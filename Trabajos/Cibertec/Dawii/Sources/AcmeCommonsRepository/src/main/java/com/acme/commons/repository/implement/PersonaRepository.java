package com.acme.commons.repository.implement;

import com.acme.commons.repository.service.IPersonaRepository;
import com.acme.jpa.domain.PersonaEntity;
import com.acme.util.HibernateRepositoryHelper;
import org.springframework.stereotype.Repository;

/**
 * Created by JRaffo on 15/10/15.
 */

@Repository
public class PersonaRepository extends HibernateRepositoryHelper<PersonaEntity,Integer> implements IPersonaRepository {
}
