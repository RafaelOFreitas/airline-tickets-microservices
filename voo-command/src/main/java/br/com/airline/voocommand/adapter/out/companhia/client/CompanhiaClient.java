package br.com.airline.voocommand.adapter.out.companhia.client;

import br.com.airline.voocommand.adapter.out.companhia.dto.CompanhiaDto;
import feign.Headers;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("companhia")
public interface CompanhiaClient {

  @GetMapping(value = "/companhias/views")
  @Headers(value = MediaType.APPLICATION_JSON_VALUE)
  CompanhiaDto getInfo(
      @RequestParam UUID companhia,
      @RequestParam Integer rota,
      @RequestParam String aeronave);
}