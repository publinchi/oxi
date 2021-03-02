package com.oxi.persistence.dao;

import com.oxi.persistence.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Long> {

}