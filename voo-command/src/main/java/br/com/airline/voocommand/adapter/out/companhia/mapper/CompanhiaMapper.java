package br.com.airline.voocommand.adapter.out.companhia.mapper;

import br.com.airline.voocommand.adapter.out.companhia.dto.InformacoesVoo;
import br.com.airline.voocommand.adapter.out.companhia.dto.SecaoDto;
import br.com.airline.voocommand.core.domain.Classe;
import br.com.airline.voocommand.core.domain.MapaVoo;
import br.com.airline.voocommand.core.domain.Sessao;
import br.com.airline.voocommand.core.domain.StatusVoo;
import br.com.airline.voocommand.core.domain.Voo;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CompanhiaMapper {

  public Voo toDomain(InformacoesVoo dto) {
    var rota = dto.getRota();
    var aeronave = rota.getAeronave();

    return Voo.builder()
        .origem(rota.getOrigem())
        .destino(rota.getDestino())
        .horario(OffsetDateTime.now())
        .status(StatusVoo.AGENDADO)
        .mapa(new MapaVoo("", this.mapaFactory(aeronave.getSecoes())))
        .dataRegistro(OffsetDateTime.now())
        .dataAtualizacao(OffsetDateTime.now())
        .build();
  }

  private Set<Sessao> mapaFactory(Set<SecaoDto> secoes) {
    var mapas = new HashSet<Sessao>();

    secoes.forEach(secao -> mapas.add(Sessao.mapaFactory(Classe.valueOf(secao.getClasse()),
        secao.getQuantidadeFila(), secao.getQuantidadeAssento())));

    return mapas;
  }
}
