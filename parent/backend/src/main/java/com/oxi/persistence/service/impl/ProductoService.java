package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.dao.IProductoDao;
import com.oxi.persistence.model.Producto;
import com.oxi.persistence.service.IProductoService;
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
public class ProductoService extends AbstractService<Producto> implements IProductoService {

    @Autowired
    private IProductoDao dao;

    public ProductoService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Producto, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Producto> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
