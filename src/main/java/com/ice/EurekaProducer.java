package com.ice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: eclair
 * @Description:
 * @Date: 2019/7/25
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaProducer {
	public static void main(String[] args) {
		SpringApplication.run(EurekaProducer.class, args);
	}
}
