package com.reinanhs.gestorprojetos.entitys.projeto;

import com.reinanhs.gestorprojetos.entitys.Entidade;
import com.reinanhs.gestorprojetos.entitys.cliente.Cliente;
import com.reinanhs.gestorprojetos.entitys.funcionario.Funcionario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Projeto extends Entidade {
    @Column(nullable = false, length = 80)
    @Size(min = 5, max = 80, message = "O tamanho inserido para o nome é inválido")
    @NotBlank(message = "O campo nome é obrigatório")
    protected String nome;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(min = 10, message = "O tamanho inserido para a descrição é inválido")
    @NotBlank(message = "O campo descrição é obrigatório")
    protected String descricao;

    @Column(nullable = false, name = "data_inicio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotBlank(message = "O campo data inicio é obrigatório")
    protected LocalDate dataInicio;

    @Column(name = "data_fim")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "cliente_id_fk", nullable = false)
    @NotBlank(message = "O campo cliente é obrigatório")
    protected Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "lider_id_fk", nullable = false)
    @NotBlank(message = "O campo lider é obrigatório")
    protected Funcionario lider;

    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "##,#0.00")
    @NotBlank(message = "O campo orcamento é obrigatório")
    protected BigDecimal orcamento;

    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "##,#0.00")
    @NotBlank(message = "O campo gastos é obrigatório")
    protected BigDecimal gastos;

    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(name = "projeto_id_fk", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id_fk", nullable = false)
    )
    protected List<Funcionario> equipe;
}
