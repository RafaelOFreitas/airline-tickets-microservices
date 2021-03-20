package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Companhia;
import java.util.UUID;

public interface CompanhiaServicePort {

  Companhia adicionar(Companhia companhia);

  Companhia buscar(UUID id);

  Companhia atualizar(UUID id, Companhia companhia);

  void ativar(UUID id);

  void inativar(UUID id);
}
