package pl.com.simbit;

import org.apache.commons.lang.StringUtils;

public class StringToInt {

	public static final Integer get(String s) {
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			return Integer.parseInt(s.trim());
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public static final Long getL(String s) {
		try {
			return Long.parseLong(s.trim());
		} catch (NumberFormatException ex) {
			return null;
		}
	}

}
