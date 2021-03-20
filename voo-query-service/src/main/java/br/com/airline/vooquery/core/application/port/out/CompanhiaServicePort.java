package br.com.airline.vooquery.core.application.port.out;

import br.com.airline.vooquery.core.domain.Voo;
import java.util.UUID;

public interface CompanhiaServicePort {

  Voo buscarInformacoesAdicionais(UUID companhia, Integer rota, String aeronave);
}