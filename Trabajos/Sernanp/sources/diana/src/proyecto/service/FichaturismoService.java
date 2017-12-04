package proyecto.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.ActividadTurismoFichaTurismoDAO;
import proyecto.dao.AreaNaturalDAO;
import proyecto.dao.BoletajeDAO;
import proyecto.dao.FichaturismoBoletajeDAO;
import proyecto.dao.FichaturismoDAO;
import proyecto.dao.GuiaFichaturismoDAO;
import proyecto.dao.HistFichaturismoAccionDAO;
import proyecto.dao.PagoBancoDAO;
import proyecto.dao.PagoFichaTurismoDAO;
import proyecto.dao.TipoturismoFichaturismoDAO;
import proyecto.dao.VisitanteConceptoexoneracionpagoDAO;
import proyecto.dao.VisitanteDAO;
import proyecto.param.BoletajeParam;
import proyecto.param.FichaTurismoParam;
import proyecto.util.Pagination;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Actividadturismo;
import proyecto.vo.Areanatural;
import proyecto.vo.Fichaturismo;
import proyecto.vo.GuiaFichaTurismo;
import proyecto.vo.HistFichaturismoAccion;
import proyecto.vo.PagoBanco;
import proyecto.vo.PagoFichaturismo;
import proyecto.vo.Rutaturismo;
import proyecto.vo.Tipo;
import proyecto.vo.TipoturismoFichaturismo;
import proyecto.vo.Visitante;

@Service
public class FichaturismoService {
	
	@Autowired 
	private FichaturismoDAO fichaturismoDAO;
	@Autowired 
	private AreaNaturalDAO areaNaturalDAO;
	@Autowired 
	private AreaNaturalService areaNaturalService;
	@Autowired 
	private VisitanteDAO visitanteDAO;
	@Autowired 
	private BoletajeDAO boletajeDAO;
	@Autowired 
	private GuiaFichaturismoDAO guiaFichaturismoDAO;
	@Autowired 
	private PagoBancoDAO pagoBancoDAO;
	@Autowired 
	private TipoturismoFichaturismoDAO tipoturismoFichaturismoDAO;
	@Autowired 
	private ActividadTurismoFichaTurismoDAO actividadTurismoFichaTurismoDAO;
	@Autowired 
	private VisitanteService visitanteService;
	@Autowired 
	private VisitanteConceptoexoneracionpagoDAO visitanteConceptoexoneracionpagoDAO;
	@Autowired 
	private RutaturismoService rutaturismoService;
	@Autowired 
	private TipoService tipoService;
	@Autowired 
	private HistFichaturismoAccionDAO histFichaturismoAccionDAO;
	@Autowired 
	private PagoFichaTurismoDAO pagoFichaTurismoDAO;
	@Autowired 
	private FichaturismoBoletajeDAO fichaturismoBoletajeDAO;
	@Autowired 
	private PagoBancoService pagoBancoService;
	
//	public Long save(Fichaturismo ficha){
//		return fichaturismoDAO.save(ficha); 
//	} 
	
	public long count(){
		return fichaturismoDAO.count();
	}
	
	public long count(String code){
		return fichaturismoDAO.count( code );
	}

	public long countActives(){
		return fichaturismoDAO.countActives();
	}

	public long countActives(int idArea){
		return fichaturismoDAO.countActives( idArea ); 
	}
	
	public Fichaturismo getfromCode( String code ){
		return fichaturismoDAO.getfromCode(code);
	}
	
	public List<Fichaturismo> listar(){
		return fichaturismoDAO.listar(); 
	}
	public List<Fichaturismo> listar( int page, int limit ){
		return fichaturismoDAO.listar(page, limit);
	}

	public List<Fichaturismo> listarActivas( int idarea, int page, int limit ){
		return fichaturismoDAO.listarActivas( idarea, page, limit);
	}  
	public Fichaturismo findById(Integer id){
		Fichaturismo ficha = fichaturismoDAO.findById(id);
		
		ficha.setAreanatural(areaNaturalService.consultarAreasNaturalxId(ficha.getAreanatural().getIdareanatural()));
		//ficha.setListaVisitante(visitanteService.listarxFicha( ficha.getIdfichaturismo())); 
		//.setVisitantes( visitanteService.listarxFicha( ficha.getIdfichaturismo() )); 
		return ficha;
	}
	public void consolidarFicha(Fichaturismo ft){
		//consolidar ficha(cambiar de estado y fecha)
		Fichaturismo f=new Fichaturismo();
		f.setIdfichaturismo(ft.getIdfichaturismo());
		f.setFechaingreso(ft.getFechaingreso());
		f.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo
				(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO));
		fichaturismoDAO.actualizar(f);
		
		//consolidar los visitantes seleccionados
		Visitante vis=new Visitante();
		vis.setFlagvisitante(ValueConstants.FLAG_ACTIVO);
		visitanteDAO.actualizarxLista(vis, ft.getListaVisitante());
		
