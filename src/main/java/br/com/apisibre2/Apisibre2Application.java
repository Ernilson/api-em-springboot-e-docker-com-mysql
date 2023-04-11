package br.com.apisibre2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class Apisibre2Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Apisibre2Application.class, args);
	}

}
