package com.va.reusable.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * Load the properties file specified by -Dconfig.filename. Also loads a local
 * properties file if it exists which overrides the primary properties file. If
 * the properties file is named app.properties, the local properties file should
 * be named app.local.properties.
 *
 * To use the safe. confgure the safe and use safe anchors as the value. For
 * example: config.safe=/opt/va/conf/safe.zip
 * root.user=config.safe#prod.va.root.user
 */

public class ConfigurationEx {

	private static final Logger log = Logger.getLogger(ConfigurationEx.class);
	//---------------------Code from Configuration.java ---------------------
	private final static String LOCAL_EXTENSION = "local.";
	private final static String CONFIG_FILENAME_SYSTEM_PROPERTY = "config.filename";
	private final static String SAFE_FILENAME_KEY = "config.safe";
	private final static String SAFE_VALUE_ANCHOR = SAFE_FILENAME_KEY + "#";
	private final static String SAFE_PROPERTIES_FILENAME = "safe.properties";

	//-----------------------------------------------------------------------
	private static Properties props;
	private static Properties propsLocal;
	private static Properties safe;
	private static String configFilename;

    static{
			ArchiveReader rdr = null;
			InputStream is = null;
			String configLocalFilename;

			String safeFilename;

			try {
				configFilename = System.getProperty(CONFIG_FILENAME_SYSTEM_PROPERTY);
				if (StringUtils.isBlank(configFilename)) {
					throw new IOException("-D" + CONFIG_FILENAME_SYSTEM_PROPERTY + "=... not defined");
				}

				// load properties
				props = new Properties();
				props.load(new FileInputStream(configFilename));
				log.info("Loaded props=" + configFilename);

				// load local properties if it exists
				configLocalFilename = getLocalConfigFilename(configFilename);
				if (new File(configLocalFilename).exists()) {
					propsLocal = new Properties();
					propsLocal.load(new FileInputStream(configLocalFilename));
					log.info("Loaded local=" + configLocalFilename);
				}

				// load safe properties if configured
				safeFilename = getPropertyQuiet(SAFE_FILENAME_KEY);
				if (!StringUtils.isBlank(safeFilename)) {
					String safeKey = StringUtils.trim(FileUtils.readFileToString(new File(EncodeUtil.base64Decode("L2V0Yy92YQ==")))); // purposely hardcoded
																// here
					rdr = ArchiveReader.getReader(new File(safeFilename));
					rdr.setDefaultPassword(safeKey);

					ArchiveEntry entry = null;
					while ((entry = rdr.nextEntry()) != null) {
						String filename = entry.getFilename();
						is = entry.getInputStream();
					}

					// InputStream is = extractSafe(safeFilename, safeKey);
					safe = new Properties();
					safe.load(is);
					// log.info("Loaded safe =" + safeFilename);
				}
			} catch (Exception e) {
				System.out.println("ConfigurationEx " + e.getMessage());
				log.error("ConfigurationEx " + e.getMessage(), e);
				throw new RuntimeException("ConfigurationEx " + e.getMessage(), e);
			} finally {
				try {
					if (is != null)
						is.close();
					if (rdr != null)
						rdr.close();
				} catch (Exception e1) {
					throw new RuntimeException("ConfigurationEx " + e1.getMessage(), e1);
				}
			}

	}

	public static String getProperty(String key) throws MissingResourceException {
		String value = getPropertyQuiet(key);
		
		if (value == null) {
			log.error("Found Null property :"+key);
			throw new MissingResourceException(key + " does not exist", configFilename, key);			
		}

		if(StringUtils.isEmpty(value)){
			log.warn("Warning Empty property :"+key);
		}
		return value;
	}

	public static String getPropertyQuiet(String key) {
		// Looks for the property in propsLocal first, then props.
		// Then check if this value is a value inside safe.
		String value = null;

		if (propsLocal != null) {
			value = propsLocal.getProperty(key);
		}

		if (StringUtils.isBlank(value)) {
			value = props.getProperty(key);
		}

		if (StringUtils.isNotBlank(value) && value.startsWith(SAFE_VALUE_ANCHOR)) {
			String safeKey = StringUtils.removeStart(value, SAFE_VALUE_ANCHOR);
			if (safe != null) {
				value = safe.getProperty(safeKey);
			} else {
				value = null;
			}
		}

		if (StringUtils.isBlank(value)) {
			value = null;
		}

		return value;
	}

	private static String getLocalConfigFilename(String configFilename) {
		String extension = FilenameUtils.getExtension(configFilename);
		return StringUtils.replace(configFilename, extension, LOCAL_EXTENSION + extension);
	}

	private static InputStream extractSafe(String safeFilename, String password) throws IOException, ArchiveFormatException {
		ByteArrayOutputStream os = null;

		ArchiveReader reader = null;
		try {
			reader = ArchiveReader.getReader(new File(safeFilename));

			ArchiveEntry entry = null;
			while ((entry = reader.nextEntry()) != null) {
				String filename = entry.getFilename();
				if (filename.equals(SAFE_PROPERTIES_FILENAME)) {
					entry.setPassword(password);
					InputStream is = entry.getInputStream();
					os = new ByteArrayOutputStream();
					IOUtils.copy(is, os);
					is.close();
					os.close();
					break;
				}
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}

		return new ByteArrayInputStream(os.toByteArray());
	}
}
