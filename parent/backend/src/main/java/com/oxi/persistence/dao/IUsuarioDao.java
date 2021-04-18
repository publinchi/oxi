package com.oxi.persistence.dao;

import com.oxi.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    @Query("select u from usuario u where u.login = :login")
    Usuario findByLogin(@Param("login") String login);
}