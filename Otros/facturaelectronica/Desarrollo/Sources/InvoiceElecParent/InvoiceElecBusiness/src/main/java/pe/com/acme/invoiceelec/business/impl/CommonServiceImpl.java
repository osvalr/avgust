package pe.com.acme.invoiceelec.business.impl;

import org.springframework.stereotype.Service;

import pe.com.acme.invoiceelec.business.service.CommonService;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.NumeroDocQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.NumeroDocQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.NumeroDocQueryMapper;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class CommonServiceImpl extends MybatisRepositoryHelper implements CommonService {

	@Override
	public String obtenerCorrelativo(String id_empresa, String tipoDoc, String serie) throws Exception {
		NumeroDocQueryCriteria criteria = new NumeroDocQueryCriteria();
		criteria.setEmp_id(id_empresa);
		criteria.setTipdoc_id(tipoDoc);
		criteria.setNumf_serie(serie);
		
		NumeroDocQuery numeroDocQuery = this.selectOneByQuery(NumeroDocQueryMapper.class, criteria);
		
		return numeroDocQuery.getNum_correlativo();
	}

}
