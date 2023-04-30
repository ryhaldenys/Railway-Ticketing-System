package ua.nulp.kn303;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TrainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainServiceApplication.class, args);
	}

}
