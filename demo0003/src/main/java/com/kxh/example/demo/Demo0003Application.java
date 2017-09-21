package com.kxh.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.kxh.example.demo.config.*;

@SpringBootApplication
//@Import(SpringConfiguration.class)
public class Demo0003Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0003Application.class, args);
	}
}
