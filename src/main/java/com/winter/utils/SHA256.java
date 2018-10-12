package com.winter.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <b> References </b>
 * <ul>
 * <li> <a href="https://gist.github.com/qpark99/7652032"> GitHub Gist qpark99/Digest.java </a> </li>
 * </ul>
 * Verified correct using <a href="http://www.xorbin.com/tools/sha256-hash-calculator"> XORBin SHA-256 hash calculator </a>
 */
public class SHA256 {
	
	private final static String HASH_ALGORITHM = "SHA-256";
	private MessageDigest md;
	
	public SHA256() {
		try {
			md = MessageDigest.getInstance(HASH_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Hashes a given string using SHA-256 algorithm.  
	 * <p> First, the input string is decoded using UTF-8 to an array of bytes;   
	 * each byte is an integer in base 10.  Next, each byte is hashed and the 
	 * result is also in base 10.  Finally, the result is converted into base 16. </p>
	 * 
	 * @param string Input string
	 * @return String of 64 hex digits that represent the hash of s
	 */
	public String hashString(String string) {
		byte[] byteString = string.getBytes(Charset.forName("UTF-8"));
		return hashBytes(byteString);
	}
	
	/**
	 * Same as hashString but input type is an array of bytes.
	 * @param bytes Input array of bytes
	 * @return String of 64 hex digits that represent the hash of bytes
	 */
	public String hashBytes(byte[] bytes) {
		byte[] bytesDecimal = md.digest(bytes);
		return BaseConverter.bytesDecToHex(bytesDecimal);	
	}

}
