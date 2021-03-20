package br.com.airline.vooquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VooQueryApplication {

  public static void main(String[] args) {
    SpringApplication.run(VooQueryApplication.class, args);
  }
}
