package com.oxi.persistence.dao;

import com.oxi.persistence.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioPerfilDao extends JpaRepository<UsuarioPerfil, Long> {

}