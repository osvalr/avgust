package pe.com.kapcom.generator.bean;

import java.util.List;

public class CrudBean {

	private String nameCrud;
	private String path;
	private String propertyId;

	private String packageService;
	private String packageImplement;
	private String packageRepository;
	private String packageModel;
	private String packageMapper;
	private String packageRest;

	private String nameModel;
	private String nameModelCriteria;
	private String nameModelMapper;
	private String nameRepository;
	
	private List<DetailCrudBean> details;

	public String getNameCrud() {
		return nameCrud;
	}

	public void setNameCrud(String nameCrud) {
		this.nameCrud = nameCrud;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPackageService() {
		return packageService;
	}

	public void setPackageService(String packageService) {
		this.packageService = packageService;
	}

	public String getPackageImplement() {
		return packageImplement;
	}

	public void setPackageImplement(String packageImplement) {
		this.packageImplement = packageImplement;
	}

	public String getPackageRepository() {
		return packageRepository;
	}

	public void setPackageRepository(String packageRepository) {
		this.packageRepository = packageRepository;
	}

	public String getPackageModel() {
		return packageModel;
	}

	public void setPackageModel(String packageModel) {
		this.packageModel = packageModel;
	}

	public String getPackageMapper() {
		return packageMapper;
	}

	public void setPackageMapper(String packageMapper) {
		this.packageMapper = packageMapper;
	}

	public String getPackageRest() {
		return packageRest;
	}

	public void setPackageRest(String packageRest) {
		this.packageRest = packageRest;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public String getNameModelCriteria() {
		return nameModelCriteria;
	}

	public void setNameModelCriteria(String nameModelCriteria) {
		this.nameModelCriteria = nameModelCriteria;
	}

	public String getNameModelMapper() {
		return nameModelMapper;
	}

	public void setNameModelMapper(String nameModelMapper) {
		this.nameModelMapper = nameModelMapper;
	}

	public String getNameRepository() {
		return nameRepository;
	}

	public void setNameRepository(String nameRepository) {
		this.nameRepository = nameRepository;
	}

	public List<DetailCrudBean> getDetails() {
		return details;
	}

	public void setDetails(List<DetailCrudBean> details) {
		this.details = details;
	}

}
