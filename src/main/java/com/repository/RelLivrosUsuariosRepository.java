package com.repository;

import com.model.RelLivrosUsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelLivrosUsuariosRepository extends JpaRepository<RelLivrosUsuariosModel, Long>{

}
