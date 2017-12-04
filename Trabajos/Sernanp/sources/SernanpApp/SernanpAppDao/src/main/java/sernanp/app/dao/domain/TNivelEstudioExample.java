package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TNivelEstudioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNivelEstudioExample() {
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

        public Criteria andSrl_id_nivel_estudioIsNull() {
            addCriterion("srl_id_nivel_estudio is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioIsNotNull() {
            addCriterion("srl_id_nivel_estudio is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio =", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio <>", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioGreaterThan(Integer value) {
            addCriterion("srl_id_nivel_estudio >", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio >=", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioLessThan(Integer value) {
            addCriterion("srl_id_nivel_estudio <", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio <=", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioIn(List<Integer> values) {
            addCriterion("srl_id_nivel_estudio in", values, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotIn(List<Integer> values) {
            addCriterion("srl_id_nivel_estudio not in", values, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_estudio between", value1, value2, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_estudio not between", value1, value2, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioIsNull() {
            addCriterion("var_descripcion_nivel_estudio is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioIsNotNull() {
            addCriterion("var_descripcion_nivel_estudio is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioEqualTo(String value) {
            addCriterion("var_descripcion_nivel_estudio =", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioNotEqualTo(String value) {
            addCriterion("var_descripcion_nivel_estudio <>", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioGreaterThan(String value) {
            addCriterion("var_descripcion_nivel_estudio >", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_nivel_estudio >=", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioLessThan(String value) {
            addCriterion("var_descripcion_nivel_estudio <", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_nivel_estudio <=", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioLike(String value) {
            addCriterion("var_descripcion_nivel_estudio like", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioNotLike(String value) {
            addCriterion("var_descripcion_nivel_estudio not like", value, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioIn(List<String> values) {
            addCriterion("var_descripcion_nivel_estudio in", values, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioNotIn(List<String> values) {
            addCriterion("var_descripcion_nivel_estudio not in", values, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioBetween(String value1, String value2) {
            addCriterion("var_descripcion_nivel_estudio between", value1, value2, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_nivel_estudioNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_nivel_estudio not between", value1, value2, "var_descripcion_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioIsNull() {
            addCriterion("var_cod_nivel_estudio is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioIsNotNull() {
            addCriterion("var_cod_nivel_estudio is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioEqualTo(String value) {
            addCriterion("var_cod_nivel_estudio =", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioNotEqualTo(String value) {
            addCriterion("var_cod_nivel_estudio <>", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioGreaterThan(String value) {
            addCriterion("var_cod_nivel_estudio >", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_nivel_estudio >=", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioLessThan(String value) {
            addCriterion("var_cod_nivel_estudio <", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioLessThanOrEqualTo(String value) {
            addCriterion("var_cod_nivel_estudio <=", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioLike(String value) {
            addCriterion("var_cod_nivel_estudio like", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioNotLike(String value) {
            addCriterion("var_cod_nivel_estudio not like", value, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioIn(List<String> values) {
            addCriterion("var_cod_nivel_estudio in", values, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioNotIn(List<String> values) {
            addCriterion("var_cod_nivel_estudio not in", values, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioBetween(String value1, String value2) {
            addCriterion("var_cod_nivel_estudio between", value1, value2, "var_cod_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_nivel_estudioNotBetween(String value1, String value2) {
            addCriterion("var_cod_nivel_estudio not between", value1, value2, "var_cod_nivel_estudio");
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