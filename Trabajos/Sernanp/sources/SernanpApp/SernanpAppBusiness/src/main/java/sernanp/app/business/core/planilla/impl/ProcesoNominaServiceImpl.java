package sernanp.app.business.core.planilla.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.common.service.ConsumeRestWebService;
import sernanp.app.business.core.planilla.service.ProcesoNominaService;
import sernanp.app.business.dto.SuspensionCuartaCategoriaResponseType;
import sernanp.app.dao.domain.TAfectoConcepto;
import sernanp.app.dao.domain.TAfectoConceptoExample;
import sernanp.app.dao.domain.TAfpComision;
import sernanp.app.dao.domain.TAfpComisionExample;
import sernanp.app.dao.domain.TAnioParametroPlanilla;
import sernanp.app.dao.domain.TAnioParametroPlanillaExample;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaExample;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaKey;
import sernanp.app.dao.domain.TConceptoPlanilla;
import sernanp.app.dao.domain.TEstadoPersonal;
import sernanp.app.dao.domain.TEstadoPersonalExample;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonal;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonalExample;
import sernanp.app.dao.domain.TNominaConcepto;
import sernanp.app.dao.domain.TNominaConceptoExample;
import sernanp.app.dao.domain.TPersonalConcepto;
import sernanp.app.dao.domain.TPersonalConceptoAfecto;
import sernanp.app.dao.domain.TPersonalConceptoAfectoExample;
import sernanp.app.dao.domain.TPersonalConceptoExample;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoKey;
import sernanp.app.dao.domain.TPersonalDescuento;
import sernanp.app.dao.domain.TPersonalDescuentoExample;
import sernanp.app.dao.domain.TPersonalDescuentoTmpExample;
import sernanp.app.dao.domain.TPersonalMetaFteFto;
import sernanp.app.dao.domain.TPersonalMetaFteFtoExample;
import sernanp.app.dao.mapper.TAfectoConceptoMapper;
import sernanp.app.dao.mapper.TAfpComisionMapper;
import sernanp.app.dao.mapper.TAnioParametroPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.mapper.TConceptoPlanillaMapper;
import sernanp.app.dao.mapper.TEstadoPersonalMapper;
import sernanp.app.dao.mapper.TNominaAnioPeriodoPersonalMapper;
import sernanp.app.dao.mapper.TNominaConceptoMapper;
import sernanp.app.dao.mapper.TPersonalConceptoAfectoMapper;
import sernanp.app.dao.mapper.TPersonalConceptoMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.mapper.TPersonalDescuentoMapper;
import sernanp.app.dao.mapper.TPersonalDescuentoTmpMapper;
import sernanp.app.dao.mapper.TPersonalMetaFteFtoMapper;
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQueryCriteria;
import sernanp.app.dao.query.domain.FnGeneraDescuentoPersonalQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerRetencionPorAnhoPeriodoQuery;
import sernanp.app.dao.query.domain.ObtenerRetencionPorAnhoPeriodoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerTotalIngresosAfectoPorConceptoQuery;
import sernanp.app.dao.query.domain.ObtenerTotalIngresosAfectoPorConceptoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerTotalIngresosPorConceptoQuery;
import sernanp.app.dao.query.domain.ObtenerTotalIngresosPorConceptoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerTotalRetencionPorConceptoQuery;
import sernanp.app.dao.query.domain.ObtenerTotalRetencionPorConceptoQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerTotalSueldoPorMesCorte;
import sernanp.app.dao.query.domain.ObtenerTotalSueldoPorMesCorteCriteria;
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQueryCriteria;
import sernanp.app.dao.query.domain.PersonalContratoNominaQuery;
import sernanp.app.dao.query.domain.PersonalContratoNominaQueryCriteria;
import sernanp.app.dao.query.domain.PersonalDiasLicenciasQuery;
import sernanp.app.dao.query.domain.PersonalDiasLicenciasQueryCriteria;
import sernanp.app.dao.query.domain.PersonalNominaQuery;
import sernanp.app.dao.query.domain.PersonalNominaQueryCriteria;
import sernanp.app.dao.query.domain.PersonalPorRegimenContractualQuery;
import sernanp.app.dao.query.domain.PersonalPorRegimenContractualQueryCriteria;
import sernanp.app.dao.query.domain.SubsidiosPersonal;
import sernanp.app.dao.query.domain.SubsidiosPersonalCriteria;
import sernanp.app.dao.query.domain.SuspensionPorPersonalQuery;
import sernanp.app.dao.query.domain.SuspensionPorPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.ConceptoFrecuenciaQueryMapper;
import sernanp.app.dao.query.mapper.FnGeneraDescuentoPersonalQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerRetencionPorAnhoPeriodoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerTotalIngresosAfectoPorConceptoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerTotalIngresosPorConceptoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerTotalRetencionPorConceptoQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerTotalSueldoPorMesCorteMapper;
import sernanp.app.dao.query.mapper.PersonalConceptoFrecuenciaQueryMapper;
import sernanp.app.dao.query.mapper.PersonalContratoNominaQueryMapper;
import sernanp.app.dao.query.mapper.PersonalDiasLicenciasQueryMapper;
import sernanp.app.dao.query.mapper.PersonalNominaQueryMapper;
import sernanp.app.dao.query.mapper.PersonalPorRegimenContractualQueryMapper;
import sernanp.app.dao.query.mapper.SubsidiosPersonalMapper;
import sernanp.app.dao.query.mapper.SuspensionPorPersonalQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;



/**
 * @author JRaffo
 *
 */

@Service
public class ProcesoNominaServiceImpl extends HelperServiceMybatisImpl  implements ProcesoNominaService {

	@Autowired
	TNominaAnioPeriodoPersonalMapper tNominaAnioPeriodoPersonalMapper;
	@Autowired
	TNominaConceptoMapper tNominaConceptoMapper;
	@Autowired
	ConsumeRestWebService consumeRestWebService;
	@Autowired
	TPersonalDescuentoTmpMapper TPersonalDescuentoTmpMapper;
	
	private final int UIT = 1;
	private final int TOPE_MIN_4TA = 2;
	private final int TOPE_AFP = 3;
	private final int PORCENTAJE_ESSALUD = 4;
	private final int RMV = 5;
	private final int PORCENTAJE_SNP_ONP = 6;
	private final int PORCENTAJE_UIT = 7;
	
	private final int CONCEPTO_CUARTA_CATAGORIA = 7;
	private final int CONCEPTO_QUINTA_CATEGORIA = 8;
	private final int CONCEPTO_REGIMEN_PENSIONARIO = 74;
	private final int CONCEPTO_SEGURO_SOCIAL = 73;
	
	private final int CONCEPTO_19990 = 1;
	private final int CONCEPTO_20530 = 3;
	private final int CONCEPTO_APORTE_OBLIGATORIO = 4;
	private final int CONCEPTO_SEGURO_INVALIDEZ = 5;
	private final int CONCEPTO_COMISION_PORCENTUAL = 6;
	
	private final int CONCEPTO_OBLIGACIONES_EMPLEADOR = 52;
	
	private final int CONCEPTO_TIPO_INGRESO = 1;
	private final int CONCEPTO_TIPO_DESCUENTO = 2;
	private final int CONCEPTO_TIPO_APORTE = 3;
	
	private final int TIPO_REGIMEN_CONTRACTUAL_728 = 1;
	private final int TIPO_REGIMEN_CONTRACTUAL_CAS = 3;
	
	private final int TIPO_REGIMEN_PENSIONARIO_19990 = 2;
	private final int TIPO_REGIMEN_PENSIONARIO_20530 = 3;
	private final int TIPO_REGIMEN_PENSIONARIO_AFP = 4;
	private final int TIPO_REGIMEN_PENSIONARIO_NINGUNO = 5;
	
	private final int TIPO_ESTADO_PERSONAL_ACTIVO = 0;
	private final int TIPO_ESTADO_GENERICO_ACTIVO = 1;
	private final int TIPO_ESTADO_GENERICO_INACTIVO = 2;
	private final int TIPO_ESTADO_CONCEPTO_MODIFICADO = 3;
	
	private final int CONCEPTO_HONORARIO = 53;
	private final int CONCEPTO_REMUNERACION = 54;
	
	private final int TIPO_MONTO_PORCENTUAL = 2;
	
	private final int TIPO_DESCUENTO_INASISTENCIA = 128;
	private final int TIPO_DESCUENTO_TARDANZA = 129;
	private final int TIPO_DESCUENTO_PER_SIN_GOCE_HABER = 130;
	
	private final int CONCEPTO_TARDANZA = 41;

	private final int CONCEPTO_VACACIONES = 66;
	private final int CONCEPTO_REINTEGRO = 65;
	
	private final int NO_OBLIGA_AFECTOS = 2;
	
	private final int NO_OBLIGA_FRECUENCIAS = 2;
	
	private final int TIPO_SUBSIDIO_ENFERMEDAD = 6;
	private final int TIPO_SUBSIDIO_MATERNIDAD = 29;
	private final int TIPO_LICENCIA_SIN_GOCE_HABER = 12;
	
	private final int MES_ENERO = 1;
	private final int MES_DICIEMBRE = 12;
	
//	ADD 16-10-2015 DAVID
	private int cantDiasLicSGHAnual = 0;
//	END

	private TAnioPeriodoPlanilla tAnioPeriodoPlanilla;
	private TAnioPlanilla tAnioPlanilla;
	
	private TAnioParametroPlanilla uit;
	private TAnioParametroPlanilla tope_min_4ta;
	private TAnioParametroPlanilla tope_afp;
	private TAnioParametroPlanilla porcentaje_snp_onp;
	private TAnioParametroPlanilla porcentaje_essalud;
	private TAnioParametroPlanilla rmv;
	private TAnioParametroPlanilla porcentaje_uit;
	private List<TConceptoPlanilla> listTConceptoPlanilla;
	
	public void precargarInfo(Integer srl_id_anio_periodo_planilla){
		
		TAnioPeriodoPlanillaKey tAnioPeriodoPlanillaKey = new TAnioPeriodoPlanillaKey();
		tAnioPeriodoPlanillaKey.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
		
		tAnioPeriodoPlanilla = this.selectByPrimaryKey(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanillaKey);
		
		TAnioPlanillaKey tAnioPlanillaKey = new TAnioPlanillaKey();
		tAnioPlanillaKey.setSrl_id_anio_planilla(tAnioPeriodoPlanilla.getSrl_id_anio_planilla());
		
		tAnioPlanilla = this.selectByPrimaryKey(TAnioPlanillaMapper.class, tAnioPlanillaKey);
		
		//PARAMETROS
		uit = this.obtenerParametro(srl_id_anio_periodo_planilla, UIT);
		tope_min_4ta = this.obtenerParametro(srl_id_anio_periodo_planilla, TOPE_MIN_4TA);
		tope_afp = this.obtenerParametro(srl_id_anio_periodo_planilla, TOPE_AFP);
		porcentaje_snp_onp = this.obtenerParametro(srl_id_anio_periodo_planilla, PORCENTAJE_SNP_ONP);
		porcentaje_essalud = this.obtenerParametro(srl_id_anio_periodo_planilla, PORCENTAJE_ESSALUD);
		rmv = this.obtenerParametro(srl_id_anio_periodo_planilla, RMV);
		porcentaje_uit = this.obtenerParametro(srl_id_anio_periodo_planilla, PORCENTAJE_UIT);
		
		//Conceptos
		listTConceptoPlanilla = this.selectAll(TConceptoPlanillaMapper.class);
		
	}
	
	@Transactional
	@Override
	public void procesarNomina(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException {
		
		this.precargarInfo(srl_id_anio_periodo_planilla);
		
		if(tAnioPlanilla.getInt_id_estado() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El Año seleccionado no esta activo.");
		}
		
		if(tAnioPeriodoPlanilla.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El periodo seleccionado no esta activo.");
		}
		
		//estado final
		int_id_estado = 1;
		
		PersonalPorRegimenContractualQueryCriteria criteria = new PersonalPorRegimenContractualQueryCriteria();		
		criteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
		criteria.setIdpersonal(idpersonal);
		List<PersonalPorRegimenContractualQuery> listPersonalPorRegimenContractualQuery = this.getListByQuery(PersonalPorRegimenContractualQueryMapper.class, criteria);
		
		for(PersonalPorRegimenContractualQuery personalPorRegimenContractualQuery : listPersonalPorRegimenContractualQuery){
			
			this.procesarNominaPersonal(srl_id_anio_periodo_planilla, personalPorRegimenContractualQuery.getIdpersonal(),int_id_estado);
			this.procesarLicencias(srl_id_anio_periodo_planilla, srl_id_regimen_contractual, personalPorRegimenContractualQuery.getIdpersonal(),int_id_estado);
			
		}
		
	}
	
	/** (non-Javadoc)
	 * @see sernanp.app.business.core.planilla.service.ProcesoNominaService#procesarNominaPersonal(java.lang.Integer, java.lang.Integer)
	 */
	@Transactional
	@Override
	public void procesarNominaPersonal(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException {
		
			if(tAnioPlanilla == null){
				this.precargarInfo(srl_id_anio_periodo_planilla);
			}else{
				if(!tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla().equals(srl_id_anio_periodo_planilla)){
					this.precargarInfo(srl_id_anio_periodo_planilla);
				}
			}
			
			PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(idpersonal);
						
			PersonalContratoNominaQuery personalContratoNominaQuery = this.obtenerInfoContrato(idpersonal);
			if(personalContratoNominaQuery == null){
				throw new BusinessException("No se encuentra el contrato del personal: " + personalNominaQuery.getNombre_completo());
			}
			
			TPersonalMetaFteFto tPersonalMetaFteFto = this.obtenerMetaFteFto(srl_id_anio_periodo_planilla, personalNominaQuery.getIdpersonal());
			
			double totalIngresosAfectosSegSocial = 0;
			double totalVacacionesAfectosSegSocial = 0;
			
			if(personalNominaQuery.getInt_estado().intValue() == TIPO_ESTADO_PERSONAL_ACTIVO){
				
				if(tPersonalMetaFteFto != null){
					
					//////////// Nomina de la meta y fuente de su anterior contrato
					TEstadoPersonal tEstadoPersonalReintegro = this.obtenerEstadoPersonalReintegro(idpersonal);
								
					if(tEstadoPersonalReintegro != null){
						if(!(tEstadoPersonalReintegro.getC_fte_fto().equals(tPersonalMetaFteFto.getC_fte_fto()) && tEstadoPersonalReintegro.getC_meta().equals(tPersonalMetaFteFto.getC_meta()))){
							totalIngresosAfectosSegSocial = this.calcularNomina(srl_id_anio_periodo_planilla, idpersonal,tEstadoPersonalReintegro.getSrl_id_contrato(),tEstadoPersonalReintegro.getC_fte_fto(),tEstadoPersonalReintegro.getC_meta(),false,0,int_id_estado);
						}
					}	
					//////////
					
					//////////// Vacaciones truncas de la meta y fuente de su anterior contrato
					TEstadoPersonal tEstadoPersonal = this.obtenerEstadoPersonal(idpersonal);
					
					
					if(tEstadoPersonal != null){
						
						if(tEstadoPersonal.getC_fte_fto().equals(tPersonalMetaFteFto.getC_fte_fto()) && tEstadoPersonal.getC_meta().equals(tPersonalMetaFteFto.getC_meta())){
							
						}else{
							TPersonalContrato contratoAnterior = this.obtenerContrato(tEstadoPersonal.getSrl_id_contrato());
							if(contratoAnterior.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
								totalVacacionesAfectosSegSocial = this.calcularVacacionesTruncas(srl_id_anio_periodo_planilla, idpersonal,false, int_id_estado);
							}
						}	
					}
					//////////
					
					double totalAcumuladoIngresos = totalIngresosAfectosSegSocial + totalVacacionesAfectosSegSocial;
					
					//Nomina Ordinaria del periodo actual
					this.calcularNomina(srl_id_anio_periodo_planilla, idpersonal,personalContratoNominaQuery.getSrl_id_contrato(),tPersonalMetaFteFto.getC_fte_fto(),tPersonalMetaFteFto.getC_meta(),true,totalAcumuladoIngresos,int_id_estado);
				}

			}else{
				
				Date fechaCese = personalContratoNominaQuery.getDte_fec_cese();
				
				if(fechaCese != null){
					
					int month = this.getMonth(fechaCese);
					int year = this.getYear(fechaCese);
					
					if(month == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() && year == tAnioPlanilla.getInt_anio().intValue()){
						int diasLaborados = 0;
						Date fechaIncioMes = this.getFirstDate(month, year);
						
						diasLaborados = this.daysBetween(fechaIncioMes, fechaCese);
						
						if(diasLaborados > 0){
							this.calcularNomina(srl_id_anio_periodo_planilla, idpersonal,personalContratoNominaQuery.getSrl_id_contrato(),tPersonalMetaFteFto.getC_fte_fto(),tPersonalMetaFteFto.getC_meta(),true,0, int_id_estado);
						}
						
					}else{
						if(personalContratoNominaQuery.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
							this.calcularVacacionesTruncas(srl_id_anio_periodo_planilla, idpersonal,true,int_id_estado);	
						}
					}
					
				}else{
					if(personalContratoNominaQuery.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
						this.calcularVacacionesTruncas(srl_id_anio_periodo_planilla, idpersonal,true,int_id_estado);	
					}
				}
				
			}
	}
	
	//Nomina extraordinaria
	@Transactional
	@Override
	public void procesarNominaPersonalAlterno(Integer srl_id_anio_periodo_planilla, Integer idpersonal) throws BusinessException, IOException {
		
			if(tAnioPlanilla == null){
				this.precargarInfo(srl_id_anio_periodo_planilla);
			}else{
				if(!tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla().equals(srl_id_anio_periodo_planilla)){
					this.precargarInfo(srl_id_anio_periodo_planilla);
				}
			}
			
			PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(idpersonal);
			
			TNominaAnioPeriodoPersonalExample example = new TNominaAnioPeriodoPersonalExample();
			example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
			List<TNominaAnioPeriodoPersonal> listTNominaAnioPeriodoPersonal = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, example);
			
			for(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal : listTNominaAnioPeriodoPersonal){
				TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
				tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				tNominaConceptoMapper.deleteByExample(tNominaConceptoExample);
			}
			
			tNominaAnioPeriodoPersonalMapper.deleteByExample(example);
			
			PersonalContratoNominaQuery personalContratoNominaQuery = this.obtenerInfoContrato(idpersonal);
			if(personalContratoNominaQuery == null){
				throw new BusinessException("No se encuentra el contrato del personal: " + personalNominaQuery.getNombre_completo());
			}
			
			TPersonalMetaFteFto tPersonalMetaFteFto = this.obtenerMetaFteFto(srl_id_anio_periodo_planilla, personalNominaQuery.getIdpersonal());
			
			if(tPersonalMetaFteFto != null){
				this.calcularNominaAlterno(srl_id_anio_periodo_planilla, idpersonal,personalContratoNominaQuery.getSrl_id_contrato(),tPersonalMetaFteFto.getC_fte_fto(),tPersonalMetaFteFto.getC_meta(),true,0);
			}
			
	}
	
	
	//Nomina Ordinaria
	public double calcularNomina(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer srl_id_contrato, String c_fte_fto, String c_meta, boolean calcularAportes, double ingresosAcumulados, Integer int_id_estado) throws BusinessException, IOException{
		
		PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(idpersonal);
		
		TPersonalContrato tPersonalContrato = this.obtenerContrato(srl_id_contrato);
		
		TNominaAnioPeriodoPersonalExample example = new TNominaAnioPeriodoPersonalExample();
		example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).
		andIdpersonalEqualTo(personalNominaQuery.getIdpersonal()).
		
//		COMMENT 26-10-2015
		
		andSrl_id_contratoEqualTo(srl_id_contrato);
//		andC_fte_ftoEqualTo(c_fte_fto).
//		andC_metaEqualTo(c_meta);
		
		List<TNominaAnioPeriodoPersonal> listTNominaAnioPeriodoPersonal = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, example);
		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = this.getRecord(listTNominaAnioPeriodoPersonal);
		List<TNominaConcepto> listTNominaConcepto = null;
		
