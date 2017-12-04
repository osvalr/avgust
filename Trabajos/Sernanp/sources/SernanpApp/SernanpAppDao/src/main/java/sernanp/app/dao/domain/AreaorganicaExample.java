package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class AreaorganicaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaorganicaExample() {
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

        public Criteria andIdareaIsNull() {
            addCriterion("idarea is null");
            return (Criteria) this;
        }

        public Criteria andIdareaIsNotNull() {
            addCriterion("idarea is not null");
            return (Criteria) this;
        }

        public Criteria andIdareaEqualTo(Integer value) {
            addCriterion("idarea =", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotEqualTo(Integer value) {
            addCriterion("idarea <>", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaGreaterThan(Integer value) {
            addCriterion("idarea >", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idarea >=", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaLessThan(Integer value) {
            addCriterion("idarea <", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaLessThanOrEqualTo(Integer value) {
            addCriterion("idarea <=", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaIn(List<Integer> values) {
            addCriterion("idarea in", values, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotIn(List<Integer> values) {
            addCriterion("idarea not in", values, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaBetween(Integer value1, Integer value2) {
            addCriterion("idarea between", value1, value2, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotBetween(Integer value1, Integer value2) {
            addCriterion("idarea not between", value1, value2, "idarea");
            return (Criteria) this;
        }

        public Criteria andCodareaIsNull() {
            addCriterion("codarea is null");
            return (Criteria) this;
        }

        public Criteria andCodareaIsNotNull() {
            addCriterion("codarea is not null");
            return (Criteria) this;
        }

        public Criteria andCodareaEqualTo(String value) {
            addCriterion("codarea =", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaNotEqualTo(String value) {
            addCriterion("codarea <>", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaGreaterThan(String value) {
            addCriterion("codarea >", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaGreaterThanOrEqualTo(String value) {
            addCriterion("codarea >=", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaLessThan(String value) {
            addCriterion("codarea <", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaLessThanOrEqualTo(String value) {
            addCriterion("codarea <=", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaLike(String value) {
            addCriterion("codarea like", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaNotLike(String value) {
            addCriterion("codarea not like", value, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaIn(List<String> values) {
            addCriterion("codarea in", values, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaNotIn(List<String> values) {
            addCriterion("codarea not in", values, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaBetween(String value1, String value2) {
            addCriterion("codarea between", value1, value2, "codarea");
            return (Criteria) this;
        }

        public Criteria andCodareaNotBetween(String value1, String value2) {
            addCriterion("codarea not between", value1, value2, "codarea");
            return (Criteria) this;
        }

        public Criteria andDesareaIsNull() {
            addCriterion("desarea is null");
            return (Criteria) this;
        }

        public Criteria andDesareaIsNotNull() {
            addCriterion("desarea is not null");
            return (Criteria) this;
        }

        public Criteria andDesareaEqualTo(String value) {
            addCriterion("desarea =", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaNotEqualTo(String value) {
            addCriterion("desarea <>", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaGreaterThan(String value) {
            addCriterion("desarea >", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaGreaterThanOrEqualTo(String value) {
            addCriterion("desarea >=", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaLessThan(String value) {
            addCriterion("desarea <", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaLessThanOrEqualTo(String value) {
            addCriterion("desarea <=", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaLike(String value) {
            addCriterion("desarea like", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaNotLike(String value) {
            addCriterion("desarea not like", value, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaIn(List<String> values) {
            addCriterion("desarea in", values, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaNotIn(List<String> values) {
            addCriterion("desarea not in", values, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaBetween(String value1, String value2) {
            addCriterion("desarea between", value1, value2, "desarea");
            return (Criteria) this;
        }

        public Criteria andDesareaNotBetween(String value1, String value2) {
            addCriterion("desarea not between", value1, value2, "desarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaIsNull() {
            addCriterion("idtipoarea is null");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaIsNotNull() {
            addCriterion("idtipoarea is not null");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaEqualTo(Integer value) {
            addCriterion("idtipoarea =", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaNotEqualTo(Integer value) {
            addCriterion("idtipoarea <>", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaGreaterThan(Integer value) {
            addCriterion("idtipoarea >", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idtipoarea >=", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaLessThan(Integer value) {
            addCriterion("idtipoarea <", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaLessThanOrEqualTo(Integer value) {
            addCriterion("idtipoarea <=", value, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaIn(List<Integer> values) {
            addCriterion("idtipoarea in", values, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaNotIn(List<Integer> values) {
            addCriterion("idtipoarea not in", values, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaBetween(Integer value1, Integer value2) {
            addCriterion("idtipoarea between", value1, value2, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andIdtipoareaNotBetween(Integer value1, Integer value2) {
            addCriterion("idtipoarea not between", value1, value2, "idtipoarea");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaIsNull() {
            addCriterion("telefonoareaorganica is null");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaIsNotNull() {
            addCriterion("telefonoareaorganica is not null");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaEqualTo(Integer value) {
            addCriterion("telefonoareaorganica =", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaNotEqualTo(Integer value) {
            addCriterion("telefonoareaorganica <>", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaGreaterThan(Integer value) {
            addCriterion("telefonoareaorganica >", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaGreaterThanOrEqualTo(Integer value) {
            addCriterion("telefonoareaorganica >=", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaLessThan(Integer value) {
            addCriterion("telefonoareaorganica <", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaLessThanOrEqualTo(Integer value) {
            addCriterion("telefonoareaorganica <=", value, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaIn(List<Integer> values) {
            addCriterion("telefonoareaorganica in", values, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaNotIn(List<Integer> values) {
            addCriterion("telefonoareaorganica not in", values, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaBetween(Integer value1, Integer value2) {
            addCriterion("telefonoareaorganica between", value1, value2, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andTelefonoareaorganicaNotBetween(Integer value1, Integer value2) {
            addCriterion("telefonoareaorganica not between", value1, value2, "telefonoareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaIsNull() {
            addCriterion("direccionareaorganica is null");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaIsNotNull() {
            addCriterion("direccionareaorganica is not null");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaEqualTo(String value) {
            addCriterion("direccionareaorganica =", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaNotEqualTo(String value) {
            addCriterion("direccionareaorganica <>", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaGreaterThan(String value) {
            addCriterion("direccionareaorganica >", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaGreaterThanOrEqualTo(String value) {
            addCriterion("direccionareaorganica >=", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaLessThan(String value) {
            addCriterion("direccionareaorganica <", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaLessThanOrEqualTo(String value) {
            addCriterion("direccionareaorganica <=", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaLike(String value) {
            addCriterion("direccionareaorganica like", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaNotLike(String value) {
            addCriterion("direccionareaorganica not like", value, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaIn(List<String> values) {
            addCriterion("direccionareaorganica in", values, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaNotIn(List<String> values) {
            addCriterion("direccionareaorganica not in", values, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaBetween(String value1, String value2) {
            addCriterion("direccionareaorganica between", value1, value2, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andDireccionareaorganicaNotBetween(String value1, String value2) {
            addCriterion("direccionareaorganica not between", value1, value2, "direccionareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaIsNull() {
            addCriterion("faxareaorganica is null");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaIsNotNull() {
            addCriterion("faxareaorganica is not null");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaEqualTo(Integer value) {
            addCriterion("faxareaorganica =", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaNotEqualTo(Integer value) {
            addCriterion("faxareaorganica <>", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaGreaterThan(Integer value) {
            addCriterion("faxareaorganica >", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaGreaterThanOrEqualTo(Integer value) {
            addCriterion("faxareaorganica >=", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaLessThan(Integer value) {
            addCriterion("faxareaorganica <", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaLessThanOrEqualTo(Integer value) {
            addCriterion("faxareaorganica <=", value, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaIn(List<Integer> values) {
            addCriterion("faxareaorganica in", values, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaNotIn(List<Integer> values) {
            addCriterion("faxareaorganica not in", values, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaBetween(Integer value1, Integer value2) {
            addCriterion("faxareaorganica between", value1, value2, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andFaxareaorganicaNotBetween(Integer value1, Integer value2) {
            addCriterion("faxareaorganica not between", value1, value2, "faxareaorganica");
            return (Criteria) this;
        }

        public Criteria andIdsedeIsNull() {
            addCriterion("idsede is null");
            return (Criteria) this;
        }

        public Criteria andIdsedeIsNotNull() {
            addCriterion("idsede is not null");
            return (Criteria) this;
        }

        public Criteria andIdsedeEqualTo(Integer value) {
            addCriterion("idsede =", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeNotEqualTo(Integer value) {
            addCriterion("idsede <>", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeGreaterThan(Integer value) {
            addCriterion("idsede >", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeGreaterThanOrEqualTo(Integer value) {
            addCriterion("idsede >=", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeLessThan(Integer value) {
            addCriterion("idsede <", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeLessThanOrEqualTo(Integer value) {
            addCriterion("idsede <=", value, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeIn(List<Integer> values) {
            addCriterion("idsede in", values, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeNotIn(List<Integer> values) {
            addCriterion("idsede not in", values, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeBetween(Integer value1, Integer value2) {
            addCriterion("idsede between", value1, value2, "idsede");
            return (Criteria) this;
        }

        public Criteria andIdsedeNotBetween(Integer value1, Integer value2) {
            addCriterion("idsede not between", value1, value2, "idsede");
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