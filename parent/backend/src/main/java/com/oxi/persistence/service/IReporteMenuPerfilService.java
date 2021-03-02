package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.ReporteMenuPerfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReporteMenuPerfilService extends IOperations<ReporteMenuPerfil> {

    Page<ReporteMenuPerfil> findPaginated(Pageable pageable);

}
