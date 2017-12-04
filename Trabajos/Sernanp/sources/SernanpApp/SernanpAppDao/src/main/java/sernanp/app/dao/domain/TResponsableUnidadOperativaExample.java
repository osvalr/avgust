package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TResponsableUnidadOperativaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TResponsableUnidadOperativaExample() {
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

        public Criteria andSrl_id_resp_unid_operIsNull() {
            addCriterion("srl_id_resp_unid_oper is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operIsNotNull() {
            addCriterion("srl_id_resp_unid_oper is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper =", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper <>", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operGreaterThan(Integer value) {
            addCriterion("srl_id_resp_unid_oper >", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper >=", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operLessThan(Integer value) {
            addCriterion("srl_id_resp_unid_oper <", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper <=", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operIn(List<Integer> values) {
            addCriterion("srl_id_resp_unid_oper in", values, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotIn(List<Integer> values) {
            addCriterion("srl_id_resp_unid_oper not in", values, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_resp_unid_oper between", value1, value2, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_resp_unid_oper not between", value1, value2, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andIdunidadIsNull() {
            addCriterion("idunidad is null");
            return (Criteria) this;
        }

        public Criteria andIdunidadIsNotNull() {
            addCriterion("idunidad is not null");
            return (Criteria) this;
        }

        public Criteria andIdunidadEqualTo(Integer value) {
            addCriterion("idunidad =", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotEqualTo(Integer value) {
            addCriterion("idunidad <>", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadGreaterThan(Integer value) {
            addCriterion("idunidad >", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("idunidad >=", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadLessThan(Integer value) {
            addCriterion("idunidad <", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadLessThanOrEqualTo(Integer value) {
            addCriterion("idunidad <=", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadIn(List<Integer> values) {
            addCriterion("idunidad in", values, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotIn(List<Integer> values) {
            addCriterion("idunidad not in", values, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadBetween(Integer value1, Integer value2) {
            addCriterion("idunidad between", value1, value2, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotBetween(Integer value1, Integer value2) {
            addCriterion("idunidad not between", value1, value2, "idunidad");
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

        public Criteria andInt_id_tipo_responsableIsNull() {
            addCriterion("int_id_tipo_responsable is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableIsNotNull() {
            addCriterion("int_id_tipo_responsable is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableEqualTo(Integer value) {
            addCriterion("int_id_tipo_responsable =", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_responsable <>", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableGreaterThan(Integer value) {
            addCriterion("int_id_tipo_responsable >", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_responsable >=", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableLessThan(Integer value) {
            addCriterion("int_id_tipo_responsable <", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_responsable <=", value, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableIn(List<Integer> values) {
            addCriterion("int_id_tipo_responsable in", values, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_responsable not in", values, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_responsable between", value1, value2, "int_id_tipo_responsable");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_responsableNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_responsable not between", value1, value2, "int_id_tipo_responsable");
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

        public Criteria andTsp_fecha_inicio_ejercicioIsNull() {
            addCriterion("tsp_fecha_inicio_ejercicio is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioIsNotNull() {
            addCriterion("tsp_fecha_inicio_ejercicio is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioEqualTo(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio =", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioNotEqualTo(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio <>", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioGreaterThan(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio >", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio >=", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioLessThan(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio <", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_inicio_ejercicio <=", value, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioIn(List<Date> values) {
            addCriterion("tsp_fecha_inicio_ejercicio in", values, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioNotIn(List<Date> values) {
            addCriterion("tsp_fecha_inicio_ejercicio not in", values, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_inicio_ejercicio between", value1, value2, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_inicio_ejercicioNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_inicio_ejercicio not between", value1, value2, "tsp_fecha_inicio_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioIsNull() {
            addCriterion("tsp_fecha_fin_ejercicio is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioIsNotNull() {
            addCriterion("tsp_fecha_fin_ejercicio is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioEqualTo(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio =", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioNotEqualTo(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio <>", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioGreaterThan(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio >", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio >=", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioLessThan(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio <", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_fin_ejercicio <=", value, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioIn(List<Date> values) {
            addCriterion("tsp_fecha_fin_ejercicio in", values, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioNotIn(List<Date> values) {
            addCriterion("tsp_fecha_fin_ejercicio not in", values, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_fin_ejercicio between", value1, value2, "tsp_fecha_fin_ejercicio");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_fin_ejercicioNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_fin_ejercicio not between", value1, value2, "tsp_fecha_fin_ejercicio");
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