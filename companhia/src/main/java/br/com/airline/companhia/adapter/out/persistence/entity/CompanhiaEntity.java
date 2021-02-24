package br.com.airline.companhia.adapter.out.persistence.entity;

import br.com.airline.companhia.core.domain.Status;
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
@Entity(name = "companhia")
@Table(name = "tb_companhia")
public class CompanhiaEntity {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_companhia")
  private UUID id;

  @Column(name = "nome_companhia", nullable = false)
  private String nome;

  @Column(name = "cnpj_companhia", nullable = false)
  private String cnpj;

  @Enumerated(EnumType.STRING)
  @Column(name = "status_companhia", nullable = false)
  private Status status;

  @CreationTimestamp
  @Column(name = "data_registro_companhia", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataRegistro;

  @UpdateTimestamp
  @Column(name = "data_ultima_atualizacao_companhia", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataAtualizacao;
}
