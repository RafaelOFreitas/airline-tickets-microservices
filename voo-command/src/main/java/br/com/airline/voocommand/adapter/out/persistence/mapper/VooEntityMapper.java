package br.com.airline.voocommand.adapter.out.persistence.mapper;

import br.com.airline.voocommand.adapter.out.persistence.entity.VooEntity;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VooEntityMapper {

  private final ModelMapper modelMapper;

  public Voo toDomain(VooEntity entity) {
    return this.modelMapper.map(entity, Voo.class);
  }

  public List<Voo> toDomain(List<VooEntity> entities) {
    if (Objects.isNull(entities)) {
      return Collections.emptyList();
    }

    return entities.stream().map(this::toDomain).collect(Collectors.toList());
  }

  public VooEntity toEntity(Voo domain) {
    return this.modelMapper.map(domain, VooEntity.class);
  }

  public void copyProperties(Voo domain, VooEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}
