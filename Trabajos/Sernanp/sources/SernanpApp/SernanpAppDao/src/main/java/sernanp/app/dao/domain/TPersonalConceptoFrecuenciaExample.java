package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPersonalConceptoFrecuenciaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalConceptoFrecuenciaExample() {
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

        public Criteria andSrl_id_frecuenciaIsNull() {
            addCriterion("srl_id_frecuencia is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaIsNotNull() {
            addCriterion("srl_id_frecuencia is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia =", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaNotEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia <>", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaGreaterThan(Integer value) {
            addCriterion("srl_id_frecuencia >", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia >=", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaLessThan(Integer value) {
            addCriterion("srl_id_frecuencia <", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_frecuencia <=", value, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaIn(List<Integer> values) {
            addCriterion("srl_id_frecuencia in", values, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaNotIn(List<Integer> values) {
            addCriterion("srl_id_frecuencia not in", values, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_frecuencia between", value1, value2, "srl_id_frecuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_frecuenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_frecuencia not between", value1, value2, "srl_id_frecuencia");
            return (Criteria) this;
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