package br.com.airline.funcionario.core.application.port.out;

import br.com.airline.funcionario.core.domain.Funcionario;
import java.util.List;
import java.util.UUID;

public interface FuncionarioPersistencePort {

  Funcionario adicionar(Funcionario funcionario);

  Funcionario atualizar(UUID id, Funcionario funcionario);

  void excluir(UUID id);

  Funcionario buscar(UUID id);

  List<Funcionario> buscarTodos();
}
