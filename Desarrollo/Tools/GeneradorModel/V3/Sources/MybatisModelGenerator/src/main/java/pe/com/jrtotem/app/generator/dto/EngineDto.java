package pe.com.jrtotem.app.generator.dto;

public class EngineDto {
	
	private Integer id_engine;
	private String descrip_engine;
	
	public Integer getId_engine() {
		return id_engine;
	}
	public void setId_engine(Integer id_engine) {
		this.id_engine = id_engine;
	}
	public String getDescrip_engine() {
		return descrip_engine;
	}
	public void setDescrip_engine(String descrip_engine) {
		this.descrip_engine = descrip_engine;
	}
	@Override
    public String toString() {
        return descrip_engine;
    }
}
