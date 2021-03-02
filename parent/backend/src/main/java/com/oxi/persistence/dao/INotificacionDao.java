package com.oxi.persistence.dao;

import com.oxi.persistence.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificacionDao extends JpaRepository<Notificacion, Long> {

}