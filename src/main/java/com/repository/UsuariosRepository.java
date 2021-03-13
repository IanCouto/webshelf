package com.repository;

import com.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE nome = :nome AND senha = :senha", nativeQuery = true)
    UsuarioModel procurarUsuario(@Param("nome") String nome,@Param("senha") String senha);
}
