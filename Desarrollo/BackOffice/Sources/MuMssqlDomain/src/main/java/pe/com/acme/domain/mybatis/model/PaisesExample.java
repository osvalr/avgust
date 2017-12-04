package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class PaisesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaisesExample() {
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

        public Criteria andId_paisIsNull() {
            addCriterion("id_pais is null");
            return (Criteria) this;
        }

        public Criteria andId_paisIsNotNull() {
            addCriterion("id_pais is not null");
            return (Criteria) this;
        }

        public Criteria andId_paisEqualTo(Integer value) {
            addCriterion("id_pais =", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisNotEqualTo(Integer value) {
            addCriterion("id_pais <>", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisGreaterThan(Integer value) {
            addCriterion("id_pais >", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_pais >=", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisLessThan(Integer value) {
            addCriterion("id_pais <", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisLessThanOrEqualTo(Integer value) {
            addCriterion("id_pais <=", value, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisIn(List<Integer> values) {
            addCriterion("id_pais in", values, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisNotIn(List<Integer> values) {
            addCriterion("id_pais not in", values, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisBetween(Integer value1, Integer value2) {
            addCriterion("id_pais between", value1, value2, "id_pais");
            return (Criteria) this;
        }

        public Criteria andId_paisNotBetween(Integer value1, Integer value2) {
            addCriterion("id_pais not between", value1, value2, "id_pais");
            return (Criteria) this;
        }

        public Criteria andIsoIsNull() {
            addCriterion("iso is null");
            return (Criteria) this;
        }

        public Criteria andIsoIsNotNull() {
            addCriterion("iso is not null");
            return (Criteria) this;
        }

        public Criteria andIsoEqualTo(String value) {
            addCriterion("iso =", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotEqualTo(String value) {
            addCriterion("iso <>", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoGreaterThan(String value) {
            addCriterion("iso >", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoGreaterThanOrEqualTo(String value) {
            addCriterion("iso >=", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLessThan(String value) {
            addCriterion("iso <", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLessThanOrEqualTo(String value) {
            addCriterion("iso <=", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLike(String value) {
            addCriterion("iso like", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotLike(String value) {
            addCriterion("iso not like", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoIn(List<String> values) {
            addCriterion("iso in", values, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotIn(List<String> values) {
            addCriterion("iso not in", values, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoBetween(String value1, String value2) {
            addCriterion("iso between", value1, value2, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotBetween(String value1, String value2) {
            addCriterion("iso not between", value1, value2, "iso");
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