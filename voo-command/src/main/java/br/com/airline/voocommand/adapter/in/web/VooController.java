package br.com.airline.voocommand.adapter.in.web;

import br.com.airline.voocommand.adapter.in.web.dto.input.VooInput;
import br.com.airline.voocommand.adapter.in.web.dto.output.VooOutput;
import br.com.airline.voocommand.adapter.in.web.mapper.VooMapper;
import br.com.airline.voocommand.core.application.port.in.VooServicePort;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/")
public class VooController {

  private final VooServicePort vooService;
  private final VooMapper mapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public VooOutput saveVoo(@Valid @RequestBody VooInput input) {
    log.info("Recebendo requisição para adicionar voo: " + input.toString());

    var voo = this.vooService.adicionar(this.mapper.toDomain(input));

    return this.mapper.toOutput(voo);
  }
}

