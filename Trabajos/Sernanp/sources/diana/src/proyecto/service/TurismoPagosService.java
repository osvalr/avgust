package proyecto.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import proyecto.dao.TurismoPagosDao;
import proyecto.util.Funciones;
import proyecto.vo.Rutaturismo;
import proyecto.vo.TurismoPagos;
import proyecto.vo.TurismoPagosDetalle;

@Service
public class TurismoPagosService {
		
	private TurismoPagosDao turismopagosDAO;
			
	public void setTurismopagosDAO(TurismoPagosDao turismopagosDAO) {
		this.turismopagosDAO = turismopagosDAO;
	}

	// JCEV 17-07-2012
//	public List<TurismoPagos> consultarListaRegPagoBnkNacion(Date dFecIni, Date dFecFin,
//			 String strCodCat, String strCodArea, 
//			 String strRuta, String strForm){
	//public List<TurismoPagos> consultarListaRegPagoBnkNacion(Date dFecIni, Date dFecFin, Rutaturismo rutaturismo, String strForm){
	public List<TurismoPagos> consultarListaRegPagoBnkNacion(Date dFecIni, Date dFecFin, TurismoPagos turismopagos, String strForm){
		SimpleDateFormat sdf     = null;
		List<TurismoPagos> lista = null;
		TurismoPagos tur         = null;
		Date dFecha              = null;
		try {
			sdf    = new SimpleDateFormat(strForm);			
			tur    = new TurismoPagos();
			lista  = new ArrayList<TurismoPagos>();
			dFecha = Funciones.fechaHoyDmy(strForm);
			if(dFecFin.equals(dFecIni) || dFecIni.equals(dFecha) ){
				dFecIni = Funciones.restaDias(dFecIni, 1);
				dFecFin = Funciones.restaDias(dFecFin, 1);
			}else{
				if(dFecIni.equals(dFecha) || dFecIni.after(dFecha) ){
					dFecIni = Funciones.restaDias(dFecIni, 1);
				}
				if(dFecFin.equals(dFecha) || dFecFin.after(dFecha) ){
					dFecFin = Funciones.restaDias(dFecFin, 1);
				}
			}
			tur.setStrFecIni(sdf.format(dFecIni));
			tur.setStrFecFin(sdf.format(dFecFin));
			
			//tur.setStrRutaTurimo(rutaturismo.getCodrutaturismo());
			
			if( turismopagos.getStrRutaTurimo() != null && !(turismopagos.getStrRutaTurimo()).equals("")){				
				tur.setStrRutaTurimo(turismopagos.getStrRutaTurimo());
			}
			
			tur.setStrCodCateg(turismopagos.getStrCodCateg());			
			tur.setStrCodAreaNat(turismopagos.getStrCodAreaNat());
			//tur.setStrCodCateg(rutaturismo.getCodrutaturismo().substring(0, 2));			
			//tur.setStrCodAreaNat(rutaturismo.getCodrutaturismo().substring(0, 4));
			
			lista = turismopagosDAO.listarPagos(tur, strForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;	
	}

	// JCEV 07-08-2012
	public List<TurismoPagosDetalle> consultarListaDetalleRegPagoBnkNacion(String strId){
		List<TurismoPagosDetalle> lista = null;
		try {
			lista = new ArrayList<TurismoPagosDetalle>();
			lista = turismopagosDAO.ListaDetallePagos(strId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;	
	}

}