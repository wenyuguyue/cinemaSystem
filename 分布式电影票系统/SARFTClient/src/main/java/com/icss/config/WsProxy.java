package com.icss.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.icss.service.ICinemaInfo;
import com.icss.service.IFilmPack;
import com.icss.service.IGetScreenQuery;
import com.icss.service.IRefund;
import com.icss.service.ISale;
import com.icss.service.ISupplement;


 
 
@Configuration
public class WsProxy {   
 
    @Bean
    public IFilmPack usePack() {
    	String address = "http://localhost:8088/sarft/ws/film?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(IFilmPack.class);
		proxy.setAddress(address);
		IFilmPack mpack =(IFilmPack) proxy.create();
		
        return mpack;
    }
    
    @Bean
    public ICinemaInfo cinemaInfo() {
    	String address = "http://localhost:8088/sarft/ws/cinema?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(ICinemaInfo.class);
		proxy.setAddress(address);		
		ICinemaInfo mpack = (ICinemaInfo) proxy.create();
		
        return mpack;
    }
    
    @Bean
    public IGetScreenQuery screenInfo() {
    	String address = "http://localhost:8088/sarft/ws/screen?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(IGetScreenQuery.class);
		proxy.setAddress(address);		
		IGetScreenQuery mpack = (IGetScreenQuery) proxy.create();
		
        return mpack;
    }
    
    @Bean
    public IRefund refundInfo() {
    	String address = "http://localhost:8088/sarft/ws/refund?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(IRefund.class);
		proxy.setAddress(address);		
		IRefund mpack = (IRefund) proxy.create();
		
        return mpack;
    }
    
    @Bean
    public ISupplement supplementInfo() {
    	String address = "http://localhost:8088/sarft/ws/supplement?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(ISupplement.class);
		proxy.setAddress(address);		
		ISupplement mpack = (ISupplement) proxy.create();
		
        return mpack;
    }
    
    @Bean
    public ISale saleInfo() {
    	String address = "http://localhost:8088/sarft/ws/sale?wsdl";
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(ISale.class);
		proxy.setAddress(address);		
		ISale mpack = (ISale) proxy.create();
		
        return mpack;
    }
}