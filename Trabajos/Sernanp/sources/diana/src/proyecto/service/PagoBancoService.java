package proyecto.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.PagoBancoDAO;
import proyecto.param.PagoBancoParam;
import proyecto.util.Pagination;
import proyecto.vo.PagoBanco;
@Service
public class PagoBancoService {

	@Autowired
	private PagoBancoDAO pagoBancoDAO;
	@Autowired
	private ParametroService parametroService;
		
	public List<PagoBanco> consultarPagosBancoConSaldoxIdOperadorTurismo(int idoperadorturismo){
		 PagoBancoParam pbpar=new PagoBancoParam();
		 pbpar.setSaldo(ValueConstants.FLAG_ACTIVO);
		 pbpar.getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
		 return pagoBancoDAO.listarxOperador(pbpar);
	}
	
	
	
	
	public void actualizarSaldoPagobanco(PagoBanco pagobanco){
		PagoBanco pb=new PagoBanco();
		pb.setIdpagobanco(pagobanco.getIdpagobanco());
		pb.setSaldo(pagobanco.getSaldo());
		pagoBancoDAO.actualizar(pb);
	}
	
	
	
//	public List<PagoBanco> consultarPagosBancoConSaldoxIdOperadorTurismo(int idoperadorturismo,String codigoficha){
//		 PagoBancoParam pbpar=new PagoBancoParam();
//		 pbpar.setCodigoficha(codigoficha);
//		 pbpar.getOperadorturismo().setIdoperadorturismo(idoperadorturismo);
//		 return pagoBancoDAO.listarDisponiblexOperador(pbpar);
//	}
	
