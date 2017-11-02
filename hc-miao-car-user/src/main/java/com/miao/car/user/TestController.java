package com.miao.car.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xsing on 2017/8/16.
 */
@RestController
public class TestController {


    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ec")
    public String ec() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/rs")
    public String rs() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("cms");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/appid";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);

        /*
         return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
         */
    }
}
