package com.winter.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class RSA512 {
	
	private final static String KEY_ALGORITHM = "RSA";
	
	public static KeyPair generateKeyPair() {
		
		KeyPair keyPair = null;
		
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
			generator.initialize(512, new SecureRandom());
			keyPair = generator.generateKeyPair(); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return keyPair;
	}
	
	public static RSAPublicKey decodePublicKey(String address) {
		
		byte[] encoded = BaseConverter.stringHexToDec(address);
		X509EncodedKeySpec encodedPublicKeySpec = new X509EncodedKeySpec(encoded);
		RSAPublicKey publicKey = null;
		
		try {
			KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
			publicKey = (RSAPublicKey) factory.generatePublic(encodedPublicKeySpec);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return publicKey;
	}

}