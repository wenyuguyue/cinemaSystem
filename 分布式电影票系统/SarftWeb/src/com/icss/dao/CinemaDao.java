package com.icss.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.entity.Cinema;
import com.icss.entity.Moviehall;
import com.icss.mapper.ICinemaMapper;

@Repository
public class CinemaDao {
@Autowired
ICinemaMapper cinemaMapper;
	public List<Cinema> queryCinema() throws Exception {
//		List<Cinema> clist=null;
//		String sql="select * from cinema";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		clist=new ArrayList<>();
//		while(rs.next()) {	
//			Cinema cinema=new Cinema();
//			cinema.setCode(rs.getString("code"));
//			cinema.setName(rs.getString("name"));
//			cinema.setCorporation(rs.getString("corporation"));
//			cinema.setContact(rs.getString("contact"));
//			cinema.setTelephone(rs.getString("telephone"));
//			cinema.setFax(rs.getString("fax"));
//			cinema.setCinemas(rs.getString("cinemas"));
//			cinema.setStatus(rs.getInt("status"));
//			cinema.setScreen_count(rs.getInt("screen_count"));
//			clist.add(cinema);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		return cinemaMapper.queryCinema();
	}

	public void editCinema(String code, String field, String value) throws Exception {
//		String sql="update cinema set "+field+"=? where code=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, value);
//		ps.setString(2, code);
//		ps.executeUpdate();	
//		ps.close();
		cinemaMapper.editCinema(code,field,value);
	}

	public void deleteCinema(String code) throws Exception {
//		String sql="delete from cinema where code=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, code);
//		ps.executeUpdate();	
//		ps.close();
		cinemaMapper.deleteCinema(code);
	}

	public void addCinema(Cinema cinema) throws Exception {
//		String sql="insert into cinema(code,name,corporation,contact,telephone,fax,cinemas,status,screen_count) values(?,?,?,?,?,?,?,?,?)";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, cinema.getCode());
//		ps.setObject(2, cinema.getName());
//		ps.setObject(3, cinema.getCorporation());
//		ps.setObject(4, cinema.getContact());
//		ps.setObject(5, cinema.getTelephone());
//		ps.setObject(6, cinema.getFax());
//		ps.setObject(7, cinema.getCinemas());
//		ps.setObject(8, cinema.getStatus());
//		ps.setObject(9, cinema.getScreen_count());
//		ps.executeUpdate();	
//		ps.close();
		cinemaMapper.deleteCinema(cinema);
	}

	public List<Moviehall> queryMoviehall() throws Exception {
//		List<Moviehall> clist=null;
//		String sql="select mh.*,c.name from cinema c inner join tmoviehall mh on c.cid=mh.cid";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		clist=new ArrayList<>();
//		while(rs.next()) {	
//			Moviehall moviehall=new Moviehall();
//			moviehall.setHno(rs.getInt("hno"));
//			moviehall.setName(rs.getString("name"));
//			moviehall.setCid(rs.getInt("cid"));
//			moviehall.setAllcol(rs.getInt("allcol"));
//			moviehall.setAllrow(rs.getInt("allrow"));
//			moviehall.setCinema_name(rs.getString("c.name"));
//			moviehall.setCode(rs.getString("code"));
//			moviehall.setHstyle(rs.getString("hstyle"));
//			moviehall.setSeat_count(rs.getInt("seat_count"));
//			clist.add(moviehall);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		return cinemaMapper.queryMoviehall();
	}

	public void deleteMoviehall(String hno) throws Exception {
//		String sql="delete from tmoviehall where hno=?";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, hno);
//		ps.executeUpdate();	
//		ps.close();
		cinemaMapper.deleteMoviehall(hno);
	}

	public List<Cinema> queryCinemaCid() throws Exception {
//		List<Cinema> clist=null;
//		String sql="select * from cinema";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		clist=new ArrayList<>();
//		while(rs.next()) {	
//			Cinema cinema=new Cinema();
//			cinema.setCid(rs.getInt("cid"));
//			cinema.setCode(rs.getString("code"));
//			cinema.setName(rs.getString("name"));
//			cinema.setCorporation(rs.getString("corporation"));
//			cinema.setContact(rs.getString("contact"));
//			cinema.setTelephone(rs.getString("telephone"));
//			cinema.setFax(rs.getString("fax"));
//			cinema.setCinemas(rs.getString("cinemas"));
//			cinema.setStatus(rs.getInt("status"));
//			cinema.setScreen_count(rs.getInt("screen_count"));
//			clist.add(cinema);
//		}
//		rs.close();
//		ps.close();
//		return clist;
		return cinemaMapper.queryCinemaCid();
	}

	public void addMoviehall(Moviehall moviehall) throws Exception {
//		String sql="insert into tmoviehall(cid,code,name,allrow,allcol,hstyle,seat_count) values(?,?,?,?,?,?,?)";
//		Connection conn=openCollection();
//		PreparedStatement ps=conn.prepareStatement(sql);
//		ps.setObject(1, moviehall.getCid());
//		ps.setObject(2, moviehall.getCode());
//		ps.setObject(3, moviehall.getName());
//		ps.setObject(4, moviehall.getAllrow());
//		ps.setObject(5, moviehall.getAllcol());
//		ps.setObject(6, moviehall.getHstyle());
//		ps.setObject(7, moviehall.getSeat_count());
//		ps.executeUpdate();	
//		ps.close();
		cinemaMapper.addMoviehall(moviehall);
	}

}