		//si no existe la nomina la creamos
		if(tNominaAnioPeriodoPersonal == null){
			
			tNominaAnioPeriodoPersonal = new TNominaAnioPeriodoPersonal();
			tNominaAnioPeriodoPersonal.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
			tNominaAnioPeriodoPersonal.setIdpersonal(personalNominaQuery.getIdpersonal());
			tNominaAnioPeriodoPersonal.setSrl_id_contrato(tPersonalContrato.getSrl_id_contrato());
			tNominaAnioPeriodoPersonal.setSrl_id_regimen_contractual(tPersonalContrato.getSrl_id_regimen_contractual());
			tNominaAnioPeriodoPersonal.setC_fte_fto(c_fte_fto);
			tNominaAnioPeriodoPersonal.setC_meta(c_meta);
			tNominaAnioPeriodoPersonal.setInt_id_estado(int_id_estado);
			tNominaAnioPeriodoPersonal.setTsp_fecha_registro(new Date());
			
			tNominaAnioPeriodoPersonal.setSrl_id_regimen_pensionario(personalNominaQuery.getSrl_id_regimen_pensionario());
			tNominaAnioPeriodoPersonal.setVar_ubicacion_fisica(tPersonalContrato.getVar_ubicacion_fisica());
			tNominaAnioPeriodoPersonal.setSrl_id_afp(personalNominaQuery.getSrl_id_afp());
			tNominaAnioPeriodoPersonal.setInt_id_tipo_comision(personalNominaQuery.getInt_id_tipo_comision());
			tNominaAnioPeriodoPersonal.setSrl_id_entidad_bancaria(personalNominaQuery.getSrl_id_entidad_bancaria());
			tNominaAnioPeriodoPersonal.setVar_numero_cuenta_bancaria(personalNominaQuery.getVar_numero_cuenta_bancaria());
			
			this.insertSelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
			
			//instanciamos una lista de conceptos
			listTNominaConcepto = new ArrayList<TNominaConcepto>();
		}else{
			
			//ADD 28-09-2015 DAVID
			if (tNominaAnioPeriodoPersonal.getInt_id_estado() != 2){
				
				tNominaAnioPeriodoPersonal.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
				tNominaAnioPeriodoPersonal.setIdpersonal(personalNominaQuery.getIdpersonal());
				tNominaAnioPeriodoPersonal.setSrl_id_contrato(tPersonalContrato.getSrl_id_contrato());
				tNominaAnioPeriodoPersonal.setSrl_id_regimen_contractual(tPersonalContrato.getSrl_id_regimen_contractual());
				
//				COMMENT 26-10-2015
//				tNominaAnioPeriodoPersonal.setC_fte_fto(c_fte_fto);
//				tNominaAnioPeriodoPersonal.setC_meta(c_meta);
				
				tNominaAnioPeriodoPersonal.setInt_id_estado(int_id_estado);
				tNominaAnioPeriodoPersonal.setTsp_fecha_registro(new Date());
				
				tNominaAnioPeriodoPersonal.setSrl_id_regimen_pensionario(personalNominaQuery.getSrl_id_regimen_pensionario());
				tNominaAnioPeriodoPersonal.setVar_ubicacion_fisica(tPersonalContrato.getVar_ubicacion_fisica());
				tNominaAnioPeriodoPersonal.setSrl_id_afp(personalNominaQuery.getSrl_id_afp());
				tNominaAnioPeriodoPersonal.setInt_id_tipo_comision(personalNominaQuery.getInt_id_tipo_comision());
				tNominaAnioPeriodoPersonal.setSrl_id_entidad_bancaria(personalNominaQuery.getSrl_id_entidad_bancaria());
				tNominaAnioPeriodoPersonal.setVar_numero_cuenta_bancaria(personalNominaQuery.getVar_numero_cuenta_bancaria());	
			}
			//END DAVID			
		}
				
		//Si la nomina existe 
		//Eliminar los conceptos
		if(listTNominaConcepto == null){
			
			//Seleccionar los conceptos en estado modificado.
			TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
			tNominaConceptoExample.createCriteria().
			andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal()).andInt_id_estadoEqualTo(TIPO_ESTADO_CONCEPTO_MODIFICADO);
			listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
			
			//eliminar los conceptos
			tNominaConceptoExample = new TNominaConceptoExample();
			tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			tNominaConceptoMapper.deleteByExample(tNominaConceptoExample);
			
		}

		TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
		tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
		
		List<TPersonalConcepto> listTPersonalConcepto = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
		
//		ADD 16-10-2015 DAVID
//		cantDiasLicSGHAnual		= this.calcularDiasLicenciaAnualSinGoceHaber(idpersonal, );
//		END
		
		
		//Ingresos
		this.calcularIngresos(srl_id_anio_periodo_planilla, tNominaAnioPeriodoPersonal, listTNominaConcepto, listTPersonalConcepto, tPersonalContrato, personalNominaQuery, true);
					
		double totalIngresos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_INGRESO);
		
		if(totalIngresos > 0){
			
//			ADD 15-10-2015 DAVID
			//Insertar los conceptos de tipo ingreso, temporalmente para obtener los ingresos afectos para la 4ta
			
			List<TNominaConcepto> nominaConceptoTemp = new ArrayList<TNominaConcepto>();
			
			for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
				if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
					Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == CONCEPTO_TIPO_INGRESO){
						nominaConceptoTemp.add(tNominaConcepto);
					}
				}
			}
			
			this.insertSelective(TNominaConceptoMapper.class, nominaConceptoTemp);
			
//		END
			
			//Descuentos
			this.calcularDescuentos(srl_id_anio_periodo_planilla,listTPersonalConcepto,tNominaAnioPeriodoPersonal,listTNominaConcepto,tPersonalContrato,personalNominaQuery, int_id_estado);
			
			//Aporte
			if(calcularAportes){
				this.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,ingresosAcumulados,false);
			}
		}

//		ADD 15-10-2015 DAVID

		//eliminar los conceptos Temps
		TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
		tNominaConceptoExample = new TNominaConceptoExample();
		tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
		tNominaConceptoMapper.deleteByExample(tNominaConceptoExample);

