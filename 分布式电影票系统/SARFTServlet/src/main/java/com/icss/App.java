package com.icss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.icss.kafka.KafkaConsume;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = {"classpath:beans.xml"})
public class App 
{

    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);    	
    	while(true) {
    		KafkaConsume.getMessage("movie");
    	}
    }
}
