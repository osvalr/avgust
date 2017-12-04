package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class BuildSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildSettingExample() {
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

        public Criteria andId_build_settingIsNull() {
            addCriterion("id_build_setting is null");
            return (Criteria) this;
        }

        public Criteria andId_build_settingIsNotNull() {
            addCriterion("id_build_setting is not null");
            return (Criteria) this;
        }

        public Criteria andId_build_settingEqualTo(Integer value) {
            addCriterion("id_build_setting =", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingNotEqualTo(Integer value) {
            addCriterion("id_build_setting <>", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingGreaterThan(Integer value) {
            addCriterion("id_build_setting >", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_build_setting >=", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingLessThan(Integer value) {
            addCriterion("id_build_setting <", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingLessThanOrEqualTo(Integer value) {
            addCriterion("id_build_setting <=", value, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingIn(List<Integer> values) {
            addCriterion("id_build_setting in", values, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingNotIn(List<Integer> values) {
            addCriterion("id_build_setting not in", values, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingBetween(Integer value1, Integer value2) {
            addCriterion("id_build_setting between", value1, value2, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andId_build_settingNotBetween(Integer value1, Integer value2) {
            addCriterion("id_build_setting not between", value1, value2, "id_build_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingIsNull() {
            addCriterion("name_setting is null");
            return (Criteria) this;
        }

        public Criteria andName_settingIsNotNull() {
            addCriterion("name_setting is not null");
            return (Criteria) this;
        }

        public Criteria andName_settingEqualTo(String value) {
            addCriterion("name_setting =", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingNotEqualTo(String value) {
            addCriterion("name_setting <>", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingGreaterThan(String value) {
            addCriterion("name_setting >", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingGreaterThanOrEqualTo(String value) {
            addCriterion("name_setting >=", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingLessThan(String value) {
            addCriterion("name_setting <", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingLessThanOrEqualTo(String value) {
            addCriterion("name_setting <=", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingLike(String value) {
            addCriterion("name_setting like", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingNotLike(String value) {
            addCriterion("name_setting not like", value, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingIn(List<String> values) {
            addCriterion("name_setting in", values, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingNotIn(List<String> values) {
            addCriterion("name_setting not in", values, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingBetween(String value1, String value2) {
            addCriterion("name_setting between", value1, value2, "name_setting");
            return (Criteria) this;
        }

        public Criteria andName_settingNotBetween(String value1, String value2) {
            addCriterion("name_setting not between", value1, value2, "name_setting");
            return (Criteria) this;
        }

        public Criteria andMain_pathIsNull() {
            addCriterion("main_path is null");
            return (Criteria) this;
        }

        public Criteria andMain_pathIsNotNull() {
            addCriterion("main_path is not null");
            return (Criteria) this;
        }

        public Criteria andMain_pathEqualTo(String value) {
            addCriterion("main_path =", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathNotEqualTo(String value) {
            addCriterion("main_path <>", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathGreaterThan(String value) {
            addCriterion("main_path >", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathGreaterThanOrEqualTo(String value) {
            addCriterion("main_path >=", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathLessThan(String value) {
            addCriterion("main_path <", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathLessThanOrEqualTo(String value) {
            addCriterion("main_path <=", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathLike(String value) {
            addCriterion("main_path like", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathNotLike(String value) {
            addCriterion("main_path not like", value, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathIn(List<String> values) {
            addCriterion("main_path in", values, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathNotIn(List<String> values) {
            addCriterion("main_path not in", values, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathBetween(String value1, String value2) {
            addCriterion("main_path between", value1, value2, "main_path");
            return (Criteria) this;
        }

        public Criteria andMain_pathNotBetween(String value1, String value2) {
            addCriterion("main_path not between", value1, value2, "main_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathIsNull() {
            addCriterion("model_path is null");
            return (Criteria) this;
        }

        public Criteria andModel_pathIsNotNull() {
            addCriterion("model_path is not null");
            return (Criteria) this;
        }

        public Criteria andModel_pathEqualTo(String value) {
            addCriterion("model_path =", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathNotEqualTo(String value) {
            addCriterion("model_path <>", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathGreaterThan(String value) {
            addCriterion("model_path >", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathGreaterThanOrEqualTo(String value) {
            addCriterion("model_path >=", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathLessThan(String value) {
            addCriterion("model_path <", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathLessThanOrEqualTo(String value) {
            addCriterion("model_path <=", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathLike(String value) {
            addCriterion("model_path like", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathNotLike(String value) {
            addCriterion("model_path not like", value, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathIn(List<String> values) {
            addCriterion("model_path in", values, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathNotIn(List<String> values) {
            addCriterion("model_path not in", values, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathBetween(String value1, String value2) {
            addCriterion("model_path between", value1, value2, "model_path");
            return (Criteria) this;
        }

        public Criteria andModel_pathNotBetween(String value1, String value2) {
            addCriterion("model_path not between", value1, value2, "model_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathIsNull() {
            addCriterion("criteria_path is null");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathIsNotNull() {
            addCriterion("criteria_path is not null");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathEqualTo(String value) {
            addCriterion("criteria_path =", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathNotEqualTo(String value) {
            addCriterion("criteria_path <>", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathGreaterThan(String value) {
            addCriterion("criteria_path >", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathGreaterThanOrEqualTo(String value) {
            addCriterion("criteria_path >=", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathLessThan(String value) {
            addCriterion("criteria_path <", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathLessThanOrEqualTo(String value) {
            addCriterion("criteria_path <=", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathLike(String value) {
            addCriterion("criteria_path like", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathNotLike(String value) {
            addCriterion("criteria_path not like", value, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathIn(List<String> values) {
            addCriterion("criteria_path in", values, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathNotIn(List<String> values) {
            addCriterion("criteria_path not in", values, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathBetween(String value1, String value2) {
            addCriterion("criteria_path between", value1, value2, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andCriteria_pathNotBetween(String value1, String value2) {
            addCriterion("criteria_path not between", value1, value2, "criteria_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathIsNull() {
            addCriterion("mapper_path is null");
            return (Criteria) this;
        }

        public Criteria andMapper_pathIsNotNull() {
            addCriterion("mapper_path is not null");
            return (Criteria) this;
        }

        public Criteria andMapper_pathEqualTo(String value) {
            addCriterion("mapper_path =", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathNotEqualTo(String value) {
            addCriterion("mapper_path <>", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathGreaterThan(String value) {
            addCriterion("mapper_path >", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathGreaterThanOrEqualTo(String value) {
            addCriterion("mapper_path >=", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathLessThan(String value) {
            addCriterion("mapper_path <", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathLessThanOrEqualTo(String value) {
            addCriterion("mapper_path <=", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathLike(String value) {
            addCriterion("mapper_path like", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathNotLike(String value) {
            addCriterion("mapper_path not like", value, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathIn(List<String> values) {
            addCriterion("mapper_path in", values, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathNotIn(List<String> values) {
            addCriterion("mapper_path not in", values, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathBetween(String value1, String value2) {
            addCriterion("mapper_path between", value1, value2, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andMapper_pathNotBetween(String value1, String value2) {
            addCriterion("mapper_path not between", value1, value2, "mapper_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathIsNull() {
            addCriterion("xml_path is null");
            return (Criteria) this;
        }

        public Criteria andXml_pathIsNotNull() {
            addCriterion("xml_path is not null");
            return (Criteria) this;
        }

        public Criteria andXml_pathEqualTo(String value) {
            addCriterion("xml_path =", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathNotEqualTo(String value) {
            addCriterion("xml_path <>", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathGreaterThan(String value) {
            addCriterion("xml_path >", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathGreaterThanOrEqualTo(String value) {
            addCriterion("xml_path >=", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathLessThan(String value) {
            addCriterion("xml_path <", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathLessThanOrEqualTo(String value) {
            addCriterion("xml_path <=", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathLike(String value) {
            addCriterion("xml_path like", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathNotLike(String value) {
            addCriterion("xml_path not like", value, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathIn(List<String> values) {
            addCriterion("xml_path in", values, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathNotIn(List<String> values) {
            addCriterion("xml_path not in", values, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathBetween(String value1, String value2) {
            addCriterion("xml_path between", value1, value2, "xml_path");
            return (Criteria) this;
        }

        public Criteria andXml_pathNotBetween(String value1, String value2) {
            addCriterion("xml_path not between", value1, value2, "xml_path");
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