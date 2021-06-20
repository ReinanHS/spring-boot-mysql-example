package com.reinanhs.gestorprojetos.repositorys;

import com.reinanhs.gestorprojetos.entitys.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
