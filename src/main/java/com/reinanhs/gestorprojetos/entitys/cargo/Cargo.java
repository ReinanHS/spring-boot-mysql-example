package com.reinanhs.gestorprojetos.entitys.cargo;

import com.reinanhs.gestorprojetos.entitys.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cargo extends Entidade {
    @Column(nullable = false, length = 40, unique = true)
    @Size(min = 2, max = 40, message = "O tamanho inserido para o nome é inválido")
    @NotBlank(message = "O campo nome é obrigatório")
    protected String nome;

    @Column(name = "gerente")
    protected boolean isGerente = false;
}
