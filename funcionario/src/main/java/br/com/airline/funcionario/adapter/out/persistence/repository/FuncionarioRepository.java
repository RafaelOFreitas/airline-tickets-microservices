package br.com.airline.funcionario.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.airline.funcionario.adapter.out.persistence.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, UUID>{

}
