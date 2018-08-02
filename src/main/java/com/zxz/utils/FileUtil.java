package com.zxz.utils;

import java.io.File;

/**
 * @author zhaoxuezhong FileUtil
 */
public class FileUtil {
	private static String []suffixs={"jpg","jpeg","png","pneg"};

	// 获取指定文件的扩展名
	public static String getFileExtensionByPath(String srcPath) {
		File file = new File(srcPath);
		if (file.isFile()) {
			String name = file.getName();
			return getFileExtensionByName(name);
		}
		return "";
	}
	
	// 获取指定文件的扩展名
	public static String getFileExtensionByName(String name) {
		String[] exName = name.split("\\.");
		return exName.length>1?exName[exName.length - 1]:"";
	}
	
	public static boolean isSuffixs(String suffix){
		for (String suf : suffixs) {
			if(suf.equalsIgnoreCase(suffix)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean deleteFile(String path){
		File file = new File(path);
		if (file.exists()) {
			return file.delete();
		}
		return false;
	}
	
}
