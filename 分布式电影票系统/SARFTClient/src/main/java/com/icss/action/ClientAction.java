package com.icss.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icss.dto.CinemaInfoDTO;
import com.icss.dto.FilmDTO;
import com.icss.dto.MoviesPackageDTO;
import com.icss.dto.RefundTicketPackageDTO;
import com.icss.dto.SalePackageDTO;
import com.icss.dto.ScreenPackageDTO;
import com.icss.dto.SupplementDTO;
import com.icss.dto.TicketDTO;
import com.icss.service.ICinemaInfo;
import com.icss.service.IFilmPack;
import com.icss.service.IGetScreenQuery;
import com.icss.service.IRefund;
import com.icss.service.ISale;
import com.icss.service.ISupplement;
import com.icss.util.Log;

@RestController
public class ClientAction {
	@Autowired
	private IFilmPack mpack;
	@Autowired
	private ICinemaInfo cinemaInfo;
	@Autowired
	private IGetScreenQuery getScreenQuery;
	@Autowired
	IRefund iRefund;
	@Autowired
	ISupplement iSupplement;
	@Autowired
	ISale iSale;
	@RequestMapping("/films")
	public String films() {		
		try {
			MoviesPackageDTO map= mpack.getFilmsPackageList(new Date("2020/11/23"), new Date("2020/12/23"));
			List<FilmDTO> flist=map.getFlist();			
			for(FilmDTO film : flist){
				System.out.println(film.getName() + "--" + film.getDirector());				
			}
			System.out.println("count"+"--"+map.getCount());
			System.out.println("return_value"+"--"+map.getReturn_value());
			System.out.println("total"+"--"+map.getTotal());
			System.out.println("remain"+"--"+map.getRemain());
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}

	@RequestMapping("/cinemaInfo")
	public String cinemaInfo() {		
		try {
			CinemaInfoDTO cinemaInfoDTO = cinemaInfo.changeCinemaInfo("123",1);
			System.out.println(cinemaInfoDTO.getName()+ "--" + cinemaInfoDTO.getCinema_code());				
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}
	
	@RequestMapping("/screen")
	public String screenInfo() {		
		try {
			ScreenPackageDTO screenPackageDTO = getScreenQuery.getScreenQuery("123");
			System.out.println(screenPackageDTO.getSlist()+ "--" + screenPackageDTO.getTotal());				
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}
	
	@RequestMapping("/refund")
	public String refundInfo() {		
		try {
			RefundTicketPackageDTO refundTicketPackageDTO=new RefundTicketPackageDTO();
			refundTicketPackageDTO.setBusiness_date(new Date("2020/09/08"));
			refundTicketPackageDTO.setCinema_code("123");
			refundTicketPackageDTO.setCount(4);
			refundTicketPackageDTO.setFilm_code("2222");
			refundTicketPackageDTO.setScreen_code("3333");
			refundTicketPackageDTO.setSession_code("4444");
			refundTicketPackageDTO.setSession_datetime(new Date("2020/09/23"));
			List<TicketDTO> tlist=new ArrayList<>();
			TicketDTO t=new TicketDTO("555",345);
			tlist.add(t);
			refundTicketPackageDTO.setTlist(tlist);
			iRefund.writeRefundInfo(refundTicketPackageDTO);			
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}
	
	@RequestMapping("/supplement")
	public String supplementInfo() {		
		try {
			SupplementDTO supplementDTO=new SupplementDTO();
			supplementDTO.setBusiness_date(new Date("2020/09/08"));
			supplementDTO.setCinema_code("123");
			supplementDTO.setCount(4);
			supplementDTO.setFilm_code("2222");
			supplementDTO.setScreen_code("3333");
			supplementDTO.setSession_code("4444");
			supplementDTO.setSession_datetime(new Date("2020/09/23"));
			supplementDTO.setCount(34);
			supplementDTO.setPrice(new BigDecimal(45.7));
			iSupplement.writeSupplement(supplementDTO);			
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}
	
	@RequestMapping("/sale")
	public String saleInfo() {		
		try {
			SalePackageDTO salePackageDTO=new SalePackageDTO();
			salePackageDTO.setBusiness_date(new Date("2020/09/08"));
			salePackageDTO.setCinema_code("123");
			salePackageDTO.setFilm_code("2222");
			salePackageDTO.setScreen_code("3333");
			salePackageDTO.setSession_code("4444");
			salePackageDTO.setSession_datetime(new Date("2020/09/28"));
			salePackageDTO.setDatetime(new Date("2020/09/28"));
			salePackageDTO.setPrice(new BigDecimal(45.7));
			iSale.writeSale(salePackageDTO);			
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
		}
		return "ok";
	}
}
