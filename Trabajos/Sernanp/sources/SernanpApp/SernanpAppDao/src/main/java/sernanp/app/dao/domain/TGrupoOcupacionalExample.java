package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TGrupoOcupacionalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGrupoOcupacionalExample() {
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

        public Criteria andSrl_id_grupo_ocupacionalIsNull() {
            addCriterion("srl_id_grupo_ocupacional is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalIsNotNull() {
            addCriterion("srl_id_grupo_ocupacional is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional =", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <>", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalGreaterThan(Integer value) {
            addCriterion("srl_id_grupo_ocupacional >", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional >=", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalLessThan(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <=", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalIn(List<Integer> values) {
            addCriterion("srl_id_grupo_ocupacional in", values, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotIn(List<Integer> values) {
            addCriterion("srl_id_grupo_ocupacional not in", values, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_grupo_ocupacional between", value1, value2, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_grupo_ocupacional not between", value1, value2, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalIsNull() {
            addCriterion("var_desc_grupo_ocupacional is null");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalIsNotNull() {
            addCriterion("var_desc_grupo_ocupacional is not null");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalEqualTo(String value) {
            addCriterion("var_desc_grupo_ocupacional =", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalNotEqualTo(String value) {
            addCriterion("var_desc_grupo_ocupacional <>", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalGreaterThan(String value) {
            addCriterion("var_desc_grupo_ocupacional >", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalGreaterThanOrEqualTo(String value) {
            addCriterion("var_desc_grupo_ocupacional >=", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalLessThan(String value) {
            addCriterion("var_desc_grupo_ocupacional <", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalLessThanOrEqualTo(String value) {
            addCriterion("var_desc_grupo_ocupacional <=", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalLike(String value) {
            addCriterion("var_desc_grupo_ocupacional like", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalNotLike(String value) {
            addCriterion("var_desc_grupo_ocupacional not like", value, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalIn(List<String> values) {
            addCriterion("var_desc_grupo_ocupacional in", values, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalNotIn(List<String> values) {
            addCriterion("var_desc_grupo_ocupacional not in", values, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalBetween(String value1, String value2) {
            addCriterion("var_desc_grupo_ocupacional between", value1, value2, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andVar_desc_grupo_ocupacionalNotBetween(String value1, String value2) {
            addCriterion("var_desc_grupo_ocupacional not between", value1, value2, "var_desc_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalIsNull() {
            addCriterion("int_cod_grupo_ocupacional is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalIsNotNull() {
            addCriterion("int_cod_grupo_ocupacional is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalEqualTo(Integer value) {
            addCriterion("int_cod_grupo_ocupacional =", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalNotEqualTo(Integer value) {
            addCriterion("int_cod_grupo_ocupacional <>", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalGreaterThan(Integer value) {
            addCriterion("int_cod_grupo_ocupacional >", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_grupo_ocupacional >=", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalLessThan(Integer value) {
            addCriterion("int_cod_grupo_ocupacional <", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_grupo_ocupacional <=", value, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalIn(List<Integer> values) {
            addCriterion("int_cod_grupo_ocupacional in", values, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalNotIn(List<Integer> values) {
            addCriterion("int_cod_grupo_ocupacional not in", values, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_grupo_ocupacional between", value1, value2, "int_cod_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andInt_cod_grupo_ocupacionalNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_grupo_ocupacional not between", value1, value2, "int_cod_grupo_ocupacional");
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