package pe.com.jrtotem.app.generator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.dto.PropertyDto;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInput;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelOutput;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelOutputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.Property;
import pe.com.jrtotem.app.generator.mybatis.domain.PropertyExample;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.mybatis.mapper.ModelInputMapper;
import pe.com.jrtotem.app.generator.mybatis.mapper.ModelOutputMapper;
import pe.com.jrtotem.app.generator.mybatis.mapper.PropertyMapper;
import pe.com.jrtotem.app.generator.mybatis.mapper.SubModelInputMapper;
import pe.com.jrtotem.app.generator.util.ConstanUtil;
import pe.com.jrtotem.app.generator.util.DtoUtil;
import pe.com.jrtotem.app.generator.util.MybatisRepositoryHelper;

@Service
public class ModelInputCrudService extends MybatisRepositoryHelper implements IModelInputCrudService {

	@Autowired
	private DtoUtil dtoUtil;
	
	@Autowired
	ModelOutputMapper modelOutputMapper;
	
	@Autowired
	PropertyMapper propertyMapper;
	
	@Autowired
	SubModelInputMapper subModelInputMapper;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(ModelInputDto model) throws Exception {
				
		ModelInput modelInput = dtoUtil.copyBean(model, ModelInput.class);
		modelInput.setState(ConstanUtil.ESTADO_ACTIVO);
		modelInput.setDate_record(ConstanUtil.getDateString());
		
		ModelInputExample example = new ModelInputExample();
		example.createCriteria().andName_modelEqualTo(model.getName_model());
		
		List<ModelInput> list = this.selectByExample(ModelInputMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.insertSelective(ModelInputMapper.class, modelInput);
		
		int lastId = modelInput.getId_model_input();
		
		ModelOutput modelOutput = dtoUtil.copyBean(model, ModelOutput.class);
		modelOutput.setId_model_input(lastId);
		modelOutput.setState(ConstanUtil.ESTADO_ACTIVO);
		modelOutput.setDate_record(ConstanUtil.getDateString());
		
		this.insertSelective(ModelOutputMapper.class, modelOutput);
		
		int idModelOutput = modelOutput.getId_model_output();
		
		this.insertNewRecordsPropertyDto(model.getListPropertyDtos(), lastId, idModelOutput);
		
		return lastId;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void save(ModelInputDto model) throws Exception {
		
		ModelInput modelInput = dtoUtil.copyBean(model, ModelInput.class);
		
		ModelInputExample example = new ModelInputExample();
		example.createCriteria().andName_modelEqualTo(model.getName_model()).andId_model_inputNotEqualTo(model.getId_model_input());
		
		List<ModelInput> list = this.selectByExample(ModelInputMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.updateByPrimaryKeySelective(ModelInputMapper.class, modelInput);
				
		if(model.isNewOutput()){
			
			{
				ModelOutputExample modelOutputExample = new ModelOutputExample();
				modelOutputExample.createCriteria().andId_model_inputEqualTo(model.getId_model_input());
				ModelOutput modelOutput = new ModelOutput();
				modelOutput.setState(ConstanUtil.ESTADO_INACTIVO);
				
				modelOutputMapper.updateByExampleSelective(modelOutput, modelOutputExample);
			}		
			
			ModelOutput modelOutput = dtoUtil.copyBean(model, ModelOutput.class);
			modelOutput.setId_model_output(model.getId_model_input());
			modelOutput.setState(ConstanUtil.ESTADO_ACTIVO);
			modelOutput.setDate_record(ConstanUtil.getDateString());
			
			this.insertSelective(ModelOutputMapper.class, modelOutput);
			
			int idModelOutput = modelOutput.getId_model_output();
			
			this.insertNewRecordsPropertyDto(model.getListPropertyDtos(), model.getId_model_input(), idModelOutput);
			
		}

	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void remove(ModelInputDto model) throws Exception {
		
		ModelInput modelInput = dtoUtil.copyBean(model, ModelInput.class);
		
		PropertyExample propertyExample = new PropertyExample();
		propertyExample.createCriteria().andId_model_inputEqualTo(modelInput.getId_model_input());
		
		propertyMapper.deleteByExample(propertyExample);
		
		ModelOutputExample example = new ModelOutputExample();
		example.createCriteria().andId_model_inputEqualTo(model.getId_model_input());
		
		modelOutputMapper.deleteByExample(example);
				
		this.deleteByPrimaryKey(ModelInputMapper.class, modelInput);

	}

	@Override
	public List<ModelInputDto> list(ModelInputExample example) throws Exception {
		
		List<ModelInput> listModelInput = this.selectByExample(ModelInputMapper.class, example);
		
		List<ModelInputDto> listModelInputDto = new ArrayList<>();
		
		for(ModelInput modelInput : listModelInput){
			
			ModelInputDto modelInputDto = dtoUtil.copyBean(modelInput, ModelInputDto.class);
			
			ModelOutputExample modelOutputExample = new ModelOutputExample();
			modelOutputExample.createCriteria().andId_model_inputEqualTo(modelInput.getId_model_input()).andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
			
			List<ModelOutput> listModelOutput = this.selectByExample(ModelOutputMapper.class, modelOutputExample);
			
			if(!listModelOutput.isEmpty()){
				
				ModelOutput modelOutput = listModelOutput.get(0);
				
				PropertyExample propertyExample = new PropertyExample();
				propertyExample.createCriteria().andId_model_outputEqualTo(modelOutput.getId_model_output());
				
				List<Property> listProperty = this.selectByExample(PropertyMapper.class, propertyExample);
				List<PropertyDto> listPropertyDto = dtoUtil.copyBean(listProperty, PropertyDto.class);
				
				modelInputDto.setListPropertyDtos(listPropertyDto);
				
				modelInputDto = dtoUtil.copyBean(modelOutput, modelInputDto);
			}
						
			listModelInputDto.add(modelInputDto);
		}
		
		return listModelInputDto;
	}
	    
    @Transactional(rollbackForClassName = {"Exception"})
    private void insertNewRecordsPropertyDto(List<PropertyDto> listPropertyDtos, Integer idModelInput, Integer idModelOutput) throws Exception{

        for(PropertyDto propertyDto : listPropertyDtos){

            if(propertyDto.isNewEntry()){
            	
            	Property property = dtoUtil.copyBean(propertyDto,Property.class);
            	property.setId_property(null);
            	property.setId_model_input(idModelInput);
            	property.setId_model_output(idModelOutput);
            	property.setState(ConstanUtil.ESTADO_ACTIVO);
            	property.setDate_record(ConstanUtil.getDateString());
                
                this.insertSelective(PropertyMapper.class, property);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
    private void updateModifiedRecordsPropertyDto(List<PropertyDto> listPropertyDtos) throws Exception{

        for(PropertyDto propertyDto : listPropertyDtos){

            if(propertyDto.isUpdatedRecord()){
            	Property property = dtoUtil.copyBean(propertyDto,Property.class);
            	this.updateByPrimaryKeySelective(PropertyMapper.class, property);
            }

        }

    }
    
    @Transactional(rollbackForClassName = {"Exception"})
    private void removeRecordsPropertyDto(List<PropertyDto> listPropertyDtos, boolean onlyFlag) throws Exception{

    	for(PropertyDto propertyDto : listPropertyDtos){

            if(onlyFlag){
                if(propertyDto.isRemovedRecord()){
                	Property property = dtoUtil.copyBean(propertyDto,Property.class);
                    this.deleteByPrimaryKey(PropertyMapper.class, property);
                }
            }else{
            	Property property = dtoUtil.copyBean(propertyDto,Property.class);
                this.deleteByPrimaryKey(PropertyMapper.class, property);
            }

        }

    }

    @Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void createChild(SubModelInput subModelInput) throws Exception {
		this.insertSelective(SubModelInputMapper.class, subModelInput);
	}

    @Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void saveChild(SubModelInput subModelInput) throws Exception {
    	this.updateByPrimaryKeySelective(SubModelInputMapper.class, subModelInput);
	}

    @Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void removeChild(SubModelInput subModelInput) throws Exception {
    	this.deleteByPrimaryKey(SubModelInputMapper.class, subModelInput);
	}
   
}
