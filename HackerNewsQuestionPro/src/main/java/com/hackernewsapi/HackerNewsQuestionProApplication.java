package com.hackernewsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HackerNewsQuestionProApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerNewsQuestionProApplication.class, args);
	}

}
