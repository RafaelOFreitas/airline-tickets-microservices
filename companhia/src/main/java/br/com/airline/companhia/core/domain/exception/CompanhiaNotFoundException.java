package br.com.airline.companhia.core.domain.exception;

import java.util.UUID;
import lombok.Getter;

@Getter
public class CompanhiaNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  CompanhiaNotFoundException(String message) {
    super(message);
  }

  public CompanhiaNotFoundException(UUID id) {
    this(String.format("Companhia não pode ser encontrada com o código: %s", id));
  }
}