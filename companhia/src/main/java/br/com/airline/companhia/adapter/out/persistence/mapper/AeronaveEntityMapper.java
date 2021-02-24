package br.com.airline.companhia.adapter.out.persistence.mapper;

import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntity;
import br.com.airline.companhia.core.domain.Aeronave;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AeronaveEntityMapper {

  private final ModelMapper modelMapper;

  public Aeronave toDomain(AeronaveEntity entity) {
    return this.modelMapper.map(entity, Aeronave.class);
  }

  public AeronaveEntity toEntity(Aeronave domain) {
    return this.modelMapper.map(domain, AeronaveEntity.class);
  }

  public void copyProperties(Aeronave domain, AeronaveEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}
