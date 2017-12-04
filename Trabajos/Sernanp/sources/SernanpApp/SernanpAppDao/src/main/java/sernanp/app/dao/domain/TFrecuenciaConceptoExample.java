package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TFrecuenciaConceptoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFrecuenciaConceptoExample() {
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

        public Criteria andSrl_id_frecuencia_conceptoIsNull() {
            addCriterion("srl_id_frecuencia_concepto is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoIsNotNull() {
            addCriterion("srl_id_frecuencia_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia_concepto =", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoNotEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia_concepto <>", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoGreaterThan(Integer value) {
            addCriterion("srl_id_frecuencia_concepto >", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia_concepto >=", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoLessThan(Integer value) {
            addCriterion("srl_id_frecuencia_concepto <", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia_concepto <=", value, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoIn(List<Integer> values) {
            addCriterion("srl_id_frecuencia_concepto in", values, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoNotIn(List<Integer> values) {
            addCriterion("srl_id_frecuencia_concepto not in", values, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_frecuencia_concepto between", value1, value2, "srl_id_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuencia_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_frecuencia_concepto not between", value1, value2, "srl_id_frecuencia_concepto");
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

        public Criteria andInt_id_mesIsNull() {
            addCriterion("int_id_mes is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesIsNotNull() {
            addCriterion("int_id_mes is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesEqualTo(Integer value) {
            addCriterion("int_id_mes =", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesNotEqualTo(Integer value) {
            addCriterion("int_id_mes <>", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesGreaterThan(Integer value) {
            addCriterion("int_id_mes >", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_mes >=", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesLessThan(Integer value) {
            addCriterion("int_id_mes <", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_mes <=", value, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesIn(List<Integer> values) {
            addCriterion("int_id_mes in", values, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesNotIn(List<Integer> values) {
            addCriterion("int_id_mes not in", values, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesBetween(Integer value1, Integer value2) {
            addCriterion("int_id_mes between", value1, value2, "int_id_mes");
            return (Criteria) this;
        }

        public Criteria andInt_id_mesNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_mes not between", value1, value2, "int_id_mes");
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