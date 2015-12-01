package com.va.session;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * <p>
 * Interface for EJBHome instances for a <tt>BizManager</tt> implementation.
 * </p>
 * 
 * @author unknown
 * @author alan
 * 
 * @version $Id: BizManagerHome.java,v 1.3 2007/07/02 21:46:09 bdavid Exp $
 * 
 */
public interface BizManagerHome extends EJBHome {

	/**
	 * <p>
	 * Create a <tt>BizManager</tt> instance from the EJB Server.
	 * </p>
	 * 
	 * @return a instance implementing the BizManager interface.
	 * @throws CreateException
	 *             if a BizManager could not be created.
	 * @throws RemoteException
	 *             if there was a problem connecting to the EJB server.
	 */
	public abstract BizManager create() throws CreateException, RemoteException;
}
