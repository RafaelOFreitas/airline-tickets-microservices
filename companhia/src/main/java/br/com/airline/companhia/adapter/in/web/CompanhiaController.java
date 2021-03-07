package br.com.airline.companhia.adapter.in.web;

import br.com.airline.companhia.adapter.in.web.dto.input.CompanhiaInput;
import br.com.airline.companhia.adapter.in.web.dto.output.CompanhiaOutput;
import br.com.airline.companhia.adapter.in.web.mapper.CompanhiaMapper;
import br.com.airline.companhia.core.application.port.in.CompanhiaServicePort;
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
@RequestMapping("/")
public class CompanhiaController {

  private final CompanhiaServicePort companhiaService;
  private final CompanhiaMapper mapper;

  @GetMapping("/{id}")
  public ResponseEntity<CompanhiaOutput> getCompanhiaById(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para buscar os dados da companhia: %s.", id));

    var companhia = this.companhiaService.buscar(id);

    return ResponseEntity.ok().body(this.mapper.toOutput(companhia));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CompanhiaOutput> updateCompanhia(
      @PathVariable UUID id,
      @Valid @RequestBody CompanhiaInput input
  ) {
    log.info(String.format("Recebendo requisição para atualizar companhia: %s", id));

    var companhia = this.companhiaService.atualizar(id, this.mapper.toDomain(input));

    return ResponseEntity.ok().body(this.mapper.toOutput(companhia));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CompanhiaOutput saveCompanhia(@Valid @RequestBody CompanhiaInput input) {
    log.info("Recebendo requisição para adicionar companhia: " + input.toString());

    var companhia = this.companhiaService.adicionar(this.mapper.toDomain(input));

    return this.mapper.toOutput(companhia);
  }

  @PutMapping("/{id}/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void activateCompanhia(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para reativar uma companhia: %s", id));

    this.companhiaService.ativar(id);
  }

  @DeleteMapping("/{id}/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void inactivateCompanhia(@PathVariable UUID id) {
    log.info(String.format("Recebendo requisição para inativar uma companhia: %s", id));

    this.companhiaService.inativar(id);
  }
}
