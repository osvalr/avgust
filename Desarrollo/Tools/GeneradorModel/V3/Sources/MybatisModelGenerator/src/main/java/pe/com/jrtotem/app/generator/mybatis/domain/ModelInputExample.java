package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class ModelInputExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelInputExample() {
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

        public Criteria andId_info_db_connectionIsNull() {
            addCriterion("id_info_db_connection is null");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionIsNotNull() {
            addCriterion("id_info_db_connection is not null");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionEqualTo(Integer value) {
            addCriterion("id_info_db_connection =", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionNotEqualTo(Integer value) {
            addCriterion("id_info_db_connection <>", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionGreaterThan(Integer value) {
            addCriterion("id_info_db_connection >", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_info_db_connection >=", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionLessThan(Integer value) {
            addCriterion("id_info_db_connection <", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionLessThanOrEqualTo(Integer value) {
            addCriterion("id_info_db_connection <=", value, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionIn(List<Integer> values) {
            addCriterion("id_info_db_connection in", values, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionNotIn(List<Integer> values) {
            addCriterion("id_info_db_connection not in", values, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionBetween(Integer value1, Integer value2) {
            addCriterion("id_info_db_connection between", value1, value2, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andId_info_db_connectionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_info_db_connection not between", value1, value2, "id_info_db_connection");
            return (Criteria) this;
        }

        public Criteria andName_modelIsNull() {
            addCriterion("name_model is null");
            return (Criteria) this;
        }

        public Criteria andName_modelIsNotNull() {
            addCriterion("name_model is not null");
            return (Criteria) this;
        }

        public Criteria andName_modelEqualTo(String value) {
            addCriterion("name_model =", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelNotEqualTo(String value) {
            addCriterion("name_model <>", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelGreaterThan(String value) {
            addCriterion("name_model >", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelGreaterThanOrEqualTo(String value) {
            addCriterion("name_model >=", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelLessThan(String value) {
            addCriterion("name_model <", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelLessThanOrEqualTo(String value) {
            addCriterion("name_model <=", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelLike(String value) {
            addCriterion("name_model like", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelNotLike(String value) {
            addCriterion("name_model not like", value, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelIn(List<String> values) {
            addCriterion("name_model in", values, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelNotIn(List<String> values) {
            addCriterion("name_model not in", values, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelBetween(String value1, String value2) {
            addCriterion("name_model between", value1, value2, "name_model");
            return (Criteria) this;
        }

        public Criteria andName_modelNotBetween(String value1, String value2) {
            addCriterion("name_model not between", value1, value2, "name_model");
            return (Criteria) this;
        }

        public Criteria andSql_textIsNull() {
            addCriterion("sql_text is null");
            return (Criteria) this;
        }

        public Criteria andSql_textIsNotNull() {
            addCriterion("sql_text is not null");
            return (Criteria) this;
        }

        public Criteria andSql_textEqualTo(String value) {
            addCriterion("sql_text =", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textNotEqualTo(String value) {
            addCriterion("sql_text <>", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textGreaterThan(String value) {
            addCriterion("sql_text >", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textGreaterThanOrEqualTo(String value) {
            addCriterion("sql_text >=", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textLessThan(String value) {
            addCriterion("sql_text <", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textLessThanOrEqualTo(String value) {
            addCriterion("sql_text <=", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textLike(String value) {
            addCriterion("sql_text like", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textNotLike(String value) {
            addCriterion("sql_text not like", value, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textIn(List<String> values) {
            addCriterion("sql_text in", values, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textNotIn(List<String> values) {
            addCriterion("sql_text not in", values, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textBetween(String value1, String value2) {
            addCriterion("sql_text between", value1, value2, "sql_text");
            return (Criteria) this;
        }

        public Criteria andSql_textNotBetween(String value1, String value2) {
            addCriterion("sql_text not between", value1, value2, "sql_text");
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