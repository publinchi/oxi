package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.Perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPerfilService extends IOperations<Perfil> {

    Page<Perfil> findPaginated(Pageable pageable);

}
