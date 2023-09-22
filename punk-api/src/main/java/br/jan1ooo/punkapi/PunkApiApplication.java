package br.jan1ooo.punkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class PunkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunkApiApplication.class, args);
	}

}
