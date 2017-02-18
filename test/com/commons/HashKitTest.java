package com.commons;


import org.junit.Test;


public class HashKitTest {

	@Test
	public void testMd5(){
		String userPwd = "12345698765dhc90";
		String userPwdMd5 = HashKit.md5(userPwd);
		System.out.println(userPwdMd5);
	}
}
