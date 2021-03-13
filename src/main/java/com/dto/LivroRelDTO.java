package com.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class LivroRelDTO implements Serializable {
    private int id;
    private String titulo;
    private Integer numero_paginas;
    private String autor;
    private String editora;
    private String generos;
    private String resumo;
    private String img_base64;
    private int id_rel;
    private int id_livro;

    public LivroRelDTO(){};

    public LivroRelDTO(int id, String titulo, Integer numero_paginas, String autor, String editora, String generos, String resumo, String img_base64, int id_rel, int id_livro) {
        this.id = id;
        this.titulo = titulo;
        this.numero_paginas = numero_paginas;
        this.autor = autor;
        this.editora = editora;
        this.generos = generos;
        this.resumo = resumo;
        this.img_base64 = img_base64;
        this.id_rel = id_rel;
        this.id_livro = id_livro;
    }


}
