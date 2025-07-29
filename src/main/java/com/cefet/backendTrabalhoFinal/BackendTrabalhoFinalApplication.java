package com.cefet.backendTrabalhoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendTrabalhoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTrabalhoFinalApplication.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hash = encoder.encode("123456");
		System.out.println(hash);
	}

}
