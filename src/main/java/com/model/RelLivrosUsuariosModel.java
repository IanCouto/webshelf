package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "rel_livro_usuario")
@Getter
@Setter
public class RelLivrosUsuariosModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_livro")
    private Long id_livro;

    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "avaliacao")
    private int avaliacao;




    public RelLivrosUsuariosModel(){}
}
