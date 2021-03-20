package br.com.airline.companhia.adapter.out.persistence.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AeronaveEntityId implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "matricula_aeronave")
  private String matricula;

  @Column(name = "fk_companhia")
  private UUID idCompanhia;

  @Column(name = "fk_rota")
  private Integer idRota;
}
