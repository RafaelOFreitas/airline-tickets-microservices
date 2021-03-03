package br.com.airline.passagem.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.airline.passagem.adapter.in.web.dto.PagamentoInput;
import br.com.airline.passagem.adapter.in.web.mapper.FormaPagamentoMapper;
import br.com.airline.passagem.adapter.in.web.mapper.UsuarioMapper;
import br.com.airline.passagem.core.application.service.PassagemService;
import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/")
public class PassagemController {
	
	private PassagemService passagemService;
	private UsuarioMapper usuarioMapper;
	private FormaPagamentoMapper formaPagamentoMapper;
	

	@PostMapping("/")
	public void comprar(@RequestBody PagamentoInput input) {
		log.info("Recebendo requisição para compra de passagem");
		Usuario usuario = usuarioMapper.toDomain(input.getUsuario());
		FormaPagamento forma = formaPagamentoMapper.toDomain(input.getFormaPagamento());
		passagemService.comprar(usuario, forma, input.getValor());
	}

}
