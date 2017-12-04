package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TUnidadOperativaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUnidadOperativaExample() {
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

        public Criteria andSrl_id_unidad_operativaIsNull() {
            addCriterion("srl_id_unidad_operativa is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaIsNotNull() {
            addCriterion("srl_id_unidad_operativa is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaEqualTo(Integer value) {
            addCriterion("srl_id_unidad_operativa =", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaNotEqualTo(Integer value) {
            addCriterion("srl_id_unidad_operativa <>", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaGreaterThan(Integer value) {
            addCriterion("srl_id_unidad_operativa >", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_unidad_operativa >=", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaLessThan(Integer value) {
            addCriterion("srl_id_unidad_operativa <", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_unidad_operativa <=", value, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaIn(List<Integer> values) {
            addCriterion("srl_id_unidad_operativa in", values, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaNotIn(List<Integer> values) {
            addCriterion("srl_id_unidad_operativa not in", values, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_unidad_operativa between", value1, value2, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_unidad_operativaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_unidad_operativa not between", value1, value2, "srl_id_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadIsNull() {
            addCriterion("var_nom_unidad is null");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadIsNotNull() {
            addCriterion("var_nom_unidad is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadEqualTo(String value) {
            addCriterion("var_nom_unidad =", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadNotEqualTo(String value) {
            addCriterion("var_nom_unidad <>", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadGreaterThan(String value) {
            addCriterion("var_nom_unidad >", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadGreaterThanOrEqualTo(String value) {
            addCriterion("var_nom_unidad >=", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadLessThan(String value) {
            addCriterion("var_nom_unidad <", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadLessThanOrEqualTo(String value) {
            addCriterion("var_nom_unidad <=", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadLike(String value) {
            addCriterion("var_nom_unidad like", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadNotLike(String value) {
            addCriterion("var_nom_unidad not like", value, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadIn(List<String> values) {
            addCriterion("var_nom_unidad in", values, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadNotIn(List<String> values) {
            addCriterion("var_nom_unidad not in", values, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadBetween(String value1, String value2) {
            addCriterion("var_nom_unidad between", value1, value2, "var_nom_unidad");
            return (Criteria) this;
        }

        public Criteria andVar_nom_unidadNotBetween(String value1, String value2) {
            addCriterion("var_nom_unidad not between", value1, value2, "var_nom_unidad");
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