//package com.icss.dao;
//
//import java.io.InputStream;
//import java.sql.Connection;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//
//import com.icss.util.Log;
//
//public class BaseDao extends JdbcDaoSupport{
//	private static SqlSessionFactory sqlSessionFactory;//工厂单例
//	static {
//		String resource = "mybatis.xml";
//		try {
//			InputStream inputStream=Resources.getResourceAsStream(resource);
//			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (Exception e) {
//			Log.logger.error(e.getMessage(),e);
//		}
//	}
//	
//	public SqlSession openSession() {
//		return sqlSessionFactory.openSession(true);//自动提交autoCommit=true
//	}
//	
//	public void releaseSession(SqlSession session) {
//		session.close();
//	}
//	
//	@Autowired
//	public void prepareDataSource(org.springframework.jdbc.datasource.DriverManagerDataSource dataSource) {
//		super.setDataSource(dataSource);
//	}	
//	
//	public Connection openCollection() {
//		return this.getConnection();
//	}
//	
//	public void closeCollection(Connection conn) {
//		boolean isTransaction=DataSourceUtils.isConnectionTransactional(conn, this.getDataSource());
//		if(isTransaction) {
//			Log.logger.info(Thread.currentThread().getId() + "浜嬪姟鐜锛宑onnection绛夊緟閲嶇敤...");
//		}else {
//			Log.logger.info(Thread.currentThread().getId() + "闈炰簨鍔＄幆澧�,鑷姩鍏抽棴鏁版嵁搴撹繛鎺�...");
//			try {
//				conn.close();	
//			} catch (Exception e) {
//			}			
//		}	
//	}
//}
