package br.com.airline.vooquery.adapter.out.persistence.mapper;

import br.com.airline.vooquery.adapter.out.persistence.entity.VooEntity;
import br.com.airline.vooquery.core.domain.MapaVoo;
import br.com.airline.vooquery.core.domain.Voo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VooEntityMapper {

  private final ModelMapper modelMapper;

  public Voo toDomain(VooEntity entity, MapaVoo mapa) {
    var voo = this.modelMapper.map(entity, Voo.class);

    voo.setMapa(mapa);

    return voo;
  }

  public VooEntity toEntity(Voo domain) {
    return this.modelMapper.map(domain, VooEntity.class);
  }
}
