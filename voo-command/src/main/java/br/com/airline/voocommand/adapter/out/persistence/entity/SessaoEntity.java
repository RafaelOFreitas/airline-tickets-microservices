package br.com.airline.voocommand.adapter.out.persistence.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "sessao")
public class SessaoEntity {

  @EqualsAndHashCode.Include
  @Id
  @Field("classe_sessao")
  private String classe;

  @Field("assentos_sessao")
  private List<AssentoEntity> assentos;
}
