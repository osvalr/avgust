package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembInfoReferidoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembInfoReferidoExample() {
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

        public Criteria andId_referidoIsNull() {
            addCriterion("id_referido is null");
            return (Criteria) this;
        }

        public Criteria andId_referidoIsNotNull() {
            addCriterion("id_referido is not null");
            return (Criteria) this;
        }

        public Criteria andId_referidoEqualTo(Integer value) {
            addCriterion("id_referido =", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoNotEqualTo(Integer value) {
            addCriterion("id_referido <>", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoGreaterThan(Integer value) {
            addCriterion("id_referido >", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_referido >=", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoLessThan(Integer value) {
            addCriterion("id_referido <", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoLessThanOrEqualTo(Integer value) {
            addCriterion("id_referido <=", value, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoIn(List<Integer> values) {
            addCriterion("id_referido in", values, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoNotIn(List<Integer> values) {
            addCriterion("id_referido not in", values, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoBetween(Integer value1, Integer value2) {
            addCriterion("id_referido between", value1, value2, "id_referido");
            return (Criteria) this;
        }

        public Criteria andId_referidoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_referido not between", value1, value2, "id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoIsNull() {
            addCriterion("memb___id_referido is null");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoIsNotNull() {
            addCriterion("memb___id_referido is not null");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoEqualTo(String value) {
            addCriterion("memb___id_referido =", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoNotEqualTo(String value) {
            addCriterion("memb___id_referido <>", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoGreaterThan(String value) {
            addCriterion("memb___id_referido >", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoGreaterThanOrEqualTo(String value) {
            addCriterion("memb___id_referido >=", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoLessThan(String value) {
            addCriterion("memb___id_referido <", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoLessThanOrEqualTo(String value) {
            addCriterion("memb___id_referido <=", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoLike(String value) {
            addCriterion("memb___id_referido like", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoNotLike(String value) {
            addCriterion("memb___id_referido not like", value, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoIn(List<String> values) {
            addCriterion("memb___id_referido in", values, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoNotIn(List<String> values) {
            addCriterion("memb___id_referido not in", values, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoBetween(String value1, String value2) {
            addCriterion("memb___id_referido between", value1, value2, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___id_referidoNotBetween(String value1, String value2) {
            addCriterion("memb___id_referido not between", value1, value2, "memb___id_referido");
            return (Criteria) this;
        }

        public Criteria andMemb___idIsNull() {
            addCriterion("memb___id is null");
            return (Criteria) this;
        }

        public Criteria andMemb___idIsNotNull() {
            addCriterion("memb___id is not null");
            return (Criteria) this;
        }

        public Criteria andMemb___idEqualTo(String value) {
            addCriterion("memb___id =", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotEqualTo(String value) {
            addCriterion("memb___id <>", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idGreaterThan(String value) {
            addCriterion("memb___id >", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idGreaterThanOrEqualTo(String value) {
            addCriterion("memb___id >=", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLessThan(String value) {
            addCriterion("memb___id <", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLessThanOrEqualTo(String value) {
            addCriterion("memb___id <=", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLike(String value) {
            addCriterion("memb___id like", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotLike(String value) {
            addCriterion("memb___id not like", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idIn(List<String> values) {
            addCriterion("memb___id in", values, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotIn(List<String> values) {
            addCriterion("memb___id not in", values, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idBetween(String value1, String value2) {
            addCriterion("memb___id between", value1, value2, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotBetween(String value1, String value2) {
            addCriterion("memb___id not between", value1, value2, "memb___id");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIsNull() {
            addCriterion("fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIsNotNull() {
            addCriterion("fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_registroEqualTo(Date value) {
            addCriterion("fecha_registro =", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotEqualTo(Date value) {
            addCriterion("fecha_registro <>", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroGreaterThan(Date value) {
            addCriterion("fecha_registro >", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha_registro >=", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroLessThan(Date value) {
            addCriterion("fecha_registro <", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroLessThanOrEqualTo(Date value) {
            addCriterion("fecha_registro <=", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIn(List<Date> values) {
            addCriterion("fecha_registro in", values, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotIn(List<Date> values) {
            addCriterion("fecha_registro not in", values, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroBetween(Date value1, Date value2) {
            addCriterion("fecha_registro between", value1, value2, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotBetween(Date value1, Date value2) {
            addCriterion("fecha_registro not between", value1, value2, "fecha_registro");
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