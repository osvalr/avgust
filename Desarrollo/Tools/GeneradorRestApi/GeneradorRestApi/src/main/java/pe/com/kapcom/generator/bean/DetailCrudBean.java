package pe.com.kapcom.generator.bean;

public class DetailCrudBean {

	private CrudBean crudBean;
	private String namePropertyList;
	private String propertyId;
	private String nameCrud;

	public String getNamePropertyList() {
		return namePropertyList;
	}

	public void setNamePropertyList(String namePropertyList) {
		this.namePropertyList = namePropertyList;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getNameCrud() {
		return nameCrud;
	}

	public void setNameCrud(String nameCrud) {
		this.nameCrud = nameCrud;
	}

	public CrudBean getCrudBean() {
		return crudBean;
	}

	public void setCrudBean(CrudBean crudBean) {
		this.crudBean = crudBean;
	}
	
}
