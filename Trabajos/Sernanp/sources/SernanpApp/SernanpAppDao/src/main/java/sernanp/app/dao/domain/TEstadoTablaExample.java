package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEstadoTablaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEstadoTablaExample() {
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

        public Criteria andSrl_id_estado_tablaIsNull() {
            addCriterion("srl_id_estado_tabla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaIsNotNull() {
            addCriterion("srl_id_estado_tabla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaEqualTo(Integer value) {
            addCriterion("srl_id_estado_tabla =", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaNotEqualTo(Integer value) {
            addCriterion("srl_id_estado_tabla <>", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaGreaterThan(Integer value) {
            addCriterion("srl_id_estado_tabla >", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_estado_tabla >=", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaLessThan(Integer value) {
            addCriterion("srl_id_estado_tabla <", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_estado_tabla <=", value, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaIn(List<Integer> values) {
            addCriterion("srl_id_estado_tabla in", values, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaNotIn(List<Integer> values) {
            addCriterion("srl_id_estado_tabla not in", values, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_estado_tabla between", value1, value2, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_estado_tablaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_estado_tabla not between", value1, value2, "srl_id_estado_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIsNull() {
            addCriterion("var_nombre_tabla is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIsNotNull() {
            addCriterion("var_nombre_tabla is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaEqualTo(String value) {
            addCriterion("var_nombre_tabla =", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotEqualTo(String value) {
            addCriterion("var_nombre_tabla <>", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaGreaterThan(String value) {
            addCriterion("var_nombre_tabla >", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_tabla >=", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLessThan(String value) {
            addCriterion("var_nombre_tabla <", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_tabla <=", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLike(String value) {
            addCriterion("var_nombre_tabla like", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotLike(String value) {
            addCriterion("var_nombre_tabla not like", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIn(List<String> values) {
            addCriterion("var_nombre_tabla in", values, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotIn(List<String> values) {
            addCriterion("var_nombre_tabla not in", values, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaBetween(String value1, String value2) {
            addCriterion("var_nombre_tabla between", value1, value2, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotBetween(String value1, String value2) {
            addCriterion("var_nombre_tabla not between", value1, value2, "var_nombre_tabla");
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