package com.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid数据库连接池管理类
 * @author dhc
 * @version V1.0
 */
public class ConnectionPoolManager {
	
	private static DruidDataSource dds = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static{
		try {
			InputStream is = ConnectionPoolManager.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties properties = new Properties();
			properties.load(is);
			dds = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static DataSource getDataSource(){
		return dds;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn != null) return conn;
		return dds.getConnection();
	}
	
	public static void beginTransaction() throws SQLException {
		Connection conn = tl.get();
		if(conn != null) throw new SQLException("已经开启了事务!");
		conn = dds.getConnection();
		conn.setAutoCommit(false);
		tl.set(conn);
	}
	
	public static void commitTransaction() throws SQLException {
		Connection conn = tl.get();
		if(conn == null) throw new SQLException("没有事务不能提交！");
		conn.commit();
		conn.close();
		conn = null;
		tl.remove();
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection conn = tl.get();
		if(conn == null) throw new SQLException("没有事务不能回滚！");
		conn.rollback();
		conn.close();
		conn = null;
		tl.remove();
	}
	
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();
		if(connection != con) {
			if(connection != null &&!connection.isClosed()) {
				connection.close();
			}
		}
	}
	

	public static void main(String[] args) throws SQLException {
		System.out.println(ConnectionPoolManager.getConnection());
	}
}
