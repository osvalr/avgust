package pe.com.coravi.domain.hibernate.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.com.coravi.domain.hibernate.domain.GuiaRemisionItem;

/**
 * Created by JRaffo on 23/03/17.
 */

@Repository
public interface GuiaRemisionItemRepository extends PagingAndSortingRepository<GuiaRemisionItem, Integer> {
}
