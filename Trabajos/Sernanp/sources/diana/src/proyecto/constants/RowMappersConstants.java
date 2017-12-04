package proyecto.constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.springframework.jdbc.core.RowMapper;
import proyecto.param.AreanaturalParam;
import proyecto.param.BoletajeParam;
import proyecto.vo.Actividadturismo;
import proyecto.vo.AprobacionRecursoInformacion;
import proyecto.vo.Archivo;
import proyecto.vo.Areanatural;
import proyecto.vo.Areaorganica;
import proyecto.vo.Autor;
import proyecto.vo.Boletaje;
import proyecto.vo.Categoriaanp;
import proyecto.vo.Conceptoexoneracionpago;
import proyecto.vo.DetalleExpedienteSancion;
import proyecto.vo.Directorioarchivo;
import proyecto.vo.DirectorioarchivoModulo;
import proyecto.vo.Documento;
import proyecto.vo.Editorial;
import proyecto.vo.Estado;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteSancion;
import proyecto.vo.FichaRegistro;
import proyecto.vo.Fichaturismo;
import proyecto.vo.Guia;
import proyecto.vo.GuiaFichaTurismo;
import proyecto.vo.HistFichaturismoAccion;
import proyecto.vo.HistorialJefesAnp;
import proyecto.vo.Idioma;
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;
import proyecto.vo.Logo;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PagoBanco;
import proyecto.vo.PagoFichaturismo;
import proyecto.vo.Pais;
import proyecto.vo.Parametro;
import proyecto.vo.Personajuridica;
import proyecto.vo.Personal;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
import proyecto.vo.RecursoInformacion;
import proyecto.vo.RecursoInformacionAreanatural;
import proyecto.vo.RecursoInformacionAutor;
import proyecto.vo.RecursoInformacionEditorial;
import proyecto.vo.RecursoInformacionTema;
import proyecto.vo.RolModulo;
import proyecto.vo.Rutaturismo;
import proyecto.vo.Sancion;
import proyecto.vo.Telefono;
import proyecto.vo.Tema;
import proyecto.vo.TematicaRecursoInformacion;
import proyecto.vo.Tipo;
import proyecto.vo.Tipoturismo;
import proyecto.vo.TipoturismoFichaturismo;
import proyecto.vo.Turismo;
import proyecto.vo.TurismoPagos;
import proyecto.vo.TurismoPagosDetalle;
import proyecto.vo.Ubigeo;
import proyecto.vo.Usuario;
import proyecto.vo.UsuarioRol;
import proyecto.vo.Visitante;

public class RowMappersConstants {
	
	// Agregado 26-04-2013 (J.M.)
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
	
	
	public static final class CantidadProyectoxAreanaturalMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	    	  AreanaturalParam ap=new AreanaturalParam();
				
