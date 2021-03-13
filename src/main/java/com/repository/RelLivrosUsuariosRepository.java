package com.repository;

import com.model.RelLivrosUsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelLivrosUsuariosRepository extends JpaRepository<RelLivrosUsuariosModel, Long>{
    @Query(value = "SELECT * FROM livros \n" +
            "LEFT JOIN (SELECT rel.id as id_rel, l.id as id_livro \n" +
            "           FROM rel_livro_usuario as rel \n" +
            "           INNER JOIN livros as l ON l.id = rel.id_livro WHERE rel.id_usuario = :id) AS aux\n" +
            "           ON livros.id = aux.id_livro", nativeQuery = true)
    List<Object> relAllLivrosPorUsuario(@Param("id") int id);

}
