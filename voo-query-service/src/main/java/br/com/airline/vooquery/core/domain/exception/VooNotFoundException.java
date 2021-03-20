package br.com.airline.vooquery.core.domain.exception;

import lombok.Getter;

@Getter
public class VooNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VooNotFoundException(String id) {
    super(String.format("Voo não pode ser encontrado com código: %s", id));
  }
}