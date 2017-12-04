package pe.com.acme.hibernate.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.com.acme.hibernate.domain.SerieNumeroDoc;

/**
 * Created by JRaffo on 23/03/17.
 */

@Repository
public interface SerieNumeroDocRepository extends PagingAndSortingRepository<SerieNumeroDoc, Integer> {
}
