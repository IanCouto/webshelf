package com.br.model;

import com.br.enumerator.EstadoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity(name = "livros")
public class LivroModel {
    @Id
    private int id;
    private EstadoEnum estado;
    private boolean possui;
    private int avaliacao;
    private int numero_paginas;
    private String autor;
    private String editora;
    private String generos;
}
