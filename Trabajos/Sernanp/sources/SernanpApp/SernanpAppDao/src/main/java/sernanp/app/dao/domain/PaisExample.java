package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PaisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaisExample() {
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

        public Criteria andIdpaisIsNull() {
            addCriterion("idpais is null");
            return (Criteria) this;
        }

        public Criteria andIdpaisIsNotNull() {
            addCriterion("idpais is not null");
            return (Criteria) this;
        }

        public Criteria andIdpaisEqualTo(Integer value) {
            addCriterion("idpais =", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotEqualTo(Integer value) {
            addCriterion("idpais <>", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisGreaterThan(Integer value) {
            addCriterion("idpais >", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpais >=", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisLessThan(Integer value) {
            addCriterion("idpais <", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisLessThanOrEqualTo(Integer value) {
            addCriterion("idpais <=", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisIn(List<Integer> values) {
            addCriterion("idpais in", values, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotIn(List<Integer> values) {
            addCriterion("idpais not in", values, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisBetween(Integer value1, Integer value2) {
            addCriterion("idpais between", value1, value2, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotBetween(Integer value1, Integer value2) {
            addCriterion("idpais not between", value1, value2, "idpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisIsNull() {
            addCriterion("codpais is null");
            return (Criteria) this;
        }

        public Criteria andCodpaisIsNotNull() {
            addCriterion("codpais is not null");
            return (Criteria) this;
        }

        public Criteria andCodpaisEqualTo(String value) {
            addCriterion("codpais =", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisNotEqualTo(String value) {
            addCriterion("codpais <>", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisGreaterThan(String value) {
            addCriterion("codpais >", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisGreaterThanOrEqualTo(String value) {
            addCriterion("codpais >=", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisLessThan(String value) {
            addCriterion("codpais <", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisLessThanOrEqualTo(String value) {
            addCriterion("codpais <=", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisLike(String value) {
            addCriterion("codpais like", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisNotLike(String value) {
            addCriterion("codpais not like", value, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisIn(List<String> values) {
            addCriterion("codpais in", values, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisNotIn(List<String> values) {
            addCriterion("codpais not in", values, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisBetween(String value1, String value2) {
            addCriterion("codpais between", value1, value2, "codpais");
            return (Criteria) this;
        }

        public Criteria andCodpaisNotBetween(String value1, String value2) {
            addCriterion("codpais not between", value1, value2, "codpais");
            return (Criteria) this;
        }

        public Criteria andNompaisIsNull() {
            addCriterion("nompais is null");
            return (Criteria) this;
        }

        public Criteria andNompaisIsNotNull() {
            addCriterion("nompais is not null");
            return (Criteria) this;
        }

        public Criteria andNompaisEqualTo(String value) {
            addCriterion("nompais =", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisNotEqualTo(String value) {
            addCriterion("nompais <>", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisGreaterThan(String value) {
            addCriterion("nompais >", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisGreaterThanOrEqualTo(String value) {
            addCriterion("nompais >=", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisLessThan(String value) {
            addCriterion("nompais <", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisLessThanOrEqualTo(String value) {
            addCriterion("nompais <=", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisLike(String value) {
            addCriterion("nompais like", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisNotLike(String value) {
            addCriterion("nompais not like", value, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisIn(List<String> values) {
            addCriterion("nompais in", values, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisNotIn(List<String> values) {
            addCriterion("nompais not in", values, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisBetween(String value1, String value2) {
            addCriterion("nompais between", value1, value2, "nompais");
            return (Criteria) this;
        }

        public Criteria andNompaisNotBetween(String value1, String value2) {
            addCriterion("nompais not between", value1, value2, "nompais");
            return (Criteria) this;
        }

        public Criteria andNacpaisIsNull() {
            addCriterion("nacpais is null");
            return (Criteria) this;
        }

        public Criteria andNacpaisIsNotNull() {
            addCriterion("nacpais is not null");
            return (Criteria) this;
        }

        public Criteria andNacpaisEqualTo(String value) {
            addCriterion("nacpais =", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisNotEqualTo(String value) {
            addCriterion("nacpais <>", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisGreaterThan(String value) {
            addCriterion("nacpais >", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisGreaterThanOrEqualTo(String value) {
            addCriterion("nacpais >=", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisLessThan(String value) {
            addCriterion("nacpais <", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisLessThanOrEqualTo(String value) {
            addCriterion("nacpais <=", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisLike(String value) {
            addCriterion("nacpais like", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisNotLike(String value) {
            addCriterion("nacpais not like", value, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisIn(List<String> values) {
            addCriterion("nacpais in", values, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisNotIn(List<String> values) {
            addCriterion("nacpais not in", values, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisBetween(String value1, String value2) {
            addCriterion("nacpais between", value1, value2, "nacpais");
            return (Criteria) this;
        }

        public Criteria andNacpaisNotBetween(String value1, String value2) {
            addCriterion("nacpais not between", value1, value2, "nacpais");
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