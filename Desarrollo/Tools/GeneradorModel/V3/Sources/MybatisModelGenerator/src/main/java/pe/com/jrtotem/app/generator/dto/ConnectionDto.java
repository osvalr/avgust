package pe.com.jrtotem.app.generator.dto;

public class ConnectionDto {
	
	private Integer id_connection;
	private String descrip_connection;
	
	public Integer getId_connection() {
		return id_connection;
	}
	public void setId_connection(Integer id_connection) {
		this.id_connection = id_connection;
	}
	public String getDescrip_connection() {
		return descrip_connection;
	}
	public void setDescrip_connection(String descrip_connection) {
		this.descrip_connection = descrip_connection;
	}
	
	@Override
	public String toString() {
		return descrip_connection;
	}
}
