package com.reinanhs.gestorprojetos.repositorys;

import com.reinanhs.gestorprojetos.entitys.projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
