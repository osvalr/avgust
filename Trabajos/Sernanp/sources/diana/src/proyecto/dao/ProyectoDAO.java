package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.param.ProyectoParam;
import proyecto.util.ConexionBD;
import proyecto.vo.Archivo;
import proyecto.vo.Proyecto;


public class ProyectoDAO  {
	
	private ConexionBD dt;
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	 public ProyectoDAO()  {
		dt = new ConexionBD();
	}
		
		
	 public int contarSubConsulta(ProyectoParam proyectoParam) {
		 
		    Connection cn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.contarProyecto);
			
			if(proyectoParam.getProyecto().getNombreproyecto()!=null)
			{
			sqlb.append(" and p.nombreproyecto like '%" );
			sqlb.append(proyectoParam.getProyecto().getNombreproyecto() );
			sqlb.append("%' " );
			}
			if(proyectoParam.getProyecto().getObjetivoproyecto()!=null)
			{
			sqlb.append(" and p.objetivoproyecto like '%" );
			sqlb.append(proyectoParam.getProyecto().getObjetivoproyecto() );
			sqlb.append("%' " );
			}
			if(proyectoParam.getProyecto().getAreaespecificaproyecto()!=null)
			{
			sqlb.append(" and p.areaespecificaproyecto like '%" );
			sqlb.append(proyectoParam.getProyecto().getAreaespecificaproyecto() );
			sqlb.append("%' " );
			}
			if(proyectoParam.getProyecto().getTipoproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idtipoproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getTipoproyecto().getIdtipo());
			}
			if(proyectoParam.getProyecto().getEstadoproyecto().getIdestado()!=0 ){
				sqlb.append(" and p.idestadoproyecto=" );
				sqlb.append(proyectoParam.getProyecto().getEstadoproyecto().getIdestado());
				}
			if(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo()!=0 ){
				sqlb.append(" and p.idcategoriaproyecto=" );
				sqlb.append(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo());
			}
			
			if(proyectoParam.getProyecto().getFlagVigencia()!=0 ){
				sqlb.append(" and p.flagvigencia=" );
				sqlb.append(proyectoParam.getProyecto().getFlagVigencia());
			}
			
			if(proyectoParam.getProyecto().getFlagProyecto()!=0 ){
				sqlb.append(" and p.flagproyecto=" );
				sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
			}
			else
				if(proyectoParam.getProyecto().getFlagProyecto()==ValueConstants.VALOR_CERO ){
					sqlb.append(" and p.flagproyecto=0" );
				}
			if(proyectoParam.getProyecto().getProyectoPrincipal()!=null ){
				if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()!=0){
					sqlb.append(" and p.idproyectogrupo=" );
					sqlb.append(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto());
				}
				else
					if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()==ValueConstants.VALOR_CERO){
						sqlb.append(" and p.idproyectogrupo=null" );
					}
				
		    }
			/*
			if(proyectoParam.getProyecto().getFlagProyecto()!=ValueConstants.FLAG_TODOS ){
				sqlb.append(" and p.flagproyecto=" );
				sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
			}
			*/
			if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(SqlConstants.listaProyectoSubAreaNatural);
			if(proyectoParam.getAreanatural().getIdareanatural()!=0){
				sqlb.append(" and idareanatural=");
				sqlb.append(proyectoParam.getAreanatural().getIdareanatural());
				
			}
			
			else 
				if(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
					sqlb.append(" and idcategoriaanp=");
					sqlb.append(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
					
				}
			
			sqlb.append(") ");
			}
			
			
			if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
				sqlb.append(SqlConstants.listaProyectoSubEjecutorFinanciero);
				sqlb.append(proyectoParam.getEjecutorFinanciero().getIdejecutor());
				sqlb.append(" and p.idtipoejecutor=");
				sqlb.append(ValueConstants.EJECUTOR_FINANCIERO);
			}
			
			
			if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
				sqlb.append(SqlConstants.listaProyectoSubEjecutorTecnico);
				sqlb.append(proyectoParam.getEjecutorTecnico().getIdejecutor());
				sqlb.append(" and p.idtipoejecutor=");
				sqlb.append(ValueConstants.EJECUTOR_TECNICO);
			}
			
			if(proyectoParam.getFtefto().getIdftefto()!=0){
				sqlb.append(SqlConstants.listaProyectoSubFteFto);
				sqlb.append(proyectoParam.getFtefto().getIdftefto());
			}
			if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(")");
			}
			
			if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
				sqlb.append(")");
			}
			if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
				sqlb.append(")");
			}
			if(proyectoParam.getFtefto().getIdftefto()!=0){
				sqlb.append(")");
			}
			
			
		
			
			String sql =sqlb.toString();
			
			
			int total=0;
			try{
				 cn=dt.obtenerConexion();
				 st=cn.prepareStatement(sql);
				 rs=st.executeQuery();
				 if(rs.next()){
					 total=rs.getInt("total");
				 }
				 
				 
			
				 dt.cerrarConexion(cn,null,st);
					
			}catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}		
			
			
			
			return total;
		
	}
	
	


	
	
	public List<Proyecto> listarPaginadoSubConsulta(ProyectoParam proyectoParam,int offset,int tamPagina) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaProyecto);
	
		
		if(proyectoParam.getProyecto().getNombreproyecto()!=null)
		{
		sqlb.append(" and p.nombreproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getNombreproyecto() );
		sqlb.append("%' " );
		}
		if(proyectoParam.getProyecto().getObjetivoproyecto()!=null)
		{
		sqlb.append(" and p.objetivoproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getObjetivoproyecto() );
		sqlb.append("%' " );
		}
		if(proyectoParam.getProyecto().getAreaespecificaproyecto()!=null)
		{
		sqlb.append(" and p.areaespecificaproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getAreaespecificaproyecto() );
		sqlb.append("%' " );
		}
		
		if(proyectoParam.getProyecto().getTipoproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idtipoproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getTipoproyecto().getIdtipo());
			}
		if(proyectoParam.getProyecto().getEstadoproyecto().getIdestado()!=0 ){
			sqlb.append(" and p.idestadoproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getEstadoproyecto().getIdestado());
			}
		if(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idcategoriaproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo());
			}
		
		
		if(proyectoParam.getProyecto().getFlagVigencia()!=0 ){
			sqlb.append(" and p.flagvigencia=" );
			sqlb.append(proyectoParam.getProyecto().getFlagVigencia());
			}
		
		if(proyectoParam.getProyecto().getFlagProyecto()!=0 ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
		}
		else
			if(proyectoParam.getProyecto().getFlagProyecto()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and p.flagproyecto=0" );
			}
		if(proyectoParam.getProyecto().getProyectoPrincipal()!=null ){
			if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()!=0){
				sqlb.append(" and p.idproyectogrupo=" );
				sqlb.append(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto());
			}
			else
				if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()==ValueConstants.VALOR_CERO){
					sqlb.append(" and p.idproyectogrupo=null" );
				}
			
	    }
		/*
		if(proyectoParam.getProyecto().getFlagProyecto()!=ValueConstants.FLAG_TODOS ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
		}
		*/
		if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
		sqlb.append(SqlConstants.listaProyectoSubAreaNatural);
		
		if(proyectoParam.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and idareanatural=");
			sqlb.append(proyectoParam.getAreanatural().getIdareanatural());
			
		}
		else 
		
			if(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(" and idcategoriaanp=");
			sqlb.append(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
			
		}
		sqlb.append(") ");
		}
		
		
		if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
			sqlb.append(SqlConstants.listaProyectoSubEjecutorFinanciero);
			sqlb.append(proyectoParam.getEjecutorFinanciero().getIdejecutor());
			sqlb.append(" and p.idtipoejecutor=");
			sqlb.append(ValueConstants.EJECUTOR_FINANCIERO);
		}
		
		
		if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
			sqlb.append(SqlConstants.listaProyectoSubEjecutorTecnico);
			sqlb.append(proyectoParam.getEjecutorTecnico().getIdejecutor());
			sqlb.append(" and p.idtipoejecutor=");
			sqlb.append(ValueConstants.EJECUTOR_TECNICO);
		}
		if(proyectoParam.getFtefto().getIdftefto()!=0){
			sqlb.append(SqlConstants.listaProyectoSubFteFto);
			sqlb.append(proyectoParam.getFtefto().getIdftefto());
		}
		
		if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(")");
			}
		if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
			sqlb.append(")");
		}
		if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
			sqlb.append(")");
		}
			if(proyectoParam.getFtefto().getIdftefto()!=0){
				sqlb.append(")");
			}
			
			
			sqlb.append(" order by p.nombreproyecto ");
			sqlb.append(" LIMIT ");
			sqlb.append(offset);
			sqlb.append(",");
			sqlb.append(tamPagina);
			
			String sql =sqlb.toString();
			
			List<Proyecto> lista=new ArrayList<Proyecto>();
			try{
				 cn=dt.obtenerConexion();
				 st=cn.prepareStatement(sql);
				 rs=st.executeQuery();
				 
				 while(rs.next())
				 {
					 Proyecto p=new Proyecto();
					 p.setIdproyecto(rs.getInt("idproyecto"));
					 p.setNombreproyecto(rs.getString("nombreproyecto"));
					 p.setSiglasproyecto(rs.getString("siglasproyecto"));
					 p.setObjetivoproyecto(rs.getString("objetivoproyecto"));
					 p.setAreaespecificaproyecto(rs.getString("areaespecificaproyecto"));
					 p.setPeriodoproyecto(rs.getInt("periodoproyecto"));
					 p.getEstadoproyecto().setIdestado(rs.getInt("idestadoproyecto"));
					 p.setCodigoproyecto(rs.getString("codigoproyecto"));
					 p.setFechainicioproyecto(rs.getDate("fechainicioproyecto"));
					 p.setFechafinproyecto(rs.getDate("fechafinproyecto"));
					 p.setObservacionproyecto(rs.getString("observacionproyecto"));
					 p.setCompromisoproyecto(rs.getString("compromisoproyecto"));
					 p.getCategoriaproyecto().setIdtipo(rs.getInt("idcategoriaproyecto"));
					 p.setFlagVigencia(rs.getInt("flagvigencia"));
					 p.setFlagProyecto(rs.getInt("flagproyecto"));
					 p.getMoneda().setIdmoneda(rs.getInt("idmoneda"));
					 lista.add(p);
				 }
					
				 dt.cerrarConexion(cn,rs,st);
						
						
			}catch(SQLException e){
						e.printStackTrace();
			}
		    catch(Exception e){
						e.printStackTrace();
			}		
					
		return lista;
}
			
			
		
	
	public List<Proyecto> listarSubConsulta(ProyectoParam proyectoParam) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaProyecto);
			
		if(proyectoParam.getProyecto().getNombreproyecto()!=null)
		{
		sqlb.append(" and p.nombreproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getNombreproyecto() );
		sqlb.append("%' " );
		}
		if(proyectoParam.getProyecto().getObjetivoproyecto()!=null)
		{
		sqlb.append(" and p.objetivoproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getObjetivoproyecto() );
		sqlb.append("%' " );
		}
		if(proyectoParam.getProyecto().getAreaespecificaproyecto()!=null)
		{
		sqlb.append(" and p.areaespecificaproyecto like '%" );
		sqlb.append(proyectoParam.getProyecto().getAreaespecificaproyecto() );
		sqlb.append("%' " );
		}
		
		if(proyectoParam.getProyecto().getTipoproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idtipoproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getTipoproyecto().getIdtipo());
			}
		if(proyectoParam.getProyecto().getEstadoproyecto().getIdestado()!=0 ){
			sqlb.append(" and p.idestadoproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getEstadoproyecto().getIdestado());
			}
		if(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idcategoriaproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getCategoriaproyecto().getIdtipo());
			}
		
		
		if(proyectoParam.getProyecto().getFlagVigencia()!=0 ){
			sqlb.append(" and p.flagvigencia=" );
			sqlb.append(proyectoParam.getProyecto().getFlagVigencia());
			}
		
		if(proyectoParam.getProyecto().getFlagProyecto()!=0 ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
		}
		else
			if(proyectoParam.getProyecto().getFlagProyecto()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and p.flagproyecto=0" );
			}
		if(proyectoParam.getProyecto().getProyectoPrincipal()!=null ){
			if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()!=0){
				sqlb.append(" and p.idproyectogrupo=" );
				sqlb.append(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto());
			}
			else
				if(proyectoParam.getProyecto().getProyectoPrincipal().getIdproyecto()==ValueConstants.VALOR_CERO){
					sqlb.append(" and p.idproyectogrupo=null" );
				}
			
	    }
		/*
		if(proyectoParam.getProyecto().getFlagProyecto()!=ValueConstants.FLAG_TODOS ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyectoParam.getProyecto().getFlagProyecto());
		}
		*/
		if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
		sqlb.append(SqlConstants.listaProyectoSubAreaNatural);
		
		if(proyectoParam.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and idareanatural=");
			sqlb.append(proyectoParam.getAreanatural().getIdareanatural());
			
		}
		else 
		
			if(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(" and idcategoriaanp=");
			sqlb.append(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
			
		}
		sqlb.append(") ");
		}
		
		
		if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
			sqlb.append(SqlConstants.listaProyectoSubEjecutorFinanciero);
			sqlb.append(proyectoParam.getEjecutorFinanciero().getIdejecutor());
			sqlb.append(" and p.idtipoejecutor=");
			sqlb.append(ValueConstants.EJECUTOR_FINANCIERO);
		}
		
		
		if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
			sqlb.append(SqlConstants.listaProyectoSubEjecutorTecnico);
			sqlb.append(proyectoParam.getEjecutorTecnico().getIdejecutor());
			sqlb.append(" and p.idtipoejecutor=");
			sqlb.append(ValueConstants.EJECUTOR_TECNICO);
		}
		if(proyectoParam.getFtefto().getIdftefto()!=0){
			sqlb.append(SqlConstants.listaProyectoSubFteFto);
			sqlb.append(proyectoParam.getFtefto().getIdftefto());
		}
		
		if(proyectoParam.getAreanatural().getIdareanatural()!=0 ||proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(")");
			}
		if(proyectoParam.getEjecutorFinanciero().getIdejecutor()!=0){
			sqlb.append(")");
		}
		if(proyectoParam.getEjecutorTecnico().getIdejecutor()!=0){
			sqlb.append(")");
		}
			if(proyectoParam.getFtefto().getIdftefto()!=0){
				sqlb.append(")");
			}
			
			
			sqlb.append(" order by p.nombreproyecto ");
			/*
			sqlb.append(" LIMIT ");
			sqlb.append(offset);
			sqlb.append(",");
			sqlb.append(tamPagina);
			*/
			String sql =sqlb.toString();
			//System.out.println(sql);
			List<Proyecto> lista=new ArrayList<Proyecto>();
			try{
				 cn=dt.obtenerConexion();
				 st=cn.prepareStatement(sql);
				 rs=st.executeQuery();
				 
				 while(rs.next())
				 {
					 Proyecto p=new Proyecto();
					 p.setIdproyecto(rs.getInt("idproyecto"));
					 p.setNombreproyecto(rs.getString("nombreproyecto"));
					 p.setSiglasproyecto(rs.getString("siglasproyecto"));
					 p.getEstadoproyecto().setIdestado(rs.getInt("idestadoproyecto"));
					 p.setCodigoproyecto(rs.getString("codigoproyecto"));
					 p.setObjetivoproyecto(rs.getString("objetivoproyecto"));
					 p.setAreaespecificaproyecto(rs.getString("areaespecificaproyecto"));
					 p.setPeriodoproyecto(rs.getInt("periodoproyecto"));
					 p.setFechainicioproyecto(rs.getDate("fechainicioproyecto"));
					 p.setFechafinproyecto(rs.getDate("fechafinproyecto"));
					 p.setObservacionproyecto(rs.getString("observacionproyecto"));
					 p.setCompromisoproyecto(rs.getString("compromisoproyecto"));
					 p.getCategoriaproyecto().setIdtipo(rs.getInt("idcategoriaproyecto"));
					 p.setFlagVigencia(rs.getInt("flagvigencia"));
					 p.setFlagProyecto(rs.getInt("flagproyecto"));
					 p.getMoneda().setIdmoneda(rs.getInt("idmoneda"));
					 lista.add(p);
				 }
					
				 dt.cerrarConexion(cn,rs,st);
						
						
			}catch(SQLException e){
						e.printStackTrace();
			}
		    catch(Exception e){
						e.printStackTrace();
			}		
					
		return lista;
}
	
	
	
	
	public List<Proyecto> listar(Proyecto proyecto) {
		
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaProyecto);
			
		if(proyecto.getIdproyecto()!=0 ){
			sqlb.append(" and p.idproyecto=" );
			sqlb.append(proyecto.getIdproyecto());
		}
		if(proyecto.getNombreproyecto()!=null)
		{
		sqlb.append(" and p.nombreproyecto like '%" );
		sqlb.append(proyecto.getNombreproyecto() );
		sqlb.append("%' " );
		}
		if(proyecto.getObjetivoproyecto()!=null)
		{
		sqlb.append(" and p.objetivoproyecto like '%" );
		sqlb.append(proyecto.getObjetivoproyecto() );
		sqlb.append("%' " );
		}
		if(proyecto.getAreaespecificaproyecto()!=null)
		{
		sqlb.append(" and p.areaespecificaproyecto like '%" );
		sqlb.append(proyecto.getAreaespecificaproyecto() );
		sqlb.append("%' " );
		}
		if(proyecto.getTipoproyecto().getIdtipo()!=0 ){
		sqlb.append(" and p.idtipoproyecto=" );
		sqlb.append(proyecto.getTipoproyecto().getIdtipo());
		}
		if(proyecto.getEstadoproyecto().getIdestado()!=0 ){
			sqlb.append(" and p.idestadoproyecto=" );
			sqlb.append(proyecto.getEstadoproyecto().getIdestado());
			}
		if(proyecto.getCategoriaproyecto().getIdtipo()!=0 ){
			sqlb.append(" and p.idcategoriaproyecto=" );
			sqlb.append(proyecto.getCategoriaproyecto().getIdtipo());
	    }
		
		if(proyecto.getFlagProyecto()!=0 ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyecto.getFlagProyecto());
		}
		else
			if(proyecto.getFlagProyecto()==ValueConstants.VALOR_CERO ){
				sqlb.append(" and p.flagproyecto=0" );
			}
		/*
		if(proyecto.getFlagProyecto()!=ValueConstants.FLAG_TODOS ){
			sqlb.append(" and p.flagproyecto=" );
			sqlb.append(proyecto.getFlagProyecto());
		}
		*/
		
		if(proyecto.getProyectoPrincipal()!=null ){
			sqlb.append(" and p.idproyectogrupo=" );
			sqlb.append(proyecto.getProyectoPrincipal().getIdproyecto());
	    }	
		if(proyecto.getNivelproyecto()!=0 ){
			sqlb.append(" and p.nivelproyecto=" );
			sqlb.append(proyecto.getNivelproyecto());
	    }	
			String sql =sqlb.toString();
			
			List<Proyecto> lista=new ArrayList<Proyecto>();
			try{
				 cn=dt.obtenerConexion();
				 st=cn.prepareStatement(sql);
				 rs=st.executeQuery();
				 
				 while(rs.next())
				 {
					 Proyecto p=new Proyecto();
					 p.setProyectoPrincipal(new Proyecto());
					 p.setIdproyecto(rs.getInt("idproyecto"));
					 p.setNombreproyecto(rs.getString("nombreproyecto"));
					 p.setSiglasproyecto(rs.getString("siglasproyecto"));
					 p.setCodigoproyecto(rs.getString("codigoproyecto"));
					 p.setObjetivoproyecto(rs.getString("objetivoproyecto"));
					 p.setAreaespecificaproyecto(rs.getString("areaespecificaproyecto"));
					 p.setPeriodoproyecto(rs.getInt("periodoproyecto"));
					 p.setFechainicioproyecto(rs.getDate("fechainicioproyecto"));
					 p.setFechafinproyecto(rs.getDate("fechafinproyecto"));
					 p.setObservacionproyecto(rs.getString("observacionproyecto"));
					 p.setCompromisoproyecto(rs.getString("compromisoproyecto"));
					 p.setComponenteproyecto(rs.getString("componenteproyecto"));
					 p.setCodigoproyecto(rs.getString("codigoproyecto"));
					 p.getTipoproyecto().setIdtipo(rs.getInt("idtipoproyecto"));
					 p.getTipoproyecto().setNombretipo(rs.getString("nombretipoproyecto"));
					 p.getCategoriaproyecto().setIdtipo(rs.getInt("idcategoriaproyecto"));
					 p.getCategoriaproyecto().setNombretipo(rs.getString("nombrecategoriaproyecto"));
					 p.getEstadoproyecto().setIdestado(rs.getInt("idestadoproyecto"));
					 p.getEstadoproyecto().setNombestado(rs.getString("descripcionestadoproyecto"));
					 p.setFlagVigencia(rs.getInt("flagvigencia"));
					 p.setFlagProyecto(rs.getInt("flagproyecto"));
					 p.getMoneda().setIdmoneda(rs.getInt("idmoneda"));
					 p.getMoneda().setNombremoneda(rs.getString("nombremoneda"));
					 p.getProyectoPrincipal().setIdproyecto(rs.getInt("idproyectogrupo"));
					 p.setNivelproyecto(rs.getInt("nivelproyecto"));
					 
					 lista.add(p);
				 }
					
				 dt.cerrarConexion(cn,rs,st);
						
						
			}catch(SQLException e){
						e.printStackTrace();
			}
		    catch(Exception e){
						e.printStackTrace();
			}		
					
		return lista;
	}
	
	
	
	public int insertar(Proyecto proyecto){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaProyecto);
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombreproyecto",proyecto.getNombreproyecto() );
		parametros.put("siglasproyecto",proyecto.getSiglasproyecto());
		parametros.put("objetivoproyecto", proyecto.getObjetivoproyecto());
		parametros.put("areaespecificaproyecto",proyecto.getAreaespecificaproyecto() );
		if(proyecto.getFechainicioproyecto()!=null){
			parametros.put("fechainicioproyecto", new java.sql.Date(proyecto.getFechainicioproyecto().getTime()));
		}
		else{
			parametros.put("fechainicioproyecto", null);
		}
		if(proyecto.getFechafinproyecto()!=null){
			parametros.put("fechafinproyecto", new java.sql.Date(proyecto.getFechafinproyecto().getTime()));
		}
		else{
			parametros.put("fechafinproyecto", null);
		}
		parametros.put("fechafinproyecto", proyecto.getFechafinproyecto());
		parametros.put("observacionproyecto", proyecto.getObservacionproyecto());
		parametros.put("compromisoproyecto", proyecto.getCompromisoproyecto());
		parametros.put("idestadoproyecto", proyecto.getEstadoproyecto().getIdestado());
		parametros.put("codigoproyecto", proyecto.getCodigoproyecto());
		parametros.put("idmoneda", proyecto.getMoneda().getIdmoneda());
		parametros.put("componenteproyecto", proyecto.getComponenteproyecto());
		parametros.put("nivelproyecto", proyecto.getNivelproyecto());
		if(proyecto.getProyectoPrincipal()!=null){
			if(proyecto.getProyectoPrincipal().getIdproyecto()==ValueConstants.ID_PROYECTO_PRINCIPAL){
				parametros.put("idproyectogrupo", null);
				parametros.put("nivelproyecto", ValueConstants.NIVEL_UNO);
			}
			
			else
				if(proyecto.getProyectoPrincipal().getIdproyecto()==0){
					parametros.put("idproyectogrupo", null);
					
				}
				else
					if(proyecto.getProyectoPrincipal().getIdproyecto()!=0){
						parametros.put("idproyectogrupo", proyecto.getProyectoPrincipal().getIdproyecto());
						
					}
			  
		}
		
		parametros.put("idcategoriaproyecto", proyecto.getCategoriaproyecto().getIdtipo());
		parametros.put("flagproyecto", proyecto.getFlagProyecto());
		parametros.put("idtipoproyecto", proyecto.getTipoproyecto().getIdtipo());
		
		
		
		
		
		simpleJdbcTemplate.update(sql, parametros);
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		return codigo;	
	}
	
	
	
	
	/*
	public int insertar(Proyecto proyecto){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("insert into proyecto(");
		if(proyecto.getNombreproyecto()!=null){
			sql.append("nombreproyecto,");
		}
		if(proyecto.getObjetivoproyecto()!=null){
			sql.append("objetivoproyecto,");
			
		}
		if(proyecto.getAreaespecificaproyecto()!=null){
			sql.append("areaespecificaproyecto,");
		}
		if(proyecto.getObservacionproyecto()!=null){
			sql.append("observacionproyecto,");
		}
		if(proyecto.getCompromisoproyecto()!=null){
			sql.append("compromisoproyecto,");
		}
		if(proyecto.getTipoproyecto().getIdtipo()!=0){
			sql.append("idtipoproyecto,");
		}
		if(proyecto.getCategoriaproyecto().getIdtipo()!=0){
			sql.append("idcategoriaproyecto,");
		}
		if(proyecto.getEstadoproyecto().getIdestado()!=0){
			sql.append("idestadoproyecto,");
		}
		if(proyecto.getMoneda().getIdmoneda()!=0){
			sql.append("idmoneda,");
		}
		if(proyecto.getFechainicioproyecto()!=null){
			sql.append("fechainicioproyecto,");
		}
		if(proyecto.getFechafinproyecto()!=null){
			sql.append("fechafinproyecto,");
		}
		if(proyecto.getProyectoPrincipal()!=null){
			if(proyecto.getProyectoPrincipal().getIdproyecto()!=0){
			sql.append("idproyectogrupo,");
			}
		}
		sql.append("flagproyecto,");
		
		sql.delete(sql.length()-1, sql.length());
		sql.append(")");
		sql.append(" values (");
		if(proyecto.getNombreproyecto()!=null){
			sql.append("'");
			sql.append(proyecto.getNombreproyecto()+"',");
		}
		if(proyecto.getObjetivoproyecto()!=null){
			sql.append("'");
			sql.append(proyecto.getObjetivoproyecto()+"',");
		}
		if(proyecto.getAreaespecificaproyecto()!=null){
			sql.append("'");
			sql.append(proyecto.getAreaespecificaproyecto()+"',");
		}
		if(proyecto.getObservacionproyecto()!=null){
			sql.append("'");
			sql.append(proyecto.getObservacionproyecto()+"',");
		}
		if(proyecto.getCompromisoproyecto()!=null){
			sql.append("'");
			sql.append(proyecto.getCompromisoproyecto()+"',");
		}
		if(proyecto.getTipoproyecto().getIdtipo()!=0){
			sql.append(proyecto.getTipoproyecto().getIdtipo()+",");
		}
		if(proyecto.getCategoriaproyecto().getIdtipo()!=0){
			sql.append(proyecto.getCategoriaproyecto().getIdtipo()+",");
		}
		if(proyecto.getEstadoproyecto().getIdestado()!=0){
			sql.append(proyecto.getEstadoproyecto().getIdestado()+",");
		}
		if(proyecto.getMoneda().getIdmoneda()!=0){
			sql.append(proyecto.getMoneda().getIdmoneda()+",");
		}
		if(proyecto.getFechainicioproyecto()!=null){
			sql.append("' ");
			sql.append(new java.sql.Date(proyecto.getFechainicioproyecto().getTime()));
			sql.append("',");
		}
		if(proyecto.getFechafinproyecto()!=null){
			sql.append("' ");
			sql.append(new java.sql.Date(proyecto.getFechafinproyecto().getTime()));
			sql.append("',");
		}
		if(proyecto.getProyectoPrincipal()!=null){
			if(proyecto.getProyectoPrincipal().getIdproyecto()!=0){
				sql.append(proyecto.getProyectoPrincipal().getIdproyecto()+",");
			}		
		}
		sql.append(proyecto.getFlagProyecto()+",");
		sql.delete(sql.length()-1, sql.length());
		sql.append(")");
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		int idproyecto=0;
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 st.execute();
             rs=st.executeQuery("SELECT LAST_INSERT_ID()");
             if(rs.next())
               idproyecto = rs.getInt(1);
			dt.cerrarConexion(cn,rs,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		return idproyecto;
		
	}
	*/
	
	public void actualizar(Proyecto proyecto)
	{
		
		Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer("update proyecto set nombreproyecto=nombreproyecto ");
		if(proyecto.getNombreproyecto()!=null){
			sql.append(",  nombreproyecto='");
			sql.append(proyecto.getNombreproyecto());
			sql.append("' ");
		}
		if(proyecto.getObjetivoproyecto()!=null){
			sql.append(",  objetivoproyecto='");
			sql.append(proyecto.getObjetivoproyecto());
			sql.append("' ");
		}
		if(proyecto.getCodigoproyecto()!=null){
			sql.append(",  codigoproyecto='");
			sql.append(proyecto.getCodigoproyecto());
			sql.append("' ");
		}
		if(proyecto.getAreaespecificaproyecto()!=null){
			sql.append(",  areaespecificaproyecto='");
			sql.append(proyecto.getAreaespecificaproyecto());
			sql.append("' ");
		}
		if(proyecto.getPeriodoproyecto()!=0){
			sql.append(",  periodoproyecto=");
			sql.append(proyecto.getPeriodoproyecto());
			
		}
		if(proyecto.getFlagProyecto()!=0){
			sql.append(",  flagproyecto=");
			if(proyecto.getFlagProyecto()==ValueConstants.VALOR_CERO){
				sql.append("0");
			}
			else{
				sql.append(proyecto.getFlagProyecto());
			}
			
		}
		if(proyecto.getObservacionproyecto()!=null){
			sql.append(",  observacionproyecto='");
			sql.append(proyecto.getObservacionproyecto());
			sql.append("' ");
		}
		if(proyecto.getCompromisoproyecto()!=null){
			sql.append(",  compromisoproyecto='");
			sql.append(proyecto.getCompromisoproyecto());
			sql.append("' ");
		}
		if(proyecto.getComponenteproyecto()!=null){
			sql.append(",  componenteproyecto='");
			sql.append(proyecto.getComponenteproyecto());
			sql.append("' ");
		}
		
		/*
		if(proyecto.getTipoproyecto().getIdtipo()!=0){
			sql.append(",  idtipoproyecto=");
			sql.append(proyecto.getTipoproyecto().getIdtipo());
		}
		*/
		if(proyecto.getEstadoproyecto().getIdestado()!=0){
			sql.append(",  idestadoproyecto=");
			sql.append(proyecto.getEstadoproyecto().getIdestado());
		}
		if(proyecto.getTipoproyecto().getIdtipo()!=0){
			sql.append(",  idtipoproyecto=");
			sql.append(proyecto.getTipoproyecto().getIdtipo());
		}
		if(proyecto.getCategoriaproyecto().getIdtipo()!=0){
			sql.append(",  idcategoriaproyecto=");
			sql.append(proyecto.getCategoriaproyecto().getIdtipo());
		}
		if(proyecto.getMoneda().getIdmoneda()!=0){
			sql.append(",  idmoneda=");
			sql.append(proyecto.getMoneda().getIdmoneda());
		}
		if(proyecto.getFechainicioproyecto()!=null){
			sql.append(",  fechainicioproyecto='");
			sql.append(new java.sql.Date(proyecto.getFechainicioproyecto().getTime()));
			sql.append("' ");
		}
		if(proyecto.getFechafinproyecto()!=null){
			sql.append(",  fechafinproyecto='");
			sql.append(new java.sql.Date(proyecto.getFechafinproyecto().getTime()));
			sql.append("'");
		}
		if(proyecto.getProyectoPrincipal()!=null){
			sql.append(",  idproyectogrupo=");
			if(proyecto.getProyectoPrincipal().getIdproyecto()!=0){
				sql.append(proyecto.getProyectoPrincipal().getIdproyecto());
			}
			else{
				sql.append("null");
			}
			
			
		}
		/*
		if(proyecto.getNivelproyecto()!=0){
			sql.append(",  idmoneda=");
			sql.append(proyecto.getNivelproyecto());
		}
		*/
		/*
		if(proyecto.getProyectoPrincipal()!=null){
			if(proyecto.getProyectoPrincipal().getIdproyecto()!=0){
				sql.append(",  idproyectogrupo=");
				sql.append(proyecto.getProyectoPrincipal().getIdproyecto());
			}		
		}
		*/
		sql.append(" where idproyecto=");
		sql.append(proyecto.getIdproyecto());
		String cad =sql.toString();
		
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 int i=1;
			 st.executeUpdate();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	
	
	public void eliminar(Proyecto proyecto)
	{
		
		Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer(SqlConstants.eliminaProyecto);
		
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 //int i=1;
			 st.setInt(1,proyecto.getIdproyecto());
			 st.execute();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	public void eliminar(int idcodigo)
	{
		
		Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer(SqlConstants.eliminaProyecto);
		
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 //int i=1;
			 st.setInt(1,idcodigo);
			 st.execute();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	
	
	
}
