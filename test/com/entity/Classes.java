package com.entity;

public class Classes {
	private int clsId;
	private String clsName;
	public int getClsId() {
		return clsId;
	}
	public void setClsId(int clsId) {
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
