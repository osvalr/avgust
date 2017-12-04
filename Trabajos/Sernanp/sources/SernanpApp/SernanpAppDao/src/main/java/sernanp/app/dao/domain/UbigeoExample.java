package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class UbigeoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UbigeoExample() {
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

        public Criteria andIdubigeoIsNull() {
            addCriterion("idubigeo is null");
            return (Criteria) this;
        }

        public Criteria andIdubigeoIsNotNull() {
            addCriterion("idubigeo is not null");
            return (Criteria) this;
        }

        public Criteria andIdubigeoEqualTo(Integer value) {
            addCriterion("idubigeo =", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotEqualTo(Integer value) {
            addCriterion("idubigeo <>", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoGreaterThan(Integer value) {
            addCriterion("idubigeo >", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idubigeo >=", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoLessThan(Integer value) {
            addCriterion("idubigeo <", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoLessThanOrEqualTo(Integer value) {
            addCriterion("idubigeo <=", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoIn(List<Integer> values) {
            addCriterion("idubigeo in", values, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotIn(List<Integer> values) {
            addCriterion("idubigeo not in", values, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoBetween(Integer value1, Integer value2) {
            addCriterion("idubigeo between", value1, value2, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotBetween(Integer value1, Integer value2) {
            addCriterion("idubigeo not between", value1, value2, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andCoddptoIsNull() {
            addCriterion("coddpto is null");
            return (Criteria) this;
        }

        public Criteria andCoddptoIsNotNull() {
            addCriterion("coddpto is not null");
            return (Criteria) this;
        }

        public Criteria andCoddptoEqualTo(String value) {
            addCriterion("coddpto =", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoNotEqualTo(String value) {
            addCriterion("coddpto <>", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoGreaterThan(String value) {
            addCriterion("coddpto >", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoGreaterThanOrEqualTo(String value) {
            addCriterion("coddpto >=", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoLessThan(String value) {
            addCriterion("coddpto <", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoLessThanOrEqualTo(String value) {
            addCriterion("coddpto <=", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoLike(String value) {
            addCriterion("coddpto like", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoNotLike(String value) {
            addCriterion("coddpto not like", value, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoIn(List<String> values) {
            addCriterion("coddpto in", values, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoNotIn(List<String> values) {
            addCriterion("coddpto not in", values, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoBetween(String value1, String value2) {
            addCriterion("coddpto between", value1, value2, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCoddptoNotBetween(String value1, String value2) {
            addCriterion("coddpto not between", value1, value2, "coddpto");
            return (Criteria) this;
        }

        public Criteria andCodprovIsNull() {
            addCriterion("codprov is null");
            return (Criteria) this;
        }

        public Criteria andCodprovIsNotNull() {
            addCriterion("codprov is not null");
            return (Criteria) this;
        }

        public Criteria andCodprovEqualTo(String value) {
            addCriterion("codprov =", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovNotEqualTo(String value) {
            addCriterion("codprov <>", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovGreaterThan(String value) {
            addCriterion("codprov >", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovGreaterThanOrEqualTo(String value) {
            addCriterion("codprov >=", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovLessThan(String value) {
            addCriterion("codprov <", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovLessThanOrEqualTo(String value) {
            addCriterion("codprov <=", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovLike(String value) {
            addCriterion("codprov like", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovNotLike(String value) {
            addCriterion("codprov not like", value, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovIn(List<String> values) {
            addCriterion("codprov in", values, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovNotIn(List<String> values) {
            addCriterion("codprov not in", values, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovBetween(String value1, String value2) {
            addCriterion("codprov between", value1, value2, "codprov");
            return (Criteria) this;
        }

        public Criteria andCodprovNotBetween(String value1, String value2) {
            addCriterion("codprov not between", value1, value2, "codprov");
            return (Criteria) this;
        }

        public Criteria andCoddistIsNull() {
            addCriterion("coddist is null");
            return (Criteria) this;
        }

        public Criteria andCoddistIsNotNull() {
            addCriterion("coddist is not null");
            return (Criteria) this;
        }

        public Criteria andCoddistEqualTo(String value) {
            addCriterion("coddist =", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistNotEqualTo(String value) {
            addCriterion("coddist <>", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistGreaterThan(String value) {
            addCriterion("coddist >", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistGreaterThanOrEqualTo(String value) {
            addCriterion("coddist >=", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistLessThan(String value) {
            addCriterion("coddist <", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistLessThanOrEqualTo(String value) {
            addCriterion("coddist <=", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistLike(String value) {
            addCriterion("coddist like", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistNotLike(String value) {
            addCriterion("coddist not like", value, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistIn(List<String> values) {
            addCriterion("coddist in", values, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistNotIn(List<String> values) {
            addCriterion("coddist not in", values, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistBetween(String value1, String value2) {
            addCriterion("coddist between", value1, value2, "coddist");
            return (Criteria) this;
        }

        public Criteria andCoddistNotBetween(String value1, String value2) {
            addCriterion("coddist not between", value1, value2, "coddist");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
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