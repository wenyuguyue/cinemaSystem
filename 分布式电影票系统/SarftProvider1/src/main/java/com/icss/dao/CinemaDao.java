package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.icss.dto.CinemaInfoDTO;

@Repository
public class CinemaDao extends BaseDao{

	public void changeCinemaInfo(String cinema_code, int request) throws SQLException {
		String sql="update cinema set status=? where code=?";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, request);
		ps.setString(2, cinema_code);
		ps.executeUpdate();
		ps.close();
	}

	public CinemaInfoDTO getCinemaInfo(String cinema_code) throws SQLException {
		CinemaInfoDTO cinemaInfoDTO=null;
		String sql="select * from cinema where code=?";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, cinema_code);
		ResultSet rs=ps.executeQuery();	
		if(rs.next()) {
			cinemaInfoDTO=new CinemaInfoDTO();
			cinemaInfoDTO.setCinema_code(cinema_code);
			cinemaInfoDTO.setCinemas(rs.getString("cinemas"));
			cinemaInfoDTO.setContact(rs.getString("contact"));
			cinemaInfoDTO.setCorporation(rs.getString("corporation"));
			cinemaInfoDTO.setFax(rs.getString("fax"));
			cinemaInfoDTO.setName(rs.getString("name"));
			cinemaInfoDTO.setScreen_count(rs.getInt("screen_count"));
			cinemaInfoDTO.setStatus(rs.getInt("status"));
			cinemaInfoDTO.setTelephone(rs.getString("telephone"));
		}
		rs.close();
		ps.close();
		return cinemaInfoDTO;
	}

}
