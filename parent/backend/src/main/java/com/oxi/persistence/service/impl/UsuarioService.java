package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.dao.IUsuarioDao;
import com.oxi.persistence.model.Usuario;
import com.oxi.persistence.service.IUsuarioService;
import com.oxi.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService extends AbstractService<Usuario> implements IUsuarioService {

    @Autowired
    private IUsuarioDao dao;

    public UsuarioService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Usuario, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Usuario> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
