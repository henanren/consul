package com.lenovo.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulApplication {

	@RequestMapping("/home")
	public Object home() {
		System.out.println("2222222");
		return "OK22";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsulApplication.class, args);
	}
}
