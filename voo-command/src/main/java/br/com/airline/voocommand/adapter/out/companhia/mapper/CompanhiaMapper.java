package br.com.airline.voocommand.adapter.out.companhia.mapper;

import br.com.airline.voocommand.adapter.out.companhia.dto.CompanhiaDto;
import br.com.airline.voocommand.adapter.out.companhia.dto.TipoAeronaveDto;
import br.com.airline.voocommand.core.domain.Classe;
import br.com.airline.voocommand.core.domain.MapaVoo;
import br.com.airline.voocommand.core.domain.StatusVoo;
import br.com.airline.voocommand.core.domain.Voo;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CompanhiaMapper {

  public Voo toDomain(Voo voo, CompanhiaDto dto) {
    var rota = dto.getRota();
    var aeronave = rota.getAeronave();

    var quantidadeAssentoFila = rota.getAeronave().getQuantidadeAssentoFila();
    var quantidadeFila = rota.getAeronave().getQuantidadeFila();

    return Voo.builder()
        .idCompanhia(voo.getIdCompanhia())
        .idRota(voo.getIdRota())
        .matriculaAeronave(voo.getMatriculaAeronave())
        .origem(rota.getOrigem())
        .destino(rota.getDestino())
        .horario(OffsetDateTime.now())
        .statusVoo(StatusVoo.AGENDADO)
        .mapasVoo(this.mapaFactory(aeronave.getTipo(), quantidadeFila, quantidadeAssentoFila))
        .dataRegistro(OffsetDateTime.now())
        .dataAtualizacao(OffsetDateTime.now())
        .build();
  }

  private Set<MapaVoo> mapaFactory(TipoAeronaveDto tipo, Integer filas, Integer assentos) {
    var mapas = new HashSet<MapaVoo>();

    if (TipoAeronaveDto.EXECUTIVA == tipo) {
      mapas.add(MapaVoo.mapaFactory(Classe.EXECUTIVA, filas, assentos));
      return mapas;
    }

    tipo.getClasses()
        .forEach(c -> mapas.add(MapaVoo.mapaFactory(c, c.arranjarFila(filas), assentos)));

    return mapas;
  }
}
