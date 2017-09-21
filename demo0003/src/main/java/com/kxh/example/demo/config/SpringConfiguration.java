package com.kxh.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kxh.example.demo.controller.ContactsController;

@Configuration
//@EntityScan("com.kxh.example.demo.domain.*")
//@EnableJpaRepositories("com.kxh.example.demo.dao.*")
public class SpringConfiguration {

}
