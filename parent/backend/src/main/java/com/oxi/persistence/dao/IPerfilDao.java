package com.oxi.persistence.dao;

import com.oxi.persistence.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilDao extends JpaRepository<Perfil, Long> {

}