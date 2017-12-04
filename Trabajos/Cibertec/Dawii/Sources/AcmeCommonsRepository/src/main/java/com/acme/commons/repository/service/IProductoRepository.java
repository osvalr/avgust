package com.acme.commons.repository.service;

import com.acme.jpa.domain.PersonaEntity;
import com.acme.jpa.domain.ProductoEntity;
import com.acme.util.IHibernateRepositoryHelper;

/**
 * Created by JRaffo on 15/10/15.
 */
public interface IProductoRepository extends IHibernateRepositoryHelper<ProductoEntity,Integer> {
}
