package br.com.airline.companhia.adapter.out.persistence.mapper;

import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntity;
import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntityId;
import br.com.airline.companhia.core.domain.Aeronave;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AeronaveEntityMapper {

  private final ModelMapper modelMapper;

  public Aeronave toDomain(AeronaveEntity entity) {
    var domain = this.modelMapper.map(entity, Aeronave.class);

    domain.setMatricula(entity.getId().getMatricula());

    return domain;
  }

  public List<Aeronave> toDomain(List<AeronaveEntity> entities) {
    if (Objects.isNull(entities)) {
      return Collections.emptyList();
    }

    return entities.stream().map(this::toDomain).collect(Collectors.toList());
  }

  public AeronaveEntity toEntity(UUID idCompanhia, Integer idRota, Aeronave domain) {
    var entity = this.modelMapper.map(domain, AeronaveEntity.class);

    entity.setId(new AeronaveEntityId(domain.getMatricula(), idCompanhia, idRota));

    return entity;
  }

  public void copyProperties(Aeronave domain, AeronaveEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}
