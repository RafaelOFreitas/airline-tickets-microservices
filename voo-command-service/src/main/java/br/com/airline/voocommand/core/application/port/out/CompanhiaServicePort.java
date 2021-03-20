package br.com.airline.voocommand.core.application.port.out;

import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;

public interface CompanhiaServicePort {

  Voo buscarInformacoesAdicionais(UUID companhia, Integer rota, String aeronave);
}