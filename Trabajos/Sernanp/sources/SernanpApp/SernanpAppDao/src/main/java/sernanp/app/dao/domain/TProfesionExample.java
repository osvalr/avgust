package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TProfesionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProfesionExample() {
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

        public Criteria andSrl_id_profesionIsNull() {
            addCriterion("srl_id_profesion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIsNotNull() {
            addCriterion("srl_id_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionEqualTo(Integer value) {
            addCriterion("srl_id_profesion =", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotEqualTo(Integer value) {
            addCriterion("srl_id_profesion <>", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThan(Integer value) {
            addCriterion("srl_id_profesion >", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion >=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThan(Integer value) {
            addCriterion("srl_id_profesion <", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion <=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIn(List<Integer> values) {
            addCriterion("srl_id_profesion in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotIn(List<Integer> values) {
            addCriterion("srl_id_profesion not in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion between", value1, value2, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion not between", value1, value2, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIsNull() {
            addCriterion("srl_id_tipo_profesion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIsNotNull() {
            addCriterion("srl_id_tipo_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion =", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion <>", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionGreaterThan(Integer value) {
            addCriterion("srl_id_tipo_profesion >", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion >=", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionLessThan(Integer value) {
            addCriterion("srl_id_tipo_profesion <", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion <=", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIn(List<Integer> values) {
            addCriterion("srl_id_tipo_profesion in", values, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotIn(List<Integer> values) {
            addCriterion("srl_id_tipo_profesion not in", values, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_profesion between", value1, value2, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_profesion not between", value1, value2, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionIsNull() {
            addCriterion("int_cod_profesion is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionIsNotNull() {
            addCriterion("int_cod_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionEqualTo(Integer value) {
            addCriterion("int_cod_profesion =", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionNotEqualTo(Integer value) {
            addCriterion("int_cod_profesion <>", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionGreaterThan(Integer value) {
            addCriterion("int_cod_profesion >", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_profesion >=", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionLessThan(Integer value) {
            addCriterion("int_cod_profesion <", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_profesion <=", value, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionIn(List<Integer> values) {
            addCriterion("int_cod_profesion in", values, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionNotIn(List<Integer> values) {
            addCriterion("int_cod_profesion not in", values, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_profesion between", value1, value2, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_profesion not between", value1, value2, "int_cod_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionIsNull() {
            addCriterion("var_descripcion_profesion is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionIsNotNull() {
            addCriterion("var_descripcion_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionEqualTo(String value) {
            addCriterion("var_descripcion_profesion =", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionNotEqualTo(String value) {
            addCriterion("var_descripcion_profesion <>", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionGreaterThan(String value) {
            addCriterion("var_descripcion_profesion >", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_profesion >=", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionLessThan(String value) {
            addCriterion("var_descripcion_profesion <", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_profesion <=", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionLike(String value) {
            addCriterion("var_descripcion_profesion like", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionNotLike(String value) {
            addCriterion("var_descripcion_profesion not like", value, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionIn(List<String> values) {
            addCriterion("var_descripcion_profesion in", values, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionNotIn(List<String> values) {
            addCriterion("var_descripcion_profesion not in", values, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionBetween(String value1, String value2) {
            addCriterion("var_descripcion_profesion between", value1, value2, "var_descripcion_profesion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_profesionNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_profesion not between", value1, value2, "var_descripcion_profesion");
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