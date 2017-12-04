package proyecto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import proyecto.constants.ValueConstants;
import proyecto.dao.ArchivoDAO;
import proyecto.dao.AreaNaturalDAO;
import proyecto.dao.ProyectoArchivoDAO;
import proyecto.dao.ProyectoAreanaturalDAO;
import proyecto.dao.ProyectoDAO;
import proyecto.dao.ProyectoEjecutorDAO;
import proyecto.dao.ProyectoFteFtoDAO;
import proyecto.dao.TipoCambioDAO;
import proyecto.dao.TipoDAO;
import proyecto.param.ProyectoParam;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Archivo;
import proyecto.vo.Areanatural;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoArchivo;
import proyecto.vo.ProyectoAreanatural;
import proyecto.vo.ProyectoEjecutor;
import proyecto.vo.ProyectoFteFto;
import proyecto.vo.Tipo;
import proyecto.vo.Tipocambio;

public class ProyectoService {

	private ProyectoDAO proyectoDAO;
	private TipoDAO tipoDAO;
	private ProyectoAreanaturalDAO proyectoAreanaturalDAO;
	private ProyectoEjecutorDAO proyectoEjecutorDAO;
	private ProyectoFteFtoDAO proyectoFteFtoDAO;
	private TipoCambioDAO tipoCambioDAO; 
	@Autowired
	private ArchivoDAO archivoDAO;
	private ProyectoArchivoDAO proyectoArchivoDAO;
	private AreaNaturalDAO areaNaturalDAO;

	
	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
	
	public void setTipoDAO(TipoDAO tipoDAO) {
		this.tipoDAO = tipoDAO;
	}
	

	public void setAreaNaturalDAO(AreaNaturalDAO areaNaturalDAO) {
		this.areaNaturalDAO = areaNaturalDAO;
	}

	public void setProyectoArchivoDAO(ProyectoArchivoDAO proyectoArchivoDAO) {
		this.proyectoArchivoDAO = proyectoArchivoDAO;
	}

	

	public void setTipoCambioDAO(TipoCambioDAO tipoCambioDAO) {
		this.tipoCambioDAO = tipoCambioDAO;
	}

	public void setProyectoEjecutorDAO(ProyectoEjecutorDAO proyectoEjecutorDAO) {
		this.proyectoEjecutorDAO = proyectoEjecutorDAO;
	}

	public void setProyectoFteFtoDAO(ProyectoFteFtoDAO proyectoFteFtoDAO) {
		this.proyectoFteFtoDAO = proyectoFteFtoDAO;
	}

	public void setProyectoAreanaturalDAO(
			ProyectoAreanaturalDAO proyectoAreanaturalDAO) {
		this.proyectoAreanaturalDAO = proyectoAreanaturalDAO;
	}

	public List<Proyecto>  consultarProyectosPaginado(ProyectoParam proyectoParam,int offset,int tamPagina)  {
		proyectoParam.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		return proyectoDAO.listarPaginadoSubConsulta(proyectoParam, offset, tamPagina);
    }
	
	public List<Proyecto>  consultarProyectos(ProyectoParam proyectoParam)  {
		proyectoParam.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		
		return proyectoDAO.listarSubConsulta(proyectoParam);
    }
	
	public int  calcularCantidadProyectos(ProyectoParam proyectoParam)  {
		proyectoParam.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		return proyectoDAO.contarSubConsulta(proyectoParam);		
    }
	
	
	

	
	
