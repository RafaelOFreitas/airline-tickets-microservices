package br.com.airline.passagem.adapter.out.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntity {

  private String cpf;
  private String nome;

  @Override
  public String toString() {
    return "Usuario [cpf=" + cpf + ", nome=" + nome + "]";
  }
}
