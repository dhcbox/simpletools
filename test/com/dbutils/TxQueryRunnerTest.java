package com.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.entity.Classes;

public class TxQueryRunnerTest {

	@Test
	public void testQuery1(){
		
		try {
			QueryRunner qr = new TxQueryRunner();
			List<Classes> list = qr.query("select * from classes", new BeanListHandler<>(Classes.class));
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery2(){
		try {
			QueryRunner qr = new TxQueryRunner();
			List<Map<String, Object>> list = qr.query("select * from classes ", new MapListHandler());
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
