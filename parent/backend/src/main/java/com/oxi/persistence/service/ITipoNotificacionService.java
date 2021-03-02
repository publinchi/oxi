package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.TipoNotificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITipoNotificacionService extends IOperations<TipoNotificacion> {

    Page<TipoNotificacion> findPaginated(Pageable pageable);

}
