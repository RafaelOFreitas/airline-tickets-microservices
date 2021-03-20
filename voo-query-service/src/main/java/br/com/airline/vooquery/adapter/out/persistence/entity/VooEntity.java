package br.com.airline.vooquery.adapter.out.persistence.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "voo")
public class VooEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @Id
  private String id;

  @Field("id_companhia_voo")
  private UUID companhia;

  @Field("id_rota_voo")
  private Integer rota;

  @Field("matricula_aeronave_voo")
  private String aeronave;

  @Field("origem_voo")
  private String origem;

  @Field("destino_voo")
  private String destino;

  @Field("horario_voo")
  private OffsetDateTime horario;

  @Field("status_voo")
  private String status;

  @Field("data_registro_voo")
  private OffsetDateTime dataRegistro;

  @Field("data_atualizacao_voo")
  private OffsetDateTime dataAtualizacao;
}