package br.com.airline.companhia.adapter.in.web;

import br.com.airline.companhia.adapter.in.web.dto.view.input.ParamAggregation;
import br.com.airline.companhia.adapter.in.web.dto.view.input.ViewInput;
import br.com.airline.companhia.adapter.in.web.dto.view.output.ViewOutput;
import br.com.airline.companhia.adapter.in.web.mapper.ViewMapper;
import br.com.airline.companhia.core.application.port.in.ViewServicePort;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/view")
public class ViewController {

  private final ViewServicePort viewService;
  private final ViewMapper mapper;

  @GetMapping
  public ResponseEntity<ViewOutput> getCompanhiaRotaAeronaveByIds(
      @Valid @ParamAggregation ViewInput input
  ) {
    var idCompanhia = input.getCompanhia();
    var idRota = input.getRota();
    var matriculaAeronave = input.getAeronave();

    log.info(String.format("Recebendo requisição para buscar dados da companhia: %s "
        + "rota: %d aeronave: %s", idCompanhia, idRota, matriculaAeronave));

    var view = this.viewService.buscar(idCompanhia, idRota, matriculaAeronave);

    return ResponseEntity.ok().body(this.mapper.toOutput(view));
  }
}
