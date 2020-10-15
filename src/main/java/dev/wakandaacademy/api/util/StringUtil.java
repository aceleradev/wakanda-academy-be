package dev.wakandaacademy.api.util;

public class StringUtil {
	
	public static boolean isBlank(String value) {
		return value==null || value.trim().isEmpty();
	}
	
}

