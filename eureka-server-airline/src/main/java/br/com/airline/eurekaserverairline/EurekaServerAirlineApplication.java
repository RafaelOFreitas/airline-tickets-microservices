package br.com.airline.eurekaserverairline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerAirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerAirlineApplication.class, args);
	}

}
