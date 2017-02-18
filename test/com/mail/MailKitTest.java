package com.mail;

import javax.mail.Session;

import org.junit.Test;

public class MailKitTest {

	@Test
	public void testSend(){
		try {
			//获取会话，三个形参分别是：自己要发送邮件邮箱的SMTP服务器，邮箱的用户名，邮箱的密码
			Session session = MailKit.createSession("smtp.163.com", "m15967101311", "snm19950301");
			//构建邮件对象,参数如下：发送的邮箱地址，目标邮箱的地址，邮件的主题，邮箱的正文
			Mail mail = new Mail("m15967101311@163.com","dhcbox@163.com","情人节快乐标题3333","又是一年情人节，还是单身8888");
			//使用邮件工具类发送邮件
			MailKit.send(session, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
