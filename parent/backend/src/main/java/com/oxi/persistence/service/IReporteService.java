package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.Reporte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReporteService extends IOperations<Reporte> {

    Page<Reporte> findPaginated(Pageable pageable);

}
