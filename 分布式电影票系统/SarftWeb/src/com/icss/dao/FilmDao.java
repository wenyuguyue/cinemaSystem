package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.entity.FilmPlan;
import com.icss.entity.Office;
import com.icss.mapper.IFilmMapper;
@Repository
public class FilmDao{
@Autowired
IFilmMapper filmMapper;
	public List<FilmPlan> queryFilm(String selectfp) throws Exception {
//		List<FilmPlan> clist=null;
//		String sql;
//		if(selectfp.equals("0")) {
//			sql="select fp.*,m.name,m.cover from tfilmplan fp left join tmovie m on fp.film_code=m.code where valid=0";
//		}else if(selectfp.equals("1")) {
//			sql="select fp.*,m.name,m.cover from tfilmplan fp left join tmovie m on fp.film_code=m.code where valid=1 and session_datetime >= now()";
//		}else {
//			sql="select fp.*,m.name,m.cover from tfilmplan fp left join tmovie m on fp.film_code=m.code where valid=1 and session_datetime < now()";
//		}
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		clist=new ArrayList<>();
//		while(rs.next()) {	
//			FilmPlan filmPlan=new FilmPlan();
//			filmPlan.setFpid(rs.getInt("fpid"));
//			filmPlan.setBusiness_date(rs.getDate("business_date"));
//			filmPlan.setFilm_code(rs.getString("film_code"));
//			filmPlan.setFilm_cover(rs.getBytes("m.cover"));
//			filmPlan.setFilm_name(rs.getString("m.name"));
//			filmPlan.setLowest_price(rs.getBigDecimal("lowest_price"));
//			filmPlan.setPrice(rs.getBigDecimal("price"));
//			filmPlan.setScreen_code(rs.getString("screen_code"));
//			filmPlan.setSeat_by_number(rs.getInt("seat_by_number"));
//			filmPlan.setSession_code(rs.getString("session_code"));
//			filmPlan.setSession_datetime(rs.getTimestamp("session_datetime"));
//			filmPlan.setValid(rs.getInt("valid"));
//			clist.add(filmPlan);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		if(selectfp.equals("0")) {
			return filmMapper.queryFilm1();
		}else if(selectfp.equals("1")) {
			return filmMapper.queryFilm2();
		}else {
			return filmMapper.queryFilm3();
		}
	}

	public void editFilmPlan(String fpid, String field, String value) throws Exception {
//		String sql="update tfilmplan set "+field+"=? where fpid=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, value);
//		ps.setString(2, fpid);
//		ps.executeUpdate();	
//		ps.close();
		filmMapper.editFilmPlan(fpid, field, value);
	}

	public void deleteFilmPlan(String fpid) throws Exception {
//		String sql="delete from tfilmplan where fpid=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, fpid);
//		ps.executeUpdate();	
//		ps.close();
		filmMapper.deleteFilmPlan(fpid);
	}

	
	public List<Office> queryOffice() throws Exception {
//		List<Office> clist=null;
//		String sql="select m.*,count(*) as totalnum,count(*)*s.price as totalmoney from tsale s left join tmovie m on s.film_code=m.code group by m.code";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		clist=new ArrayList<>();
//		while(rs.next()) {	
//			Office office=new Office();
//			office.setCode(rs.getInt("code"));
//			office.setArea(rs.getString("area"));
//			office.setCover(rs.getBytes("cover"));
//			office.setDirector(rs.getString("director"));
//			office.setDuration(rs.getInt("duration"));
//			office.setIntroduction(rs.getString("introduction"));
//			office.setName(rs.getString("name"));
//			office.setStatus(rs.getString("status"));
//			office.setTotalMoney(rs.getBigDecimal("totalmoney"));
//			office.setTotalSale(rs.getInt("totalnum"));
//			office.setType(rs.getString("type"));
//			clist.add(office);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		return filmMapper.queryOffice();
	}

}
