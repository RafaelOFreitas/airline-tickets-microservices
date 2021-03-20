package br.com.airline.companhia.adapter.out.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SecaoEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "classe_secao", nullable = false)
  private String classe;

  @Column(name = "quantidade_assento_secao", nullable = false)
  private Integer quantidadeAssento;

  @Column(name = "quantidade_fila_secao", nullable = false)
  private Integer quantidadeFila;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
