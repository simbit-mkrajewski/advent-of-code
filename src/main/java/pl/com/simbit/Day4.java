package pl.com.simbit;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 implements Day {

	public String getAnswer1() {

		String input = "iwrupvqb";
		int i = 0;
		MessageDigest instance;
		try {
			instance = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			return "ERROR";
		}
		
		while (true) {
			String toEnc = input + "" + i++;
			instance.update(toEnc.getBytes());
			byte[] digest = instance.digest();
			String md5 = new BigInteger(1, digest).toString(16);
			if (md5.length() == 27) {
				return (i - 1) + "";
			}
		}
	}

	public String getAnswer2() {
		String input = "iwrupvqb";
		int i = 0;
		MessageDigest instance;
		try {
			instance = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			return "ERROR";
		}
		
		while (true) {
			String toEnc = input + "" + i++;
			instance.update(toEnc.getBytes());
			byte[] digest = instance.digest();
			String md5 = new BigInteger(1, digest).toString(16);
			if (md5.length() == 26) {
				return (i - 1) + "";
			}
		}
	}

}
