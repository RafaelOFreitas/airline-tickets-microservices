package br.com.airline.companhia.adapter.in.web;

import br.com.airline.companhia.adapter.in.web.dto.input.RotaInput;
import br.com.airline.companhia.adapter.in.web.dto.output.RotaListOutput;
import br.com.airline.companhia.adapter.in.web.dto.output.RotaOutput;
import br.com.airline.companhia.adapter.in.web.mapper.RotaMapper;
import br.com.airline.companhia.core.application.port.in.RotaServicePort;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/companhias/{id_companhia}/rotas")
public class RotaController {

  private final RotaServicePort rotaService;
  private final RotaMapper mapper;

  @GetMapping
  public ResponseEntity<RotaListOutput> getRotasByIdCompanhia(
      @PathVariable(name = "id_companhia") UUID id
  ) {
    log.info(String.format("Recebendo requisição para buscar rotas da companhia: %s.", id));

    var rotas = this.rotaService.buscar(id);

    return ResponseEntity.ok().body(this.mapper.toOutput(id, rotas));
  }

  @PutMapping("/{id_rota}")
  public ResponseEntity<RotaOutput> updateRota(
      @PathVariable(name = "id_companhia") UUID idCompanhia,
      @PathVariable(name = "id_rota") Integer idRota,
      @Valid @RequestBody RotaInput input
  ) {
    log.info(String.format("Recebendo requisição para atualizar rota: %s", idRota));

    var rota = this.mapper.toDomain(idRota, input);

    rota = this.rotaService.atualizar(idCompanhia, rota);

    return ResponseEntity.ok().body(this.mapper.toOutput(rota));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RotaOutput saveRota(
      @PathVariable(name = "id_companhia") UUID id,
      @Valid @RequestBody RotaInput input
  ) {
    log.info("Recebendo requisição para adicionar rota: " + input.toString());

    var rota = this.rotaService.adicionar(id, this.mapper.toDomain(input));

    return this.mapper.toOutput(rota);
  }
}
