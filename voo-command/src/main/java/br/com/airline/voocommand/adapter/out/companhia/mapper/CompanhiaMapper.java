package br.com.airline.voocommand.adapter.out.companhia.mapper;

import br.com.airline.voocommand.adapter.out.companhia.dto.CompanhiaDto;
import br.com.airline.voocommand.adapter.out.companhia.dto.SecaoDto;
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

    return Voo.builder()
        .idCompanhia(voo.getIdCompanhia())
        .idRota(voo.getIdRota())
        .matriculaAeronave(voo.getMatriculaAeronave())
        .origem(rota.getOrigem())
        .destino(rota.getDestino())
        .horario(OffsetDateTime.now())
        .statusVoo(StatusVoo.AGENDADO)
        .mapasVoo(this.mapaFactory(aeronave.getSecoes()))
        .dataRegistro(OffsetDateTime.now())
        .dataAtualizacao(OffsetDateTime.now())
        .build();
  }

  private Set<MapaVoo> mapaFactory(Set<SecaoDto> secoes) {
    var mapas = new HashSet<MapaVoo>();

    secoes.forEach(secao -> mapas.add(MapaVoo.mapaFactory(Classe.valueOf(secao.getClasse()),
        secao.getQuantidadeFila(), secao.getQuantidadeAssento())));

    return mapas;
  }
}
