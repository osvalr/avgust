package proyecto.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Archivo;
import proyecto.vo.DetalleExpedienteSancion;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteInfraccion;
import proyecto.vo.ExpedienteSancion;

//import com.sun.corba.se.impl.orbutil.closure.Constant;

@Repository
public class ExpedienteDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate         = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate               = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int insertar(int idAnpxExpedientexAno, int correlAnpxExpedientexAno, int anoAnpxExpedientexAno, 
			            int idresolucion, int idInfractor, int idareanatural){
		String strCodIdAnpxExpedientexAno = idAnpxExpedientexAno + "-" + 
			                                correlAnpxExpedientexAno + "-" + anoAnpxExpedientexAno;  
		String sql                        = SqlConstants.insertarExpediente;		
		Map<String,Object> parametros     = new HashMap<String, Object>();
		parametros.put("idAnpxExpedientexAno",idAnpxExpedientexAno);
		parametros.put("correlAnpxExpedientexAno",correlAnpxExpedientexAno);
		parametros.put("anoAnpxExpedientexAno",anoAnpxExpedientexAno);
		parametros.put("strCodIdAnpxExpedientexAno",strCodIdAnpxExpedientexAno);
		parametros.put("idresolucion", idresolucion);
		parametros.put("idInfractor", idInfractor);
		parametros.put("idareanatural",idareanatural);		
		return this.simpleJdbcTemplate.queryForInt(sql,parametros);
	}

	// Veriosn Anterior 16-09-2012, no se utiliza, nueva version: insertar_ExpedienteInfractor
	// @SuppressWarnings("unchecked")
	public int insertar_wi(int idinfractor, int idresolucion, int idmulta,int idareanatural){
		String sql                    = SqlConstants.insertarExpedienteInfractor;		
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idinfractor",idinfractor);
		parametros.put("idresolucion", idresolucion);
		parametros.put("idmulta", idmulta);
		parametros.put("idareanatural",idareanatural);	
		return this.simpleJdbcTemplate.queryForInt(sql,parametros);
	}	
	
	// JCEV 29-10-2012 Grabación de Expediente Transaccional
	@Transactional
	public int insertarUpdateExpedienteTrx(Expediente exp, int idPersNatu){
		List<Object[]> parameters    = null;
		DetalleExpedienteSancion des = null;
		Map<String, Object> param    = null;
		String strSql                = null;
		int nIdExpInfractor[]        = null;
		int nIdExpSancion[]          = null;
		int nIdDetExpSancion[]       = null;
		int nIdInfraccion            = 0;
		int nIdSancion               = 0;
		int nIdResolucion            = 0;
		int nIdAreaNatural           = 0;
		int nIdExpediente            = 0;
		int nCurval                  = 0;
		int nFecha                   = 0;
		
		// Obtenemos el idAreaNatural
		nIdAreaNatural = exp.getIdareanatural();								
		
		// Insertamos resolucion
		strSql = SqlConstants.insertarResolucion_sf;
		param  = new HashMap<String, Object>();
		if(exp.getResolucion().getArchivo() != null){
			strSql = SqlConstants.insertarResolucion;
			param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  // 1
			param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); // 2
			param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    // 3
			param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo()); // 7
		}
		param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion());  
		param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion());  
		param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());
		param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion());
		nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
		if(nIdResolucion>0){
			// Grabamos el Expediente
			strSql = SqlConstants.insertarExpediente;		
			nFecha = this.getYear();
			param  = new HashMap<String, Object>();
			param.put("idResolucion", nIdResolucion);
			param.put("idInfractor", idPersNatu);
			param.put("idAreaNatural", nIdAreaNatural);	
			param.put("dFecha", nFecha);
			nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql,param);
			
			//System.out.println("Update idInfractor : " + idPersNatu);

			if(nIdExpediente>0){
				// Grabamos las Infracciones x Expediente
				parameters = new ArrayList<Object[]>();
				strSql     = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
						     "idinfraccion, reincidencia) VALUES(?,?,?)";
				for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
					if(ei != null){
						nIdInfraccion = ei.getInfraccion().getIdinfraccion();
			            if(nIdInfraccion > 0){
							parameters.add(new Object[] {nIdExpediente,
														 nIdInfraccion,
														 ei.getReincidencia()});
			            }
					}
				}
				if(parameters.size()>0){
					nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, parameters);
					if(nIdExpInfractor.length>0){
						
				        // Grabamos listamos las Sanciones x Expediente y su Detalle
						parameters = new ArrayList<Object[]>();
						strSql     = "INSERT INTO sernanp.expedientesancion(idexpediente, " +
				                     "idsancion, estado) VALUES(?,?,?)";		        
						for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
							if(es != null){
								nIdSancion = es.getSancion().getIdsancion();
					            if(nIdSancion > 0){
									parameters.add(new Object[] {nIdExpediente,
																 nIdSancion,
																 es.getEstado()});
					            }
							}
						}
						if(parameters.size()>0){
							nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
							if(nIdExpSancion.length>0){
								
								// Obtenemos la posicion de la secuencia de idexpedientesancion
								strSql  = "SELECT CURRVAL('sernanp.expedientesancion_idexpedientesancion_seq')";
								nCurval = this.jdbcTemplate.queryForInt(strSql);
								nCurval = nCurval - nIdExpSancion.length;

								// Creando el DetalleExpedienteSancion
								parameters = new ArrayList<Object[]>();
							    strSql     = "INSERT INTO sernanp.detalleexpedientesancion(datovariado, " +
		                                     "observacion, estado, idexpediente, idsancion, idexpedientesancion) " +
							    		     "VALUES(?,?,?,?,?,?)";
								for(ExpedienteSancion es : exp.getListaExpedienteSancion()){			
									if(es != null){
										des        = es.getDetalleExpedienteSancion();
										nIdSancion = es.getSancion().getIdsancion();
							            if(nIdSancion > 0){
											nCurval++;
							            	/*System.out.println("Dsp. : " + 
							            			des.getDatoVariado() + " --- " + 
													 des.getObservacion() + " --- " +
													 es.getEstado() + " --- " +
								                     nIdExpediente + " --- " +
													 nIdSancion + " --- " +
												     nCurval);*/
											parameters.add(new Object[] {des.getDatoVariado(),
																		 des.getObservacion(),
																		 es.getEstado(),
													                     nIdExpediente,
																		 nIdSancion,
																		 nCurval});
							            }
									}
								}
								if(parameters.size()>0){
									nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
								}
							}
						}
					}
				}
			}
		}
		return nIdDetExpSancion.length;
	}
	
	// JCEV 26-10-2012 Grabación de Expediente Transaccional
	@Transactional
	public int insertarExpedienteTrx(Expediente exp){
		List<Object[]> parameters       = null;
		DetalleExpedienteSancion des    = null;
		StringBuffer sqlb               = null; 
		Map<String, Object> param       = null;
		String strSql                   = null;
		int nIdExpInfractor[]           = null;
		int nIdExpSancion[]             = null;
		int nIdDetExpSancion[]          = null;
		int nIdInfraccion               = 0;
		int nIdInfractor                = 0;
		int nIdResolucion               = 0;
		int nIdAreaNatural              = 0;
		int nIdExpediente               = 0;
		int nCurval                     = 0;
		int nFecha                      = 0;
		int nTipo                       = 0;
		
		// Inicializa la Variable
		nIdDetExpSancion    = new int[1];
		nIdDetExpSancion[0] = 0;
		
		// Inserta Infractor Natural o Juridico
		nIdAreaNatural      = exp.getIdareanatural();								
		nTipo               = exp.getInfractor().getTipodocumento().getIdtipo();
		param               = new HashMap<String, Object>();
		param.put("numerodoc", exp.getInfractor().getNumerodocumento());		
		param.put("idtipodocumento", nTipo);
				
		if (nTipo == 4){ // Para el Caso de RUC
			sqlb = new StringBuffer(SqlConstants.insertaInfractorJuridico);
			param.put("razonsocial", exp.getInfractor().getEmpresa());
			param.put("personJurid", exp.getInfractor().getNombrepersonajuridica());
		}else{
			
			sqlb = new StringBuffer(SqlConstants.insertaInfractor);
			param.put("nombre", exp.getInfractor().getNombre());		
			param.put("apepat", exp.getInfractor().getApepat());
			param.put("apemat", exp.getInfractor().getApemat());
		}	
		// Nos devuelve el Codigo del Infractor
		strSql       = sqlb.toString();
		nIdInfractor = this.simpleJdbcTemplate.queryForInt(strSql, param);
		
		//System.out.println("idInfractor : " + nIdInfractor);

		//if(nIdInfractor > 0){
			// Inserta Resolucion
			sqlb  = new StringBuffer(SqlConstants.insertarResolucion_sf);
			param = new HashMap<String, Object>();
			if(exp.getResolucion().getArchivo() != null){
				sqlb = new StringBuffer(SqlConstants.insertarResolucion);
				param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  
				param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); 
				param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    
				param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo());
			}
			param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion()); 
			param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion());
			param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());
			param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion());			
			strSql        = sqlb.toString();
			nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
			if(nIdResolucion > 0){
				// Inserta Expediente
				sqlb   = new StringBuffer(SqlConstants.insertarExpediente);
				nFecha = this.getYear();
				param  = new HashMap<String, Object>();
				param.put("idResolucion", nIdResolucion);
				param.put("idInfractor", nIdInfractor);
				param.put("idAreaNatural", nIdAreaNatural);	
				param.put("dFecha", nFecha);
				strSql          = sqlb.toString();
				nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql, param);
				if(nIdExpediente>0){
					// Grabamos las Infracciones x Expediente
					parameters = new ArrayList<Object[]>();
					strSql     = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
							     "idinfraccion, reincidencia) VALUES(?,?,?)";
					for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
						if(ei != null){
							nIdInfraccion = ei.getInfraccion().getIdinfraccion();
							if(nIdInfraccion > 0){
								parameters.add(new Object[] {nIdExpediente,
															 nIdInfraccion,
															 ei.getReincidencia()});
							}
						}
					}
					if(parameters.size()>0){
						nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, parameters);
						if(nIdExpInfractor.length>0){
					        // Grabamos listamos las Sanciones x Expediente y su Detalle
							// Nueva Version
							parameters = new ArrayList<Object[]>();
							strSql     = "INSERT INTO sernanp.expedientesancion(idexpediente, " +
							             "idsancion, estado) VALUES(?,?,?)";
//						     "nextval('sernanp.expedientesancion_idexpedientesancion_seq')) " +
							for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
								if(es != null){
									parameters.add(new Object[] {nIdExpediente,
											 es.getSancion().getIdsancion(),
											 es.getEstado()});
								}
							}
							nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
							if(parameters.size()>0){
								if(nIdExpSancion.length>0){
//									System.out.println("Size  : " + nIdExpSancion.length);
//									System.out.println("Valor : " + nIdExpSancion[0]);
									
									// Obtenemos la posicion de la secuencia de idexpedientesancion
									strSql  = "SELECT CURRVAL('sernanp.expedientesancion_idexpedientesancion_seq')";
									nCurval = this.jdbcTemplate.queryForInt(strSql);
									
									// Creando el DetalleExpedienteSancion
									// nPos       = 0;
									parameters = new ArrayList<Object[]>();
								    strSql     = "INSERT INTO sernanp.detalleexpedientesancion(" +
								    		     "datovariado, observacion, estado, idexpediente, " + 
								    		     "idsancion, idexpedientesancion) " +
									             "VALUES(?,?,?,?,?,?)";
								    // Coloco la posicion del Inicio de la secuencia 06-11-2012
								    nCurval    = nCurval - exp.getListaExpedienteSancion().size();
									for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
										if(es != null){
											// nPos++;
											nCurval++; //  = nCurval + nPos;
											des     = es.getDetalleExpedienteSancion();
											int ids = es.getSancion().getIdsancion();
											parameters.add(new Object[] {(ids == 1) ? "S/."+des.getDatoVariado():( (ids == 3 && !des.getDatoVariado().equals("")) ? des.getDatoVariado() + " Días" : des.getDatoVariado()),
																		 des.getObservacion(),
																		 es.getEstado(),
																		 nIdExpediente,
													                     es.getSancion().getIdsancion(),
													                     nCurval});
										}
									}
									nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, 
											                                          parameters);
								}							
							}
						}					
					}					
				}
			}
		//}
		return nIdDetExpSancion.length;
	}
	
	/*
	  
	@Transactional
	public int seg_insertarExpedienteTrx(Expediente exp){
		List<Object[]> parameters       = null;
		DetalleExpedienteSancion des    = null;
		SqlParameterSource[] batch      = null;
		SqlParameterSource[] DetBatch   = null;
		StringBuffer sqlb               = null; 
		Map<String, Object> param       = null;
		String strSql                   = null;
		int nIdExpInfractor[]           = null;
		int nIdExpSancion[]             = null;
		int nIdDetExpSancion[]          = null;
		int nIdInfractor                = 0;
		int nIdResolucion               = 0;
		int nIdAreaNatural              = 0;
		int nIdExpediente               = 0;
		int nRotate                     = 0;
		int dFecha                      = 0;
		int nTipo                       = 0;
		int nSize                       = 0;
		
		// Inserta Infractor Natural o Juridico
		nIdAreaNatural = exp.getIdareanatural();								
		nTipo          = exp.getInfractor().getTipodocumento().getIdtipo();
		param          = new HashMap<String, Object>();
		param.put("numerodoc", exp.getInfractor().getNumerodocumento());		
		param.put("idtipodocumento", nTipo);
				
		if (nTipo == 4){ // Para el Caso de RUC
			sqlb = new StringBuffer(SqlConstants.insertaInfractorJuridico);
			param.put("razonsocial", exp.getInfractor().getEmpresa());
			param.put("personJurid", exp.getInfractor().getNombrepersonajuridica());
		}else{
			sqlb = new StringBuffer(SqlConstants.insertaInfractor);
			param.put("nombre", exp.getInfractor().getNombre());		
			param.put("apepat", exp.getInfractor().getApepat());
			param.put("apemat", exp.getInfractor().getApemat());
		}	
		// Nos devuelve el Codigo del Infractor
		strSql       = sqlb.toString();
		nIdInfractor = this.simpleJdbcTemplate.queryForInt(strSql, param);
		if(nIdInfractor > 0){
			// Inserta Resolucion
			sqlb  = new StringBuffer(SqlConstants.insertarResolucion_sf);
			param = new HashMap<String, Object>();
			if(exp.getResolucion().getArchivo() != null){
				sqlb = new StringBuffer(SqlConstants.insertarResolucion);
				param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  
				param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); 
				param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    
				param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo());
			}
			param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion());  
			param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion()); 
			param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());			
			param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion()); 			
			strSql        = sqlb.toString();
			nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
			if(nIdResolucion > 0){
				// Inserta Expediente
				sqlb   = new StringBuffer(SqlConstants.insertarExpediente);
				dFecha = this.getYear();
				param  = new HashMap<String, Object>();
				param.put("idResolucion", nIdResolucion);
				param.put("idInfractor", nIdInfractor);
				param.put("idAreaNatural", nIdAreaNatural);	
				param.put("dFecha", dFecha);
				strSql          = sqlb.toString();
				nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql, param);
				if(nIdExpediente>0){
//					strSql          = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
//							  		  "idinfraccion, reincidencia) VALUES(" + nIdExpediente +   
//							  		  ", :idinfraccion, :reincidencia)";		        
//					batch           = SqlParameterSourceUtils.createBatch(exp.getListaExpedienteInfraccion().toArray());						
//					nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql,batch);
					
					// Grabamos las Infracciones x Expediente
					strSql  = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
							  "idinfraccion, reincidencia) VALUES(?, ?, ?)";		        
//					strSql  = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
//							  "idinfraccion, reincidencia) VALUES(:idexpediente, " + 
//							  ":idinfraccion, :reincidencia)";		        
//			        nSize   = exp.getListaExpedienteInfraccion().size(); 
//			        batch   = new SqlParameterSource[nSize]; 
//					nRotate = 0;
					
					// Nueva Version
					parameters = new ArrayList<Object[]>();
					for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
						parameters.add(new Object[] {nIdExpediente,
													 ei.getInfraccion().getIdinfraccion(),
													 ei.getReincidencia()});
					}
					nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, parameters);
				    
				    
//					for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
//						if(ei != null){
//							param           = new HashMap<String, Object>();
//							param.put("idexpediente", nIdExpediente);
//							param.put("idinfraccion", ei.getInfraccion().getIdinfraccion());
//							param.put("reincidencia", ei.getReincidencia());		
//						    batch [nRotate] = new BeanPropertySqlParameterSource(param);
//							nRotate ++;
//						}
//					}
//					nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, batch);
					
					if(nIdExpInfractor.length>0){
				        // Grabamos listamos las Sanciones x Expediente y su Detalle
//						strSql        = "INSERT INTO sernanp.expedientesancion(idexpediente, idsancion, estado) " +
//								        "VALUES(" + nIdExpediente + ", ;idsancion, :estado)";
//						batch         = SqlParameterSourceUtils.createBatch(exp.getListaExpedienteSancion().toArray());						
//						nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql,batch);

						
						for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
							System.out.println("LstSancion : " + nIdExpediente + " -- " +
									           es.getSancion().getIdsancion() + " -- " +
									           es.getEstado());
						}
						// Nueva Version
						parameters = new ArrayList<Object[]>();
						strSql     = "INSERT INTO sernanp.expedientesancion(idexpediente, " +
						             "idsancion, estado) VALUES(?,?, ?)";
						for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
							parameters.add(new Object[] {nIdExpediente,
														 es.getSancion().getIdsancion(),
														 es.getEstado()});
						}
						nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
						
						
//						for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
//							if(es != null){
//								param           = new HashMap<String, Object>();
//								param.put("expediente", nIdExpediente);
//								param.put(";idsancion", es.getSancion().getIdsancion());
//								param.put(":estado", es.getEstado());		
//							    batch [nRotate] = new BeanPropertySqlParameterSource(param);
//								nRotate ++;
//							}
//						}
//						nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
						
						if(nIdExpSancion.length>0){
							// Creando el DetalleExpedienteSancion
							DetBatch = new SqlParameterSource[nSize]; 
						    strSql   = "INSERT INTO sernanp.detalleexpedientesancion(datovariado, " +
                                       "observacion, estado, idexpediente, idsancion, idexpedientesancion) VALUES( " +
                                       ":datovariado, :observacion, :estado, :idexpediente, :idsancion, :idexpsacion)";
							nRotate  = 0;
							for(ExpedienteSancion es : exp.getListaExpedienteSancion()){			
								des               = es.getDetalleExpedienteSancion();
								param             = new HashMap<String, Object>();
								param.put("datovariado", des.getDatoVariado());
								param.put("observacion", des.getObservacion());
								param.put("estado", es.getEstado());
								param.put("idexpediente", nIdExpediente);
								param.put("idsancion", es.getSancion().getIdsancion());
								param.put("idexpsacion", nIdExpSancion[nRotate]);
								DetBatch [nRotate] = new BeanPropertySqlParameterSource(param);
								nRotate ++;
							}
							nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, DetBatch);
						}
					}
				}
			}
		}
		return nIdDetExpSancion.length;
	}
	  
	 	
	//insert batch example
	public void insertBatch(final List<Customer> customers){
		String sql = "INSERT INTO CUSTOMER " +
			         "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
	 
		List<Object[]> parameters = new ArrayList<Object[]>();
	 
		for (Customer cust : customers) {
	        parameters.add(new Object[] {cust.getCustId(), 
	            cust.getName(), cust.getAge()}
	        );
	    }
	    getSimpleJdbcTemplate().batchUpdate(sql, parameters);        
	}	
	
	
	public int[] batchUpdate(final List<Actor> actors) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(actors.toArray());
        int[] updateCounts = simpleJdbcTemplate.batchUpdate("update t_actor set first_name = :firstName, last_name = :lastName where id = :id", batch);
        return updateCounts;
    }

	public int[] batchUpdate(String[] ArrayOfStrings) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(ArrayOfStrings);
        int[] updateCounts = sjt.batchUpdate("update t_actor set first_name = ? ", batch);
        return updateCounts;
    }	
*/	
	
	// JCEV 14-09-2012 Nueva Version
	// @SuppressWarnings("unchecked")
	public int insertar_ExpedienteInfractor(int idInfractor, int idResolucion,int idAreaNatural) throws Exception {
		String sql                    = null;		
		Map<String,Object> parametros = null;
		int dFecha                    = 0;
		int nInsert                   = -1;
		sql        = SqlConstants.insertarExpediente;		
		dFecha     = this.getYear();
		parametros = new HashMap<String, Object>();
		parametros.put("idResolucion", idResolucion);
		parametros.put("idInfractor", idInfractor);
		parametros.put("idAreaNatural", idAreaNatural);	
		parametros.put("dFecha", dFecha);
		nInsert    = this.simpleJdbcTemplate.queryForInt(sql,parametros);
		return nInsert;
	}
	
	// JCEV 16-09-2012
	private int getYear(){
		Date dFecha         = null;
		SimpleDateFormat df = null;
		try {
			dFecha = new Date();
			df     = new SimpleDateFormat("yyyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(df.format(dFecha));
	}

		
	@SuppressWarnings("unchecked")
	public List<Expediente> listar(Expediente exp){
		String sql = SqlConstants.listarExpedientes;
		if(exp.getIdareanatural()!=0){
			sql += " and exp.idareanatural= " + exp.getIdareanatural();
		}		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Expediente> listarXNumDoc(Expediente expediente){
		String sql = SqlConstants.listarExpedientes;
		sql += " and pn.numerodoc='" + expediente.getInfractor().getNumerodocumento() + "'";
		if(expediente.getIdareanatural()!=0){
			sql += " and exp.idareanatural= " + expediente.getIdareanatural();
		}		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Expediente> ObtenerXID(Expediente expediente){
		String sql = SqlConstants.listarExpedientes;
		sql += " and exp.idexpediente=" + expediente.getIdexpediente();					
		return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
	}
	
    // Metodo para la paginacion
	public int contarPaginadoXNumDoc(Expediente expediente){
		String sql = SqlConstants.contarExpediente;		
		if(expediente.getInfractor().getNumerodocumento()!=null){
			sql += " and pn.numerodoc='" + expediente.getInfractor().getNumerodocumento() + "'";
		}
		if(expediente.getIdareanatural()!=0){
			sql += " and exp.idareanatural= " + expediente.getIdareanatural();
		}
		//System.out.println("ESTE ES EL SQL :"+sql);
		return this.jdbcTemplate.queryForInt(sql);
	}
	
	public int contarPaginado(Expediente expediente){
		String strSql = null;
		try {
			strSql = SqlConstants.contarExpediente;
			if(expediente.getIdareanatural() != 0){
				strSql += " and exp.idareanatural = " + expediente.getIdareanatural();
			}
			
			// System.out.println("contarPaginado : " + strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.jdbcTemplate.queryForInt(strSql);
	}
	
	public int contarPaginadoxNDoc(Expediente expediente, String ndoc){
		String strSql = null;
		try {
			strSql = SqlConstants.contarExpedientexNDoc;
			if(expediente.getIdareanatural() != 0){
				strSql += " and exp.idareanatural = " + expediente.getIdareanatural();
			}
			
			if(!ndoc.equals("")){
				strSql += " and (pn.numerodoc LIKE '%"+ndoc+"%' or pj.ruc LIKE '%"+ndoc+"%')";
			}
			
			// System.out.println("contarPaginado : " + strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.jdbcTemplate.queryForInt(strSql);
	}

	// metodo para listar por codigo	
	@SuppressWarnings("unchecked")
	public List<Expediente> listarPaginadoSubConsultaXNumDoc(Expediente expediente,int offset,int tamPagina){
		String sql = SqlConstants.listarExpedientes;
		if(expediente.getInfractor().getNumerodocumento()!=null){
			sql += " and pn.numerodoc='" + expediente.getInfractor().getNumerodocumento()+"'";
		}
		if(expediente.getIdareanatural()!=0){
			sql += " and exp.idareanatural= " + expediente.getIdareanatural();
		}
		sql += " ORDER BY exp.idexpediente";
		sql += " LIMIT ";
		sql += tamPagina;
		sql += " OFFSET ";
		sql += offset;
		// System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Expediente> listarPaginadoSubConsulta(Expediente expediente, int offset, int tamPagina){
		String sql = null;
		try {		
			sql = SqlConstants.listarExpedientes;
									
			if(expediente.getAreanatural().getCategoriaanp().getIdcategoriaanp() != 0){
				sql += " and an.idcategoriaanp = " + expediente.getAreanatural().getCategoriaanp().getIdcategoriaanp();
			}
			
			// Agregarle el Filtro de Area Natural
			if(expediente.getIdareanatural()!=0){
				sql += " and exp.idareanatural = " + expediente.getIdareanatural();
			}
			
			// Excluye a los ANULADOS - 24-10-2012 (JCEV)
			//sql += " and exp.idusuario < 2";
			sql += " and exp.estadoexpediente = 0";
			
			sql += " ORDER BY exp.idareanatural, exp.idexpediente";			
		
			sql += " LIMIT ";
			sql += tamPagina;
			sql += " OFFSET ";
			sql += offset;
			
			//System.out.println("ExpedienteDAO : " + sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Expediente> listarPaginadoSubConsultaxNDoc(Expediente expediente, String ndoc){
		String sql = null;
		try {		
			sql = SqlConstants.listarExpedientes;
			
			// Agregarle el Filtro de Area Natural
			if(expediente.getIdareanatural()!=0){
				sql += " and exp.idareanatural = " + expediente.getIdareanatural();
			}
			
			// Excluye a los ANULADOS - 24-10-2012 (JCEV)
			sql += " and exp.idusuario < 2";
			
			if(!ndoc.equals("")){
				sql += " and (pn.numerodoc LIKE '%"+ndoc+"%' or pj.ruc LIKE '%"+ndoc+"%')";
			}
			
			sql += " ORDER BY exp.idexpediente";			
			
			//System.out.println("ExpedienteDAO : " + sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
	}
		
	@SuppressWarnings("unchecked")
	public List<Expediente> xlistarPaginadoSubConsulta(Expediente expediente, int offset, int tamPagina){
		String sql = null;
		try {		
			// JCEV, agregado 19-09-2012 16:43 pm.
			// Se debe determinar el Tipo de Documento
			sql = SqlConstants.listarExpedientesJuridicos;
			if(expediente.getIdareanatural()!=0){
				sql += " and exp.idareanatural = " + expediente.getIdareanatural();
			}
			sql += " LIMIT ";
			sql += tamPagina;
			sql += " OFFSET ";
			sql += offset;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
	}

	// JCEV 12-10-2012	
	//public int updateMorosidadXExpediente(int nIdExpediente){
	//YCB 01-02-2013
	@Transactional
	public int updateMorosidadXExpediente(Expediente exp, Archivo af){
		String strSql  = null;
		StringBuffer sqlb = null;
		int nMorosidad = 1;
		int nUpdate = 0;
		int idarchivo = 0;
		Map<String, Object> param = null;
		
		try {			
			sqlb  = new StringBuffer(SqlConstants.insertarVoucherPagoInfractor);
			param = new HashMap<String, Object>();			
			param.put("nombreinicialarchivo",  af.getNombreinicial());  
			param.put("nombregeneradoarchivo", af.getNombregenerado()); 
			param.put("mimearchivo",           af.getMimearchivo());    
			param.put("iddirectorioarchivo",   af.getDirectorioarchivo().getIddirectorioarchivo());
			
						
			strSql        = sqlb.toString();
			idarchivo = this.simpleJdbcTemplate.queryForInt(strSql, param);			
			
			strSql     = SqlConstants.actualizaIdArchivoVoucher + 
				     " SET idarchivo = " + idarchivo + 
				     " WHERE idexpediente = " + exp.getIdexpediente();
			
			this.simpleJdbcTemplate.update(strSql);
			
			/**El flamorosidad ahora se usa para verificar si se ha realizado el pago de la sanción
			 * */
			// Segundo: Actualizamos el Flag de Morosidad
			strSql     = SqlConstants.actualizaFlagMorosidad + 
					     " SET flagmorosidad = " + nMorosidad + 
					     " WHERE idexpediente = " + exp.getIdexpediente();
			// Cargar el Estado del Flag de Morosidad
			
			nUpdate    = this.jdbcTemplate.update(strSql);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nUpdate;
	}
	
	// JCEV 21-10-2012, actualizado 24-10-2012
	public int updateStatusFile(Expediente exp, int nUser){
		String strSql = null;
		int nUpdate   = 0;
		try {
			strSql = SqlConstants.actualizaFlagExpediente + " WHERE idexpediente = ?";
			//System.out.println("strSql : " + strSql);
			
			// Usando el Modelo de PrepareStatement
			nUpdate = this.jdbcTemplate.update(strSql, 
					                           new Object[]{exp.getEstadoexpediente(), 
					                                        exp.getObsestadoexpediente(), 
					                                        nUser,
					                                        exp.getIdexpediente()});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nUpdate;
	}

	public int xxupdateStatusFile(Expediente exp, int nUser){
		String strSql = null;
		int nUpdate   = 0;
		try {			
			if(exp.getEstadoexpediente() == 2){
				strSql = SqlConstants.anularExpediente;
				strSql += " WHERE idexpediente = ? ";
				System.out.println("strSql : " + strSql);
				nUpdate = this.jdbcTemplate.update(strSql, 
						                           new Object[]{exp.getIdexpediente()});
			}else{
				strSql = SqlConstants.actualizaFlagExpediente; 
				strSql += " WHERE idexpediente = ? ";
				System.out.println("strSql : " + strSql);
				nUpdate = this.jdbcTemplate.update(strSql, 
						                           new Object[]{exp.getEstadoexpediente(), 
						                                        exp.getObsestadoexpediente(), 
						                                        nUser,
						                                        exp.getIdexpediente()});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nUpdate;
	}

}


/*
@Autowired
public void init(DataSource dataSource) {
	this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	this.jdbcTemplate=new JdbcTemplate(dataSource);
	this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
}

public int insertar(int idPersNatu, int idresolucion, int idmulta,int idareanatural){
	String sql = SqlConstants.insertarExpediente;		
	Map<String,Object> parametros = new HashMap<String, Object>();
	//parametros.put("idinfractor",idinfractor);
	parametros.put("idpersonnat",idPersNatu);
	parametros.put("idresolucion", idresolucion);
	parametros.put("idmulta", idmulta);
	parametros.put("idareanatural",idareanatural);		
	return this.simpleJdbcTemplate.queryForInt(sql,parametros);
}
	
@SuppressWarnings("unchecked")
public List<Expediente> listar(Expediente exp){
	String sql = SqlConstants.listarExpedientes;
	if(exp.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+exp.getIdareanatural();
	}		
	return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
}

@SuppressWarnings("unchecked")
public List<Expediente> listarXNumDoc(Expediente expediente){
	String sql = SqlConstants.listarExpedientes;
	sql += " and pn.numerodoc='"+expediente.getInfractor().getNumerodocumento()+"'";
	if(expediente.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+expediente.getIdareanatural();
	}		
	return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
}

@SuppressWarnings("unchecked")
public List<Expediente> ObtenerXID(Expediente expediente){
	String sql = SqlConstants.listarExpedientes;
	sql += " and exp.idexpediente="+expediente.getIdexpediente();					
	return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
}

// Metodo para la paginacion
public int contarPaginadoXNumDoc(Expediente expediente){
	String sql = SqlConstants.contarExpediente;		
	if(expediente.getInfractor().getNumerodocumento()!=null){
		sql += " and pn.numerodoc='"+expediente.getInfractor().getNumerodocumento()+"'";
	}
	if(expediente.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+expediente.getIdareanatural();
	}
	//System.out.println("ESTE ES EL SQL :"+sql);
	return this.jdbcTemplate.queryForInt(sql);
}

public int contarPaginado(Expediente expediente){
	String sql = SqlConstants.contarExpediente;		
	if(expediente.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+expediente.getIdareanatural();
	}
	//System.out.println("ESTE ES EL SQL :"+sql);
	return this.jdbcTemplate.queryForInt(sql);
}

// metodo para listar por codigo	
@SuppressWarnings("unchecked")
public List<Expediente> listarPaginadoSubConsultaXNumDoc(Expediente expediente,int offset,int tamPagina){
	String sql = SqlConstants.listarExpedientes;
	if(expediente.getInfractor().getNumerodocumento()!=null){
		sql += " and pn.numerodoc='"+expediente.getInfractor().getNumerodocumento()+"'";
	}
	if(expediente.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+expediente.getIdareanatural();
	}
	sql += " LIMIT ";
	sql += tamPagina;
	sql += " OFFSET ";
	sql += offset;
	System.out.println(sql);
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
}

@SuppressWarnings("unchecked")
public List<Expediente> listarPaginadoSubConsulta(Expediente expediente,int offset,int tamPagina){
	String sql = SqlConstants.listarExpedientes;
	if(expediente.getIdareanatural()!=0){
		sql += " and exp.idareanatural= "+expediente.getIdareanatural();
	}
	sql += " LIMIT ";
	sql += tamPagina;
	sql += " OFFSET ";
	sql += offset;
	return  this.jdbcTemplate.query(sql, new RowMappersConstants.ExpedienteMapper());
}
*/


//@SuppressWarnings("unchecked")
//public int insertar_wi(int idinfractor, int idresolucion, int idmulta,int idareanatural){
//	String sql = SqlConstants.insertarExpedienteInfractor;		
//	Map<String,Object> parametros = new HashMap<String, Object>();
//	parametros.put("idinfractor",idinfractor);
//	parametros.put("idresolucion", idresolucion);
//	parametros.put("idmulta", idmulta);
//	parametros.put("idareanatural",idareanatural);	
//	return this.simpleJdbcTemplate.queryForInt(sql,parametros);
//}	



//// JCEV 26-10-2012 Grabación de Expediente Transaccional
//@Transactional
//public int TrxinsertarExpedienteTrx(Expediente exp){
//	DetalleExpedienteSancion des    = null;
//	SqlParameterSource[] batch      = null;
//	StringBuffer sqlb               = null; 
//	Map<String, Object> param       = null;
//	String strSql                   = null;
//	int nIdExpSancion[]             = null;
//	int nIdExpInfractor[]           = null;
//	int nIdDetExpSancion[]          = null;
//	int nIdInfractor                = 0;
//	int nIdResolucion               = 0;
//	int nIdAreaNatural              = 0;
//	int nIdExpediente               = 0;
//	int nRotate                     = 0;
//	int dFecha                      = 0;
//	int nTipo                       = 0;
//	int nRet                        = 0;
//	
//	// Inserta Infractor Natural o Juridico
//	nIdAreaNatural = exp.getIdareanatural();								
//	nTipo          = exp.getInfractor().getTipodocumento().getIdtipo();
//	param          = new HashMap<String, Object>();
//	param.put("numerodoc", exp.getInfractor().getNumerodocumento());		
//	param.put("idtipodocumento", nTipo);
//			
//	if (nTipo == 4){ // Para el Caso de RUC
//		sqlb = new StringBuffer(SqlConstants.insertaInfractorJuridico);
//		param.put("razonsocial", exp.getInfractor().getEmpresa());
//		param.put("personJurid", exp.getInfractor().getNombrepersonajuridica());
//	}else{
//		sqlb = new StringBuffer(SqlConstants.insertaInfractor);
//		param.put("nombre", exp.getInfractor().getNombre());		
//		param.put("apepat", exp.getInfractor().getApepat());
//		param.put("apemat", exp.getInfractor().getApemat());
//	}	
//	// Nos devuelve el Codigo del Infractor
//	strSql         = sqlb.toString();
//	nIdInfractor   = this.simpleJdbcTemplate.queryForInt(strSql, param);
//	if(nIdInfractor > 0){
//		// Inserta Resolucion
//		sqlb  = new StringBuffer(SqlConstants.insertarResolucion_sf);
//		param = new HashMap<String, Object>();
//		if(exp.getResolucion().getArchivo() != null){
//			sqlb = new StringBuffer(SqlConstants.insertarResolucion);
//			param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  
//			param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); 
//			param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    
//			param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo());
//		}
//		param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion());  
//		param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion()); 
//		param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());			
//		param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion()); 			
//		strSql        = sqlb.toString();
//		nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
//		if(nIdResolucion > 0){
//			// Inserta Expediente
//			sqlb   = new StringBuffer(SqlConstants.insertarExpediente);
//			dFecha = this.getYear();
//			param  = new HashMap<String, Object>();
//			param.put("idResolucion", nIdResolucion);
//			param.put("idInfractor", nIdInfractor);
//			param.put("idAreaNatural", nIdAreaNatural);	
//			param.put("dFecha", dFecha);
//			strSql          = sqlb.toString();
//			nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql,param);
//			if(nIdExpediente>0){
//
//				// Grabamos las Infracciones x Expediente
//		        batch           = SqlParameterSourceUtils.createBatch(exp.getListaExpedienteInfraccion().toArray());
//				strSql          = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, idinfraccion, reincidencia) " + 
//						          "VALUES( " + nIdExpediente + ", :idinfraccion, :reincidencia)";		        
//				nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, batch);
//				
//				if(nIdExpInfractor.length>0){
//			        // Grabamos las Sanciones
//			        batch         = SqlParameterSourceUtils.createBatch(exp.getListaExpedienteSancion().toArray()); 
//					strSql        = "INSERT INTO sernanp.expedientesancion(idexpedientesancion, idexpediente, idsancion, estado) " + 
//					                "VALUES(nextval('sernanp.expedientesancion_idexpedientesancion_seq'), " + nIdExpediente + ", " + 
//					                ":idsancion, :estado)";					    					
//				    nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
//					if(nIdExpSancion.length>0){
//				        // Grabamos los Detalles de Expediente Sancion
//				        batch            = SqlParameterSourceUtils.createBatch(exp.getListaExpedienteSancion().toArray()); 
//					    strSql           = "INSERT INTO sernanp.detalleexpedientesancion(iddetalleexpedientesancion, datovariado, " + 
//                                           "observacion, estado, idexpediente, idsancion, idexpedientesancion) " +
//                                           "VALUES(nextval('sernanp.detalleexpedientesancion_iddetalleexpedientesancion_seq'), " +
//                                           ":datovariado, :observacion, :estado, " + nIdExpediente + ", :idsancion, :idexpsacion)";
//						nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
//					}
//				}
//			}
//			
//		}
//	}
//	return nRet;
//}
//
//// JCEV 26-10-2012 Grabación de Expediente Transaccional
//@Transactional
//public int xinsertarExpedienteTrx(Expediente exp){
//	DetalleExpedienteSancion des = null;
//	SqlParameterSource[] batch   = null;
//	StringBuffer sqlb            = null; 
//	Map<String, Object> param    = null;
//	String strSql                = null;
//	int nIdExpSancion[]          = null;
//	int nIdExpInfractor[]        = null;
//	int nIdDetExpSancion[]       = null;
//	int nIdInfractor             = 0;
//	int nIdResolucion            = 0;
//	int nIdAreaNatural           = 0;
//	int nIdExpediente            = 0;
//	int nRotate                  = 0;
//	int dFecha                   = 0;
//	int nTipo                    = 0;
//	int nRet                     = 0;
//	
//	// Inserta Infractor Natural o Juridico
//	nIdAreaNatural = exp.getIdareanatural();								
//	nTipo          = exp.getInfractor().getTipodocumento().getIdtipo();
//	param          = new HashMap<String, Object>();
//	param.put("numerodoc", exp.getInfractor().getNumerodocumento());		
//	param.put("idtipodocumento", nTipo);
//			
//	if (nTipo == 4){ // Para el Caso de RUC
//		sqlb = new StringBuffer(SqlConstants.insertaInfractorJuridico);
//		param.put("razonsocial", exp.getInfractor().getEmpresa());
//		param.put("personJurid", exp.getInfractor().getNombrepersonajuridica());
//	}else{
//		sqlb = new StringBuffer(SqlConstants.insertaInfractor);
//		param.put("nombre", exp.getInfractor().getNombre());		
//		param.put("apepat", exp.getInfractor().getApepat());
//		param.put("apemat", exp.getInfractor().getApemat());
//	}	
//	// Nos devuelve el Codigo del Infractor
//	strSql         = sqlb.toString();
//	nIdInfractor   = this.simpleJdbcTemplate.queryForInt(strSql, param);
//	if(nIdInfractor > 0){
//		// Inserta Resolucion
//		sqlb  = new StringBuffer(SqlConstants.insertarResolucion_sf);
//		param = new HashMap<String, Object>();
//		if(exp.getResolucion().getArchivo() != null){
//			sqlb = new StringBuffer(SqlConstants.insertarResolucion);
//			param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  
//			param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); 
//			param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    
//			param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo());
//		}
//		param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion());  
//		param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion()); 
//		param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());			
//		param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion()); 			
//		strSql        = sqlb.toString();
//		nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
//		if(nIdResolucion > 0){
//			// Inserta Expediente
//			sqlb   = new StringBuffer(SqlConstants.insertarExpediente);
//			dFecha = this.getYear();
//			param  = new HashMap<String, Object>();
//			param.put("idResolucion", nIdResolucion);
//			param.put("idInfractor", nIdInfractor);
//			param.put("idAreaNatural", nIdAreaNatural);	
//			param.put("dFecha", dFecha);
//			strSql          = sqlb.toString();
//			nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql,param);
//			if(nIdExpediente>0){
//
//				// Grabamos las Infracciones x Expediente
//				sqlb    = new StringBuffer(SqlConstants.insertarExpedienteInfraccion);
//			    strSql  = sqlb.toString();
//		        batch   = new SqlParameterSource[exp.getListaExpedienteInfraccion().size()]; 
//				nRotate = 0;
//				for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
//					if(ei != null){
//						nRotate ++;
//						param           = new HashMap<String, Object>();
//						param.put("idexpediente", nIdExpediente);
//						param.put("idinfraccion", ei.getInfraccion().getIdinfraccion());
//						param.put("reincidencia", ei.getReincidencia());		
//					    batch [nRotate] = new BeanPropertySqlParameterSource(param);
//					}
//				}
//				nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, batch);
//				
//				if(nIdExpInfractor.length>0){
//			        // Grabamos las Sanciones
//					nRotate = 0;
//			        batch   = new SqlParameterSource[exp.getListaExpedienteInfraccion().size()]; 
//					sqlb    = new StringBuffer(SqlConstants.insertarExpedienteSancion);
//				    strSql  = sqlb.toString();
//					for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
//						nRotate ++;
//						param  = new HashMap<String, Object>();
//						param.put("idExpediente", nIdExpediente);
//						param.put("idSancion", es.getSancion().getIdsancion());
//						param.put("estado", es.getEstado());
//					    batch [nRotate] = new BeanPropertySqlParameterSource(param) ; 
//					}
//				    nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
//					if(nIdExpSancion.length>0){
//				        // Grabamos los Detalles de Expediente Sancion
//						sqlb   = new StringBuffer(SqlConstants.insertarDetalleExpedienteSancion);
//					    strSql = sqlb.toString();
//						for(int x=0; x<nIdExpSancion.length; x++){
//							nRotate = 0;
//							for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
//								nRotate ++;
//							    des    = es.getDetalleExpedienteSancion();
//								param  = new HashMap<String, Object>();
//								param.put("idExpediente",nIdExpediente);
//								param.put("idSancion", es.getSancion().getIdsancion());
//								param.put("estado", es.getEstado());
//								param.put("datovariado", des.getDatoVariado());
//								param.put("observacion", des.getObservacion());
//								param.put("idexpsancion", nIdExpSancion[x]);
//							    batch [nRotate] = new BeanPropertySqlParameterSource(param) ; 
//							}
//						}
//						nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
//						if(nIdDetExpSancion.length>0){
//							nRet = 1;
//						}
//					}
//				}
//			}
//			
//		}
//	}
//	return nRet;
//}


//public void xmain ( String args []){ 
//     ApplicationContext ac = new ClassPathXmlApplicationContext ( "context.xml" , Main. class ) ; 
//     DataSource dataSource = ( DataSource ) ac.getBean ( "dataSource" ) ; 
//     // DataSource mysqlDataSource = (DataSource) ac.getBean("mysqlDataSource"); 
//
//     SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate ( dataSource ) ; 
//
//     int count = 1000 ; 
//     SqlParameterSource [] source = new SqlParameterSource [ count ] ; 
//     for ( int i = 0 ; i < count; i++ ) { 
//       Customer c = new Customer () ; 
//       c.setId ( i + 100L ) ; 
//       c.setFirstName ( "FN #" + i ) ; 
//       c.setLastName ( "LN #" + i ) ; 
//       c.setLastLogin ( new Date ()) ; 
//       source [ i ] = new BeanPropertySqlParameterSource ( c ) ; 
//     } 
//     jdbcTemplate.batchUpdate ( 
//         "insert into customer (id, first_name, last_name, last_login, comments) " 
//             + "values (:id, :firstName, :lastName, :lastLogin, :comments)" , source ) ; 
//
//   }

//public void insertBatch(final List<Customer> customers){
//	String sql = "INSERT INTO CUSTOMER " +
//		"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
// 
//	List<Object[]> parameters = new ArrayList<Object[]>();
// 
//	for (Customer cust : customers) {
//        parameters.add(new Object[] {cust.getCustId(), 
//            cust.getName(), cust.getAge()}
//        );
//    }
//    getSimpleJdbcTemplate().batchUpdate(sql, parameters);        
//}	



//// JCEV 29-10-2012 Grabación de Expediente Transaccional
//@Transactional
//public int OldinsertarUpdateExpedienteTrx(Expediente exp, int idPersNatu){
//	List<Object[]> parameters       = null;
//	DetalleExpedienteSancion des    = null;
//	SqlParameterSource[] batch      = null;
//	SqlParameterSource[] DetBatch   = null;
//	Map<String, Object> param       = null;
//	String strSql                   = null;
//	int nIdExpInfractor[]           = null;
//	int nIdExpSancion[]             = null;
//	int nIdDetExpSancion[]          = null;
//	int nIdInfraccion               = 0;
//	int nIdSancion                  = 0;
//	int nIdResolucion               = 0;
//	int nIdAreaNatural              = 0;
//	int nIdExpediente               = 0;
//	int nRotate                     = 0;
//	int dFecha                      = 0;
//	int nSize                       = 0;
//	
//	// Obtenemos el idAreaNatural
//	nIdAreaNatural = exp.getIdareanatural();								
//	
//	// Insertamos resolucion
//	strSql = SqlConstants.insertarResolucion_sf;
//	param  = new HashMap<String, Object>();
//	if(exp.getResolucion().getArchivo() != null){
//		strSql = SqlConstants.insertarResolucion;
//		param.put("nombreinicialarchivo",  exp.getResolucion().getArchivo().getNombreinicial());  // 1
//		param.put("nombregeneradoarchivo", exp.getResolucion().getArchivo().getNombregenerado()); // 2
//		param.put("mimearchivo",           exp.getResolucion().getArchivo().getMimearchivo());    // 3
//		param.put("iddirectorioarchivo",   exp.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo()); // 7
//	}
//	param.put("fecharesolucion",   exp.getResolucion().getFecharesolucion());  
//	param.put("numeroresolucion",  exp.getResolucion().getNumeroresolucion());  
//	param.put("fechanotificacion", exp.getResolucion().getFechanotificacion());
//	param.put("annoresolucion",    exp.getResolucion().getAnnoresolucion());
//	nIdResolucion = this.simpleJdbcTemplate.queryForInt(strSql, param);
//
//	if(nIdResolucion>0){
//		// Grabamos el Expediente
//		strSql = SqlConstants.insertarExpediente;		
//		dFecha = this.getYear();
//		param  = new HashMap<String, Object>();
//		param.put("idResolucion", nIdResolucion);
//		param.put("idInfractor", idPersNatu);
//		param.put("idAreaNatural", nIdAreaNatural);	
//		param.put("dFecha", dFecha);
//		nIdExpediente = this.simpleJdbcTemplate.queryForInt(strSql,param);
//		if(nIdExpediente>0){
//			// Grabamos las Infracciones x Expediente
//	        nSize      = exp.getListaExpedienteInfraccion().size(); 
//	        batch      = new SqlParameterSource[nSize]; 
//			strSql     = "INSERT INTO sernanp.expedienteinfraccion(idexpediente, " +
//					     "idinfraccion, reincidencia) VALUES(?,?,?)";
//					  // "VALUES( " + nIdExpediente + 
//					  // ", :idinfraccion, :reincidencia)";		        
//			parameters = new ArrayList<Object[]>();
//			nRotate    = 0;
//			for(ExpedienteInfraccion ei : exp.getListaExpedienteInfraccion()){
//				if(ei != null){
//					nIdInfraccion = ei.getInfraccion().getIdinfraccion();
//		            if(nIdInfraccion > 0){
//						parameters.add(new Object[] {nIdExpediente,
//													 nIdInfraccion,
//													 ei.getReincidencia()});
////						param           = new HashMap<String, Object>();
////						param.put("idexpediente", nIdExpediente);
////						param.put("idinfraccion", nIdInfraccion);
////						param.put("reincidencia", ei.getReincidencia());		
////					    batch [nRotate] = new BeanPropertySqlParameterSource(param);
////						nRotate ++;
//		            }
//				}
//			}
////			nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, batch);
//			nIdExpInfractor = simpleJdbcTemplate.batchUpdate(strSql, parameters);
//			if(nIdExpInfractor.length>0){
//			
//		        // Grabamos listamos las Sanciones x Expediente y su Detalle
////		        nSize   = exp.getListaExpedienteSancion().size(); 
////		        batch   = new SqlParameterSource[nSize]; 
//				parameters = new ArrayList<Object[]>();
//				strSql     = "INSERT INTO sernanp.expedientesancion(idexpediente, " +
//		                     "idsancion, estado) VALUES(?,?,?)";		        
////                  "idsancion, estado) VALUES(:expediente, ;idsancion, :estado)";		        
////				nRotate = 0;
//				for(ExpedienteSancion es : exp.getListaExpedienteSancion()){
//
//					nIdSancion = es.getSancion().getIdsancion();
//		            if(nIdSancion > 0){
//						parameters.add(new Object[] {nIdExpediente,
//													 nIdSancion,
//													 es.getEstado()});
////						if(es != null){
////							param           = new HashMap<String, Object>();
////							param.put("expediente", nIdExpediente);
////							param.put(";idsancion", es.getSancion().getIdsancion());
////							param.put(":estado", es.getEstado());		
////						    batch [nRotate] = new BeanPropertySqlParameterSource(param);
////							nRotate ++;
////						}
//		            }
//				}
//				nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
////		nIdExpSancion = simpleJdbcTemplate.batchUpdate(strSql, batch);
//				if(nIdExpSancion.length>0){
//					// Creando el DetalleExpedienteSancion
////					DetBatch = new SqlParameterSource[nSize]; 
//					parameters = new ArrayList<Object[]>();
//				    strSql     = "INSERT INTO sernanp.detalleexpedientesancion(datovariado, " +
//                                 "observacion, estado, idexpediente, idsancion, idexpedientesancion) " +
//				    		     "VALUES(?,?,?,?,?,?)";
////				    		   VALUES( ":datovariado, :observacion, :estado, :idexpediente, :idsancion, :idexpsacion)";
//					nRotate    = 0;
//					for(ExpedienteSancion es : exp.getListaExpedienteSancion()){			
//						des        = es.getDetalleExpedienteSancion();
//						nIdSancion = es.getSancion().getIdsancion();
//			            if(nIdSancion > 0){
//							parameters.add(new Object[] {des.getDatoVariado(),
//														 des.getObservacion(),
//														 es.getEstado(),
//									                     nIdExpediente,
//														 nIdSancion,
//														 nIdExpSancion[nRotate]});
//							nRotate++;
//			            }
////						param              = new HashMap<String, Object>();
////						param.put("datovariado", des.getDatoVariado());
////						param.put("observacion", des.getObservacion());
////						param.put("estado", es.getEstado());
////						param.put("idexpediente", nIdExpediente);
////						param.put("idsancion", es.getSancion().getIdsancion());
////						param.put("idexpsacion", nIdExpSancion[nRotate]);
////						DetBatch [nRotate] = new BeanPropertySqlParameterSource(param);
////						nRotate ++;
//					}
//					nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, parameters);
////					nIdDetExpSancion = simpleJdbcTemplate.batchUpdate(strSql, DetBatch);
//				}
//			}
//		}
//	}
//	return nIdDetExpSancion.length;
//}
