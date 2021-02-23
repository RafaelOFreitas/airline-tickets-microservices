package br.com.airline.companhia.core.domain.exception;

import java.util.UUID;
import lombok.Getter;

@Getter
public class RotaNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  RotaNotFoundException(String message) {
    super(message);
  }

  public RotaNotFoundException(UUID id) {
    this(String.format("Rota não pode ser encontrada com o código: %s", id));
  }
}