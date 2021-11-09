package com.fox.grpc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
public class SpringBootServerApplication {
	
	public static void main(String[] args) {
	    
	    SpringApplication.run(SpringBootServerApplication.class, args);
	}
	
	
}