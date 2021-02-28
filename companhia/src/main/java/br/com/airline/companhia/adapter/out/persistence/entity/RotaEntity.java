package br.com.airline.companhia.adapter.out.persistence.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class RotaEntity {

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
  private List<AeronaveEntity> aeronaves = new ArrayList<>();

  public void addAeronave(AeronaveEntity aeronave) {
    this.aeronaves.add(aeronave);
    aeronave.setRota(this);
  }

  public void addAeronaves(List<AeronaveEntity> aeronaves) {
    aeronaves.forEach(this::addAeronave);
  }
}
