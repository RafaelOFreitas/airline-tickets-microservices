package br.com.airline.companhia.adapter.out.persistence.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class CompanhiaEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_companhia")
  private UUID id;

  @Column(name = "nome_companhia", nullable = false)
  private String nome;

  @Column(name = "cnpj_companhia", nullable = false)
  private String cnpj;

  @Column(name = "status_companhia", nullable = false)
  private String status;

  @CreationTimestamp
  @Column(name = "data_registro_companhia", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataRegistro;

  @UpdateTimestamp
  @Column(name = "data_ultima_atualizacao_companhia", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataAtualizacao;

  @OneToMany(mappedBy = "companhia", fetch = FetchType.LAZY)
  private Set<RotaEntity> rotas = new HashSet<>();

  public void addRota(RotaEntity rota) {
    this.rotas.add(rota);
    rota.setCompanhia(this);
  }

  public void addRotas(Set<RotaEntity> rotas) {
    rotas.forEach(this::addRota);
  }
}
