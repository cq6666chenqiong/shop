/**  
* @Project: jingjie-util
* @Title: PasswordUtil.java
* @author Chenzhi Wu : zhonghcc@gmail.com
* @Copyright: 2016 Chenzhi Wu. All rights reserved.
*/
package com.zhsj.m.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName PasswordUtil
 * @Description TODO
 * @author taoxiangshan : taoxiangshan@163.com
 * @date 2017年08月09日
 */
public class PasswordUtil {
	/**
	 * 
	 * @param input
	 * @return 返回编码后字符串
	 */
	
	public static final String DEFAULT_MONEY_MARROW = "lts123456";
	public static final String DEFAULT_SUPER_MARROW = "lts123456";
	
	//是否明文密码
	public static final boolean SHOW_MARROW = false;
	
	public static String encodePassword(String input) {  

		if ( SHOW_MARROW  ){
			return input;
		}
		else{
			String tmpStr = DigestUtils.md5Hex(input);//对密码进行第一次MD5加密
			char arr[] = tmpStr.toCharArray();//将字符串前半部分和后半部分交换，例：abcd交换后为cdba
			for(int i = 0;i<arr.length/2;i++){
				char tmp = arr[i];
				arr[i] = arr[i+arr.length/2];
				arr[i+arr.length/2] = tmp;
			}
			String str = new String(arr);//将字符数组转化为字符串
		    return DigestUtils.md5Hex(str);  //对字符串再次MD5加密并返回
		}
	}  
}