//		END
		
		this.insertSelective(TNominaConceptoMapper.class, listTNominaConcepto);
		
		
		double totalDescuentos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_DESCUENTO);		
		double totalAportes = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_APORTE);
		double totalNeto = totalIngresos-totalDescuentos;
		
		tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
		tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
		tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
		tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalNeto));
		
		this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
		
		double totalIngresosAfectoSegSocial = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_SEGURO_SOCIAL);
		
		return totalIngresosAfectoSegSocial;
	}
	
	
	public double calcularNominaAlterno(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer srl_id_contrato, String c_fte_fto, String c_meta, boolean calcularAportes, double ingresosAcumulados) throws BusinessException, IOException{
		
		PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(idpersonal);
		
		TPersonalContrato tPersonalContrato = this.obtenerContrato(srl_id_contrato);
		
		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = new TNominaAnioPeriodoPersonal();
		tNominaAnioPeriodoPersonal.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
		tNominaAnioPeriodoPersonal.setIdpersonal(personalNominaQuery.getIdpersonal());
		tNominaAnioPeriodoPersonal.setSrl_id_contrato(tPersonalContrato.getSrl_id_contrato());
		tNominaAnioPeriodoPersonal.setSrl_id_regimen_contractual(tPersonalContrato.getSrl_id_regimen_contractual());
		tNominaAnioPeriodoPersonal.setC_fte_fto(c_fte_fto);
		tNominaAnioPeriodoPersonal.setC_meta(c_meta);
		tNominaAnioPeriodoPersonal.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
		tNominaAnioPeriodoPersonal.setTsp_fecha_registro(new Date());
		tNominaAnioPeriodoPersonal.setSrl_id_regimen_pensionario(personalNominaQuery.getSrl_id_regimen_pensionario());
		tNominaAnioPeriodoPersonal.setVar_ubicacion_fisica(tPersonalContrato.getVar_ubicacion_fisica());
		tNominaAnioPeriodoPersonal.setSrl_id_afp(personalNominaQuery.getSrl_id_afp());
		tNominaAnioPeriodoPersonal.setInt_id_tipo_comision(personalNominaQuery.getInt_id_tipo_comision());
		tNominaAnioPeriodoPersonal.setSrl_id_entidad_bancaria(personalNominaQuery.getSrl_id_entidad_bancaria());
		tNominaAnioPeriodoPersonal.setVar_numero_cuenta_bancaria(personalNominaQuery.getVar_numero_cuenta_bancaria());
		
		this.insertSelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);

		TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
		tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
		
		List<TPersonalConcepto> listTPersonalConcepto = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
		
		List<TNominaConcepto> listTNominaConcepto = new ArrayList<TNominaConcepto>();
											

		this.calcularIngresos(srl_id_anio_periodo_planilla, tNominaAnioPeriodoPersonal, listTNominaConcepto, listTPersonalConcepto, tPersonalContrato, personalNominaQuery, false);
			
		double totalIngresos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_INGRESO);
		
		if(totalIngresos > 0){
			// Descuentos
			this.calcularDescuentos(srl_id_anio_periodo_planilla,listTPersonalConcepto,tNominaAnioPeriodoPersonal,listTNominaConcepto,tPersonalContrato,personalNominaQuery,1);
			
			//Aporte
			if(calcularAportes){
				this.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,ingresosAcumulados,false);
			}
		}
			
		this.insertSelective(TNominaConceptoMapper.class, listTNominaConcepto);
		
		
		double totalDescuentos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_DESCUENTO);
		double totalAportes = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_APORTE);
		double totalNeto = totalIngresos-totalDescuentos;
		
		tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
		tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
		tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
		tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalNeto));
		
		this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);

		double totalIngresosAfectoSegSocial = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_SEGURO_SOCIAL);
		
		return totalIngresosAfectoSegSocial;
	}
	
	public TEstadoPersonal obtenerEstadoPersonal(Integer idpersonal){
		
		TEstadoPersonalExample tEstadoPersonalExample = new TEstadoPersonalExample();
		tEstadoPersonalExample.createCriteria().
		andIdpersonalEqualTo(idpersonal).
		andInt_anioEqualTo(tAnioPlanilla.getInt_anio()).
		andInt_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes());//.andInt_id_estadoEqualTo(1);
		
		List<TEstadoPersonal> listTEstadoPersonal = this.selectByExample(TEstadoPersonalMapper.class, tEstadoPersonalExample);
		TEstadoPersonal tEstadoPersonal = null;
		if(!listTEstadoPersonal.isEmpty()){
			tEstadoPersonal = listTEstadoPersonal.get(0);
		}
		
		return tEstadoPersonal;
	}
	
	public TEstadoPersonal obtenerEstadoPersonalReintegro(Integer idpersonal){
		
		TEstadoPersonalExample tEstadoPersonalExample = new TEstadoPersonalExample();
		tEstadoPersonalExample.createCriteria().
		andIdpersonalEqualTo(idpersonal).
		andInt_id_estadoEqualTo(1).
		andInt_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()+1).
		andInt_anioEqualTo(tAnioPlanilla.getInt_anio().intValue());
		
		tEstadoPersonalExample.setOrderByClause("dte_fecha_estado desc");
		
		List<TEstadoPersonal> listTEstadoPersonal = this.selectByExample(TEstadoPersonalMapper.class, tEstadoPersonalExample);
		TEstadoPersonal tEstadoPersonal = null;
		if(!listTEstadoPersonal.isEmpty()){
			tEstadoPersonal = listTEstadoPersonal.get(0);
		}
		
		return tEstadoPersonal;
	}
	
	/**
	 * @param idpersonal
	 * @return
	 */
	public PersonalNominaQuery obtenerInfoPersonal(Integer idpersonal){
		PersonalNominaQueryCriteria personalNominaQueryCriteria = new PersonalNominaQueryCriteria();
		personalNominaQueryCriteria.setIdpersonal(idpersonal);
		return this.getRecordByQuery(PersonalNominaQueryMapper.class, personalNominaQueryCriteria);
	}
	
	/**
	 * @param idpersonal
	 * @return
	 */
	public PersonalContratoNominaQuery obtenerInfoContrato(Integer idpersonal){
		PersonalContratoNominaQueryCriteria criteria = new PersonalContratoNominaQueryCriteria();
		criteria.setIdpersonal(idpersonal);
		return this.getRecordByQuery(PersonalContratoNominaQueryMapper.class, criteria);
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param srl_id_parametro_planilla
	 * @return
	 */
	public TAnioParametroPlanilla obtenerParametro(Integer srl_id_anio_periodo_planilla, Integer srl_id_parametro_planilla){
		
		TAnioParametroPlanillaExample tAnioParametroPlanillaExample = new TAnioParametroPlanillaExample();
		tAnioParametroPlanillaExample.createCriteria().
		andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla()).
		andSrl_id_parametro_planillaEqualTo(srl_id_parametro_planilla).
		andInt_id_estadoEqualTo(TIPO_ESTADO_GENERICO_ACTIVO);
		
		List<TAnioParametroPlanilla> listTAnioParametroPlanilla = this.selectByExample(TAnioParametroPlanillaMapper.class, tAnioParametroPlanillaExample);
		
		if(!listTAnioParametroPlanilla.isEmpty()){
			return listTAnioParametroPlanilla.get(0);
		}
		
		return null;
		
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param idpesonal
	 * @return
	 */
	public TPersonalMetaFteFto obtenerMetaFteFto(Integer srl_id_anio_periodo_planilla, Integer idpesonal){
				
		TPersonalMetaFteFtoExample example = new TPersonalMetaFteFtoExample();
		example.createCriteria().andSrl_id_anio_planillaEqualTo(tAnioPeriodoPlanilla.getSrl_id_anio_planilla()).andIdpersonalEqualTo(idpesonal);
		
		List<TPersonalMetaFteFto> list = this.selectByExample(TPersonalMetaFteFtoMapper.class, example);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
		
	}
	
	public TPersonalMetaFteFto obtenerMetaFteFtoAlterno(Integer srl_id_anio_planilla, Integer idpesonal){
		
		TPersonalMetaFteFtoExample example = new TPersonalMetaFteFtoExample();
		example.createCriteria().andSrl_id_anio_planillaEqualTo(srl_id_anio_planilla).andIdpersonalEqualTo(idpesonal);
		
		List<TPersonalMetaFteFto> list = this.selectByExample(TPersonalMetaFteFtoMapper.class, example);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
		
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param srl_id_concepto_planilla
	 * @param tPersonalConcepto
	 * @return
	 */
	public boolean aplicaPeriodo(Integer srl_id_anio_periodo_planilla, Integer srl_id_concepto_planilla, TPersonalConcepto tPersonalConcepto){
		
		if(tPersonalConcepto.getSrl_id_anio_planilla() == null){
			tPersonalConcepto.setSrl_id_anio_planilla(tAnioPeriodoPlanilla.getSrl_id_anio_planilla());
		}
		
		if(tPersonalConcepto.getInt_aplica_frecuencias() == null){
			tPersonalConcepto.setInt_aplica_frecuencias(NO_OBLIGA_FRECUENCIAS);
		}
		
		if(tAnioPeriodoPlanilla.getSrl_id_anio_planilla().equals(tPersonalConcepto.getSrl_id_anio_planilla())){
			
			if(tPersonalConcepto.getInt_aplica_frecuencias().intValue() == NO_OBLIGA_FRECUENCIAS){
				
				PersonalConceptoFrecuenciaQueryCriteria personalConceptoFrecuenciaQueryCriteria = new PersonalConceptoFrecuenciaQueryCriteria();
				personalConceptoFrecuenciaQueryCriteria.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
				personalConceptoFrecuenciaQueryCriteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
				
				List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = this.getListByQuery(PersonalConceptoFrecuenciaQueryMapper.class, personalConceptoFrecuenciaQueryCriteria);
				
				ConceptoFrecuenciaQueryCriteria conceptoFrecuenciaQueryCriteria = new ConceptoFrecuenciaQueryCriteria();
				conceptoFrecuenciaQueryCriteria.setSrl_id_concepto_planilla(srl_id_concepto_planilla);
				conceptoFrecuenciaQueryCriteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
				
				List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = this.getListByQuery(ConceptoFrecuenciaQueryMapper.class, conceptoFrecuenciaQueryCriteria);
				
				if(!listPersonalConceptoFrecuenciaQuery.isEmpty()){
					for(PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery){
						if(personalConceptoFrecuenciaQuery.getInt_id_mes().intValue() == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
							return true;
						}
					}
				}else if(listConceptoFrecuenciaQuery.isEmpty()){
					return true;
				}else{
					for(ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery){
						if(conceptoFrecuenciaQuery.getInt_id_mes().intValue() == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
							return true;
						}
					}
				}
			}else{
				
				PersonalConceptoFrecuenciaQueryCriteria personalConceptoFrecuenciaQueryCriteria = new PersonalConceptoFrecuenciaQueryCriteria();
				personalConceptoFrecuenciaQueryCriteria.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
				personalConceptoFrecuenciaQueryCriteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
				
				List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = this.getListByQuery(PersonalConceptoFrecuenciaQueryMapper.class, personalConceptoFrecuenciaQueryCriteria);
				
				if(!listPersonalConceptoFrecuenciaQuery.isEmpty()){
					for(PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery){
						if(personalConceptoFrecuenciaQuery.getInt_id_mes().intValue() == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
							return true;
						}
					}
				}else{
					return true;
				}
				
			}
			
		}
		
		return false;
	}
	
	/**
	 * @param listTPersonalConcepto
	 * @param personalContratoNominaQuery
	 * @return
	 */
	public double obtenerIngresosProyectadoPorConcepto(List<TPersonalConcepto> listTPersonalConcepto, TPersonalContrato tPersonalContrato){
		
		double totalPoyectadoConcepto = 0.0;
		
		for(TPersonalConcepto tPersonalConcepto : listTPersonalConcepto){
			
			if(tPersonalConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO){
				
				Integer tipoConcepto = this.obtenerTipoConcepto(tPersonalConcepto.getSrl_id_concepto_planilla());
				
				if(tipoConcepto.intValue() == CONCEPTO_TIPO_INGRESO){
					
					if(tPersonalConcepto.getSrl_id_concepto_planilla() != CONCEPTO_REMUNERACION && tPersonalConcepto.getSrl_id_concepto_planilla() != CONCEPTO_HONORARIO){
						
						PersonalConceptoFrecuenciaQueryCriteria personalConceptoFrecuenciaQueryCriteria = new PersonalConceptoFrecuenciaQueryCriteria();
						personalConceptoFrecuenciaQueryCriteria.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
						personalConceptoFrecuenciaQueryCriteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
						
						List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = this.getListByQuery(PersonalConceptoFrecuenciaQueryMapper.class, personalConceptoFrecuenciaQueryCriteria);
						
						ConceptoFrecuenciaQueryCriteria conceptoFrecuenciaQueryCriteria = new ConceptoFrecuenciaQueryCriteria();
						conceptoFrecuenciaQueryCriteria.setSrl_id_concepto_planilla(tPersonalConcepto.getSrl_id_concepto_planilla());
						conceptoFrecuenciaQueryCriteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
						
						List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = this.getListByQuery(ConceptoFrecuenciaQueryMapper.class, conceptoFrecuenciaQueryCriteria);
						
						double monto = 0;
						
						if(tPersonalConcepto.getInt_id_tipo_monto_concepto().intValue() == TIPO_MONTO_PORCENTUAL){
							monto = tPersonalContrato.getNum_sueldo().doubleValue() * tPersonalConcepto.getDec_monto_concepto().doubleValue();
						}else{
							monto = tPersonalConcepto.getDec_monto_concepto().doubleValue();
						}
						
						for(int i=1;i<13;i++){
							if(!listPersonalConceptoFrecuenciaQuery.isEmpty()){
								for(PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery){
									if(personalConceptoFrecuenciaQuery.getInt_id_mes().intValue() == i){
										totalPoyectadoConcepto = totalPoyectadoConcepto + monto;
									}
								}
							}else if(listConceptoFrecuenciaQuery.isEmpty()){
								totalPoyectadoConcepto = totalPoyectadoConcepto + monto;
							}else{
								for(ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery){
									if(conceptoFrecuenciaQuery.getInt_id_mes().intValue() == i){
										totalPoyectadoConcepto = totalPoyectadoConcepto + monto;
									}
								}
							}
						}
						
					}
				}
			}
			
		}
		
		return totalPoyectadoConcepto;
	}
	
	public double obtenerIngresosAfectoPorConcepto(Integer srl_id_anio_planilla, Integer idpersonal, Integer srl_id_concepto_planilla_afecto){
		
		ObtenerTotalIngresosAfectoPorConceptoQueryCriteria criteria = new ObtenerTotalIngresosAfectoPorConceptoQueryCriteria();
		criteria.setSrl_id_anio_planilla(srl_id_anio_planilla);
		criteria.setIdpersonal(idpersonal);
		criteria.setSrl_id_concepto_planilla_afecto(srl_id_concepto_planilla_afecto);
		
		List<ObtenerTotalIngresosAfectoPorConceptoQuery> list = this.getListByQuery(ObtenerTotalIngresosAfectoPorConceptoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			
			return list.get(0).getTotal_ingresos();
			
		}
		
		return 0;
	}
	
	/**
	 * @param listTNominaConcepto
	 * @param int_id_tipo_concepto
	 * @param srl_id_concepto_planilla
	 * @return
	 */
	public Double obtenerTotalPorAfectos(List<TNominaConcepto> listTNominaConcepto, Integer int_id_tipo_concepto, Integer srl_id_concepto_planilla){
		
		double total = 0.0;
		TAfectoConceptoExample tAfectoConceptoExample = new TAfectoConceptoExample();
		tAfectoConceptoExample.createCriteria().
		andSrl_id_concepto_planillaEqualTo(srl_id_concepto_planilla).
		andInt_id_estadoEqualTo(TIPO_ESTADO_GENERICO_ACTIVO);
//		System.out.println("Concepto --> " + srl_id_concepto_planilla);
		List<TAfectoConcepto> listTAfectoConcepto = this.selectByExample(TAfectoConceptoMapper.class, tAfectoConceptoExample);
		
		if(!listTAfectoConcepto.isEmpty()){
			for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
				if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
					for(TAfectoConcepto tAfectoConcepto : listTAfectoConcepto){
						if(tAfectoConcepto.getSrl_id_concepto_planilla_afecto().intValue() == tNominaConcepto.getSrl_id_concepto_planilla().intValue()){							
							Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
							if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
								total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
							}
							break;
						}
					}
				}
			}
		}else{
			for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
				if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
					Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
						total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
					}
				}
			}
		}
		
		return total;
	}
	
	/**
	 * @param listTNominaConcepto
	 * @param int_id_tipo_concepto
	 * @param tPersonalConcepto
	 * @return
	 */
	public Double obtenerMontoPorAfectos(List<TNominaConcepto> listTNominaConcepto, Integer int_id_tipo_concepto, TPersonalConcepto tPersonalConcepto){
		
		double total = 0.0;
		
		for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
			if(tNominaConcepto.getSrl_id_concepto_planilla().intValue() == CONCEPTO_HONORARIO){
				total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
				break;
			}
			if(tNominaConcepto.getSrl_id_concepto_planilla().intValue() == CONCEPTO_REMUNERACION){
				total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
				break;
			}
		}
		
		if(tPersonalConcepto.getInt_aplica_afectos() == null){
			tPersonalConcepto.setInt_aplica_afectos(2);
		}
		
		if(tPersonalConcepto.getInt_aplica_afectos().intValue() == NO_OBLIGA_AFECTOS){
			
			TPersonalConceptoAfectoExample tPerConceptoAfectoExample = new TPersonalConceptoAfectoExample();
			tPerConceptoAfectoExample.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto()).andInt_id_estadoEqualTo(TIPO_ESTADO_GENERICO_ACTIVO);
			
			List<TPersonalConceptoAfecto> listTPersonalConceptoAfectos = this.selectByExample(TPersonalConceptoAfectoMapper.class, tPerConceptoAfectoExample);
			
			if(listTPersonalConceptoAfectos.isEmpty()){
				
				TAfectoConceptoExample tAfectoConceptoExample = new TAfectoConceptoExample();
				tAfectoConceptoExample.createCriteria().
				andSrl_id_concepto_planillaEqualTo(tPersonalConcepto.getSrl_id_concepto_planilla()).
				andInt_id_estadoEqualTo(TIPO_ESTADO_GENERICO_ACTIVO);
				
				List<TAfectoConcepto> listTAfectoConcepto = this.selectByExample(TAfectoConceptoMapper.class, tAfectoConceptoExample);
				
				if(!listTAfectoConcepto.isEmpty()){
					for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
						if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
							for(TAfectoConcepto tAfectoConcepto : listTAfectoConcepto){
								if(tAfectoConcepto.getSrl_id_concepto_planilla_afecto().intValue() == tNominaConcepto.getSrl_id_concepto_planilla().intValue()){
									Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
									if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
										total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
									}
									break;
								}
							}
						}
					}
				}else{
					for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
						if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
							Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
							if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
								total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
							}
						}
					}
				}
				
			}else{
				for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
					if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
						for(TPersonalConceptoAfecto tPersonalConceptoAfecto : listTPersonalConceptoAfectos){
							if(tPersonalConceptoAfecto.getSrl_id_concepto_planilla().intValue() == tNominaConcepto.getSrl_id_concepto_planilla().intValue()){
								Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
								if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
									total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
								}
								break;
							}
						}
					}
				}
			}
			
		}else{
			
			TPersonalConceptoAfectoExample tPerConceptoAfectoExample = new TPersonalConceptoAfectoExample();
			tPerConceptoAfectoExample.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto()).andInt_id_estadoEqualTo(TIPO_ESTADO_GENERICO_ACTIVO);
			
			List<TPersonalConceptoAfecto> listTPersonalConceptoAfectos = this.selectByExample(TPersonalConceptoAfectoMapper.class, tPerConceptoAfectoExample);
			
			if(!listTPersonalConceptoAfectos.isEmpty()){
				
				for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
					if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
						for(TPersonalConceptoAfecto tPersonalConceptoAfecto : listTPersonalConceptoAfectos){
							if(tPersonalConceptoAfecto.getSrl_id_concepto_planilla().intValue() == tNominaConcepto.getSrl_id_concepto_planilla().intValue()){
								Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
								if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
									total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
								}
								break;
							}
						}
					}
				}
				
			}
			
		}
		
		return total;
	}
	
	/**
	 * @param listTNominaConcepto
	 * @param int_id_tipo_concepto
	 * @return
	 */
	public Double obtenerTotalPorTipoConcepto(List<TNominaConcepto> listTNominaConcepto, Integer int_id_tipo_concepto){
		
		double total = 0.0;
		
			for(TNominaConcepto tNominaConcepto : listTNominaConcepto){
				if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
					Integer tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == int_id_tipo_concepto.intValue()){
						total = total + tNominaConcepto.getDec_monto_calculado().doubleValue();
					}
				}
			}
		
		return total;
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @return
	 */
	public int obtenerMesActual(Integer srl_id_anio_periodo_planilla){
		
		return tAnioPeriodoPlanilla.getInt_id_periodo_mes();
		
	}
	
	public double obtenerTotalSueldoPorMesCorte(Integer int_anio, Integer int_id_periodo_mes, Integer idpersonal, Integer srl_id_concepto_planilla){
		
		ObtenerTotalSueldoPorMesCorteCriteria criteria = new ObtenerTotalSueldoPorMesCorteCriteria();
		criteria.setIdpersonal(idpersonal);
		criteria.setInt_anio(int_anio);
		criteria.setInt_id_periodo_mes(int_id_periodo_mes);
		criteria.setSrl_id_concepto_planilla(srl_id_concepto_planilla);
		
		ObtenerTotalSueldoPorMesCorte obj = this.getRecordByQuery(ObtenerTotalSueldoPorMesCorteMapper.class, criteria);
		
		if(obj == null){
			return 0;
		}
		
		return obj.getTotalsueldo().doubleValue();
		
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param idpersonal
	 * @param srl_id_concepto_planilla
	 * @return
	 */
	public double obtenerTotalIngresosPorConceptoPorEjercicio(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer srl_id_concepto_planilla){
		
		ObtenerTotalIngresosPorConceptoQueryCriteria criteria = new ObtenerTotalIngresosPorConceptoQueryCriteria();
		criteria.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
		criteria.setIdpersonal(idpersonal);
		criteria.setSrl_id_concepto_planilla(srl_id_concepto_planilla);
		criteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
		
		ObtenerTotalIngresosPorConceptoQuery obj = this.getRecordByQuery(ObtenerTotalIngresosPorConceptoQueryMapper.class, criteria);
		
		return obj.getTotal_ingreso();
		
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param idpersonal
	 * @param srl_id_concepto_planilla
	 * @return
	 */
	public double obtenerTotalRetencionPorConceptoPorEjercicio(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer srl_id_concepto_planilla){
		
		ObtenerTotalRetencionPorConceptoQueryCriteria criteria = new ObtenerTotalRetencionPorConceptoQueryCriteria();
		criteria.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
		criteria.setIdpersonal(idpersonal);
		criteria.setSrl_id_concepto_planilla(srl_id_concepto_planilla);
		criteria.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
		
		ObtenerTotalRetencionPorConceptoQuery obj = this.getRecordByQuery(ObtenerTotalRetencionPorConceptoQueryMapper.class, criteria);
		
		return obj.getTotal_retencion();
		
	}
	
	/* (non-Javadoc)
	 * @see sernanp.app.business.core.planilla.service.ProcesoNominaService#obtenerTipoConcepto(java.lang.Integer)
	 */
	public Integer obtenerTipoConcepto(Integer srl_id_concepto_planilla){

		if(listTConceptoPlanilla == null){
			listTConceptoPlanilla = this.selectAll(TConceptoPlanillaMapper.class);
		}
		
		TConceptoPlanilla tConceptoPlanilla = null;
		
		for (TConceptoPlanilla x : listTConceptoPlanilla) {
			if(x.getSrl_id_concepto_planilla().equals(srl_id_concepto_planilla)){
				tConceptoPlanilla = x;
				break;
			}
		}
		return tConceptoPlanilla.getInt_id_tipo_concepto();
		
	}
	
	/* (non-Javadoc)
	 * @see sernanp.app.business.core.planilla.service.ProcesoNominaService#obtenerConcepto(java.lang.Integer)
	 */
	public TConceptoPlanilla obtenerConcepto(Integer srl_id_concepto_planilla){

		if(listTConceptoPlanilla == null){
			listTConceptoPlanilla = this.selectAll(TConceptoPlanillaMapper.class);
		}
		
		TConceptoPlanilla tConceptoPlanilla = null;
		
		for (TConceptoPlanilla x : listTConceptoPlanilla) {
			if(x.getSrl_id_concepto_planilla().equals(srl_id_concepto_planilla)){
				tConceptoPlanilla = x;
				break;
			}
		}
		
		return tConceptoPlanilla;
	}
	
	/**
	 * @param idpersonal
	 * @param srl_id_anio_periodo_planilla
	 * @return
	 */
	public boolean existeRegistroSuspension(Integer idpersonal, Integer srl_id_anio_periodo_planilla){
				
		SuspensionPorPersonalQueryCriteria criteria = new SuspensionPorPersonalQueryCriteria();
		criteria.setAnho_presenteacion(tAnioPlanilla.getInt_anio());
		criteria.setIdpersonal(idpersonal);
		
		
		List<SuspensionPorPersonalQuery> list = this.getListByQuery(SuspensionPorPersonalQueryMapper.class, criteria);
		
		if(list.isEmpty()){
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * @param uit
	 * @param totalProyectado
	 * @param mesActual
	 * @param totalRemuneraciones
	 * @param totalRetenciones
	 * @return
	 * @throws BusinessException
	 * @throws IOException
	 */
	public double calcularRetencionQuintaCategoria(double uit, double totalProyectado) throws BusinessException, IOException{
				
		double rentaBruta = totalProyectado;
		double deduccion7Uit = this.obtenerDeduccion7Uit(uit, rentaBruta);
		double totalRentaImponible = rentaBruta - deduccion7Uit;
		double totalImpuestoAnual= this.obtenerAcumuladoTasas5taCat(uit, totalRentaImponible);
		double totalImpuestoMensual = this.obtenerRetencionMensual5taCat(totalImpuestoAnual);
		
		return totalImpuestoMensual;
		
	}
	
	public double calcularRetencionAnualQuintaCategoria(double uit, double totalProyectado) throws BusinessException, IOException{
		
		double rentaBruta = totalProyectado;
		double deduccion7Uit = this.obtenerDeduccion7Uit(uit, rentaBruta);
		double totalRentaImponible = rentaBruta - deduccion7Uit;
		double totalImpuestoAnual= this.obtenerAcumuladoTasas5taCat(uit, totalRentaImponible);
		return totalImpuestoAnual;
		
	}
	
	
	public double obtenerDeduccion7Uit(double uit,  double rentaNeta){
		double deduccion7Uit = 0;
		if(uit * 7 >rentaNeta){
			deduccion7Uit = rentaNeta;
		}else{
			deduccion7Uit = uit * 7;
		}
		return deduccion7Uit;
	}
	
	public double obtenerAcumuladoTasas5taCat(double uit,  double totalRentaImponible){
		double acumuladoTasas = 0;
		double tramo = 0;
		double tramoAcumulado = 0;
		
		//Hasta 5 UIT
		if(totalRentaImponible > (uit * 5)){
			tramo = uit * 5;
		}else{
			tramo = totalRentaImponible;
		}
		
		acumuladoTasas = acumuladoTasas + (tramo * 0.08);
		tramoAcumulado = tramoAcumulado+ tramo;
		//
		
		//Por el Exceso de 5 UIT  y hasta 20 UIT
		if(totalRentaImponible > (uit * 5) && totalRentaImponible <= (uit * 20)){
			tramo = totalRentaImponible - tramoAcumulado;
		}else{
			if(totalRentaImponible > (uit * 20)){
				tramo = (uit*20) - tramoAcumulado;	
			}else{
				tramo =0 ;
			}
		}
		
		acumuladoTasas = acumuladoTasas + (tramo * 0.14);
		tramoAcumulado = tramoAcumulado+ tramo;
		//

		//Por el Exceso de 20 UIT  y hasta 35 UIT
		if(totalRentaImponible > (uit * 20) && totalRentaImponible <= (uit * 35)){
			tramo = totalRentaImponible - tramoAcumulado;
		}else{
			if(totalRentaImponible > (uit * 35)){
				tramo = (uit*35) - tramoAcumulado;	
			}else{
				tramo =0 ;
			}
		}
		
		acumuladoTasas = acumuladoTasas + (tramo * 0.17);
		tramoAcumulado = tramoAcumulado+ tramo;
		//

		//Por el Exceso de 35 UIT  y hasta 45 UIT
		if(totalRentaImponible > (uit * 35) && totalRentaImponible <= (uit * 45)){
			tramo = totalRentaImponible - tramoAcumulado;
		}else{
			if(totalRentaImponible > (uit * 45)){
				tramo = (uit*45) - tramoAcumulado;	
			}else{
				tramo =0 ;
			}
		}
		
		acumuladoTasas = acumuladoTasas + (tramo * 0.2);
		tramoAcumulado = tramoAcumulado+ tramo;
		//
		
		//Por el Exceso de 45 UIT
		if(totalRentaImponible > (uit * 45)){
			tramo = totalRentaImponible - tramoAcumulado;
		}else{
			tramo = 0;
		}
		
		acumuladoTasas = acumuladoTasas + (tramo * 0.3);
		tramoAcumulado = tramoAcumulado+ tramo;
		//
	
		return acumuladoTasas;
		
	}
	
	public double obtenerRetencionMensual5taCat (double totalImpuestoAnual){
		double retencionMensual = 0;
		retencionMensual = totalImpuestoAnual /12;
		retencionMensual = Math.rint(retencionMensual);
		return retencionMensual;
	}
	
	/**
	 * @param uit
	 * @return
	 * @throws BusinessException
	 * @throws IOException
	 */
	public SuspensionCuartaCategoriaResponseType obtenerSupuestosCuartaCategoria(double uit) throws BusinessException, IOException{
		
		SuspensionCuartaCategoriaResponseType response = new SuspensionCuartaCategoriaResponseType();
		
		response.setSupuesto1(((uit * 7) / 0.8) / 12);
		response.setSupuesto2((uit * 7) / 12);
		response.setSupuesto3((Double) (uit * 7) / 0.8);
		response.setSupuesto4(uit * 7);
		
		return response;
		
	}

	@Transactional
	@Override
	public void procesarLicencias(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException {
		
		boolean tieneLicMatEnf = false;
		
		if(tAnioPlanilla == null){
			this.precargarInfo(srl_id_anio_periodo_planilla);
		}else{
			if(!tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla().equals(srl_id_anio_periodo_planilla)){
				this.precargarInfo(srl_id_anio_periodo_planilla);
			}
		}
		
		if(tAnioPlanilla.getInt_id_estado() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El Año seleccionado no esta activo.");
		}
		
		if(tAnioPeriodoPlanilla.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El periodo seleccionado no esta activo.");
		}
			    
	    TNominaAnioPeriodoPersonalExample example = new TNominaAnioPeriodoPersonalExample();
		
		if(idpersonal != null){
			example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).andSrl_id_regimen_contractualEqualTo(srl_id_regimen_contractual).andIdpersonalEqualTo(idpersonal);
		}else{
			example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).andSrl_id_regimen_contractualEqualTo(srl_id_regimen_contractual);
		}
		
		List<TNominaAnioPeriodoPersonal> listTNominaAnioPeriodoPersonal = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, example);
		
		for(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal : listTNominaAnioPeriodoPersonal){
						
			TPersonalMetaFteFto tPersonalMetaFteFto = this.obtenerMetaFteFto(srl_id_anio_periodo_planilla, tNominaAnioPeriodoPersonal.getIdpersonal());
			
			if(tNominaAnioPeriodoPersonal.getC_fte_fto().equals(tPersonalMetaFteFto.getC_fte_fto()) && tNominaAnioPeriodoPersonal.getC_meta().equals(tPersonalMetaFteFto.getC_meta())){
				
				TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
				tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				
				List<TNominaConcepto> listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
				
				TNominaConcepto ncSueldo = null;
				int indexNcSueldo = -1;
				
				indexNcSueldo = this.obtenerIndexSueldo(listTNominaConcepto);
				
				if(indexNcSueldo > -1){
					ncSueldo = listTNominaConcepto.get(indexNcSueldo);
				}
							
				List<Integer> listDiasLicenciaEnfermedad = this.calcularDiasLicenciaEnfermedad(tNominaAnioPeriodoPersonal);
				List<Integer> listDiasLicenciaMaternidad = this.calcularDiasLicenciaMaternidad(tNominaAnioPeriodoPersonal);
				
				int totalDiasLaborados = 0;
				int totalDiasNoLaborados = 0;
				int totalDiasEnElMes = 30;
				int cantDias = 0;
				for (Integer dias : listDiasLicenciaEnfermedad) {
					
					if(dias.intValue() > 0){
						tieneLicMatEnf = true;
						cantDias = cantDias + dias.intValue();
					}
					
					
//					if(dias.intValue() < totalDiasEnElMes){
//						
//						totalDiasLaborados += (totalDiasEnElMes - dias.intValue());
//						totalDiasNoLaborados += dias.intValue();
//						
//					}else{
//						
//						totalDiasLaborados += 0;
//						totalDiasNoLaborados += dias.intValue();
//						
//					}
					
					
											
				}
				
				totalDiasLaborados += (totalDiasEnElMes - cantDias);
				totalDiasNoLaborados += cantDias;
				
				//16-11-2015 DAVID
				
				/*
				for (Integer dias : listDiasLicenciaMaternidad) {
					
					tieneLicMatEnf = true;
					
					if(dias.intValue() < totalDiasEnElMes){
						totalDiasLaborados += (totalDiasEnElMes - dias.intValue());
						totalDiasNoLaborados += dias.intValue();
					}else{
						totalDiasLaborados += 0;
						totalDiasNoLaborados += dias.intValue();
					}

						
				}
				*/
				
			
				cantDias = 0;
				
				for (Integer dias : listDiasLicenciaMaternidad) {

					if(dias.intValue() > 0){
						tieneLicMatEnf = true;
						cantDias = cantDias + dias.intValue();
					}
						
				}

				totalDiasLaborados = totalDiasLaborados - cantDias;
				totalDiasNoLaborados += cantDias;
				
//				END DAVID
				
				if(!tieneLicMatEnf){
					continue;
				}
				
				double sueldo = 0;
				
				if(totalDiasNoLaborados > 0){
					
					double subsidio = 0;
					double tope_cas_essalud = ncSueldo.getDec_monto_calculado().doubleValue() - (uit.getDec_valor_parametro().doubleValue() * porcentaje_uit.getDec_valor_parametro().doubleValue());
					sueldo = (ncSueldo.getDec_monto_calculado().doubleValue() / 30 ) * totalDiasLaborados;
					
					if(tNominaAnioPeriodoPersonal.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
						subsidio = (tope_cas_essalud / 30) * totalDiasNoLaborados;
					}else if(tNominaAnioPeriodoPersonal.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_728){
						subsidio = 0;
					}
					
					sueldo = sueldo + subsidio;
					
				}else{
					sueldo = ncSueldo.getDec_monto_calculado().doubleValue();
				}
				
				//
				sueldo = new BigDecimal(sueldo).setScale(0, RoundingMode.HALF_UP).doubleValue();
				
				ncSueldo.setDec_monto_calculado(new Double(sueldo));
				
				listTNominaConcepto.set(indexNcSueldo, ncSueldo);
				
				List<TNominaConcepto> descuentosYaportes = new ArrayList<TNominaConcepto>();
				
				for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
					int tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto == CONCEPTO_TIPO_DESCUENTO || tipoConcepto == CONCEPTO_TIPO_APORTE){
						descuentosYaportes.add(tNominaConcepto);
						this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
					}else{
						this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
					}
				}
				
				for (TNominaConcepto tNominaConcepto : descuentosYaportes) {
					listTNominaConcepto.remove(tNominaConcepto);
				}
				
				PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
				PersonalContratoNominaQuery personalContratoNominaQuery = this.obtenerInfoContrato(tNominaAnioPeriodoPersonal.getIdpersonal());
				TPersonalContrato tPersonalContrato = this.obtenerContrato(personalContratoNominaQuery.getSrl_id_contrato());
				
				TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
				tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
				
				List<TPersonalConcepto> listTPersonalConcepto = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
				
				if(sueldo > 0){
					this.calcularDescuentos(srl_id_anio_periodo_planilla,listTPersonalConcepto,tNominaAnioPeriodoPersonal,listTNominaConcepto,tPersonalContrato,personalNominaQuery,int_id_estado);
					this.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,0,tieneLicMatEnf);
				}
				
				for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
					
					int tipoConcepto = this.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					
					if(tipoConcepto == CONCEPTO_TIPO_DESCUENTO || tipoConcepto == CONCEPTO_TIPO_APORTE){
						this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
					}else{
						this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
					}
								
				}
				
				double totalIngresos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_INGRESO);
				double totalDescuentos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_DESCUENTO);
				double totalAportes = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_APORTE);
				double totalNeto = totalIngresos-totalDescuentos;
				
				tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
				tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
				tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
				tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalNeto));
				
				this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
			}
			
		}
	    
	}
	
	
	public TPersonalContrato obtenerContrato(Integer srl_id_contrato){
		
		TPersonalContratoKey pk = new TPersonalContratoKey();
		pk.setSrl_id_contrato(srl_id_contrato);
		
		return this.selectByPrimaryKey(TPersonalContratoMapper.class, pk);
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param idpersonal
	 * @throws BusinessException
	 * @throws IOException 
	 */
	@Transactional
	public double calcularVacacionesTruncas(Integer srl_id_anio_periodo_planilla, Integer idpersonal, boolean calcularAportes, Integer int_id_estado) throws BusinessException, IOException {
				
		double totalIngresosAfectoSegSocial = 0;
		
		TEstadoPersonalExample tEstadoPersonalExample = new TEstadoPersonalExample();
		tEstadoPersonalExample.createCriteria().
		andIdpersonalEqualTo(idpersonal).
		andInt_anioEqualTo(tAnioPlanilla.getInt_anio()).
		andInt_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes());//.andInt_id_estadoEqualTo(1);
		
		List<TEstadoPersonal> listTEstadoPersonal = this.selectByExample(TEstadoPersonalMapper.class, tEstadoPersonalExample);
		TEstadoPersonal tEstadoPersonal = null;
		if(!listTEstadoPersonal.isEmpty()){
			tEstadoPersonal = listTEstadoPersonal.get(0);
		}
		
		if(tEstadoPersonal!=null){
						
			if(tEstadoPersonal.getDec_dias_vac_truncas().doubleValue() > 0){
				
				PersonalNominaQuery personalNominaQuery = obtenerInfoPersonal(idpersonal);
				
				TPersonalContrato tPersonalContrato = this.obtenerContrato(tEstadoPersonal.getSrl_id_contrato());
				
				TNominaAnioPeriodoPersonalExample example = new TNominaAnioPeriodoPersonalExample();
				example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).
				andIdpersonalEqualTo(personalNominaQuery.getIdpersonal()).
				
				andSrl_id_contratoEqualTo(tEstadoPersonal.getSrl_id_contrato());
				
//				COMMENT 26-10-2015
				
//				andC_fte_ftoEqualTo(tEstadoPersonal.getC_fte_fto()).
//				andC_metaEqualTo(tEstadoPersonal.getC_meta());
				
				List<TNominaAnioPeriodoPersonal> listTNominaAnioPeriodoPersonal = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, example);
				TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = this.getRecord(listTNominaAnioPeriodoPersonal);
				List<TNominaConcepto> listTNominaConcepto = null;
				
				if(tNominaAnioPeriodoPersonal == null){
					
					tNominaAnioPeriodoPersonal = new TNominaAnioPeriodoPersonal();
					tNominaAnioPeriodoPersonal.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
					tNominaAnioPeriodoPersonal.setIdpersonal(idpersonal);
					tNominaAnioPeriodoPersonal.setSrl_id_contrato(tEstadoPersonal.getSrl_id_contrato());
					tNominaAnioPeriodoPersonal.setInt_id_estado(int_id_estado);
					tNominaAnioPeriodoPersonal.setC_fte_fto(tEstadoPersonal.getC_fte_fto());
					tNominaAnioPeriodoPersonal.setC_meta(tEstadoPersonal.getC_meta());
					tNominaAnioPeriodoPersonal.setSrl_id_regimen_contractual(tPersonalContrato.getSrl_id_regimen_contractual());
					tNominaAnioPeriodoPersonal.setTsp_fecha_registro(new Date());
					
					tNominaAnioPeriodoPersonal.setSrl_id_regimen_pensionario(personalNominaQuery.getSrl_id_regimen_pensionario());
					tNominaAnioPeriodoPersonal.setVar_ubicacion_fisica(tPersonalContrato.getVar_ubicacion_fisica());
					tNominaAnioPeriodoPersonal.setSrl_id_afp(personalNominaQuery.getSrl_id_afp());
					tNominaAnioPeriodoPersonal.setInt_id_tipo_comision(personalNominaQuery.getInt_id_tipo_comision());
					tNominaAnioPeriodoPersonal.setSrl_id_entidad_bancaria(personalNominaQuery.getSrl_id_entidad_bancaria());
					tNominaAnioPeriodoPersonal.setVar_numero_cuenta_bancaria(personalNominaQuery.getVar_numero_cuenta_bancaria());
					
					this.insertSelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);

					listTNominaConcepto = new ArrayList<TNominaConcepto>();
				}else{
					tNominaAnioPeriodoPersonal.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
					tNominaAnioPeriodoPersonal.setIdpersonal(idpersonal);
					tNominaAnioPeriodoPersonal.setSrl_id_contrato(tEstadoPersonal.getSrl_id_contrato());
					tNominaAnioPeriodoPersonal.setInt_id_estado(int_id_estado);
					
//					COMMENT 26-10-2015
//					tNominaAnioPeriodoPersonal.setC_fte_fto(tEstadoPersonal.getC_fte_fto());
//					tNominaAnioPeriodoPersonal.setC_meta(tEstadoPersonal.getC_meta());
					
					tNominaAnioPeriodoPersonal.setSrl_id_regimen_contractual(tPersonalContrato.getSrl_id_regimen_contractual());
					tNominaAnioPeriodoPersonal.setTsp_fecha_registro(new Date());
					
					tNominaAnioPeriodoPersonal.setSrl_id_regimen_pensionario(personalNominaQuery.getSrl_id_regimen_pensionario());
					tNominaAnioPeriodoPersonal.setVar_ubicacion_fisica(tPersonalContrato.getVar_ubicacion_fisica());
					tNominaAnioPeriodoPersonal.setSrl_id_afp(personalNominaQuery.getSrl_id_afp());
					tNominaAnioPeriodoPersonal.setInt_id_tipo_comision(personalNominaQuery.getInt_id_tipo_comision());
					tNominaAnioPeriodoPersonal.setSrl_id_entidad_bancaria(personalNominaQuery.getSrl_id_entidad_bancaria());
					tNominaAnioPeriodoPersonal.setVar_numero_cuenta_bancaria(personalNominaQuery.getVar_numero_cuenta_bancaria());
				}
				
				//Si la nomina existe 
				//Eliminar los conceptos
				if(listTNominaConcepto == null){
					
					//Seleccionar los conceptos en estado modificado.
					TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
					tNominaConceptoExample.createCriteria().
					andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal()).andInt_id_estadoEqualTo(TIPO_ESTADO_CONCEPTO_MODIFICADO);
					listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
					
					//eliminar los conceptos
					tNominaConceptoExample = new TNominaConceptoExample();
					tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					tNominaConceptoMapper.deleteByExample(tNominaConceptoExample);
					
				}
						
				double montoVacacionesTruncas = (tPersonalContrato.getNum_sueldo().doubleValue() / 30) * tEstadoPersonal.getDec_dias_vac_truncas().doubleValue(); 
				
				montoVacacionesTruncas = new BigDecimal(montoVacacionesTruncas).setScale(0, RoundingMode.HALF_UP).doubleValue();
				
				//Si no existe el concepto calculado en la nomina, agregarlo
				if(!this.existeConceptoCalculado(CONCEPTO_VACACIONES, listTNominaConcepto)){
					TNominaConcepto tNominaConcepto = new TNominaConcepto();
					tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_VACACIONES);
					tNominaConcepto.setDec_monto_calculado(new Double(montoVacacionesTruncas));
					tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
					tNominaConcepto.setTsp_fecha_registro(new Date());
					
					listTNominaConcepto.add(tNominaConcepto);
				}
				
				
				TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
				tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
				
				List<TPersonalConcepto> listTPersonalConcepto = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
				
				/*STAR DAVID 22-12-2015 --- Para agregar otros conceptos*/
				
				for(TPersonalConcepto tPersonalConcepto : listTPersonalConcepto){
					if(tPersonalConcepto.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO){
						if(tPersonalConcepto.getDec_monto_concepto().doubleValue() > 0){
							Integer tipoConcepto = obtenerTipoConcepto(tPersonalConcepto.getSrl_id_concepto_planilla());
							if(tipoConcepto.intValue() == CONCEPTO_TIPO_INGRESO){
								
								if(aplicaPeriodo(srl_id_anio_periodo_planilla, tPersonalConcepto.getSrl_id_concepto_planilla(), tPersonalConcepto)){
									
									//Si no existe el concepto calculado en la nomina, agregarlo
									if(!this.existeConceptoCalculado(tPersonalConcepto.getSrl_id_concepto_planilla(), listTNominaConcepto)){
										
										TNominaConcepto tNominaConcepto = new TNominaConcepto();
										tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
										tNominaConcepto.setSrl_id_concepto_planilla(tPersonalConcepto.getSrl_id_concepto_planilla());
										if(tPersonalConcepto.getInt_id_tipo_monto_concepto().intValue() == TIPO_MONTO_PORCENTUAL){
											tNominaConcepto.setDec_monto_calculado(new Double(tPersonalContrato.getNum_sueldo().doubleValue() * tPersonalConcepto.getDec_monto_concepto().doubleValue()));
										}else{
											tNominaConcepto.setDec_monto_calculado(tPersonalConcepto.getDec_monto_concepto().doubleValue());
										}
										tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
										tNominaConcepto.setTsp_fecha_registro(new Date());
										listTNominaConcepto.add(tNominaConcepto);
										
									}
									
								}
								
							}
						}
						
					}
				}
				
				/* END DAVID */
				
				// calcular descuentos
				this.calcularDescuentos(srl_id_anio_periodo_planilla,listTPersonalConcepto,tNominaAnioPeriodoPersonal,listTNominaConcepto,tPersonalContrato,personalNominaQuery,int_id_estado);
				
				// calcular aportes
				if(calcularAportes){
					if(montoVacacionesTruncas <= (uit.getDec_valor_parametro().doubleValue() * porcentaje_uit.getDec_valor_parametro().doubleValue())){
						this.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,0,true);
					}else{
						this.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,0,false);
					}
				}
				
				this.insertSelective(TNominaConceptoMapper.class, listTNominaConcepto);
				
				double totalIngresos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_INGRESO);
				double totalDescuentos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_DESCUENTO);				
				double totalAportes = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_APORTE);
				double totalNeto = totalIngresos-totalDescuentos;
				
				tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
				tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
				tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
				tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalNeto));
				
				this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);

				totalIngresosAfectoSegSocial = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_SEGURO_SOCIAL);
				
			}
			
		}
		
		return totalIngresosAfectoSegSocial;
		
	}

	@Transactional
	public List<TNominaConcepto> obtenerVacacionesTruncas(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal) throws BusinessException {
		
		List<TNominaConcepto> listTNominaConcepto = new ArrayList<TNominaConcepto>();
		TEstadoPersonal tEstadoPersonal = null;
		
		if(tNominaAnioPeriodoPersonal.getC_fte_fto() != null && tNominaAnioPeriodoPersonal.getC_meta() != null){
			TEstadoPersonalExample tEstadoPersonalExample = new TEstadoPersonalExample();
			tEstadoPersonalExample.createCriteria().
			andIdpersonalEqualTo(tNominaAnioPeriodoPersonal.getIdpersonal()).
			andInt_anioEqualTo(tAnioPlanilla.getInt_anio()).
			andInt_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes()).

//			COMMENT 26-10-2015
			
			andInt_id_estadoEqualTo(1);	

//			andC_metaEqualTo(tNominaAnioPeriodoPersonal.getC_meta()).
//			andC_fte_ftoEqualTo(tNominaAnioPeriodoPersonal.getC_fte_fto());//.andInt_id_estadoEqualTo(1);
			
			List<TEstadoPersonal> listTEstadoPersonal = this.selectByExample(TEstadoPersonalMapper.class, tEstadoPersonalExample);
			
			if(!listTEstadoPersonal.isEmpty()){
				
				tEstadoPersonal = listTEstadoPersonal.get(0);			
//			ADD 26-10-2015
				TNominaAnioPeriodoPersonalExample exampleNomina = new TNominaAnioPeriodoPersonalExample();
				exampleNomina.createCriteria().
				andIdpersonalEqualTo(tNominaAnioPeriodoPersonal.getIdpersonal()).
				andSrl_id_contratoEqualTo(tEstadoPersonal.getSrl_id_contrato()).
				andSrl_id_anio_periodo_planillaEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_anio_periodo_planilla());
				
				List<TNominaAnioPeriodoPersonal> listNominaPersonalAnioPeriodo = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, exampleNomina);
				
				if(listNominaPersonalAnioPeriodo.size() > 0){
					
					TNominaAnioPeriodoPersonal  nomina = this.getRecord(listNominaPersonalAnioPeriodo);
					
					if (nomina != null){
						tEstadoPersonal = null;
					}					
				}				
			}			
		}
		
		if(tEstadoPersonal!=null){
			
			if(tEstadoPersonal.getDec_dias_vac_truncas().doubleValue() > 0){
								
				TPersonalContrato tPersonalContrato = this.obtenerContrato(tEstadoPersonal.getSrl_id_contrato());
				
				double montoVacacionesTruncas = (tPersonalContrato.getNum_sueldo().doubleValue() / 30) * tEstadoPersonal.getDec_dias_vac_truncas().doubleValue(); 
				
				montoVacacionesTruncas = new BigDecimal(montoVacacionesTruncas).setScale(0, RoundingMode.HALF_UP).doubleValue();
				
				//Si no existe el concepto calculado en la nomina, agregarlo
				if(!this.existeConceptoCalculado(CONCEPTO_VACACIONES, listTNominaConcepto)){
					
					TNominaConcepto tNominaConcepto = new TNominaConcepto();
					tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_VACACIONES);
					tNominaConcepto.setDec_monto_calculado(new Double(montoVacacionesTruncas));
					tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
					tNominaConcepto.setTsp_fecha_registro(new Date());
					
					listTNominaConcepto.add(tNominaConcepto);
					
				}
				
			}
			
		}
		
		return listTNominaConcepto;
	}

	
	/**
	 * @param f
	 * @return
	 */
	public int getYear(Date f){
		
		Calendar date = Calendar.getInstance();
		date.setTime(f);
		
		int year = date.get(Calendar.YEAR);
		
		return year;
		
	}
	
	/**
	 * @param f
	 * @return
	 */
	public int getMonth(Date f){
		
		if(f != null){
			Calendar date = Calendar.getInstance();
			date.setTime(f);
			int month = date.get(Calendar.MONTH);
			month++;
			return month;
		}else {
			return -1;
		}
	
	}
	
	/**
	 * @param numMes
	 * @param numAnho
	 * @return
	 */
	public Date getFirstDate(int numMes, int numAnho){
		
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH,1);
	    cal.set(Calendar.MONTH,(numMes-1));
	    cal.set(Calendar.YEAR,numAnho);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    
	    Date fechaInicio = cal.getTime();
	    
	    return fechaInicio;
	}
	
	/**
	 * @param numMes
	 * @param numAnho
	 * @return
	 */
	public Date getLastDate(int numMes, int numAnho){
		
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH,1);
	    cal.set(Calendar.MONTH,(numMes-1));
	    cal.set(Calendar.YEAR,numAnho);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
		
		Calendar cal2 = Calendar.getInstance();
	    cal2.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	    cal2.set(Calendar.MONTH,(numMes-1));
	    cal2.set(Calendar.YEAR,numAnho);
	    cal2.set(Calendar.HOUR_OF_DAY, 0);
	    cal2.set(Calendar.MINUTE, 0);
	    cal2.set(Calendar.SECOND, 0);
	    
	    Date fechaFin = cal2.getTime();
	    
	    return fechaFin;
	}
	
	@Transactional
	public void generarDescuentosPersonal(int numAnho,int numMes, Integer srl_id_regimen_contractual, Integer idpersonal){
		
		if(numMes == 1){
			numAnho = numAnho - 1;
			numMes=12;
		}else{
			numMes = numMes - 1;
		}
		
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH,1);
	    cal.set(Calendar.MONTH,(numMes-1));
	    cal.set(Calendar.YEAR,numAnho);
	    
	    Date fechaInicio = cal.getTime();
	    
	    Calendar cal2 = Calendar.getInstance();
	    cal2.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	    cal2.set(Calendar.MONTH,(numMes-1));
	    cal2.set(Calendar.YEAR,numAnho);
	    
	    Date fechaFin = cal2.getTime();
	    
	    TPersonalDescuentoTmpExample tPersonalDescuentoTmpExample = new TPersonalDescuentoTmpExample();
	    tPersonalDescuentoTmpExample.createCriteria().andSrl_id_pers_desc_tmpIsNotNull();
	    
	    TPersonalDescuentoTmpMapper.deleteByExample(tPersonalDescuentoTmpExample);
	    
	    FnGeneraDescuentoPersonalQueryCriteria criteria = new FnGeneraDescuentoPersonalQueryCriteria();
	    criteria.setDte_fecha_inicio(fechaInicio);
	    criteria.setDte_fecha_fin(fechaFin);
	    criteria.setInt_anho(numAnho);
	    criteria.setInt_mes(numMes);
	    criteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
	    criteria.setIdpersonal(idpersonal);
	    
	    this.getListByQuery(FnGeneraDescuentoPersonalQueryMapper.class, criteria);
	    
	}
		
	@Transactional
	public void calcularTardanzasyOtrosAlterno(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal, List<TNominaConcepto> list) throws BusinessException{
		
		int numAnho = tAnioPlanilla.getInt_anio();
		int numMes = tAnioPeriodoPlanilla.getInt_id_periodo_mes();
		
		if(numMes == 1){
			numAnho = numAnho - 1;
			numMes=12;
		}else{
			numMes = numMes - 1;
		}
					        	    
	    List<Integer> listTipoDescuentos = new ArrayList<Integer>();
		//listTipoDescuentos.add(TIPO_DESCUENTO_LIC_SIN_GOCE_HABER);
		listTipoDescuentos.add(TIPO_DESCUENTO_INASISTENCIA);
		listTipoDescuentos.add(TIPO_DESCUENTO_TARDANZA);
		listTipoDescuentos.add(TIPO_DESCUENTO_PER_SIN_GOCE_HABER);
		
		TPersonalDescuentoExample tPersonalDescuentoExample = new TPersonalDescuentoExample();
		tPersonalDescuentoExample.createCriteria().
		andInt_periodo_descEqualTo(numAnho).
		andInt_mes_descEqualTo(numMes);
		
		List<TPersonalDescuento> listTPersonalDescuento = this.selectByExample(TPersonalDescuentoMapper.class, tPersonalDescuentoExample);
		
		if(listTPersonalDescuento.isEmpty()){
				throw new BusinessException("Falta cerrar Reporte Descuentos en Desplazamiento y Asistencia.");	
		}
		
		tPersonalDescuentoExample = new TPersonalDescuentoExample();
		tPersonalDescuentoExample.createCriteria().
		andIdpersonalEqualTo(tNominaAnioPeriodoPersonal.getIdpersonal()).
		andInt_periodo_descEqualTo(numAnho).
		andInt_mes_descEqualTo(numMes);
		
		listTPersonalDescuento = this.selectByExample(TPersonalDescuentoMapper.class, tPersonalDescuentoExample);
		
		double totalInasistencias = 0;
		double totalTardanzas = 0;
		double totalsinGoceHaber = 0;
		double total=0;
		
		for(TPersonalDescuento tPersonalDescuento : listTPersonalDescuento){
			
			TNominaConcepto tNominaConcepto = new TNominaConcepto();
			tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());

			totalTardanzas += tPersonalDescuento.getNum_monto_desc().doubleValue();

		}
		
		total= totalInasistencias + totalTardanzas + totalsinGoceHaber;
		
		TNominaConceptoExample example = new TNominaConceptoExample();
		example.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal()).andSrl_id_concepto_planillaEqualTo(CONCEPTO_TARDANZA);
		
		tNominaConceptoMapper.deleteByExample(example);
		
		if(total>0){
			{
				
				TNominaConcepto tNominaConcepto = new TNominaConcepto();
				tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_TARDANZA);
				tNominaConcepto.setDec_monto_calculado(total);
				tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
				tNominaConcepto.setTsp_fecha_registro(new Date());
				this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
				
			}
		}
		
	}
	
	public int obtenerTotalDiasLicenciasPorAnho(List<PersonalDiasLicenciasQuery> listPersonalDiasLicenciasQuery){
		
		int totalDiasEnElAnho = 0;
		
		for (PersonalDiasLicenciasQuery personalDiasLicenciasQuery : listPersonalDiasLicenciasQuery) {
						
			if(this.getYear(personalDiasLicenciasQuery.getDte_fec_inicio_lic()) != tAnioPlanilla.getInt_anio().intValue()){
				
				if(this.getMonth(personalDiasLicenciasQuery.getDte_fec_fin_lic()) == 1) {
					Date fechaInicioMes = this.getFirstDate(this.getMonth(personalDiasLicenciasQuery.getDte_fec_fin_lic()), this.getYear(personalDiasLicenciasQuery.getDte_fec_fin_lic()));
					totalDiasEnElAnho += this.daysBetween(fechaInicioMes, personalDiasLicenciasQuery.getDte_fec_fin_lic()) + 1;
				}
				
			}else if(this.getYear(personalDiasLicenciasQuery.getDte_fec_fin_lic()) != tAnioPlanilla.getInt_anio().intValue()){
				
				if(this.getMonth(personalDiasLicenciasQuery.getDte_fec_fin_lic()) == 12) {
					Date fechaFinMes = this.getLastDate(this.getMonth(personalDiasLicenciasQuery.getDte_fec_fin_lic()), this.getYear(personalDiasLicenciasQuery.getDte_fec_fin_lic()));
					totalDiasEnElAnho += this.daysBetween(personalDiasLicenciasQuery.getDte_fec_inicio_lic(), fechaFinMes) + 1;
				}
				
			}else{
				totalDiasEnElAnho += this.daysBetween(personalDiasLicenciasQuery.getDte_fec_inicio_lic(), personalDiasLicenciasQuery.getDte_fec_fin_lic()) + 1;
			}
			
		}
		
		return totalDiasEnElAnho;
	}
	
	/**
	 * @param tNominaAnioPeriodoPersonal
	 * @return
	 */
	public List<Integer> calcularDiasLicenciaEnfermedad(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal){
		
		//Obtenemos la licencia del periodo y año
		SubsidiosPersonalCriteria subsidiosPersonalCriteria = new SubsidiosPersonalCriteria();
		subsidiosPersonalCriteria.setIdpersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
		subsidiosPersonalCriteria.setInt_anho(tAnioPlanilla.getInt_anio());
		subsidiosPersonalCriteria.setInt_mes(tAnioPeriodoPlanilla.getInt_id_periodo_mes());
		subsidiosPersonalCriteria.setSrl_id_per_activ(TIPO_SUBSIDIO_ENFERMEDAD);
		
		List<SubsidiosPersonal> listSubsidiosPersonal = this.getListByQuery(SubsidiosPersonalMapper.class, subsidiosPersonalCriteria);
		
		List<Integer> listDiasNoLaborados = new ArrayList<Integer>();
		
		for(SubsidiosPersonal subsidiosPersonal : listSubsidiosPersonal){
						
			//Obtener los dias de licencia del personal en todo el año actual
			PersonalDiasLicenciasQueryCriteria personalDiasLicenciasQueryCriteria = new PersonalDiasLicenciasQueryCriteria();
			personalDiasLicenciasQueryCriteria.setInt_anho(tAnioPlanilla.getInt_anio());
			personalDiasLicenciasQueryCriteria.setSrl_id_per_activ(TIPO_SUBSIDIO_ENFERMEDAD);
			personalDiasLicenciasQueryCriteria.setIdpersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
			personalDiasLicenciasQueryCriteria.setDte_fec_inicio_lic(subsidiosPersonal.getDte_fec_inicio_lic());
			personalDiasLicenciasQueryCriteria.setSrl_id_pers_lic(subsidiosPersonal.getSrl_id_pers_lic());
			
			List<PersonalDiasLicenciasQuery> listPersonalDiasLicenciasQuery = this.getListByQuery(PersonalDiasLicenciasQueryMapper.class, personalDiasLicenciasQueryCriteria);
			
			int totalDiasLicenciasPorAnho = this.obtenerTotalDiasLicenciasPorAnho(listPersonalDiasLicenciasQuery);
			
			Date fechaInicioMes = this.getFirstDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue(), tAnioPlanilla.getInt_anio().intValue());
			
			if(fechaInicioMes.after(subsidiosPersonal.getDte_fec_inicio_lic())){
				totalDiasLicenciasPorAnho += this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), fechaInicioMes);	
			}
			
			int diasNoLaborados = 0;
			
			//Supera los 20 dias
			if(totalDiasLicenciasPorAnho > 20) {
				diasNoLaborados = this.calcularDiasNoLaboradosMes(subsidiosPersonal);

				//02-12-2015 DAVID
				
//				if(diasNoLaborados == 31 || diasNoLaborados == 28 || diasNoLaborados == 29){
				if(diasNoLaborados >= 30){
					
					diasNoLaborados = 30;
					
				}else{
					
					if(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() == 2){
						
						if( diasNoLaborados == 28 || diasNoLaborados == 29){
//							diasNoLaborados = 30;	
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
							
							Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());
							
							Integer ultimoDiaMes = Integer.parseInt(dateFormat.format(fechaFinMes));
							
							if(diasNoLaborados == ultimoDiaMes){
								diasNoLaborados = 30;	
							}else if(diasNoLaborados < ultimoDiaMes){
								diasNoLaborados = 30 - (ultimoDiaMes - diasNoLaborados);	
							}

						}
						
					}
				}
				
				//
			}else{
				
				diasNoLaborados = this.calcularDiasNoLaboradosMes(subsidiosPersonal);
					
					//int diasPendientes = 20 - totalDiasLicenciasPorAnho;
				int totalDiasNoLaborados =  totalDiasLicenciasPorAnho + diasNoLaborados;
				
				if(totalDiasNoLaborados > 20){
					
					int diasPendientes =  (totalDiasLicenciasPorAnho +diasNoLaborados) - 20;
					
//					Date nuevaFechaInicioLicencia = null;
//					
//					if(fechaInicioMes.after(subsidiosPersonal.getDte_fec_inicio_lic())){
//						nuevaFechaInicioLicencia = this.addDays(fechaInicioMes, (diasPendientes));		
//					}else{
//						nuevaFechaInicioLicencia = this.addDays(subsidiosPersonal.getDte_fec_inicio_lic(), (diasPendientes));
//					}
//					
//					subsidiosPersonal.setDte_fec_inicio_lic(nuevaFechaInicioLicencia);
//					
//					diasNoLaborados = this.calcularDiasNoLaboradosMes(subsidiosPersonal);
					diasNoLaborados = diasPendientes;
					
					//02-12-2015 DAVID
					
//					if(diasNoLaborados == 31 || diasNoLaborados == 28 || diasNoLaborados == 29){
					if(diasNoLaborados >= 30){
						
						diasNoLaborados = 30;
						
					}else{
						
						if(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() == 2){
							
							if( diasNoLaborados == 28 || diasNoLaborados == 29){
//								diasNoLaborados = 30;
								
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
								
								Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());
								
								Integer ultimoDiaMes = Integer.parseInt(dateFormat.format(fechaFinMes));
								
								if(diasNoLaborados == ultimoDiaMes){
									diasNoLaborados = 30;	
								}else if(diasNoLaborados < ultimoDiaMes){
									diasNoLaborados = 30 - (ultimoDiaMes - diasNoLaborados);	
								}

							}
							
						}
					}
					
				}else{
					diasNoLaborados = 0;
				}
				
			}
			
			listDiasNoLaborados.add(diasNoLaborados);
			
		}
		
		return listDiasNoLaborados;

	}
	
	/**
	 * @param tNominaAnioPeriodoPersonal
	 * @return
	 */
	public List<Integer> calcularDiasLicenciaMaternidad(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal){
		
		//Obtenemos la licencia del periodo y año
		SubsidiosPersonalCriteria subsidiosPersonalCriteria = new SubsidiosPersonalCriteria();
		subsidiosPersonalCriteria.setIdpersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
		subsidiosPersonalCriteria.setInt_anho(tAnioPlanilla.getInt_anio());
		subsidiosPersonalCriteria.setInt_mes(tAnioPeriodoPlanilla.getInt_id_periodo_mes());
		subsidiosPersonalCriteria.setSrl_id_per_activ(TIPO_SUBSIDIO_MATERNIDAD);
		
		List<SubsidiosPersonal> listSubsidiosPersonal = this.getListByQuery(SubsidiosPersonalMapper.class, subsidiosPersonalCriteria);
		
		List<Integer> listDiasNoLaborados = new ArrayList<Integer>();
		
		for(SubsidiosPersonal subsidiosPersonal : listSubsidiosPersonal){
						
			int diasNoLaborados = 0;
			diasNoLaborados = this.calcularDiasNoLaboradosMes(subsidiosPersonal);
			
//			if(diasNoLaborados == 31 || diasNoLaborados == 28 || diasNoLaborados == 29){
//				diasNoLaborados = 30;
//			}
			
			//02-12-2015 DAVID
			
//			if(diasNoLaborados == 31 || diasNoLaborados == 28 || diasNoLaborados == 29){
			if(diasNoLaborados >= 30){
				
				diasNoLaborados = 30;
				
			}else{
				
				if(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() == 2){
					
					if( diasNoLaborados == 28 || diasNoLaborados == 29){
						
//						diasNoLaborados = 30;	
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
						
						Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());
						
						Integer ultimoDiaMes = Integer.parseInt(dateFormat.format(fechaFinMes));
						
						if(diasNoLaborados == ultimoDiaMes){
							diasNoLaborados = 30;	
						}else if(diasNoLaborados < ultimoDiaMes){
							diasNoLaborados = 30 - (ultimoDiaMes - diasNoLaborados);	
						}
							
					}
					
				}
			}			
			
			listDiasNoLaborados.add(diasNoLaborados);
							
		}
		
		return listDiasNoLaborados;
	}
	
	
