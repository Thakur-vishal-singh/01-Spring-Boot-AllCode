package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.AppConfig;

@SpringBootApplication
public class Application  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	private final AppConfig appConfig;
	
	@Autowired
	public Application(AppConfig appConfig) {
		this.appConfig=appConfig;
	}
	
	@Override
	public void run(String... args){
		appConfig.helloWorld();
	}
	
	
	
}