	public PagoBanco consultarPagoBancoxId(int idpagoficha){
		PagoBanco pb=new PagoBanco();
		List<PagoBanco> lista=pagoBancoDAO.listar(new PagoBanco(idpagoficha));
		if(lista.size()==1){
			pb=lista.get(0);
		}
		return pb;
	}
	
	
	public List<PagoBanco> leerListadoPagoBanco(String rutadoc){
		 List<PagoBanco> lista=new ArrayList<PagoBanco>(); 
		try {
			File file = new File(rutadoc);
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	        String linea=scanner.nextLine();  
	        if(!linea.substring(0, ValueConstants.IDX_FINAL_ARCHIVO).equals(ValueConstants.FINAL_ARCHIVO)){
	        		PagoBanco pb=new PagoBanco();
		            pb.setCadcodigotributo(linea.substring(0, ValueConstants.IDXF_CODIGO_TRIBUTO));
		        	pb.setCadtipodocumento(linea.substring(ValueConstants.IDXF_CODIGO_TRIBUTO,ValueConstants.IDXF_TIPO_DOCUMENTO));
		            pb.setCadnumerodocumento(linea.substring(ValueConstants.IDXF_TIPO_DOCUMENTO, ValueConstants.IDXF_NUMERO_DOCUMENTO));
		        	pb.setCadcodigoficha(linea.substring(ValueConstants.IDXF_NUMERO_DOCUMENTO,ValueConstants.IDXF_CODIGO_SERNANP));
		        	pb.setCadnumeroregistro(linea.substring(ValueConstants.IDXF_CODIGO_SERNANP, ValueConstants.IDXF_NUMERO_REGISTROS));
		        	pb.setCadimporte(linea.substring(ValueConstants.IDXF_NUMERO_REGISTROS, ValueConstants.IDXF_IMPORTE));
		        	pb.setCadfechamovimiento(linea.substring(ValueConstants.IDXF_IMPORTE,ValueConstants.IDXF_FECHA_MOVIMIENTO));
		        	pb.setCadnumerovoucher(linea.substring(ValueConstants.IDXF_FECHA_MOVIMIENTO, ValueConstants.IDXF_NUMERO_SECUENCIA));
		        	pb.setCadhora(linea.substring(ValueConstants.IDXF_NUMERO_SECUENCIA, ValueConstants.IDXF_HORA));
		        	pb.setCaddigitochequeo(linea.substring(ValueConstants.IDXF_HORA, ValueConstants.IDXF_DIGITO_CHEQUEO));
		        	pb.setCadcodigoagencia(linea.substring(ValueConstants.IDXF_DIGITO_CHEQUEO, ValueConstants.IDXF_COD_AGENCIA));
		        	pb.setCadcodigocajero(linea.substring(ValueConstants.IDXF_COD_AGENCIA, ValueConstants.IDXF_COD_CAJERO));
		        	pb.setCadfiller(linea.substring(ValueConstants.IDXF_COD_CAJERO, ValueConstants.IDXF_FILLER));
		        	pb.setCodigopagobanco(pb.getCadfechamovimiento()+pb.getCadhora()+pb.getCadcodigoagencia()+pb.getCadcodigocajero());
		        	//pb.setIdpagobanco(pb.getCadfechamovimiento()+pb.getCadhora()+pb.getCadcodigoagencia()+pb.getCadcodigocajero());
		        	pb.setIdtabla(ValueConstants.TIPO_MODALIDAD_PAGO_FICHA_TURISMO);
		        	pb.setCodigointtipo(ValueConstants.CODIGO_MODPAGOFICHA_BANCO_FICHA);
		        	//importe
		        	int timporte=ValueConstants.IDXF_IMPORTE-ValueConstants.IDXF_NUMERO_REGISTROS;
		        	int idxf_enteroimporte=timporte-2;
		        	double pentero=Double.parseDouble(pb.getCadimporte().substring(0, idxf_enteroimporte));
		        	int decimal=Integer.parseInt(pb.getCadimporte().substring(idxf_enteroimporte, timporte));
		        	double pdecimal=(decimal/(double)100);
		        	pb.setImporte(pentero+pdecimal);
		        	//fecha
		        	String anio=pb.getCadfechamovimiento().substring(0, 4);
		        	String mes=pb.getCadfechamovimiento().substring(4, 6);
		        	String dia=pb.getCadfechamovimiento().substring(6, 8);
		        	String hora=pb.getCadhora().substring(0, 2);
		        	String min=pb.getCadhora().substring(2, 4);
		        	String seg=pb.getCadhora().substring(4, 6);
		        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	String cadf=anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+seg;
		        	try {
						Date fec= sdf.parse(cadf);
						pb.setFechamovimiento(new Timestamp(fec.getTime()));
		        	} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        	lista.add(pb);	
	        	}
	            
	          }
	          scanner.close();
	        } catch (FileNotFoundException e) {
	          e.printStackTrace();
	          System.out.print(e.toString());
	        }
	        return lista;
	}
	
	
	
	public void insertarNoDuplicadoListadoPagoBanco(List<PagoBanco> lista){
		for(PagoBanco pb:lista){
		    pagoBancoDAO.insertarNoDuplicado(pb);
			//pagoBancoDAO.insertarNoDuplicado(pb);
		}
	}
	
	
	
	
	public Pagination calcularPaginacion(PagoBancoParam pagoBancoParam,int tamanio,int numeropagina){
		int total= pagoBancoDAO.contar(pagoBancoParam);
		Pagination paginacion=new Pagination();
		paginacion.setTotal(total);
		paginacion.setItemsxpag(tamanio);
		paginacion.setPagina(numeropagina);
		paginacion.paginar1();
		return paginacion;
	}
	
	public List<PagoBanco> consultarPagoBancoPaginado(PagoBancoParam pagoBancoParam,int offset, int tamaniopagina){
		return pagoBancoDAO.listarPaginado(pagoBancoParam, offset, tamaniopagina);
    }
	
	public void copiarPagosBancoDeArchivosATablas(){
		Map<String,String> mapParametros= parametroService.obtenerParametros();
		String rutadir=mapParametros.get(ValueConstants.RUTA_ARCHIVOS_PAGOSBANCO);
		 File dir = new File(rutadir);
		 File[] ficheros = dir.listFiles();
		 for (int x=0;x<ficheros.length;x++){  
		    	String nomfichero=ficheros[x].getName();
		    	if(nomfichero.length()>10){
		    		String nomini=nomfichero.substring(0,10);
		    		if(nomini.equals(ValueConstants.NOMBRE_ARCHIVO)){
		    			String rutadoc=nomfichero;
			    		rutadoc=rutadir+rutadoc;
			    		List<PagoBanco> lista =leerListadoPagoBanco(rutadoc);
			    		if(lista.size()!=0){
							 insertarNoDuplicadoListadoPagoBanco(lista); 
						 }
		    		}	
		    	}		    	
		  }
	}
	
	
	
	
}
