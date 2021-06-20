package com.reinanhs.gestorprojetos.entitys.cliente;

import com.reinanhs.gestorprojetos.entitys.helpers.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cliente extends Pessoa {

}
