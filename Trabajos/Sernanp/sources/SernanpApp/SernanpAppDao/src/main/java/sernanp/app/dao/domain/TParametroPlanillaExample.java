package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TParametroPlanillaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TParametroPlanillaExample() {
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

        public Criteria andVar_descrip_parametroIsNull() {
            addCriterion("var_descrip_parametro is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroIsNotNull() {
            addCriterion("var_descrip_parametro is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroEqualTo(String value) {
            addCriterion("var_descrip_parametro =", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroNotEqualTo(String value) {
            addCriterion("var_descrip_parametro <>", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroGreaterThan(String value) {
            addCriterion("var_descrip_parametro >", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_parametro >=", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroLessThan(String value) {
            addCriterion("var_descrip_parametro <", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_parametro <=", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroLike(String value) {
            addCriterion("var_descrip_parametro like", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroNotLike(String value) {
            addCriterion("var_descrip_parametro not like", value, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroIn(List<String> values) {
            addCriterion("var_descrip_parametro in", values, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroNotIn(List<String> values) {
            addCriterion("var_descrip_parametro not in", values, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroBetween(String value1, String value2) {
            addCriterion("var_descrip_parametro between", value1, value2, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_parametroNotBetween(String value1, String value2) {
            addCriterion("var_descrip_parametro not between", value1, value2, "var_descrip_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroIsNull() {
            addCriterion("int_tipo_parametro is null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroIsNotNull() {
            addCriterion("int_tipo_parametro is not null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroEqualTo(Integer value) {
            addCriterion("int_tipo_parametro =", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroNotEqualTo(Integer value) {
            addCriterion("int_tipo_parametro <>", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroGreaterThan(Integer value) {
            addCriterion("int_tipo_parametro >", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_parametro >=", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroLessThan(Integer value) {
            addCriterion("int_tipo_parametro <", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroLessThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_parametro <=", value, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroIn(List<Integer> values) {
            addCriterion("int_tipo_parametro in", values, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroNotIn(List<Integer> values) {
            addCriterion("int_tipo_parametro not in", values, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_parametro between", value1, value2, "int_tipo_parametro");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_parametroNotBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_parametro not between", value1, value2, "int_tipo_parametro");
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