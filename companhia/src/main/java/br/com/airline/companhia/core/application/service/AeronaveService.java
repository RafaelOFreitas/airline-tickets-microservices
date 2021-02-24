package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.AeronaveServicePort;
import br.com.airline.companhia.core.application.port.out.AeronavePersistencePort;
import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AeronaveService implements AeronaveServicePort {

  private final AeronavePersistencePort aeronavePersistence;

  @Override
  public Aeronave adicionar(Aeronave aeronave) {
    aeronave.ativar();

    return this.aeronavePersistence.adicionar(aeronave);
  }

  @Override
  public Aeronave buscar(UUID id) {
    return this.aeronavePersistence.buscar(id);
  }

  @Override
  public Aeronave atualizar(UUID id, Aeronave aeronave) {
    return this.aeronavePersistence.atualizar(id, aeronave);
  }

  @Override
  public void ativar(UUID id) {
    var aeronave = this.aeronavePersistence.buscar(id);

    aeronave.ativar();

    this.aeronavePersistence.atualizar(aeronave);
  }

  @Override
  public void inativar(UUID id) {
    var aeronave = this.aeronavePersistence.buscar(id);

    aeronave.inativar();

    this.aeronavePersistence.atualizar(aeronave);
  }
}
