package com.icss.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.icss.service.Impl.ScreenQueryImpl;
 
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;  
    @Autowired
    ScreenQueryImpl screenQueryImpl;
    
    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/sc/*");  //发布服务名称
    }
    
//    @Bean
//    public IMoviePack getPack()
//    {
//        return  new MoviePackImpl();
//    }
    
//    @Bean
//    public ICinemaInfo getPack2()
//    {
//        return  new CinemaInfoImpl();
//    }
 
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, screenQueryImpl);
        endpoint.publish("/screen");
        return endpoint;
    }

}