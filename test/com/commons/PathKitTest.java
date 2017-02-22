package com.commons;

import org.junit.Test;

public class PathKitTest {

	@Test
	public void test1(){
		String aa = PathKit.getWebRootPath();
		System.out.println(aa);
	}
	
	@Test
	public void test2(){
		String aa = PathKit.getRootClassPath();
		System.out.println(aa);
	}
	
	@Test
	public void test3(){
		String aa = PathKit.getPath(PathKit.class);
		System.out.println(aa);
	}
	
}
