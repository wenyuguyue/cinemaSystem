package com.icss.dao;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.icss.util.Log;

public class BaseDao extends JdbcDaoSupport{
	@Autowired
	public void prepareDataSource(org.springframework.jdbc.datasource.DriverManagerDataSource dataSource) {
		super.setDataSource(dataSource);
	}	
	
	public Connection openCollection() {
		return this.getConnection();
	}
	
	public void closeCollection(Connection conn) {
		boolean isTransaction=DataSourceUtils.isConnectionTransactional(conn, this.getDataSource());
		if(isTransaction) {
			Log.logger.info(Thread.currentThread().getId() + "事务环境，connection等待重用...");
		}else {
			Log.logger.info(Thread.currentThread().getId() + "非事务环境,自动关闭数据库连接...");
			try {
				conn.close();	
			} catch (Exception e) {
			}			
		}	
	}
}
