package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class ModelOutputExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelOutputExample() {
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

        public Criteria andOutputsIsNull() {
            addCriterion("outputs is null");
            return (Criteria) this;
        }

        public Criteria andOutputsIsNotNull() {
            addCriterion("outputs is not null");
            return (Criteria) this;
        }

        public Criteria andOutputsEqualTo(String value) {
            addCriterion("outputs =", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsNotEqualTo(String value) {
            addCriterion("outputs <>", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsGreaterThan(String value) {
            addCriterion("outputs >", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsGreaterThanOrEqualTo(String value) {
            addCriterion("outputs >=", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsLessThan(String value) {
            addCriterion("outputs <", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsLessThanOrEqualTo(String value) {
            addCriterion("outputs <=", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsLike(String value) {
            addCriterion("outputs like", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsNotLike(String value) {
            addCriterion("outputs not like", value, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsIn(List<String> values) {
            addCriterion("outputs in", values, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsNotIn(List<String> values) {
            addCriterion("outputs not in", values, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsBetween(String value1, String value2) {
            addCriterion("outputs between", value1, value2, "outputs");
            return (Criteria) this;
        }

        public Criteria andOutputsNotBetween(String value1, String value2) {
            addCriterion("outputs not between", value1, value2, "outputs");
            return (Criteria) this;
        }

        public Criteria andInputsIsNull() {
            addCriterion("inputs is null");
            return (Criteria) this;
        }

        public Criteria andInputsIsNotNull() {
            addCriterion("inputs is not null");
            return (Criteria) this;
        }

        public Criteria andInputsEqualTo(String value) {
            addCriterion("inputs =", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsNotEqualTo(String value) {
            addCriterion("inputs <>", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsGreaterThan(String value) {
            addCriterion("inputs >", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsGreaterThanOrEqualTo(String value) {
            addCriterion("inputs >=", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsLessThan(String value) {
            addCriterion("inputs <", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsLessThanOrEqualTo(String value) {
            addCriterion("inputs <=", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsLike(String value) {
            addCriterion("inputs like", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsNotLike(String value) {
            addCriterion("inputs not like", value, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsIn(List<String> values) {
            addCriterion("inputs in", values, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsNotIn(List<String> values) {
            addCriterion("inputs not in", values, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsBetween(String value1, String value2) {
            addCriterion("inputs between", value1, value2, "inputs");
            return (Criteria) this;
        }

        public Criteria andInputsNotBetween(String value1, String value2) {
            addCriterion("inputs not between", value1, value2, "inputs");
            return (Criteria) this;
        }

        public Criteria andFromsIsNull() {
            addCriterion("froms is null");
            return (Criteria) this;
        }

        public Criteria andFromsIsNotNull() {
            addCriterion("froms is not null");
            return (Criteria) this;
        }

        public Criteria andFromsEqualTo(String value) {
            addCriterion("froms =", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsNotEqualTo(String value) {
            addCriterion("froms <>", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsGreaterThan(String value) {
            addCriterion("froms >", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsGreaterThanOrEqualTo(String value) {
            addCriterion("froms >=", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsLessThan(String value) {
            addCriterion("froms <", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsLessThanOrEqualTo(String value) {
            addCriterion("froms <=", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsLike(String value) {
            addCriterion("froms like", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsNotLike(String value) {
            addCriterion("froms not like", value, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsIn(List<String> values) {
            addCriterion("froms in", values, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsNotIn(List<String> values) {
            addCriterion("froms not in", values, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsBetween(String value1, String value2) {
            addCriterion("froms between", value1, value2, "froms");
            return (Criteria) this;
        }

        public Criteria andFromsNotBetween(String value1, String value2) {
            addCriterion("froms not between", value1, value2, "froms");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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