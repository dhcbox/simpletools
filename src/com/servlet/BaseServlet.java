package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.StrKit;

/**
 * 基础Servlet类
 * @author dhc
 * @version V1.0
 */
@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {
	
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
	
	protected String getUrl(HttpServletRequest request,String flagString) {
		String str = "";
		try {
			String contextPath = request.getContextPath();//项目名http://localhost:8080/firstjdbc
			String servletPath = request.getServletPath();//servlet名称：/stuAction
			String queryString = request.getQueryString();//参数：？后面的所有内容
			if(queryString == null){
				queryString = flagString;
			}
			if(queryString.contains("&pageNumber=")){
				queryString = queryString.substring(0, queryString.lastIndexOf("&pageNumber="));
			}
			str = contextPath + servletPath + "?" + queryString;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return str;
	}
	
	@Override
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		/**
		 * 1. 获取flag参数，它是用户想调用的方法
		 */
		String methodName = request.getParameter("flag");
		Method method = null;
		/**
		 * 2. 通过方法名称获取Method对象
		 */
		try {
			method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("您要调用的方法：" + methodName + "不存在！", e);
		}

		/**
		 * 3. 通过method对象来调用它
		 */
		try {
			String result = (String) method.invoke(this, request, response);
			/**
			 * 请求处理方法返回值必须为字符串，当不为空时
			 */
			if (StrKit.notBlank(result)) {
				/**
				 * 获取第一个冒号的位置
				 */
				int index = result.indexOf(":");
				/**
				 * 如果没有冒号，使用转发
				 */
				if (index == -1) {
					request.getRequestDispatcher(result).forward(request, response);
				} else {
					/**
					 * 分割出前缀
					 */
					String start = result.substring(0, index);
					/**
					 * 分割出路径
					 */
					String path = result.substring(index + 1);
					if (start.equals("f")) {
						/**
						 * 前缀为f表示转发
						 */
						request.getRequestDispatcher(path).forward(request, response);
					} else if (start.equals("r")) {
						/**
						 * 前缀为r表示重定向
						 */
						response.sendRedirect(request.getContextPath() + path);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
