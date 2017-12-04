package pe.com.kapcom.generator.repositories.bean;

public class ColumnBean {
	
	private String nameColumn;
	private String dataType;
	private String dataTypeJava;
	private String annotations;
	
	private Integer character_maximum_length;
	private Integer numeric_precision;
	private Integer numeric_scale;
	private String is_nullable;
	private boolean isColumnPk = false;
	
	public String getNameColumn() {
		return nameColumn;
	}
	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getAnnotations() {
		return annotations;
	}
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	public String getDataTypeJava() {
		return dataTypeJava;
	}
	public void setDataTypeJava(String dataTypeJava) {
		this.dataTypeJava = dataTypeJava;
	}
	public Integer getCharacter_maximum_length() {
		return character_maximum_length;
	}
	public void setCharacter_maximum_length(Integer character_maximum_length) {
		this.character_maximum_length = character_maximum_length;
	}
	public Integer getNumeric_precision() {
		return numeric_precision;
	}
	public void setNumeric_precision(Integer numeric_precision) {
		this.numeric_precision = numeric_precision;
	}
	public Integer getNumeric_scale() {
		return numeric_scale;
	}
	public void setNumeric_scale(Integer numeric_scale) {
		this.numeric_scale = numeric_scale;
	}
	public String getIs_nullable() {
		return is_nullable;
	}
	public void setIs_nullable(String is_nullable) {
		this.is_nullable = is_nullable;
	}
	public boolean isColumnPk() {
		return isColumnPk;
	}
	public void setColumnPk(boolean isColumnPk) {
		this.isColumnPk = isColumnPk;
	}

}
