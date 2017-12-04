package sernanp.app.business.core.planilla.service;

import java.io.IOException;
import java.util.List;

import sernanp.app.dao.domain.TConceptoPlanilla;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonal;
import sernanp.app.dao.domain.TNominaConcepto;
import sernanp.app.dao.domain.TPersonalConcepto;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalMetaFteFto;
import sernanp.app.dao.query.domain.PersonalContratoNominaQuery;
import sernanp.app.dao.query.domain.PersonalNominaQuery;
import sernanp.app.dao.query.domain.SubsidiosPersonal;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface ProcesoNominaService extends HelperServiceMybatis {
	
	void procesarNomina(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException;
	void procesarNominaPersonal(Integer srl_id_anio_periodo_planilla, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException;
	Integer obtenerTipoConcepto(Integer srl_id_concepto_planilla) throws BusinessException;
	TConceptoPlanilla obtenerConcepto(Integer srl_id_concepto_planilla) throws BusinessException;
	void procesarLicencias(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal, Integer int_id_estado) throws BusinessException, IOException;
	void procesarMarcaciones(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer idpersonal) throws BusinessException, IOException;
	int calcularDiasNoLaboradosMes(SubsidiosPersonal subsidiosPersonal);
	void precargarInfo(Integer srl_id_anio_periodo_planilla);
	List<Integer> calcularDiasLicenciaMaternidad(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal);
	List<Integer> calcularDiasLicenciaEnfermedad(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal);
	PersonalNominaQuery obtenerInfoPersonal(Integer idpersonal);
	PersonalContratoNominaQuery obtenerInfoContrato(Integer idpersonal);
	void calcularAportes(TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal, List<TNominaConcepto> listTNominaConcepto, TPersonalContrato tPersonalContrato, double totalAcumuladoIngresos, boolean tieneLicMatEnf) throws BusinessException, IOException;
	void calcularDescuentos(Integer srl_id_anio_periodo_planilla,List<TPersonalConcepto> listTPersonalConcepto,TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal,List<TNominaConcepto> listTNominaConcepto,TPersonalContrato tPersonalContrato,PersonalNominaQuery personalNominaQuery,Integer int_id_estado) throws BusinessException, IOException;
	TPersonalMetaFteFto obtenerMetaFteFto(Integer srl_id_anio_periodo_planilla, Integer idpesonal);
	TPersonalMetaFteFto obtenerMetaFteFtoAlterno(Integer srl_id_anio_planilla, Integer idpesonal);
	TPersonalContrato obtenerContrato(Integer srl_id_contrato);
	void procesarNominaPersonalAlterno(Integer srl_id_anio_periodo_planilla, Integer idpersonal) throws BusinessException, IOException;

}
