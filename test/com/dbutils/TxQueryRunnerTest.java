package com.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.connection.ConnectionPoolManager;
import com.entity.UserInfo;

public class TxQueryRunnerTest {
	
	//希望把从数据库查询出来的多条数据转换List<UserInfo>
	//List list = JdbcUtils.query("select * from userInfo");
	//List<UserInfo> userList = new ArrayList<UserInfo>();
	//for(Object ob : list){userList.add(JSON.parseObject(JSON.toJsonString(ob),UserInfo.class));}
	@Test
	public void testQueryBeanList(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			List<UserInfo> userList = qr.query("select * from userInfo", new BeanListHandler<>(UserInfo.class));
			System.out.println(userList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//希望把从数据库查询出来的多条数据转换List<Map<>>
	@Test
	public void testQueryMapList(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			List<Map<String,Object>> userList = qr.query("select * from userInfo", new MapListHandler());
			System.out.println(userList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryBeanList2(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			UserInfo user = qr.query("select * from userInfo where userId=? ", new BeanHandler<>(UserInfo.class),new Object[]{6});
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryCount(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			//不要问为什么，直接强转成Number类型即可，适合一行一类的结果转换数字类型
			Number num = (Number)qr.query("select count(*) from userInfo ", new ScalarHandler<>());
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//query的总结：4个重要的内容：BeanListHandler，MapListHandler,BeanHandler,ScalarHandler
	
	
	@Test
	public void testUpdateTx(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			//1 开始事务
			ConnectionPoolManager.beginTransaction();
			int i = qr.update("update userInfo set userName=? where userId=? ", new Object[]{"jxf@qq.com",6});
			System.out.println("+++++++++++" + i);
			//2 提交事务
			ConnectionPoolManager.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			//3 出现任何异常直接回滚事务
			try {
				ConnectionPoolManager.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void testUpdateTx2(){
		try {
			TxQueryRunner qr = new TxQueryRunner();
			//1 开始事务
			ConnectionPoolManager.beginTransaction();
			qr.update("update userInfo set userName=? where userId=? ", new Object[]{"kkkkkk@qq.com",6});
			Integer.parseInt("sss");//发生运行时异常
			qr.update("update userInfo set userPwd=? where userId=? ", new Object[]{"789",6});
			//2 提交事务
			ConnectionPoolManager.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			//3 出现任何异常直接回滚事务
			try {
				ConnectionPoolManager.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	
	
}
