package com.repository;

import com.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioModel, Long> {

    //    @Query("select u from usuarios u where u.nome = :nome")
    @Query(value = "SELECT * FROM usuarios u where u.nome = :nome", nativeQuery = true)
    Collection<UsuarioModel> findAllActiveUsersNative();

    @Query(value = "SELECT u FROM usuarios u where u.nome = :nome")
    UsuarioModel findByNome(@Param("nome") String nome);
}
