package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THistorialDetalleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public THistorialDetalleExample() {
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

        public Criteria andSrl_id_historial_detalleIsNull() {
            addCriterion("srl_id_historial_detalle is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleIsNotNull() {
            addCriterion("srl_id_historial_detalle is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleEqualTo(Integer value) {
            addCriterion("srl_id_historial_detalle =", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleNotEqualTo(Integer value) {
            addCriterion("srl_id_historial_detalle <>", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleGreaterThan(Integer value) {
            addCriterion("srl_id_historial_detalle >", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_historial_detalle >=", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleLessThan(Integer value) {
            addCriterion("srl_id_historial_detalle <", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_historial_detalle <=", value, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleIn(List<Integer> values) {
            addCriterion("srl_id_historial_detalle in", values, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleNotIn(List<Integer> values) {
            addCriterion("srl_id_historial_detalle not in", values, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_historial_detalle between", value1, value2, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andSrl_id_historial_detalleNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_historial_detalle not between", value1, value2, "srl_id_historial_detalle");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroIsNull() {
            addCriterion("var_codigo_registro is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroIsNotNull() {
            addCriterion("var_codigo_registro is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroEqualTo(String value) {
            addCriterion("var_codigo_registro =", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroNotEqualTo(String value) {
            addCriterion("var_codigo_registro <>", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroGreaterThan(String value) {
            addCriterion("var_codigo_registro >", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroGreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_registro >=", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroLessThan(String value) {
            addCriterion("var_codigo_registro <", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroLessThanOrEqualTo(String value) {
            addCriterion("var_codigo_registro <=", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroLike(String value) {
            addCriterion("var_codigo_registro like", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroNotLike(String value) {
            addCriterion("var_codigo_registro not like", value, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroIn(List<String> values) {
            addCriterion("var_codigo_registro in", values, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroNotIn(List<String> values) {
            addCriterion("var_codigo_registro not in", values, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroBetween(String value1, String value2) {
            addCriterion("var_codigo_registro between", value1, value2, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_registroNotBetween(String value1, String value2) {
            addCriterion("var_codigo_registro not between", value1, value2, "var_codigo_registro");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonIsNull() {
            addCriterion("var_valor_json is null");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonIsNotNull() {
            addCriterion("var_valor_json is not null");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonEqualTo(String value) {
            addCriterion("var_valor_json =", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonNotEqualTo(String value) {
            addCriterion("var_valor_json <>", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonGreaterThan(String value) {
            addCriterion("var_valor_json >", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonGreaterThanOrEqualTo(String value) {
            addCriterion("var_valor_json >=", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonLessThan(String value) {
            addCriterion("var_valor_json <", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonLessThanOrEqualTo(String value) {
            addCriterion("var_valor_json <=", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonLike(String value) {
            addCriterion("var_valor_json like", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonNotLike(String value) {
            addCriterion("var_valor_json not like", value, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonIn(List<String> values) {
            addCriterion("var_valor_json in", values, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonNotIn(List<String> values) {
            addCriterion("var_valor_json not in", values, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonBetween(String value1, String value2) {
            addCriterion("var_valor_json between", value1, value2, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_valor_jsonNotBetween(String value1, String value2) {
            addCriterion("var_valor_json not between", value1, value2, "var_valor_json");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableIsNull() {
            addCriterion("var_id_responsable is null");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableIsNotNull() {
            addCriterion("var_id_responsable is not null");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableEqualTo(String value) {
            addCriterion("var_id_responsable =", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableNotEqualTo(String value) {
            addCriterion("var_id_responsable <>", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableGreaterThan(String value) {
            addCriterion("var_id_responsable >", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableGreaterThanOrEqualTo(String value) {
            addCriterion("var_id_responsable >=", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableLessThan(String value) {
            addCriterion("var_id_responsable <", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableLessThanOrEqualTo(String value) {
            addCriterion("var_id_responsable <=", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableLike(String value) {
            addCriterion("var_id_responsable like", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableNotLike(String value) {
            addCriterion("var_id_responsable not like", value, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableIn(List<String> values) {
            addCriterion("var_id_responsable in", values, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableNotIn(List<String> values) {
            addCriterion("var_id_responsable not in", values, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableBetween(String value1, String value2) {
            addCriterion("var_id_responsable between", value1, value2, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_responsableNotBetween(String value1, String value2) {
            addCriterion("var_id_responsable not between", value1, value2, "var_id_responsable");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionIsNull() {
            addCriterion("var_id_tipo_operacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionIsNotNull() {
            addCriterion("var_id_tipo_operacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionEqualTo(String value) {
            addCriterion("var_id_tipo_operacion =", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionNotEqualTo(String value) {
            addCriterion("var_id_tipo_operacion <>", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionGreaterThan(String value) {
            addCriterion("var_id_tipo_operacion >", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_id_tipo_operacion >=", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionLessThan(String value) {
            addCriterion("var_id_tipo_operacion <", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionLessThanOrEqualTo(String value) {
            addCriterion("var_id_tipo_operacion <=", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionLike(String value) {
            addCriterion("var_id_tipo_operacion like", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionNotLike(String value) {
            addCriterion("var_id_tipo_operacion not like", value, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionIn(List<String> values) {
            addCriterion("var_id_tipo_operacion in", values, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionNotIn(List<String> values) {
            addCriterion("var_id_tipo_operacion not in", values, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionBetween(String value1, String value2) {
            addCriterion("var_id_tipo_operacion between", value1, value2, "var_id_tipo_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_id_tipo_operacionNotBetween(String value1, String value2) {
            addCriterion("var_id_tipo_operacion not between", value1, value2, "var_id_tipo_operacion");
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