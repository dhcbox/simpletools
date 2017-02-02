package com.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.connection.ConnectionPoolManager;

/**
 * apache-dbutils扩展类
 * @author dhc
 * @version V1.0
 */
public class TxQueryRunner extends QueryRunner {

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection conn = ConnectionPoolManager.getConnection();
		T result = super.query(conn, sql, rsh, params);
		ConnectionPoolManager.releaseConnection(conn);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection conn = ConnectionPoolManager.getConnection();
		T result = super.query(conn, sql, rsh);
		ConnectionPoolManager.releaseConnection(conn);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection conn = ConnectionPoolManager.getConnection();
		int result = super.update(conn, sql, params);
		ConnectionPoolManager.releaseConnection(conn);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection conn = ConnectionPoolManager.getConnection();
		int result = super.update(conn, sql);
		ConnectionPoolManager.releaseConnection(conn);
		return result;
	}

}
