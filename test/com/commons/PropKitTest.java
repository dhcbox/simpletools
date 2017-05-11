package com.commons;


import org.junit.Test;


public class PropKitTest {

	@Test
	public void testUse(){
		PropKit.use("druid.properties");
		String pwd = PropKit.get("driverClassName");
		System.out.println(pwd);
	}
	
	@Test
	public void testStrKit(){
		System.out.println(StrKit.isBlank(""));
		System.out.println(StrKit.uuid());
		System.out.println(HashKit.md5("123456"));
	}
}