//	ADD 14-10-2015 DAVID
	public Integer calcularDiasLicenciaAnualSinGoceHaber(int  idPersonal, int mesActual){
		int cantDias = 0;
		//Obtenemos la licencia del periodo y año
		SubsidiosPersonalCriteria subsidiosPersonalCriteria = new SubsidiosPersonalCriteria();
		subsidiosPersonalCriteria.setIdpersonal(idPersonal);
		subsidiosPersonalCriteria.setInt_anho(tAnioPlanilla.getInt_anio());
		subsidiosPersonalCriteria.setSrl_id_per_activ(TIPO_LICENCIA_SIN_GOCE_HABER);
//		System.out.println("------------------------------------------------------------------------------------");
		for(int mes = mesActual + 1; mes <= 12;  mes++){
			
			subsidiosPersonalCriteria.setInt_mes((mes));		
			
			List<SubsidiosPersonal> listSubsidiosPersonal = this.getListByQuery(SubsidiosPersonalMapper.class, subsidiosPersonalCriteria);
						
			for(SubsidiosPersonal subsidiosPersonal : listSubsidiosPersonal){
				
				int diasLicencias 	= 0;								
				diasLicencias 		= this.calcularDiasLicenciasPorMes(subsidiosPersonal, mes);
				cantDias 			= cantDias + diasLicencias;				
//				System.out.println(mes + ".- cantDias  Lic. por mes --> " + diasLicencias);
			}
		}
		
//		System.out.println("cantDias  Lic. anual --> " + cantDias);
//		System.out.println("------------------------------------------------------------------------------------");
		
		return cantDias;
	}
