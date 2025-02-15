package com.marcosDev.notificacaoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificacaomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaomsApplication.class, args);
	}

}
