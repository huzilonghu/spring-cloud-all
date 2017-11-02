package com.miao.car.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.List;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
public class HcMiaoCarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcMiaoCarApiApplication.class, args);
	}
}
