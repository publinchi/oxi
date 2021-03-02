package com.oxi.persistence.dao;

import com.oxi.persistence.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuDao extends JpaRepository<Menu, Long> {

}