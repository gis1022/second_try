package com.example.second_try;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondTryApplication {


	public static void main(String[] args) {
		SpringApplication.run(SecondTryApplication.class, args);
		SaxMyParser parser = new SaxMyParser();
		parser.parce();
	}

}
