package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.Notificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INotificacionService extends IOperations<Notificacion> {

    Page<Notificacion> findPaginated(Pageable pageable);

}
