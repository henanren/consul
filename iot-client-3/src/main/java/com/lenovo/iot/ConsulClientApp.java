package com.lenovo.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecwid.consul.v1.ConsulClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulClientApp {

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ConsulClient consulClient;

	/**
	 * 从所有服务中选择一个服务（轮询）
	 */
	@RequestMapping("/discover")
	public Object discover() {
		return loadBalancer.choose("tom123").getUri().toString();
	}

	@RequestMapping("/home")
	public Object home() {
		return loadBalancer.choose("tom123").getUri().toString();
	}

	/**
	 * 获取所有服务
	 */
	@RequestMapping("/services")
	public Object services() {
		return discoveryClient.getInstances("tom123");
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsulClientApp.class, args);
	}
}
