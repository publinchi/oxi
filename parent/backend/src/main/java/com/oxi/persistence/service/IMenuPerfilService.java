package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.MenuPerfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMenuPerfilService extends IOperations<MenuPerfil> {

    Page<MenuPerfil> findPaginated(Pageable pageable);

}
