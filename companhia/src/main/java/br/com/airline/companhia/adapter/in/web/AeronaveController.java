package br.com.airline.companhia.adapter.in.web;

import br.com.airline.companhia.adapter.in.web.dto.input.AeronaveInput;
import br.com.airline.companhia.adapter.in.web.dto.output.AeronaveOutput;
import br.com.airline.companhia.adapter.in.web.mapper.AeronaveMapper;
import br.com.airline.companhia.core.application.port.in.AeronaveServicePort;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/aeronaves")
public class AeronaveController {

  private final AeronaveServicePort aeronaveService;
  private final AeronaveMapper mapper;

  @GetMapping("/{id}")
  public ResponseEntity<AeronaveOutput> getAeronaveById(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para buscar os dados da aeronave: %s.", id));

    var aeronave = this.aeronaveService.buscar(id);

    return ResponseEntity.ok().body(this.mapper.toOutput(aeronave));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AeronaveOutput> updateCompanhia(
      @PathVariable UUID id,
      @Valid @RequestBody AeronaveInput input
  ) {
    log.info(String.format("Recebendo requisição para atualizar uma aeronave: %s", id));

    var aeronave = this.aeronaveService.atualizar(id, this.mapper.toDomain(input));

    return ResponseEntity.ok().body(this.mapper.toOutput(aeronave));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AeronaveOutput saveAeronave(@Valid @RequestBody AeronaveInput input) {
    log.info("Recebendo requisição para adicionar uma aeronave: " + input.getNome());

    var aeronave = this.aeronaveService.adicionar(this.mapper.toDomain(input));

    return this.mapper.toOutput(aeronave);
  }

  @PutMapping("/{id}/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void activateAeronave(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para reativar uma aeronave: %s", id));

    this.aeronaveService.ativar(id);
  }

  @DeleteMapping("/{id}/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void inactivateAeronave(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para inativar uma aeronave: %s", id));

    this.aeronaveService.inativar(id);
  }
}

