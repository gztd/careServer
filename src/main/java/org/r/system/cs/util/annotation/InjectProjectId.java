/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.annotation.business 
 * @author: Casper   
 * @date: 2018年11月14日 上午1:07:16 
 */
package org.r.system.cs.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Casper
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InjectProjectId {

	public Class<?> value();
	
	public String propertyName();
	
	
}
