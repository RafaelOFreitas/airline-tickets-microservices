package br.com.airline.funcionario.adapter.out.persistence.mapper;

import br.com.airline.funcionario.adapter.out.persistence.entity.FuncionarioEntity;
import br.com.airline.funcionario.core.domain.Funcionario;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FuncionarioEntityMapper {

  private final ModelMapper modelMapper;

  public Funcionario toDomain(FuncionarioEntity entity) {
    return this.modelMapper.map(entity, Funcionario.class);
  }

  public List<Funcionario> toDomain(List<FuncionarioEntity> entities) {
    return entities.stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }

  public FuncionarioEntity toEntity(Funcionario domain) {
    return this.modelMapper.map(domain, FuncionarioEntity.class);
  }

  public void copyProperties(Funcionario domain, FuncionarioEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}
