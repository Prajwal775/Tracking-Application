package com.trackingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication(scanBasePackages = "com.trackingapplication")
public class TrackingApplication {


//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

	public static void main(String[] args) {
		SpringApplication.run(TrackingApplication.class, args);
	}

}
