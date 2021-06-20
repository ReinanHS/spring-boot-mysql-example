package com.reinanhs.gestorprojetos.entitys.helpers;

import com.reinanhs.gestorprojetos.entitys.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class Pessoa extends Entidade {
    @Column(nullable = false, length = 80)
    @Size(min = 2, max = 80, message = "O tamanho inserido para o nome é inválido")
    @NotBlank(message = "O campo nome é obrigatório")
    protected String nome;

    @Column(nullable = false, length = 14, unique = true)
    @Size(min = 11, max = 14, message = "O tamanho inserido para o cpf é inválido")
    @NotBlank(message = "O campo cpf é obrigatório")
    protected String cpf;

    @Column(nullable = false, length = 15)
    @Size(min = 11, max = 15, message = "O tamanho inserido para o telefone é inválido")
    @NotBlank(message = "O campo telefone é obrigatório")
    protected String telefone;

    @Column(nullable = false, length = 80, unique = true)
    @Size(min = 10, max = 80, message = "O tamanho inserido para o email é invalido")
    @NotBlank(message = "O campo email é obrigatório")
    protected String email;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "O campo data de nascimento é obrigatório")
    protected LocalDate dataNascimento;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk", nullable = false)
    @NotNull(message = "O campo endereco é obrigatório")
    protected Endereco endereco;
}
