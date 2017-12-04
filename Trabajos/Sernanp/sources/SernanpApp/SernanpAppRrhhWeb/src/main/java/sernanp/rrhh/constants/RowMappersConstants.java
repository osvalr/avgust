package sernanp.rrhh.constants;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.Areaorganica;
import sernanp.rrhh.vo.Cargo;
import sernanp.rrhh.vo.Categoriaanp;
import sernanp.rrhh.vo.Idioma;
import sernanp.rrhh.vo.LoginVO;
import sernanp.rrhh.vo.Pais;
import sernanp.rrhh.vo.PersonalActividadVO;
import sernanp.rrhh.vo.PersonalAsistenciaResumenVO;
import sernanp.rrhh.vo.PersonalAsistenciaTurnoVO;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalContratoAdendaVO;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.PersonalDescuentosVO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalLicenciasVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalTardanzaVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.PersonalVacacionesGoceVO;
import sernanp.rrhh.vo.PersonalVacacionesVO;
import sernanp.rrhh.vo.PersonaldiasnolaborablesVO;
import sernanp.rrhh.vo.Personanatural;
import sernanp.rrhh.vo.RolModulo;
import sernanp.rrhh.vo.Tipo;
import sernanp.rrhh.vo.Ubigeo;
import sernanp.rrhh.vo.Usuario;
import sernanp.rrhh.vo.UsuarioRol;

public class RowMappersConstants {	
	
