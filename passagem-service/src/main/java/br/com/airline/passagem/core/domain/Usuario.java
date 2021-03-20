package br.com.airline.passagem.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Usuario {

  private String cpf;
  private String nome;

  @Override
  public String toString() {
    return "Usuario [cpf=" + cpf + ", nome=" + nome + "]";
  }
}
