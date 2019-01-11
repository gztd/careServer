/**
 * 
 */
package org.r.system.cs.listener.authorization;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.r.system.cs.entity.authorization.SysInfo;

/**
 * @author Casper
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		SysInfo.removeSession((String) se.getSession().getAttribute("username"));
	}

}
