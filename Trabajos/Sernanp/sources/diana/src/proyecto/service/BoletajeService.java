package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.BoletajeDAO;
import proyecto.dao.TipoDAO;
import proyecto.vo.Boletaje;

@Service
public class BoletajeService {
	
	@Autowired
	private BoletajeDAO boletajeDAO;
	@Autowired
	private TipoDAO tipoDAO;
	
	public List<Boletaje> listar(int idareanatural){
		return this.boletajeDAO.listar(idareanatural);
	}
	
	public List<Boletaje> listarxRuta( int idrutaturismo ){
		return this.boletajeDAO.listarxRuta(idrutaturismo);
	}
	
	
	public List<Boletaje> listarBoletaje(Boletaje boletaje){
//		List<Boletaje> lista=new ArrayList<Boletaje>();
//		List<Boletaje> listaboletaje=  boletajeDAO.listar(boletaje);
//		Boletaje bnoaplica=new Boletaje();
//		bnoaplica.setIdboletaje(0);
//		bnoaplica.setNombreboletaje("No aplica");
//		lista.add(bnoaplica);
//		lista.addAll(listaboletaje);
//		return lista;
		return boletajeDAO.listar(boletaje);
	}
	
	public List<Boletaje> listarBoletajeMayorEdadxIdruta(int idrutaturismo){
		Boletaje boletaje=new Boletaje();
		boletaje.setFlagmayoredad(ValueConstants.FLAG_ACTIVO);
		boletaje.getRutaturismo().setIdrutaturismo(idrutaturismo);
		Boletaje b=new Boletaje();
		b.setIdboletaje(0);
		b.setNombreboletaje("No Aplica");
		b.setObsboletaje("");
		b.setValorboletaje(0f);
		List<Boletaje>lista=new ArrayList<Boletaje>();
		lista.add(b);
		lista.addAll(boletajeDAO.listar(boletaje));
		return lista;
	}
	
	public List<Boletaje> listarBoletajeMenorEdadxIdruta(int idrutaturismo){
		Boletaje boletaje=new Boletaje();
		boletaje.setFlagmayoredad(ValueConstants.VALOR_CERO);
		boletaje.getRutaturismo().setIdrutaturismo(idrutaturismo);
		Boletaje b=new Boletaje();
		b.setIdboletaje(0);
		b.setNombreboletaje("No Aplica");
		b.setObsboletaje("");
		b.setValorboletaje(0f);
		List<Boletaje>lista=new ArrayList<Boletaje>();
		lista.add(b);
		lista.addAll(boletajeDAO.listar(boletaje));
		return lista;
	}
	
	public List<Boletaje> listarBoletajeInfante(){
		List<Boletaje> lista=new ArrayList<Boletaje>();
		Boletaje b=new Boletaje();
		b.setIdboletaje(0);
		b.setNombreboletaje("No Aplica");
		b.setObsboletaje("");
		b.setValorboletaje(0f);
		lista.add(b);
		return lista;
	}
	
	public Boletaje obtenerBoletajeAdicionalxRutaTurismo(int idrutaturismo){
		Boletaje b=new Boletaje();
		b.getRutaturismo().setIdrutaturismo(idrutaturismo);
		b.getTipoboletaje().setIdtipo(ValueConstants.FLAG_ACTIVO);
		List<Boletaje> lista=boletajeDAO.listar(b);
		Boletaje bol=new Boletaje();
		if(lista.size()==1){
			bol=lista.get(0);
		}
		return bol;
	}
	
	

}
