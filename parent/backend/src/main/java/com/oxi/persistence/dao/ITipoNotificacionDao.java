package com.oxi.persistence.dao;

import com.oxi.persistence.model.TipoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoNotificacionDao extends JpaRepository<TipoNotificacion, Long> {

}