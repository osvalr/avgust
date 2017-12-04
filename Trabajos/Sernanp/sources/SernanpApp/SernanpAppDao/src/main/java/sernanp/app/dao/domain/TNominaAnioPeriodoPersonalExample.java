package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TNominaAnioPeriodoPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNominaAnioPeriodoPersonalExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalIsNull() {
            addCriterion("srl_id_nomina_anio_periodo_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalIsNotNull() {
            addCriterion("srl_id_nomina_anio_periodo_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalEqualTo(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal =", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal <>", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalGreaterThan(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal >", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal >=", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalLessThan(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal <", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nomina_anio_periodo_personal <=", value, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalIn(List<Integer> values) {
            addCriterion("srl_id_nomina_anio_periodo_personal in", values, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_nomina_anio_periodo_personal not in", values, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nomina_anio_periodo_personal between", value1, value2, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nomina_anio_periodo_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nomina_anio_periodo_personal not between", value1, value2, "srl_id_nomina_anio_periodo_personal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNull() {
            addCriterion("idpersonal is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNotNull() {
            addCriterion("idpersonal is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalEqualTo(Integer value) {
            addCriterion("idpersonal =", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotEqualTo(Integer value) {
            addCriterion("idpersonal <>", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThan(Integer value) {
            addCriterion("idpersonal >", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonal >=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThan(Integer value) {
            addCriterion("idpersonal <", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonal <=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIn(List<Integer> values) {
            addCriterion("idpersonal in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotIn(List<Integer> values) {
            addCriterion("idpersonal not in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal not between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoIsNull() {
            addCriterion("srl_id_contrato is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoIsNotNull() {
            addCriterion("srl_id_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoEqualTo(Integer value) {
            addCriterion("srl_id_contrato =", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotEqualTo(Integer value) {
            addCriterion("srl_id_contrato <>", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoGreaterThan(Integer value) {
            addCriterion("srl_id_contrato >", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato >=", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoLessThan(Integer value) {
            addCriterion("srl_id_contrato <", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato <=", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoIn(List<Integer> values) {
            addCriterion("srl_id_contrato in", values, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotIn(List<Integer> values) {
            addCriterion("srl_id_contrato not in", values, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato between", value1, value2, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato not between", value1, value2, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaIsNull() {
            addCriterion("srl_id_anio_periodo_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaIsNotNull() {
            addCriterion("srl_id_anio_periodo_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaEqualTo(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla =", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla <>", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla >", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla >=", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaLessThan(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla <", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_periodo_planilla <=", value, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaIn(List<Integer> values) {
            addCriterion("srl_id_anio_periodo_planilla in", values, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_anio_periodo_planilla not in", values, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_periodo_planilla between", value1, value2, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_periodo_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_periodo_planilla not between", value1, value2, "srl_id_anio_periodo_planilla");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNull() {
            addCriterion("int_id_estado is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNotNull() {
            addCriterion("int_id_estado is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoEqualTo(Integer value) {
            addCriterion("int_id_estado =", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotEqualTo(Integer value) {
            addCriterion("int_id_estado <>", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThan(Integer value) {
            addCriterion("int_id_estado >", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado >=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThan(Integer value) {
            addCriterion("int_id_estado <", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado <=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIn(List<Integer> values) {
            addCriterion("int_id_estado in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotIn(List<Integer> values) {
            addCriterion("int_id_estado not in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado not between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosIsNull() {
            addCriterion("dec_total_ingresos is null");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosIsNotNull() {
            addCriterion("dec_total_ingresos is not null");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosEqualTo(BigDecimal value) {
            addCriterion("dec_total_ingresos =", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosNotEqualTo(BigDecimal value) {
            addCriterion("dec_total_ingresos <>", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosGreaterThan(BigDecimal value) {
            addCriterion("dec_total_ingresos >", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_ingresos >=", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosLessThan(BigDecimal value) {
            addCriterion("dec_total_ingresos <", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_ingresos <=", value, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosIn(List<BigDecimal> values) {
            addCriterion("dec_total_ingresos in", values, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosNotIn(List<BigDecimal> values) {
            addCriterion("dec_total_ingresos not in", values, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_ingresos between", value1, value2, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_ingresosNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_ingresos not between", value1, value2, "dec_total_ingresos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosIsNull() {
            addCriterion("dec_total_descuentos is null");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosIsNotNull() {
            addCriterion("dec_total_descuentos is not null");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosEqualTo(BigDecimal value) {
            addCriterion("dec_total_descuentos =", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosNotEqualTo(BigDecimal value) {
            addCriterion("dec_total_descuentos <>", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosGreaterThan(BigDecimal value) {
            addCriterion("dec_total_descuentos >", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_descuentos >=", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosLessThan(BigDecimal value) {
            addCriterion("dec_total_descuentos <", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_descuentos <=", value, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosIn(List<BigDecimal> values) {
            addCriterion("dec_total_descuentos in", values, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosNotIn(List<BigDecimal> values) {
            addCriterion("dec_total_descuentos not in", values, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_descuentos between", value1, value2, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_descuentosNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_descuentos not between", value1, value2, "dec_total_descuentos");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesIsNull() {
            addCriterion("dec_total_aportes is null");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesIsNotNull() {
            addCriterion("dec_total_aportes is not null");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesEqualTo(BigDecimal value) {
            addCriterion("dec_total_aportes =", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesNotEqualTo(BigDecimal value) {
            addCriterion("dec_total_aportes <>", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesGreaterThan(BigDecimal value) {
            addCriterion("dec_total_aportes >", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_aportes >=", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesLessThan(BigDecimal value) {
            addCriterion("dec_total_aportes <", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_aportes <=", value, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesIn(List<BigDecimal> values) {
            addCriterion("dec_total_aportes in", values, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesNotIn(List<BigDecimal> values) {
            addCriterion("dec_total_aportes not in", values, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_aportes between", value1, value2, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_aportesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_aportes not between", value1, value2, "dec_total_aportes");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoIsNull() {
            addCriterion("dec_total_neto is null");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoIsNotNull() {
            addCriterion("dec_total_neto is not null");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoEqualTo(BigDecimal value) {
            addCriterion("dec_total_neto =", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoNotEqualTo(BigDecimal value) {
            addCriterion("dec_total_neto <>", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoGreaterThan(BigDecimal value) {
            addCriterion("dec_total_neto >", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_neto >=", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoLessThan(BigDecimal value) {
            addCriterion("dec_total_neto <", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_total_neto <=", value, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoIn(List<BigDecimal> values) {
            addCriterion("dec_total_neto in", values, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoNotIn(List<BigDecimal> values) {
            addCriterion("dec_total_neto not in", values, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_neto between", value1, value2, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andDec_total_netoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_total_neto not between", value1, value2, "dec_total_neto");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNull() {
            addCriterion("tsp_fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNotNull() {
            addCriterion("tsp_fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroEqualTo(Date value) {
            addCriterion("tsp_fecha_registro =", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <>", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThan(Date value) {
            addCriterion("tsp_fecha_registro >", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro >=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThan(Date value) {
            addCriterion("tsp_fecha_registro <", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIn(List<Date> values) {
            addCriterion("tsp_fecha_registro in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotIn(List<Date> values) {
            addCriterion("tsp_fecha_registro not in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro between", value1, value2, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro not between", value1, value2, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andC_metaIsNull() {
            addCriterion("c_meta is null");
            return (Criteria) this;
        }

        public Criteria andC_metaIsNotNull() {
            addCriterion("c_meta is not null");
            return (Criteria) this;
        }

        public Criteria andC_metaEqualTo(String value) {
            addCriterion("c_meta =", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaNotEqualTo(String value) {
            addCriterion("c_meta <>", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaGreaterThan(String value) {
            addCriterion("c_meta >", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaGreaterThanOrEqualTo(String value) {
            addCriterion("c_meta >=", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaLessThan(String value) {
            addCriterion("c_meta <", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaLessThanOrEqualTo(String value) {
            addCriterion("c_meta <=", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaLike(String value) {
            addCriterion("c_meta like", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaNotLike(String value) {
            addCriterion("c_meta not like", value, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaIn(List<String> values) {
            addCriterion("c_meta in", values, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaNotIn(List<String> values) {
            addCriterion("c_meta not in", values, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaBetween(String value1, String value2) {
            addCriterion("c_meta between", value1, value2, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_metaNotBetween(String value1, String value2) {
            addCriterion("c_meta not between", value1, value2, "c_meta");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoIsNull() {
            addCriterion("c_fte_fto is null");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoIsNotNull() {
            addCriterion("c_fte_fto is not null");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoEqualTo(String value) {
            addCriterion("c_fte_fto =", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoNotEqualTo(String value) {
            addCriterion("c_fte_fto <>", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoGreaterThan(String value) {
            addCriterion("c_fte_fto >", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoGreaterThanOrEqualTo(String value) {
            addCriterion("c_fte_fto >=", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoLessThan(String value) {
            addCriterion("c_fte_fto <", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoLessThanOrEqualTo(String value) {
            addCriterion("c_fte_fto <=", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoLike(String value) {
            addCriterion("c_fte_fto like", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoNotLike(String value) {
            addCriterion("c_fte_fto not like", value, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoIn(List<String> values) {
            addCriterion("c_fte_fto in", values, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoNotIn(List<String> values) {
            addCriterion("c_fte_fto not in", values, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoBetween(String value1, String value2) {
            addCriterion("c_fte_fto between", value1, value2, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andC_fte_ftoNotBetween(String value1, String value2) {
            addCriterion("c_fte_fto not between", value1, value2, "c_fte_fto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNull() {
            addCriterion("srl_id_regimen_contractual is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNotNull() {
            addCriterion("srl_id_regimen_contractual is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual =", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <>", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_contractual >", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual >=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThan(Integer value) {
            addCriterion("srl_id_regimen_contractual <", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual not in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual not between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroIsNull() {
            addCriterion("int_id_tipo_registro is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroIsNotNull() {
            addCriterion("int_id_tipo_registro is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroEqualTo(Integer value) {
            addCriterion("int_id_tipo_registro =", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_registro <>", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroGreaterThan(Integer value) {
            addCriterion("int_id_tipo_registro >", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_registro >=", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroLessThan(Integer value) {
            addCriterion("int_id_tipo_registro <", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_registro <=", value, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroIn(List<Integer> values) {
            addCriterion("int_id_tipo_registro in", values, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_registro not in", values, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_registro between", value1, value2, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_registroNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_registro not between", value1, value2, "int_id_tipo_registro");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNull() {
            addCriterion("idpersonanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNotNull() {
            addCriterion("idpersonanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalEqualTo(Integer value) {
            addCriterion("idpersonanatural =", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotEqualTo(Integer value) {
            addCriterion("idpersonanatural <>", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThan(Integer value) {
            addCriterion("idpersonanatural >", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural >=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThan(Integer value) {
            addCriterion("idpersonanatural <", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural <=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIn(List<Integer> values) {
            addCriterion("idpersonanatural in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotIn(List<Integer> values) {
            addCriterion("idpersonanatural not in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural not between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIsNull() {
            addCriterion("srl_id_regimen_pensionario is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIsNotNull() {
            addCriterion("srl_id_regimen_pensionario is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario =", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <>", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario >", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario >=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario <", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario not in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario between", value1, value2, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario not between", value1, value2, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIsNull() {
            addCriterion("var_ubicacion_fisica is null");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIsNotNull() {
            addCriterion("var_ubicacion_fisica is not null");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaEqualTo(String value) {
            addCriterion("var_ubicacion_fisica =", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotEqualTo(String value) {
            addCriterion("var_ubicacion_fisica <>", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaGreaterThan(String value) {
            addCriterion("var_ubicacion_fisica >", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaGreaterThanOrEqualTo(String value) {
            addCriterion("var_ubicacion_fisica >=", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLessThan(String value) {
            addCriterion("var_ubicacion_fisica <", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLessThanOrEqualTo(String value) {
            addCriterion("var_ubicacion_fisica <=", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLike(String value) {
            addCriterion("var_ubicacion_fisica like", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotLike(String value) {
            addCriterion("var_ubicacion_fisica not like", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIn(List<String> values) {
            addCriterion("var_ubicacion_fisica in", values, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotIn(List<String> values) {
            addCriterion("var_ubicacion_fisica not in", values, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaBetween(String value1, String value2) {
            addCriterion("var_ubicacion_fisica between", value1, value2, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotBetween(String value1, String value2) {
            addCriterion("var_ubicacion_fisica not between", value1, value2, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNull() {
            addCriterion("srl_id_afp is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNotNull() {
            addCriterion("srl_id_afp is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpEqualTo(Integer value) {
            addCriterion("srl_id_afp =", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotEqualTo(Integer value) {
            addCriterion("srl_id_afp <>", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThan(Integer value) {
            addCriterion("srl_id_afp >", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp >=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThan(Integer value) {
            addCriterion("srl_id_afp <", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp <=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIn(List<Integer> values) {
            addCriterion("srl_id_afp in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotIn(List<Integer> values) {
            addCriterion("srl_id_afp not in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp not between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNull() {
            addCriterion("int_id_tipo_comision is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNotNull() {
            addCriterion("int_id_tipo_comision is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision =", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <>", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThan(Integer value) {
            addCriterion("int_id_tipo_comision >", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision >=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThan(Integer value) {
            addCriterion("int_id_tipo_comision <", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision not in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision between", value1, value2, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision not between", value1, value2, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNull() {
            addCriterion("srl_id_entidad_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNotNull() {
            addCriterion("srl_id_entidad_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria =", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <>", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria >", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria >=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria <", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria not in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria not between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNull() {
            addCriterion("var_numero_cuenta_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNotNull() {
            addCriterion("var_numero_cuenta_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria =", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <>", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThan(String value) {
            addCriterion("var_numero_cuenta_bancaria >", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria >=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThan(String value) {
            addCriterion("var_numero_cuenta_bancaria <", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLike(String value) {
            addCriterion("var_numero_cuenta_bancaria like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotLike(String value) {
            addCriterion("var_numero_cuenta_bancaria not like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria not in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria between", value1, value2, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria not between", value1, value2, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}