//	END
	public Integer calcularDiasLicenciaSinGoceHaber(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal){
		
		//Obtenemos la licencia del periodo y año
		SubsidiosPersonalCriteria subsidiosPersonalCriteria = new SubsidiosPersonalCriteria();
		subsidiosPersonalCriteria.setIdpersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
		subsidiosPersonalCriteria.setInt_anho(tAnioPlanilla.getInt_anio());
		subsidiosPersonalCriteria.setInt_mes((tAnioPeriodoPlanilla.getInt_id_periodo_mes()));
		subsidiosPersonalCriteria.setSrl_id_per_activ(TIPO_LICENCIA_SIN_GOCE_HABER);
		
		List<SubsidiosPersonal> listSubsidiosPersonal = this.getListByQuery(SubsidiosPersonalMapper.class, subsidiosPersonalCriteria);
		
		int cantDias = 0;
		
		for(SubsidiosPersonal subsidiosPersonal : listSubsidiosPersonal){
			int diasLicencias = 0;
			
			
//			ADD 13-10-2015 DAVID
			
			diasLicencias = this.calcularDiasLicenciasPorMes(subsidiosPersonal, tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue());
			
//			System.out.println("diasLicencias --> " + diasLicencias);
			
			cantDias = cantDias + diasLicencias;
			
//			System.out.println("cantDias --> " + cantDias);

/*			
			int diasLaborados = 0;
			diasLaborados = this.calcularDiasLaboradosMes(subsidiosPersonal);
			if(cantDias == 0){
				cantDias = cantDias + diasLaborados;
			}else{
				if(cantDias < diasLaborados){
					cantDias = diasLaborados - cantDias;
				}else{
					cantDias = cantDias - diasLaborados;
				}
				
			}
*/
			
//			END			
			
		}
		
		return cantDias;
	}
	
	/**
	 * @param subsidiosPersonal
	 * @return
	 */
	public int calcularDiasNoLaboradosMes(SubsidiosPersonal subsidiosPersonal){
		
		int diasMes = 0;
		//Si el mes del inicio de la licencia es igual al mes del preceso de la planilla o si la fecha fin de la licencia
		//es igual al mes del proceso de la planilla
		if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() || this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
			
			//Si las fechas de licencia (inicio y fin) pertenecen al mismo mes
			if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == this.getMonth(subsidiosPersonal.getDte_fec_fin_lic())){
				//Obtenemos los dias entre esas fechas			
			    int diasNoLaborados = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), subsidiosPersonal.getDte_fec_fin_lic());
			    
				diasMes = diasNoLaborados + 1;
			
			//Si no pertenecen al mismo mes
			}else{
				
				//Si la fecha de inicio de la licencia es igual al mes de proceso de planilla
				if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					//Obtenemos la fecha de fin del mes
					Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());
									    
				    int diasNoLaborados = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), fechaFinMes);

					
					diasMes = diasNoLaborados + 1;
					
				}
				//Si la fecha fin de la licencia es igual al mes de proceso de planilla
				if(this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					//Obtenemos la fecha de inicio del mes
					Date fechaInicioMes = this.getFirstDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio());

					int diasNoLaborados = this.daysBetween(fechaInicioMes, subsidiosPersonal.getDte_fec_fin_lic());
					
					diasMes = diasNoLaborados + 1;

				}
			}
		
		}else{
			diasMes = 30;
		}
		
		return diasMes;
	}
	
	