    public List<Proyecto> listarProyectosPrincipales(){
    	List<Proyecto> lista=new ArrayList<Proyecto>();
    	Proyecto p=new Proyecto();
    	p.setFlagProyecto(ValueConstants.FLAG_ACTIVO);
    	p.setNivelproyecto(ValueConstants.FLAG_ACTIVO);
    	lista=proyectoDAO.listar(p);
    	/*int num=lista.size()+1;
    	Proyecto pp=new Proyecto();
    	pp.setSiglasproyecto(ValueConstants.PROYECTO_PRINCIPAL);
    	pp.setIdproyecto(ValueConstants.ID_PROYECTO_PRINCIPAL);
    	lista.add(pp);
    	*/
    	return lista;
    }

	
	public Proyecto consultarDetalleProyecto(Proyecto proyecto)  {
		
		    Proyecto p=new Proyecto();
			List<Proyecto> lista=new ArrayList<Proyecto>();
			
			
			lista=proyectoDAO.listar(proyecto);
			
			if(lista.size()!=0){
				p=lista.get(0);
				
				
				
				//fechas
				if(p.getFechafinproyecto()!=null && p.getFechainicioproyecto()!=null){
					long diferencia = ( p.getFechafinproyecto().getTime() - p.getFechainicioproyecto().getTime() )/ValueConstants.MILLSECS_PER_DAY; 
					double meses= (diferencia/(double)ValueConstants.NUMERODIASXMES);
					long nummeses  =Math.round(meses);
					p.setPeriodoproyecto((int)nummeses);
				}
				
				p.setAreanaturals(proyectoAreanaturalDAO.listar(proyecto));
				//ejecutores
				ProyectoEjecutor pe=new ProyectoEjecutor();
				pe.setProyecto(proyecto);
				p.setListaProyectoEjecutor(proyectoEjecutorDAO.listar(pe));
				ProyectoFteFto pft=new ProyectoFteFto();
				pft.setProyecto(proyecto);
				double monto=0;
				List<ProyectoFteFto> listaProyFte=new ArrayList<ProyectoFteFto>();
				listaProyFte=proyectoFteFtoDAO.listar(pft);
				//tipo cambio
				SimpleDateFormat formatanio=new SimpleDateFormat("yyyy");
				
				for(ProyectoFteFto pf:listaProyFte){
					Tipocambio tc=new Tipocambio();
					int idtipocambio= pf.getTipocambio().getIdtipocambio();
					if(idtipocambio==0){
						tc.setIdtipocambio(ValueConstants.VALOR_CERO);
					}
					else{
						tc.setIdtipocambio(idtipocambio);
					}
					
					
					List<Tipocambio> listaTc=tipoCambioDAO.listar(tc);
					if(listaTc.size()!=0){
						tc=listaTc.get(0);
						pf.setTipocambio(tc);
					    pf.getTipocambio().setAnio(Integer.parseInt(formatanio.format(pf.getTipocambio().getFecha())));
					}
					double montoconv=0;
					if(tc.getValor()==0){
						montoconv=pf.getMonto();
				    }
					else{
						montoconv= pf.getMonto()*tc.getValor();
					}
				    
				    montoconv=ProyectoUtil.redondear(montoconv, 2);
				    monto+=montoconv;
				}
				p.setMonto(monto);
				//consulto padre
				List<Proyecto> listaProyPadre=new ArrayList<Proyecto>();
				//System.out.println("id proy padre"+p.getProyectoPrincipal().getIdproyecto());
				if(p.getProyectoPrincipal().getIdproyecto()!=0){
					//Proyecto pr=new Proyecto();
					//pr.setIdproyecto(p.getProyectoPrincipal().getIdproyecto());
					//pr.setFlagProyecto(ValueConstants.FLAG_TODOS);
					listaProyPadre=proyectoDAO.listar(new Proyecto(p.getProyectoPrincipal().getIdproyecto()));
					p.setProyectoPrincipal(listaProyPadre.get(0));
				}
				
				
				//proyecto principal
				/*
				if(p.getNivelproyecto()==ValueConstants.NIVEL_UNO){
					p.setProyectoPrincipal(new Proyecto(ValueConstants.ID_PROYECTO_PRINCIPAL));
				}
				*/
				//documentos
				List<ProyectoArchivo>  listaProyArch= proyectoArchivoDAO.listar(p);
				
				//archivos
				for(ProyectoArchivo pa:listaProyArch){
					Archivo arch=new Archivo();
					arch.setIdarchivoPadre(pa.getArchivo().getIdarchivo());
					pa.getArchivo().setListaArchivo(archivoDAO.listar(arch));
				}
				
				
				p.setListaProyectoArchivo(listaProyArch);
				p.setListaFuenteProyecto(listaProyFte);
				p.setFuentefinanciamientos(proyectoFteFtoDAO.listar(proyecto));
				
	   		   
			}
			return p;
		
	}
	
	
	
