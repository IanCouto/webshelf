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

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numero_paginas")
    private Integer numero_paginas;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "generos")
    private String generos;

    @Column(name = "resumo")
    private String resumo;

    @Column(name = "img_base64")
    private String img_base64;

}
