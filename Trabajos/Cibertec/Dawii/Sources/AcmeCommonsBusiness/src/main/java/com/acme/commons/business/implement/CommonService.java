package com.acme.commons.business.implement;

import com.acme.commons.business.service.ICommonService;
import com.acme.commons.business.service.IGestionarCatalogoService;
import com.acme.util.MybatisRepositoryHelper;
import org.springframework.stereotype.Service;

/**
 * Created by JRaffo on 10/26/15.
 */

@Service
public class CommonService extends MybatisRepositoryHelper implements ICommonService {
}
