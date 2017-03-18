package com.dbutils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;


/**
 * dbutils-spring整合模板
 * @author dhc
 * @version V1.0
 */
public class QueryRunnerTemplate{
	
	private DataSource dataSource;
	private QueryRunner qr;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		qr = new QueryRunner(dataSource);
		T result = qr.query(sql, rsh, params);
		return result;
	}

	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		qr = new QueryRunner(dataSource);
		T result = qr.query(sql, rsh);
		return result;
	}

	public int update(String sql, Object... params) throws SQLException {
		qr = new QueryRunner(dataSource);
		int result = qr.update(sql, params);
		return result;
	}

	public int update(String sql) throws SQLException {
		qr = new QueryRunner(dataSource);
		int result = qr.update(sql);
		return result;
	}
	
}
