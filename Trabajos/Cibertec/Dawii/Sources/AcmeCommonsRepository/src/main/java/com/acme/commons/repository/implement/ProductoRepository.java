package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.IPersonaRepository;
import com.acme.commons.repository.service.IProductoRepository;
import com.acme.jpa.domain.PersonaEntity;
import com.acme.jpa.domain.ProductoEntity;
import com.acme.util.HibernateRepositoryHelper;
import org.springframework.stereotype.Repository;

/**
 * Created by JRaffo on 15/10/15.
 */

@Repository
public class ProductoRepository extends HibernateRepositoryHelper<ProductoEntity,Integer> implements IProductoRepository {
}

