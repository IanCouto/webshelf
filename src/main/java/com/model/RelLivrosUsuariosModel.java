package com.model;

import com.dto.LivroRelDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@NamedNativeQuery(
        name = "get_livro_rel_dto",
        query = "SELECT * FROM livros " +
                "LEFT JOIN (SELECT rel.id as id_rel, l.id as id_livro " +
                "FROM rel_livro_usuario as rel " +
                "INNER JOIN livros as l ON l.id = rel.id_livro WHERE rel.id_usuario = :id_usuario) AS aux " +
                "ON livros.id = aux.id_livro",
        resultSetMapping = "livro_rel_dto"
)
@SqlResultSetMapping(
        name = "livro_rel_dto",
        classes = @ConstructorResult(
                targetClass = LivroRelDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "titulo", type = String.class),
                        @ColumnResult(name = "numero_paginas", type = Integer.class),
                        @ColumnResult(name = "autor", type = String.class),
                        @ColumnResult(name = "editora", type = String.class),
                        @ColumnResult(name = "generos", type = String.class),
                        @ColumnResult(name = "resumo", type = String.class),
                        @ColumnResult(name = "img_base64", type = String.class),
                        @ColumnResult(name = "id_rel", type = Integer.class),
                        @ColumnResult(name = "id_livro", type = Integer.class),
                }
        )
)

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
