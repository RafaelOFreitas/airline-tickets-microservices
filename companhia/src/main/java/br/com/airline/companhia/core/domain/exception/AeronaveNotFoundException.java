package br.com.airline.companhia.core.domain.exception;

import java.util.UUID;
import lombok.Getter;

@Getter
public class AeronaveNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  AeronaveNotFoundException(String message) {
    super(message);
  }

  public AeronaveNotFoundException(UUID id) {
    this(String.format("Aeronave não pode ser encontrada com o código: %s", id));
  }
}