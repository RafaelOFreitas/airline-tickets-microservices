package br.com.airline.apigatewayairline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayAirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayAirlineApplication.class, args);
	}

}
