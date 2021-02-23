package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.CompanhiaServicePort;
import br.com.airline.companhia.core.application.port.out.CompanhiaPersistencePort;
import br.com.airline.companhia.core.domain.Companhia;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanhiaService implements CompanhiaServicePort {

  private final CompanhiaPersistencePort companhiaPersistence;

  @Override
  public Companhia adicionar(Companhia companhia) {
    return this.companhiaPersistence.adicionar(companhia);
  }

  @Override
  public Companhia buscar(Integer id) {
    return this.companhiaPersistence.buscar(id);
  }

  @Override
  public Companhia atualizar(Integer id, Companhia companhia) {
    return this.companhiaPersistence.atualizar(id, companhia);
  }

  @Transactional
  @Override
  public void ativar(Integer id) {
    var companhia = this.buscar(id);

    companhia.ativarCompanhia();
  }

  @Transactional
  @Override
  public void inativar(Integer id) {
    var companhia = this.buscar(id);

    companhia.inativarCompanhia();
  }
}
