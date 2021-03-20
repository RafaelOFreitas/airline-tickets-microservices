package br.com.airline.voocommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class VooCommandApplication {

  public static void main(String[] args) {
    SpringApplication.run(VooCommandApplication.class, args);
  }

}
