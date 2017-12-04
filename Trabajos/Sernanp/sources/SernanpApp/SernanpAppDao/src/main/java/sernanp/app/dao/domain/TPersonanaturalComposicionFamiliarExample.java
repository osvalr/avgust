package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPersonanaturalComposicionFamiliarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonanaturalComposicionFamiliarExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSrl_id_personanatural_composicion_familiarIsNull() {
            addCriterion("srl_id_personanatural_composicion_familiar is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarIsNotNull() {
            addCriterion("srl_id_personanatural_composicion_familiar is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar =", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarNotEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar <>", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarGreaterThan(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar >", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar >=", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarLessThan(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar <", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_composicion_familiar <=", value, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarIn(List<Integer> values) {
            addCriterion("srl_id_personanatural_composicion_familiar in", values, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarNotIn(List<Integer> values) {
            addCriterion("srl_id_personanatural_composicion_familiar not in", values, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personanatural_composicion_familiar between", value1, value2, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_composicion_familiarNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personanatural_composicion_familiar not between", value1, value2, "srl_id_personanatural_composicion_familiar");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNull() {
            addCriterion("idpersonanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNotNull() {
            addCriterion("idpersonanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalEqualTo(Integer value) {
            addCriterion("idpersonanatural =", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotEqualTo(Integer value) {
            addCriterion("idpersonanatural <>", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThan(Integer value) {
            addCriterion("idpersonanatural >", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural >=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThan(Integer value) {
            addCriterion("idpersonanatural <", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural <=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIn(List<Integer> values) {
            addCriterion("idpersonanatural in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotIn(List<Integer> values) {
            addCriterion("idpersonanatural not in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural not between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreIsNull() {
            addCriterion("var_datos_padre is null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreIsNotNull() {
            addCriterion("var_datos_padre is not null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreEqualTo(String value) {
            addCriterion("var_datos_padre =", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreNotEqualTo(String value) {
            addCriterion("var_datos_padre <>", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreGreaterThan(String value) {
            addCriterion("var_datos_padre >", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreGreaterThanOrEqualTo(String value) {
            addCriterion("var_datos_padre >=", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreLessThan(String value) {
            addCriterion("var_datos_padre <", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreLessThanOrEqualTo(String value) {
            addCriterion("var_datos_padre <=", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreLike(String value) {
            addCriterion("var_datos_padre like", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreNotLike(String value) {
            addCriterion("var_datos_padre not like", value, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreIn(List<String> values) {
            addCriterion("var_datos_padre in", values, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreNotIn(List<String> values) {
            addCriterion("var_datos_padre not in", values, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreBetween(String value1, String value2) {
            addCriterion("var_datos_padre between", value1, value2, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_padreNotBetween(String value1, String value2) {
            addCriterion("var_datos_padre not between", value1, value2, "var_datos_padre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreIsNull() {
            addCriterion("var_datos_madre is null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreIsNotNull() {
            addCriterion("var_datos_madre is not null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreEqualTo(String value) {
            addCriterion("var_datos_madre =", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreNotEqualTo(String value) {
            addCriterion("var_datos_madre <>", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreGreaterThan(String value) {
            addCriterion("var_datos_madre >", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreGreaterThanOrEqualTo(String value) {
            addCriterion("var_datos_madre >=", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreLessThan(String value) {
            addCriterion("var_datos_madre <", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreLessThanOrEqualTo(String value) {
            addCriterion("var_datos_madre <=", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreLike(String value) {
            addCriterion("var_datos_madre like", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreNotLike(String value) {
            addCriterion("var_datos_madre not like", value, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreIn(List<String> values) {
            addCriterion("var_datos_madre in", values, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreNotIn(List<String> values) {
            addCriterion("var_datos_madre not in", values, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreBetween(String value1, String value2) {
            addCriterion("var_datos_madre between", value1, value2, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_madreNotBetween(String value1, String value2) {
            addCriterion("var_datos_madre not between", value1, value2, "var_datos_madre");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoIsNull() {
            addCriterion("var_datos_hijo is null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoIsNotNull() {
            addCriterion("var_datos_hijo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoEqualTo(String value) {
            addCriterion("var_datos_hijo =", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoNotEqualTo(String value) {
            addCriterion("var_datos_hijo <>", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoGreaterThan(String value) {
            addCriterion("var_datos_hijo >", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoGreaterThanOrEqualTo(String value) {
            addCriterion("var_datos_hijo >=", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoLessThan(String value) {
            addCriterion("var_datos_hijo <", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoLessThanOrEqualTo(String value) {
            addCriterion("var_datos_hijo <=", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoLike(String value) {
            addCriterion("var_datos_hijo like", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoNotLike(String value) {
            addCriterion("var_datos_hijo not like", value, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoIn(List<String> values) {
            addCriterion("var_datos_hijo in", values, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoNotIn(List<String> values) {
            addCriterion("var_datos_hijo not in", values, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoBetween(String value1, String value2) {
            addCriterion("var_datos_hijo between", value1, value2, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_datos_hijoNotBetween(String value1, String value2) {
            addCriterion("var_datos_hijo not between", value1, value2, "var_datos_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoIsNull() {
            addCriterion("var_dni_hijo is null");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoIsNotNull() {
            addCriterion("var_dni_hijo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoEqualTo(String value) {
            addCriterion("var_dni_hijo =", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoNotEqualTo(String value) {
            addCriterion("var_dni_hijo <>", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoGreaterThan(String value) {
            addCriterion("var_dni_hijo >", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoGreaterThanOrEqualTo(String value) {
            addCriterion("var_dni_hijo >=", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoLessThan(String value) {
            addCriterion("var_dni_hijo <", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoLessThanOrEqualTo(String value) {
            addCriterion("var_dni_hijo <=", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoLike(String value) {
            addCriterion("var_dni_hijo like", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoNotLike(String value) {
            addCriterion("var_dni_hijo not like", value, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoIn(List<String> values) {
            addCriterion("var_dni_hijo in", values, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoNotIn(List<String> values) {
            addCriterion("var_dni_hijo not in", values, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoBetween(String value1, String value2) {
            addCriterion("var_dni_hijo between", value1, value2, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andVar_dni_hijoNotBetween(String value1, String value2) {
            addCriterion("var_dni_hijo not between", value1, value2, "var_dni_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoIsNull() {
            addCriterion("dte_fecha_nacimiento_hijo is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoIsNotNull() {
            addCriterion("dte_fecha_nacimiento_hijo is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo =", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo <>", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo >", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo >=", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo <", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo <=", value, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo in", values, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo not in", values, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo between", value1, value2, "dte_fecha_nacimiento_hijo");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_nacimiento_hijoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_nacimiento_hijo not between", value1, value2, "dte_fecha_nacimiento_hijo");
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