//	ADD 13-10-2015 DAVID
	public int calcularDiasLicenciasPorMes(SubsidiosPersonal subsidiosPersonal, int int_periodo_mes){
		
		int diasLicenciaMes = 0;
		
		//Si el mes del inicio de la licencia es igual al mes del preceso de la planilla o si la fecha fin de la licencia
		//es igual al mes del proceso de la planilla
		if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == int_periodo_mes || this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == int_periodo_mes){
			
			
			//Obtener el ultimo día del mes de la nomina
	    	SimpleDateFormat sdfmesdesc = new SimpleDateFormat("dd");
	    	int	ultimodiaMes						= Integer.parseInt(sdfmesdesc.format(this.getLastDate(int_periodo_mes, tAnioPlanilla.getInt_anio().intValue())));
			
			
			//Si las fechas de licencia (inicio y fin) pertenecen al mismo mes
			if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == this.getMonth(subsidiosPersonal.getDte_fec_fin_lic())){
								
				//Obtenemos los dias entre esas fechas
			    int diasLicencia = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), subsidiosPersonal.getDte_fec_fin_lic());
			    
			    diasLicenciaMes = diasLicencia + 1;				
			
			//Si no pertenecen al mismo mes
			}else{
				
				//Si la fecha de inicio de la licencia es igual al mes de proceso de planilla Y FINALIZA MES(S) POSTERIOR
				if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == int_periodo_mes){
					
					//Obtenemos la fecha de fin del mes
					Date fechaFinMes = this.getLastDate(int_periodo_mes, tAnioPlanilla.getInt_anio());
				    
					//obtenemos los dias entre las fechas
					
				    diasLicenciaMes = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(),fechaFinMes);
		    
					if(ultimodiaMes < 31){
						diasLicenciaMes = diasLicenciaMes +1;
					}
				    
				}
				
				//Si la fecha fin de la licencia es igual al mes de proceso de planilla E INICIO UN MES ANTERIOR
				if(this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == int_periodo_mes){
					
					//Obtenemos la fecha de inicio del mes
					Date fechaInicioMes = this.getFirstDate(int_periodo_mes, tAnioPlanilla.getInt_anio().intValue());					
					
					//obtenemos los dias entre las fechas

					diasLicenciaMes = this.daysBetween(fechaInicioMes, subsidiosPersonal.getDte_fec_fin_lic());			
					
//					if(ultimodiaMes < 31){
						diasLicenciaMes = diasLicenciaMes +1;
//					}
					
				}
				
			}
			
			
			
			//Validar para el mes de febrero y los 30 días por mes
			
			if (this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == 2 ){
				
				if(diasLicenciaMes == ultimodiaMes){
					diasLicenciaMes = 30;
				}else{
					diasLicenciaMes = diasLicenciaMes + (30 - ultimodiaMes);
				}
		    	
			}else{
				
				if(diasLicenciaMes > 30){
					diasLicenciaMes = 30;
				}
				
			}
			
			
		}else if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) < int_periodo_mes && this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) > int_periodo_mes){
			
			diasLicenciaMes = 30;
			
		}
		
		return diasLicenciaMes;
	}
	
	public int calcularDiasLicenciasPorMexNoseUsa(SubsidiosPersonal subsidiosPersonal){
		
		int diasLicenciaMes = 0;
		
		//Si el mes del inicio de la licencia es igual al mes del preceso de la planilla o si la fecha fin de la licencia
		//es igual al mes del proceso de la planilla
		
		if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() 
				|| this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
			
			
			//Obtener el ultimo día del mes de la nomina
	    	SimpleDateFormat sdfmesdesc = new SimpleDateFormat("dd");
	    	int	ultimodiaMes						= Integer.parseInt(sdfmesdesc.format(this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue())));
			
			
			//Si las fechas de licencia (inicio y fin) pertenecen al mismo mes
			if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == this.getMonth(subsidiosPersonal.getDte_fec_fin_lic())){
								
				//Obtenemos los dias entre esas fechas
			    int diasLicencia = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), subsidiosPersonal.getDte_fec_fin_lic());
			    
			    diasLicenciaMes = diasLicencia + 1;				
			
			//Si no pertenecen al mismo mes
			}else{
				
				//Si la fecha de inicio de la licencia es igual al mes de proceso de planilla Y FINALIZA MES(S) POSTERIOR
				if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					
					//Obtenemos la fecha de fin del mes
					Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio());
				    
					//obtenemos los dias entre las fechas
					
				    diasLicenciaMes = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(),fechaFinMes);
		    
					if(ultimodiaMes < 31){
						diasLicenciaMes = diasLicenciaMes +1;
					}
				    
				}
				
				//Si la fecha fin de la licencia es igual al mes de proceso de planilla E INICIO UN MES ANTERIOR
				if(this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					
					//Obtenemos la fecha de inicio del mes
					Date fechaInicioMes = this.getFirstDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());					
					
					//obtenemos los dias entre las fechas

					diasLicenciaMes = this.daysBetween(fechaInicioMes, subsidiosPersonal.getDte_fec_fin_lic());			
					
//					if(ultimodiaMes < 31){
						diasLicenciaMes = diasLicenciaMes +1;
//					}
					
				}
				
			}
			
			
			
			//Validar para el mes de febrero y los 30 días por mes
			
			if (this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == 2 ){
				
				if(diasLicenciaMes == ultimodiaMes){
					diasLicenciaMes = 30;
				}
		    	
			}else{
				
				if(diasLicenciaMes > 30){
					diasLicenciaMes = 30;
				}
				
			}
			
			
		}else if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) < tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() 
				&& this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) > tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
			
			diasLicenciaMes = 30;
			
		}
		
		return diasLicenciaMes;
	}
//	END DAVID
	
	
	public int calcularDiasLaboradosMes(SubsidiosPersonal subsidiosPersonal){
		
		int diasMes = 0;
		
		//Si el mes del inicio de la licencia es igual al mes del preceso de la planilla o si la fecha fin de la licencia
		//es igual al mes del proceso de la planilla
		if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() 
				|| this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
			
			//Si las fechas de licencia (inicio y fin) pertenecen al mismo mes
			if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == this.getMonth(subsidiosPersonal.getDte_fec_fin_lic())){
								
				//Obtenemos los dias entre esas fechas
			    int diasLaborados = this.daysBetween(subsidiosPersonal.getDte_fec_inicio_lic(), subsidiosPersonal.getDte_fec_fin_lic());
			    
				diasMes = diasLaborados + 1;
				
				if(diasMes == 28 || diasMes == 29 || diasMes == 30 || diasMes == 31){
					diasMes = 0;
				}				
			
			//Si no pertenecen al mismo mes
			}else{
				
				//Si la fecha de inicio de la licencia es igual al mes de proceso de planilla
				if(this.getMonth(subsidiosPersonal.getDte_fec_inicio_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					
					//Obtenemos la fecha de inicio del mes
					Date fechaInicioMes = this.getFirstDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio().intValue());
					
					//obtenemos los dias entre las fechas
				    int diasNoLaborados = this.daysBetween(fechaInicioMes,subsidiosPersonal.getDte_fec_inicio_lic());					
		    
					diasMes = diasNoLaborados;
					
				}
				
				//Si la fecha fin de la licencia es igual al mes de proceso de planilla
				if(this.getMonth(subsidiosPersonal.getDte_fec_fin_lic()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
					
					//Obtenemos la fecha de fin del mes
					Date fechaFinMes = this.getLastDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio());					
					
					//obtenemos los dias entre las fechas
					int diasNoLaborados = this.daysBetween(subsidiosPersonal.getDte_fec_fin_lic(),fechaFinMes);

					diasMes = diasNoLaborados;					

				}
			}
		
		}else{
			diasMes = 0;
		}
		
		return diasMes;
	}
	
	public double obtenerRetencionEneroPorAnho(Integer idpersonal){
		
		TAnioPeriodoPlanillaExample example = new TAnioPeriodoPlanillaExample();
		example.createCriteria().andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla()).andInt_id_periodo_mesEqualTo(MES_ENERO);
//		example.createCriteria().andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla());
		
		TAnioPeriodoPlanilla app = (TAnioPeriodoPlanilla) this.getRecord(this.selectByExample(TAnioPeriodoPlanillaMapper.class, example));
