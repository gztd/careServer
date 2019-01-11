/**
 * 
 */
package org.r.system.cs.entity.authorization;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Casper
 *
 */
public class SysInfo {

	// 最大站点数，默认5个
	private static int MAXSESSION = 5;

	private static Map<String, Object> SESSIONPOOL = new HashMap<>();

	public static int getPoolSize() {
		return SESSIONPOOL.size();
	}

	public static boolean isStillAviable() {
		return SESSIONPOOL.size() < MAXSESSION;
	}

	public static void addSession(String key, Object value) {
		if (isStillAviable())
			SESSIONPOOL.put(key, value);
	}

	public static void removeSession(String key) {
		SESSIONPOOL.remove(key);
	}

	public static void clear() {
		SESSIONPOOL.clear();
	}
	
	public static boolean contain(String key) {
		return SESSIONPOOL.containsKey(key);
	}
	
	public static Object getValue(String key) {
		return SESSIONPOOL.get(key);
	}
}
