package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.service.IReporteService;
import com.oxi.persistence.dao.IReporteDao;
import com.oxi.persistence.model.Reporte;
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
public class ReporteService extends AbstractService<Reporte> implements IReporteService {

    @Autowired
    private IReporteDao dao;

    public ReporteService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Reporte, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Reporte> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Reporte> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
