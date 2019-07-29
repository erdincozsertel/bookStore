package com.erdincozsertel.bookstore.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class EncodingPasswordUtil {

	private EncodingPasswordUtil() {
	}

	public static String hashPassword(String password, byte[] salt) {
		try {
//			System.out.println(password+" "+ase64.getEncoder().encodeToString(salt));
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
			SecretKeyFactory factory;
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			password = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			password = null;
			e.printStackTrace();
		}
		return password;
	}
}
