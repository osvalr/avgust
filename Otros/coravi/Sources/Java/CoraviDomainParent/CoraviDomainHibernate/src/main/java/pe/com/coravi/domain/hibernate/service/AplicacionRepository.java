package pe.com.coravi.domain.hibernate.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.com.coravi.domain.hibernate.domain.Aplicacion;

/**
 * Created by JRaffo on 23/03/17.
 */
@Repository
public interface AplicacionRepository extends PagingAndSortingRepository<Aplicacion,Integer> {

}
