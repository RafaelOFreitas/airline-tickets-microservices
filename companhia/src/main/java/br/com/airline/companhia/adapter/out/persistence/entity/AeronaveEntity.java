package br.com.airline.companhia.adapter.out.persistence.entity;

import br.com.airline.companhia.core.domain.Status;
import br.com.airline.companhia.core.domain.TipoAeronave;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "aeronave")
@Table(name = "tb_aeronave")
public class AeronaveEntity {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_aeronave")
  private UUID id;

  @Column(name = "nome_aeronave", nullable = false)
  private String nome;

  @Column(name = "modelo_aeronave", nullable = false)
  private String modelo;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_aeronave", nullable = false)
  private TipoAeronave tipo;

  @Column(name = "quantidade_assento_fila_aeronave", nullable = false)
  private Integer quantidadeAssentoFila;

  @Column(name = "quantidade_fila_aeronave", nullable = false)
  private Integer quantidadeFila;

  @Enumerated(EnumType.STRING)
  @Column(name = "status_aeronave", nullable = false)
  private Status status;

  @CreationTimestamp
  @Column(name = "data_registro_aeronave", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataRegistro;

  @UpdateTimestamp
  @Column(name = "data_ultima_atualizacao_aeronave", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataAtualizacao;
}
