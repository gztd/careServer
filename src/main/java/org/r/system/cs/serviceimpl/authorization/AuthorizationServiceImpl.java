/**
 * 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.r.system.cs.service.authorization.AuthorizationService;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class AuthorizationServiceImpl implements AuthorizationService {

	/* (non-Javadoc)
	 * @see org.r.system.cs.service.authorization.AuthorizationService#verifyPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verifyPassword(String password, String principle) {
		
		if(password.equals(principle))return true;
		return false;
	}

	@Override
	public String createToken(String username, String project) {
		String token = username+System.currentTimeMillis()+project+"casper";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(token.getBytes());
			Encoder encoder = Base64.getEncoder();
			token = encoder.encodeToString(md5);
		} catch (NoSuchAlgorithmException e) {
			token = null;
		} catch (Exception e) {
			token = null;
		}
		return token;
	}

}
