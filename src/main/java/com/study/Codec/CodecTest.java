package com.study.Codec;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

public class CodecTest {

	// Base64编解码
	private static String encodeTest(String str) {
		Base64 base64 = new Base64();
		try {
			str = base64.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Base64 编码后：" + str);
		return str;
	}
	
	private static void decodeTest(String str){
		Base64 base64 = new Base64();  
        //str = Arrays.toString(Base64.decodeBase64(str));  
        str = new String(Base64.decodeBase64(str));  
        System.out.println("Base64 解码后："+str); 
	}
	
	public static void main(String[] args) {
		String test = "kgy";
		encodeTest(test);
		decodeTest(encodeTest(test));
	}
}
