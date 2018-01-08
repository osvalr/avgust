package pe.com.acme.inavi.business.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.acme.domain.mybatis.mapper.GuiaMapper;
import pe.com.acme.domain.mybatis.mapper.GuiaSaldoMapper;
import pe.com.acme.domain.mybatis.model.Guia;
import pe.com.acme.domain.mybatis.model.GuiaKey;
import pe.com.acme.domain.mybatis.model.GuiaSaldo;
import pe.com.acme.domain.mybatis.model.GuiaSaldoExample;
import pe.com.acme.inavi.business.service.MttoSaldoService;
import pe.com.acme.inavi.business.util.InaviConstantes;
import pe.com.acme.query.mybatis.mapper.GuiaQueryMapper;
import pe.com.acme.query.mybatis.model.GuiaQuery;
import pe.com.acme.query.mybatis.model.GuiaQueryCriteria;
import pe.com.acme.query.mybatis.model.GuiaSaldoQuery;
import pe.com.acme.query.mybatis.model.SaldoPorGuiaQuery;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class MttoSaldoServiceImpl extends MybatisRepositoryHelper implements MttoSaldoService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(SaldoPorGuiaQuery model) throws Exception {
			
        this.insertNewRecordsGuiaSaldoQuery(model.getListGuiaSaldoQuery(), model.getId_guia());
        this.updateModifiedRecordsGuiaSaldoQuery(model.getListGuiaSaldoQuery());
        this.removeRecordsGuiaSaldoQuery(model.getListGuiaSaldoQuery(), true);
        
    	GuiaKey guiaKey = new GuiaKey();
    	guiaKey.setId_guia(model.getId_guia());
    	Guia guia = this.selectByPrimaryKey(GuiaMapper.class, guiaKey);
    	
    	GuiaSaldoExample guiaSaldoExample = new GuiaSaldoExample();
    	guiaSaldoExample.createCriteria().andId_guiaEqualTo(guia.getId_guia());
    	
    	List<GuiaSaldo> listGuiaSaldo = this.selectByExample(GuiaSaldoMapper.class, guiaSaldoExample);
    	
    	double totalSaldado = this.getTotalSaldado(listGuiaSaldo);
    	
        if(totalSaldado >= guia.getTotal_importe().doubleValue()){
        	guia.setId_estado(InaviConstantes.ESTADO_GUIA_VENTA_SALDADO);
        }else{
        	guia.setId_estado(InaviConstantes.ESTADO_GUIA_VENTA_POR_SALDAR);
        }
        
        this.updateByPrimaryKey(GuiaMapper.class, guia);
	}
	
	@Override
	public List<GuiaQuery> list(GuiaQueryCriteria criteria) throws Exception {
		List<GuiaQuery> list = this.selectByQuery(GuiaQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(GuiaQueryCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(GuiaQueryMapper.class, criteria);
		return count;
	}
	
    @Transactional(rollbackForClassName = {"Exception"})
    private void insertNewRecordsGuiaSaldoQuery(List<GuiaSaldoQuery> listGuiaSaldoQuery, Integer id) throws Exception{

        for(GuiaSaldoQuery guiaSaldoQuery : listGuiaSaldoQuery){

            if(guiaSaldoQuery.isNewEntry()){
                guiaSaldoQuery.setId_guia(id);
                GuiaSaldo guiaSaldo = dtoUtil.copyBean(guiaSaldoQuery, GuiaSaldo.class);                
                this.insertSelective(GuiaSaldoMapper.class, guiaSaldo);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void updateModifiedRecordsGuiaSaldoQuery(List<GuiaSaldoQuery> listGuiaSaldoQuery) throws Exception{

        for(GuiaSaldoQuery guiaSaldoQuery : listGuiaSaldoQuery){

            if(guiaSaldoQuery.isUpdatedRecord()){
            	GuiaSaldo guiaSaldo = dtoUtil.copyBean(guiaSaldoQuery, GuiaSaldo.class);
            	this.updateByPrimaryKeySelective(GuiaSaldoMapper.class, guiaSaldo);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void removeRecordsGuiaSaldoQuery(List<GuiaSaldoQuery> listGuiaSaldoQuery, boolean onlyFlag) throws Exception{

    	for(GuiaSaldoQuery guiaSaldoQuery : listGuiaSaldoQuery){

            if(onlyFlag){
                if(guiaSaldoQuery.isRemovedRecord()){
                    GuiaSaldo guiaSaldo = dtoUtil.copyBean(guiaSaldoQuery, GuiaSaldo.class);
                    this.deleteByPrimaryKey(GuiaSaldoMapper.class, guiaSaldo);
                }
            }else{
            	GuiaSaldo guiaSaldo = dtoUtil.copyBean(guiaSaldoQuery, GuiaSaldo.class);
                this.deleteByPrimaryKey(GuiaSaldoMapper.class, guiaSaldo);
            }

        }

    }	
    
    public double getTotalSaldado(List<GuiaSaldo> list){
    	
    	double total = 0;
    	
		for (GuiaSaldo guiaSaldo : list) {
			if(guiaSaldo.getId_estado().intValue() == 1){
				total = total + guiaSaldo.getMonto_amortizado().doubleValue();
			}
		}
		
		return total;
    }
	
}
