package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService extends IOperations<Usuario> {

    Page<Usuario> findPaginated(Pageable pageable);

    Usuario findByLogin(final String login);

}
