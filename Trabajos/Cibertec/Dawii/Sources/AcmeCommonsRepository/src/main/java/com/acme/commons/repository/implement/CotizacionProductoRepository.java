package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.ICotizacionProductoRepository;
import com.acme.jpa.domain.CotizacionProductoEntity;
import com.acme.util.HibernateRepositoryHelper;
import org.springframework.stereotype.Repository;

/**
 * Created by JRaffo on 15/10/15.
 */

@Repository
public class CotizacionProductoRepository extends HibernateRepositoryHelper<CotizacionProductoEntity,Integer> implements ICotizacionProductoRepository {
}
