package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SubModelInputExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubModelInputExample() {
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

        public Criteria andId_sub_model_inputIsNull() {
            addCriterion("id_sub_model_input is null");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputIsNotNull() {
            addCriterion("id_sub_model_input is not null");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputEqualTo(Integer value) {
            addCriterion("id_sub_model_input =", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputNotEqualTo(Integer value) {
            addCriterion("id_sub_model_input <>", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputGreaterThan(Integer value) {
            addCriterion("id_sub_model_input >", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_sub_model_input >=", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputLessThan(Integer value) {
            addCriterion("id_sub_model_input <", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputLessThanOrEqualTo(Integer value) {
            addCriterion("id_sub_model_input <=", value, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputIn(List<Integer> values) {
            addCriterion("id_sub_model_input in", values, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputNotIn(List<Integer> values) {
            addCriterion("id_sub_model_input not in", values, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputBetween(Integer value1, Integer value2) {
            addCriterion("id_sub_model_input between", value1, value2, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_sub_model_inputNotBetween(Integer value1, Integer value2) {
            addCriterion("id_sub_model_input not between", value1, value2, "id_sub_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentIsNull() {
            addCriterion("id_model_input_parent is null");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentIsNotNull() {
            addCriterion("id_model_input_parent is not null");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentEqualTo(Integer value) {
            addCriterion("id_model_input_parent =", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentNotEqualTo(Integer value) {
            addCriterion("id_model_input_parent <>", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentGreaterThan(Integer value) {
            addCriterion("id_model_input_parent >", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_model_input_parent >=", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentLessThan(Integer value) {
            addCriterion("id_model_input_parent <", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentLessThanOrEqualTo(Integer value) {
            addCriterion("id_model_input_parent <=", value, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentIn(List<Integer> values) {
            addCriterion("id_model_input_parent in", values, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentNotIn(List<Integer> values) {
            addCriterion("id_model_input_parent not in", values, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input_parent between", value1, value2, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_parentNotBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input_parent not between", value1, value2, "id_model_input_parent");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childIsNull() {
            addCriterion("id_model_input_child is null");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childIsNotNull() {
            addCriterion("id_model_input_child is not null");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childEqualTo(Integer value) {
            addCriterion("id_model_input_child =", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childNotEqualTo(Integer value) {
            addCriterion("id_model_input_child <>", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childGreaterThan(Integer value) {
            addCriterion("id_model_input_child >", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_model_input_child >=", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childLessThan(Integer value) {
            addCriterion("id_model_input_child <", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childLessThanOrEqualTo(Integer value) {
            addCriterion("id_model_input_child <=", value, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childIn(List<Integer> values) {
            addCriterion("id_model_input_child in", values, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childNotIn(List<Integer> values) {
            addCriterion("id_model_input_child not in", values, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input_child between", value1, value2, "id_model_input_child");
            return (Criteria) this;
        }

        public Criteria andId_model_input_childNotBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input_child not between", value1, value2, "id_model_input_child");
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