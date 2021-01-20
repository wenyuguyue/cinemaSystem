package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icss.dto.FilmDTO;
@Repository
public class FilmDao extends BaseDao{

	public int gettotalNum() throws SQLException {
		int num=0;
		String sql="select count(*) from tmovie";
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

	public int getcount(Date start_date, Date end_date) throws SQLException {
		int num=0;
		String sql="select count(*) from tmovie where publish_date between ? and ?";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setTimestamp(1, new Timestamp(start_date.getTime()));
		ps.setTimestamp(2, new Timestamp(end_date.getTime()));
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			num=rs.getInt(1);
		}
		rs.close();
		ps.close();
		return num;
	}

	public List<FilmDTO> getFilmsPackage(Date start_date, Date end_date) throws SQLException {
		List<FilmDTO> flist=null;
		String sql="select * from tmovie where publish_date between ? and ?";
		Connection conn=openCollection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setTimestamp(1, new Timestamp(start_date.getTime()));
		ps.setTimestamp(2, new Timestamp(end_date.getTime()));
		ResultSet rs=ps.executeQuery();
		flist=new ArrayList<>();
		while(rs.next()) {
			FilmDTO film=new FilmDTO();
			film.setCode(rs.getString("code"));
			film.setName(rs.getString("name"));
			film.setVersion(rs.getString("version"));
			film.setDuration(rs.getInt("duration"));
			film.setPublish_date(rs.getTimestamp("publish_date"));
			film.setProducer(rs.getString("producer"));
			film.setDirector(rs.getString("director"));
			film.setCast(rs.getString("cast"));
			film.setIntroduction(rs.getString("introduction"));
			flist.add(film);
		}
		rs.close();
		ps.close();
		return flist;
	}
}
