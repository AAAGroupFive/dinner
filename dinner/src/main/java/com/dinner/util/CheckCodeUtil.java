package com.dinner.util;

import java.security.MessageDigest;
import java.util.Arrays;
/**
 * @className:CheckCodeUtil
 * @discription:
 * @author:zz
 * @crateTime:2019-01-13 15:21
 */
public class CheckCodeUtil {
	private static final String token = "myToken";
	
	public static boolean checkSignature(String signature,String timestamp,String nonce) {
		//1、将token、timestamp、nonce三个参数进行字典序排序 
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);
		//2、将三个参数字符串拼接成一个字符串
		StringBuffer sb = new StringBuffer();
		for (String string : arr) {
			sb.append(string);
		}
		//3、将字符串进行sha1加密 
		String temp = getSha1(sb.toString());
		//4、开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return temp.equals(signature);
	}
	
	/**
	 * sha1加密
	 * @Title: getSha1
	 * @Description: TODO
	 * @param: @param str
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getSha1(String str){
	   	 if (str==null || str.length() == 0) {
				return null;
			}
	   	 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','i','t'};
	   	 try {
				MessageDigest mdTemp =MessageDigest.getInstance("SHA1");
				mdTemp.update(str.getBytes("UTF-8"));
				byte[] md = mdTemp.digest();
				int j =md.length;
				char buf[]=new char[j*2];
				int k=0;
				for(int i=0;i<j;i++){
					byte byte0=md[i];
					buf[k++]=hexDigits[byte0>>>4&0xf];
					buf[k++]=hexDigits[byte0 & 0xf];
				}
				return new String(buf);
 
			} catch (Exception e) {
				return null;
			}
 
	    }
}
