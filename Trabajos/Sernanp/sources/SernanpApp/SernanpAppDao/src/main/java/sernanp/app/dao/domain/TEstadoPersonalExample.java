package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TEstadoPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEstadoPersonalExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSrl_id_estado_personalIsNull() {
            addCriterion("srl_id_estado_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalIsNotNull() {
            addCriterion("srl_id_estado_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalEqualTo(Integer value) {
            addCriterion("srl_id_estado_personal =", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_estado_personal <>", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalGreaterThan(Integer value) {
            addCriterion("srl_id_estado_personal >", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_estado_personal >=", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalLessThan(Integer value) {
            addCriterion("srl_id_estado_personal <", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_estado_personal <=", value, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalIn(List<Integer> values) {
            addCriterion("srl_id_estado_personal in", values, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_estado_personal not in", values, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_estado_personal between", value1, value2, "srl_id_estado_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_estado_personal not between", value1, value2, "srl_id_estado_personal");
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

        public Criteria andVar_motivoIsNull() {
            addCriterion("var_motivo is null");
            return (Criteria) this;
        }

        public Criteria andVar_motivoIsNotNull() {
            addCriterion("var_motivo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_motivoEqualTo(String value) {
            addCriterion("var_motivo =", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoNotEqualTo(String value) {
            addCriterion("var_motivo <>", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoGreaterThan(String value) {
            addCriterion("var_motivo >", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoGreaterThanOrEqualTo(String value) {
            addCriterion("var_motivo >=", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoLessThan(String value) {
            addCriterion("var_motivo <", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoLessThanOrEqualTo(String value) {
            addCriterion("var_motivo <=", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoLike(String value) {
            addCriterion("var_motivo like", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoNotLike(String value) {
            addCriterion("var_motivo not like", value, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoIn(List<String> values) {
            addCriterion("var_motivo in", values, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoNotIn(List<String> values) {
            addCriterion("var_motivo not in", values, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoBetween(String value1, String value2) {
            addCriterion("var_motivo between", value1, value2, "var_motivo");
            return (Criteria) this;
        }

        public Criteria andVar_motivoNotBetween(String value1, String value2) {
            addCriterion("var_motivo not between", value1, value2, "var_motivo");
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

        public Criteria andInt_id_tipificacionIsNull() {
            addCriterion("int_id_tipificacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionIsNotNull() {
            addCriterion("int_id_tipificacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionEqualTo(Integer value) {
            addCriterion("int_id_tipificacion =", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionNotEqualTo(Integer value) {
            addCriterion("int_id_tipificacion <>", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionGreaterThan(Integer value) {
            addCriterion("int_id_tipificacion >", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipificacion >=", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionLessThan(Integer value) {
            addCriterion("int_id_tipificacion <", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipificacion <=", value, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionIn(List<Integer> values) {
            addCriterion("int_id_tipificacion in", values, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionNotIn(List<Integer> values) {
            addCriterion("int_id_tipificacion not in", values, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipificacion between", value1, value2, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipificacion not between", value1, value2, "int_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoIsNull() {
            addCriterion("dte_fecha_estado is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoIsNotNull() {
            addCriterion("dte_fecha_estado is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado =", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado <>", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado >", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado >=", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado <", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_estado <=", value, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_estado in", values, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_estado not in", values, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_estado between", value1, value2, "dte_fecha_estado");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_estadoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_estado not between", value1, value2, "dte_fecha_estado");
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

        public Criteria andInt_anioIsNull() {
            addCriterion("int_anio is null");
            return (Criteria) this;
        }

        public Criteria andInt_anioIsNotNull() {
            addCriterion("int_anio is not null");
            return (Criteria) this;
        }

        public Criteria andInt_anioEqualTo(Integer value) {
            addCriterion("int_anio =", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotEqualTo(Integer value) {
            addCriterion("int_anio <>", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioGreaterThan(Integer value) {
            addCriterion("int_anio >", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_anio >=", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioLessThan(Integer value) {
            addCriterion("int_anio <", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioLessThanOrEqualTo(Integer value) {
            addCriterion("int_anio <=", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioIn(List<Integer> values) {
            addCriterion("int_anio in", values, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotIn(List<Integer> values) {
            addCriterion("int_anio not in", values, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioBetween(Integer value1, Integer value2) {
            addCriterion("int_anio between", value1, value2, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotBetween(Integer value1, Integer value2) {
            addCriterion("int_anio not between", value1, value2, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_mesIsNull() {
            addCriterion("int_mes is null");
            return (Criteria) this;
        }

        public Criteria andInt_mesIsNotNull() {
            addCriterion("int_mes is not null");
            return (Criteria) this;
        }

        public Criteria andInt_mesEqualTo(Integer value) {
            addCriterion("int_mes =", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotEqualTo(Integer value) {
            addCriterion("int_mes <>", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesGreaterThan(Integer value) {
            addCriterion("int_mes >", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_mes >=", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesLessThan(Integer value) {
            addCriterion("int_mes <", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesLessThanOrEqualTo(Integer value) {
            addCriterion("int_mes <=", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesIn(List<Integer> values) {
            addCriterion("int_mes in", values, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotIn(List<Integer> values) {
            addCriterion("int_mes not in", values, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesBetween(Integer value1, Integer value2) {
            addCriterion("int_mes between", value1, value2, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotBetween(Integer value1, Integer value2) {
            addCriterion("int_mes not between", value1, value2, "int_mes");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasIsNull() {
            addCriterion("dec_dias_vac_truncas is null");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasIsNotNull() {
            addCriterion("dec_dias_vac_truncas is not null");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasEqualTo(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas =", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasNotEqualTo(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas <>", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasGreaterThan(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas >", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas >=", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasLessThan(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas <", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_dias_vac_truncas <=", value, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasIn(List<BigDecimal> values) {
            addCriterion("dec_dias_vac_truncas in", values, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasNotIn(List<BigDecimal> values) {
            addCriterion("dec_dias_vac_truncas not in", values, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_dias_vac_truncas between", value1, value2, "dec_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andDec_dias_vac_truncasNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_dias_vac_truncas not between", value1, value2, "dec_dias_vac_truncas");
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