	  public static final class UsuarioMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Usuario u=new Usuario();
	       try {
	       //usuario   
	       u.setIdUsuario(rs.getInt("idusuario"));
	       u.setUsername(rs.getString("usuario"));
	       u.setClave(rs.getString("clave")); // Agregado 29/04/11 15:27 (Yonny)
	       u.setEstado(rs.getInt("estado"));
	       u.setLoginfirst(rs.getInt("loginfirst"));
	       u.setIdpersonanatural(rs.getInt("idpersonanatural"));
	       u.setApepat(rs.getString("apepat"));
	       u.setApemat(rs.getString("apemat"));
	       u.setNombre(rs.getString("nombre"));
	       u.getPais().setIdpais(rs.getInt("idpais"));
	       u.getPais().setNompais(rs.getString("nompais"));
	       u.getPais().setCodpais(rs.getString("codpais"));
	       u.getRol().setIdrol(rs.getInt("idrol"));       
	       u.getPersonal().setIdpersonal(rs.getInt("idpersonal"));
	       u.getPersona().setIdpersona(rs.getInt("idpersona"));//Agregado 26-05-2012 (Y.C.B.)
	       //area organica
	       u.getAreaorganica().setIdarea(rs.getInt("idarea"));
	       u.getAreaorganica().setDesarea(rs.getString("desarea"));
	       //sede
	       u.getAreaorganica().getSede().setIdsede(rs.getInt("idsede"));
	       u.getAreaorganica().getSede().setDessede(rs.getString("dessede"));
	       //area natural
	       u.getAreaorganica().getSede().getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
	       //u.getAreaorganica().getSede().getAreanatural().setDesareanatural(rs.getString("desareanatural"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;  
	    }
	  }
	
	public static final class LoginMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	    	  LoginVO lg		= new LoginVO();
	       try {
	    	lg.setIntIdLogin(rs.getInt("idlogin"));
			lg.setStrClave(rs.getString("clave"));
			lg.setStrClaveMD5(rs.getString("clavemd5"));
			lg.setStrUsuario(rs.getString("usuario"));
			lg.setIntIdSistema(rs.getInt("idsistema"));
			lg.setIntIdUsuario(rs.getInt("idusuario"));
			lg.setDteFecha(rs.getTimestamp("fecha"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lg;  
	    }
	  }
	
	// Agregado 02-08-2013 (D.V.)
		public static final class UsuarioRolMapper implements RowMapper {
			public Object mapRow(ResultSet rs, int rowNum) {
				UsuarioRol ur		= new UsuarioRol();
				try {
					ur.getRol().setIdrol(rs.getInt("idrol"));
					ur.getRol().setFlagrol(rs.getString("flagrol"));
					ur.getRol().setDesrol(rs.getString("flagrol"));
					
					ur.getUsuario().setIdUsuario(rs.getInt("idusuario"));
					ur.getUsuario().setUsername(rs.getString("usuario"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ur;
			}
		}
	
	public static final class RolModuloMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       RolModulo rm=new RolModulo();
	       try {
	       rm.getRol().setIdrol(rs.getInt("idrol"));
	       rm.getRol().setFlagrol(rs.getString("flagrol"));
		   rm.getModulo().setIdmodulo(rs.getInt("idmodulo"));
		   rm.getModulo().setNombremodulo(rs.getString("nombremodulo"));
		   rm.getModulo().setImgmodulo(rs.getString("imgmodulo"));
		   rm.getModulo().setNivelmodulo(rs.getInt("nivelmodulo"));
		   rm.getModulo().setNiveldependemodulo(rs.getInt("niveldependemodulo"));
		   rm.getModulo().setOrdenmodulo(rs.getInt("ordenmodulo"));
		   rm.getModulo().setFlagmodulo(rs.getInt("flagmodulo"));
		   rm.getModulo().setHrefmodulo(rs.getString("hrefmodulo"));
		   rm.setPesorol(rs.getInt("pesorol"));
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rm;  
	    }
	  }
	
	
	public static final class AreanaturalMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Areanatural an=new Areanatural();
	       try {
	       an.setIdareanatural(rs.getInt("idareanatural"));
	       an.setDesareanatural(rs.getString("desareanatural"));
	       an.setCodareanatural(rs.getString("codareanatural"));
	       an.setFlagestado(rs.getInt("estado"));
		   an.getCategoriaanp().setIdcategoriaanp(rs.getInt("idcategoriaanp"));
		   an.getCategoriaanp().setCodcategoriaanp(rs.getString("codcategoriaanp"));
		   an.getCategoriaanp().setDescategoriaanp(rs.getString("descategoriaanp"));
		   an.getCategoriaanp().setFlagestado(rs.getInt("estadocat"));
	       an.getCategoriaanp().setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
	       an.getAdministracionAreanatural().setIdadministracionareanatural(rs.getInt("idadministracionareanatural"));
	       //an.setIdadministracionareanatural(rs.getInt("idadministracionareanatural"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return an;  
	    }
	  } 	
	 
	
	  public static final class AreaorganicaMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Areaorganica ao=new Areaorganica();
	       try {
	       ao.setIdarea(rs.getInt("idarea"));
	       ao.setDesarea(rs.getString("desarea"));
	       ao.setCodarea(rs.getString("codarea"));
	       ao.getSede().getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
	       
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ao;  
	    }
	  } 
	      
	    
	  public static final class PersonalMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       PersonalVO p=new PersonalVO();
	       try {
	       p.setIdpersonal(rs.getInt("idpersonal"));
	       p.setIdpersonanatural(rs.getInt("idpersonanatural"));
	       p.getAreaorganica().setIdarea(rs.getInt("idarea"));
	       p.getAreaorganica().setDesarea(rs.getString("desarea"));
	       p.getCargo().setIdcargo(rs.getInt("idcargo"));
	       p.setMailpersonal(rs.getString("mailpersonal"));
	       p.setApepat(rs.getString("apepat"));
	       p.setApemat(rs.getString("apemat"));
	       p.setNombre(rs.getString("nombre"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;  
	    }
	  } 
	   
	  public static final class TipoMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Tipo t=new Tipo();
	       try {
	       t.setIdtipo(rs.getInt("idtablatipo"));
	       t.setNombretipo(rs.getString("destablatipo"));
	       t.setOrdentipo(rs.getInt("ordtablatipo"));
	       t.setAbrevtipo(rs.getString("abrtablatipo"));
	       t.setIdtabla(rs.getInt("idtabla"));
	       t.setCodigointtipo(rs.getInt("codinttablatipo"));
			t.setMensajetipo(rs.getString("mensajetablatipo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;  
	    }
	  }
	  
	  
	  public static final class TipoDocumentoIdentidadMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Tipo t=new Tipo();
	       try {
	       t.setIdtipo(rs.getInt("idtipodocumento"));
	       t.setNombretipo(rs.getString("nombretipodocumento"));
	      
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;  
	    }
	  }
	  
	   
	  
	  public static final class IdiomaMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Idioma i=new Idioma();
	       try {
	       i.setIdidioma(rs.getInt("ididioma"));
	       i.setNombreidioma(rs.getString("nombreidioma"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;  
	    }
	  }
	  
	   
	  public static final class PaisMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Pais p=new Pais();
	       try {
	       	  p.setIdpais(rs.getInt("idpais"));
	       	  p.setCodpais(rs.getString("codpais"));
	       	  p.setNompais(rs.getString("nompais"));
	       	  p.setNacionalidad(rs.getString("nacpais"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;  
	    }
	  }
	  
	   
	  public static final class CategoriaAnpMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Categoriaanp cat=new Categoriaanp();
	       try {
	           cat.setIdcategoriaanp(rs.getInt("idcategoriaanp"));
	           
	           //Agregado 24/07/12
	           cat.setCodcategoriaanp(rs.getString("codcategoriaanp"));
	           
	           cat.setDescategoriaanp(rs.getString("descategoriaanp"));
	           cat.setFlagestado(rs.getInt("estado"));
	           cat.setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;  
	    }
	  }
	  
	    
	  public static final class UbigeoMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Ubigeo u=new Ubigeo();
	       try {
	       u.setIdubigeo(rs.getInt("idubigeo"));
		   u.setCoddepartamento(rs.getString("coddpto"));	
		   u.setCodprovincia(rs.getString("codprov"));
		   u.setCoddistrito(rs.getString("coddist"));
		   u.setNombre(rs.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;  
	    }
	  }
	  
	  // Agregado 03-08-2013 (D. V. R)
	  public static final class Personal_Asistencia implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalAsistenciaVO pa 	= null;
	    	  PersonalVO p 					= null;	    
	    	  Cargo c								= null;
	    	  PersonalContratoVO pc		= null;
	      
	       try {
	    	   
	    	   pa 	= new PersonalAsistenciaVO();
	    	   p 		= new PersonalVO();
	    	   c		= new Cargo(); 
	    	   pc		= new PersonalContratoVO();
	    	   
	    	   pa.setDte_fecha(rs.getDate("dte_fecha"));
	    	   pa.setHor_hor_ingreso(rs.getTime("asistencia_ingreso"));
	    	   pa.setHor_hor_salida(rs.getTime("asistencia_Salida"));
	    	   pa.setMinutostardanza(rs.getTime("minutos_tardanza"));
	    	   pa.setEstado(rs.getInt("int_estado"));
	    	   pa.setEstadoTmp(rs.getInt("int_estado_tmp"));
	    	   pa.setInt_vac_lic(rs.getInt("int_vac_lic"));
	    	   pa.setDescoficina(rs.getString("oficina").toUpperCase());
	    	   
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   p.setNumerodocumento(rs.getString("numerodoc"));
	    	   p.setNombre(rs.getString("nombre"));
	    	   p.setApepat(rs.getString("apepat"));
	    	   p.setApemat(rs.getString("apemat"));	  
	    	   
	    	   pc.setDte_fec_inicio(rs.getDate("dte_fec_inicio"));
	    	   pc.setDte_fec_cese(rs.getDate("dte_fec_cese"));
	    	   c.setNombrecargo(rs.getString("cargo"));
	    	   
	    	   p.setCargo(c);
	    	   
	    	   pa.setPersonalContrato(pc);
	    	   
	    	   pa.setPersonal(p);
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pa;
	    }
	  } 
	  
	  
	  
	// Agregado 19-08-2014 (D. V. R)
		  public static final class Personal_estado_Asistencia implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalAsistenciaVO pa 	= null;
		      
		       try {
		    	   
		    	   pa 	= new PersonalAsistenciaVO();
		    	   pa.setHor_hor_ingreso(rs.getTime("asistencia_ingreso"));
		    	   pa.setHor_hor_salida(rs.getTime("asistencia_Salida"));
		    	   pa.setMinutostardanza(rs.getTime("minutos_tardanza"));
		    	   pa.setEstado(rs.getInt("int_estado"));
		    	   pa.setEstadoTmp(rs.getInt("int_estado_tmp"));
		    	   pa.setInt_vac_lic(rs.getInt("int_vac_lic"));//ADD 07-0-2014 (D.V.R)

			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pa;
		    }
		  } 
		  
		  
	  
	  
	  public static final class Personal_Incidencias implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalAsistenciaVO pa 	= null;      
	       try {
	    	   
	    	   pa 	= new PersonalAsistenciaVO();
	    	   pa.setIncidencias(rs.getString("incidencias"));
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pa;
	    }
	  } 
	  
	  
	  // Agregado 15-09-2013 (D. V. R)
	  public static final class Personal_Descuentos implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	    	  
	    	  PersonalVO p 				= null;
	    	  PersonalDescuentosVO pd 	= null;
	    	  String [] pt				= null;
	      
	       try {
	    	   
	    	   p 	= new PersonalVO();
	    	   pd 	= new PersonalDescuentosVO();    	   
	    	   
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   p.setNumerodocumento(rs.getString("numerodoc"));
	    	   p.setNombre(rs.getString("nombre"));
	    	   p.setApepat(rs.getString("apepat"));
	    	   p.setApemat(rs.getString("apemat"));
	    	   pd.setInasistencias(rs.getInt("faltas"));
	    	   pd.setMinutos_tardanza(rs.getInt("minutos_tardanza"));    	   
	    	   pd.setPermisos(rs.getInt("permisos"));
	    	   if(rs.getTime("permisos_tiempo") != null){
	    		   pt = rs.getTime("permisos_tiempo").toString().split(":");
	    		   pd.setPermiso_horas(Integer.parseInt(pt[0]));
	    		   pd.setPermiso_minutos(Integer.parseInt(pt[1]));
	    	   }
	//    	   pd.setPermiso_tiempo(rs.getTime("permisos_tiempo"));    	   
	    	   pd.setTotal_descuento(rs.getDouble("total_desc"));
	//    	   pd.setTsp_fec_pers_desc(rs.getTimestamp("tsp_fec_pers_desc"));
	    	   pd.setInt_periodo_desc(rs.getInt("int_periodo_desc"));
	    	   pd.setInt_mes_desc(rs.getInt("int_mes_desc"));   

	    	   //18-07-2014
	    	   pd.setLicencias_sgh(rs.getInt("licencias_sgh"));
	    	   
	    	   pd.setPersonaldescuento(p);
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	    }
	  } 
	  
	  
	  
	  public static final class listarPeriodoMesDescuento implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalDescuentosVO pd 	= null;
			  try {
				  pd = new PersonalDescuentosVO();
				pd.setInt_periodo_desc(rs.getInt("int_periodo_desc"));
				pd.setInt_mes_desc(rs.getInt("int_mes_desc"));
				pd.setNom_mes_desc(Funciones.nombreMes(rs.getInt("int_mes_desc")));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			  return pd;
		  }
	  }
	  
	  
	  
	  
	  public static final class listarPeriodoDescuento implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalDescuentosVO pd 	= null;
			  try {
				pd = new PersonalDescuentosVO();
				pd.setInt_periodo_desc(rs.getInt("int_periodo_desc"));				
			} catch (Exception e) {
				// TODO: handle exception
			}
			  return pd;
		  }
	  }
	  
	  
	  
	  public static final class listarMesDescuento implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalDescuentosVO pd 	= null;
			  try {
				  pd = new PersonalDescuentosVO();
				  pd.setInt_mes_desc(rs.getInt("int_mes_desc"));
				  pd.setNom_mes_desc(Funciones.nombreMes(rs.getInt("int_mes_desc")));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			  return pd;
		  }
	  }
	  
	  
	  
	  public static final class PersonaNatural implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalVO p = null;
	      
	       try {
	    	   
	    	   p = new PersonalVO();
	    	   
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   p.setNumerodocumento(rs.getString("numerodoc"));
	    	   p.setNombre(rs.getString("nombre"));
	    	   p.setApepat(rs.getString("apepat"));
	    	   p.setApemat(rs.getString("apemat"));
	    	      	   
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	    }
	  } 
	  
	  
	  public static final class Personal implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalVO ps 	= null;
	    	  Personanatural pn = null;
	      
	       try {
	    	   
	    	   ps = new PersonalVO();
	    	   pn = new Personanatural();    	   
	    	   ps.setIdpersonal(rs.getInt("idpersonal"));
	    	   pn.setIdpersonanatural(rs.getInt("idpersonanatural"));
	    	   pn.setNumerodocumento(rs.getString("numerodoc"));
	    	   ps.setPersonanatural(pn);    	   
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	    }
	  } 
	  
	  
	  
	  public static final class PersonalTurno implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVO p					= new PersonalVO();
			  PersonalAsistenciaTurnoVO pt 	= new PersonalAsistenciaTurnoVO();
			  try {
				  
				 pt.setHor_hor_ingreso(rs.getTime("hor_hor_ingreso"));
				 pt.setHor_hor_salida(rs.getTime("hor_hor_salida"));
				 p.setTurno(pt);
				 
			} catch (Exception e) {
				// TODO: handle exception
			}
			return p;  
		  }	  
	  }
	  
	  
	  public static final class PersonalListaMarcacion implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalMarcacionVO pm 		= new PersonalMarcacionVO();
	    	  Tipo	tm 						= new Tipo(33);
	    	  PersonalActividadVO pa		= new PersonalActividadVO();
	      
	       try {
	    	   tm.setIdtipo(rs.getInt("idtablatipo"));
	    	   tm.setDestipo(rs.getString("destablatipo"));
	    	   pa.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
	    	   pa.setVar_des_per_activ(rs.getString("var_des_per_activ"));
	    	   pm.setSrl_id_personal_marcacion(rs.getInt("srl_id_pers_marc"));
	    	   pm.setDte_fec_marc(rs.getDate("dte_fec_marc"));
	    	   pm.setHor_hor_marc(rs.getTime("hor_hor_marc"));
	    	   pm.setVar_descripcion(rs.getString("var_descripcion"));
	
	    	   pm.setTipomarcacion(tm);
	    	   pm.setPersonalActividad(pa);
	    	   pm.getPersonal().setIdpersonal(rs.getInt("idpersonal"));
	    	   
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pm;
	    }
	  } 
	  
	  
	  
	  
	  
	  public static final class PersonalMarcacion implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalMarcacionVO pm 		= new PersonalMarcacionVO();
	    	  Tipo	tm 						= new Tipo(33);
	    	  PersonalActividadVO pa		= new PersonalActividadVO();
