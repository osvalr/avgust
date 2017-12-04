package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TRegimenPensionarioHistorialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRegimenPensionarioHistorialExample() {
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

        public Criteria andSrl_id_regimen_pensionario_historialIsNull() {
            addCriterion("srl_id_regimen_pensionario_historial is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialIsNotNull() {
            addCriterion("srl_id_regimen_pensionario_historial is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial =", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial <>", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial >", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial >=", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialLessThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial <", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario_historial <=", value, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario_historial in", values, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario_historial not in", values, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario_historial between", value1, value2, "srl_id_regimen_pensionario_historial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionario_historialNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario_historial not between", value1, value2, "srl_id_regimen_pensionario_historial");
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

        public Criteria andInt_estadoIsNull() {
            addCriterion("int_estado is null");
            return (Criteria) this;
        }

        public Criteria andInt_estadoIsNotNull() {
            addCriterion("int_estado is not null");
            return (Criteria) this;
        }

        public Criteria andInt_estadoEqualTo(Integer value) {
            addCriterion("int_estado =", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotEqualTo(Integer value) {
            addCriterion("int_estado <>", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoGreaterThan(Integer value) {
            addCriterion("int_estado >", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_estado >=", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoLessThan(Integer value) {
            addCriterion("int_estado <", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("int_estado <=", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoIn(List<Integer> values) {
            addCriterion("int_estado in", values, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotIn(List<Integer> values) {
            addCriterion("int_estado not in", values, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoBetween(Integer value1, Integer value2) {
            addCriterion("int_estado between", value1, value2, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_estado not between", value1, value2, "int_estado");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIsNull() {
            addCriterion("var_nombre_afp is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIsNotNull() {
            addCriterion("var_nombre_afp is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpEqualTo(String value) {
            addCriterion("var_nombre_afp =", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotEqualTo(String value) {
            addCriterion("var_nombre_afp <>", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpGreaterThan(String value) {
            addCriterion("var_nombre_afp >", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_afp >=", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLessThan(String value) {
            addCriterion("var_nombre_afp <", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_afp <=", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLike(String value) {
            addCriterion("var_nombre_afp like", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotLike(String value) {
            addCriterion("var_nombre_afp not like", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIn(List<String> values) {
            addCriterion("var_nombre_afp in", values, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotIn(List<String> values) {
            addCriterion("var_nombre_afp not in", values, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpBetween(String value1, String value2) {
            addCriterion("var_nombre_afp between", value1, value2, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotBetween(String value1, String value2) {
            addCriterion("var_nombre_afp not between", value1, value2, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIsNull() {
            addCriterion("var_codigo_afiliacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIsNotNull() {
            addCriterion("var_codigo_afiliacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionEqualTo(String value) {
            addCriterion("var_codigo_afiliacion =", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotEqualTo(String value) {
            addCriterion("var_codigo_afiliacion <>", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionGreaterThan(String value) {
            addCriterion("var_codigo_afiliacion >", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_afiliacion >=", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLessThan(String value) {
            addCriterion("var_codigo_afiliacion <", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLessThanOrEqualTo(String value) {
            addCriterion("var_codigo_afiliacion <=", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLike(String value) {
            addCriterion("var_codigo_afiliacion like", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotLike(String value) {
            addCriterion("var_codigo_afiliacion not like", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIn(List<String> values) {
            addCriterion("var_codigo_afiliacion in", values, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotIn(List<String> values) {
            addCriterion("var_codigo_afiliacion not in", values, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionBetween(String value1, String value2) {
            addCriterion("var_codigo_afiliacion between", value1, value2, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotBetween(String value1, String value2) {
            addCriterion("var_codigo_afiliacion not between", value1, value2, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIsNull() {
            addCriterion("dte_fecha_afiliacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIsNotNull() {
            addCriterion("dte_fecha_afiliacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion =", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <>", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion >", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion >=", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <=", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_afiliacion in", values, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_afiliacion not in", values, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_afiliacion between", value1, value2, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_afiliacion not between", value1, value2, "dte_fecha_afiliacion");
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