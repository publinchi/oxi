package com.oxi.persistence.service.impl;

import com.google.common.collect.Lists;
import com.oxi.persistence.dao.INotificacionDao;
import com.oxi.persistence.model.Notificacion;
import com.oxi.persistence.service.INotificacionService;
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
public class NotificacionService extends AbstractService<Notificacion> implements INotificacionService {

    @Autowired
    private INotificacionDao dao;

    public NotificacionService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Notificacion, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Notificacion> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Notificacion> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
