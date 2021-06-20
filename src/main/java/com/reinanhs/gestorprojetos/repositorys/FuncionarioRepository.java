package com.reinanhs.gestorprojetos.repositorys;

import com.reinanhs.gestorprojetos.entitys.funcionario.Funcionario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Override
    @EntityGraph(attributePaths = {"endereco", "cargo"})
    List<Funcionario> findAll();
}
