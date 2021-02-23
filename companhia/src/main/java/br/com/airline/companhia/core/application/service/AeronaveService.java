package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.AeronaveServicePort;
import br.com.airline.companhia.core.application.port.out.AeronavePersistencePort;
import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AeronaveService implements AeronaveServicePort {

  private final AeronavePersistencePort aeronavePersistence;

  @Override
  public Aeronave adicionar(Aeronave aeronave) {
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

  @Transactional
  @Override
  public void ativarAeronave(UUID id) {
    var aeronave = this.buscar(id);

    aeronave.ativarAeronave();
  }

  @Transactional
  @Override
  public void inativarAeronave(UUID id) {
    var aeronave = this.buscar(id);

    aeronave.inativarAeronave();
  }
}
