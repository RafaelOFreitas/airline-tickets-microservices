package br.com.airline.passagem.adapter.in.web.mapper;

import br.com.airline.passagem.adapter.in.web.dto.UsuarioInput;
import br.com.airline.passagem.core.domain.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioMapper {

  public Usuario toDomain(UsuarioInput input) {
    Usuario usuario = new Usuario();

    usuario.setNome(input.getNome());

    usuario.setCpf(input.getCpf());

    return usuario;
  }
}
