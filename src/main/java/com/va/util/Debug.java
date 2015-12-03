package com.va.util;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.StringUtils;

public class Debug {
	public static void objectDump(Object object, Writer writer, String prefix) {
		try {
			Class clazz = object.getClass();
			writer.write("\n" + prefix + clazz.getName() + "\n");
			Field[] fields = clazz.getDeclaredFields();

			// get largest field length
			int fieldLen = 0;
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (!Modifier.isStatic(field.getModifiers())) {
					String fieldName = field.getName();
					if (fieldName.length() > fieldLen) {
						fieldLen = fieldName.length();
					}
				}
			}

			// print
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (!Modifier.isStatic(field.getModifiers())) {
					writer.write(prefix + StringUtils.rightPad(field.getName(), fieldLen) + " = " + field.get(object)
							+ "\n");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
