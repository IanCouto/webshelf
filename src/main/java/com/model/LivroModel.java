package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity(name = "livros")
@Getter
@Setter
public class LivroModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "avaliacao")
    private int avaliacao;

    @Column(name = "numero_paginas")
    private int numero_paginas;

    @Column(name = "estado")
    private String estado;

    @Column(name = "possui")
    private boolean possui;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "generos")
    private String generos;

    @Column(name = "descricao")
    private String descricao;

}
