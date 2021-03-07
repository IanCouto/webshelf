package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity(name = "rel_livro_usuario")
@Getter
@Setter

public class RelLivrosUsuariosModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "id_livro")
    private String id_livro;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "avaliacao")
    private int avaliacao;

}
