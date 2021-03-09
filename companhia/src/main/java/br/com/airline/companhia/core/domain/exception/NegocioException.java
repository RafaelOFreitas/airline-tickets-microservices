package br.com.airline.companhia.core.domain.exception;

import lombok.Getter;

@Getter
public class NegocioException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NegocioException(String msg) {
    super(msg);
  }
}