package com.reinanhs.gestorprojetos.entitys.funcionario;

import com.reinanhs.gestorprojetos.entitys.cargo.Cargo;
import com.reinanhs.gestorprojetos.entitys.helpers.Pessoa;
import com.reinanhs.gestorprojetos.entitys.projeto.Projeto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Funcionario extends Pessoa {
    @Column(nullable = false, name = "data_admissacao")
    @NotBlank(message = "O campo data de admissão é obrigatório")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate dataAdmissao;

    @Column(name = "data_demissao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate dataDemissao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id_fk", nullable = false)
    protected Cargo cargo;

    @ManyToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    protected List<Projeto> projetos;
}
