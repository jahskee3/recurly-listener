package com.va.session;

import org.apache.log4j.Logger;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.va.core.Configuration;

public class BizManagerUtil {
	private static final Logger logger = Logger.getLogger(BizManagerUtil.class);

	public static BizManager createBizManager() throws NamingException, RemoteException, CreateException {
		return createBizManager(Configuration.JNDI_SERVER);
	}

	public static BizManager createBizManager(String server) throws NamingException, RemoteException, CreateException {
		logger.debug("BizManagerUtil.createBizManager(" + server + ")");

		Properties h = new Properties();
		h.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		h.put("java.naming.provider.url", server);
		h.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

		Context ctx = new InitialContext(h);
		BizManagerHome bizHome = (BizManagerHome) PortableRemoteObject.narrow(ctx.lookup("BizManager"),
				BizManagerHome.class);
		return bizHome.create();
	}
}
