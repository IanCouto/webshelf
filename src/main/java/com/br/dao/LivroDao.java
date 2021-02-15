package com.br.dao;

import com.br.enumerator.EstadoEnum;
import com.br.model.LivroModel;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroDao extends JpaRepository<LivroModel, Long>{
/*
    @Query(value ="insert into livros (estado, possui, avaliacao, numero_paginas, autor, editora, generos, descricao) " +
            "values (:estado, :possui, :avaliacao, :numero_paginas, :autor, :editora, :generos, :descricao)",nativeQuery = true)
    public boolean adicionaLivro(@Param("estado") EstadoEnum estado, @Param("possui") boolean possui,
                                 @Param("avaliacao") int avaliacao, @Param("numero_paginas") int numero_paginas,
                                 @Param("autor") String autor, @Param("editora") String editora,
                                 @Param("generos") String generos, @Param("descricao") String descricao){

        if(true){
            return true;
        }else{
            return false;
        }


    }
*/

}
