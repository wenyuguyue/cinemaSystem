package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icss.dto.ScreenDTO;

@Repository
public class ScreenDao extends BaseDao{

	public List<ScreenDTO> getScreenPackageList(String screen_code) throws SQLException {
		List<ScreenDTO> slist=null;
		String sql="select * from tmoviehall where code=?";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, screen_code);
		ResultSet rs=ps.executeQuery();	
		slist=new ArrayList<>();
		if(rs.next()) {
			ScreenDTO screenDTO=new ScreenDTO();
			screenDTO.setCode(rs.getString("code"));
			screenDTO.setName(rs.getString("name"));
			screenDTO.setSeat_count(rs.getInt("seat_count"));
			slist.add(screenDTO);
		}
		rs.close();
		ps.close();
		return slist;
	}

	public int gettotalNum() throws SQLException {
		int num=0;
		String sql="select count(*) from tmoviehall";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			num=rs.getInt(1);
		}
		rs.close();
		ps.close();
		return num;
	}

	public int getcount(String screen_code) throws SQLException {
		int num=0;
		String sql="select count(*) from tmoviehall where code=? ";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, screen_code);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			num=rs.getInt(1);
		}
		rs.close();
		ps.close();
		return num;
	}

}
