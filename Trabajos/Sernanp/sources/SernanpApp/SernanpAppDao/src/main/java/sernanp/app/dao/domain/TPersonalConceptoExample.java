package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPersonalConceptoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalConceptoExample() {
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

        public Criteria andSrl_id_personal_conceptoIsNull() {
            addCriterion("srl_id_personal_concepto is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoIsNotNull() {
            addCriterion("srl_id_personal_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoEqualTo(Integer value) {
            addCriterion("srl_id_personal_concepto =", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoNotEqualTo(Integer value) {
            addCriterion("srl_id_personal_concepto <>", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoGreaterThan(Integer value) {
            addCriterion("srl_id_personal_concepto >", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personal_concepto >=", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoLessThan(Integer value) {
            addCriterion("srl_id_personal_concepto <", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personal_concepto <=", value, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoIn(List<Integer> values) {
            addCriterion("srl_id_personal_concepto in", values, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoNotIn(List<Integer> values) {
            addCriterion("srl_id_personal_concepto not in", values, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personal_concepto between", value1, value2, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personal_concepto not between", value1, value2, "srl_id_personal_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialIsNull() {
            addCriterion("srl_id_beneficiario_descuento_judicial is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialIsNotNull() {
            addCriterion("srl_id_beneficiario_descuento_judicial is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial =", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <>", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialGreaterThan(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial >", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial >=", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialLessThan(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <=", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialIn(List<Integer> values) {
            addCriterion("srl_id_beneficiario_descuento_judicial in", values, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotIn(List<Integer> values) {
            addCriterion("srl_id_beneficiario_descuento_judicial not in", values, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_beneficiario_descuento_judicial between", value1, value2, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_beneficiario_descuento_judicial not between", value1, value2, "srl_id_beneficiario_descuento_judicial");
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

        public Criteria andSrl_id_concepto_planillaIsNull() {
            addCriterion("srl_id_concepto_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaIsNotNull() {
            addCriterion("srl_id_concepto_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla =", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla <>", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_concepto_planilla >", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla >=", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaLessThan(Integer value) {
            addCriterion("srl_id_concepto_planilla <", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla <=", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaIn(List<Integer> values) {
            addCriterion("srl_id_concepto_planilla in", values, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_concepto_planilla not in", values, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_concepto_planilla between", value1, value2, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_concepto_planilla not between", value1, value2, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIsNull() {
            addCriterion("dec_monto_concepto is null");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIsNotNull() {
            addCriterion("dec_monto_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto =", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto <>", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoGreaterThan(BigDecimal value) {
            addCriterion("dec_monto_concepto >", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto >=", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoLessThan(BigDecimal value) {
            addCriterion("dec_monto_concepto <", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto <=", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIn(List<BigDecimal> values) {
            addCriterion("dec_monto_concepto in", values, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotIn(List<BigDecimal> values) {
            addCriterion("dec_monto_concepto not in", values, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_monto_concepto between", value1, value2, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_monto_concepto not between", value1, value2, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIsNull() {
            addCriterion("int_id_tipo_monto_concepto is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIsNotNull() {
            addCriterion("int_id_tipo_monto_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto =", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <>", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_monto_concepto >", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto >=", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoLessThan(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <=", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIn(List<Integer> values) {
            addCriterion("int_id_tipo_monto_concepto in", values, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_monto_concepto not in", values, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_monto_concepto between", value1, value2, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_monto_concepto not between", value1, value2, "int_id_tipo_monto_concepto");
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

        public Criteria andInt_aplica_afectosIsNull() {
            addCriterion("int_aplica_afectos is null");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosIsNotNull() {
            addCriterion("int_aplica_afectos is not null");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosEqualTo(Integer value) {
            addCriterion("int_aplica_afectos =", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosNotEqualTo(Integer value) {
            addCriterion("int_aplica_afectos <>", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosGreaterThan(Integer value) {
            addCriterion("int_aplica_afectos >", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_aplica_afectos >=", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosLessThan(Integer value) {
            addCriterion("int_aplica_afectos <", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosLessThanOrEqualTo(Integer value) {
            addCriterion("int_aplica_afectos <=", value, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosIn(List<Integer> values) {
            addCriterion("int_aplica_afectos in", values, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosNotIn(List<Integer> values) {
            addCriterion("int_aplica_afectos not in", values, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosBetween(Integer value1, Integer value2) {
            addCriterion("int_aplica_afectos between", value1, value2, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_afectosNotBetween(Integer value1, Integer value2) {
            addCriterion("int_aplica_afectos not between", value1, value2, "int_aplica_afectos");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasIsNull() {
            addCriterion("int_aplica_frecuencias is null");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasIsNotNull() {
            addCriterion("int_aplica_frecuencias is not null");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasEqualTo(Integer value) {
            addCriterion("int_aplica_frecuencias =", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasNotEqualTo(Integer value) {
            addCriterion("int_aplica_frecuencias <>", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasGreaterThan(Integer value) {
            addCriterion("int_aplica_frecuencias >", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_aplica_frecuencias >=", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasLessThan(Integer value) {
            addCriterion("int_aplica_frecuencias <", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasLessThanOrEqualTo(Integer value) {
            addCriterion("int_aplica_frecuencias <=", value, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasIn(List<Integer> values) {
            addCriterion("int_aplica_frecuencias in", values, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasNotIn(List<Integer> values) {
            addCriterion("int_aplica_frecuencias not in", values, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasBetween(Integer value1, Integer value2) {
            addCriterion("int_aplica_frecuencias between", value1, value2, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andInt_aplica_frecuenciasNotBetween(Integer value1, Integer value2) {
            addCriterion("int_aplica_frecuencias not between", value1, value2, "int_aplica_frecuencias");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIsNull() {
            addCriterion("srl_id_anio_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIsNotNull() {
            addCriterion("srl_id_anio_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla =", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <>", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_anio_planilla >", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla >=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThan(Integer value) {
            addCriterion("srl_id_anio_planilla <", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla not in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla between", value1, value2, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla not between", value1, value2, "srl_id_anio_planilla");
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