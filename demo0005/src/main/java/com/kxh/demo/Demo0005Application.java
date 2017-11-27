package com.kxh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Demo0005Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0005Application.class, args);
	}
}
