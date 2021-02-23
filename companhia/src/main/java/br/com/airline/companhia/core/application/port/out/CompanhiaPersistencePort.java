package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Companhia;

public interface CompanhiaPersistencePort {

  Companhia adicionar(Companhia companhia);

  Companhia buscar(Integer id);

  Companhia atualizar(Integer id, Companhia companhia);
}
