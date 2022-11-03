package br.com.uniamerica.pregao.pregaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PregaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PregaoApiApplication.class, args);
	}

}
