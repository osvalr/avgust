package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TRequerimientoPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRequerimientoPersonalExample() {
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

        public Criteria andSrl_id_requerimiento_personalIsNull() {
            addCriterion("srl_id_requerimiento_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalIsNotNull() {
            addCriterion("srl_id_requerimiento_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal =", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal <>", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalGreaterThan(Integer value) {
            addCriterion("srl_id_requerimiento_personal >", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal >=", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalLessThan(Integer value) {
            addCriterion("srl_id_requerimiento_personal <", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal <=", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalIn(List<Integer> values) {
            addCriterion("srl_id_requerimiento_personal in", values, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_requerimiento_personal not in", values, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_requerimiento_personal between", value1, value2, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_requerimiento_personal not between", value1, value2, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteIsNull() {
            addCriterion("idarea_solicitante is null");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteIsNotNull() {
            addCriterion("idarea_solicitante is not null");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteEqualTo(Integer value) {
            addCriterion("idarea_solicitante =", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteNotEqualTo(Integer value) {
            addCriterion("idarea_solicitante <>", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteGreaterThan(Integer value) {
            addCriterion("idarea_solicitante >", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteGreaterThanOrEqualTo(Integer value) {
            addCriterion("idarea_solicitante >=", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteLessThan(Integer value) {
            addCriterion("idarea_solicitante <", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteLessThanOrEqualTo(Integer value) {
            addCriterion("idarea_solicitante <=", value, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteIn(List<Integer> values) {
            addCriterion("idarea_solicitante in", values, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteNotIn(List<Integer> values) {
            addCriterion("idarea_solicitante not in", values, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteBetween(Integer value1, Integer value2) {
            addCriterion("idarea_solicitante between", value1, value2, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_solicitanteNotBetween(Integer value1, Integer value2) {
            addCriterion("idarea_solicitante not between", value1, value2, "idarea_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteIsNull() {
            addCriterion("idunidad_solicitante is null");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteIsNotNull() {
            addCriterion("idunidad_solicitante is not null");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteEqualTo(Integer value) {
            addCriterion("idunidad_solicitante =", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteNotEqualTo(Integer value) {
            addCriterion("idunidad_solicitante <>", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteGreaterThan(Integer value) {
            addCriterion("idunidad_solicitante >", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteGreaterThanOrEqualTo(Integer value) {
            addCriterion("idunidad_solicitante >=", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteLessThan(Integer value) {
            addCriterion("idunidad_solicitante <", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteLessThanOrEqualTo(Integer value) {
            addCriterion("idunidad_solicitante <=", value, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteIn(List<Integer> values) {
            addCriterion("idunidad_solicitante in", values, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteNotIn(List<Integer> values) {
            addCriterion("idunidad_solicitante not in", values, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteBetween(Integer value1, Integer value2) {
            addCriterion("idunidad_solicitante between", value1, value2, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdunidad_solicitanteNotBetween(Integer value1, Integer value2) {
            addCriterion("idunidad_solicitante not between", value1, value2, "idunidad_solicitante");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraIsNull() {
            addCriterion("idarea_supervisora is null");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraIsNotNull() {
            addCriterion("idarea_supervisora is not null");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraEqualTo(Integer value) {
            addCriterion("idarea_supervisora =", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraNotEqualTo(Integer value) {
            addCriterion("idarea_supervisora <>", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraGreaterThan(Integer value) {
            addCriterion("idarea_supervisora >", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraGreaterThanOrEqualTo(Integer value) {
            addCriterion("idarea_supervisora >=", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraLessThan(Integer value) {
            addCriterion("idarea_supervisora <", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraLessThanOrEqualTo(Integer value) {
            addCriterion("idarea_supervisora <=", value, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraIn(List<Integer> values) {
            addCriterion("idarea_supervisora in", values, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraNotIn(List<Integer> values) {
            addCriterion("idarea_supervisora not in", values, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraBetween(Integer value1, Integer value2) {
            addCriterion("idarea_supervisora between", value1, value2, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdarea_supervisoraNotBetween(Integer value1, Integer value2) {
            addCriterion("idarea_supervisora not between", value1, value2, "idarea_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraIsNull() {
            addCriterion("idunidad_supervisora is null");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraIsNotNull() {
            addCriterion("idunidad_supervisora is not null");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraEqualTo(Integer value) {
            addCriterion("idunidad_supervisora =", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraNotEqualTo(Integer value) {
            addCriterion("idunidad_supervisora <>", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraGreaterThan(Integer value) {
            addCriterion("idunidad_supervisora >", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraGreaterThanOrEqualTo(Integer value) {
            addCriterion("idunidad_supervisora >=", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraLessThan(Integer value) {
            addCriterion("idunidad_supervisora <", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraLessThanOrEqualTo(Integer value) {
            addCriterion("idunidad_supervisora <=", value, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraIn(List<Integer> values) {
            addCriterion("idunidad_supervisora in", values, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraNotIn(List<Integer> values) {
            addCriterion("idunidad_supervisora not in", values, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraBetween(Integer value1, Integer value2) {
            addCriterion("idunidad_supervisora between", value1, value2, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andIdunidad_supervisoraNotBetween(Integer value1, Integer value2) {
            addCriterion("idunidad_supervisora not between", value1, value2, "idunidad_supervisora");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoIsNull() {
            addCriterion("var_numero_requerimiento is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoIsNotNull() {
            addCriterion("var_numero_requerimiento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoEqualTo(String value) {
            addCriterion("var_numero_requerimiento =", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoNotEqualTo(String value) {
            addCriterion("var_numero_requerimiento <>", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoGreaterThan(String value) {
            addCriterion("var_numero_requerimiento >", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_requerimiento >=", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoLessThan(String value) {
            addCriterion("var_numero_requerimiento <", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoLessThanOrEqualTo(String value) {
            addCriterion("var_numero_requerimiento <=", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoLike(String value) {
            addCriterion("var_numero_requerimiento like", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoNotLike(String value) {
            addCriterion("var_numero_requerimiento not like", value, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoIn(List<String> values) {
            addCriterion("var_numero_requerimiento in", values, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoNotIn(List<String> values) {
            addCriterion("var_numero_requerimiento not in", values, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoBetween(String value1, String value2) {
            addCriterion("var_numero_requerimiento between", value1, value2, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_numero_requerimientoNotBetween(String value1, String value2) {
            addCriterion("var_numero_requerimiento not between", value1, value2, "var_numero_requerimiento");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaIsNull() {
            addCriterion("int_cantidad_requerida is null");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaIsNotNull() {
            addCriterion("int_cantidad_requerida is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaEqualTo(Integer value) {
            addCriterion("int_cantidad_requerida =", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaNotEqualTo(Integer value) {
            addCriterion("int_cantidad_requerida <>", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaGreaterThan(Integer value) {
            addCriterion("int_cantidad_requerida >", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cantidad_requerida >=", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaLessThan(Integer value) {
            addCriterion("int_cantidad_requerida <", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaLessThanOrEqualTo(Integer value) {
            addCriterion("int_cantidad_requerida <=", value, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaIn(List<Integer> values) {
            addCriterion("int_cantidad_requerida in", values, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaNotIn(List<Integer> values) {
            addCriterion("int_cantidad_requerida not in", values, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaBetween(Integer value1, Integer value2) {
            addCriterion("int_cantidad_requerida between", value1, value2, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_requeridaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cantidad_requerida not between", value1, value2, "int_cantidad_requerida");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalIsNull() {
            addCriterion("dec_honorario_personal is null");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalIsNotNull() {
            addCriterion("dec_honorario_personal is not null");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalEqualTo(BigDecimal value) {
            addCriterion("dec_honorario_personal =", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalNotEqualTo(BigDecimal value) {
            addCriterion("dec_honorario_personal <>", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalGreaterThan(BigDecimal value) {
            addCriterion("dec_honorario_personal >", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_honorario_personal >=", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalLessThan(BigDecimal value) {
            addCriterion("dec_honorario_personal <", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_honorario_personal <=", value, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalIn(List<BigDecimal> values) {
            addCriterion("dec_honorario_personal in", values, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalNotIn(List<BigDecimal> values) {
            addCriterion("dec_honorario_personal not in", values, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_honorario_personal between", value1, value2, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andDec_honorario_personalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_honorario_personal not between", value1, value2, "dec_honorario_personal");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoIsNull() {
            addCriterion("int_cantidad_tiempo is null");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoIsNotNull() {
            addCriterion("int_cantidad_tiempo is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoEqualTo(Integer value) {
            addCriterion("int_cantidad_tiempo =", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoNotEqualTo(Integer value) {
            addCriterion("int_cantidad_tiempo <>", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoGreaterThan(Integer value) {
            addCriterion("int_cantidad_tiempo >", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cantidad_tiempo >=", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoLessThan(Integer value) {
            addCriterion("int_cantidad_tiempo <", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoLessThanOrEqualTo(Integer value) {
            addCriterion("int_cantidad_tiempo <=", value, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoIn(List<Integer> values) {
            addCriterion("int_cantidad_tiempo in", values, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoNotIn(List<Integer> values) {
            addCriterion("int_cantidad_tiempo not in", values, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoBetween(Integer value1, Integer value2) {
            addCriterion("int_cantidad_tiempo between", value1, value2, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_cantidad_tiempoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cantidad_tiempo not between", value1, value2, "int_cantidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoIsNull() {
            addCriterion("int_id_tipo_unidad_tiempo is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoIsNotNull() {
            addCriterion("int_id_tipo_unidad_tiempo is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoEqualTo(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo =", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo <>", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo >", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo >=", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoLessThan(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo <", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_unidad_tiempo <=", value, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoIn(List<Integer> values) {
            addCriterion("int_id_tipo_unidad_tiempo in", values, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_unidad_tiempo not in", values, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_unidad_tiempo between", value1, value2, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_unidad_tiempoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_unidad_tiempo not between", value1, value2, "int_id_tipo_unidad_tiempo");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaIsNull() {
            addCriterion("var_experiencia_requerida is null");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaIsNotNull() {
            addCriterion("var_experiencia_requerida is not null");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaEqualTo(String value) {
            addCriterion("var_experiencia_requerida =", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaNotEqualTo(String value) {
            addCriterion("var_experiencia_requerida <>", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaGreaterThan(String value) {
            addCriterion("var_experiencia_requerida >", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaGreaterThanOrEqualTo(String value) {
            addCriterion("var_experiencia_requerida >=", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaLessThan(String value) {
            addCriterion("var_experiencia_requerida <", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaLessThanOrEqualTo(String value) {
            addCriterion("var_experiencia_requerida <=", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaLike(String value) {
            addCriterion("var_experiencia_requerida like", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaNotLike(String value) {
            addCriterion("var_experiencia_requerida not like", value, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaIn(List<String> values) {
            addCriterion("var_experiencia_requerida in", values, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaNotIn(List<String> values) {
            addCriterion("var_experiencia_requerida not in", values, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaBetween(String value1, String value2) {
            addCriterion("var_experiencia_requerida between", value1, value2, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_experiencia_requeridaNotBetween(String value1, String value2) {
            addCriterion("var_experiencia_requerida not between", value1, value2, "var_experiencia_requerida");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasIsNull() {
            addCriterion("var_competencias_requeridas is null");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasIsNotNull() {
            addCriterion("var_competencias_requeridas is not null");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasEqualTo(String value) {
            addCriterion("var_competencias_requeridas =", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasNotEqualTo(String value) {
            addCriterion("var_competencias_requeridas <>", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasGreaterThan(String value) {
            addCriterion("var_competencias_requeridas >", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasGreaterThanOrEqualTo(String value) {
            addCriterion("var_competencias_requeridas >=", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasLessThan(String value) {
            addCriterion("var_competencias_requeridas <", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasLessThanOrEqualTo(String value) {
            addCriterion("var_competencias_requeridas <=", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasLike(String value) {
            addCriterion("var_competencias_requeridas like", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasNotLike(String value) {
            addCriterion("var_competencias_requeridas not like", value, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasIn(List<String> values) {
            addCriterion("var_competencias_requeridas in", values, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasNotIn(List<String> values) {
            addCriterion("var_competencias_requeridas not in", values, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasBetween(String value1, String value2) {
            addCriterion("var_competencias_requeridas between", value1, value2, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_competencias_requeridasNotBetween(String value1, String value2) {
            addCriterion("var_competencias_requeridas not between", value1, value2, "var_competencias_requeridas");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaIsNull() {
            addCriterion("var_formacion_academica is null");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaIsNotNull() {
            addCriterion("var_formacion_academica is not null");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaEqualTo(String value) {
            addCriterion("var_formacion_academica =", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaNotEqualTo(String value) {
            addCriterion("var_formacion_academica <>", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaGreaterThan(String value) {
            addCriterion("var_formacion_academica >", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaGreaterThanOrEqualTo(String value) {
            addCriterion("var_formacion_academica >=", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaLessThan(String value) {
            addCriterion("var_formacion_academica <", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaLessThanOrEqualTo(String value) {
            addCriterion("var_formacion_academica <=", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaLike(String value) {
            addCriterion("var_formacion_academica like", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaNotLike(String value) {
            addCriterion("var_formacion_academica not like", value, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaIn(List<String> values) {
            addCriterion("var_formacion_academica in", values, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaNotIn(List<String> values) {
            addCriterion("var_formacion_academica not in", values, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaBetween(String value1, String value2) {
            addCriterion("var_formacion_academica between", value1, value2, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_formacion_academicaNotBetween(String value1, String value2) {
            addCriterion("var_formacion_academica not between", value1, value2, "var_formacion_academica");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionIsNull() {
            addCriterion("var_cursos_especializacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionIsNotNull() {
            addCriterion("var_cursos_especializacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionEqualTo(String value) {
            addCriterion("var_cursos_especializacion =", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionNotEqualTo(String value) {
            addCriterion("var_cursos_especializacion <>", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionGreaterThan(String value) {
            addCriterion("var_cursos_especializacion >", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_cursos_especializacion >=", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionLessThan(String value) {
            addCriterion("var_cursos_especializacion <", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionLessThanOrEqualTo(String value) {
            addCriterion("var_cursos_especializacion <=", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionLike(String value) {
            addCriterion("var_cursos_especializacion like", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionNotLike(String value) {
            addCriterion("var_cursos_especializacion not like", value, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionIn(List<String> values) {
            addCriterion("var_cursos_especializacion in", values, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionNotIn(List<String> values) {
            addCriterion("var_cursos_especializacion not in", values, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionBetween(String value1, String value2) {
            addCriterion("var_cursos_especializacion between", value1, value2, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_cursos_especializacionNotBetween(String value1, String value2) {
            addCriterion("var_cursos_especializacion not between", value1, value2, "var_cursos_especializacion");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoIsNull() {
            addCriterion("var_requisitos_puesto is null");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoIsNotNull() {
            addCriterion("var_requisitos_puesto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoEqualTo(String value) {
            addCriterion("var_requisitos_puesto =", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoNotEqualTo(String value) {
            addCriterion("var_requisitos_puesto <>", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoGreaterThan(String value) {
            addCriterion("var_requisitos_puesto >", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoGreaterThanOrEqualTo(String value) {
            addCriterion("var_requisitos_puesto >=", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoLessThan(String value) {
            addCriterion("var_requisitos_puesto <", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoLessThanOrEqualTo(String value) {
            addCriterion("var_requisitos_puesto <=", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoLike(String value) {
            addCriterion("var_requisitos_puesto like", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoNotLike(String value) {
            addCriterion("var_requisitos_puesto not like", value, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoIn(List<String> values) {
            addCriterion("var_requisitos_puesto in", values, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoNotIn(List<String> values) {
            addCriterion("var_requisitos_puesto not in", values, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoBetween(String value1, String value2) {
            addCriterion("var_requisitos_puesto between", value1, value2, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_requisitos_puestoNotBetween(String value1, String value2) {
            addCriterion("var_requisitos_puesto not between", value1, value2, "var_requisitos_puesto");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesIsNull() {
            addCriterion("var_principales_funciones is null");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesIsNotNull() {
            addCriterion("var_principales_funciones is not null");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesEqualTo(String value) {
            addCriterion("var_principales_funciones =", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesNotEqualTo(String value) {
            addCriterion("var_principales_funciones <>", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesGreaterThan(String value) {
            addCriterion("var_principales_funciones >", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesGreaterThanOrEqualTo(String value) {
            addCriterion("var_principales_funciones >=", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesLessThan(String value) {
            addCriterion("var_principales_funciones <", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesLessThanOrEqualTo(String value) {
            addCriterion("var_principales_funciones <=", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesLike(String value) {
            addCriterion("var_principales_funciones like", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesNotLike(String value) {
            addCriterion("var_principales_funciones not like", value, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesIn(List<String> values) {
            addCriterion("var_principales_funciones in", values, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesNotIn(List<String> values) {
            addCriterion("var_principales_funciones not in", values, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesBetween(String value1, String value2) {
            addCriterion("var_principales_funciones between", value1, value2, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andVar_principales_funcionesNotBetween(String value1, String value2) {
            addCriterion("var_principales_funciones not between", value1, value2, "var_principales_funciones");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionIsNull() {
            addCriterion("int_requiere_evaluacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionIsNotNull() {
            addCriterion("int_requiere_evaluacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionEqualTo(Integer value) {
            addCriterion("int_requiere_evaluacion =", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionNotEqualTo(Integer value) {
            addCriterion("int_requiere_evaluacion <>", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionGreaterThan(Integer value) {
            addCriterion("int_requiere_evaluacion >", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_requiere_evaluacion >=", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionLessThan(Integer value) {
            addCriterion("int_requiere_evaluacion <", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_requiere_evaluacion <=", value, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionIn(List<Integer> values) {
            addCriterion("int_requiere_evaluacion in", values, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionNotIn(List<Integer> values) {
            addCriterion("int_requiere_evaluacion not in", values, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionBetween(Integer value1, Integer value2) {
            addCriterion("int_requiere_evaluacion between", value1, value2, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_evaluacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_requiere_evaluacion not between", value1, value2, "int_requiere_evaluacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionIsNull() {
            addCriterion("var_lugar_prestacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionIsNotNull() {
            addCriterion("var_lugar_prestacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionEqualTo(String value) {
            addCriterion("var_lugar_prestacion =", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotEqualTo(String value) {
            addCriterion("var_lugar_prestacion <>", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionGreaterThan(String value) {
            addCriterion("var_lugar_prestacion >", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_lugar_prestacion >=", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLessThan(String value) {
            addCriterion("var_lugar_prestacion <", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLessThanOrEqualTo(String value) {
            addCriterion("var_lugar_prestacion <=", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLike(String value) {
            addCriterion("var_lugar_prestacion like", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotLike(String value) {
            addCriterion("var_lugar_prestacion not like", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionIn(List<String> values) {
            addCriterion("var_lugar_prestacion in", values, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotIn(List<String> values) {
            addCriterion("var_lugar_prestacion not in", values, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionBetween(String value1, String value2) {
            addCriterion("var_lugar_prestacion between", value1, value2, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotBetween(String value1, String value2) {
            addCriterion("var_lugar_prestacion not between", value1, value2, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorIsNull() {
            addCriterion("int_id_tipo_trabajador is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorIsNotNull() {
            addCriterion("int_id_tipo_trabajador is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorEqualTo(Integer value) {
            addCriterion("int_id_tipo_trabajador =", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_trabajador <>", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorGreaterThan(Integer value) {
            addCriterion("int_id_tipo_trabajador >", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_trabajador >=", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorLessThan(Integer value) {
            addCriterion("int_id_tipo_trabajador <", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_trabajador <=", value, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorIn(List<Integer> values) {
            addCriterion("int_id_tipo_trabajador in", values, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_trabajador not in", values, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_trabajador between", value1, value2, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_trabajadorNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_trabajador not between", value1, value2, "int_id_tipo_trabajador");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoIsNull() {
            addCriterion("var_denominacion_requerimiento is null");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoIsNotNull() {
            addCriterion("var_denominacion_requerimiento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoEqualTo(String value) {
            addCriterion("var_denominacion_requerimiento =", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoNotEqualTo(String value) {
            addCriterion("var_denominacion_requerimiento <>", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoGreaterThan(String value) {
            addCriterion("var_denominacion_requerimiento >", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoGreaterThanOrEqualTo(String value) {
            addCriterion("var_denominacion_requerimiento >=", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoLessThan(String value) {
            addCriterion("var_denominacion_requerimiento <", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoLessThanOrEqualTo(String value) {
            addCriterion("var_denominacion_requerimiento <=", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoLike(String value) {
            addCriterion("var_denominacion_requerimiento like", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoNotLike(String value) {
            addCriterion("var_denominacion_requerimiento not like", value, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoIn(List<String> values) {
            addCriterion("var_denominacion_requerimiento in", values, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoNotIn(List<String> values) {
            addCriterion("var_denominacion_requerimiento not in", values, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoBetween(String value1, String value2) {
            addCriterion("var_denominacion_requerimiento between", value1, value2, "var_denominacion_requerimiento");
            return (Criteria) this;
        }

        public Criteria andVar_denominacion_requerimientoNotBetween(String value1, String value2) {
            addCriterion("var_denominacion_requerimiento not between", value1, value2, "var_denominacion_requerimiento");
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

        public Criteria andId_sede_ubicacionIsNull() {
            addCriterion("id_sede_ubicacion is null");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionIsNotNull() {
            addCriterion("id_sede_ubicacion is not null");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionEqualTo(Integer value) {
            addCriterion("id_sede_ubicacion =", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionNotEqualTo(Integer value) {
            addCriterion("id_sede_ubicacion <>", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionGreaterThan(Integer value) {
            addCriterion("id_sede_ubicacion >", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_sede_ubicacion >=", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionLessThan(Integer value) {
            addCriterion("id_sede_ubicacion <", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_sede_ubicacion <=", value, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionIn(List<Integer> values) {
            addCriterion("id_sede_ubicacion in", values, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionNotIn(List<Integer> values) {
            addCriterion("id_sede_ubicacion not in", values, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionBetween(Integer value1, Integer value2) {
            addCriterion("id_sede_ubicacion between", value1, value2, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andId_sede_ubicacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_sede_ubicacion not between", value1, value2, "id_sede_ubicacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selIsNull() {
            addCriterion("srl_id_sede_req_sel is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selIsNotNull() {
            addCriterion("srl_id_sede_req_sel is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selEqualTo(Integer value) {
            addCriterion("srl_id_sede_req_sel =", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selNotEqualTo(Integer value) {
            addCriterion("srl_id_sede_req_sel <>", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selGreaterThan(Integer value) {
            addCriterion("srl_id_sede_req_sel >", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_sede_req_sel >=", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selLessThan(Integer value) {
            addCriterion("srl_id_sede_req_sel <", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_sede_req_sel <=", value, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selIn(List<Integer> values) {
            addCriterion("srl_id_sede_req_sel in", values, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selNotIn(List<Integer> values) {
            addCriterion("srl_id_sede_req_sel not in", values, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_sede_req_sel between", value1, value2, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_req_selNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_sede_req_sel not between", value1, value2, "srl_id_sede_req_sel");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaIsNull() {
            addCriterion("dte_fec_aprobacion_oa is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaIsNotNull() {
            addCriterion("dte_fec_aprobacion_oa is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa =", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa <>", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa >", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa >=", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa <", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa <=", value, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa in", values, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa not in", values, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa between", value1, value2, "dte_fec_aprobacion_oa");
            return (Criteria) this;
        }

        public Criteria andDte_fec_aprobacion_oaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_aprobacion_oa not between", value1, value2, "dte_fec_aprobacion_oa");
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