		//insertar boletaje adicional
		if(ft.getFichaturismoboletaje().getCantidad()!=0){
			ft.getFichaturismoboletaje().setIdfichaturismo((int)ft.getIdfichaturismo());
			fichaturismoBoletajeDAO.insertar(ft.getFichaturismoboletaje());
		}
		//insertar pagos 
		guardarListadoPagosFichaTurismo(ft);
		
	}
	
	
	public void guardarListadoPagosFichaTurismo(Fichaturismo ft){
		if(ft.getListaPagoFichaturismo().size()!=0){
 			for(PagoFichaturismo pft:ft.getListaPagoFichaturismo()){
 				if(pft.getIdpagofichaturismo()==0){
 					pft.getModalidadpago().setIdtipo(
 					 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_MODALIDAD_PAGO_FICHA_TURISMO, pft.getModalidadpago().getCodigointtipo()));
 					pft.setIdfichaturismo((int)ft.getIdfichaturismo());
 	 				if(pft.getModalidadpago().getCodigointtipo()==ValueConstants.CODIGO_MODPAGOFICHA_BANCO_FICHA){
 	 					PagoBanco pgb= pagoBancoService.consultarPagoBancoxId(pft.getPagobanco().getIdpagobanco());
 	 					double saldo=pgb.getSaldo()-pft.getMonto();
 	 					if(saldo==0){
 	 						saldo=ValueConstants.VALOR_CERO;
 	 					}
 	 					PagoBanco pb=new PagoBanco();
 	 					pb.setIdpagobanco(pft.getPagobanco().getIdpagobanco());
 	 					pb.setSaldo(saldo);
 	 					pagoBancoDAO.actualizar(pb);
 	 				}
 					pagoFichaTurismoDAO.insertar(pft);
 				}else{
 					//actualizar monto pago ficha
 					PagoFichaturismo pagof=new PagoFichaturismo();
 					pagof.setMonto(pft.getMonto());
 					pagof.setIdpagofichaturismo(pft.getIdpagofichaturismo());
 					pagoFichaTurismoDAO.actualizar(pagof);
 					//actualizar pagobanco
 					//consultar pago
 					PagoFichaturismo pgft=consultarPagoFichaTurismoxId(pft.getIdpagofichaturismo());
 					PagoBanco pgb= pagoBancoService.consultarPagoBancoxId(pgft.getPagobanco().getIdpagobanco());
 					double saldo=pgb.getSaldo()-pft.getMonto();
 					if(saldo==0){
 						saldo=ValueConstants.VALOR_CERO;
 					}
 					PagoBanco pb=new PagoBanco();
 					pb.setIdpagobanco(pgft.getPagobanco().getIdpagobanco());
 					pb.setSaldo(saldo);
 					pagoBancoDAO.actualizar(pb);
 				}	
 			}
 	    }
	}
	
	public List<Visitante> obtenerListadoVisitantesSeleccionados(List<Visitante> lista){
		List<Visitante> listavsel=new ArrayList<Visitante>();
		for(Visitante v:lista){
			if(v.getFlagvisitante()==ValueConstants.FLAG_ACTIVO){
				listavsel.add(v);
			}
		}
		return listavsel;
	}
	
	public void consolidarFichaDirecto(Fichaturismo ft){
		//consolidar ficha(cambiar de estado y fecha)
		Fichaturismo f=new Fichaturismo();
		f.setIdfichaturismo(ft.getIdfichaturismo());
		f.setFechaingreso(ft.getFechaingreso());
		f.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo
				(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO));
		fichaturismoDAO.actualizar(f);
		//consolidar todos los visitantes
		Visitante vis=new Visitante();
		vis.setFlagvisitante(ValueConstants.FLAG_ACTIVO);
		visitanteDAO.actualizarxFicha(f, vis);
			
	}
	
	
	public void actualizarSaldoPagoBancoxIdficha(int idfichaturismo,double saldo){
		List<PagoFichaturismo> listapft= consultarPagosFichaTurismoxId(idfichaturismo);
		for(PagoFichaturismo pft:listapft){
			if(pft.getModalidadpago().getCodigointtipo()==ValueConstants.CODIGO_MODPAGOFICHA_BANCO_FICHA){
				PagoBanco pb=new PagoBanco();
				pb.setIdpagobanco(pft.getPagobanco().getIdpagobanco());
				pb.setSaldo(saldo);
				pagoBancoDAO.actualizar(pb);
				//pagoBancoService.actualizarSaldoPagobanco(pft.getPagobanco().getIdpagobanco(), saldo);
			}
		}
		
	}
	
