package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Companhia;
import java.util.UUID;

public interface CompanhiaPersistencePort {

  Companhia adicionar(Companhia companhia);

  Companhia buscar(UUID id);

  Companhia atualizar(UUID id, Companhia companhia);

  void atualizar(Companhia companhia);
}
