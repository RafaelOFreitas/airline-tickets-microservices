package br.com.airline.companhia.adapter.out.persistence.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "rota")
@Table(name = "tb_rota")
public class RotaEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rota")
  private Integer id;

  @Column(name = "origem_rota", nullable = false)
  private String origem;

  @Column(name = "destino_rota", nullable = false)
  private String destino;

  @CreationTimestamp
  @Column(name = "data_registro_rota", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataRegistro;

  @UpdateTimestamp
  @Column(name = "data_ultima_atualizacao_rota", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataAtualizacao;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_companhia", nullable = false)
  private CompanhiaEntity companhia;

  @OneToMany(mappedBy = "rota", fetch = FetchType.LAZY)
  private Set<AeronaveEntity> aeronaves = new HashSet<>();

  public void addAeronave(AeronaveEntity aeronave) {
    this.aeronaves.add(aeronave);
    aeronave.setRota(this);
  }

  public void addAeronaves(Set<AeronaveEntity> aeronaves) {
    aeronaves.forEach(this::addAeronave);
  }
}