//	    	  PersonalAsistenciaTurnoVO pt 	= new PersonalAsistenciaTurnoVO();
	      
	       try {
	    	   tm.setIdtipo(rs.getInt("idtablatipo"));
	    	   tm.setDestipo(rs.getString("destablatipo"));
	    	   pa.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
	    	   pa.setVar_des_per_activ(rs.getString("var_des_per_activ"));
//	    	   pt.setHor_hor_ingreso(rs.getTime("hor_hor_ingreso"));
//	    	   pt.setHor_hor_salida(rs.getTime("hor_hor_salida"));
	    	   pm.setSrl_id_personal_marcacion(rs.getInt("srl_id_pers_marc"));
	    	   pm.setDte_fec_marc(rs.getDate("dte_fec_marc"));
	    	   pm.setHor_hor_marc(rs.getTime("hor_hor_marc"));
	    	   pm.setVar_descripcion(rs.getString("var_descripcion"));
	    	   pm.setSrl_id_papeleta(rs.getInt("srl_id_desp"));
	
	    	   pm.setTipomarcacion(tm);
	    	   pm.setPersonalActividad(pa);
//	    	   pm.setPersonalAsistenciaTurno(pt);
	    	   pm.getPersonal().setIdpersonal(rs.getInt("idpersonal"));
	    	   
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pm;
	    }
	  } 
	  
	  
	
	  public static final class PersonalTardanza implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalAsistenciaVO pa 	= new PersonalAsistenciaVO();
	    	  PersonalVO p	= new PersonalVO();
	       try {
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   p.setNombre(rs.getString("nombre"));
	    	   p.setApepat(rs.getString("apepat"));
	    	   p.setApemat(rs.getString("apemat"));
	    	   p.setNumerodocumento(rs.getString("numerodoc"));
	    	   
	    	   pa.setHor_hor_ingreso(rs.getTime("asistencia_ingreso"));
	    	   pa.setMinutostardanza(rs.getTime("minutos_tardanza"));
	    	   pa.setEstado(rs.getInt("int_estado"));
	    	   
	    	   pa.setPersonal(p);
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pa;
	    }
	  } 
	  
	  
	  
	  public static final class listaPersonalconTardanzaTMP implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalTardanzaVO pt 	= new PersonalTardanzaVO();
	    	  PersonalVO p				= new PersonalVO();
	    	  PersonalContratoVO pc 	= new PersonalContratoVO(); 
	       try {
	
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   pc.setNum_sueldo(rs.getDouble("num_sueldo"));
	    	   pt.setInt_min_tard(rs.getInt("tardanza"));
	    	   pt.setPersonalContratoVO(pc);
	    	   pt.setPersonal(p);
	    	       	       	   	   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pt;
	    }
	  } 
	
	  
	  
	  
	  
	  public static final class listaPersonalconTardanza implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalTardanzaVO pt 	= new PersonalTardanzaVO();
	    	  PersonalVO p				= new PersonalVO();
	    	  PersonalContratoVO pc 	= new PersonalContratoVO(); 
	       try {
	
	    	   p.setIdpersonal(rs.getInt("idpersonal"));
	    	   pc.setNum_sueldo(rs.getDouble("num_sueldo"));
	    	   pt.setInt_min_tard(rs.getInt("tardanza"));
	    	   pt.setDte_fec_pers_tard(rs.getDate("dte_fecha"));
	    	   pt.setPersonalContratoVO(pc);
	    	   pt.setPersonal(p);
	    	       	       	   	   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pt;
	    }
	  } 
	
	  
	
	  
	  public static final class listapersonaltardanzaDesc implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	PersonalDescuentosVO pad 	= new PersonalDescuentosVO();
	    	PersonalVO pa				= new PersonalVO();
	    	Tipo td						= new Tipo();
	
	       try {
	    	   
	    	   pad.setInt_periodo_desc(Funciones.obtenerAnioOfDescuento());
	    	   pad.setInt_mes_desc(Funciones.obtenerNroMesDescuento());
	    	   pad.setNum_monto_desc(rs.getDouble("descuento"));
	    	   pad.setTsp_fec_pers_desc(Funciones.fechaHoyTimeStamp());
	
	    	   pa.setIdpersonal(rs.getInt("idpersonal"));
	    	   td.setIdtipo(ValueConstants.TipoDescuentoTardanza);
	    	   pad.setPersonaldescuento(pa);
	    	   pad.setTipodescuento(td);
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pad;
	    }
	  } 
	  
	  
	  
	  public static final class listapersonalinasistenciaDesc implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	PersonalDescuentosVO pad 	= new PersonalDescuentosVO();
	    	PersonalVO pa				= new PersonalVO();
	    	Tipo td						= new Tipo();
	
	       try {
	    	   
	    	   pad.setInt_periodo_desc(Funciones.obtenerAnioOfDescuento());
	    	   pad.setInt_mes_desc(Funciones.obtenerNroMesDescuento());
	//    	   pad.setNum_monto_desc(rs.getDouble("descuento"));
	    	   pad.setNum_monto_desc(rs.getDouble("descuento")+rs.getDouble("permisos_dias")+rs.getDouble("permisos_tiempo"));
	    	   pad.setTsp_fec_pers_desc(Funciones.fechaHoyTimeStamp()); 
	
	    	   pa.setIdpersonal(rs.getInt("idpersonal"));
	    	   td.setIdtipo(ValueConstants.TipoDescuentoInasistencia);
	    	   pad.setPersonaldescuento(pa);
	    	   pad.setTipodescuento(td);
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pad;
	    }
	  } 
	  
	  
		
	  
	   
	  
	  
	  
	  public static final class listainasistenciasPermisosxidpersonal implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	PersonalAsistenciaVO pa 	= new PersonalAsistenciaVO();
	    	
	       try {
	
	    	   pa.setDte_fecha(rs.getDate("dte_fecha"));
	    	   pa.setEstado(rs.getInt("int_estado"));
	    	   pa.setInt_vac_lic(rs.getInt("int_vac_lic"));
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pa;
	    }
	  } 
	  
	  
	  
	  
	  public static final class PersonalMarcacionxId implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalMarcacionVO pm 	= new PersonalMarcacionVO();
	    	  PersonalActividadVO pa	= new PersonalActividadVO();
	    	  PersonalVO		  ps	= new PersonalVO();
	    	  Tipo				  tm	= new Tipo();    	  
	    	  
	       try {
	    	   
	    	   pm.setSrl_id_personal_marcacion(rs.getInt("srl_id_pers_marc"));
	    	   pm.setDte_fec_marc(rs.getDate("dte_fec_marc"));
	    	   pm.setHor_hor_marc(rs.getTime("hor_hor_marc"));
	    	   
	    	   //Cuando sea 0: Es hora de ingreso, caso contrario (1) es hora de salida.
	    	   pm.setIngreso_o_salida(rs.getInt("hor_en_asistencia"));
	    	   
	    	   //Cuando sea 0: Es hora de salida, caso contrario (1) es hora de retorno.
	    	   pm.setHor_sal_o_ret_papeleta(rs.getInt("hor_sal_o_ret"));
	    	   pm.setSrl_id_papeleta(rs.getInt("srl_id_desp"));
	    	   
	    	   ps.setIdpersonal(rs.getInt("idpersonal"));
	    	   
	    	   pm.setTsp_fec_mod(Funciones.fechaHoyTimeStamp());
	    	   pm.setInt_id_usu_mod(0);
	    	   pa.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
	    	   pa.setVar_des_per_activ(rs.getString("var_des_per_activ"));
	    	   pm.setVar_descripcion(rs.getString("var_descripcion"));
	    	   tm.setIdtipo(rs.getInt("idtablatipo"));
	    	   tm.setDestipo(rs.getString("destablatipo"));
	
	    	   pm.setPersonal(ps);
	    	   pm.setPersonalActividad(pa);
	    	   pm.setTipomarcacion(tm);
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pm;
	    }
	  } 
	  
	  
	  
	  public static final class MarcacionesId implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalMarcacionVO pm 	= new PersonalMarcacionVO();  
	    	  
	       try {
	    	   
	    	   pm.setSrl_id_personal_marcacion(rs.getInt("srl_id_pers_marc"));	
	    	       	       	   	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pm;
	    }
	  }
	  
	  // Agregado 03-08-2013 (D. V. R)
	  public static final class Personanaturalxnrodoc implements RowMapper {
	
		  public Object mapRow(ResultSet rs, int rowNum)  {
	    	  Personanatural pn = null;
	
	    	  try {
		    	  pn			= new Personanatural();
	//	     	  p1	= new Persona();
		    	   //pn.nombre,  pn.apepat, pn.apemat, pn.numerodoc
		    	   pn.setNumerodocumento(rs.getString("numerodoc"));
		    	   pn.setNombre(rs.getString("nombre"));
		    	   pn.setApepat(rs.getString("apepat"));    	   
		    	   pn.setApemat(rs.getString("apemat"));
		    	   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pn;
	    }
	  } 
	  
	  public static final class PersonalContratoMapper implements RowMapper {
	
		  public Object mapRow(ResultSet rs, int rowNum)  {
	    	  
			  PersonalVO ps = new PersonalVO();		  
			  Personanatural pn = null;
			  
			  
	    	  
		       try {
		    	  
		    	  ps.setIdpersonal(rs.getInt("idpersonal"));	    	     	   
		    	  pn			= new Personanatural();
		    	  
		    	  pn.setNumerodocumento(rs.getString("numerodoc"));
		    	  pn.setNombre(rs.getString("nombre"));
		    	  pn.setApepat(rs.getString("apepat"));    	   
		    	  pn.setApemat(rs.getString("apemat"));
		    	  pn.setIdpersona(rs.getInt("idpersona"));
		    	  
		    	  
		    	   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ps;
	    }
	  } 
	  
	  
	  public static final class listacontratosxid implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       
	    	  PersonalContratoVO pc 	= null;    	  
	      
	       try {    	   
	    	   pc = new PersonalContratoVO();
	    	       	   
	    	   pc.setDte_fec_suscrip(rs.getDate("fechmax"));
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pc;
	    }
	  } 
	  
	  
	  public static final class listarTipoMarcacion implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Tipo t = new Tipo();
	       try {
	    	   t.setIdtipo(rs.getInt("idtablatipo"));
	    	   t.setDestipo(rs.getString("destablatipo"));      
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;  
	    }
	  }
	  
	  public static final class listMotivoMarcacion implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       PersonalActividadVO pa 	= 	new PersonalActividadVO();
	       try {
	    	   pa.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
	    	   pa.setVar_des_per_activ(rs.getString("var_des_per_activ"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pa;  
	    }
	  }
	  
	  
	  
	  //05-06-2014: 	D.V.R -------------------VACACIONES
	  
	  public static final class listapersonalVacaciones implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVacacionesVO pv 		= new PersonalVacacionesVO();
			  PersonalVO ps					= new PersonalVO();
			  PersonalContratoVO pc			= new PersonalContratoVO();
			  PersonalContratoAdendaVO pca	= new PersonalContratoAdendaVO();
	
			  try {
				  
				  pc.setDte_fec_inicio(rs.getDate("dte_fec_inicio"));
//				  pc.setDte_fec_termino(rs.getDate("dte_fec_termino"));
				  pc.setDte_fec_cese(rs.getDate("dte_fec_cese"));
				  
//				  pca.setDte_fec_termino(rs.getDate("dte_fec_termino_adenda"));
				  pca.setPersonalContrato(pc);			  

				  
				  ps.setNumerodocumento(rs.getString("numerodoc"));;
				  ps.setApepat(rs.getString("apepat"));
				  ps.setApemat(rs.getString("apemat"));
				  ps.setNombre(rs.getString("nombre"));			  
				  ps.setIdpersonal(rs.getInt("idpersonal"));
				  ps.setEstado(rs.getInt("int_estado"));
			  
				  pv.setDte_fec_inicio_programacion_vac(rs.getDate("dte_fec_inicio_programacion_vac"));
//				  pv.setDte_fec_vac_aprobadas(rs.getDate("dte_fec_vac_aprobadas"));
				  pv.setInt_periodo_vac(rs.getInt("int_periodo_vac"));
				  pv.setInt_dias_vac_corresponde(rs.getInt("int_dias_vac_corresponde"));
				  pv.setInt_dias_vac_goce(rs.getInt("int_dias_vac_goce"));
//				  pv.setInt_dias_vac_truncas(rs.getInt("int_dias_vac_truncas"));
				  pv.setDouble_dias_vac_truncas(rs.getDouble("int_dias_vac_truncas"));
				  pv.setVac_pendientes_periodos_ant(rs.getInt("vac_pendientes_periodos_ant"));
				  
				  /*ADD 16-09-2015 DAVID*/				  
				  pv.setInt_cant_dias_laborados_truncos(rs.getInt("int_cant_dias_laborados_truncos"));
				  pv.setAnios_servicio(rs.getInt("int_cant_dias_laborados_truncos") / 360);
				  pv.setMeses_servicio(
						  (rs.getInt("int_cant_dias_laborados_truncos") -  ( (rs.getInt("int_cant_dias_laborados_truncos") / 360) * 360 ) )  / 30						
				  );
				  pv.setDias_servicio(
						  rs.getInt("int_cant_dias_laborados_truncos") - 
						  (
							 (
									 (((rs.getInt("int_cant_dias_laborados_truncos") / 360) * 12) * 30)
									 +
									 (((rs.getInt("int_cant_dias_laborados_truncos") -  ( (rs.getInt("int_cant_dias_laborados_truncos") / 360) * 360 ) )  / 30) * 30)
							)
						)
						  
						  
						  
						  );
				  /*				  END  */
				  
				  pv.setPersonal(ps);
				  pv.setPersonalContratoAdenda(pca);
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pv;
		  }
	  }
	  
	  
	  public static final class listaPeriodosVacaciones implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVacacionesVO pvp 	= new PersonalVacacionesVO();
	
			  try {				  

				  pvp.setInt_periodo_vac(rs.getInt("int_periodo_vac"));
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pvp;
		  }
	  }
	  
	  
	  
	  public static final class listaVacacionesxidpersonal implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVacacionesVO pv 		= new PersonalVacacionesVO();
			  PersonalVacacionesGoceVO pvg 	= new PersonalVacacionesGoceVO();
			  PersonalVO ps					= new PersonalVO();
			  
	
			  try {	
				  
				  ps.setIdpersonal(rs.getInt("idpersonal"));
				  
				  pv.setPersonal(ps);
				  
				  pv.setSrl_id_pers_vac(rs.getInt("srl_id_pers_vac"));
				  pv.setInt_periodo_vac(rs.getInt("int_periodo_vac"));
				  pv.setDte_fec_inicio_programacion_vac(rs.getDate("dte_fec_inicio_programacion_vac"));
				  pv.setInt_est_vacaciones(rs.getInt("int_est_vacaciones"));
//				  pv.setDte_fec_vac_aprobadas(rs.getDate("dte_fec_vac_aprobadas"));
				  pv.setTsp_fec_sys_crea(rs.getTimestamp("tsp_fec_sys_crea"));
				  pv.setTsp_fec_sys_mod(rs.getTimestamp("tsp_fec_sys_mod"));
				  pv.setInt_dias_vac_corresponde(rs.getInt("int_dias_vac_corresponde"));				  
				  pv.setInt_dias_vac_goce(rs.getInt("int_dias_vac_goce"));
				  pv.setInt_dias_vac_pendientes(pv.getInt_dias_vac_corresponde() - pv.getInt_dias_vac_goce());
				  
				  pvg.setPersonalVacaciones(pv);
				  
				  pvg.setSrl_id_pers_goce_vac(rs.getInt("srl_id_pers_goce_vac"));
				  pvg.setDte_fec_inicio_goc_vac(rs.getDate("dte_fec_inicio_goc_vac"));
				  pvg.setDte_fec_fin_goc_vac(rs.getDate("dte_fec_fin_goc_vac"));
				  pvg.setInt_dias_goce_vac(rs.getInt("int_dias_goce_vac"));
				  pvg.setInt_estado_goce_vac(rs.getInt("int_estado_goce_vac"));
				  pvg.setTsp_fec_post_goce_vac(rs.getTimestamp("tsp_fec_post_goce_vac"));
				  pvg.setVar_justificacion_post(rs.getString("var_justificacion_post"));			  
				  
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pvg;
		  }
	  }

	  
	  public static final class obtieneVacacionesAutorizadasxidP implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVacacionesVO pv 		= new PersonalVacacionesVO();
	
			  try {
		  				  
				  pv.setSrl_id_pers_vac(rs.getInt("srl_id_pers_vac"));
				  pv.setInt_periodo_vac(rs.getInt("int_periodo_vac"));
				  pv.setDte_fec_inicio_programacion_vac(rs.getDate("dte_fec_inicio_programacion_vac"));
				  pv.setInt_est_vacaciones(rs.getInt("int_est_vacaciones"));
//				  pv.setDte_fec_vac_aprobadas(rs.getDate("dte_fec_vac_aprobadas"));
				  pv.setTsp_fec_sys_crea(rs.getTimestamp("tsp_fec_sys_crea"));
				  pv.setTsp_fec_sys_mod(rs.getTimestamp("tsp_fec_sys_mod"));
				  pv.setInt_dias_vac_corresponde(rs.getInt("int_dias_vac_corresponde"));				  
				  pv.setInt_dias_vac_goce(rs.getInt("int_dias_vac_goce"));
				  pv.setInt_dias_vac_pendientes(pv.getInt_dias_vac_corresponde() - pv.getInt_dias_vac_goce());
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pv;
		  }
	  }
	  
	  
	  public static final class obtenerVacacionesProgramadaxid implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalVacacionesVO pv 		= new PersonalVacacionesVO();
			  PersonalVacacionesGoceVO pvg 	= new PersonalVacacionesGoceVO();
	
			  try {	
				  
			  
				  pvg.setSrl_id_pers_goce_vac(rs.getInt("srl_id_pers_goce_vac"));
				  pvg.setDte_fec_inicio_goc_vac(rs.getDate("dte_fec_inicio_goc_vac"));
				  pvg.setDte_fec_fin_goc_vac(rs.getDate("dte_fec_fin_goc_vac"));
				  pvg.setInt_dias_goce_vac(rs.getInt("int_dias_goce_vac"));
				  pvg.setInt_estado_goce_vac(rs.getInt("int_estado_goce_vac"));
				  pvg.setTsp_fec_post_goce_vac(rs.getTimestamp("tsp_fec_post_goce_vac"));
				  pvg.setVar_justificacion_post(rs.getString("var_justificacion_post"));
				  				  
				  pv.setInt_dias_vac_goce(rs.getInt("int_dias_vac_goce"));
				  pv.setSrl_id_pers_vac(rs.getInt("srl_id_pers_vac"));
				  pv.setInt_dias_vac_pendientes(30 - (pvg.getInt_dias_goce_vac() + pv.getInt_dias_vac_goce()));
				  
				  pvg.setPersonalVacaciones(pv);
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pvg;
		  }
	  }
	  
	  
	  //08-07-2014: 	D.V.R -------------------LICENCIAS
	  
	  public static final class listapersonalLicencias implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  PersonalLicenciasVO pl	= new PersonalLicenciasVO();
			  PersonalActividadVO tl	= new PersonalActividadVO();
	
			  try {	
				  
				  tl.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
				  tl.setVar_des_per_activ(rs.getString("var_des_per_activ"));
				  
				  pl.setSrl_id_pers_lic(rs.getInt("srl_id_pers_lic"));
				  pl.setDte_fec_inicio_lic(rs.getDate("dte_fec_inicio_lic"));
				  pl.setDte_fec_fin_lic(rs.getDate("dte_fec_fin_lic"));
				  pl.setInt_dias_lic(rs.getInt("int_dias_lic"));
				  pl.setInt_est_lic(rs.getInt("int_est_lic"));
				  pl.setVar_num_resol_autoriza_lic(rs.getString("var_num_resol_autoriza_lic"));
				  pl.setVar_descripcion_lic(rs.getString("var_descripcion_lic"));
				  pl.setIdPersonallicencia(rs.getInt("idpersonal"));
				  pl.setTipolicencia(tl);
				  
			  
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  return pl;
		  }
	  }
	  
	  
	  
	  public static final class listTipoLicencia implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Tipo t = new Tipo();
	       try {
	    	   t.setIdtipo(rs.getInt("idtablatipo"));
	    	   t.setDestipo(rs.getString("destablatipo"));      
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;  
	    }
	  }
	  
	  public static final class listapapeletaxidP implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	    	  
	       PersonalDesplazamientoVO pd 	= new PersonalDesplazamientoVO();
	       PersonalActividadVO pa		= new PersonalActividadVO();
	       PersonalVO	ps				= new PersonalVO();
	       
	       try {
	    	   
	    	   ps.setIdpersonal(rs.getInt("idpersonal"));
	    	   
	    	   pa.setSrl_id_per_activ(rs.getInt("srl_id_per_activ"));
	    	   pa.setVar_des_per_activ(rs.getString("var_des_per_activ"));
	    	   
	    	   pd.setSrl_id_desp(rs.getInt("srl_id_desp"));
	    	   pd.setVar_lug_desp(rs.getString("var_lug_desp"));
	    	   pd.setDte_fec_sal_desp(rs.getDate("dte_fec_sal_desp"));
	    	   pd.setDte_fec_ret_desp(rs.getDate("dte_fec_ret_desp"));
	    	   pd.setHor_hor_sal_desp(rs.getTime("hor_hor_sal_desp"));
	    	   pd.setHor_hor_ret_desp(rs.getTime("hor_hor_ret_desp"));
	    	   
	    	   pd.setPersonalActividad(pa);
	    	   pd.setPersonal(ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;  
	    }
	  }
	  
	  

		public static final class CatAreanaturalMapper implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
			       Categoriaanp can = null;
			       try {
				       can = new Categoriaanp();
//				       can.idcategoriaanp, canp.descategoriaanp
				       can.setIdcategoriaanp(rs.getInt("idcategoriaanp"));
				       can.setDescategoriaanp(rs.getString("descategoriaanp"));
				       
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return can;  
		    }
		  } 
	  
		
		
