/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.report 
 * @author: Casper   
 * @date: 2018年11月18日 下午3:46:27 
 */
package org.r.system.cs.exception.report;

/**
 * @author Casper
 *
 */
public class FileExportException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2159651073608393703L;

	public FileExportException() {
		super();
	}

	public FileExportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileExportException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileExportException(String message) {
		super(message);
	}

	public FileExportException(Throwable cause) {
		super(cause);
	}

}
