package io.egen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "io.egen" })
public class WeightMonitorApp {

	public static void main(String[] args) {
		SpringApplication.run(WeightMonitorApp.class, args);
	}
}
