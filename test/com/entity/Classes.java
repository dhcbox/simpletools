package com.entity;

/**
 * 普通的javabean
 * @author dhc
 *
 */
public class Classes {
	private String clsId;
	private String clsName;
	public String getClsId() {
		return clsId;
	}
	public void setClsId(String clsId) {
		this.clsId = clsId;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	@Override
	public String toString() {
		return "Classes [clsId=" + clsId + ", clsName=" + clsName + "]";
	}
	
	
}
