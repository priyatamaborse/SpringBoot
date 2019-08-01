package com.yash.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

//@EnableAutoConfiguration

//@ComponentScan("com.yash.springbootdemo.*")
@SpringBootConfiguration
public class SpringMvcApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
