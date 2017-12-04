package pe.com.focus.generator.crud.extjs.bean;

import java.util.List;

public class EntityBean {

	private String nameEntity;
	private String nameVarEntity;
	private String nameMapperEntity;
	private String propertyGetMethod;
	private String propertySetMethod;
	private String primaryKeyGetMethod;
	private String primaryKeySetMethod;
	private String classEntity;
	private String classMapperEntity;
	private String joinProperty;
	private String joinPropertyGetMethod;
	private String joinPropertySetMethod;

	public String getJoinProperty() {
		return joinProperty;
	}

	public void setJoinProperty(String joinProperty) {
		this.joinProperty = joinProperty;
	}

	public String getJoinPropertyGetMethod() {
		return joinPropertyGetMethod;
	}

	public void setJoinPropertyGetMethod(String joinPropertyGetMethod) {
		this.joinPropertyGetMethod = joinPropertyGetMethod;
	}

	public String getJoinPropertySetMethod() {
		return joinPropertySetMethod;
	}

	public void setJoinPropertySetMethod(String joinPropertySetMethod) {
		this.joinPropertySetMethod = joinPropertySetMethod;
	}

	private List<EntityBean> subBeans;
	private String otherProperties;

	public String getNameEntity() {
		return nameEntity;
	}

	public void setNameEntity(String nameEntity) {
		this.nameEntity = nameEntity;
	}

	public String getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(String classEntity) {
		this.classEntity = classEntity;
	}

	public String getNameVarEntity() {
		return nameVarEntity;
	}

	public void setNameVarEntity(String nameVarEntity) {
		this.nameVarEntity = nameVarEntity;
	}

	public String getNameMapperEntity() {
		return nameMapperEntity;
	}

	public void setNameMapperEntity(String nameMapperEntity) {
		this.nameMapperEntity = nameMapperEntity;
	}

	public String getPropertyGetMethod() {
		return propertyGetMethod;
	}

	public void setPropertyGetMethod(String propertyGetMethod) {
		this.propertyGetMethod = propertyGetMethod;
	}

	public String getPropertySetMethod() {
		return propertySetMethod;
	}

	public void setPropertySetMethod(String propertySetMethod) {
		this.propertySetMethod = propertySetMethod;
	}

	public String getClassMapperEntity() {
		return classMapperEntity;
	}

	public void setClassMapperEntity(String classMapperEntity) {
		this.classMapperEntity = classMapperEntity;
	}

	public String getPrimaryKeyGetMethod() {
		return primaryKeyGetMethod;
	}

	public void setPrimaryKeyGetMethod(String primaryKeyGetMethod) {
		this.primaryKeyGetMethod = primaryKeyGetMethod;
	}

	public String getPrimaryKeySetMethod() {
		return primaryKeySetMethod;
	}

	public void setPrimaryKeySetMethod(String primaryKeySetMethod) {
		this.primaryKeySetMethod = primaryKeySetMethod;
	}

	public List<EntityBean> getSubBeans() {
		return subBeans;
	}

	public void setSubBeans(List<EntityBean> subBeans) {
		this.subBeans = subBeans;
	}

	public String getOtherProperties() {
		return otherProperties;
	}

	public void setOtherProperties(String otherProperties) {
		this.otherProperties = otherProperties;
	}

}
