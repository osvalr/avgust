package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSubetapaProcesoSeleccionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSubetapaProcesoSeleccionExample() {
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

        public Criteria andSrl_id_subetapa_proceso_seleccionIsNull() {
            addCriterion("srl_id_subetapa_proceso_seleccion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionIsNotNull() {
            addCriterion("srl_id_subetapa_proceso_seleccion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionEqualTo(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion =", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionNotEqualTo(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion <>", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionGreaterThan(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion >", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion >=", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionLessThan(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion <", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_subetapa_proceso_seleccion <=", value, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionIn(List<Integer> values) {
            addCriterion("srl_id_subetapa_proceso_seleccion in", values, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionNotIn(List<Integer> values) {
            addCriterion("srl_id_subetapa_proceso_seleccion not in", values, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_subetapa_proceso_seleccion between", value1, value2, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_subetapa_proceso_seleccionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_subetapa_proceso_seleccion not between", value1, value2, "srl_id_subetapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionIsNull() {
            addCriterion("srl_id_etapa_proceso_seleccion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionIsNotNull() {
            addCriterion("srl_id_etapa_proceso_seleccion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionEqualTo(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion =", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionNotEqualTo(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion <>", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionGreaterThan(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion >", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion >=", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionLessThan(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion <", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_etapa_proceso_seleccion <=", value, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionIn(List<Integer> values) {
            addCriterion("srl_id_etapa_proceso_seleccion in", values, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionNotIn(List<Integer> values) {
            addCriterion("srl_id_etapa_proceso_seleccion not in", values, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_etapa_proceso_seleccion between", value1, value2, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_etapa_proceso_seleccionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_etapa_proceso_seleccion not between", value1, value2, "srl_id_etapa_proceso_seleccion");
            return (Criteria) this;
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

        public Criteria andIdunidadIsNull() {
            addCriterion("idunidad is null");
            return (Criteria) this;
        }

        public Criteria andIdunidadIsNotNull() {
            addCriterion("idunidad is not null");
            return (Criteria) this;
        }

        public Criteria andIdunidadEqualTo(Integer value) {
            addCriterion("idunidad =", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotEqualTo(Integer value) {
            addCriterion("idunidad <>", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadGreaterThan(Integer value) {
            addCriterion("idunidad >", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("idunidad >=", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadLessThan(Integer value) {
            addCriterion("idunidad <", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadLessThanOrEqualTo(Integer value) {
            addCriterion("idunidad <=", value, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadIn(List<Integer> values) {
            addCriterion("idunidad in", values, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotIn(List<Integer> values) {
            addCriterion("idunidad not in", values, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadBetween(Integer value1, Integer value2) {
            addCriterion("idunidad between", value1, value2, "idunidad");
            return (Criteria) this;
        }

        public Criteria andIdunidadNotBetween(Integer value1, Integer value2) {
            addCriterion("idunidad not between", value1, value2, "idunidad");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaIsNull() {
            addCriterion("var_descrip_subetapa is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaIsNotNull() {
            addCriterion("var_descrip_subetapa is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaEqualTo(String value) {
            addCriterion("var_descrip_subetapa =", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaNotEqualTo(String value) {
            addCriterion("var_descrip_subetapa <>", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaGreaterThan(String value) {
            addCriterion("var_descrip_subetapa >", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_subetapa >=", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaLessThan(String value) {
            addCriterion("var_descrip_subetapa <", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_subetapa <=", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaLike(String value) {
            addCriterion("var_descrip_subetapa like", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaNotLike(String value) {
            addCriterion("var_descrip_subetapa not like", value, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaIn(List<String> values) {
            addCriterion("var_descrip_subetapa in", values, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaNotIn(List<String> values) {
            addCriterion("var_descrip_subetapa not in", values, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaBetween(String value1, String value2) {
            addCriterion("var_descrip_subetapa between", value1, value2, "var_descrip_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_subetapaNotBetween(String value1, String value2) {
            addCriterion("var_descrip_subetapa not between", value1, value2, "var_descrip_subetapa");
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

        public Criteria andVar_detalle_subetapaIsNull() {
            addCriterion("var_detalle_subetapa is null");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaIsNotNull() {
            addCriterion("var_detalle_subetapa is not null");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaEqualTo(String value) {
            addCriterion("var_detalle_subetapa =", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaNotEqualTo(String value) {
            addCriterion("var_detalle_subetapa <>", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaGreaterThan(String value) {
            addCriterion("var_detalle_subetapa >", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaGreaterThanOrEqualTo(String value) {
            addCriterion("var_detalle_subetapa >=", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaLessThan(String value) {
            addCriterion("var_detalle_subetapa <", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaLessThanOrEqualTo(String value) {
            addCriterion("var_detalle_subetapa <=", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaLike(String value) {
            addCriterion("var_detalle_subetapa like", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaNotLike(String value) {
            addCriterion("var_detalle_subetapa not like", value, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaIn(List<String> values) {
            addCriterion("var_detalle_subetapa in", values, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaNotIn(List<String> values) {
            addCriterion("var_detalle_subetapa not in", values, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaBetween(String value1, String value2) {
            addCriterion("var_detalle_subetapa between", value1, value2, "var_detalle_subetapa");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_subetapaNotBetween(String value1, String value2) {
            addCriterion("var_detalle_subetapa not between", value1, value2, "var_detalle_subetapa");
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