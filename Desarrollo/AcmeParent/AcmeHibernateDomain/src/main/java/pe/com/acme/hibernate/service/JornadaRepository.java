package pe.com.acme.hibernate.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.com.acme.hibernate.domain.Jornada;
import pe.com.acme.hibernate.domain.JornadaPK;

/**
 * Created by JRaffo on 23/03/17.
 */
@Repository
public interface JornadaRepository extends PagingAndSortingRepository<Jornada,JornadaPK> {

}
