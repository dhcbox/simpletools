package com.commons;

import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.alibaba.fastjson.JSON;

/**
 * Map转Bean的工具类
 * @author dhc
 * @version V1.5
 */
public class BeanKit {
	
	public static <T> T toBean(Object map, Class<T> clazz){
		return JSON.parseObject(JSON.toJSONString(map), clazz);
	}
	
	public static <T> T toBean(Map<String,String[]> map, Class<T> clazz){
		try {
			T bn = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), Date.class);
			BeanUtils.populate(bn, map);
			return bn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
