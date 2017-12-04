package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoriaanpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoriaanpExample() {
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

        public Criteria andIdcategoriaanpIsNull() {
            addCriterion("idcategoriaanp is null");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpIsNotNull() {
            addCriterion("idcategoriaanp is not null");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpEqualTo(Integer value) {
            addCriterion("idcategoriaanp =", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotEqualTo(Integer value) {
            addCriterion("idcategoriaanp <>", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpGreaterThan(Integer value) {
            addCriterion("idcategoriaanp >", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcategoriaanp >=", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpLessThan(Integer value) {
            addCriterion("idcategoriaanp <", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpLessThanOrEqualTo(Integer value) {
            addCriterion("idcategoriaanp <=", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpIn(List<Integer> values) {
            addCriterion("idcategoriaanp in", values, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotIn(List<Integer> values) {
            addCriterion("idcategoriaanp not in", values, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpBetween(Integer value1, Integer value2) {
            addCriterion("idcategoriaanp between", value1, value2, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotBetween(Integer value1, Integer value2) {
            addCriterion("idcategoriaanp not between", value1, value2, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpIsNull() {
            addCriterion("codcategoriaanp is null");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpIsNotNull() {
            addCriterion("codcategoriaanp is not null");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpEqualTo(String value) {
            addCriterion("codcategoriaanp =", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpNotEqualTo(String value) {
            addCriterion("codcategoriaanp <>", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpGreaterThan(String value) {
            addCriterion("codcategoriaanp >", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpGreaterThanOrEqualTo(String value) {
            addCriterion("codcategoriaanp >=", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpLessThan(String value) {
            addCriterion("codcategoriaanp <", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpLessThanOrEqualTo(String value) {
            addCriterion("codcategoriaanp <=", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpLike(String value) {
            addCriterion("codcategoriaanp like", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpNotLike(String value) {
            addCriterion("codcategoriaanp not like", value, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpIn(List<String> values) {
            addCriterion("codcategoriaanp in", values, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpNotIn(List<String> values) {
            addCriterion("codcategoriaanp not in", values, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpBetween(String value1, String value2) {
            addCriterion("codcategoriaanp between", value1, value2, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andCodcategoriaanpNotBetween(String value1, String value2) {
            addCriterion("codcategoriaanp not between", value1, value2, "codcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpIsNull() {
            addCriterion("descategoriaanp is null");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpIsNotNull() {
            addCriterion("descategoriaanp is not null");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpEqualTo(String value) {
            addCriterion("descategoriaanp =", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpNotEqualTo(String value) {
            addCriterion("descategoriaanp <>", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpGreaterThan(String value) {
            addCriterion("descategoriaanp >", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpGreaterThanOrEqualTo(String value) {
            addCriterion("descategoriaanp >=", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpLessThan(String value) {
            addCriterion("descategoriaanp <", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpLessThanOrEqualTo(String value) {
            addCriterion("descategoriaanp <=", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpLike(String value) {
            addCriterion("descategoriaanp like", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpNotLike(String value) {
            addCriterion("descategoriaanp not like", value, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpIn(List<String> values) {
            addCriterion("descategoriaanp in", values, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpNotIn(List<String> values) {
            addCriterion("descategoriaanp not in", values, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpBetween(String value1, String value2) {
            addCriterion("descategoriaanp between", value1, value2, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andDescategoriaanpNotBetween(String value1, String value2) {
            addCriterion("descategoriaanp not between", value1, value2, "descategoriaanp");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNull() {
            addCriterion("estado is null");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNotNull() {
            addCriterion("estado is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoEqualTo(Integer value) {
            addCriterion("estado =", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotEqualTo(Integer value) {
            addCriterion("estado <>", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThan(Integer value) {
            addCriterion("estado >", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("estado >=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThan(Integer value) {
            addCriterion("estado <", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThanOrEqualTo(Integer value) {
            addCriterion("estado <=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoIn(List<Integer> values) {
            addCriterion("estado in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotIn(List<Integer> values) {
            addCriterion("estado not in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoBetween(Integer value1, Integer value2) {
            addCriterion("estado between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotBetween(Integer value1, Integer value2) {
            addCriterion("estado not between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpIsNull() {
            addCriterion("siglascategoriaanp is null");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpIsNotNull() {
            addCriterion("siglascategoriaanp is not null");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpEqualTo(String value) {
            addCriterion("siglascategoriaanp =", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpNotEqualTo(String value) {
            addCriterion("siglascategoriaanp <>", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpGreaterThan(String value) {
            addCriterion("siglascategoriaanp >", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpGreaterThanOrEqualTo(String value) {
            addCriterion("siglascategoriaanp >=", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpLessThan(String value) {
            addCriterion("siglascategoriaanp <", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpLessThanOrEqualTo(String value) {
            addCriterion("siglascategoriaanp <=", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpLike(String value) {
            addCriterion("siglascategoriaanp like", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpNotLike(String value) {
            addCriterion("siglascategoriaanp not like", value, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpIn(List<String> values) {
            addCriterion("siglascategoriaanp in", values, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpNotIn(List<String> values) {
            addCriterion("siglascategoriaanp not in", values, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpBetween(String value1, String value2) {
            addCriterion("siglascategoriaanp between", value1, value2, "siglascategoriaanp");
            return (Criteria) this;
        }

        public Criteria andSiglascategoriaanpNotBetween(String value1, String value2) {
            addCriterion("siglascategoriaanp not between", value1, value2, "siglascategoriaanp");
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