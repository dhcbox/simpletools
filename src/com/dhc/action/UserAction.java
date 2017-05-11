package com.dhc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

/**
 * 使用步骤
 * 1、创建Servlet继承自BaseServlet
 * 2、在该Servlet中创建方法（应该与前台页面上的flag=xxx有关,方法名就应该叫xxx）
 * http://localhost:8080/firstweb/userAction?flag=login
 * <a href="userAction?flag=listUsers">查询所有</a>
 * HttpServletRequest ServletRequest
 * 3、该方法的返回值类型必须是String,两个形参必须是HttpServletRequest和HttpServletResponse，抛出的异常参照doGet或者doPost
 * 4、这个方法最后的返回值，return "f:/welcome.jsp"; 这是转发。return "r:/welcome.jsp";这是重定向。"/"注意再WebContent根目录下查找页面
 * @author dhc
 *
 */
public class UserAction extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("哎呀，好兴奋啊，进来了。。。。。");
		return "r:/welcome.jsp";
	}
}
