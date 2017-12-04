package proyecto.param;

import java.util.ArrayList;
import java.util.List;

import proyecto.vo.Boletaje;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Visitante;

public class BoletajeParam extends Boletaje{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	
    private  List<Visitante> listaVisitante;
    private Fichaturismo fichaturismo;
    
    public BoletajeParam(){
	super();
	listaVisitante=new ArrayList<Visitante>();
	fichaturismo=new Fichaturismo();
}

public List<Visitante> getListaVisitante() {
	return listaVisitante;
}

public void setListaVisitante(List<Visitante> listaVisitante) {
	this.listaVisitante = listaVisitante;
}

public Fichaturismo getFichaturismo() {
	return fichaturismo;
}

public void setFichaturismo(Fichaturismo fichaturismo) {
	this.fichaturismo = fichaturismo;
}
	
	



}
