package com.example.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
System.out.println("Current working directory: " + System.getProperty("user.dir"));

		Dotenv dotenv = Dotenv.configure()
			.load();

		checkEnvVariable(dotenv, "SPRING_DATASOURCE_URL");
		checkEnvVariable(dotenv, "SPRING_DATASOURCE_USERNAME");
		checkEnvVariable(dotenv, "SPRING_DATASOURCE_PASSWORD");
		checkEnvVariable(dotenv, "SPRING_DATASOURCE_DRIVER_CLASS_NAME");

		System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
		System.setProperty("SPRING_DATASOURCE_DRIVER_CLASS_NAME", dotenv.get("SPRING_DATASOURCE_DRIVER_CLASS_NAME"));

		SpringApplication.run(PortfolioApplication.class, args);
		System.out.println("Portfolio running successfully.");
	}

	private static void checkEnvVariable(Dotenv dotenv, String key) {
		if (dotenv.get(key) == null || dotenv.get(key).isEmpty()) {
			throw new IllegalArgumentException("Missing required environment variable: " + key);
		}
	}

}
