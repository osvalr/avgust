package pe.com.jrtotem.app.generator.dto;

public class DataTypeDto {

	private String nameDataType;
	private String className;
	private String namespace;
	private String dbDataType;

	public String getNameDataType() {
		return nameDataType;
	}

	public void setNameDataType(String nameDataType) {
		this.nameDataType = nameDataType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getDbDataType() {
		return dbDataType;
	}

	public void setDbDataType(String dbDataType) {
		this.dbDataType = dbDataType;
	}
}
