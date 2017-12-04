package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.ICatalogoRepository;
import com.acme.util.HibernateRepositoryHelper;
import com.acme.jpa.domain.CatalogoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoRepository extends HibernateRepositoryHelper<CatalogoEntity, Integer> implements ICatalogoRepository {
}
