package pe.com.jrtotem.app.generator.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class InfoDbConnectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoDbConnectionExample() {
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

        public Criteria andEngineIsNull() {
            addCriterion("engine is null");
            return (Criteria) this;
        }

        public Criteria andEngineIsNotNull() {
            addCriterion("engine is not null");
            return (Criteria) this;
        }

        public Criteria andEngineEqualTo(Integer value) {
            addCriterion("engine =", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotEqualTo(Integer value) {
            addCriterion("engine <>", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThan(Integer value) {
            addCriterion("engine >", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThanOrEqualTo(Integer value) {
            addCriterion("engine >=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThan(Integer value) {
            addCriterion("engine <", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThanOrEqualTo(Integer value) {
            addCriterion("engine <=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineIn(List<Integer> values) {
            addCriterion("engine in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotIn(List<Integer> values) {
            addCriterion("engine not in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineBetween(Integer value1, Integer value2) {
            addCriterion("engine between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotBetween(Integer value1, Integer value2) {
            addCriterion("engine not between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andJdbc_classIsNull() {
            addCriterion("jdbc_class is null");
            return (Criteria) this;
        }

        public Criteria andJdbc_classIsNotNull() {
            addCriterion("jdbc_class is not null");
            return (Criteria) this;
        }

        public Criteria andJdbc_classEqualTo(String value) {
            addCriterion("jdbc_class =", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classNotEqualTo(String value) {
            addCriterion("jdbc_class <>", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classGreaterThan(String value) {
            addCriterion("jdbc_class >", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classGreaterThanOrEqualTo(String value) {
            addCriterion("jdbc_class >=", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classLessThan(String value) {
            addCriterion("jdbc_class <", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classLessThanOrEqualTo(String value) {
            addCriterion("jdbc_class <=", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classLike(String value) {
            addCriterion("jdbc_class like", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classNotLike(String value) {
            addCriterion("jdbc_class not like", value, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classIn(List<String> values) {
            addCriterion("jdbc_class in", values, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classNotIn(List<String> values) {
            addCriterion("jdbc_class not in", values, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classBetween(String value1, String value2) {
            addCriterion("jdbc_class between", value1, value2, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andJdbc_classNotBetween(String value1, String value2) {
            addCriterion("jdbc_class not between", value1, value2, "jdbc_class");
            return (Criteria) this;
        }

        public Criteria andName_userIsNull() {
            addCriterion("name_user is null");
            return (Criteria) this;
        }

        public Criteria andName_userIsNotNull() {
            addCriterion("name_user is not null");
            return (Criteria) this;
        }

        public Criteria andName_userEqualTo(String value) {
            addCriterion("name_user =", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userNotEqualTo(String value) {
            addCriterion("name_user <>", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userGreaterThan(String value) {
            addCriterion("name_user >", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userGreaterThanOrEqualTo(String value) {
            addCriterion("name_user >=", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userLessThan(String value) {
            addCriterion("name_user <", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userLessThanOrEqualTo(String value) {
            addCriterion("name_user <=", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userLike(String value) {
            addCriterion("name_user like", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userNotLike(String value) {
            addCriterion("name_user not like", value, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userIn(List<String> values) {
            addCriterion("name_user in", values, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userNotIn(List<String> values) {
            addCriterion("name_user not in", values, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userBetween(String value1, String value2) {
            addCriterion("name_user between", value1, value2, "name_user");
            return (Criteria) this;
        }

        public Criteria andName_userNotBetween(String value1, String value2) {
            addCriterion("name_user not between", value1, value2, "name_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userIsNull() {
            addCriterion("password_user is null");
            return (Criteria) this;
        }

        public Criteria andPassword_userIsNotNull() {
            addCriterion("password_user is not null");
            return (Criteria) this;
        }

        public Criteria andPassword_userEqualTo(String value) {
            addCriterion("password_user =", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userNotEqualTo(String value) {
            addCriterion("password_user <>", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userGreaterThan(String value) {
            addCriterion("password_user >", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userGreaterThanOrEqualTo(String value) {
            addCriterion("password_user >=", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userLessThan(String value) {
            addCriterion("password_user <", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userLessThanOrEqualTo(String value) {
            addCriterion("password_user <=", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userLike(String value) {
            addCriterion("password_user like", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userNotLike(String value) {
            addCriterion("password_user not like", value, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userIn(List<String> values) {
            addCriterion("password_user in", values, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userNotIn(List<String> values) {
            addCriterion("password_user not in", values, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userBetween(String value1, String value2) {
            addCriterion("password_user between", value1, value2, "password_user");
            return (Criteria) this;
        }

        public Criteria andPassword_userNotBetween(String value1, String value2) {
            addCriterion("password_user not between", value1, value2, "password_user");
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