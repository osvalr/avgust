package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TArchivoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TArchivoExample() {
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

        public Criteria andSrl_id_archivoIsNull() {
            addCriterion("srl_id_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIsNotNull() {
            addCriterion("srl_id_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoEqualTo(Integer value) {
            addCriterion("srl_id_archivo =", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_archivo <>", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_archivo >", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo >=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThan(Integer value) {
            addCriterion("srl_id_archivo <", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo <=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIn(List<Integer> values) {
            addCriterion("srl_id_archivo in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_archivo not in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo between", value1, value2, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo not between", value1, value2, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoIsNull() {
            addCriterion("var_nombre_archivo is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoIsNotNull() {
            addCriterion("var_nombre_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoEqualTo(String value) {
            addCriterion("var_nombre_archivo =", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoNotEqualTo(String value) {
            addCriterion("var_nombre_archivo <>", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoGreaterThan(String value) {
            addCriterion("var_nombre_archivo >", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_archivo >=", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoLessThan(String value) {
            addCriterion("var_nombre_archivo <", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_archivo <=", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoLike(String value) {
            addCriterion("var_nombre_archivo like", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoNotLike(String value) {
            addCriterion("var_nombre_archivo not like", value, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoIn(List<String> values) {
            addCriterion("var_nombre_archivo in", values, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoNotIn(List<String> values) {
            addCriterion("var_nombre_archivo not in", values, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoBetween(String value1, String value2) {
            addCriterion("var_nombre_archivo between", value1, value2, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_archivoNotBetween(String value1, String value2) {
            addCriterion("var_nombre_archivo not between", value1, value2, "var_nombre_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoIsNull() {
            addCriterion("var_tipo_archivo is null");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoIsNotNull() {
            addCriterion("var_tipo_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoEqualTo(String value) {
            addCriterion("var_tipo_archivo =", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoNotEqualTo(String value) {
            addCriterion("var_tipo_archivo <>", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoGreaterThan(String value) {
            addCriterion("var_tipo_archivo >", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoGreaterThanOrEqualTo(String value) {
            addCriterion("var_tipo_archivo >=", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoLessThan(String value) {
            addCriterion("var_tipo_archivo <", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoLessThanOrEqualTo(String value) {
            addCriterion("var_tipo_archivo <=", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoLike(String value) {
            addCriterion("var_tipo_archivo like", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoNotLike(String value) {
            addCriterion("var_tipo_archivo not like", value, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoIn(List<String> values) {
            addCriterion("var_tipo_archivo in", values, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoNotIn(List<String> values) {
            addCriterion("var_tipo_archivo not in", values, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoBetween(String value1, String value2) {
            addCriterion("var_tipo_archivo between", value1, value2, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_tipo_archivoNotBetween(String value1, String value2) {
            addCriterion("var_tipo_archivo not between", value1, value2, "var_tipo_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenIsNull() {
            addCriterion("var_archivo_ruta_almacen is null");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenIsNotNull() {
            addCriterion("var_archivo_ruta_almacen is not null");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenEqualTo(String value) {
            addCriterion("var_archivo_ruta_almacen =", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenNotEqualTo(String value) {
            addCriterion("var_archivo_ruta_almacen <>", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenGreaterThan(String value) {
            addCriterion("var_archivo_ruta_almacen >", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenGreaterThanOrEqualTo(String value) {
            addCriterion("var_archivo_ruta_almacen >=", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenLessThan(String value) {
            addCriterion("var_archivo_ruta_almacen <", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenLessThanOrEqualTo(String value) {
            addCriterion("var_archivo_ruta_almacen <=", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenLike(String value) {
            addCriterion("var_archivo_ruta_almacen like", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenNotLike(String value) {
            addCriterion("var_archivo_ruta_almacen not like", value, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenIn(List<String> values) {
            addCriterion("var_archivo_ruta_almacen in", values, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenNotIn(List<String> values) {
            addCriterion("var_archivo_ruta_almacen not in", values, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenBetween(String value1, String value2) {
            addCriterion("var_archivo_ruta_almacen between", value1, value2, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andVar_archivo_ruta_almacenNotBetween(String value1, String value2) {
            addCriterion("var_archivo_ruta_almacen not between", value1, value2, "var_archivo_ruta_almacen");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoIsNull() {
            addCriterion("num_size_archivo is null");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoIsNotNull() {
            addCriterion("num_size_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoEqualTo(BigDecimal value) {
            addCriterion("num_size_archivo =", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoNotEqualTo(BigDecimal value) {
            addCriterion("num_size_archivo <>", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoGreaterThan(BigDecimal value) {
            addCriterion("num_size_archivo >", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("num_size_archivo >=", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoLessThan(BigDecimal value) {
            addCriterion("num_size_archivo <", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("num_size_archivo <=", value, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoIn(List<BigDecimal> values) {
            addCriterion("num_size_archivo in", values, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoNotIn(List<BigDecimal> values) {
            addCriterion("num_size_archivo not in", values, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_size_archivo between", value1, value2, "num_size_archivo");
            return (Criteria) this;
        }

        public Criteria andNum_size_archivoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_size_archivo not between", value1, value2, "num_size_archivo");
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