package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.dao.IPerfilDao;
import com.oxi.persistence.model.Perfil;
import com.oxi.persistence.service.IPerfilService;
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
public class PerfilService extends AbstractService<Perfil> implements IPerfilService {

    @Autowired
    private IPerfilDao dao;

    public PerfilService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Perfil, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Perfil> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Perfil> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
