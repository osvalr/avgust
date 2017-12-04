package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class SedeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SedeExample() {
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

        public Criteria andDessedeIsNull() {
            addCriterion("dessede is null");
            return (Criteria) this;
        }

        public Criteria andDessedeIsNotNull() {
            addCriterion("dessede is not null");
            return (Criteria) this;
        }

        public Criteria andDessedeEqualTo(String value) {
            addCriterion("dessede =", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeNotEqualTo(String value) {
            addCriterion("dessede <>", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeGreaterThan(String value) {
            addCriterion("dessede >", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeGreaterThanOrEqualTo(String value) {
            addCriterion("dessede >=", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeLessThan(String value) {
            addCriterion("dessede <", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeLessThanOrEqualTo(String value) {
            addCriterion("dessede <=", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeLike(String value) {
            addCriterion("dessede like", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeNotLike(String value) {
            addCriterion("dessede not like", value, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeIn(List<String> values) {
            addCriterion("dessede in", values, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeNotIn(List<String> values) {
            addCriterion("dessede not in", values, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeBetween(String value1, String value2) {
            addCriterion("dessede between", value1, value2, "dessede");
            return (Criteria) this;
        }

        public Criteria andDessedeNotBetween(String value1, String value2) {
            addCriterion("dessede not between", value1, value2, "dessede");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNull() {
            addCriterion("direccion is null");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNotNull() {
            addCriterion("direccion is not null");
            return (Criteria) this;
        }

        public Criteria andDireccionEqualTo(String value) {
            addCriterion("direccion =", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotEqualTo(String value) {
            addCriterion("direccion <>", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThan(String value) {
            addCriterion("direccion >", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThanOrEqualTo(String value) {
            addCriterion("direccion >=", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThan(String value) {
            addCriterion("direccion <", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThanOrEqualTo(String value) {
            addCriterion("direccion <=", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLike(String value) {
            addCriterion("direccion like", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotLike(String value) {
            addCriterion("direccion not like", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionIn(List<String> values) {
            addCriterion("direccion in", values, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotIn(List<String> values) {
            addCriterion("direccion not in", values, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionBetween(String value1, String value2) {
            addCriterion("direccion between", value1, value2, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotBetween(String value1, String value2) {
            addCriterion("direccion not between", value1, value2, "direccion");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalIsNull() {
            addCriterion("idareanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalIsNotNull() {
            addCriterion("idareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalEqualTo(Integer value) {
            addCriterion("idareanatural =", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotEqualTo(Integer value) {
            addCriterion("idareanatural <>", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalGreaterThan(Integer value) {
            addCriterion("idareanatural >", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idareanatural >=", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalLessThan(Integer value) {
            addCriterion("idareanatural <", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idareanatural <=", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalIn(List<Integer> values) {
            addCriterion("idareanatural in", values, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotIn(List<Integer> values) {
            addCriterion("idareanatural not in", values, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idareanatural between", value1, value2, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idareanatural not between", value1, value2, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalIsNull() {
            addCriterion("idsedeprincipal is null");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalIsNotNull() {
            addCriterion("idsedeprincipal is not null");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalEqualTo(Integer value) {
            addCriterion("idsedeprincipal =", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalNotEqualTo(Integer value) {
            addCriterion("idsedeprincipal <>", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalGreaterThan(Integer value) {
            addCriterion("idsedeprincipal >", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idsedeprincipal >=", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalLessThan(Integer value) {
            addCriterion("idsedeprincipal <", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalLessThanOrEqualTo(Integer value) {
            addCriterion("idsedeprincipal <=", value, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalIn(List<Integer> values) {
            addCriterion("idsedeprincipal in", values, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalNotIn(List<Integer> values) {
            addCriterion("idsedeprincipal not in", values, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalBetween(Integer value1, Integer value2) {
            addCriterion("idsedeprincipal between", value1, value2, "idsedeprincipal");
            return (Criteria) this;
        }

        public Criteria andIdsedeprincipalNotBetween(Integer value1, Integer value2) {
            addCriterion("idsedeprincipal not between", value1, value2, "idsedeprincipal");
            return (Criteria) this;
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

        public Criteria andInt_sede_principalIsNull() {
            addCriterion("int_sede_principal is null");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalIsNotNull() {
            addCriterion("int_sede_principal is not null");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalEqualTo(Integer value) {
            addCriterion("int_sede_principal =", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalNotEqualTo(Integer value) {
            addCriterion("int_sede_principal <>", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalGreaterThan(Integer value) {
            addCriterion("int_sede_principal >", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_sede_principal >=", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalLessThan(Integer value) {
            addCriterion("int_sede_principal <", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalLessThanOrEqualTo(Integer value) {
            addCriterion("int_sede_principal <=", value, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalIn(List<Integer> values) {
            addCriterion("int_sede_principal in", values, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalNotIn(List<Integer> values) {
            addCriterion("int_sede_principal not in", values, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalBetween(Integer value1, Integer value2) {
            addCriterion("int_sede_principal between", value1, value2, "int_sede_principal");
            return (Criteria) this;
        }

        public Criteria andInt_sede_principalNotBetween(Integer value1, Integer value2) {
            addCriterion("int_sede_principal not between", value1, value2, "int_sede_principal");
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