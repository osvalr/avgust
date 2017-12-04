package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyExample() {
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

        public Criteria andId_propertyIsNull() {
            addCriterion("id_property is null");
            return (Criteria) this;
        }

        public Criteria andId_propertyIsNotNull() {
            addCriterion("id_property is not null");
            return (Criteria) this;
        }

        public Criteria andId_propertyEqualTo(Integer value) {
            addCriterion("id_property =", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyNotEqualTo(Integer value) {
            addCriterion("id_property <>", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyGreaterThan(Integer value) {
            addCriterion("id_property >", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_property >=", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyLessThan(Integer value) {
            addCriterion("id_property <", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyLessThanOrEqualTo(Integer value) {
            addCriterion("id_property <=", value, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyIn(List<Integer> values) {
            addCriterion("id_property in", values, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyNotIn(List<Integer> values) {
            addCriterion("id_property not in", values, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyBetween(Integer value1, Integer value2) {
            addCriterion("id_property between", value1, value2, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_propertyNotBetween(Integer value1, Integer value2) {
            addCriterion("id_property not between", value1, value2, "id_property");
            return (Criteria) this;
        }

        public Criteria andId_model_inputIsNull() {
            addCriterion("id_model_input is null");
            return (Criteria) this;
        }

        public Criteria andId_model_inputIsNotNull() {
            addCriterion("id_model_input is not null");
            return (Criteria) this;
        }

        public Criteria andId_model_inputEqualTo(Integer value) {
            addCriterion("id_model_input =", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputNotEqualTo(Integer value) {
            addCriterion("id_model_input <>", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputGreaterThan(Integer value) {
            addCriterion("id_model_input >", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_model_input >=", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputLessThan(Integer value) {
            addCriterion("id_model_input <", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputLessThanOrEqualTo(Integer value) {
            addCriterion("id_model_input <=", value, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputIn(List<Integer> values) {
            addCriterion("id_model_input in", values, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputNotIn(List<Integer> values) {
            addCriterion("id_model_input not in", values, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input between", value1, value2, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_inputNotBetween(Integer value1, Integer value2) {
            addCriterion("id_model_input not between", value1, value2, "id_model_input");
            return (Criteria) this;
        }

        public Criteria andId_model_outputIsNull() {
            addCriterion("id_model_output is null");
            return (Criteria) this;
        }

        public Criteria andId_model_outputIsNotNull() {
            addCriterion("id_model_output is not null");
            return (Criteria) this;
        }

        public Criteria andId_model_outputEqualTo(Integer value) {
            addCriterion("id_model_output =", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputNotEqualTo(Integer value) {
            addCriterion("id_model_output <>", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputGreaterThan(Integer value) {
            addCriterion("id_model_output >", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_model_output >=", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputLessThan(Integer value) {
            addCriterion("id_model_output <", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputLessThanOrEqualTo(Integer value) {
            addCriterion("id_model_output <=", value, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputIn(List<Integer> values) {
            addCriterion("id_model_output in", values, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputNotIn(List<Integer> values) {
            addCriterion("id_model_output not in", values, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputBetween(Integer value1, Integer value2) {
            addCriterion("id_model_output between", value1, value2, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andId_model_outputNotBetween(Integer value1, Integer value2) {
            addCriterion("id_model_output not between", value1, value2, "id_model_output");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andData_typeEqualTo(String value) {
            addCriterion("data_type =", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThan(String value) {
            addCriterion("data_type >", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThan(String value) {
            addCriterion("data_type <", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLike(String value) {
            addCriterion("data_type like", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotLike(String value) {
            addCriterion("data_type not like", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeIn(List<String> values) {
            addCriterion("data_type in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDate_recordIsNull() {
            addCriterion("date_record is null");
            return (Criteria) this;
        }

        public Criteria andDate_recordIsNotNull() {
            addCriterion("date_record is not null");
            return (Criteria) this;
        }

        public Criteria andDate_recordEqualTo(String value) {
            addCriterion("date_record =", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordNotEqualTo(String value) {
            addCriterion("date_record <>", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordGreaterThan(String value) {
            addCriterion("date_record >", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordGreaterThanOrEqualTo(String value) {
            addCriterion("date_record >=", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordLessThan(String value) {
            addCriterion("date_record <", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordLessThanOrEqualTo(String value) {
            addCriterion("date_record <=", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordLike(String value) {
            addCriterion("date_record like", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordNotLike(String value) {
            addCriterion("date_record not like", value, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordIn(List<String> values) {
            addCriterion("date_record in", values, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordNotIn(List<String> values) {
            addCriterion("date_record not in", values, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordBetween(String value1, String value2) {
            addCriterion("date_record between", value1, value2, "date_record");
            return (Criteria) this;
        }

        public Criteria andDate_recordNotBetween(String value1, String value2) {
            addCriterion("date_record not between", value1, value2, "date_record");
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