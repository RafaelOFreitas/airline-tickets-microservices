package br.com.airline.voocommand.adapter.out.persistence.mapper;

import br.com.airline.voocommand.adapter.out.persistence.entity.MapaVooEntity;
import br.com.airline.voocommand.adapter.out.persistence.entity.SessaoEntity;
import br.com.airline.voocommand.core.domain.Classe;
import br.com.airline.voocommand.core.domain.MapaVoo;
import br.com.airline.voocommand.core.domain.Sessao;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MapaVooEntityMapper {

  private final AssentoEntityMapper assentoMapper;

  public Sessao toDomain(SessaoEntity entity) {
    var assentos = this.assentoMapper.toDomain(entity.getAssentos());

    return new Sessao(Classe.valueOf(entity.getClasse()), assentos);
  }

  public MapaVoo toDomain(MapaVooEntity entity) {
    var sessoes = entity.getSessoes().stream()
        .map(this::toDomain)
        .collect(Collectors.toSet());

    return new MapaVoo(entity.getId(), sessoes);
  }

  public SessaoEntity toEntity(Sessao domain) {
    var assentos = this.assentoMapper.toEntity(domain.getAssentos());

    return new SessaoEntity(domain.getClasse().toString(), assentos);
  }

  public MapaVooEntity toEntity(String idVoo, MapaVoo domain) {
    var sessoes = domain.getSessoes().stream()
        .map(this::toEntity)
        .collect(Collectors.toList());

    return MapaVooEntity.builder()
        .idVoo(idVoo)
        .sessoes(sessoes)
        .build();
  }
}
