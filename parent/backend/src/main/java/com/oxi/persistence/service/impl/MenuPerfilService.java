package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.dao.IMenuPerfilDao;
import com.oxi.persistence.model.MenuPerfil;
import com.oxi.persistence.service.IMenuPerfilService;
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
public class MenuPerfilService extends AbstractService<MenuPerfil> implements IMenuPerfilService {

    @Autowired
    private IMenuPerfilDao dao;

    public MenuPerfilService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<MenuPerfil, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<MenuPerfil> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<MenuPerfil> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
