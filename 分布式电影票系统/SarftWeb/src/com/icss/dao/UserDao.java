package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.entity.User;
import com.icss.mapper.IUserMapper;
import com.icss.util.Log;
@Repository
public class UserDao {
@Autowired
IUserMapper userMapper;

	public User login(String name, String pwd) throws Exception {
//		User user=null;
//		String sql="select * from tuser where name=? and pwd=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setString(1, name);
//		ps.setString(2, pwd);
//		ResultSet rs=ps.executeQuery();
//		user=new User();
//		if(rs.next()) {		
//			user.setName(name);
//			user.setPwd(pwd);
//			user.setRname(rs.getString("rname"));
//		}
//		rs.close();
//		ps.close();
//		return user;
		return userMapper.login(name, pwd);
	}

	public boolean isValidUname(String name) throws Exception {
		boolean isValid = false;		
//		String sql = "select name from tuser where name = ?";		
//		Connection conn = openCollection();
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, name);
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			isValid = true;
//			break;
//		}
//		rs.close();
//		ps.close();				
//		return isValid;
		if(userMapper.isValidUname(name)!=null) {
			isValid = true;
		}
		return isValid;
	}

	public int regist(User user) throws Exception {
//		String sql = "insert into tuser(name,pwd,rname,family,stime) values(?,?,?,?,?)";		
//		int num=0;
//		try {			
//			Connection conn = openCollection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1,user.getName());
//			ps.setString(2, user.getPwd());
//			ps.setString(3, user.getRname());
//			ps.setString(4, user.getFamily());
//			ps.setTimestamp(5, new Timestamp(user.getStime().getTime()));
//			num=ps.executeUpdate();
//			ps.close();
//		}catch (Exception e) {
//			Log.logger.error(e.getMessage(),e);
//			throw e;
//		}
//		return num;		
		return userMapper.regist(user);
	}

}
