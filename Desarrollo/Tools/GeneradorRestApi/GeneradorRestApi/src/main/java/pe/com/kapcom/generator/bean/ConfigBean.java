package pe.com.kapcom.generator.bean;

public class ConfigBean {
	
	private String nameCrud;
	private String path;
	private String nameRepository;
	private String nameModelXml;
	private java.util.List<SubModelBean> subModels;
	
	//Defaults
	private String pathSrc;
	private String packageService;
	private String packageImplement;
	private String packageRest;
	private String packageRepository;
	
	
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
	public String getNameRepository() {
		return nameRepository;
	}
	public void setNameRepository(String nameRepository) {
		this.nameRepository = nameRepository;
	}
	public String getNameModelXml() {
		return nameModelXml;
	}
	public void setNameModelXml(String nameModelXml) {
		this.nameModelXml = nameModelXml;
	}
	public java.util.List<SubModelBean> getSubModels() {
		return subModels;
	}
	public void setSubModels(java.util.List<SubModelBean> subModels) {
		this.subModels = subModels;
	}
	public String getPathSrc() {
		return pathSrc;
	}
	public void setPathSrc(String pathSrc) {
		this.pathSrc = pathSrc;
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
	public String getPackageRest() {
		return packageRest;
	}
	public void setPackageRest(String packageRest) {
		this.packageRest = packageRest;
	}
	public String getPackageRepository() {
		return packageRepository;
	}
	public void setPackageRepository(String packageRepository) {
		this.packageRepository = packageRepository;
	}
		
}
