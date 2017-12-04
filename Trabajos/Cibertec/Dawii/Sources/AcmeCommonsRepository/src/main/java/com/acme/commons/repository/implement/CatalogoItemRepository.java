package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.ICatalogoItemRepository;
import com.acme.jpa.domain.CatalogoItemEntity;
import com.acme.util.HibernateRepositoryHelper;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoItemRepository extends HibernateRepositoryHelper<CatalogoItemEntity, Integer> implements ICatalogoItemRepository {
}
