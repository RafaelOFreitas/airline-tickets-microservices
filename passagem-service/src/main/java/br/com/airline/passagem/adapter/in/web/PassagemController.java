package br.com.airline.passagem.adapter.in.web;

import br.com.airline.passagem.adapter.in.web.dto.PagamentoInput;
import br.com.airline.passagem.adapter.in.web.mapper.FormaPagamentoMapper;
import br.com.airline.passagem.adapter.in.web.mapper.UsuarioMapper;
import br.com.airline.passagem.core.application.service.PassagemService;
import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/")
public class PassagemController {

  private final PassagemService passagemService;
  private final UsuarioMapper usuarioMapper;
  private final FormaPagamentoMapper formaPagamentoMapper;

  @PostMapping
  public void comprar(@RequestBody PagamentoInput input) {
    log.info("Recebendo requisição para compra de passagem");

    Usuario usuario = this.usuarioMapper.toDomain(input.getUsuario());

    FormaPagamento forma = this.formaPagamentoMapper.toDomain(input.getFormaPagamento());

    this.passagemService.comprar(usuario, forma, input.getValor());
  }
}
