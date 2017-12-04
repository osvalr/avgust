package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TConvocatoriaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConvocatoriaExample() {
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

        public Criteria andSrl_id_convocatoriaIsNull() {
            addCriterion("srl_id_convocatoria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaIsNotNull() {
            addCriterion("srl_id_convocatoria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaEqualTo(Integer value) {
            addCriterion("srl_id_convocatoria =", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaNotEqualTo(Integer value) {
            addCriterion("srl_id_convocatoria <>", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaGreaterThan(Integer value) {
            addCriterion("srl_id_convocatoria >", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_convocatoria >=", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaLessThan(Integer value) {
            addCriterion("srl_id_convocatoria <", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_convocatoria <=", value, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaIn(List<Integer> values) {
            addCriterion("srl_id_convocatoria in", values, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaNotIn(List<Integer> values) {
            addCriterion("srl_id_convocatoria not in", values, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_convocatoria between", value1, value2, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_convocatoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_convocatoria not between", value1, value2, "srl_id_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaIsNull() {
            addCriterion("var_num_convocatoria is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaIsNotNull() {
            addCriterion("var_num_convocatoria is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaEqualTo(String value) {
            addCriterion("var_num_convocatoria =", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaNotEqualTo(String value) {
            addCriterion("var_num_convocatoria <>", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaGreaterThan(String value) {
            addCriterion("var_num_convocatoria >", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_convocatoria >=", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaLessThan(String value) {
            addCriterion("var_num_convocatoria <", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaLessThanOrEqualTo(String value) {
            addCriterion("var_num_convocatoria <=", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaLike(String value) {
            addCriterion("var_num_convocatoria like", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaNotLike(String value) {
            addCriterion("var_num_convocatoria not like", value, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaIn(List<String> values) {
            addCriterion("var_num_convocatoria in", values, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaNotIn(List<String> values) {
            addCriterion("var_num_convocatoria not in", values, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaBetween(String value1, String value2) {
            addCriterion("var_num_convocatoria between", value1, value2, "var_num_convocatoria");
            return (Criteria) this;
        }

        public Criteria andVar_num_convocatoriaNotBetween(String value1, String value2) {
            addCriterion("var_num_convocatoria not between", value1, value2, "var_num_convocatoria");
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

        public Criteria andInt_num_activacionIsNull() {
            addCriterion("int_num_activacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionIsNotNull() {
            addCriterion("int_num_activacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionEqualTo(Integer value) {
            addCriterion("int_num_activacion =", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionNotEqualTo(Integer value) {
            addCriterion("int_num_activacion <>", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionGreaterThan(Integer value) {
            addCriterion("int_num_activacion >", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_num_activacion >=", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionLessThan(Integer value) {
            addCriterion("int_num_activacion <", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_num_activacion <=", value, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionIn(List<Integer> values) {
            addCriterion("int_num_activacion in", values, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionNotIn(List<Integer> values) {
            addCriterion("int_num_activacion not in", values, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionBetween(Integer value1, Integer value2) {
            addCriterion("int_num_activacion between", value1, value2, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_activacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_num_activacion not between", value1, value2, "int_num_activacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionIsNull() {
            addCriterion("dte_fecha_aprobacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionIsNotNull() {
            addCriterion("dte_fecha_aprobacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion =", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion <>", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion >", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion >=", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion <", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_aprobacion <=", value, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_aprobacion in", values, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_aprobacion not in", values, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_aprobacion between", value1, value2, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_aprobacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_aprobacion not between", value1, value2, "dte_fecha_aprobacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionIsNull() {
            addCriterion("dte_fecha_inicio_publicacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionIsNotNull() {
            addCriterion("dte_fecha_inicio_publicacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion =", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion <>", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion >", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion >=", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion <", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion <=", value, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion in", values, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion not in", values, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion between", value1, value2, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_publicacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio_publicacion not between", value1, value2, "dte_fecha_inicio_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionIsNull() {
            addCriterion("dte_fecha_termino_publicacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionIsNotNull() {
            addCriterion("dte_fecha_termino_publicacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion =", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion <>", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion >", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion >=", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion <", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion <=", value, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion in", values, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion not in", values, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion between", value1, value2, "dte_fecha_termino_publicacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_termino_publicacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_termino_publicacion not between", value1, value2, "dte_fecha_termino_publicacion");
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