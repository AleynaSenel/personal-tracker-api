package com.stajTakip.staj_takip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling    //Spring Boot'un arka plandaki kronomotrelerini aktif eder
public class StajTakipApplication {

	public static void main(String[] args) {
		SpringApplication.run(StajTakipApplication.class, args);
	}

}