//	public void validarPagoListadoFichas(List<Fichaturismo> lista,int idusuario){
//		for(Fichaturismo ft: lista){
//			//consolidar ficha
//			Fichaturismo f=new Fichaturismo();
//			f.setIdfichaturismo(ft.getIdfichaturismo());
//			f.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo
//					(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_PAGADO_COMPLETO));
//			fichaturismoDAO.actualizar(f);
//			//historial
//			guardarHistorialAccionFicha(ft.getIdfichaturismo(),idusuario, ValueConstants.CODIGO_TIPO_ACCION_FICHA_PAGAR);
//		}	
//	}
	
	
//	public void adjuntarVoucherAPagoIncompleto(PagoFichaturismo pagoFichaturismo){
//		pagoFichaTurismoDAO.insertar(pagoFichaturismo);
//		Fichaturismo f=new Fichaturismo();
//		f.setIdfichaturismo(pagoFichaturismo.getIdfichaturismo());
//		f.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo
//				(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, ValueConstants.CODIGO_ESTADO_FICHA_PAGADO_COMPLETO));
//		fichaturismoDAO.actualizar(f);
//	}
	
	public void consolidarListadoFichas(List<Fichaturismo> lista,int idusuario){
		for(Fichaturismo ft: lista){
			//consolidar ficha
			consolidarFichaDirecto(ft);
			//actualizar saldo de pago de fichas en el banco
			double saldo=ValueConstants.VALOR_CERO;
			actualizarSaldoPagoBancoxIdficha((int)ft.getIdfichaturismo(), saldo);	
			//historial
			guardarHistorialAccionFicha(ft.getIdfichaturismo(),idusuario, ValueConstants.CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR);
		}
	}
	
	
//	public void guardarHistorialAccionConsolidarFicha(HistFichaturismoAccion histficha){
//		int idtipoaccion= tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_CONSOLIDAR);
//		histficha.getTipoaccionficha().setIdtipo(idtipoaccion);
//		histFichaturismoAccionDAO.insertar(histficha);
//	}
	
	public void guardarHistorialAccionFicha(long idficha,int idusuario,int codtipoaccion){
		HistFichaturismoAccion histficha=new HistFichaturismoAccion();
		histficha.setIdfichaturismo(idficha);
		int idtipoaccion= tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, 
				codtipoaccion);
		histficha.getUsuario().setIdUsuario(idusuario);
		histficha.getTipoaccionficha().setIdtipo(idtipoaccion);
		histficha.setFecha(ProyectoUtil.obtenerFechaHoraActual());
		histFichaturismoAccionDAO.insertar(histficha);
	}
	
	
	
	public void validarPagoBancoFichaturismoxIdficha(int idfichaturismo){
		Fichaturismo ft=new Fichaturismo();
		ft.setFlagpagobanco(ValueConstants.FLAG_ACTIVO);
		ft.setIdfichaturismo(idfichaturismo);
		fichaturismoDAO.actualizar(ft);
		
	}
	
	
	public List<Fichaturismo> consultarFichas(FichaTurismoParam fichaturismoparam){
			return fichaturismoDAO.listar(fichaturismoparam,0);
	}
	
	
	
	public Pagination calcularPaginacionFichasPagoValidado(FichaTurismoParam fichaturismoparam,int tamanio,int numeropagina){
		//fichaturismoparam.getFichaturismo().setFlagpagobanco(ValueConstants.FLAG_ACTIVO);
		fichaturismoparam.getFichaturismo().getEstadopagobanco()
		.setIdtipo(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_PAGO_BANCO, ValueConstants.CODIGO_ESTADO_PAGOBANCO_COMPLETO));
		fichaturismoparam.getFichaturismo().setFlagfichaturismo(ValueConstants.VALOR_CERO);
		return calcularPaginacion(fichaturismoparam, tamanio, numeropagina);
	}
	
	
	
	
     public List<Fichaturismo> consultarFichasPagoValidadoPaginado(FichaTurismoParam fichaturismoparam,int offset, int tamaniopagina){
    	//fichaturismoparam.getFichaturismo().setFlagpagobanco(ValueConstants.FLAG_ACTIVO);
    	 fichaturismoparam.getFichaturismo().getEstadopagobanco()
 		.setIdtipo(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_PAGO_BANCO, ValueConstants.CODIGO_ESTADO_PAGOBANCO_COMPLETO));
 		fichaturismoparam.getFichaturismo().setFlagfichaturismo(ValueConstants.VALOR_CERO);
	    return consultarFichaTurismoPaginado(fichaturismoparam, offset, tamaniopagina);
     }
	
	
	public Pagination calcularPaginacion(FichaTurismoParam fichaturismoparam,int tamanio,int numeropagina){
		fichaturismoparam.getFichaturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO);
		int total= fichaturismoDAO.contar(fichaturismoparam,0);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
     public List<Fichaturismo> consultarFichaTurismoPaginado(FichaTurismoParam fichaturismoparam,int offset, int tamaniopagina){
    	 fichaturismoparam.getFichaturismo().setFlagregistro(ValueConstants.FLAG_ACTIVO);
    	 List<Fichaturismo> lista=fichaturismoDAO.listarPaginado(fichaturismoparam, offset, tamaniopagina,0);
   
    	 for(Fichaturismo ft:lista){
    		 //consultar monto calculado
    		 ft.setMontocalculadopagar
    		 (consultarMontoCalculadoFichaTurismoxId((int)ft.getIdfichaturismo()));
    		 //consultar pagos ficha
    		 List<PagoFichaturismo> listapft=consultarPagosFichaTurismoxId((int)ft.getIdfichaturismo());
    		 double montopft=0;
    		 for(PagoFichaturismo pft:listapft){
    			 montopft=montopft+pft.getMonto();
    		 }
    		 ft.setListaPagoFichaturismo(listapft);
    		 ft.setMontopagado(montopft);
    	 }
    	 return lista;	 
     }
	
     
     
     

     
     
     public Fichaturismo consultarDetalleFichaPagoBancoxIdFichaturismo(int idfichaturismo){
    	 Fichaturismo ft=new Fichaturismo();
    	 ft=consultarDetalleFichaTurismoxId(idfichaturismo);
    	 List<PagoFichaturismo> listapft=consultarPagosFichaTurismoxId((int)ft.getIdfichaturismo());
		 double montopft=0;
		 for(PagoFichaturismo pft:listapft){
			 montopft=montopft+pft.getMonto();
		 }
		 ft.setListaPagoFichaturismo(listapft);
		 ft.setMontopagado(montopft);
    	 //ft.setPagoBanco(consultarPagoBancoxCodigoFichaturismo(ft.getCodigoficha()));
    	 return ft;
    	 
     }
     

     
     
     
     public Fichaturismo consultarDetalleFichaPagoBancoxCodigoFichaturismo(String codigoficha){
    	 Fichaturismo ft=new Fichaturismo();
    	 ft=consultarDetalleFichaTurismoxCodigo(codigoficha);
    	 ft.setPagoBanco(consultarPagoBancoxCodigoFichaturismo(codigoficha));
    	 return ft;
    	 
     }
     
     public Fichaturismo consultarMinimoFichaTurismoxId(long idfichaturismo){
    	 Fichaturismo ft=new Fichaturismo();
    	 List<Fichaturismo> lista= fichaturismoDAO.listarMinimo(new Fichaturismo(idfichaturismo));
    	 if(lista.size()==1){
    		ft=lista.get(0); 
    	 }
    	 return ft;
     }
     
     
     public PagoBanco consultarPagoBancoxCodigoFichaturismo(String codigofichaturismo){
    	 PagoBanco pb=new PagoBanco();
    	 pb.setCadcodigoficha(codigofichaturismo);
    	 return consultarPagoBanco(pb);
     }
     
     public PagoBanco consultarPagoBanco(PagoBanco pagobanco){
    	 PagoBanco pb=new PagoBanco();
    	 List<PagoBanco> lista=new ArrayList<PagoBanco>();
    	 lista=pagoBancoDAO.listar(pagobanco);
    	 if(lista.size()==1){
    		 pb=lista.get(0);
    	 }
    	 return pb;
     }
     
     