/*--------------------REPORTES-------------------*/
		
		  public static final class listaInasistenciaxRangoFechas implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalAsistenciaVO pa 	= null;
		    	  PersonalVO ps				= null;
		      
		       try {
		    	   
		    	   pa 	= new PersonalAsistenciaVO();
		    	   ps	= new PersonalVO();		    	   

		    	   ps.setNumerodocumento(rs.getString("numerodoc"));
		    	   ps.setApepat(rs.getString("apepat"));
		    	   ps.setApemat(rs.getString("apemat"));
		    	   ps.setNombre(rs.getString("nombre"));
		    	   ps.setIdpersonal(rs.getInt("idpersonal"));
		    	   
		    	   pa.setDte_fecha(rs.getDate("dte_fecha"));
		    	   pa.setHor_hor_ingreso(rs.getTime("hor_hor_ingreso"));
		    	   pa.setHor_hor_salida(rs.getTime("hor_hor_salida"));
		    	   pa.setHor_despues_horario_tardanza(rs.getString("minutos_tardanza"));
		    	   pa.setHor_despues_horario_tardanza_total(rs.getString("minutos_tardanza_total"));
		    	   /*pa.setMinutosTardanza(rs.getInt("tardanza"));
		    	   pa.setMinutosExcedentes(rs.getInt("excedente"));*/
		    	   pa.setHor_antes_horario(rs.getTime("hor_antes_horario"));
		    	   pa.setHor_antes_horario_total(rs.getString("hor_antes_horario_total"));
		    	   pa.setHor_despues_horario(rs.getTime("hor_despues_horario"));
		    	   pa.setHor_despues_horario_total(rs.getString("hor_despues_horario_total"));
		    	   pa.setHor_fuera_horario(rs.getTime("hor_fuera_horario"));
		    	   pa.setHor_fuera_horario_total(rs.getString("hor_fuera_horario_total"));
//		    	   pa.setEstado(rs.getInt("int_estado"));
//		    	   pa.setEstadoTmp(rs.getInt("int_estado_tmp"));


		    	   pa.setPersonal(ps);
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pa;
		    }
		  } 
		  
		  

		  public static final class listaPersonalporActividad implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalDesplazamientoVO pd 	= null;
		    	  PersonalVO ps					= null;
		    	  PersonalActividadVO pac		= null;
		      
		       try {
		    	   
		    	   pd 	= new PersonalDesplazamientoVO();
		    	   ps	= new PersonalVO();	
		    	   pac	= new PersonalActividadVO();

		    	   ps.setNumerodocumento(rs.getString("numerodoc"));
		    	   ps.setApepat(rs.getString("apepat"));
		    	   ps.setApemat(rs.getString("apemat"));
		    	   ps.setNombre(rs.getString("nombre"));
		    	   ps.setIdpersonal(rs.getInt("idpersonal"));
	    	   
		    	   pd.setTiempo_horas_diaReporte(rs.getString("motivo_papeleta"));
		    	   pd.setDte_fec_sal_desp(rs.getDate("fecha_inicio_papeleta"));
		    	   pd.setInicioReporte(rs.getString("inicio"));
		    	   pd.setFinReporte(rs.getString("fin"));
		    	   pd.setDte_fec_ret_desp(rs.getDate("fecha_fin_papeleta"));
		    	   pd.setHor_hor_sal_desp(rs.getTime("hora_salida_papeleta"));
		    	   pd.setHor_hor_ret_desp(rs.getTime("hora_retorno_papeleta"));
		    	   pd.setVar_lug_desp(rs.getString("justificacion"));
		    	   
		    	   pac.setSrl_id_per_activ(rs.getInt("actividad"));
		    	   pac.setVar_des_per_activ(rs.getString("descripcion_actividad"));
		    	   
		    	   pd.setPersonal(ps);
		    	   pd.setPersonalActividad(pac);		    	   		    	   
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pd;
		    }
		  }
		  
		  
		  public static final class listarPersonalResumenAsistencia implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalAsistenciaResumenVO par	= null;
		    	  PersonalVO ps						= null;
		      
		       try {
		    	   
		    	   par	= new PersonalAsistenciaResumenVO();
		    	   ps	= new PersonalVO();	
		    	   

		    	   ps.setNumerodocumento(rs.getString("numerodoc"));
		    	   ps.setApepat(rs.getString("apepat"));
		    	   ps.setApemat(rs.getString("apemat"));
		    	   ps.setNombre(rs.getString("nombre"));
		    	   ps.setIdpersonal(rs.getInt("idpersonal"));
		    	   
		    	   par.setMinutosTardanza(rs.getInt("minutosTardanza"));
		    	   par.setPermisoParticularDias(rs.getInt("permisoParticularDias"));
		    	   par.setPermisoParticularHoras(rs.getTime("permisoParticularHoras"));
		    	   par.setPermisoConGoceDias(rs.getInt("permisoConGoceDias"));
		    	   par.setPermisoConGoceHoras(rs.getTime("permisoConGoceHoras"));
		    	   par.setComisionLocalDias(rs.getInt("comisionLocalDias"));
		    	   par.setComisionLocalHoras(rs.getTime("comisionLocalHoras"));
		    	   par.setComisionProvinciaDias(rs.getInt("comisionProvinciaDias"));
		    	   par.setComisionProvinciaHoras(rs.getTime("comisionProvinciaHoras"));
		    	   par.setComisionExtranjeroDias(rs.getInt("comisionExtranjeroDias"));
		    	   par.setComisionExtranjeroHoras(rs.getTime("comisionExtranjeroHoras"));
		    	   par.setInasistencias(rs.getInt("inasistencias"));
		    	   par.setVacaciones(rs.getInt("vacaciones"));
		    	   par.setLicIncapacidadTemporalTrabajo(rs.getInt("licIncapacidadTemporalTrabajo"));
		    	   par.setLicFallecimientoFamiliar(rs.getInt("licFallecimientoFamiliar"));
		    	   par.setLicPaternidad(rs.getInt("licPaternidad"));
		    	   par.setLicCapacitacionExtranjero(rs.getInt("licCapacitacionExtranjero"));
		    	   par.setLicCapacitacionLocal(rs.getInt("licCapacitacionLocal"));
		    	   par.setLicEnfermedadGraveFamiliar(rs.getInt("licEnfermedadGraveFamiliar"));
		    	   par.setLicSinGoceDeHaber(rs.getInt("licSinGoceDeHaber"));
		    	   
		    	   par.setPersonal(ps);		    	   		    	   
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return par;
		    }
		  }
		  
		  
		  public static final class listarPersonalRecordAsistencias implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalAsistenciaVO pa 	= null;
		    	  PersonalVO ps				= null;
		    	  Areaorganica a			= null;
		      
		       try {
		    	   
		    	   pa 	= new PersonalAsistenciaVO();
		    	   ps	= new PersonalVO();	
		    	   a	= new Areaorganica();
		    	   
		    	   a.setDesarea(rs.getString("area"));
		    	   
		    	   ps.setAreaorganica(a);
		    	   
		    	   ps.setNumerodocumento(rs.getString("numerodoc"));
		    	   ps.setApepat(rs.getString("apepat"));
		    	   ps.setApemat(rs.getString("apemat"));
		    	   ps.setNombre(rs.getString("nombre"));
		    	   ps.setIdpersonal(rs.getInt("idpersonal"));		    	   
		    	   
		    	   pa.setDte_fecha(rs.getDate("dte_fecha"));
		    	   pa.setNumerodia(rs.getInt("numerodia"));
		    	   pa.setStr_hor_ingreso(rs.getString("hor_hor_ingreso"));
		    	   pa.setStr_hor_salida(rs.getString("hor_hor_salida"));
		    	   pa.setPersonal(ps);
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pa;
		    }
		  } 
		  
		  public static final class listarPersonalResumenAsistenciaRecord implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonalAsistenciaResumenVO par	= null;
		    	  //PersonalVO ps						= null;
		      
		       try {
		    	   
		    	   par	= new PersonalAsistenciaResumenVO();
		    	   /*
		    	   ps	= new PersonalVO();	
		    	   

		    	   ps.setNumerodocumento(rs.getString("numerodoc"));
		    	   ps.setApepat(rs.getString("apepat"));
		    	   ps.setApemat(rs.getString("apemat"));
		    	   ps.setNombre(rs.getString("nombre"));
		    	   ps.setIdpersonal(rs.getInt("idpersonal"));*/
		    	   
		    	   par.setMinutosTardanza(rs.getInt("minutosTardanza"));
		    	   par.setPermisoParticularDias(rs.getInt("permisoParticularDias"));

		    	   par.setPermisoConGoceDias(rs.getInt("permisoConGoceDias"));

		    	   par.setComisionLocalDias(rs.getInt("comisionLocalDias"));

		    	   par.setComisionProvinciaDias(rs.getInt("comisionProvinciaDias"));

		    	   par.setComisionExtranjeroDias(rs.getInt("comisionExtranjeroDias"));

		    	   par.setInasistencias(rs.getInt("inasistencias"));
		    	   par.setVacaciones(rs.getInt("vacaciones"));
		    	   par.setLicIncapacidadTemporalTrabajo(rs.getInt("licIncapacidadTemporalTrabajo"));
		    	   par.setLicFallecimientoFamiliar(rs.getInt("licFallecimientoFamiliar"));
		    	   par.setLicPaternidad(rs.getInt("licPaternidad"));
		    	   par.setLicCapacitacionExtranjero(rs.getInt("licCapacitacionExtranjero"));
		    	   par.setLicCapacitacionLocal(rs.getInt("licCapacitacionLocal"));
		    	   par.setLicEnfermedadGraveFamiliar(rs.getInt("licEnfermedadGraveFamiliar"));
		    	   par.setLicSinGoceDeHaber(rs.getInt("licSinGoceDeHaber"));
		    	   par.setSaldoVacaciones(rs.getString("saldovacaciones"));
		    	   par.setFechaingreso(rs.getDate("fechaingreso"));
		    	   par.setFechanacimiento(rs.getDate("fechanacimiento"));
		    	   
		    	   //par.setPersonal(ps);		    	   		    	   
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return par;
		    }
		  }
		  
		  public static final class listardiasnolaborables implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonaldiasnolaborablesVO dnl	= null;
		      
		       try {
		    	   
		    	   dnl	= new PersonaldiasnolaborablesVO();
		    	   
		    	   dnl.setDte_fec_no_laborable(rs.getDate("dte_fec_no_laborable"));
		    	   dnl.setInt_estado(rs.getInt("int_estado"));
		    	   		    	   
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dnl;
		    }
		  }
		  
		  public static final class listarperiodosdiasnolaborables implements RowMapper {
		      public Object mapRow(ResultSet rs, int rowNum)  {
		       
		    	  PersonaldiasnolaborablesVO dnl	= null;
		      
		       try {
		    	   
		    	   dnl	= new PersonaldiasnolaborablesVO();
		    	   
		    	   dnl.setPeriodoanio(rs.getInt("periodo"));
		    	   		    	   
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dnl;
		    }
		  }
  
}