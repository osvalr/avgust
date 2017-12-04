package proyecto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sede implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idsede;
	private String dessede;
	private Areanatural areanatural;
	private int idsedeprincipal;
	private Ubigeo ubigeo;
	private List<Sede> listaSede;
	
	
	public Sede(){
		ubigeo=new Ubigeo();
		areanatural=new Areanatural();
		listaSede=new ArrayList<Sede>();
	}


	
	
	
	

	public int getIdsedeprincipal() {
		return idsedeprincipal;
	}







	public void setIdsedeprincipal(int idsedeprincipal) {
		this.idsedeprincipal = idsedeprincipal;
	}







	public List<Sede> getListaSede() {
		return listaSede;
	}







	public void setListaSede(List<Sede> listaSede) {
		this.listaSede = listaSede;
	}







	public int getIdsede() {
		return idsede;
	}



	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}



	public String getDessede() {
		return dessede;
	}



	public void setDessede(String dessede) {
		this.dessede = dessede;
	}



	public Areanatural getAreanatural() {
		return areanatural;
	}



	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}



	

	public Ubigeo getUbigeo() {
		return ubigeo;
	}



	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	
	
	

}
