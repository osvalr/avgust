package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TTipificacionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTipificacionExample() {
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

        public Criteria andSrl_id_tipificacionIsNull() {
            addCriterion("srl_id_tipificacion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionIsNotNull() {
            addCriterion("srl_id_tipificacion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionEqualTo(Integer value) {
            addCriterion("srl_id_tipificacion =", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionNotEqualTo(Integer value) {
            addCriterion("srl_id_tipificacion <>", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionGreaterThan(Integer value) {
            addCriterion("srl_id_tipificacion >", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipificacion >=", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionLessThan(Integer value) {
            addCriterion("srl_id_tipificacion <", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipificacion <=", value, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionIn(List<Integer> values) {
            addCriterion("srl_id_tipificacion in", values, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionNotIn(List<Integer> values) {
            addCriterion("srl_id_tipificacion not in", values, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipificacion between", value1, value2, "srl_id_tipificacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipificacion not between", value1, value2, "srl_id_tipificacion");
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

        public Criteria andVar_descripcion_tipificacionIsNull() {
            addCriterion("var_descripcion_tipificacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionIsNotNull() {
            addCriterion("var_descripcion_tipificacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionEqualTo(String value) {
            addCriterion("var_descripcion_tipificacion =", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionNotEqualTo(String value) {
            addCriterion("var_descripcion_tipificacion <>", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionGreaterThan(String value) {
            addCriterion("var_descripcion_tipificacion >", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_tipificacion >=", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionLessThan(String value) {
            addCriterion("var_descripcion_tipificacion <", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_tipificacion <=", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionLike(String value) {
            addCriterion("var_descripcion_tipificacion like", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionNotLike(String value) {
            addCriterion("var_descripcion_tipificacion not like", value, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionIn(List<String> values) {
            addCriterion("var_descripcion_tipificacion in", values, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionNotIn(List<String> values) {
            addCriterion("var_descripcion_tipificacion not in", values, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionBetween(String value1, String value2) {
            addCriterion("var_descripcion_tipificacion between", value1, value2, "var_descripcion_tipificacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_tipificacionNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_tipificacion not between", value1, value2, "var_descripcion_tipificacion");
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