package br.com.airline.voocommand.core.application.port.out;

import br.com.airline.voocommand.core.domain.Voo;

public interface CompanhiaServicePort {

  Voo getInfo(Voo voo);
}