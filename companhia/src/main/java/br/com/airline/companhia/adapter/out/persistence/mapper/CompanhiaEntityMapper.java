package br.com.airline.companhia.adapter.out.persistence.mapper;

import br.com.airline.companhia.adapter.out.persistence.entity.CompanhiaEntity;
import br.com.airline.companhia.core.domain.Companhia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CompanhiaEntityMapper {

  private final ModelMapper modelMapper;

  public Companhia toDomain(CompanhiaEntity entity) {
    return this.modelMapper.map(entity, Companhia.class);
  }

  public CompanhiaEntity toEntity(Companhia domain) {
    return this.modelMapper.map(domain, CompanhiaEntity.class);
  }

  public void copyProperties(Companhia domain, CompanhiaEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}