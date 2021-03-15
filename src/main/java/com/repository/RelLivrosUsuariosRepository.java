package com.repository;

import com.model.RelLivrosUsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelLivrosUsuariosRepository extends JpaRepository<RelLivrosUsuariosModel, Long>{

    /**
     * Por meio do id do usuário, retorna todos os livros cadastrados e
     * o id do relacionamento com o usuario, caso exista
     * Consulta usada na página de Descobrimento
     * @param id
     * @return
     */
    @Query(value = "SELECT * FROM livros \n" +
            "LEFT JOIN (SELECT rel.id as id_rel, l.id as id_livro \n" +
            "           FROM rel_livro_usuario as rel \n" +
            "           INNER JOIN livros as l ON l.id = rel.id_livro WHERE rel.id_usuario = :id) AS aux\n" +
            "           ON livros.id = aux.id_livro" +
            "           WHERE livros.is_aprovado = true", nativeQuery = true)
    List<Object> relAllLivrosPorUsuario(@Param("id") int id);

    /**
     * Por meio do id do relacionamento, retorna todos os atributos do livro contiado no relacionamento
     * Consulta usada na Prateleira, ao clicar no livro
     * @param id_rlu
     * @return
     */
    @Query(value = "SELECT l.*, rlu.id as id_rlu, rlu.estado, rlu.avaliacao  FROM rel_livro_usuario AS rlu \n" +
            "INNER JOIN livros AS l ON l.id = rlu.id_livro\n" +
            "WHERE rlu.id = :id_rlu", nativeQuery = true)
    Object livroVinculadoRelacionamento(@Param("id_rlu") int id_rlu);

}
