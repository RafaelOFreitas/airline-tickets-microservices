package br.com.airline.passagem.adapter.in.web.mapper;

import br.com.airline.passagem.adapter.in.web.dto.FormaPagamentoInput;
import br.com.airline.passagem.core.domain.FormaPagamento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FormaPagamentoMapper {

  public FormaPagamento toDomain(FormaPagamentoInput input) {
    FormaPagamento forma = new FormaPagamento();

    forma.setDescricao(input.getDescricao());

    return forma;
  }
}
