package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPersonalEntidadBancariaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalEntidadBancariaExample() {
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

        public Criteria andSrl_id_personal_entidad_bancariaIsNull() {
            addCriterion("srl_id_personal_entidad_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaIsNotNull() {
            addCriterion("srl_id_personal_entidad_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaEqualTo(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria =", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaNotEqualTo(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria <>", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaGreaterThan(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria >", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria >=", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaLessThan(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria <", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personal_entidad_bancaria <=", value, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaIn(List<Integer> values) {
            addCriterion("srl_id_personal_entidad_bancaria in", values, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaNotIn(List<Integer> values) {
            addCriterion("srl_id_personal_entidad_bancaria not in", values, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personal_entidad_bancaria between", value1, value2, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personal_entidad_bancariaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personal_entidad_bancaria not between", value1, value2, "srl_id_personal_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNull() {
            addCriterion("idpersonal is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNotNull() {
            addCriterion("idpersonal is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalEqualTo(Integer value) {
            addCriterion("idpersonal =", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotEqualTo(Integer value) {
            addCriterion("idpersonal <>", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThan(Integer value) {
            addCriterion("idpersonal >", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonal >=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThan(Integer value) {
            addCriterion("idpersonal <", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonal <=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIn(List<Integer> values) {
            addCriterion("idpersonal in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotIn(List<Integer> values) {
            addCriterion("idpersonal not in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal not between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNull() {
            addCriterion("srl_id_entidad_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNotNull() {
            addCriterion("srl_id_entidad_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria =", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <>", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria >", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria >=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria <", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria not in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria not between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNull() {
            addCriterion("var_numero_cuenta_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNotNull() {
            addCriterion("var_numero_cuenta_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria =", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <>", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThan(String value) {
            addCriterion("var_numero_cuenta_bancaria >", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria >=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThan(String value) {
            addCriterion("var_numero_cuenta_bancaria <", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLike(String value) {
            addCriterion("var_numero_cuenta_bancaria like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotLike(String value) {
            addCriterion("var_numero_cuenta_bancaria not like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria not in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria between", value1, value2, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria not between", value1, value2, "var_numero_cuenta_bancaria");
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