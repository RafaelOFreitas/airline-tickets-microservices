package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.CompanhiaServicePort;
import br.com.airline.companhia.core.application.port.out.CompanhiaPersistencePort;
import br.com.airline.companhia.core.domain.Companhia;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Log4j2
@Service
public class CompanhiaService implements CompanhiaServicePort {

  private final CompanhiaPersistencePort companhiaPersistence;

  @Override
  public Companhia adicionar(Companhia companhia) {
    companhia.ativar();

    return this.companhiaPersistence.adicionar(companhia);
  }

  @Override
  public Companhia buscar(UUID id) {
    return this.companhiaPersistence.buscar(id);
  }

  @Override
  public Companhia atualizar(UUID id, Companhia companhia) {
    return this.companhiaPersistence.atualizar(id, companhia);
  }

  @Override
  public void ativar(UUID id) {
    var companhia = this.companhiaPersistence.buscar(id);

    companhia.ativar();

    this.companhiaPersistence.atualizar(companhia);
  }

  @Override
  public void inativar(UUID id) {
    var companhia = this.companhiaPersistence.buscar(id);

    companhia.inativar();

    this.companhiaPersistence.atualizar(companhia);
  }
}
