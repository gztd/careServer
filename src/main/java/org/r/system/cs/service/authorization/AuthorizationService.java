/**
 * 
 */
package org.r.system.cs.service.authorization;
/**
 * @author Casper
 *
 */
public interface AuthorizationService {

	/**
	 * 验证密码是否正确
	 * 
	 * @param password
	 * @param principle
	 * @return 正确返回true，否则返回false
	 */
	public boolean verifyPassword(String password, String principle);

	/**
	 * 参数一个token
	 * 
	 * @param username
	 * @param project
	 * @return 成功返回token
	 */
	public String createToken(String username, String project);

}
