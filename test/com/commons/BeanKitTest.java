package com.commons;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.entity.Classes;

public class BeanKitTest {

	@Test
	public void testToBean1(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("clsId", "0001");
		map.put("clsName", "杭州java118期");
		
		Classes cls = BeanKit.toBean(map, Classes.class);
		System.out.println(cls);
	}
	
	@Test
	public void testToBean2(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("clsId", new String[]{"0001"});
		map.put("clsName", new String[]{"杭州java118期"});
		
		Classes cls = BeanKit.toBean(map, Classes.class);
		System.out.println(cls);
	}
}