	    	  try {
	    	    ap.getAreanatural().setIdareanatural(rs.getInt("idareaNatural"));
				 ap.getAreanatural().setDesareanatural(rs.getString("desareanatural"));
				 ap.setCantidadProyectos(rs.getInt("canttotal"));
				 ap.setCantidadProyectosVigente(rs.getInt("cantvigente"));
				 ap.setCantidadProyectosVencidos(rs.getInt("cantvencido"));
	    	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ap;  
	    }
	  } 
	
	
	public static final class DocumentoMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	       Documento d=new Documento();
	       try {
	        d.setIddocumento(rs.getInt("iddocumento"));
	        d.setDesdocumento(rs.getString("desdocumento"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;  
	    }
	  }
	
	
	public static final class MontoProyectoxAreanaturalMapper implements RowMapper {
	      public Object mapRow(ResultSet rs, int rowNum)  {
	    	  AreanaturalParam ap=new AreanaturalParam();
				
	    	  try {
	    	     ap.getAreanatural().setIdareanatural(rs.getInt("idareaNatural"));
				 ap.getAreanatural().setDesareanatural(rs.getString("desareanatural"));
				 ap.setMontoTotalProyectos(rs.getDouble("montototal"));
				 ap.setMontoTotalVigente(rs.getDouble("montovigente"));
				 ap.setMontoTotalVencido(rs.getDouble("montovencido"));
				 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ap;  
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
  
  
  
  public static final class LogoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Logo l=new Logo();
       try {
       l.setIdlogo(rs.getInt("idlogo"));
       l.setDeslogo(rs.getString("deslogo"));
       l.setNombrelogo(rs.getString("nombrelogo"));
       l.setNombregeneradologo(rs.getString("nombregeneradologo"));
       l.setFlaglogo(rs.getInt("flaglogo"));
       l.getDirectorioarchivo().setIddirectorioarchivo(rs.getInt("iddirectorioarchivo"));
       l.getDirectorioarchivo().setNomdirectorio(rs.getString("nomdirectorio"));
       l.getDirectorioarchivo().setIddirectoriopadre(rs.getInt("iddirectoriopadre"));
       l.getDirectorioarchivo().setDirdirectorio(rs.getString("dirdirectorio"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;  
    }
  }
  
  
  public static final class TurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Turismo t=new Turismo();
       try {
       t.setIdturismo(rs.getInt("idturismo"));
       t.setIdareanatural(rs.getInt("idareanatural"));
       t.getCategoriaanp().setDescategoriaanp(rs.getString("descategoriaanp")); 
       t.setDesareanatural(rs.getString("desareanatural"));
       t.getCategoriaanp().setIdcategoriaanp(rs.getInt("idcategoriaanp"));
       t.getCategoriaanp().setDescategoriaanp(rs.getString("descategoriaanp"));
       t.getCategoriaanp().setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
       //t.getAreanatural()
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;  
    }
  } 
  
  
//  public static final class ProyectoArchivoMapper implements RowMapper {
//      public Object mapRow(ResultSet rs, int rowNum)  {
//       ProyectoArchivo pa=new ProyectoArchivo();
//       try {
//       pa.getArchivo().setIdarchivo(rs.getInt("idarchivo"));   
//       pa.getArchivo().setNombreInicial(rs.getString("nombreinicialarchivo"));
//       pa.getArchivo().setNombreGenerado(rs.getString("nombregeneradoarchivo"));
//       pa.getArchivo().setDescripcion(rs.getString("descripcionarchivo"));
//       pa.getArchivo().getUsuario().setIdUsuario(rs.getInt("idUsuario"));
//       pa.getArchivo().setIdarchivoPadre(rs.getInt("idarchivopadre"));
//       pa.getProyecto().setIdproyecto(rs.getInt("idproyecto"));
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return pa;  
//    }
//  } 
  
  public static final class GuiaMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Guia g=new Guia();
       try {
       g.setIdguia(rs.getInt("idguia"));
       g.setIdpersonanatural(rs.getInt("idpersonanatural"));
       g.setApepat(rs.getString("apepat"));
       g.setApemat(rs.getString("apemat"));
       g.setNombre(rs.getString("nombre"));
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return g;  
    }
  }
  
//Agregado (Y.C.B)
  public static final class PersonaNaturalMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Personanatural g = null;
       Tipo t = null;
       Tipo s = null;
       try {
    	   g = new Personanatural();
    	   t = new Tipo(1);
    	   s = new Tipo(2);
    	   
	       t.setIdtipo(rs.getInt("idtipodocumento"));
	       s.setIdtipo(rs.getInt("idsexo"));
	       g.setIdpersonanatural(rs.getInt("idpersonanatural"));
	       g.setApepat(rs.getString("apepat"));
	       g.setApemat(rs.getString("apemat"));
	       g.setNombre(rs.getString("nombre"));
	       g.setTipodocumento(t);
	       g.setNumerodocumento(rs.getString("numerodoc"));
	       g.setSexo(s);
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return g;  
    }
  }
  
  public static final class PersonaJuridicaMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Personajuridica pj=new Personajuridica();
              
       try {
                   
       pj.setIdpersona(rs.getInt("idpersona"));
       pj.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
       
       pj.setCorreoinstitucional(rs.getString("correoinstitucional"));
       pj.setTelefono(rs.getString("telefono"));
       
       pj.setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
       pj.setRuc(rs.getString("ruc"));
                     
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pj;  
    }
  }
  
  
  public static final class PersonalRegistroMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       PersonalRegistro g=new PersonalRegistro();
       Tipo t = new Tipo(1);
       Tipo s = new Tipo(2);
       Tipo l = new Tipo(22);
       try {
       t.setIdtipo(rs.getInt("idtipodocumento"));
       s.setIdtipo(rs.getInt("idsexo"));
       l.setIdtipo(rs.getInt("intipodoc"));
       
       g.setIdpersonalregistro(rs.getInt("idpersonalregistro"));
       g.setNombre(rs.getString("nombre"));
       g.setApepat(rs.getString("apepat"));
       g.setApemat(rs.getString("apemat"));
       g.setEmpresa(rs.getString("empresa"));
       g.setTipodocumento(t);
       g.setNumerodocumento(rs.getString("numerodocumento"));       
       g.setTipolocal(l);             
       g.setSexo(s);
       
       g.setFechaingreso(rs.getString("fechaingreso"));
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return g;  
    }
  }
  
  public static final class PersonalFichaRegistroMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       PersonalFichaRegistro pfr=new PersonalFichaRegistro();
       
       try {
       
       pfr.setIdficharegistro(rs.getInt("idficharegistro"));
       pfr.setIdpersonalregistro(rs.getInt("idpersonalregistro"));       
       pfr.setFechaingreso(rs.getString("fechaingreso"));
       pfr.setHoraingreso(rs.getString("horaingreso"));
       pfr.setFechasalida(rs.getString("fechasalida"));
       pfr.setHorasalida(rs.getString("horasalida"));
       pfr.setIdestado(rs.getInt("idestado"));
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pfr;  
    }
  }
  
  public static final class PersonalRegistroMapperDoc implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       PersonalRegistro g=new PersonalRegistro();
       Tipo t = new Tipo(1);
       try {
       t.setIdtipo(rs.getInt("idtipodocumento"));       
       g.setTipodocumento(t);
       g.setNumerodocumento(rs.getString("numerodocumento"));       
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return g;  
    }
  }
  
  public static final class FichaRegistroMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       FichaRegistro f=new FichaRegistro();
       try {
       
    	   f.setIdficharegistro(rs.getInt("idficharegistro"));
           f.setCodigoficha(rs.getString("codigoficha"));
           f.setFechacreacion(rs.getTimestamp("fechacreacion"));
           f.setIdestadoficha(rs.getInt("idestadoficha"));
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f;  
    }
  }
  
  //07-08-12 16:04:42 (Y.C.B)
  public static final class JefesAnpMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       HistorialJefesAnp hja=new HistorialJefesAnp();
       Areanatural an = new Areanatural();
       Personal p = new Personal();
       try {
    	   
    	   an.setIdareanatural(rs.getInt("idareanatural"));
    	   p.setIdpersonal(rs.getInt("idpersonal"));
    	   p.setIdpersonanatural(rs.getInt("idpersonanatural"));
    	   p.setMailpersonal(rs.getString("mailpersonal"));
    	   
    	   hja.setAreanatural(an);
    	   hja.setPersonal(p);
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hja;  
    }
  }
  
  
  
  public static final class FichaRegistroxANMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       
       FichaRegistro f=new FichaRegistro();
       Areanatural an = new Areanatural();
       Operadorturismo ot = new Operadorturismo();
       Personajuridica pj = new Personajuridica();
       
       try {
       
    	an.setIdareanatural(rs.getInt("idareanatural"));
    	ot.setIdoperadorturismo(rs.getInt("idoperadorturismo"));
    	ot.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
    	
    	pj.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
    	pj.setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
    	
    	f.setPersonajuridica(pj);    	
    	   
       f.setIdficharegistro(rs.getInt("idficharegistro"));
       f.setCodigoficha(rs.getString("codigoficha"));
       f.setAreanatural(an);
       f.setOperadorturismo(ot);
       f.setFechacreacion(rs.getTimestamp("fechacreacion"));
       f.setIdestadoficha(rs.getInt("idestadoficha"));
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f;  
    }
  }
  
  public static final class FichaRegistroMapper_ implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       FichaRegistro f=new FichaRegistro();
       
       try {
    	   
       f.setIdficharegistro(rs.getInt("idficharegistro"));
       f.setCodigoficha(rs.getString("codigoficha"));
       f.setLote(rs.getString("lote"));
       f.setNombreproyecto(rs.getString("nombreproyecto"));
       f.setActividad(rs.getString("actividad"));
       f.setLugar(rs.getString("lugar"));
       f.getOperadorturismo().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
       f.setFechacreacion(rs.getTimestamp("fechacreacion"));
       f.setIdestadoficha(rs.getInt("idestadoficha"));
       f.setNombrearchivo(rs.getString("nombrearchivo"));
       
       f.setFechaaprobacion(rs.getTimestamp("fechaaprobacion"));
       f.setFechaaprobsys(rs.getTimestamp("fechaaprobsys"));
       f.setObservacion(rs.getString("observacion"));
       f.setComentario(rs.getString("comentario"));
       
       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f;  
    }
  }
  
