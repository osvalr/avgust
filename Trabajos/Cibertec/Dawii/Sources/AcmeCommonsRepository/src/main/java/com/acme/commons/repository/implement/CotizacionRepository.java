package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.ICotizacionRepository;
import com.acme.jpa.domain.CotizacionEntity;
import com.acme.util.HibernateRepositoryHelper;
import org.springframework.stereotype.Repository;

/**
 * Created by JRaffo on 15/10/15.
 */

@Repository
public class CotizacionRepository extends HibernateRepositoryHelper<CotizacionEntity,Integer> implements ICotizacionRepository{
}
