package com.commons;


import org.junit.Test;


public class PropKitTest {

	@Test
	public void testUse(){
		//PropKit.use("druid.properties");
		String pwd = PropKit.get("password");
		System.out.println(pwd);
	}
}
