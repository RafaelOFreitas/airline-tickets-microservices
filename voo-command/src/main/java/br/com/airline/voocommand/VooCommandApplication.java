package br.com.airline.voocommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VooCommandApplication {

  public static void main(String[] args) {
    SpringApplication.run(VooCommandApplication.class, args);
  }

}
