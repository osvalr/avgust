package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TSecuenciaDefinicionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSecuenciaDefinicionExample() {
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

        public Criteria andSrl_id_secuenciaIsNull() {
            addCriterion("srl_id_secuencia is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaIsNotNull() {
            addCriterion("srl_id_secuencia is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaEqualTo(Integer value) {
            addCriterion("srl_id_secuencia =", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaNotEqualTo(Integer value) {
            addCriterion("srl_id_secuencia <>", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaGreaterThan(Integer value) {
            addCriterion("srl_id_secuencia >", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_secuencia >=", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaLessThan(Integer value) {
            addCriterion("srl_id_secuencia <", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_secuencia <=", value, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaIn(List<Integer> values) {
            addCriterion("srl_id_secuencia in", values, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaNotIn(List<Integer> values) {
            addCriterion("srl_id_secuencia not in", values, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_secuencia between", value1, value2, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andSrl_id_secuenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_secuencia not between", value1, value2, "srl_id_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIsNull() {
            addCriterion("var_nombre_tabla is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIsNotNull() {
            addCriterion("var_nombre_tabla is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaEqualTo(String value) {
            addCriterion("var_nombre_tabla =", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotEqualTo(String value) {
            addCriterion("var_nombre_tabla <>", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaGreaterThan(String value) {
            addCriterion("var_nombre_tabla >", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_tabla >=", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLessThan(String value) {
            addCriterion("var_nombre_tabla <", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_tabla <=", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaLike(String value) {
            addCriterion("var_nombre_tabla like", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotLike(String value) {
            addCriterion("var_nombre_tabla not like", value, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaIn(List<String> values) {
            addCriterion("var_nombre_tabla in", values, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotIn(List<String> values) {
            addCriterion("var_nombre_tabla not in", values, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaBetween(String value1, String value2) {
            addCriterion("var_nombre_tabla between", value1, value2, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_tablaNotBetween(String value1, String value2) {
            addCriterion("var_nombre_tabla not between", value1, value2, "var_nombre_tabla");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaIsNull() {
            addCriterion("var_prefijo_secuencia is null");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaIsNotNull() {
            addCriterion("var_prefijo_secuencia is not null");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaEqualTo(String value) {
            addCriterion("var_prefijo_secuencia =", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaNotEqualTo(String value) {
            addCriterion("var_prefijo_secuencia <>", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaGreaterThan(String value) {
            addCriterion("var_prefijo_secuencia >", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaGreaterThanOrEqualTo(String value) {
            addCriterion("var_prefijo_secuencia >=", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaLessThan(String value) {
            addCriterion("var_prefijo_secuencia <", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaLessThanOrEqualTo(String value) {
            addCriterion("var_prefijo_secuencia <=", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaLike(String value) {
            addCriterion("var_prefijo_secuencia like", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaNotLike(String value) {
            addCriterion("var_prefijo_secuencia not like", value, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaIn(List<String> values) {
            addCriterion("var_prefijo_secuencia in", values, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaNotIn(List<String> values) {
            addCriterion("var_prefijo_secuencia not in", values, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaBetween(String value1, String value2) {
            addCriterion("var_prefijo_secuencia between", value1, value2, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_prefijo_secuenciaNotBetween(String value1, String value2) {
            addCriterion("var_prefijo_secuencia not between", value1, value2, "var_prefijo_secuencia");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoIsNull() {
            addCriterion("var_descrip_prefijo is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoIsNotNull() {
            addCriterion("var_descrip_prefijo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoEqualTo(String value) {
            addCriterion("var_descrip_prefijo =", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoNotEqualTo(String value) {
            addCriterion("var_descrip_prefijo <>", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoGreaterThan(String value) {
            addCriterion("var_descrip_prefijo >", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_prefijo >=", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoLessThan(String value) {
            addCriterion("var_descrip_prefijo <", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_prefijo <=", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoLike(String value) {
            addCriterion("var_descrip_prefijo like", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoNotLike(String value) {
            addCriterion("var_descrip_prefijo not like", value, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoIn(List<String> values) {
            addCriterion("var_descrip_prefijo in", values, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoNotIn(List<String> values) {
            addCriterion("var_descrip_prefijo not in", values, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoBetween(String value1, String value2) {
            addCriterion("var_descrip_prefijo between", value1, value2, "var_descrip_prefijo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_prefijoNotBetween(String value1, String value2) {
            addCriterion("var_descrip_prefijo not between", value1, value2, "var_descrip_prefijo");
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