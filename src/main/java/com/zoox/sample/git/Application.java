package com.zoox.sample.git;


import com.zoox.sample.git.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootApplication
@Import(AppConfig.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
