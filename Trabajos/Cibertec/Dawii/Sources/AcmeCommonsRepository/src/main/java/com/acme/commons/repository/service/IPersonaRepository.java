package com.acme.commons.repository.service;

import com.acme.jpa.domain.PersonaEntity;
import com.acme.util.IHibernateRepositoryHelper;

/**
 * Created by JRaffo on 15/10/15.
 */
public interface IPersonaRepository extends IHibernateRepositoryHelper<PersonaEntity,Integer> {
}
