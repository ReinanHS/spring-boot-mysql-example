package com.reinanhs.gestorprojetos.entitys;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
