package br.com.airline.voocommand.adapter.out.persistence.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "mapa")
public class MapaVooEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @Id
  private String id;

  @Field("id_voo")
  private String idVoo;

  @Field("sessoes_mapa")
  private transient List<SessaoEntity> sessoes;
}
