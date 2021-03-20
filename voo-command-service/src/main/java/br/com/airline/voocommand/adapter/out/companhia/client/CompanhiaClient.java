package br.com.airline.voocommand.adapter.out.companhia.client;

import br.com.airline.voocommand.adapter.out.companhia.dto.InformacoesVoo;
import feign.Headers;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("companhia")
public interface CompanhiaClient {

  @GetMapping(value = "/views")
  @Headers(value = MediaType.APPLICATION_JSON_VALUE)
  InformacoesVoo getInfo(
      @RequestParam UUID companhia,
      @RequestParam Integer rota,
      @RequestParam String aeronave);
}