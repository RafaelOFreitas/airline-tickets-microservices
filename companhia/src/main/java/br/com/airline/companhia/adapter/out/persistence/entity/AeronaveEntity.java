package br.com.airline.companhia.adapter.out.persistence.entity;

import br.com.airline.companhia.core.domain.Status;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class AeronaveEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @EmbeddedId
  private AeronaveEntityId id;

  @Column(name = "modelo_aeronave", nullable = false)
  private String modelo;

  @Column(name = "tipo_aeronave", nullable = false)
  private String tipo;

  @Enumerated(EnumType.STRING)
  @Column(name = "status_aeronave", nullable = false)
  private Status status;

  @CreationTimestamp
  @Column(name = "data_registro_aeronave", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataRegistro;

  @UpdateTimestamp
  @Column(name = "data_ultima_atualizacao_aeronave", nullable = false, columnDefinition = "timestampTz")
  private OffsetDateTime dataAtualizacao;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "tb_secao", joinColumns = {
      @JoinColumn(name = "fk_companhia"),
      @JoinColumn(name = "fk_rota"),
      @JoinColumn(name = "matricula_aeronave")
  })
  private Set<SecaoEntity> secoes = new LinkedHashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_companhia", referencedColumnName = "id_companhia", insertable = false, updatable = false)
  private CompanhiaEntity companhia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_rota", referencedColumnName = "id_rota", insertable = false, updatable = false)
  private RotaEntity rota;
}
