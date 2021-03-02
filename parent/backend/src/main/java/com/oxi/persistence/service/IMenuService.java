package com.oxi.persistence.service;

import com.oxi.persistence.IOperations;
import com.oxi.persistence.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMenuService extends IOperations<Menu> {

    Page<Menu> findPaginated(Pageable pageable);

}