	public void guardarProyecto(Proyecto proyecto){
		
		List<Tipo> listaTipoProy=tipoDAO.listarTipoProyecto(new Tipo());
		int indOtro= listaTipoProy.get(listaTipoProy.size()-1).getIdtipo();
		indOtro++;
		if(proyecto.getTipoproyecto().getIdtipo()==indOtro){
			Tipo tipoProyecto=new Tipo();
			tipoProyecto.setIdtipo(proyecto.getTipoproyecto().getIdtipo());
			tipoProyecto.setNombretipo(proyecto.getTipoproyecto().getNombretipo());
			int codTipoProy= tipoDAO.insertarTipoProyecto(tipoProyecto);
		   proyecto.getTipoproyecto().setIdtipo(codTipoProy);
		}
		
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		for(ProyectoFteFto pf:proyecto.getListaFuenteProyecto()){
			
			if(pf.getTipocambio().getIdtipocambio()==0){
				
				if(pf.getMoneda().getIdmoneda()!=ValueConstants.MONEDA_SOL){
					Tipocambio tc=new Tipocambio();
					int mes=pf.getTipocambio().getMes();
					String cadfecha="";
					if(mes>0 && mes <10)
					  cadfecha=pf.getTipocambio().getAnio()+"-0"+pf.getTipocambio().getMes()+"-"+01;
					else
						cadfecha=pf.getTipocambio().getAnio()+"-"+pf.getTipocambio().getMes()+"-"+01;
					Date fecha;
					try {
						fecha = formateador.parse(cadfecha);
						tc.setFecha(fecha);
						tc.getMonedaOrigen().setIdmoneda(pf.getMoneda().getIdmoneda());
						tc.getMonedaDestino().setIdmoneda(ValueConstants.MONEDA_SOL);
						tc.setValor(pf.getTipocambio().getValor());
						int idtipocambio=tipoCambioDAO.insertar(tc);
					    pf.getTipocambio().setIdtipocambio(idtipocambio);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
				
				
				
				
				
			}
			
		}
		
		
		if(proyecto.getIdproyecto()==0){
			
			
			
			proyecto.setFlagProyecto(ValueConstants.FLAG_ACTIVO);
			int codproy=proyectoDAO.insertar(proyecto);
			for(Areanatural a:proyecto.getAreanaturals()){
				ProyectoAreanatural pa=new ProyectoAreanatural();
				pa.getProyecto().setIdproyecto(codproy);
				pa.getAreanatural().setIdareanatural(a.getIdareanatural());
				proyectoAreanaturalDAO.insertar(pa);
			}
			for(ProyectoEjecutor pe:proyecto.getListaProyectoEjecutor()){
				pe.getProyecto().setIdproyecto(codproy);
				proyectoEjecutorDAO.insertar(pe);
			}
			for(ProyectoFteFto pf:proyecto.getListaFuenteProyecto()){
				
				pf.getProyecto().setIdproyecto(codproy);
				pf.setMonto(pf.getMonto());
				proyectoFteFtoDAO.insertar(pf);
			}
			for(ProyectoArchivo pa:proyecto.getListaProyectoArchivo()){
				int codigoarch= archivoDAO.insertar(pa.getArchivo());
				
				for(Archivo ar:pa.getArchivo().getListaArchivo()){
					ar.setIdarchivoPadre(codigoarch);
					archivoDAO.insertar(ar);
				}
				
				pa.getProyecto().setIdproyecto(codproy);
				pa.getArchivo().setIdarchivo(codigoarch);
				proyectoArchivoDAO.insertar(pa);
			}
		
			
		}
		else{
			//actualizar
			
			proyectoDAO.actualizar(proyecto);
			//actualizar areas naturales
			if(proyecto.getAreanaturals().size()!=0){
				List<ProyectoAreanatural> listaProyArea=new ArrayList<ProyectoAreanatural>();
				for(Areanatural a:proyecto.getAreanaturals()){
					ProyectoAreanatural pa=new ProyectoAreanatural();
					pa.getProyecto().setIdproyecto(proyecto.getIdproyecto());
					pa.getAreanatural().setIdareanatural(a.getIdareanatural());
					listaProyArea.add(pa);
				}
				proyectoAreanaturalDAO.eliminarDiferencia(listaProyArea,proyecto);
				proyectoAreanaturalDAO.insertarNoDuplicado(listaProyArea);
				
			}
			//actualizar ejecutoras
				for(int i=0;i<proyecto.getListaProyectoEjecutor().size();i++){
					proyecto.getListaProyectoEjecutor().get(i).getProyecto().setIdproyecto(proyecto.getIdproyecto());
				}
				proyectoEjecutorDAO.eliminarDiferencia(proyecto.getListaProyectoEjecutor(),proyecto);
				if(proyecto.getListaProyectoEjecutor().size()!=0){
				proyectoEjecutorDAO.insertarNoDuplicado(proyecto.getListaProyectoEjecutor());
				}
			
			//actualizar fuentes
		
				for(int i=0;i<proyecto.getListaFuenteProyecto().size();i++){
					proyecto.getListaFuenteProyecto().get(i).getProyecto().setIdproyecto(proyecto.getIdproyecto());
					
				}
				
				proyectoFteFtoDAO.eliminarDiferencia(proyecto.getListaFuenteProyecto(),proyecto);
				if(proyecto.getListaFuenteProyecto().size()!=0){
				for(ProyectoFteFto pf:proyecto.getListaFuenteProyecto()){
					proyectoFteFtoDAO.insertarNoDuplicado(pf);
				}
				
				//proyectoFteFtoDAO.insertarNoDuplicado(proyecto.getListaFuenteProyecto());
			    }
			    
				//actualizar documentos
				proyectoArchivoDAO.eliminarDiferencia(proyecto.getListaProyectoArchivo(), proyecto);
				for(ProyectoArchivo pa:proyecto.getListaProyectoArchivo()){
					if( pa.getArchivo().getIdarchivo()!=0){
						archivoDAO.eliminarDiferencia(pa.getArchivo().getListaArchivo(), pa.getArchivo().getIdarchivo());
					}
					int codigodoc=pa.getArchivo().getIdarchivo();
					if(pa.getArchivo().getIdarchivo()==0){
						codigodoc=archivoDAO.insertar(pa.getArchivo());
						ProyectoArchivo parch=new ProyectoArchivo();
						parch.getProyecto().setIdproyecto(proyecto.getIdproyecto());
						parch.getArchivo().setIdarchivo(codigodoc);
						proyectoArchivoDAO.insertar(parch);
					}
					else{
						pa.getArchivo().setNombreInicial(null);
						pa.getArchivo().setNombreGenerado(null);
						pa.getArchivo().setIdarchivoPadre(0);
						archivoDAO.actualizar(pa.getArchivo());
					}
					for(Archivo a:pa.getArchivo().getListaArchivo()){
						if(a.getIdarchivo()==0){
							a.setIdarchivoPadre(codigodoc);
							archivoDAO.insertar(a);
						}
						
					}
	
						
				}
			
		}
		
	}
	
	
	
	public List<Proyecto> consultarProyectosxIdAreaNatural(int codigoarea){
		List<Proyecto> listaProyecto=new ArrayList<Proyecto>();
		
			ProyectoParam p=new ProyectoParam();
			p.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
			p.getAreanatural().setIdareanatural(codigoarea);
			listaProyecto=proyectoDAO.listarSubConsulta(p);
		return listaProyecto;
	}
	
	
	public void eliminarProyectos(List<Integer> lista){
		for(Integer i:lista){
			Proyecto p=new Proyecto();
			p.setIdproyecto(i);
			p.setFlagProyecto(ValueConstants.VALOR_CERO);
			proyectoDAO.actualizar(p);
		}
		
	}
	
	
	public List<Proyecto>  consultarProyectos(Proyecto proyecto)  {
			return proyectoDAO.listar(proyecto);
	}
	
	
	
	

}