//-----
  
  
  public static final class PagoFichaTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       PagoFichaturismo pft=new PagoFichaturismo();
       try {
       pft.setIdpagofichaturismo(rs.getInt("idpagofichaturismo"));
       pft.setIdfichaturismo(rs.getInt("idfichaturismo"));
       pft.setMonto(rs.getDouble("monto"));
       pft.setNumvoucher(rs.getString("numvoucher"));
	   pft.getModalidadpago().setIdtipo(rs.getInt("idmodalidadpago"));
	   pft.getModalidadpago().setNombretipo(rs.getString("destablatipo"));
	   pft.getModalidadpago().setCodigointtipo(rs.getInt("codinttablatipo"));
	   pft.getPagobanco().setIdpagobanco(rs.getInt("idpagobanco"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pft;  
    }
  }
  
  
  public static final class PersonalMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Personal p=new Personal();
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
  
  
  public static final class TelefonoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Telefono t=new Telefono();
       try {
       t.setIdtelefono(rs.getInt("idtelefono"));
       t.setNumerotelefono(rs.getString("numerotelefono"));
       t.getTipotelefono().setIdtipotelefono(rs.getInt("idtipotelefono"));
       t.getTipotelefono().setNombretipotelefono(rs.getString("nombretipotelefono"));
       t.getPersonal().setIdpersonal(rs.getInt("idpersonal"));
       t.getPersonal().setMailpersonal(rs.getString("mailpersonal"));
       t.getPersonal().setIdpersonanatural(rs.getInt("idpersonanatural"));
       t.getPersonal().setApepat(rs.getString("apepat"));
       t.getPersonal().setApemat(rs.getString("apemat"));
       t.getPersonal().setNombre(rs.getString("nombre"));
       t.setFlagPrincipal(rs.getInt("principaltelefono"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;  
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
  
  
  public static final class ConceptoExoneracionPagoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Conceptoexoneracionpago cexp=new Conceptoexoneracionpago();
       try {
       cexp.setIdconceptoexoneracionpago(rs.getInt("idconceptoexoneracionpago"));
       cexp.setDesconceptoexoneracionpago(rs.getString("desconceptoexoneracionpago"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cexp;  
    }
  }
  
  
  public static final class TipoturismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Tipoturismo t=new Tipoturismo();
       try {
       t.setIdtipoturismo(rs.getInt("idtipoturismo"));
       t.setNombretipoturismo(rs.getString("nombretipoturismo"));
		
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
  
  public static final class TipoRecursoInformacionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Tipo t=new Tipo();
       try {
       t.setIdtipo(rs.getInt("idtiporecursoinformacion"));
       t.setNombretipo(rs.getString("nombretiporecursoinformacion"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;  
    }
  }

  
  
  public static final class MedioRecursoInformacionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Tipo t=new Tipo();
       try {
       t.setIdtipo(rs.getInt("idmediorecursoinformacion"));
       t.setNombretipo(rs.getString("nombremediorecursoinformacion"));
		
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
  
  
  
  public static final class TematicaRecursoInformacionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       TematicaRecursoInformacion t=new TematicaRecursoInformacion();
       try {
      t.setIdtematicarecursoinformacion(rs.getInt("idtematicarecursoinformacion"));
      t.setNombretematicarecursoinformacion(rs.getString("nombretematicarecursoinformacion"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;  
    }
  }
  
  public static final class TemaMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Tema t=new Tema();
       try {
       t.setIdtema(rs.getInt("idtema"));
       t.setNombretema(rs.getString("nombretema"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;  
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
  
  
  
  
  public static final class AutorMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Autor a=new Autor();
       try {
       a.setIdautor(rs.getInt("idautor"));
       a.setIdpersonanatural(rs.getInt("idpersonanatural"));
       a.setNombre(rs.getString("nombre"));
       a.setApepat(rs.getString("apepat"));
       a.setApemat(rs.getString("apemat"));	  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;  
    }
  }
  
  
  public static final class EditorialMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Editorial edit=new Editorial();
       try {
       edit.setIdeditorial(rs.getInt("ideditorial"));
       edit.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
       edit.setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
       edit.setSiglas(rs.getString("siglas"));
       
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return edit;  
    }
  }
  
  
  public static final class ArchivoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Archivo a=new Archivo();
       try {
       a.setIdarchivo(rs.getInt("idarchivo"));   
       a.setNombreinicial(rs.getString("nombreinicialarchivo"));
       a.setNombregenerado(rs.getString("nombregeneradoarchivo"));
       a.getDocumento().setIddocumento(rs.getInt("iddocumento"));
       a.getUsuario().setIdUsuario(rs.getInt("idusuario"));
       a.setFlagarchivo(rs.getInt("flagarchivo"));
       a.getDirectorioarchivo().setIddirectorioarchivo(rs.getInt("iddirectorioarchivo"));
       a.getDirectorioarchivo().setDirdirectorio(rs.getString("dirdirectorio"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;  
    }
  }
  
  
//  public static final class ArchivoMapper implements RowMapper {
//      public Object mapRow(ResultSet rs, int rowNum)  {
//       Archivo a=new Archivo();
//       try {
//       a.setIdarchivo(rs.getInt("idarchivo"));   
//       a.setNombreInicial(rs.getString("nombreinicialarchivo"));
//       a.setNombreGenerado(rs.getString("nombregeneradoarchivo"));
//       a.setDescripcion(rs.getString("descripcionarchivo"));
//       a.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
//       a.setIdarchivoPadre(rs.getInt("idarchivopadre"));
//       
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return a;  
//    }
//  }
  
  
  public static final class HistFichaturismoAccionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       HistFichaturismoAccion hft=new HistFichaturismoAccion();
       try {
    	   hft.setIdhistfichaturismoaccion(rs.getInt("idhistfichaturismoaccion"));
    	   hft.setIdfichaturismo(rs.getLong("idfichaturismo"));
    	   hft.getTipoaccionficha().setIdtipo(rs.getInt("idtipoaccionficha"));
    	   hft.getTipoaccionficha().setNombretipo(rs.getString("destablatipo"));
    	   hft.getTipoaccionficha().setCodigointtipo(rs.getInt("codinttablatipo"));
    	   hft.getUsuario().setIdUsuario(rs.getInt("idusuario"));
    	   hft.getUsuario().setUsername(rs.getString("usuario"));
    	   hft.setFecha(rs.getTimestamp("fecha"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hft;  
    }
  }
  
  public static final class GuiaFichaturismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       GuiaFichaTurismo gft=new GuiaFichaTurismo();
       try {
    	   gft.getFichaturismo().setIdfichaturismo(rs.getInt("idfichaturismo"));
           gft.getGuia().setIdguia(rs.getInt("idguia"));
           gft.getGuia().setApepat(rs.getString("apepat"));
           gft.getGuia().setApemat(rs.getString("apemat"));
           gft.getGuia().setNombre(rs.getString("nombre"));
           
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return gft;  
    }
  }
  
  
  public static final class TipoturismoFichaturismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       TipoturismoFichaturismo tipft= new TipoturismoFichaturismo();
       try {
    	   tipft.getFichaturismo().setIdfichaturismo(rs.getInt("idfichaturismo"));
    	   tipft.getTipoturismo().setIdtipoturismo(rs.getInt("idtipoturismo"));
    	   tipft.getTipoturismo().setNombretipoturismo(rs.getString("nombretipoturismo"));
           
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return tipft;  
    }
  }
  
  
  public static final class RecursoInformacionEditorialMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       RecursoInformacionEditorial rie=new RecursoInformacionEditorial();
       try {
           rie.setIdrecursoinformacioneditorial(rs.getInt("idrecursoinformacioneditorial"));
           rie.setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
           rie.getEditorial().setIdeditorial(rs.getInt("ideditorial"));
           rie.getEditorial().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rie;  
    }
  }
  
  
  public static final class RecursoInformacionAutorMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       RecursoInformacionAutor ria=new RecursoInformacionAutor();
       try {
           ria.setIdrecursoinformacionautor(rs.getInt("idrecursoinformacionautor"));
           ria.setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
           ria.getAutor().setIdautor(rs.getInt("idautor"));
           ria.getAutor().setApepat(rs.getString("apepat"));
           ria.getAutor().setApemat(rs.getString("apemat"));
           ria.getAutor().setNombre(rs.getString("nombre"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ria;  
    }
  }
  
  
  
  public static final class DirectorioArchivoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Directorioarchivo da=new Directorioarchivo();
       try {
        da.setIddirectorioarchivo(rs.getInt("iddirectorioarchivo"));
        da.setIddirectoriopadre(rs.getInt("iddirectoriopadre"));
     	da.setNomdirectorio(rs.getString("nomdirectorio"));
     	da.setOrddirectorio(rs.getInt("orddirectorio"));
     	da.setDirdirectorio(rs.getString("dirdirectorio"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return da;  
    }
  }
  
  //Agregado 13-08-12  
  public static final class DirectorioArchivoModuloMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
    	  DirectorioarchivoModulo dam=new DirectorioarchivoModulo();
    	  //Modulo mod = new Modulo();
      
       try {
    	   //Directorioarchivo da=new Directorioarchivo();
    	   dam.getDirectorioarchivo().setIddirectorioarchivo(rs.getInt("iddirectorioarchivo"));
    	   dam.getDirectorioarchivo().setIddirectoriopadre(rs.getInt("iddirectoriopadre"));
    	   dam.getDirectorioarchivo().setNomdirectorio(rs.getString("nomdirectorio"));
    	   dam.getDirectorioarchivo().setOrddirectorio(rs.getInt("orddirectorio"));
    	   dam.getDirectorioarchivo().setDirdirectorio(rs.getString("dirdirectorio"));
    	   dam.getModulo().setIdmodulo(rs.getInt("idmodulo"));
     	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dam;  
    }
  }
  
  
  public static final class BoletajeMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Boletaje b=new Boletaje();
       try {
    	   
               b.setIdboletaje(rs.getInt("idboletaje"));
        	   b.setNombreboletaje(rs.getString("nombreboletaje"));
               b.setValorboletaje(rs.getFloat("valorboletaje"));
               b.setSerieboletaje(rs.getInt("serieboletaje"));
               b.setObsboletaje(rs.getString("obsboletaje"));
               b.getRutaturismo().setIdrutaturismo(rs.getInt("idrutaturismo"));
               b.setFlagmayoredad(rs.getInt("flagmayoredad"));  
               b.getTipoboletaje().setIdtipo(rs.getInt("idtipoboletaje"));
           
           
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return b;  
    }
  }
  
  
  
  public static final class BoletajeParamMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       BoletajeParam b=new BoletajeParam();
       try {
    	   
           b.setIdboletaje(rs.getInt("idboletaje"));
           if(b.getIdboletaje()!=0){
        	   b.setNombreboletaje(rs.getString("nombreboletaje"));
               b.setValorboletaje(rs.getFloat("valorboletaje"));
               b.setSerieboletaje(rs.getInt("serieboletaje"));
               b.setObsboletaje(rs.getString("obsboletaje"));
               b.getRutaturismo().setIdrutaturismo(rs.getInt("idrutaturismo"));
               b.setFlagmayoredad(rs.getInt("flagmayoredad"));  
           }else{
        	   b.setNombreboletaje(ValueConstants.TXT_NO_APLICA);
           }
           
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return b;  
    }
  }
  
  
  public static final class AprobacionRecursoInformacionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       AprobacionRecursoInformacion apri=new AprobacionRecursoInformacion();
       try {
           apri.setIdaprobacionrecursoinformacion(rs.getInt("idaprobacionrecursoinformacion"));
           apri.setFechaaprobacion(rs.getDate("fechaaprobacion"));
           apri.setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
           apri.getPersonal().setIdpersonal(rs.getInt("idpersonal"));
           apri.getAreaorganica().setIdarea(rs.getInt("idarea"));
           apri.getAreaorganica().setDesarea(rs.getString("desarea"));
           apri.getPersonal().setApepat(rs.getString("apepat"));
           apri.getPersonal().setApemat(rs.getString("apemat"));
           apri.getPersonal().setNombre(rs.getString("nombre"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return apri;  
    }
  }
  
  
  
//  public static final class RecursoInformacionArchivoMapper implements RowMapper {
//      public Object mapRow(ResultSet rs, int rowNum)  {
//       RecursoInformacionArchivo riarch=new RecursoInformacionArchivo();
//       try {
//           riarch.setIdrecursoinformacionarchivo(rs.getInt("idrecursoinformacionarchivo"));
//           riarch.getTipoarchivo().setIdtipo(rs.getInt("tipoarchivo"));
//           riarch.getRecursoinformacion().setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
//           riarch.getArchivo().setIdarchivo(rs.getInt("idarchivo"));
//           riarch.getArchivo().setNombreInicial(rs.getString("nombreinicialarchivo"));
//           riarch.getArchivo().setNombreGenerado(rs.getString("nombregeneradoarchivo"));
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return riarch;  
//    }
//  }
  
  public static final class RecursoInformacionTemaMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       RecursoInformacionTema rit=new RecursoInformacionTema();
       try {
           rit.setIdrecursoinformaciontema(rs.getInt("idtemarecursoinformacion"));
           rit.setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
           rit.getTema().setIdtema(rs.getInt("idtema"));
           rit.getTema().setNombretema(rs.getString("nombretema"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rit;  
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
  
  public static final class RecursoInformacionAreaNaturalMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       RecursoInformacionAreanatural rian=new RecursoInformacionAreanatural();
       try {
           rian.setIdrecursoinformacionareanatural(rs.getInt("idrecursoinformacionareanatural"));
           rian.getRecursoinformacion().setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
           rian.getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
           rian.getAreanatural().setDesareanatural(rs.getString("desareanatural"));
           rian.getAreanatural().setSiglasareanatural(rs.getString("siglasareanatural"));
           rian.getAreanatural().getCategoriaanp().setIdcategoriaanp(rs.getInt("idcategoriaanp"));
           rian.getAreanatural().getCategoriaanp().setDescategoriaanp(rs.getString("descategoriaanp"));
           rian.getAreanatural().getCategoriaanp().setSiglascategoriaanp(rs.getString("siglascategoriaanp"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rian;  
    }
  }
  
  
  public static final class OperadorTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Operadorturismo ot=new Operadorturismo();
       
       try {
    	setearOperadorTurismo(ot,rs);
		ot.getUbigeo().setIdubigeo(rs.getInt("idubigeo"));
		ot.getUbigeo().setCoddepartamento(rs.getString("coddpto"));
		ot.getUbigeo().setCodprovincia(rs.getString("codprov"));
		ot.getUbigeo().setCoddistrito(rs.getString("coddist"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ot;  
    }
  }
  
  
  public static final class ParametroMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Parametro p=new Parametro();
       try {
    	p.setIdparametro(rs.getInt("idparametro"));
    	p.setNombreparametro(rs.getString("nombreparametro"));
    	p.setValorparametro(rs.getString("valorparametro"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;  
    }
  }
  
  public static final class GuiaTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Guia g=new Guia();
       SimpleDateFormat formateador=new SimpleDateFormat("dd-MM-yyyy");
       try {
    	g.setIdguia(rs.getInt("idguia"));
    	g.setCodigoguia(rs.getString("codigoguia"));
    	g.setFlagguia(rs.getInt("flagguia"));
    	//persona natural
    	g.setIdpersonanatural(rs.getInt("idpersonanatural"));
    	g.setApepat(rs.getString("apepat"));
    	g.setApemat(rs.getString("apemat"));
    	g.setNombre(rs.getString("nombre"));
    	 if(rs.getDate("fechanacimiento")!=null){
        	 g.setFechanacimiento(rs.getDate("fechanacimiento")); 
        	 g.setFnacimiento(formateador.format(g.getFechanacimiento())); 
    	 }
    	
    	g.getTipodocumento().setIdtipo(rs.getInt("idtipodocumento"));
    	g.getTipodocumento().setNombretipo(rs.getString("destipdoc"));
    	g.getTipodocumento().setAbrevtipo(rs.getString("abrtipdoc"));
    	g.getTipodocumento().setCodigointtipo(rs.getInt("codinttipdoc"));
    	g.setNumerodocumento(rs.getString("numerodoc"));
    	g.getSexo().setIdtipo(rs.getInt("idsexo"));
    	g.getSexo().setNombretipo(rs.getString("destipgen"));
    	g.getSexo().setAbrevtipo(rs.getString("abrtipgen"));
    	g.getSexo().setCodigointtipo(rs.getInt("codinttipgen"));
    	g.getEstadocivil().setIdtipo(rs.getInt("idestadocivil"));
    	//persona
    	g.setIdpersona(rs.getInt("idpersona"));
    	g.setDireccion(rs.getString("direccion"));
    	g.setTelefono(rs.getString("telefono"));
        g.setCorreopersonal(rs.getString("correopersonal"));
        g.setCorreoinstitucional(rs.getString("correoinstitucional"));
        g.getUbigeo().setIdubigeo(rs.getInt("idubigeo"));
		g.getUbigeo().setCoddepartamento(rs.getString("coddpto"));
		g.getUbigeo().setCodprovincia(rs.getString("codprov"));
		g.getUbigeo().setCoddistrito(rs.getString("coddist"));
        g.getPais().setIdpais(rs.getInt("idpais"));
    	//
    	//g.getTipodocumento().setIdtipo(idtipo);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return g;  
    }
  }
  
  
  
  
  
  
  public static final class OperadorTurismoxAreaNaturalMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Operadorturismo ot=new Operadorturismo();
       setearOperadorTurismo(ot, rs);
	   return ot;  
    }
  }
  
  
  
  public static void setearOperadorTurismo(Operadorturismo ot,ResultSet rs){
	  try {
		ot.setIdoperadorturismo(rs.getInt("idoperadorturismo"));
		ot.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
		ot.setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
		ot.setSiglas(rs.getString("siglas"));
		ot.setFlagagenciaviaje(rs.getInt("flagagenciaviaje"));
		ot.setIdpersona(rs.getInt("idpersona"));
    	ot.setRuc(rs.getString("rucp"));
		ot.setCorreopersonal(rs.getString("correopersonal"));
		ot.setCorreoinstitucional(rs.getString("correoinstitucional"));
		ot.setDireccion(rs.getString("direccion"));
		ot.setTelefono(rs.getString("telefono"));
		ot.getPais().setIdpais(rs.getInt("idpais"));
		ot.getUsuario().setIdUsuario(rs.getInt("idusuario"));
		ot.getUsuario().setUsername(rs.getString("usuario"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	  
  }
  
  public static final class ActividadTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Actividadturismo at=new Actividadturismo();
       try {
          at.setIdactividadturismo(rs.getInt("idactividadturismo"));
          at.setNombreactividadturismo(rs.getString("nombreactividadturismo"));
          at.setDetalleactividadturismo(rs.getString("detalleactividadturismo"));
          at.getTipoturismo().setIdtipoturismo(rs.getInt("idtipoturismo"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return at;  
    }
  }
  
  public static final class PagoBancoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       PagoBanco pb=new PagoBanco();
       try {
          pb.setIdpagobanco(rs.getInt("idpagobanco"));
          pb.setCadtipodocumento(rs.getString("tipodocumento"));
          pb.setCadnumerodocumento(rs.getString("numerodocumento"));
          pb.setCadcodigoficha(rs.getString("codigoficha"));
          pb.setCadnumeroregistro(rs.getString("registro"));
          pb.setCadimporte(rs.getString("cadimporte"));
          pb.setCadnumerovoucher(rs.getString("numerovoucher"));
          pb.setCaddigitochequeo(rs.getString("chequeo"));
          pb.setCadcodigocajero(rs.getString("cajero"));
          pb.setCadfiller(rs.getString("filler"));
          pb.setImporte(rs.getDouble("importe"));
          pb.setFechamovimiento(rs.getTimestamp("fechamovimiento"));
          pb.setSaldo(rs.getDouble("saldo"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pb;  
    }
  }
  
  public static final class RecursoInformacionMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       RecursoInformacion ri=new RecursoInformacion();
       SimpleDateFormat formateador=new SimpleDateFormat("yyyy");
       
       try {
         ri.setIdrecursoinformacion(rs.getInt("idrecursoinformacion"));
         ri.setTitulo(rs.getString("titulo"));
         ri.setTitulooriginal(rs.getString("titulooriginal"));
         ri.setIsbn(rs.getString("isbn"));
         ri.setDescripcion(rs.getString("descripcionrecursoinformacion"));
         ri.setFechaingreso(rs.getDate("fechaingreso"));
         ri.setFecharegistro(rs.getDate("fecharegistro"));
         ri.getIdioma().setIdidioma(rs.getInt("ididioma"));
         ri.getTematicarecursoinformacion().setIdtematicarecursoinformacion(rs.getInt("idtematicarecursoinformacion"));
         ri.getSedebiblioteca().setIdareanatural(rs.getInt("idareanatural"));
         ri.getSedebiblioteca().setDesareanatural(rs.getString("desareanatural"));
         ri.getSedebiblioteca().setSiglasareanatural(rs.getString("siglasareanatural"));
         ri.getTiporecursoinformacion().setIdtipo(rs.getInt("idtiporecursoinformacion"));
         ri.getMediorecursoinformacion().setIdtipo(rs.getInt("idmediorecursoinformacion"));
         ri.getTematicarecursoinformacion().setNombretematicarecursoinformacion(rs.getString("nombretematicarecursoinformacion"));
         ri.getTiporecursoinformacion().setNombretipo(rs.getString("nombretiporecursoinformacion"));
         ri.getMediorecursoinformacion().setNombretipo(rs.getString("nombremediorecursoinformacion"));
         ri.getIdioma().setNombreidioma(rs.getString("nombreidioma"));
         ri.setNumeropaginas(rs.getInt("numeropaginas"));
         ri.setCodigosgd(rs.getString("codigosgd")); 
         if(rs.getDate("aniopublicacion")!=null){
        	 ri.setAniopublicacion(Integer.parseInt(formateador.format(rs.getDate("aniopublicacion")))); 
         }
         ri.setNumerorecursoinformacion(rs.getInt("numerorecursoinfo"));
         ri.setNumerorecursoinformacionarea(rs.getInt("numerorecursoinfoarea"));
         ri.setCodigorecursoinformacion(ri.getNumerorecursoinformacion()+ri.getSedebiblioteca().getSiglasareanatural()+ri.getNumerorecursoinformacionarea());
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ri;  
    }
  }
  
  
  public static final class FichaTurismoMinimoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
      Fichaturismo f=new Fichaturismo();
      SimpleDateFormat formateador=new SimpleDateFormat("dd-MM-yyyy");
      try {
    	  f.setIdfichaturismo(rs.getInt("idfichaturismo"));
    	  if(rs.getString("codigoficha")==null){
    		  f.setCodigoficha("");  
    	  }else{
    		  f.setCodigoficha(rs.getString("codigoficha")); 
    	  }
          f.getEstadoficha().setIdtipo(rs.getInt("idestadoficha"));
          f.getEstadoficha().setCodigointtipo(rs.getInt("codinttablatipo"));
          f.getRutaturismo().setIdrutaturismo(rs.getInt("idrutaturismo"));
          f.getOperadorturismo().setIdoperadorturismo(rs.getInt("idoperadorturismo"));
          if(rs.getDate("fechapropuesta")!=null){
         	 f.setFechapropuesta(rs.getDate("fechapropuesta")); 
         	 f.setFpropuesta(formateador.format(f.getFechapropuesta()));
          }
      } catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	return f;  
      }
    }
  
  
  
  public static final class FichaTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Fichaturismo f=new Fichaturismo();
       SimpleDateFormat formateador=new SimpleDateFormat("dd-MM-yyyy");
       
       try {
         f.setIdfichaturismo(rs.getInt("idfichaturismo"));
         f.setCodigoficha(rs.getString("codigoficha"));
         //f.setFlagfichaturismo(rs.getInt("flagfichaturismo"));
         f.setFecharegistro(rs.getDate("fecharegistro"));
         if(rs.getDate("fechapropuesta")!=null){
        	 f.setFechapropuesta(rs.getDate("fechapropuesta")); 
        	 f.setFpropuesta(formateador.format(f.getFechapropuesta()));
         }
         
         f.setFechaingreso(rs.getDate("fechaingreso"));
        
         /*
         f.setFechaingreso(rs.getDate("fechaingreso"));
        */
         f.getOperadorturismo().setIdoperadorturismo(rs.getInt("idoperadorturismo"));
         f.getOperadorturismo().setNombrepersonajuridica(rs.getString("nombreoperador"));
         f.getEmpresaturismo().setIdoperadorturismo(rs.getInt("idempresaturismo"));
         f.getEmpresaturismo().setNombrepersonajuridica(rs.getString("nombreempresa"));
         f.getRutaturismo().setIdrutaturismo(rs.getInt("idrutaturismo"));
         f.getRutaturismo().setNombrerutaturismo(rs.getString("nombrerutaturismo"));
         //f.getTipoturismo().setNombretipoturismo(rs.getString("nombretipoturismo"));
         f.getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
		 f.setNumareanatural(rs.getInt("numarea"));
		 f.setNumfecharegistro(rs.getInt("numfecha"));
		 //f.setFlagpagobanco(rs.getInt("flagpagobanco"));
		 //f.getPagoBanco().setFechamovimiento(rs.getTimestamp("fechamovimiento"));
		 //estado pago
//		 f.getEstadopagobanco().setIdtipo(rs.getInt("idestadopago"));
//		 if(f.getEstadopagobanco().getIdtipo()!=0){
//			 f.getEstadopagobanco().setNombretipo(rs.getString("desestpb"));
//			 f.getEstadopagobanco().setCodigointtipo(rs.getInt("codintestpb"));
//			 f.getEstadopagobanco().setMensajetipo(rs.getString("msgestpb")); 
//		 }else{
//			 f.getEstadopagobanco().setNombretipo(ValueConstants.EST_PAGO_FICHA_PROCESO_DES);
//			 f.getEstadopagobanco().setCodigointtipo(0);
//			 f.getEstadopagobanco().setMensajetipo(ValueConstants.EST_PAGO_FICHA_PROCESO_MSG); 
//		 }
		 f.setIdtiporolcreacion(rs.getInt("idtiporolcreacion"));
		 f.getEstadoficha().setIdtipo(rs.getInt("idestadoficha"));
		 f.getEstadoficha().setNombretipo(rs.getString("desestft"));
		 f.getEstadoficha().setCodigointtipo(rs.getInt("codintestft"));
		 f.setMontoboletajeadicional(rs.getDouble("montoboletajeadicional"));
		 f.getFichaturismoboletaje().setCantidad(rs.getInt("cantadic"));
//		 f.getModalidadpago().setIdtipo(rs.getInt("idmodalidadpago"));
//		 f.getModalidadpago().setNombretipo(rs.getString("desmodpg"));
//		 f.getModalidadpago().setCodigointtipo(rs.getInt("codintmodpg"));
		
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f;  
    }
  }
  
  
  public static final class VisitanteMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Visitante v=new Visitante();
       
       SimpleDateFormat formateador=new SimpleDateFormat("dd-MM-yyyy");
       try {
         v.setIdvisitante(rs.getInt("idvisitante"));
         v.setFlagvisitante(rs.getInt("flagvisitante"));
         v.getFichaturismo().setIdfichaturismo(rs.getInt("idfichaturismo"));
         v.getFichaturismo().getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
         v.setApepat(rs.getString("apepat"));
         v.setApemat(rs.getString("apemat"));
         v.setNombre(rs.getString("nombre"));
         if(rs.getDate("fechanacimiento")!=null){
        	 v.setFechanacimiento(rs.getDate("fechanacimiento")); 
        	 v.setFnacimiento(formateador.format(v.getFechanacimiento()));
         }
         v.getTipodocumento().setIdtipo(rs.getInt("idtipodocumento"));
         v.getTipodocumento().setNombretipo(rs.getString("nomtipodocumento"));
         v.getTipodocumento().setAbrevtipo(rs.getString("abrtipodocumento"));
         v.getTipoocupacion().setIdtipo(rs.getInt("idtipoocupacion"));
         v.getTipoocupacion().setNombretipo(rs.getString("nomtocup"));
         v.getTipoocupacion().setAbrevtipo(rs.getString("abrtocup"));
         v.getTipoocupacion().setCodigointtipo(rs.getInt("codinttocup"));
         v.getMotivovisita().setIdtipo(rs.getInt("idmotivovisita"));
         v.getMotivovisita().setNombretipo(rs.getString("nomtmvis"));
         v.getMotivovisita().setAbrevtipo(rs.getString("abrtmvis"));
         v.getMotivovisita().setCodigointtipo(rs.getInt("codinttmvis"));
         v.getSexo().setIdtipo(rs.getInt("idsexo"));
         v.getSexo().setNombretipo(rs.getString("nomsexo"));
         v.getSexo().setAbrevtipo(rs.getString("abrsexo"));
         v.setNumerodocumento(rs.getString("numerodoc"));
         v.getPais().setIdpais(rs.getInt("idpais"));
         v.getPais().setNompais(rs.getString("nompais"));
         v.getBoletaje().setIdboletaje(rs.getInt("idboletaje"));
         v.getBoletaje().setNombreboletaje(rs.getString("nombreboletaje"));
         v.getBoletaje().setObsboletaje(rs.getString("obsboletaje"));
         v.getBoletaje().setValorboletaje(rs.getFloat("valorboletaje"));
         v.getBoletaje().setSerieboletaje(rs.getInt("serieboletaje"));
         v.getBoletaje().setFlagmayoredad(rs.getInt("flagmayoredad"));
         v.getConceptoexoneracionpago().setIdconceptoexoneracionpago(rs.getInt("idconceptoexoneracionpago"));
         v.getConceptoexoneracionpago().setDesconceptoexoneracionpago(rs.getString("desconceptoexoneracionpago"));
         v.setFlagregistro(rs.getInt("flagregistro"));
         v.setFlagcompleto(rs.getInt("flagcompleto"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return v;  
    }
  }
  
  
  
  public static final class RutaTurismoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Rutaturismo rt=new Rutaturismo();
       
       try {
        rt.setIdrutaturismo(rs.getInt("idrutaturismo"));
        rt.setCodrutaturismo(rs.getString("codrutaturismo"));
        rt.setNombrerutaturismo(rs.getString("nombrerutaturismo"));
        rt.setDetallerutaturismo(rs.getString("detallerutaturismo"));
        rt.getTurismo().setIdturismo(rs.getInt("idturismo"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rt;  
    }
  }

  
  
  
  
  
  
  public static final class UsuarioAreaMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Usuario u=new Usuario();
       try {
       u.setIdUsuario(rs.getInt("idUsuario"));
       u.setUsername(rs.getString("usuario"));
       u.setEstado(rs.getInt("estado"));
       u.getAreaorganica().setIdarea(rs.getInt("idArea"));
       u.setIdpersonanatural(rs.getInt("idpersonanatural"));
       u.setApepat(rs.getString("apepat"));
       u.setApemat(rs.getString("apemat"));
       u.setNombre(rs.getString("nombre"));
       u.getRol().setIdrol(rs.getInt("idrol"));
       //u.setIdrol(rs.getInt("idrol"));
       u.getAreaorganica().getSede().getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return u;  
    }
  }
  
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
  
  
  public static final class EstadoProyectoMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int rowNum)  {
       Estado est=new Estado();
       try {
        est.setIdestado(rs.getInt("idestadoproyecto"));
        est.setNombestado(rs.getString("descripcionestadoproyecto"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return est;  
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
  
  // Agregados para la Infracción
  public static final class InfractorMapper implements RowMapper{
	  public Object mapRow(ResultSet rs, int rowNum){
		  Infractor infractor = null;
		  Tipo t              = null;
		  try {
			  infractor = new Infractor();
			  t         = new Tipo(1);
			  t.setIdtipo(rs.getInt("idtipodocumento"));			  
			  infractor.setTipodocumento(t);
			  infractor.setNumerodocumento(rs.getString("numerodoc"));
			  infractor.setIdpersona(rs.getInt("idpersona"));
			  infractor.setNombre(rs.getString("nombre"));
			  infractor.setApepat(rs.getString("apepat"));
			  infractor.setApemat(rs.getString("apemat"));
			  infractor.setEmpresa("");
			  infractor.setIdinfractor(rs.getInt("idpersona"));
//			  infractor.setIdinfractor(rs.getInt("idinfractor"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return infractor;
	  }
  }
     
	 // JCEV 22-08-2012, actualizado 17-09-2012 10:53 am
	 public static final class InfractorJuridicoMapper implements RowMapper{
		  public Object mapRow(ResultSet rs, int rowNum){
			  Infractor infractor = null;	
			  Tipo t = new Tipo(1);
			  
			  try {
				  infractor = new Infractor();		  
				  // infractor.setIdpersonanatural(rs.getInt("idpersonanatural"));
				  infractor.setIdpersona(rs.getInt("idpersona"));
				  
				  t.setIdtipo(4);			  
				  infractor.setTipodocumento(t);
				  
				  infractor.setNumerodocumento(rs.getString("ruc"));		  
				  			  
				  // JCEV 17-09-2012
				  infractor.setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				  
				  // System.out.println("Persona Juridica: " + infractor.getNombrepersonajuridica());
				  
				  infractor.setEmpresa(rs.getString("razonsocial"));			  
				  infractor.setIdinfractor(rs.getInt("idpersona"));
	  			  
				  // JCEV 17-09-2012
				  // infractor.setIdinfractor(rs.getInt("idinfractor"));
			  
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}		
			return infractor;
		  }
	 }
	  
  //JCEV 13-09-2012 Actualizado
  public static final class InfraccionMapper implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		  Infraccion bean = null;
		try {
			bean = new Infraccion();
			bean.setIdinfraccion(rs.getInt("idinfraccion"));
			bean.setDescripcioninfraccion(rs.getString("descripcioninfraccion"));
			bean.setCodigoinfraccion(rs.getString("codigoinfraccion"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		  
		  
		return bean;
	}
  }
  
  public static final class InfraccionExpedienteMapper implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		  Infraccion bean = new Infraccion();
		try {
			bean.setIdinfraccion(rs.getInt("idinfraccion"));
			bean.setDescripcioninfraccion(rs.getString("descripcioninfraccion"));
			bean.setCodigoinfraccion(rs.getString("codigoinfraccion"));
			bean.setReincidencia(rs.getInt("reincidencia"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		  
		  
		return bean;
	}
  }	  
  
  // JCEV 04-10-2012
  public static final class InfraccionXExpedienteInfractorMapper implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		Infraccion inf = null;
		int nCount     = 0;
		try {
			nCount = rs.getInt("reincidencia");
			inf    = new Infraccion();
			inf.setReincidencia(nCount);
			inf.setIdinfraccion(rs.getInt("nro_infraccion"));
		} catch (Exception e) {
		    e.printStackTrace();
		}		  
		return inf;
	}
  }	  
	  
  public static final class SancionMapper implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		  Sancion bean = new Sancion();
		try {
			bean.setIdsancion(rs.getInt("idsancion"));
			bean.setDescripcionsancion(rs.getString("descripcionsancion"));
			bean.setObservacion(rs.getString("observacion"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  
		  
		return bean;
	}
  }    
  
  public static final class ExpedienteMapper implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		Expediente bean = new Expediente();
		try {    			
			bean.setIdexpediente(rs.getInt("idexpediente"));
			bean.getArchivo().setIdarchivo(rs.getInt("idarchivo_v"));
			bean.getAnpxExpedientexano().setCodAnpxExpedientexAno(rs.getString("codanpxexpedientexano"));
			
			bean.getInfractor().setIdinfractor(rs.getInt("idinfractor"));
			
			bean.getInfractor().setIdpersona(rs.getInt("idpersona"));
			
			bean.getInfractor().setApepat(rs.getString("apepat"));
			bean.getInfractor().setApemat(rs.getString("apemat"));
			bean.getInfractor().setNombre(rs.getString("nombre"));
			
			bean.getInfractor().setRuc(rs.getString("elruc"));			
			
			bean.getInfractor().setEmpresa(rs.getString("razonsocial"));
			
			bean.getInfractor().getTipodocumento().setIdtipo(rs.getInt("idtipodocumento"));
			bean.getInfractor().setNumerodocumento(rs.getString("numerodoc"));
						
			bean.setFechaExpedienteString(rs.getString("fechaexpediente"));
						
			bean.getResolucion().setIdresolucion(rs.getInt("idresolucion"));
			bean.getResolucion().setFecharesolucion(rs.getString("fecharesolucion"));
			bean.getResolucion().setFechanotificacion(rs.getString("fechanotificacion"));
			
			
			bean.getResolucion().setNumeroresolucion(rs.getString("numeroresolucion"));
			bean.getResolucion().getArchivo().setIdarchivo(rs.getInt("idarchivo_p"));
			bean.getResolucion().getArchivo().setNombreinicial(rs.getString("nombreinicialarchivo"));
			bean.getResolucion().getArchivo().setNombregenerado(rs.getString("nombregeneradoarchivo"));
			bean.getResolucion().getArchivo().setMimearchivo(rs.getString("mimearchivo"));
			
			bean.getResolucion().getArchivo().getDirectorioarchivo().setDirdirectorio(rs.getString("dirdirectorio"));
			bean.getResolucion().getArchivo().getDirectorioarchivo().setIddirectorioarchivo(rs.getInt("iddirectorioarchivo"));
			
			// JCEV 21-10-2012
			//bean.setMorosidad(rs.getString("flagmorosidad"));
			bean.setFlagestadopago(Integer.valueOf(rs.getString("flagmorosidad")));
			bean.setEstadoexpediente(rs.getInt("estadoexpediente"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		  
		return bean;
	}
  }
  
//creo un mapper para expediente sancion
  
public static final class ExpedienteSancionMapper  implements RowMapper{
	  public Object mapRow(ResultSet rs,int rowNum) {
		ExpedienteSancion bean = null;
		try {    			
			bean = new ExpedienteSancion();
			
			bean.getExpediente().setIdexpediente(rs.getInt("idexpediente"));
			bean.getSancion().setIdsancion(rs.getInt("idsancion"));
			
			bean.getSancion().setDescripcionsancion(rs.getString("descripcionsancion"));
			
			bean.getDetalleExpedienteSancion().setDatoVariado(rs.getString("datovariado"));
			bean.getDetalleExpedienteSancion().setObservacion(rs.getString("observacion"));
			
			// JCEV 13-09-2012
//			bean.setObservacion(rs.getString("observacion"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	  }
}
  
  
//JCEV 19-07-2012
 public static final class DetalleExpedienteSancionMapper implements RowMapper{
	  public Object mapRow(ResultSet rs, int rowNum) {
		DetalleExpedienteSancion det = null;
		try {
			det = new DetalleExpedienteSancion();
			det.setIdDetalleExpedienteSancion(rs.getInt("iddetalleexpedientesancion"));
			det.setDatoVariado(rs.getString("datovariado"));
			det.setObservacion(rs.getString("observacion"));
			det.setEstado(rs.getInt("estado"));
			det.setIdexpediente(rs.getInt("idexpediente"));
			det.setIdsancion(rs.getInt("idsancion"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return det;
	  }
 }
 
//JCEV 19-07-2012, actualizado 02-08-2012
 public static final class TurismoControlPagosMapper implements RowMapper {
	  
	  public Object mapRow(ResultSet rs, int rowNum)  {
	       TurismoPagos t = null;
	       try {
		       t = new TurismoPagos();
		       t.setnIdtPago(rs.getInt("idpago"));
		       t.setStrCodTPago(rs.getString("codpago"));
		       t.setStrTipoDoc(rs.getString("tipo")); 
		       t.setStrNumDoc(rs.getString("numero")); 
		       t.setStrCodCateg(rs.getString("categoria")); 
		       t.setStrCodAreaNat(rs.getString("anatural"));		       
		       t.setStrRutaTurimo(rs.getString("rturismo"));
		       t.setStrRegTurismo(rs.getString("freg"));
		       t.setdFecRegTur(rs.getDate("freg"));
		       t.setdFechaPago(rs.getDate("freg"));
		       t.setDbImpPag(rs.getDouble("monto"));
		       t.setStrFecMov(rs.getString("fmov"));
		       t.setStrCodRutaTurismo(rs.getString("codigo"));
		       t.setStrRegistroTurista(rs.getString("regturista"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return t;  
	   }
	  
 } 
 
 // JCEV 07-08-2012, actualizado 08-08-2012
 public static final class DetalleTurismoControlPagosMapper implements RowMapper {
	  
	  public Object mapRow(ResultSet rs, int rowNum)  {
		  TurismoPagosDetalle t = null;
	       try {
		       t = new TurismoPagosDetalle();
		       t.setnIdBoletaje(rs.getInt("BOLETAJE"));
		       t.setStrNombreBoletaje(rs.getString("NOMBRE"));
		       t.setnSerieBoletaje(rs.getInt("SERIE")); 
		       t.setDbValorBoletaje(rs.getDouble("VALOR")); 	
//		       System.out.println(" BOL : " + t.getnIdBoletaje() + 
//		    		              " NOM : " + t.getStrNombreBoletaje() + 
//		    		              " SER : " + t.getnSerieBoletaje() + 
//		    		              " VAL : " + t.getDbValorBoletaje()); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return t;  
	   }	  
 } 
 
 // JCEV 12-10-2012
 public static final class estadoFlagMorosidadXExpedienteMapper implements RowMapper {
	  
	  public Object mapRow(ResultSet rs, int rowNum)  {
		  int nMorosidad = 0;
	      try {
	    	  nMorosidad = rs.getInt("flagmorosidad");
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
		  return nMorosidad;  
	   }	  
 } 
 
}