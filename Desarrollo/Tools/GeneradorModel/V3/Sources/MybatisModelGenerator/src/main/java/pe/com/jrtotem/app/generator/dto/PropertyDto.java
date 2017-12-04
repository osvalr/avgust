package pe.com.jrtotem.app.generator.dto;

public class PropertyDto {
	
	private Integer id_property;
	
    private Integer id_model_input;

    private Integer id_model_output;

    private String name;

    private String type;

    private String data_type;
    
    private boolean newEntry = false;
    private boolean updatedRecord = false;
    private boolean removedRecord = false;
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId_property() {
		return id_property;
	}
	public void setId_property(Integer id_property) {
		this.id_property = id_property;
	}
	public Integer getId_model_input() {
		return id_model_input;
	}
	public void setId_model_input(Integer id_model_input) {
		this.id_model_input = id_model_input;
	}
	public Integer getId_model_output() {
		return id_model_output;
	}
	public void setId_model_output(Integer id_model_output) {
		this.id_model_output = id_model_output;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public boolean isNewEntry() {
		return newEntry;
	}
	public void setNewEntry(boolean newEntry) {
		this.newEntry = newEntry;
	}
	public boolean isUpdatedRecord() {
		return updatedRecord;
	}
	public void setUpdatedRecord(boolean updatedRecord) {
		this.updatedRecord = updatedRecord;
	}
	public boolean isRemovedRecord() {
		return removedRecord;
	}
	public void setRemovedRecord(boolean removedRecord) {
		this.removedRecord = removedRecord;
	}
    
}
