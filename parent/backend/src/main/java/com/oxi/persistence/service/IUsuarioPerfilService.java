package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.UsuarioPerfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioPerfilService extends IOperations<UsuarioPerfil> {

    Page<UsuarioPerfil> findPaginated(Pageable pageable);

}
