package com.sgm.util;

public class CommonUtil {
	
	public static boolean isEmpty(String str) {
		if (null == str)
			return true;
		if ("".equals(str.replaceAll("　"," ").trim()))
			return true;
		return false;
	}

}
