package proyecto.quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.GestorEnvioMail;
import proyecto.vo.Areanatural;
import proyecto.vo.FichaRegistro;
import proyecto.vo.HistorialJefesAnp;
import proyecto.vo.Personajuridica;
import proyecto.vo.Personal;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
import proyecto.vo.Tipo;

public class QuartzSQL {

	public static FichaRegistro muestraFicha(int idficharegistro) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		FichaRegistro f = new FichaRegistro();

		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFichaRegistro);
		sqlb.append("WHERE fr.idficharegistro = ?");

		String sql = sqlb.toString();

		try {
			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idficharegistro);
			rs = stmt.executeQuery();

			if (rs.next()) {

				f.setIdficharegistro(rs.getInt("idficharegistro"));
				f.setCodigoficha(rs.getString("codigoficha"));
				f.setLote(rs.getString("lote"));
				f.setNombreproyecto(rs.getString("nombreproyecto"));
				f.setActividad(rs.getString("actividad"));
				f.setLugar(rs.getString("lugar"));
				f.getOperadorturismo().setIdpersonajuridica(
						rs.getInt("idpersonajuridica"));
				f.setFechacreacion(rs.getTimestamp("fechacreacion"));
				f.setIdestadoficha(rs.getInt("idestadoficha"));
				f.setNombrearchivo(rs.getString("nombrearchivo"));

				f.setFechaaprobacion(rs.getTimestamp("fechaaprobacion"));
				f.setFechaaprobsys(rs.getTimestamp("fechaaprobsys"));
				f.setObservacion(rs.getString("observacion"));
				f.setComentario(rs.getString("comentario"));

			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return f;
	}

	public static Personajuridica listarPersonaJuridica(int idpersonaj) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Personajuridica pj = new Personajuridica();

		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonaJuridica);

		sqlb.append(" and pj.idpersonajuridica= ?");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idpersonaj);
			rs = stmt.executeQuery();

			if (rs.next()) {

				pj.setIdpersona(rs.getInt("idpersona"));
				pj.setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				pj.setCorreoinstitucional(rs.getString("correoinstitucional"));
				pj.setTelefono(rs.getString("telefono"));
				pj.setNombrepersonajuridica(rs
						.getString("nombrepersonajuridica"));
				pj.setRuc(rs.getString("ruc"));
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return pj;
	}

	public static Personanatural listarPersonaNaturalxID(int idpersona) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Personanatural g = new Personanatural();
		Tipo t = new Tipo(1);
		Tipo s = new Tipo(2);

		StringBuffer sqlb = new StringBuffer(
				SqlConstants.listaPersonaNaturalxID);
		sqlb.append("  and  idpersona = ?");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idpersona);
			rs = stmt.executeQuery();

			if (rs.next()) {

				t.setIdtipo(rs.getInt("idtipodocumento"));
				s.setIdtipo(rs.getInt("idsexo"));
				g.setIdpersonanatural(rs.getInt("idpersonanatural"));
				g.setApepat(rs.getString("apepat"));
				g.setApemat(rs.getString("apemat"));
				g.setNombre(rs.getString("nombre"));
				g.setTipodocumento(t);
				g.setNumerodocumento(rs.getString("numerodoc"));
				g.setSexo(s);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return g;
	}

	public static List<Tipo> listarTipoMT(Tipo tipo, int idficharegistro) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Tipo> c = new ArrayList<Tipo>();

		StringBuffer sqlb = new StringBuffer(
				SqlConstants.listaMedioTransporteFicha);

		sqlb.append("WHERE frt.idficharegistro= ?");
		sqlb.append(" AND tt.idtabla= ?");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idficharegistro);
			stmt.setInt(2, tipo.getIdtabla());
			rs = stmt.executeQuery();

			while (rs.next()) {
				Tipo t = new Tipo();
				t.setIdtipo(rs.getInt("idtablatipo"));
				t.setNombretipo(rs.getString("destablatipo"));
				t.setOrdentipo(rs.getInt("ordtablatipo"));
				t.setAbrevtipo(rs.getString("abrtablatipo"));
				t.setIdtabla(rs.getInt("idtabla"));
				t.setCodigointtipo(rs.getInt("codinttablatipo"));
				t.setMensajetipo(rs.getString("mensajetablatipo"));
				c.add(t);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return c;
	}

	public static List<Tipo> listarTipo(Tipo tipo) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Tipo> c = new ArrayList<Tipo>();

		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipo);
		sqlb.append(" and t.idtabla= ?");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, tipo.getIdtabla());
			rs = stmt.executeQuery();

			while (rs.next()) {
				Tipo t = new Tipo();
				t.setIdtipo(rs.getInt("idtablatipo"));
				t.setNombretipo(rs.getString("destablatipo"));
				t.setOrdentipo(rs.getInt("ordtablatipo"));
				t.setAbrevtipo(rs.getString("abrtablatipo"));
				t.setIdtabla(rs.getInt("idtabla"));
				t.setCodigointtipo(rs.getInt("codinttablatipo"));
				t.setMensajetipo(rs.getString("mensajetablatipo"));
				c.add(t);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return c;

	}

	public static List<PersonalRegistro> listarPersonalxFicha(
			int idficharegistro) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PersonalRegistro> c = new ArrayList<PersonalRegistro>();

		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalRegistroxFicha);
		sqlb.append("and  pfr.idficharegistro = ?");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idficharegistro);
			rs = stmt.executeQuery();

			while (rs.next()) {
				PersonalRegistro g = new PersonalRegistro();
				Tipo t = new Tipo(1);
				Tipo s = new Tipo(2);
				Tipo l = new Tipo(22);

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
				
				c.add(g);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return c;

	}

	public static HistorialJefesAnp obtineActualJefe(int idanp) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		HistorialJefesAnp hja = new HistorialJefesAnp();
		Areanatural an = new Areanatural();
		Personal p = new Personal();

		StringBuffer sqlb = new StringBuffer(SqlConstants.listarJefesAnp);
		sqlb.append("WHERE hja.idareanatural = ?");
		sqlb.append(" ORDER BY hja.fechadesigna DESC LIMIT 1");
		String sql = sqlb.toString();

		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idanp);
			rs = stmt.executeQuery();

			if (rs.next()) {
				an.setIdareanatural(rs.getInt("idareanatural"));
				p.setIdpersonal(rs.getInt("idpersonal"));
				p.setIdpersonanatural(rs.getInt("idpersonanatural"));
				p.setMailpersonal(rs.getString("mailpersonal"));

				hja.setAreanatural(an);
				hja.setPersonal(p);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return hja;

	}

	public static void aprobarFichaRegistro(FichaRegistro fr) {

		Connection con = null;
		PreparedStatement stmt = null;

		StringBuffer sqlb = new StringBuffer(SqlConstants.aprobarFichaRegistro_);		
		String sql = sqlb.toString();

		try {
			con = QuartzConexionBD.obtenerConexion();

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, fr.getIdestadoficha());
			stmt.setString(2, fr.getNombrearchivo());
			stmt.setTimestamp(3, fr.getFechaaprobacion());
			stmt.setInt(4, fr.getIdficharegistro());
			stmt.executeUpdate();

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	public static boolean enviarMailConfirmacionRegistroConAdjunto(
			FichaRegistro fr, String adjunto, HistorialJefesAnp hja) {
		try {

			String hostname = "mail.sernanp.gob.pe";
			String puerto = "25";
			String username = "desarrollo";
			String password = "Geniu2015";
			String remitente = "webmaster@sernanp.gob.pe";
			int ssl = 0;

			GestorEnvioMail.setearParametrosEnvio(hostname, puerto, username, password, remitente, ssl);
			// redactar msg
			String cuerpomsg = "Su solicitud de ingreso con código:"
					+ fr.getCodigoficha()
					+ " fue aprobado. Se adjunta Ficha para su Impresión y presentación al momento del ingreso.";
			// obtener asunto msg
			String asuntomsg = "Confirmación de envío";

			GestorEnvioMail.enviarMail(fr.getPersonajuridica()
					.getCorreoinstitucional(), asuntomsg, cuerpomsg, adjunto);

			cuerpomsg = "SE LE INFORMA QUE SE HA APROBADO UNA SOLICITUD DE INGRESO AL ANP CON CODIGO: "
					+ fr.getCodigoficha();
			asuntomsg = "APROBACION DE SOLICITUD DE INGRESO AL ANP";
			// String correo = "ycoyla@sernanp.gob.pe";

			GestorEnvioMail.enviarMail(hja.getPersonal().getMailpersonal(),
					asuntomsg, cuerpomsg, adjunto);
		} catch (Exception e) {
			return false;
			// e.printStackTrace();
		}

		return true;
	}
	
	public static Areanatural obtieneAreaNatural(int idanp){
		
		Areanatural an=new Areanatural();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNatural);
		sqlb.append(" and a.flagactivoareanatural = ?" );
		sqlb.append(" and a.idareanatural = ?" );
		
		String sql = sqlb.toString();
		
		try {

			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			stmt.setInt(2, idanp);
			rs = stmt.executeQuery();

			if (rs.next()) {
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
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return an;
		
	}
}
