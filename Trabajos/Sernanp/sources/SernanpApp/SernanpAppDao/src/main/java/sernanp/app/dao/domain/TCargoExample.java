package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TCargoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCargoExample() {
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

        public Criteria andSrl_id_cargoIsNull() {
            addCriterion("srl_id_cargo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoIsNotNull() {
            addCriterion("srl_id_cargo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoEqualTo(Integer value) {
            addCriterion("srl_id_cargo =", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotEqualTo(Integer value) {
            addCriterion("srl_id_cargo <>", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoGreaterThan(Integer value) {
            addCriterion("srl_id_cargo >", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_cargo >=", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoLessThan(Integer value) {
            addCriterion("srl_id_cargo <", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_cargo <=", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoIn(List<Integer> values) {
            addCriterion("srl_id_cargo in", values, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotIn(List<Integer> values) {
            addCriterion("srl_id_cargo not in", values, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_cargo between", value1, value2, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_cargo not between", value1, value2, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoIsNull() {
            addCriterion("var_nom_cargo is null");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoIsNotNull() {
            addCriterion("var_nom_cargo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoEqualTo(String value) {
            addCriterion("var_nom_cargo =", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoNotEqualTo(String value) {
            addCriterion("var_nom_cargo <>", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoGreaterThan(String value) {
            addCriterion("var_nom_cargo >", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoGreaterThanOrEqualTo(String value) {
            addCriterion("var_nom_cargo >=", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoLessThan(String value) {
            addCriterion("var_nom_cargo <", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoLessThanOrEqualTo(String value) {
            addCriterion("var_nom_cargo <=", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoLike(String value) {
            addCriterion("var_nom_cargo like", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoNotLike(String value) {
            addCriterion("var_nom_cargo not like", value, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoIn(List<String> values) {
            addCriterion("var_nom_cargo in", values, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoNotIn(List<String> values) {
            addCriterion("var_nom_cargo not in", values, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoBetween(String value1, String value2) {
            addCriterion("var_nom_cargo between", value1, value2, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andVar_nom_cargoNotBetween(String value1, String value2) {
            addCriterion("var_nom_cargo not between", value1, value2, "var_nom_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoIsNull() {
            addCriterion("int_est_cargo is null");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoIsNotNull() {
            addCriterion("int_est_cargo is not null");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoEqualTo(Integer value) {
            addCriterion("int_est_cargo =", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoNotEqualTo(Integer value) {
            addCriterion("int_est_cargo <>", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoGreaterThan(Integer value) {
            addCriterion("int_est_cargo >", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_est_cargo >=", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoLessThan(Integer value) {
            addCriterion("int_est_cargo <", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoLessThanOrEqualTo(Integer value) {
            addCriterion("int_est_cargo <=", value, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoIn(List<Integer> values) {
            addCriterion("int_est_cargo in", values, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoNotIn(List<Integer> values) {
            addCriterion("int_est_cargo not in", values, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoBetween(Integer value1, Integer value2) {
            addCriterion("int_est_cargo between", value1, value2, "int_est_cargo");
            return (Criteria) this;
        }

        public Criteria andInt_est_cargoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_est_cargo not between", value1, value2, "int_est_cargo");
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