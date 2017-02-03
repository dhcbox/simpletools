package com.mail;

import javax.mail.Session;

import org.junit.Test;

public class MailKitTest {

	@Test
	public void testSend(){
		try {
			Session session = MailKit.createSession("smtp.163.com", "dhc", "123123");
			Mail mail = new Mail("dhc@163.com","dhc@163.com","新年快乐标题","新年快乐正文");
			MailKit.send(session, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