//		System.out.println("idpersonal --> " + idpersonal);

		TNominaAnioPeriodoPersonalExample nominaExample = new TNominaAnioPeriodoPersonalExample();
		nominaExample.createCriteria().andIdpersonalEqualTo(idpersonal).andSrl_id_anio_periodo_planillaEqualTo(app.getSrl_id_anio_periodo_planilla());
		
		TNominaAnioPeriodoPersonal napp = (TNominaAnioPeriodoPersonal) this.getRecord(this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, nominaExample));
		
		TNominaConceptoExample nominaConceptoExample = new TNominaConceptoExample();
		nominaConceptoExample.createCriteria().andSrl_id_concepto_planillaEqualTo(CONCEPTO_QUINTA_CATEGORIA).andSrl_id_nomina_anio_periodo_personalEqualTo(napp.getSrl_id_nomina_anio_periodo_personal());
		
		TNominaConcepto nc = (TNominaConcepto) this.getRecord(this.selectByExample(TNominaConceptoMapper.class, nominaConceptoExample));
		
		if (nc == null ) {
			return 0;
		}else{
			return nc.getDec_monto_calculado();
		}
			
		
		
		
	}
	
	public TNominaConcepto obtenerConcepto(List<TNominaConcepto> list, Integer srl_id_concepto_planilla){
		
		for(TNominaConcepto obj : list){
			if(obj.getSrl_id_concepto_planilla().intValue() == srl_id_concepto_planilla.intValue()){
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * @param srl_id_anio_periodo_planilla
	 * @param listTPersonalConcepto
	 * @param tNominaAnioPeriodoPersonal
	 * @param listTNominaConcepto
	 * @param personalContratoNominaQuery
	 * @param personalNominaQuery
	 * @throws BusinessException
	 * @throws IOException
	 */
	public void calcularDescuentos(Integer srl_id_anio_periodo_planilla,
			List<TPersonalConcepto> listTPersonalConcepto,
			TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal,
			List<TNominaConcepto> listTNominaConcepto,
			TPersonalContrato tPersonalContrato,
			PersonalNominaQuery personalNominaQuery,
			Integer int_id_estado
			) throws BusinessException, IOException{
		
		for(TPersonalConcepto tPersonalConcepto : listTPersonalConcepto){
			
			if(tPersonalConcepto.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO){
				if(tPersonalConcepto.getDec_monto_concepto().doubleValue() > 0){
					Integer tipoConcepto = obtenerTipoConcepto(tPersonalConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == CONCEPTO_TIPO_DESCUENTO){
						if(aplicaPeriodo(srl_id_anio_periodo_planilla, tPersonalConcepto.getSrl_id_concepto_planilla(), tPersonalConcepto)){
							
							//Si no existe el concepto calculado en la nomina, agregarlo
							if(!this.existeConceptoCalculado(tPersonalConcepto.getSrl_id_concepto_planilla(), listTNominaConcepto)){
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(tPersonalConcepto.getSrl_id_concepto_planilla());
								if(tPersonalConcepto.getInt_id_tipo_monto_concepto().intValue() == TIPO_MONTO_PORCENTUAL){
									double totalIngresoMensual = this.obtenerMontoPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, tPersonalConcepto);
									tNominaConcepto.setDec_monto_calculado(new Double(totalIngresoMensual * tPersonalConcepto.getDec_monto_concepto().doubleValue()));
								}else{
									tNominaConcepto.setDec_monto_calculado(tPersonalConcepto.getDec_monto_concepto().doubleValue());
								}
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
							}
							
							
						}
					}
				}
				
			}
			
		}
		
		//quinta categoria
		if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_728){ // 728
			
			//Si no existe el concepto calculado en la nomina, agregarlo
			if(!this.existeConceptoCalculado(CONCEPTO_QUINTA_CATEGORIA, listTNominaConcepto)){
				
				int mesActual = this.obtenerMesActual(srl_id_anio_periodo_planilla);
				int anhoActual = tAnioPlanilla.getInt_anio().intValue();
				
				double retencionQuintaCategoria = 0;
				double retencionAnualQuintaCategoria = 0;
				
				double totalSueldoHastaPeriodo 	= this.obtenerTotalSueldoPorMesCorte(anhoActual, mesActual, tNominaAnioPeriodoPersonal.getIdpersonal(), CONCEPTO_REMUNERACION);
				
				double totalIngresoProyectado 	= tPersonalContrato.getNum_sueldo().doubleValue() * (12 - mesActual);

				totalIngresoProyectado 			= totalIngresoProyectado + totalSueldoHastaPeriodo;
				
				double totalConceptosProyecto 	= this.obtenerIngresosProyectadoPorConcepto(listTPersonalConcepto, tPersonalContrato);

				double totalProyectado 			= totalIngresoProyectado + totalConceptosProyecto;

				TNominaConcepto ncSueldo 		= this.obtenerConcepto(listTNominaConcepto, CONCEPTO_REMUNERACION);
								
				totalProyectado 				= totalProyectado + ncSueldo.getDec_monto_calculado().doubleValue();	
								
				retencionQuintaCategoria 		= this.calcularRetencionQuintaCategoria(uit.getDec_valor_parametro().doubleValue(), totalProyectado);
				
//				ADD 14-10-2015 DAVID
				if(mesActual > MES_ENERO && mesActual < MES_DICIEMBRE){

					//Obtener dias licencia sin goce de haber de los meses posteriores a la generación de la nomina
					int diasLicenciaAnual 			= this.calcularDiasLicenciaAnualSinGoceHaber(tNominaAnioPeriodoPersonal.getIdpersonal(), mesActual);
					
					double descontarPorLic			= (tPersonalContrato.getNum_sueldo().doubleValue() / 30) * diasLicenciaAnual;
					
					totalProyectado					= totalProyectado - descontarPorLic;					
					
				}
				
//				END		
				
				retencionAnualQuintaCategoria = this.calcularRetencionAnualQuintaCategoria(uit.getDec_valor_parametro().doubleValue(), totalProyectado);
		
				
				ObtenerRetencionPorAnhoPeriodoQueryCriteria criteria = new ObtenerRetencionPorAnhoPeriodoQueryCriteria();
				criteria.setIdpersonal(tPersonalContrato.getIdpersonal());
				criteria.setInt_anio(anhoActual);
				criteria.setInt_id_periodo_mes(mesActual);
				criteria.setSrl_id_concepto_planilla(CONCEPTO_QUINTA_CATEGORIA);
				
				ObtenerRetencionPorAnhoPeriodoQuery orpapq = this.getRecordByQuery(ObtenerRetencionPorAnhoPeriodoQueryMapper.class, criteria);
				
				//ADD 14-10-2015 DAVID

				if(mesActual != MES_ENERO){
	
					double montoRetencionEnero = 0.0;
					montoRetencionEnero = this.obtenerRetencionEneroPorAnho(tPersonalContrato.getIdpersonal());
				
				// ADD 02-10-2015 DAVID
					if (montoRetencionEnero != 0 ){
						if(mesActual != MES_ENERO && mesActual != MES_DICIEMBRE){
							
//							if(orpapq.getTotal_retencion().doubleValue() >= (retencionQuintaCategoria * 12)){
							if(orpapq.getTotal_retencion().doubleValue() >= retencionAnualQuintaCategoria){								
								retencionQuintaCategoria = 0;
							}else{
								
//								if(((retencionQuintaCategoria * 12) - orpapq.getTotal_retencion().doubleValue()) < montoRetencionEnero){
								if((retencionAnualQuintaCategoria - orpapq.getTotal_retencion().doubleValue()) < montoRetencionEnero){
									
									retencionQuintaCategoria = 0;
								}else{
									retencionQuintaCategoria = montoRetencionEnero;
								}								
							}							
						}
						
						if(mesActual == MES_DICIEMBRE){							
							double val = ((retencionAnualQuintaCategoria) - orpapq.getTotal_retencion().doubleValue());							
							if(val > 0){
								retencionQuintaCategoria = Math.rint(val);
							}else{
								retencionQuintaCategoria = 0.0;
							}
						}
					}
				}
				
				
//				double totalSueldoHastaPeriodo = this.obtenerTotalSueldoPorMesCorte(anhoActual, mesActual, tNominaAnioPeriodoPersonal.getIdpersonal(), CONCEPTO_REMUNERACION);
//				
//				double totalIngresoProyectado = tPersonalContrato.getNum_sueldo().doubleValue() * (12 - mesActual);
//				
//				totalIngresoProyectado = totalIngresoProyectado + totalSueldoHastaPeriodo;
//				
//				double totalConceptosProyecto = this.obtenerIngresosProyectadoPorConcepto(listTPersonalConcepto, tPersonalContrato);
//				double totalProyectado = totalIngresoProyectado + totalConceptosProyecto;
//				
//				TNominaConcepto ncSueldo = this.obtenerConcepto(listTNominaConcepto, CONCEPTO_REMUNERACION);
//								
//				totalProyectado = totalProyectado + ncSueldo.getDec_monto_calculado().doubleValue();	
//								
//				retencionQuintaCategoria = this.calcularRetencionQuintaCategoria(uit.getDec_valor_parametro().doubleValue(), totalProyectado);
				
				if(retencionQuintaCategoria>0){

					//ADD 16-02-2016 DAVID
					if( (ncSueldo.getDec_monto_calculado().doubleValue() / 2 ) > retencionQuintaCategoria){
						TNominaConcepto tNominaConcepto = new TNominaConcepto();
						tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
						tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_QUINTA_CATEGORIA);
						tNominaConcepto.setDec_monto_calculado(Math.rint(new Double(retencionQuintaCategoria)));
						tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
						tNominaConcepto.setTsp_fecha_registro(new Date());
						listTNominaConcepto.add(tNominaConcepto);						
					}
					
				}
			}
			
		//cuarta categoria
		}else if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){ // CAS
			
			//Si no existe el concepto calculado en la nomina, agregarlo
			if(!this.existeConceptoCalculado(CONCEPTO_CUARTA_CATAGORIA, listTNominaConcepto)){
				/* 18-12-2015 DAVID
				 
				SuspensionCuartaCategoriaResponseType supuestos = this.obtenerSupuestosCuartaCategoria(uit.getDec_valor_parametro().doubleValue());
				
				double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_CUARTA_CATAGORIA);
				
				if(totalIngresoMensual > tope_min_4ta.getDec_valor_parametro().doubleValue()){
					
					double totalIngresosAfectosCuartaPorEjercicio = this.obtenerIngresosAfectoPorConcepto(tAnioPlanilla.getSrl_id_anio_planilla(), tNominaAnioPeriodoPersonal.getIdpersonal(), CONCEPTO_CUARTA_CATAGORIA);
					if(totalIngresosAfectosCuartaPorEjercicio > supuestos.getSupuesto3().doubleValue()){
						double retencionCuartaCategoria = totalIngresoMensual * 0.08;
						{
							TNominaConcepto tNominaConcepto = new TNominaConcepto();
							tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
							tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_CUARTA_CATAGORIA);
							tNominaConcepto.setDec_monto_calculado(new Double(retencionCuartaCategoria));
							tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
							tNominaConcepto.setTsp_fecha_registro(new Date());
							listTNominaConcepto.add(tNominaConcepto);
						}
					}else{
						if(!this.existeRegistroSuspension(tNominaAnioPeriodoPersonal.getIdpersonal(), srl_id_anio_periodo_planilla)){
							double retencionCuartaCategoria = totalIngresoMensual * 0.08;
							{
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_CUARTA_CATAGORIA);
								tNominaConcepto.setDec_monto_calculado(new Double(retencionCuartaCategoria));
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
							}
						}
					}

				}
				*/
				
				/* SOLO SE CALCULA EL IMPUESTO A LA RENTA DE  4TA CATEGORIA CUANDO EL PERSONAL NO TIENE REGISTRADA (PRESENTA) SUSPENSIÓN */
				
				double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_CUARTA_CATAGORIA);
				
				if(totalIngresoMensual > tope_min_4ta.getDec_valor_parametro().doubleValue()){
					
					if(!this.existeRegistroSuspension(tNominaAnioPeriodoPersonal.getIdpersonal(), srl_id_anio_periodo_planilla)){
						
						double retencionCuartaCategoria = totalIngresoMensual * 0.08;
						
						{
							TNominaConcepto tNominaConcepto = new TNominaConcepto();
							tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
							tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_CUARTA_CATAGORIA);
							tNominaConcepto.setDec_monto_calculado(new Double(retencionCuartaCategoria));
							tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
							tNominaConcepto.setTsp_fecha_registro(new Date());
							listTNominaConcepto.add(tNominaConcepto);
						}
					}
				}

				
				/* END DAVID*/
			}
			 
		}
		
		//REGIMEN PENSIONARIO
		if(personalNominaQuery.getSrl_id_regimen_pensionario() != null){
			
			if(personalNominaQuery.getSrl_id_regimen_pensionario().intValue() != TIPO_REGIMEN_PENSIONARIO_NINGUNO){
				
				if(personalNominaQuery.getSrl_id_regimen_pensionario().intValue() == TIPO_REGIMEN_PENSIONARIO_19990){
					
					//Si no existe el concepto calculado en la nomina, agregarlo
					if(!this.existeConceptoCalculado(CONCEPTO_19990, listTNominaConcepto)){

						double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_REGIMEN_PENSIONARIO);
						double totalSNPONP = totalIngresoMensual * porcentaje_snp_onp.getDec_valor_parametro().doubleValue();
						{
							TNominaConcepto tNominaConcepto = new TNominaConcepto();
							tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
							tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_19990);
							tNominaConcepto.setDec_monto_calculado(new BigDecimal(totalSNPONP).setScale(2, RoundingMode.HALF_UP).doubleValue());
							tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
							tNominaConcepto.setTsp_fecha_registro(new Date());
							listTNominaConcepto.add(tNominaConcepto);
						}
					}
					
				}
				
				if(personalNominaQuery.getSrl_id_regimen_pensionario().intValue() == TIPO_REGIMEN_PENSIONARIO_20530){
					
					//Si no existe el concepto calculado en la nomina, agregarlo
					if(!this.existeConceptoCalculado(CONCEPTO_20530, listTNominaConcepto)){
						
						double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_REGIMEN_PENSIONARIO);
						double totalSNPONP = totalIngresoMensual * porcentaje_snp_onp.getDec_valor_parametro().doubleValue();
						{
							TNominaConcepto tNominaConcepto = new TNominaConcepto();
							tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
							tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_20530);
							tNominaConcepto.setDec_monto_calculado(new BigDecimal(totalSNPONP).setScale(2, RoundingMode.HALF_UP).doubleValue());
							tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
							tNominaConcepto.setTsp_fecha_registro(new Date());
							listTNominaConcepto.add(tNominaConcepto);
						}
					}
					
				}
				
				if(personalNominaQuery.getSrl_id_regimen_pensionario().intValue() == TIPO_REGIMEN_PENSIONARIO_AFP){
					
					if(personalNominaQuery.getSrl_id_afp() != null){ // AFP
						
						if(personalNominaQuery.getInt_id_tipo_comision() == null){
							throw new BusinessException("No se tiene definido el tido de comision para la AFP en el personal: " + personalNominaQuery.getNombre_completo());
						}
												
						double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_REGIMEN_PENSIONARIO);
						TAfpComisionExample tAfpComisionExample = new TAfpComisionExample();
						tAfpComisionExample.createCriteria().andSrl_id_afpEqualTo(personalNominaQuery.getSrl_id_afp()).andInt_id_tipo_comisionEqualTo(personalNominaQuery.getInt_id_tipo_comision());
						
						List<TAfpComision> listTAfpComision = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExample);
						TAfpComision tAfpComision = null;
						
						if(!listTAfpComision.isEmpty()){
							tAfpComision = listTAfpComision.get(0);
						}
						
						Double totalAporteObligatorio = totalIngresoMensual * tAfpComision.getDec_aporte().doubleValue();
						Double totalSeguroInvalidez = 0.0;
						if(totalIngresoMensual > tope_afp.getDec_valor_parametro().doubleValue()){
							totalSeguroInvalidez = tope_afp.getDec_valor_parametro().doubleValue() * tAfpComision.getDec_seguro().doubleValue();
						}else{
							totalSeguroInvalidez = totalIngresoMensual * tAfpComision.getDec_seguro().doubleValue();
						}
						Double valComision = (tAfpComision.getDec_comision().doubleValue() * 100)/100;
						Double totalComisionPorcentual = totalIngresoMensual * valComision;
						
						//Si no existe el concepto calculado en la nomina, agregarlo
						if(!this.existeConceptoCalculado(CONCEPTO_APORTE_OBLIGATORIO, listTNominaConcepto)){
							{
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_APORTE_OBLIGATORIO);
								
								
								double num;
								long iPart;
								double fPart;

								// Get user input
								num = totalAporteObligatorio;
								iPart = (long) num;
								fPart = num - iPart;
								
								fPart = this.redondear(fPart, 4);
								fPart = this.redondear(fPart, 2);
								
								totalAporteObligatorio = iPart + fPart;
															
								tNominaConcepto.setDec_monto_calculado(totalAporteObligatorio);
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
							}
						}
						
						
						
						
						Calendar dob = Calendar.getInstance();
						dob.setTime(personalNominaQuery.getFechanacimiento());
						
						/* START DAVID 22-12-2015 */
						
						/*
						Calendar today = Calendar.getInstance();
						int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);						
						if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
						
							age--;
						*/
						
						Integer anio_nacimiento = dob.get(Calendar.YEAR);
						Integer mes_nacimiento = dob.get(Calendar.MONTH) + 1; //Los meses inician en : (enero = 0, febrero = 1, etc)
						
						int age = tAnioPlanilla.getInt_anio() - anio_nacimiento;
						
						age--;						
						
						boolean descSeguroInv = true;
						
						if( (65 - age ) <= 0 ){
							
							descSeguroInv = false;
							
						}else if((65 - age) == 1){
							
							if(mes_nacimiento <= tAnioPeriodoPlanilla.getInt_id_periodo_mes()){
								descSeguroInv = false;
							}
						}
						
						if(descSeguroInv){
						
						//if(age < 65){							
							
						/* END DAVID */							
							{
								//Si no existe el concepto calculado en la nomina, agregarlo
								if(!this.existeConceptoCalculado(CONCEPTO_SEGURO_INVALIDEZ, listTNominaConcepto)){
									TNominaConcepto tNominaConcepto = new TNominaConcepto();
									tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
									tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_SEGURO_INVALIDEZ);
									
									double num;
									long iPart;
									double fPart;

									// Get user input
									num = totalSeguroInvalidez;
									iPart = (long) num;
									fPart = num - iPart;
									
									fPart = this.redondear(fPart, 4);
									fPart = this.redondear(fPart, 2);
									
									totalSeguroInvalidez = iPart + fPart;
																	
									tNominaConcepto.setDec_monto_calculado(new Double(totalSeguroInvalidez));
									
									tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
									tNominaConcepto.setTsp_fecha_registro(new Date());
									listTNominaConcepto.add(tNominaConcepto);
								}
								
							}
						}
						
						{
							//Si no existe el concepto calculado en la nomina, agregarlo
							if(!this.existeConceptoCalculado(CONCEPTO_COMISION_PORCENTUAL, listTNominaConcepto)){
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_COMISION_PORCENTUAL);
								
								double num;
								long iPart;
								double fPart;

								// Get user input
								num = totalComisionPorcentual;
								iPart = (long) num;
								fPart = num - iPart;
								
								fPart = this.redondear(fPart, 4);
								fPart = this.redondear(fPart, 2);
								
								totalComisionPorcentual = iPart + fPart;
								
								
								tNominaConcepto.setDec_monto_calculado(new Double(totalComisionPorcentual));
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
							}
							
						}
						
						
					}
				}
				
			}

		}
		

		
	}
	
	public int getDaysOfMonth(int iYear, int iMonth){
		int iDay = 1;
		Calendar mycal = new GregorianCalendar(iYear, (iMonth-1), iDay);
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return daysInMonth;
	}
	
	public void calcularAportes(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal, List<TNominaConcepto> listTNominaConcepto, TPersonalContrato tPersonalContrato, double totalAcumuladoIngresos, boolean tieneLicMatEnf) throws BusinessException, IOException{
		
		//Aporte ESSALUD		
		double totalIngresoMensual = this.obtenerTotalPorAfectos(listTNominaConcepto, CONCEPTO_TIPO_INGRESO, CONCEPTO_SEGURO_SOCIAL);
		totalIngresoMensual = totalIngresoMensual + totalAcumuladoIngresos;
		double totalAporteEssalud = 0;
		
		if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_728){
			
//			totalAporteEssalud = totalIngresoMensual * porcentaje_essalud.getDec_valor_parametro().doubleValue();
			
			if(totalIngresoMensual <= rmv.getDec_valor_parametro().doubleValue()){
				if(totalIngresoMensual > 0){
					totalAporteEssalud = rmv.getDec_valor_parametro().doubleValue() * porcentaje_essalud.getDec_valor_parametro().doubleValue();
				}
			}else{
				totalAporteEssalud = totalIngresoMensual * porcentaje_essalud.getDec_valor_parametro().doubleValue();
				
			}
			
			//Si no existe el concepto calculado en la nomina, agregarlo
			if(!this.existeConceptoCalculado(CONCEPTO_OBLIGACIONES_EMPLEADOR, listTNominaConcepto)){
				{
					TNominaConcepto tNominaConcepto = new TNominaConcepto();
					tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_OBLIGACIONES_EMPLEADOR);
					tNominaConcepto.setDec_monto_calculado(new Double(totalAporteEssalud));
					tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
					tNominaConcepto.setTsp_fecha_registro(new Date());
					listTNominaConcepto.add(tNominaConcepto);
				}
			}
	
		}else if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
			

			double tope = (uit.getDec_valor_parametro().doubleValue() * porcentaje_uit.getDec_valor_parametro().doubleValue());
			
			/*PARA RECALCULAR EL APORTE CUANDO EL USUARIO CAMBIE EL INGRESO DEL PERSONAL 02-12-2015 DAVID */
			
			List<Integer> listDiasLicenciaEnfermedad = this.calcularDiasLicenciaEnfermedad(tNominaAnioPeriodoPersonal);
			List<Integer> listDiasLicenciaMaternidad = this.calcularDiasLicenciaMaternidad(tNominaAnioPeriodoPersonal);
			
			int cantDias = 0;
			
			for (Integer dias : listDiasLicenciaEnfermedad) {
				
				if(dias.intValue() > 0){					
					cantDias = cantDias + dias.intValue();
				}				
										
			}
			
			
			for (Integer dias : listDiasLicenciaMaternidad) {
				
				if(dias.intValue() > 0){					
					cantDias = cantDias + dias.intValue();
				}				
										
			}
			
			if(cantDias > 0){
				tieneLicMatEnf = true;	
			}
			
			
			/**/			
			
			if(tieneLicMatEnf){
				if(totalIngresoMensual <= tope){
					totalAporteEssalud = totalIngresoMensual * porcentaje_essalud.getDec_valor_parametro().doubleValue();
				}else{					

					totalAporteEssalud = tope * porcentaje_essalud.getDec_valor_parametro().doubleValue();	
					
				}
								
			}else{
				if(totalIngresoMensual <= rmv.getDec_valor_parametro().doubleValue()){
					if(totalIngresoMensual > 0){
						totalAporteEssalud = rmv.getDec_valor_parametro().doubleValue() * porcentaje_essalud.getDec_valor_parametro().doubleValue();
					}
				}else{
					if(totalIngresoMensual <= tope){
						totalAporteEssalud = totalIngresoMensual * porcentaje_essalud.getDec_valor_parametro().doubleValue();
					}else{
						totalAporteEssalud = (uit.getDec_valor_parametro().doubleValue() * porcentaje_uit.getDec_valor_parametro().doubleValue()) * porcentaje_essalud.getDec_valor_parametro().doubleValue();
					}
					
				}	
			}
			
			//Si no existe el concepto calculado en la nomina, agregarlo
			if(!this.existeConceptoCalculado(CONCEPTO_OBLIGACIONES_EMPLEADOR, listTNominaConcepto)){
				{
					TNominaConcepto tNominaConcepto = new TNominaConcepto();
					tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_OBLIGACIONES_EMPLEADOR);
					tNominaConcepto.setDec_monto_calculado(new Double(totalAporteEssalud));
					tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
					tNominaConcepto.setTsp_fecha_registro(new Date());
					listTNominaConcepto.add(tNominaConcepto);
				}
			}
			
		}
	}
	
	public double verificarInicioCeseContratoPorPeriodo(TPersonalContrato tPersonalContrato, double sueldo){
		
		int totalDiasEnElMes = 30;
		
		if(this.getYear(tPersonalContrato.getDte_fec_inicio()) == tAnioPlanilla.getInt_anio().intValue()){
			
			if(this.getMonth(tPersonalContrato.getDte_fec_inicio()) == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()){
				
				Date fechaInicioMes = this.getFirstDate(tAnioPeriodoPlanilla.getInt_id_periodo_mes(), tAnioPlanilla.getInt_anio());
				int diasNoLaborados = this.daysBetween(fechaInicioMes, tPersonalContrato.getDte_fec_inicio());
				int diasLaborados = totalDiasEnElMes - diasNoLaborados;
				
				sueldo = (sueldo / 30) * diasLaborados;
			}
			
		}
		
		Date fechaCese = tPersonalContrato.getDte_fec_cese();
		
		if(fechaCese != null){
			
			int month = this.getMonth(fechaCese);
			int year = this.getYear(fechaCese);
			
			if(month == tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue() && year == tAnioPlanilla.getInt_anio().intValue()){
				int diasLaborados = 0;
				Date fechaIncioMes = this.getFirstDate(month, year);
				
				diasLaborados = this.daysBetween(fechaIncioMes, fechaCese);				
				
				
				if(diasLaborados > 0){
					
					/*18-12-2015 DAVID*/					
					
					//sueldo = (sueldo / 30) * (diasLaborados+1);
					
					diasLaborados++;
					
					if(diasLaborados >= this.getDaysOfMonth(year, month)){
						diasLaborados = 30;						
					}
					
					sueldo = (sueldo / 30) * (diasLaborados);
					
					//END DAVID
				}
				
			}
			
		}
		
		return sueldo;
	}
	
	public double verificarSiTieneLicenciaSGH(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal, double sueldo){
		//899	
		int cantDias = this.calcularDiasLicenciaSinGoceHaber(tNominaAnioPeriodoPersonal);
//		int totalDiasEnElMes = this.getDaysOfMonth(tAnioPlanilla.getInt_anio(), tAnioPeriodoPlanilla.getInt_id_periodo_mes());
//		
//		if(cantDias == totalDiasEnElMes){
//			sueldo = 0;
//		}else{
//			sueldo = (sueldo / 30) * (totalDiasEnElMes-cantDias);
//		}

//		ADD 12-10-2015 DAVID		

		sueldo = sueldo - (sueldo / 30) * (cantDias);

//		sueldo = (sueldo / 30) * (cantDias);
		
		return sueldo;
	}
	
	public void calcularIngresos(Integer srl_id_anio_periodo_planilla, TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal, List<TNominaConcepto> listTNominaConcepto,List<TPersonalConcepto> listTPersonalConcepto, TPersonalContrato tPersonalContrato, PersonalNominaQuery personalNominaQuery, boolean aplicarSueldo){
		
		double sueldo = tPersonalContrato.getNum_sueldo().doubleValue();
		
		int totalDiasEnElMes = 30;
		
		//Verificamos si inicia o cesa su contrato en el mes de proceso
		sueldo = this.verificarInicioCeseContratoPorPeriodo(tPersonalContrato, sueldo);
		
		//Verificamos si en el mes de proceso presenta licencia sin goce de haber
		//ADD 13-10-2015 DAVID
		double sueldoAlterno = 0.0;
		if( tPersonalContrato.getNum_sueldo().doubleValue() > sueldo){
			sueldoAlterno = tPersonalContrato.getNum_sueldo().doubleValue();
		}else{
			sueldoAlterno = sueldo;
		}
		
		sueldoAlterno = this.verificarSiTieneLicenciaSGH(tNominaAnioPeriodoPersonal, sueldoAlterno);
		
		if(sueldoAlterno > 0.0){
			sueldo = sueldo - ( tPersonalContrato.getNum_sueldo().doubleValue() - sueldoAlterno);
		}else{
			sueldo = sueldoAlterno;
		}
//		System.out.println("Sueldo final --> " + sueldo);
//		sueldo = this.verificarSiTieneLicenciaSGH(tNominaAnioPeriodoPersonal, sueldoAlterno);
		
		//END
				
		sueldo = new BigDecimal(sueldo).setScale(0, RoundingMode.HALF_UP).doubleValue();
		
		if(aplicarSueldo){
			
			if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_728){
				{
					//Si no existe el concepto calculado en la nomina, agregarlo
					if(!this.existeConceptoCalculado(CONCEPTO_REMUNERACION, listTNominaConcepto)){
						TNominaConcepto tNominaConcepto = new TNominaConcepto();
						tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
						tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_REMUNERACION);
						tNominaConcepto.setDec_monto_calculado(new Double(sueldo));
						tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
						tNominaConcepto.setTsp_fecha_registro(new Date());
						listTNominaConcepto.add(tNominaConcepto);
					}
				}
			}else if(tPersonalContrato.getSrl_id_regimen_contractual().intValue() == TIPO_REGIMEN_CONTRACTUAL_CAS){
				{
					//Si no existe el concepto calculado en la nomina, agregarlo
					if(!this.existeConceptoCalculado(CONCEPTO_HONORARIO, listTNominaConcepto)){
						TNominaConcepto tNominaConcepto = new TNominaConcepto();
						tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
						tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_HONORARIO);
						tNominaConcepto.setDec_monto_calculado(new Double(sueldo));
						tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
						tNominaConcepto.setTsp_fecha_registro(new Date());
						listTNominaConcepto.add(tNominaConcepto);
					}
				}
			}	
			
		}
				
		for(TPersonalConcepto tPersonalConcepto : listTPersonalConcepto){
			if(tPersonalConcepto.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO){
				if(tPersonalConcepto.getDec_monto_concepto().doubleValue() > 0){
					Integer tipoConcepto = obtenerTipoConcepto(tPersonalConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == CONCEPTO_TIPO_INGRESO){
						
						if(aplicaPeriodo(srl_id_anio_periodo_planilla, tPersonalConcepto.getSrl_id_concepto_planilla(), tPersonalConcepto)){
							
							//Si no existe el concepto calculado en la nomina, agregarlo
							if(!this.existeConceptoCalculado(tPersonalConcepto.getSrl_id_concepto_planilla(), listTNominaConcepto)){
								
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(tPersonalConcepto.getSrl_id_concepto_planilla());
								if(tPersonalConcepto.getInt_id_tipo_monto_concepto().intValue() == TIPO_MONTO_PORCENTUAL){
									tNominaConcepto.setDec_monto_calculado(new Double(tPersonalContrato.getNum_sueldo().doubleValue() * tPersonalConcepto.getDec_monto_concepto().doubleValue()));
								}else{
									tNominaConcepto.setDec_monto_calculado(tPersonalConcepto.getDec_monto_concepto().doubleValue());
								}
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
								
							}
							
						}
						
					}
				}
				
			}
		}
		
		{
			///REINTEGRO
			if(personalNominaQuery.getInt_estado().intValue() == 0){
				
				TPersonalMetaFteFto tPersonalMetaFteFto = this.obtenerMetaFteFto(srl_id_anio_periodo_planilla, personalNominaQuery.getIdpersonal());
				
				TEstadoPersonalExample tEstadoPersonalExample = new TEstadoPersonalExample();
				tEstadoPersonalExample.createCriteria().
				andIdpersonalEqualTo(tNominaAnioPeriodoPersonal.getIdpersonal()).
				andInt_id_estadoEqualTo(1).
				andInt_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue()+1).
				andInt_anioEqualTo(tAnioPlanilla.getInt_anio().intValue()).
				andC_fte_ftoEqualTo(tPersonalMetaFteFto.getC_fte_fto()).
				andC_metaEqualTo(tPersonalMetaFteFto.getC_meta());
				
				tEstadoPersonalExample.setOrderByClause("dte_fecha_estado desc");
				
				
				List<TEstadoPersonal> listTEstadoPersonal = this.selectByExample(TEstadoPersonalMapper.class, tEstadoPersonalExample);
				TEstadoPersonal tEstadoPersonal = null;
				if(!listTEstadoPersonal.isEmpty()){
					tEstadoPersonal = listTEstadoPersonal.get(0);
				}
				
				if(tEstadoPersonal != null){
					TPersonalContrato pc = this.obtenerContrato(tEstadoPersonal.getSrl_id_contrato());
					
					double sueldox = pc.getNum_sueldo().doubleValue();
					
					//int totalDiasEnElMesx = this.getDaysOfMonth(this.getYear(pc.getDte_fec_cese()), this.getMonth(pc.getDte_fec_cese()));
					int totalDiasEnElMesx = 30;
												
					Date fechaInicioMes = this.getFirstDate(this.getMonth(pc.getDte_fec_cese()), this.getYear(pc.getDte_fec_cese()));
								
					int diasLaborados = this.daysBetween(fechaInicioMes, pc.getDte_fec_cese());
					diasLaborados = diasLaborados + 1;
					int diasNoLaborados = totalDiasEnElMes - (diasLaborados + 1);
					
					if(diasNoLaborados == 0){
						diasLaborados = totalDiasEnElMesx;
					}
					
					if(diasLaborados == totalDiasEnElMesx){
						sueldox = 0;
					}else{
						sueldox = (sueldox / 30) * diasLaborados;	
					}
					
					if(sueldox > 0){
						{
							//Si no existe el concepto calculado en la nomina, agregarlo
							if(!this.existeConceptoCalculado(CONCEPTO_REINTEGRO, listTNominaConcepto)){
								TNominaConcepto tNominaConcepto = new TNominaConcepto();
								tNominaConcepto.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
								tNominaConcepto.setSrl_id_concepto_planilla(CONCEPTO_REINTEGRO);
								tNominaConcepto.setDec_monto_calculado(new Double(sueldox));
								tNominaConcepto.setInt_id_estado(TIPO_ESTADO_GENERICO_ACTIVO);
								tNominaConcepto.setTsp_fecha_registro(new Date());
								listTNominaConcepto.add(tNominaConcepto);
							}
							
						}
					}
				}
			}
			
			///
		}
		
		{
			//Vacaciones truncas
			List<TNominaConcepto> vacaciones = this.obtenerVacacionesTruncas(tNominaAnioPeriodoPersonal);
			if(!vacaciones.isEmpty()){
				for (TNominaConcepto tNominaConcepto : vacaciones) {
					listTNominaConcepto.add(tNominaConcepto);
				}
			}
		}
	}
	
	public int obtenerIndexSueldo(List<TNominaConcepto> listTNominaConcepto){
		
		for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
			if(tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_ACTIVO || tNominaConcepto.getInt_id_estado().intValue() == TIPO_ESTADO_CONCEPTO_MODIFICADO){
				if(tNominaConcepto.getSrl_id_concepto_planilla().intValue() == CONCEPTO_HONORARIO || tNominaConcepto.getSrl_id_concepto_planilla().intValue() == CONCEPTO_REMUNERACION){
					return listTNominaConcepto.indexOf(tNominaConcepto);
				}
			}
		}
		
		return -1;
	}
	
	public int daysBetween(Date d1, Date d2) {
		
		String f1 = this.dateToString(d1);
		String f2 = this.dateToString(d2);
		
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		
		try {
			
			date = sdf.parse(f1);
			cal1.setTime(date);
			
			date = sdf.parse(f2);
			cal2.setTime(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return this.diasTranscurridosEntre(cal1.getTime(), cal2.getTime());
	}
	
	public String dateToString(Date date){

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String reportDate = df.format(date);
		
		return reportDate;
	}
	
	public int diasTranscurridosEntre(Date fechaDesde, Date fechaHasta) {
		 long diff = fechaHasta.getTime() - fechaDesde.getTime();
		 long dias = diff / (1000 * 60 * 60 * 24);
		 return (int) dias;
	}
	
	public Date addDays(Date dt, int numDays){
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, numDays);
		Date d = c.getTime();
		return d;
	}
	
	public double redondear( Double numero, int decimales ) {
	    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
	}
	
	public Double truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR).doubleValue();
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING).doubleValue();
	    }
	}
	
	public <T> T getRecord(List<T> list){
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public boolean existeConceptoCalculado(Integer srl_id_concepto_planilla, List<TNominaConcepto> listTNominaConcepto){
		for(TNominaConcepto obj : listTNominaConcepto){
			if(obj.getSrl_id_concepto_planilla().intValue() == srl_id_concepto_planilla.intValue()){
				return true;
			}
		}
		return false;
	}

	
	@Transactional
	@Override
	public void procesarMarcaciones(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal) throws BusinessException, IOException {
		
		if(tAnioPlanilla == null){
			this.precargarInfo(srl_id_anio_periodo_planilla);
		}else{
			if(!tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla().equals(srl_id_anio_periodo_planilla)){
				this.precargarInfo(srl_id_anio_periodo_planilla);
			}
		}
		
		if(tAnioPlanilla.getInt_id_estado() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El Año seleccionado no esta activo.");
		}
		
		if(tAnioPeriodoPlanilla.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El periodo seleccionado no esta activo.");
		}
			    
	    TNominaAnioPeriodoPersonalExample example = new TNominaAnioPeriodoPersonalExample();
		
		if(idpersonal != null){
			example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).andSrl_id_regimen_contractualEqualTo(srl_id_regimen_contractual).andIdpersonalEqualTo(idpersonal);
		}else{
			example.createCriteria().andSrl_id_anio_periodo_planillaEqualTo(srl_id_anio_periodo_planilla).andSrl_id_regimen_contractualEqualTo(srl_id_regimen_contractual);
		}
		
		List<TNominaAnioPeriodoPersonal> listTNominaAnioPeriodoPersonal = this.selectByExample(TNominaAnioPeriodoPersonalMapper.class, example);
		
		for(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal : listTNominaAnioPeriodoPersonal){
						
			TPersonalMetaFteFto tPersonalMetaFteFto = this.obtenerMetaFteFto(srl_id_anio_periodo_planilla, tNominaAnioPeriodoPersonal.getIdpersonal());
			
			if(tNominaAnioPeriodoPersonal.getC_fte_fto().equals(tPersonalMetaFteFto.getC_fte_fto()) && tNominaAnioPeriodoPersonal.getC_meta().equals(tPersonalMetaFteFto.getC_meta())){
				
				List<TNominaConcepto> listTNominaConcepto = new ArrayList<TNominaConcepto>();
				
				//Marcaciones
				this.calcularTardanzasyOtrosAlterno(tNominaAnioPeriodoPersonal, listTNominaConcepto);
				
				TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
				tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				
				listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
				
				double totalIngresos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_INGRESO);
				double totalDescuentos = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_DESCUENTO);
				double totalAportes = this.obtenerTotalPorTipoConcepto(listTNominaConcepto, CONCEPTO_TIPO_APORTE);
				double totalNeto = totalIngresos-totalDescuentos;
				
				tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
				tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
				tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
				tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalNeto));
				
				this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
			}
			
		}
	    
	}
	
}
