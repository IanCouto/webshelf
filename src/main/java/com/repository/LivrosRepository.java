package com.repository;

import com.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<LivroModel, Long>{
    /**
     * Por meio do id do usuario, retorna a imagem do livro, o id e estado do relacionamento de todos
     * os livros que o usuario possui em sua prateleira
     * Consulta usada ao abrir a Prateleira
     * @param id_usuario
     * @return
     */
    @Query(value = "SELECT rlu.id,rlu.estado, img_base64 FROM livros\n" +
            "INNER JOIN rel_livro_usuario AS rlu ON rlu.id_livro  = livros.id\n" +
            "WHERE rlu.id_usuario = :id_usuario", nativeQuery = true)
    List<Object> allLivrosDoUsuario(@Param("id_usuario") int id_usuario);

    /**
     * Retorna todos os livros ainda desaprovados
     * @return
     */
    @Query(value = "SELECT * FROM livros\n" +
            "WHERE is_aprovado = false", nativeQuery = true)
    List<LivroModel> allLivrosDesaprovados();

    /**
     * Retorna a quantidade de livros
     * @return
     */
    @Query(value = "SELECT count(*) FROM livros\n", nativeQuery = true)
    int countAllLivros();

    /**
     * Retorna a quantidade de usuarios
     * @return
     */
    @Query(value = "SELECT count(*) FROM usuarios\n", nativeQuery = true)
    int countAllUsuarios();

    /**
     * Retorna a quantidade de livros em prateleiras
     * @return
     */
    @Query(value = "SELECT count(*) FROM rel_livro_usuario\n", nativeQuery = true)
    int countAllRelacionamentos();
}
