package br.com.airline.companhia.adapter.in.web;

import br.com.airline.companhia.adapter.in.web.dto.input.AeronaveInput;
import br.com.airline.companhia.adapter.in.web.dto.output.AeronaveOutput;
import br.com.airline.companhia.adapter.in.web.mapper.AeronaveMapper;
import br.com.airline.companhia.core.application.port.in.AeronaveServicePort;
import java.util.UUID;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
@RequestMapping("/{id_companhia}/rotas/{id_rota}/aeronaves")
public class AeronaveController {

  private final AeronaveServicePort aeronaveService;
  private final AeronaveMapper mapper;

  @GetMapping
  public ResponseEntity<AeronaveOutput> getAeronavesById(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @PathParam(value = "matricula") String matricula
  ) {
    log.info(String.format("Recebendo requisição para buscar aeronave: %s.", matricula));

    var aeronave = this.aeronaveService.buscar(idCompanhia, idRota, matricula);

    return ResponseEntity.ok().body(this.mapper.toOutput(aeronave));
  }

  @PutMapping
  public ResponseEntity<AeronaveOutput> updateAeronave(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @Valid @RequestBody AeronaveInput input
  ) {
    log.info(String.format("Recebendo requisição para atualizar aeronave: %s", input.getMatricula()));

    var aeronave = this.aeronaveService.atualizar(idCompanhia, idRota, this.mapper.toDomain(input));

    return ResponseEntity.ok().body(this.mapper.toOutput(aeronave));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AeronaveOutput saveAeronave(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @Valid @RequestBody AeronaveInput input
  ) {
    log.info("Recebendo requisição para adicionar aeronave: " + input.getMatricula());

    var aeronave = this.mapper.toDomain(input);

    aeronave = this.aeronaveService.adicionar(idCompanhia, idRota, aeronave);

    return this.mapper.toOutput(aeronave);
  }

  @PutMapping("/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void activateAeronave(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @PathParam(value = "matricula") String matricula
  ) {
    log.info(String.format("Recebendo requisição para reativar aeronave: %s", matricula));

    this.aeronaveService.ativar(idCompanhia, idRota, matricula);
  }

  @DeleteMapping("/ativas")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void inactivateAeronave(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @PathParam(value = "matricula") String matricula
  ) {
    log.info(String.format("Recebendo requisição para inativar aeronave: %s", matricula));

    this.aeronaveService.inativar(idCompanhia, idRota, matricula);
  }
}

