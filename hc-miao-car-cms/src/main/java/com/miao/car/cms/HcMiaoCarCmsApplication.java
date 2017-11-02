package com.miao.car.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ImportResource(locations = {"classpath:spring-hbase.xml"})
public class HcMiaoCarCmsApplication {

	/**
	 * 这个在Ribbon 起到自动负载均衡的作用  ,测试时,修改端口,发布多个服务端
	 * 在使用Feigin的时候 , 可以不配置ribbon,内置已经组合  有负载均衡作用
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(HcMiaoCarCmsApplication.class, args);
	}
}
