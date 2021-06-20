package com.reinanhs.gestorprojetos.entitys.helpers;

import com.reinanhs.gestorprojetos.entitys.Entidade;
import com.reinanhs.gestorprojetos.enums.UF;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Endereco extends Entidade {
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo uf é obrigatório")
    protected UF uf;

    @Column(nullable = false, length = 80)
    @Size(min = 1, max = 80, message = "O tamanho inserido para a cidade é inválido")
    @NotBlank(message = "O campo cidade é obrigatório")
    protected String cidade;

    @Column(nullable = false, length = 100)
    @Size(min = 4, max = 100, message = "O tamanho inserido para a logradouro é inválido")
    @NotBlank(message = "O campo logradouro é inválido")
    protected String logradouro;

    @Column(nullable = false, length = 4)
    @Size(min = 1, max = 4, message = "O tamanho inserido para a número é inválido")
    @NotBlank(message = "O campo número é inválido")
    protected String numero;

    @Column(length = 100)
    protected String complemento;
}
