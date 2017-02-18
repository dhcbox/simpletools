package com.commons;


import org.junit.Test;


public class StrKitTest {

	@Test
	public void testIsBlank(){
		boolean bl = StrKit.isBlank("");
		System.out.println(bl);
	}
	@Test
	public void testIsNotBlank(){
		boolean bl = StrKit.notBlank("");
		System.out.println(bl);
	}
	@Test
	public void testJoin(){
		String a = StrKit.join(new String[]{"hello","fuck"});
		System.out.println(a);
	}
	@Test
	public void testJoin2(){
		String a = StrKit.join(new String[]{"hello","fuck"},"&");
		System.out.println(a);
	}
	@Test
	public void testUuid(){
		System.out.println(StrKit.uuid());
	}
}
