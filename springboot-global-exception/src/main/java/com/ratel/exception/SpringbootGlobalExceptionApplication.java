package com.ratel.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootGlobalExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGlobalExceptionApplication.class, args);
		System.out.println("启动成功");
	}

}
