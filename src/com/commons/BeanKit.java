package com.commons;

import com.alibaba.fastjson.JSON;

/**
 * Map转Bean的工具类
 * @author dhc
 * @version V1.0
 */
public class BeanKit {
	
	public static <T> T toBean(Object map, Class<T> clazz){
		return JSON.parseObject(JSON.toJSONString(map), clazz);
	}
	
}
