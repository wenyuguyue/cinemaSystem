package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.entity.Movie;
import com.icss.mapper.IMovieMapper;

@Repository
public class MovieDao  {
@Autowired
IMovieMapper movieMapper;
	public List<Movie> queryMovie() throws Exception {
//		List<Movie> clist = null;
//		String sql = "select * from tmovie";
//		Connection conn = openCollection();
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ResultSet rs = ps.executeQuery();
//		clist = new ArrayList<>();
//		while (rs.next()) {
//			Movie movie = new Movie();
//			movie.setCode(rs.getInt("code"));
//			movie.setName(rs.getString("name"));
//			movie.setDuration(rs.getInt("duration"));
//			movie.setArea(rs.getString("area"));
//			movie.setType(rs.getString("type"));
//			movie.setDirector(rs.getString("director"));
//			movie.setScore(rs.getBigDecimal("score"));
//			movie.setStatus(rs.getInt("status"));
//			movie.setIntroduction(rs.getString("introduction"));
//			movie.setCover(rs.getString("cover"));
//			movie.setPublish_date(rs.getTimestamp("publish_date"));
//			movie.setEddate(rs.getTimestamp("eddate"));
//			movie.setMinsale(rs.getBigDecimal("minsale"));
//			movie.setVersion(rs.getString("version"));
//			movie.setPublisher(rs.getString("publisher"));
//			movie.setProducer(rs.getString("producer"));
//			movie.setCast(rs.getString("cast"));
//			clist.add(movie);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		return movieMapper.queryMovie();
	}

	public void deleteMovie(String code) throws Exception {
//		String sql="delete from tmovie where code=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, code);
//		ps.executeUpdate();	
//		ps.close();
		movieMapper.deleteMovie(code);
	}

	public void addMovie(Movie movie) throws Exception {
//		String sql="insert into tmovie(code,name,duration,area,type,director,status,publish_date,publisher,producer,cast,version,introduction,cover) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, movie.getCode());
//		ps.setObject(2, movie.getName());
//		ps.setObject(3, movie.getDuration());
//		ps.setObject(4, movie.getArea());
//		ps.setObject(5, movie.getType());
//		ps.setObject(6, movie.getDirector());
//		ps.setObject(7, movie.getStatus());
//		ps.setObject(8, movie.getPublish_date());
//		ps.setObject(9, movie.getPublisher());
//		ps.setObject(10, movie.getProducer());
//		ps.setObject(11, movie.getCast());
//		ps.setObject(12, movie.getVersion());
//		ps.setObject(13, movie.getIntroduction());
//		ps.setObject(14, movie.getCover());
//		ps.executeUpdate();	
//		ps.close();
		movieMapper.addMovie(movie);
	}

	public void editMovie(Movie movie) throws Exception {
//		String sql="insert into tmovie(code,name,duration,area,type,director,status,publish_date,publisher,producer,cast,version,introduction,cover) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, movie.getCode());
//		ps.setObject(2, movie.getName());
//		ps.setObject(3, movie.getDuration());
//		ps.setObject(4, movie.getArea());
//		ps.setObject(5, movie.getType());
//		ps.setObject(6, movie.getDirector());
//		ps.setObject(7, movie.getStatus());
//		ps.setObject(8, movie.getPublish_date());
//		ps.setObject(9, movie.getPublisher());
//		ps.setObject(10, movie.getProducer());
//		ps.setObject(11, movie.getCast());
//		ps.setObject(12, movie.getVersion());
//		ps.setObject(13, movie.getIntroduction());
//		ps.setObject(14, movie.getCover());
//		ps.executeUpdate();	
//		ps.close();
		movieMapper.editMovie(movie);
	}

}
