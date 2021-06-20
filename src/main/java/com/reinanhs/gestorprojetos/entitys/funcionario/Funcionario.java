package com.reinanhs.gestorprojetos.entitys.funcionario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reinanhs.gestorprojetos.entitys.cargo.Cargo;
import com.reinanhs.gestorprojetos.entitys.helpers.Pessoa;
import com.reinanhs.gestorprojetos.entitys.projeto.Projeto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Funcionario extends Pessoa {
    @Column(nullable = false, name = "data_admissacao")
    @NotNull(message = "O campo data de admissão é obrigatório")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate dataAdmissao;

    @Column(name = "data_demissao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate dataDemissao;

    @ManyToOne
    @JoinColumn(name = "cargo_id_fk", nullable = false)
    @NotNull(message = "O campo cargo é obrigatório")
    protected Cargo cargo;

    @ManyToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    @JsonIgnore
    protected List<Projeto> projetos;
}