//     public long generarFichaTurismo(Fichaturismo fichaturismo){
//    	 
//    	 
//    	 return guardarFichaTurismo(fichaturismo);
//     }

  
// 	Date fregistro=new Date();
// 	fichaturismo.setFecharegistro(fregistro);
 	//generar codigo
 	//fichaturismo.setCodigoficha(generarCodigoFicha(fichaturismo));

     public long generarFichaturismo(Fichaturismo fichaturismo){
    	 long idficha=0;
    	 fichaturismo.setFecharegistro(new Date());
    	 fichaturismo.setCodigoficha(generarCodigoFicha(fichaturismo));
    	 fichaturismo.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_FICHA_TURISMO,
    			 ValueConstants.CODIGO_ESTADO_FICHA_GENERADO));
//    	 idficha=guardarFichaTurismo(fichaturismo);
//    	 int idtipoaccionficha=
//    		 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_GENERAR);
//    	 registrarHistoticoAccionFichaTurismo(idficha, idtipoaccionficha);
    	  return guardarFichaTurismo(fichaturismo);
     }
     
     
//     public long generarConsolidarFichaturismo(Fichaturismo fichaturismo){
//    	 long idficha=0;
//    	 fichaturismo.setFecharegistro(new Date());
//    	 fichaturismo.setCodigoficha(generarCodigoFicha(fichaturismo));
//    	 fichaturismo.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_FICHA_TURISMO,
//    			 ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO));
////    	 idficha=guardarFichaTurismo(fichaturismo);
////    	 int idtipoaccionficha=
////    		 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_GENERAR);
////    	 registrarHistoticoAccionFichaTurismo(idficha, idtipoaccionficha);
//    	  return guardarFichaTurismo(fichaturismo);
//     }
     
     
     public long guardarTemporalFichaTurismo(Fichaturismo fichaturismo){
//    	 long idficha=0;
//    	 idficha=guardarFichaTurismo(fichaturismo);
//    	 int idtipoaccionficha=
//    		 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_GUARDAR);
//    	 registrarHistoticoAccionFichaTurismo(idficha, idtipoaccionficha);
    	 return guardarFichaTurismo(fichaturismo);
     }
     
     public long guardarPermanenteFichaTurismo(Fichaturismo fichaturismo){
    	 fichaturismo.setFlagregistro(ValueConstants.FLAG_ACTIVO);
//    	 long idficha=0;
//    	 idficha=guardarFichaTurismo(fichaturismo);
//    	 int idtipoaccionficha=
//    		 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_GUARDAR);
//    	 registrarHistoticoAccionFichaTurismo(idficha, idtipoaccionficha);
//    	 return idficha;
    	 return guardarFichaTurismo(fichaturismo);
     }
     
     public void guardarPermanenteFichaTurismoConVisitante(long idfichaturismo){
    	 Fichaturismo ft=new Fichaturismo();
    	 ft.setFlagregistro(ValueConstants.FLAG_ACTIVO);
    	 ft.setIdfichaturismo(idfichaturismo);
//    	 int idtipoaccionficha=
//    		 tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ACCION_FICHA_TURISMO, ValueConstants.CODIGO_TIPO_ACCION_FICHA_GUARDAR);
//    	 registrarHistoticoAccionFichaTurismo(idfichaturismo, idtipoaccionficha);
    	 fichaturismoDAO.actualizar(ft);
     }
     
     
     public long guardarFichaTurismo(Fichaturismo fichaturismo){
    	 long idficha=0;
    	 if(fichaturismo.getIdfichaturismo()==0){
    		 
    		 fichaturismo.getEstadoficha().setIdtipo(tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_FICHA_TURISMO, 
    				 ValueConstants.CODIGO_ESTADO_FICHA_CREADO));
    		 //insertar ficha
    		 idficha=fichaturismoDAO.insertar(fichaturismo); 
    		 //guardar guias
    	       	for(GuiaFichaTurismo gft:fichaturismo.getListaGuiaFichaturismo()){
    	       		gft.getFichaturismo().setIdfichaturismo(idficha);
    	       		guiaFichaturismoDAO.insertar(gft);
    	       	}
    	     //guardar tipos de turismo
    	       	for(TipoturismoFichaturismo tft:fichaturismo.getListaTipoturismoFichaturismo()){
    	       		tft.getFichaturismo().setIdfichaturismo(idficha);
    	       		tipoturismoFichaturismoDAO.insertar(tft);
    	       	}
    	        //guardar actividades de turismo
    	       	for(Actividadturismo aft:fichaturismo.getListaActividadturismo()){
    	       		actividadTurismoFichaTurismoDAO.insertar(aft, idficha);
    	       	}
    	 }else{
    		//actualizar	
     		if(fichaturismo.getEmpresaturismo().getIdoperadorturismo()==0){
     			fichaturismo.getEmpresaturismo().setIdoperadorturismo(ValueConstants.VALOR_CERO);
     		}
     		if(fichaturismo.getOperadorturismo().getIdoperadorturismo()==0){
     			fichaturismo.getOperadorturismo().setIdoperadorturismo(ValueConstants.VALOR_CERO);
     		}
     		fichaturismoDAO.actualizar(fichaturismo);
     		idficha=fichaturismo.getIdfichaturismo();
     		//actualizar guias
     		guiaFichaturismoDAO.eliminarDiferencia
     		(fichaturismo.getListaGuiaFichaturismo(), fichaturismo.getIdfichaturismo());
     		if(fichaturismo.getListaGuiaFichaturismo().size()!=0){
     			for(GuiaFichaTurismo gft:fichaturismo.getListaGuiaFichaturismo()){
     				gft.getFichaturismo().setIdfichaturismo(fichaturismo.getIdfichaturismo());
     				guiaFichaturismoDAO.insertarNoDuplicado(gft);
     			}
     	    }
     		//actualizar tipo turismo
     		tipoturismoFichaturismoDAO.eliminarDiferencia
     		(fichaturismo.getListaTipoturismoFichaturismo(), fichaturismo.getIdfichaturismo());
     		if(fichaturismo.getListaTipoturismoFichaturismo().size()!=0){
     			for(TipoturismoFichaturismo tft:fichaturismo.getListaTipoturismoFichaturismo()){
     				tft.getFichaturismo().setIdfichaturismo(fichaturismo.getIdfichaturismo());
     				tipoturismoFichaturismoDAO.insertarNoDuplicado(tft);
     			}
     	    }
     		//actualizar actividad turismo
     		actividadTurismoFichaTurismoDAO.eliminarDiferencia
     		(fichaturismo.getListaActividadturismo(), fichaturismo.getIdfichaturismo());
     		if(fichaturismo.getListaActividadturismo().size()!=0){
     			for(Actividadturismo a:fichaturismo.getListaActividadturismo()){
     				actividadTurismoFichaTurismoDAO.insertarNoDuplicado(a, fichaturismo.getIdfichaturismo());
     			}
     	    }
    		 
    	 }
    	 
    	 return idficha;
    	 
     }
     
     


    
    public String generarCodigoFicha(Fichaturismo fichaturismo){
    	SimpleDateFormat formateador = new SimpleDateFormat("yyMMdd");
    	int numfecha=fichaturismoDAO.obtenerNumeroCorrelativoxFecha(fichaturismo.getFecharegistro());
    	fichaturismo.setNumfecharegistro(numfecha);
    	Rutaturismo rt=rutaturismoService.consultarRutaTurismoxId(fichaturismo.getRutaturismo().getIdrutaturismo());
    	String codruta=rt.getCodrutaturismo();
    	String codfecha=formateador.format(fichaturismo.getFecharegistro());
    	String cadnumfecha=String.valueOf(numfecha);
    	cadnumfecha=StringUtils.leftPad(cadnumfecha, ValueConstants.TAMANIO_NUMFECHA_CODIGO_FICHA_TURISMO,"0"); 
    	String codficha=codruta+codfecha+cadnumfecha;
    	return codficha;
    }
    
    
    
    
    
    
    public Fichaturismo setearDatosFichaTurismoxLista(List<Fichaturismo> lista, int ordenconsulta){
    	Fichaturismo ft=new Fichaturismo();
    	if(lista.size()==1){
    		ft=lista.get(0);
    		long idfichaturismo=ft.getIdfichaturismo();
    		//area natural
    		Areanatural an=new Areanatural();
    		an.setIdareanatural(ft.getAreanatural().getIdareanatural());
    		List<Areanatural> listaanp=new ArrayList<Areanatural>();
    		listaanp=areaNaturalDAO.listar(an);
    		if(listaanp.size()!=0){
    			ft.setAreanatural(listaanp.get(0));
    		}
    		//guias
    		GuiaFichaTurismo gft=new GuiaFichaTurismo();
    		gft.getFichaturismo().setIdfichaturismo(idfichaturismo);
    		ft.setListaGuiaFichaturismo(guiaFichaturismoDAO.listar(gft));
    		//tipos de turismo
    		TipoturismoFichaturismo tipft=new TipoturismoFichaturismo();
    		tipft.getFichaturismo().setIdfichaturismo(idfichaturismo);
    		ft.setListaTipoturismoFichaturismo(tipoturismoFichaturismoDAO.listar(tipft));
    		//actividades
    		ft.setListaActividadturismo(actividadTurismoFichaTurismoDAO.listarxFicha(idfichaturismo));
    		
    }
    	return ft;
    }
    
    public Fichaturismo setearFichaturismoxLista(List<Fichaturismo> lista, int ordenconsulta){
    	Fichaturismo ft=new Fichaturismo();
    	if(lista.size()==1){
    		ft=lista.get(0);
    		long idfichaturismo=ft.getIdfichaturismo();
    		//area natural
    		Areanatural an=new Areanatural();
    		an.setIdareanatural(ft.getAreanatural().getIdareanatural());
    		List<Areanatural> listaanp=new ArrayList<Areanatural>();
    		listaanp=areaNaturalDAO.listar(an);
    		if(listaanp.size()!=0){
    			ft.setAreanatural(listaanp.get(0));
    		}
    		//guias
    		GuiaFichaTurismo gft=new GuiaFichaTurismo();
    		gft.getFichaturismo().setIdfichaturismo(idfichaturismo);
    		ft.setListaGuiaFichaturismo(guiaFichaturismoDAO.listar(gft));
    		//tipos de turismo
    		TipoturismoFichaturismo tipft=new TipoturismoFichaturismo();
    		tipft.getFichaturismo().setIdfichaturismo(idfichaturismo);
    		ft.setListaTipoturismoFichaturismo(tipoturismoFichaturismoDAO.listar(tipft));
    		//actividades
    		ft.setListaActividadturismo(actividadTurismoFichaTurismoDAO.listarxFicha(idfichaturismo));
       		//visitantes
    		List<Visitante> lvisitante=new ArrayList<Visitante>();
    		Visitante vis=new Visitante();
    		vis.getFichaturismo().setIdfichaturismo(idfichaturismo);
    		vis.setFlagregistro(ValueConstants.FLAG_ACTIVO);
    		lvisitante= visitanteDAO.listar(vis, ordenconsulta); //.listarxFicha(idfichaturismo)
    		ft.setListaVisitante(lvisitante);
    		List<BoletajeParam> listabolpar= boletajeDAO.listarBoletajexFicha(idfichaturismo);
    		double montototal=0;
    		for(Visitante v:lvisitante){
    			v.setGrupoedad(visitanteService.determinarGrupoEdadVisitantexFechaNacimiento(v.getFechanacimiento()));
    			montototal+=v.getBoletaje().getValorboletaje();
    		}
    		ft.setMontototal(montototal);
    		for(BoletajeParam bp:listabolpar){
    			for(Visitante v:lvisitante){
    				if(bp.getIdboletaje()==v.getBoletaje().getIdboletaje()){
    					v.getBoletaje().setValorboletaje((bp.getValorboletaje() != null) ? bp.getValorboletaje() : 0);//Agregado 22/06/2011 -> Yonny Coyla
    					bp.getListaVisitante().add(v);
    				}
    			}
    		}
    		ft.setListaBoletajeParam(listabolpar);
    	}
    	return ft;
    }
    
    
    public Fichaturismo consultarDetalleFichaTurismo(FichaTurismoParam fichaturismoparam){
    	List<Fichaturismo> lista= fichaturismoDAO.listar(fichaturismoparam,0);
    	return setearFichaturismoxLista(lista,ValueConstants.ORDEN_CONSULTA_IDBOLETAJE);
    }
    
    public Fichaturismo consultarDetalleFichaTurismo(Fichaturismo fichaturismo){
    	List<Fichaturismo> lista= fichaturismoDAO.listar(fichaturismo);
    	return setearFichaturismoxLista(lista,ValueConstants.ORDEN_CONSULTA_IDBOLETAJE);
    }
    
    
    public Fichaturismo consultarDetalleFichaTurismoxId(int idfichaturismo){
    	Fichaturismo ft=new Fichaturismo();
    	ft.setIdfichaturismo(idfichaturismo);
    	return consultarDetalleFichaTurismo(ft);
    }
    
    public Fichaturismo consultarFichaTurismoxId(int idfichaturismo){
    	Fichaturismo ft=new Fichaturismo();
    	ft.setIdfichaturismo(idfichaturismo);
    	return consultarFichaTurismo(ft);
    }
    
    public Fichaturismo consultarFichaTurismo(Fichaturismo fichaturismo){
    	List<Fichaturismo> lista= fichaturismoDAO.listar(fichaturismo);
    	return setearDatosFichaTurismoxLista(lista,ValueConstants.ORDEN_CONSULTA_NOMBRECOMPVISITANTE);
    }
    
    
    public void eliminarVisitantesTemporalesxIdficha(int idfichaturismo){
    	visitanteDAO.eliminarxIdficha(idfichaturismo);
    } 
    
    
    public void actualizarRegistroIncompletoVisitantesxIdficha(long idfichaturismo){
    	Fichaturismo f=new Fichaturismo();
    	f.setIdfichaturismo(idfichaturismo);
    	Visitante v=new Visitante();
    	v.setFlagcompleto(ValueConstants.VALOR_CERO);
    	v.getBoletaje().setIdboletaje(ValueConstants.VALOR_CERO);
    	visitanteDAO.actualizarxFicha(f, v);
    	visitanteConceptoexoneracionpagoDAO.eliminarxFicha(f);
    }
    
    

    
    public Fichaturismo consultarDetalleFichaTurismoxIdxAnp(int idfichaturismo, int idareanatural){
    	FichaTurismoParam fp=new FichaTurismoParam();
    	fp.getFichaturismo().setIdfichaturismo(idfichaturismo);
    	fp.getFichaturismo().getAreanatural().setIdareanatural(idareanatural);
    	return consultarDetalleFichaTurismo(fp);
    }
    
    public Fichaturismo consultarDetalleFichaTurismoxCodigo(String codigoficha){
    	Fichaturismo ft=new Fichaturismo();
    	ft.setCodigoficha(codigoficha);
    	return consultarDetalleFichaTurismo(ft);
    }
    
    //clausurar 
    public Fichaturismo consultarDetalleFichaPagoBancoxIdxAnp(int idfichaturismo,int idareanatural){
    	FichaTurismoParam fp=new FichaTurismoParam();
    	fp.getFichaturismo().setIdfichaturismo(idfichaturismo);
    	fp.getFichaturismo().getAreanatural().setIdareanatural(idareanatural);
    	Fichaturismo ft=consultarDetalleFichaTurismo(fp);
    	 List<PagoFichaturismo> listapft=consultarPagosFichaTurismoxId((int)ft.getIdfichaturismo());
		 double montopft=0;
		 for(PagoFichaturismo pft:listapft){
			 montopft=montopft+pft.getMonto();
		 }
		 ft.setListaPagoFichaturismo(listapft);
		 ft.setMontopagado(montopft);
		 ft.setListaHistorialaccion(consultarHistorialFichaTurismoxId(idfichaturismo));
    	return ft;
   	}
    
    public Fichaturismo consultarDetalleFichaConPagosxIdxAnp(int idfichaturismo,int idareanatural){
    	FichaTurismoParam fp=new FichaTurismoParam();
    	fp.getFichaturismo().setIdfichaturismo(idfichaturismo);
    	fp.getFichaturismo().getAreanatural().setIdareanatural(idareanatural);
    	Fichaturismo ft=consultarDetalleFichaTurismo(fp);
    	 List<PagoFichaturismo> listapft=consultarPagosFichaTurismoxId((int)ft.getIdfichaturismo());
		 double montopft=0;
		 for(PagoFichaturismo pft:listapft){
			 montopft=montopft+pft.getMonto();
		 }
		 ft.setListaPagoFichaturismo(listapft);
		 ft.setMontopagado(montopft);
		 ft.setListaHistorialaccion(consultarHistorialFichaTurismoxId(idfichaturismo));
    	return ft;
   	}
    
    
    
    public List<HistFichaturismoAccion> consultarHistorialFichaTurismoxId(long idfichaturismo){
    	HistFichaturismoAccion hft=new HistFichaturismoAccion();
    	hft.setIdfichaturismo(idfichaturismo);
    	return histFichaturismoAccionDAO.listar(hft);
    	
    }
    
    public void registrarHistoticoAccionFichaTurismo(long idfichaturismo,int idtipoaccionficha,int idusuario){
    	HistFichaturismoAccion histf=new HistFichaturismoAccion();
    	histf.setIdfichaturismo(idfichaturismo);
    	histf.getTipoaccionficha().setIdtipo(idtipoaccionficha);
    	histf.getUsuario().setIdUsuario(idusuario);
    	histf.setFecha(new Timestamp((new Date()).getTime()));
    	histFichaturismoAccionDAO.insertar(histf);
    }
    
    

    
    public double consultarMontoCalculadoFichaTurismoxId(int idfichaturismo){
    	return visitanteDAO.obtenerMontoCalculadoFichaxId(idfichaturismo);
    }

    public List<PagoFichaturismo> consultarPagosFichaTurismoxId(int idfichaturismo){
    	PagoFichaturismo pft=new PagoFichaturismo();
    	pft.setIdfichaturismo(idfichaturismo);
    	return pagoFichaTurismoDAO.listar(pft);
    }

    public PagoFichaturismo consultarPagoFichaTurismoxId(int idpagofichaturismo){
    	PagoFichaturismo pagoficha=new PagoFichaturismo();
    	PagoFichaturismo pft=new PagoFichaturismo();
    	pft.setIdpagofichaturismo(idpagofichaturismo);
    	List<PagoFichaturismo> lista=pagoFichaTurismoDAO.listar(pft);
    	if(lista.size()==1){
    		pagoficha=lista.get(0);
    	}
    	return pagoficha;
    } 
  
    
    public List<Tipo> listarPeriodosconFechaRegistro(){
    	List<Tipo> listaPeriodo=new ArrayList<Tipo>();
    	List<Map<String, Object>> lista=fichaturismoDAO.listarPeriodoconFechaRegistro();
    	for(Map<String, Object> mapa: lista){
    		Tipo t=new Tipo();
    		//periodo actual
    		//int per= ((Double) mapa.get("periodo")).intValue();
    		Calendar c = Calendar.getInstance();
    		int anioActual = c.get(Calendar.YEAR);
			t.setIdtipo(anioActual);
			t.setNombretipo(String.valueOf(anioActual));
    		listaPeriodo.add(t);
    	}
    	return listaPeriodo;
    }
    
    public List<Tipo> listarPeriodosconFichasConsolidadas(){
    	List<Tipo> listaPeriodo=new ArrayList<Tipo>();
    	int idestadocons=tipoService.obtenerIdtipoxCodigo(ValueConstants.TIPO_ESTADO_FICHA_TURISMO,ValueConstants.CODIGO_ESTADO_FICHA_CONSOLIDADO );
    	List<Map<String, Object>> lista=fichaturismoDAO.listarPeriodoconFichasConsolidadas(idestadocons);
    	for(Map<String, Object> mapa: lista){
    		Tipo t=new Tipo();
    		Calendar c = Calendar.getInstance();
    		int per = c.get(Calendar.YEAR);
    		//int per= ((Double) mapa.get("periodo")).intValue();
			t.setIdtipo(per);
			t.setNombretipo(String.valueOf(per));
    		listaPeriodo.add(t);
    	}
    	return listaPeriodo;
    }
	
    public double calcularMontoFichaTurismoxId(int idficha){
        return visitanteDAO.obtenerMontoCalculadoFichaxId(idficha);	
    }
	
    public double calcularMontoFichaTurismoxVisitantesPresentes(List<Visitante> lista){
        return visitanteDAO.obtenerMontoCalculadoFichaxListadoVisitantes(lista);	
    }
    
}
