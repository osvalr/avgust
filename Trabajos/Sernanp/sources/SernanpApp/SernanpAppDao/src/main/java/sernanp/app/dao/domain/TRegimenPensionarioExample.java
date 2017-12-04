package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TRegimenPensionarioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRegimenPensionarioExample() {
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

        public Criteria andSrl_id_regimen_pensionarioIsNull() {
            addCriterion("srl_id_regimen_pensionario is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIsNotNull() {
            addCriterion("srl_id_regimen_pensionario is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario =", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <>", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario >", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario >=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario <", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario not in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario between", value1, value2, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario not between", value1, value2, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNull() {
            addCriterion("srl_id_regimen_contractual is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNotNull() {
            addCriterion("srl_id_regimen_contractual is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual =", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <>", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_contractual >", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual >=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThan(Integer value) {
            addCriterion("srl_id_regimen_contractual <", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual not in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual not between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioIsNull() {
            addCriterion("int_cod_regimen_pensionario is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioIsNotNull() {
            addCriterion("int_cod_regimen_pensionario is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioEqualTo(Integer value) {
            addCriterion("int_cod_regimen_pensionario =", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioNotEqualTo(Integer value) {
            addCriterion("int_cod_regimen_pensionario <>", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioGreaterThan(Integer value) {
            addCriterion("int_cod_regimen_pensionario >", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_regimen_pensionario >=", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioLessThan(Integer value) {
            addCriterion("int_cod_regimen_pensionario <", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_regimen_pensionario <=", value, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioIn(List<Integer> values) {
            addCriterion("int_cod_regimen_pensionario in", values, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioNotIn(List<Integer> values) {
            addCriterion("int_cod_regimen_pensionario not in", values, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_regimen_pensionario between", value1, value2, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andInt_cod_regimen_pensionarioNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_regimen_pensionario not between", value1, value2, "int_cod_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioIsNull() {
            addCriterion("var_descripcion_regimen_pensionario is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioIsNotNull() {
            addCriterion("var_descripcion_regimen_pensionario is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioEqualTo(String value) {
            addCriterion("var_descripcion_regimen_pensionario =", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioNotEqualTo(String value) {
            addCriterion("var_descripcion_regimen_pensionario <>", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioGreaterThan(String value) {
            addCriterion("var_descripcion_regimen_pensionario >", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_regimen_pensionario >=", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioLessThan(String value) {
            addCriterion("var_descripcion_regimen_pensionario <", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_regimen_pensionario <=", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioLike(String value) {
            addCriterion("var_descripcion_regimen_pensionario like", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioNotLike(String value) {
            addCriterion("var_descripcion_regimen_pensionario not like", value, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioIn(List<String> values) {
            addCriterion("var_descripcion_regimen_pensionario in", values, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioNotIn(List<String> values) {
            addCriterion("var_descripcion_regimen_pensionario not in", values, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioBetween(String value1, String value2) {
            addCriterion("var_descripcion_regimen_pensionario between", value1, value2, "var_descripcion_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_regimen_pensionarioNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_regimen_pensionario not between", value1, value2, "var_descripcion_regimen_pensionario");
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