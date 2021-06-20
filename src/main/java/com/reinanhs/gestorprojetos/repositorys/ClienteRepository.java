package com.reinanhs.gestorprojetos.repositorys;

import com.reinanhs.gestorprojetos.entitys.cliente.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Override
    @EntityGraph(attributePaths = {"endereco"})
    List<Cliente> findAll();
}
