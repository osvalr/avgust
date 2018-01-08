package pe.kapcom.iemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.kapcom.iemail.repository.dto.CustomerMailQuery;
import pe.kapcom.iemail.repository.dto.CustomerMailQueryCriteria;
import pe.kapcom.iemail.repository.dto.UspUpdateSunatFlagMail;
import pe.kapcom.iemail.repository.mapper.CustomerMailQueryMapper;
import pe.kapcom.iemail.repository.mapper.UspUpdateSunatFlagMailMapper;

import java.util.List;

/**
 * Created by JRaffo on 8/02/17.
 */

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerMailQueryMapper customerMailQueryMapper;

    @Autowired
    UspUpdateSunatFlagMailMapper uspUpdateSunatFlagMailMapper;

    public List<CustomerMailQuery> get(){

        List<CustomerMailQuery> list = null;

        CustomerMailQueryCriteria criteria = new CustomerMailQueryCriteria();

        list = customerMailQueryMapper.getListQueryByCriteria(criteria);

        return list;

    }

    @Transactional
    public void setFlag(String p_tipdoc,String p_nrodoc, String p_status){

        UspUpdateSunatFlagMail criteria = new UspUpdateSunatFlagMail();
        criteria.setP_tipdoc(p_tipdoc);
        criteria.setP_nrodoc(p_nrodoc);
        criteria.setP_status(p_status);

        uspUpdateSunatFlagMailMapper.executeCallable(criteria);
    }
}
