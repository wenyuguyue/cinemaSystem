package com.icss.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.icss.dto.RefundTicketPackageDTO;
import com.icss.dto.SalePackageDTO;
import com.icss.dto.SupplementDTO;
@Repository
public class TicketDao extends BaseDao {

	public void writeRefundInfo(RefundTicketPackageDTO refundTicketPackageDTO) throws SQLException {
		String sql = "insert into trefund(cinema_code,business_date,screen_code,film_code,session_code,session_datetime,count,code,price) values(?,?,?,?,?,?,?,?,?)";
		Connection conn = openCollection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, refundTicketPackageDTO.getCinema_code());
		ps.setTimestamp(2, new Timestamp(refundTicketPackageDTO.getBusiness_date().getTime()));
		ps.setString(3, refundTicketPackageDTO.getScreen_code());
		ps.setString(4, refundTicketPackageDTO.getFilm_code());
		ps.setString(5, refundTicketPackageDTO.getSession_code());
		ps.setTimestamp(6, new Timestamp(refundTicketPackageDTO.getSession_datetime().getTime()));
		ps.setInt(7, refundTicketPackageDTO.getCount());
		for (int i = 0; i < refundTicketPackageDTO.getTlist().size(); i++) {
			ps.setString(8, refundTicketPackageDTO.getTlist().get(i).getCode());
			ps.setDouble(9, refundTicketPackageDTO.getTlist().get(i).getPrice());
			ps.executeUpdate();
		}
		ps.close();
	}

	public void writeSupplement(SupplementDTO supplementDTO) throws SQLException {
		String sql = "insert into tsupplement(cinema_code,business_date,screen_code,film_code,session_code,session_datetime,count,price) values(?,?,?,?,?,?,?,?)";
		Connection conn = openCollection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, supplementDTO.getCinema_code());
		ps.setTimestamp(2, new Timestamp(supplementDTO.getBusiness_date().getTime()));
		ps.setString(3, supplementDTO.getScreen_code());
		ps.setString(4, supplementDTO.getFilm_code());
		ps.setString(5, supplementDTO.getSession_code());
		ps.setTimestamp(6, new Timestamp(supplementDTO.getSession_datetime().getTime()));
		ps.setInt(7, supplementDTO.getCount());
		ps.setBigDecimal(8, supplementDTO.getPrice());
		ps.executeUpdate();
		ps.close();
	}

	public void writeSale(SalePackageDTO salePackageDTO) throws SQLException {
		String sql = "insert into tsale(cinema_code,cinema_status,business_date,screen_code,film_code,session_code,session_datetime,operation,code,seat_code,price,service,online_sale,datetime,signature) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = openCollection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, salePackageDTO.getCinema_code());
		ps.setInt(2, salePackageDTO.getCinema_status());
		ps.setTimestamp(3, new Timestamp(salePackageDTO.getBusiness_date().getTime()));
		ps.setString(4, salePackageDTO.getScreen_code());
		ps.setString(5, salePackageDTO.getFilm_code());
		ps.setString(6, salePackageDTO.getSession_code());
		ps.setTimestamp(7, new Timestamp(salePackageDTO.getSession_datetime().getTime()));
		ps.setInt(8, salePackageDTO.getOperation());
		ps.setString(9, salePackageDTO.getCode());
		ps.setString(10, salePackageDTO.getSeat_code());
		ps.setBigDecimal(11, salePackageDTO.getPrice());
		ps.setBigDecimal(12, salePackageDTO.getService());
		ps.setInt(13, salePackageDTO.getOnline_sale());
		ps.setDate(14, new Date(salePackageDTO.getDatetime().getTime()));
		ps.setString(15,salePackageDTO.getSignature());
		ps.executeUpdate();
		ps.close();
	}

	public String getName(String film_code) throws SQLException {
		String name=null;
		String sql = "select name from tmovie where code=?";
		Connection conn = openCollection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, film_code);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			name=rs.getString("name");
		}
		rs.close();
		ps.close();
		return name;
	}

}
