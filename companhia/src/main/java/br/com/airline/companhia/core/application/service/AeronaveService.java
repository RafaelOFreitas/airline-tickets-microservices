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
  public Aeronave adicionar(UUID idCompanhia, Integer idRota, Aeronave aeronave) {
    aeronave.ativar();

    return this.aeronavePersistence.adicionar(idCompanhia, idRota, aeronave);
  }

  @Override
  public Aeronave buscar(UUID idCompanhia, Integer idRota, String matricula) {
    return this.aeronavePersistence.buscar(idCompanhia, idRota, matricula);
  }

  @Override
  public Aeronave atualizar(UUID idCompanhia, Integer idRota, Aeronave aeronave) {
    return this.aeronavePersistence.atualizar(idCompanhia, idRota, aeronave);
  }

  @Override
  public void ativar(UUID idCompanhia, Integer idRota, String matricula) {
    var aeronave = this.aeronavePersistence.buscar(idCompanhia, idRota, matricula);

    aeronave.ativar();

    this.aeronavePersistence.salvar(idCompanhia, idRota, aeronave);
  }

  @Override
  public void inativar(UUID idCompanhia, Integer idRota, String matricula) {
    var aeronave = this.aeronavePersistence.buscar(idCompanhia, idRota, matricula);

    aeronave.inativar();

    this.aeronavePersistence.salvar(idCompanhia, idRota, aeronave);
  }
}
