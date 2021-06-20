package com.reinanhs.gestorprojetos.entitys.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reinanhs.gestorprojetos.entitys.helpers.Pessoa;
import com.reinanhs.gestorprojetos.entitys.projeto.Projeto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cliente extends Pessoa {
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnore
    protected List<Projeto> projetos;
}
