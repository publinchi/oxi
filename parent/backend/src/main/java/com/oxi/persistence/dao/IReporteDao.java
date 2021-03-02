package com.oxi.persistence.dao;

import com.oxi.persistence.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReporteDao extends JpaRepository<Reporte, Long> {

}