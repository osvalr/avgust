package proyecto.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import proyecto.dao.TipoCambioDAO;
import proyecto.dao.TipoDAO;
import proyecto.vo.Tipo;
import proyecto.vo.Tipocambio;

public class TipoCambioService {

	
	private TipoCambioDAO tipoCambioDAO; 

	

	
	
	


	
	
	
	public void setTipoCambioDAO(TipoCambioDAO tipoCambioDAO) {
		this.tipoCambioDAO = tipoCambioDAO;
	}


	public List<Tipocambio> consultarTipoCambio(Tipocambio tipocambio){
		
		List<Tipocambio> lista=new ArrayList<Tipocambio>();
		lista=tipoCambioDAO.listar(tipocambio);
		SimpleDateFormat formateador=new SimpleDateFormat("MM-yyyy");
		
		for(Tipocambio t:lista){
			   //t.setAnio(Integer.parseInt(formateador.format(t.getFecha())));
		       t.setDestipocambio(formateador.format(t.getFecha()));
		       //System.out.println(t.getDestipocambio());
		}
		return  lista;
		
	}



	
    public Tipocambio consultarTipoCambioMensual(Tipocambio tipocambio){
     	List<Tipocambio> lista=new ArrayList<Tipocambio>();
		lista=tipoCambioDAO.listar(tipocambio);
		Tipocambio tc=new Tipocambio();
		if(lista.size()!=0){
			tc=lista.get(0);
		}
		return  tc;
		
	}

	
	

}
