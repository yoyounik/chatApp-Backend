package com.substring.chat.chat_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAppBackendApplication {

	public static void main(String[] args) {
		// Set default profile to production if not specified
		if (System.getProperty("spring.profiles.active") == null) {
			System.setProperty("spring.profiles.active", "prod");
		}
		SpringApplication.run(ChatAppBackendApplication.class, args);
	}

}