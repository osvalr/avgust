package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TAnioParametroPlanillaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAnioParametroPlanillaExample() {
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

        public Criteria andSrl_id_anio_parametro_planillaIsNull() {
            addCriterion("srl_id_anio_parametro_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaIsNotNull() {
            addCriterion("srl_id_anio_parametro_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaEqualTo(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla =", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla <>", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla >", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla >=", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaLessThan(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla <", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_parametro_planilla <=", value, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaIn(List<Integer> values) {
            addCriterion("srl_id_anio_parametro_planilla in", values, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_anio_parametro_planilla not in", values, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_parametro_planilla between", value1, value2, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_parametro_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_parametro_planilla not between", value1, value2, "srl_id_anio_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIsNull() {
            addCriterion("srl_id_anio_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIsNotNull() {
            addCriterion("srl_id_anio_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla =", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <>", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_anio_planilla >", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla >=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThan(Integer value) {
            addCriterion("srl_id_anio_planilla <", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla not in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla between", value1, value2, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla not between", value1, value2, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaIsNull() {
            addCriterion("srl_id_parametro_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaIsNotNull() {
            addCriterion("srl_id_parametro_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaEqualTo(Integer value) {
            addCriterion("srl_id_parametro_planilla =", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_parametro_planilla <>", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_parametro_planilla >", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_parametro_planilla >=", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaLessThan(Integer value) {
            addCriterion("srl_id_parametro_planilla <", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_parametro_planilla <=", value, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaIn(List<Integer> values) {
            addCriterion("srl_id_parametro_planilla in", values, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_parametro_planilla not in", values, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_parametro_planilla between", value1, value2, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_parametro_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_parametro_planilla not between", value1, value2, "srl_id_parametro_planilla");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroIsNull() {
            addCriterion("dec_valor_parametro is null");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroIsNotNull() {
            addCriterion("dec_valor_parametro is not null");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroEqualTo(BigDecimal value) {
            addCriterion("dec_valor_parametro =", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroNotEqualTo(BigDecimal value) {
            addCriterion("dec_valor_parametro <>", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroGreaterThan(BigDecimal value) {
            addCriterion("dec_valor_parametro >", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_valor_parametro >=", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroLessThan(BigDecimal value) {
            addCriterion("dec_valor_parametro <", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_valor_parametro <=", value, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroIn(List<BigDecimal> values) {
            addCriterion("dec_valor_parametro in", values, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroNotIn(List<BigDecimal> values) {
            addCriterion("dec_valor_parametro not in", values, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_valor_parametro between", value1, value2, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDec_valor_parametroNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_valor_parametro not between", value1, value2, "dec_valor_parametro");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaIsNull() {
            addCriterion("dte_fecha_vigencia is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaIsNotNull() {
            addCriterion("dte_fecha_vigencia is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia =", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia <>", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia >", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia >=", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia <", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_vigencia <=", value, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_vigencia in", values, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_vigencia not in", values, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_vigencia between", value1, value2, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_vigenciaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_vigencia not between", value1, value2, "dte_fecha_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNull() {
            addCriterion("int_id_estado is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNotNull() {
            addCriterion("int_id_estado is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoEqualTo(Integer value) {
            addCriterion("int_id_estado =", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotEqualTo(Integer value) {
            addCriterion("int_id_estado <>", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThan(Integer value) {
            addCriterion("int_id_estado >", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado >=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThan(Integer value) {
            addCriterion("int_id_estado <", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado <=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIn(List<Integer> values) {
            addCriterion("int_id_estado in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotIn(List<Integer> values) {
            addCriterion("int_id_estado not in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado not between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNull() {
            addCriterion("tsp_fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNotNull() {
            addCriterion("tsp_fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroEqualTo(Date value) {
            addCriterion("tsp_fecha_registro =", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <>", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThan(Date value) {
            addCriterion("tsp_fecha_registro >", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro >=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThan(Date value) {
            addCriterion("tsp_fecha_registro <", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIn(List<Date> values) {
            addCriterion("tsp_fecha_registro in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotIn(List<Date> values) {
            addCriterion("tsp_fecha_registro not in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro between", value1, value2, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro not between", value1, value2, "tsp_fecha_registro");
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