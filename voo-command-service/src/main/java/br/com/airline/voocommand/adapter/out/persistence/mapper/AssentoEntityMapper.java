package br.com.airline.voocommand.adapter.out.persistence.mapper;

import br.com.airline.voocommand.adapter.out.persistence.entity.AssentoEntity;
import br.com.airline.voocommand.core.domain.Assento;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AssentoEntityMapper {

  private final ModelMapper modelMapper;

  public Assento toDomain(AssentoEntity entity) {
    return this.modelMapper.map(entity, Assento.class);
  }

  public AssentoEntity toEntity(Assento domain) {
    return this.modelMapper.map(domain, AssentoEntity.class);
  }

  public Set<Assento> toDomain(List<AssentoEntity> entities) {
    return entities.stream()
        .map(this::toDomain)
        .collect(Collectors.toSet());
  }

  public List<AssentoEntity> toEntity(Set<Assento> assentos) {
    return assentos.stream()
        .map(this::toEntity)
        .collect(Collectors.toList());
  }
}
