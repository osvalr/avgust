package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TNumeroTelefonoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNumeroTelefonoExample() {
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

        public Criteria andSrl_id_numero_telefonoIsNull() {
            addCriterion("srl_id_numero_telefono is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoIsNotNull() {
            addCriterion("srl_id_numero_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono =", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono <>", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoGreaterThan(Integer value) {
            addCriterion("srl_id_numero_telefono >", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono >=", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoLessThan(Integer value) {
            addCriterion("srl_id_numero_telefono <", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono <=", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoIn(List<Integer> values) {
            addCriterion("srl_id_numero_telefono in", values, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotIn(List<Integer> values) {
            addCriterion("srl_id_numero_telefono not in", values, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_numero_telefono between", value1, value2, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_numero_telefono not between", value1, value2, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadIsNull() {
            addCriterion("var_cod_cuidad is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadIsNotNull() {
            addCriterion("var_cod_cuidad is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadEqualTo(String value) {
            addCriterion("var_cod_cuidad =", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadNotEqualTo(String value) {
            addCriterion("var_cod_cuidad <>", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadGreaterThan(String value) {
            addCriterion("var_cod_cuidad >", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_cuidad >=", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadLessThan(String value) {
            addCriterion("var_cod_cuidad <", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadLessThanOrEqualTo(String value) {
            addCriterion("var_cod_cuidad <=", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadLike(String value) {
            addCriterion("var_cod_cuidad like", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadNotLike(String value) {
            addCriterion("var_cod_cuidad not like", value, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadIn(List<String> values) {
            addCriterion("var_cod_cuidad in", values, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadNotIn(List<String> values) {
            addCriterion("var_cod_cuidad not in", values, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadBetween(String value1, String value2) {
            addCriterion("var_cod_cuidad between", value1, value2, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_cod_cuidadNotBetween(String value1, String value2) {
            addCriterion("var_cod_cuidad not between", value1, value2, "var_cod_cuidad");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoIsNull() {
            addCriterion("var_numero_telefono is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoIsNotNull() {
            addCriterion("var_numero_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoEqualTo(String value) {
            addCriterion("var_numero_telefono =", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoNotEqualTo(String value) {
            addCriterion("var_numero_telefono <>", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoGreaterThan(String value) {
            addCriterion("var_numero_telefono >", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_telefono >=", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoLessThan(String value) {
            addCriterion("var_numero_telefono <", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoLessThanOrEqualTo(String value) {
            addCriterion("var_numero_telefono <=", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoLike(String value) {
            addCriterion("var_numero_telefono like", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoNotLike(String value) {
            addCriterion("var_numero_telefono not like", value, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoIn(List<String> values) {
            addCriterion("var_numero_telefono in", values, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoNotIn(List<String> values) {
            addCriterion("var_numero_telefono not in", values, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoBetween(String value1, String value2) {
            addCriterion("var_numero_telefono between", value1, value2, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_numero_telefonoNotBetween(String value1, String value2) {
            addCriterion("var_numero_telefono not between", value1, value2, "var_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoIsNull() {
            addCriterion("int_id_tipo_telefono is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoIsNotNull() {
            addCriterion("int_id_tipo_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoEqualTo(Integer value) {
            addCriterion("int_id_tipo_telefono =", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_telefono <>", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_telefono >", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_telefono >=", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoLessThan(Integer value) {
            addCriterion("int_id_tipo_telefono <", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_telefono <=", value, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoIn(List<Integer> values) {
            addCriterion("int_id_tipo_telefono in", values, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_telefono not in", values, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_telefono between", value1, value2, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_telefonoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_telefono not between", value1, value2, "int_id_tipo_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorIsNull() {
            addCriterion("int_id_tipo_operador is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorIsNotNull() {
            addCriterion("int_id_tipo_operador is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorEqualTo(Integer value) {
            addCriterion("int_id_tipo_operador =", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_operador <>", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorGreaterThan(Integer value) {
            addCriterion("int_id_tipo_operador >", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_operador >=", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorLessThan(Integer value) {
            addCriterion("int_id_tipo_operador <", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_operador <=", value, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorIn(List<Integer> values) {
            addCriterion("int_id_tipo_operador in", values, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_operador not in", values, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_operador between", value1, value2, "int_id_tipo_operador");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_operadorNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_operador not between", value1, value2, "int_id_tipo_operador");
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