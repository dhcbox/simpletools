package com.servlet;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.commons.StrKit;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Struts2基础Action类
 * @author dhc
 * @version V1.0
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = 7756240104405310529L;

	protected T model;

	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {
		return model;
	}
	
	protected HttpServletRequest getRequest(){
		HttpServletRequest request = null;
		try {
			request = ServletActionContext.getRequest();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return request;
	}
	
	protected HttpServletResponse getResponse(){
		HttpServletResponse response = null;
		try {
			response = ServletActionContext.getResponse();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return response;
	}
	
	protected HttpSession getSession(){
		HttpSession session = null;
		try {
			session = this.getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return session;
	}
	
	protected int getPageNumber(HttpServletRequest request) {
		int i = 0;
		try {
			//当前台页面没有传递pageNumber,默认为1
			i = 1;
			String pageNumberStr = request.getParameter("pageNumber");
			if(StrKit.notBlank(pageNumberStr)){
				i = Integer.parseInt(pageNumberStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return i;
	}
	
	protected String getUrl(HttpServletRequest request) {
		String str = "";
		try {
			String contextPath = request.getContextPath();//项目名http://localhost:8080/firstjdbc
			String servletPath = request.getServletPath();//servlet名称：/stuAction
			String queryString = request.getQueryString();//?后面的参数所有内容
			if(queryString == null){
				str = contextPath + servletPath;
			}else{
				if(queryString.contains("&pageNumber=")){
					queryString = queryString.substring(0, queryString.lastIndexOf("&pageNumber="));
				}
				str = contextPath + servletPath + "?" + queryString;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return str;
	}

}
