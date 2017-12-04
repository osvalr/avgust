package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TSuspensionCuartaCategoriaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSuspensionCuartaCategoriaExample() {
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

        public Criteria andSrl_id_suspension_cuarta_categoriaIsNull() {
            addCriterion("srl_id_suspension_cuarta_categoria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaIsNotNull() {
            addCriterion("srl_id_suspension_cuarta_categoria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaEqualTo(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria =", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaNotEqualTo(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria <>", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaGreaterThan(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria >", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria >=", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaLessThan(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria <", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_suspension_cuarta_categoria <=", value, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaIn(List<Integer> values) {
            addCriterion("srl_id_suspension_cuarta_categoria in", values, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaNotIn(List<Integer> values) {
            addCriterion("srl_id_suspension_cuarta_categoria not in", values, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_suspension_cuarta_categoria between", value1, value2, "srl_id_suspension_cuarta_categoria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_suspension_cuarta_categoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_suspension_cuarta_categoria not between", value1, value2, "srl_id_suspension_cuarta_categoria");
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

        public Criteria andVar_num_operacionIsNull() {
            addCriterion("var_num_operacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionIsNotNull() {
            addCriterion("var_num_operacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionEqualTo(String value) {
            addCriterion("var_num_operacion =", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionNotEqualTo(String value) {
            addCriterion("var_num_operacion <>", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionGreaterThan(String value) {
            addCriterion("var_num_operacion >", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_operacion >=", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionLessThan(String value) {
            addCriterion("var_num_operacion <", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionLessThanOrEqualTo(String value) {
            addCriterion("var_num_operacion <=", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionLike(String value) {
            addCriterion("var_num_operacion like", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionNotLike(String value) {
            addCriterion("var_num_operacion not like", value, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionIn(List<String> values) {
            addCriterion("var_num_operacion in", values, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionNotIn(List<String> values) {
            addCriterion("var_num_operacion not in", values, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionBetween(String value1, String value2) {
            addCriterion("var_num_operacion between", value1, value2, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andVar_num_operacionNotBetween(String value1, String value2) {
            addCriterion("var_num_operacion not between", value1, value2, "var_num_operacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionIsNull() {
            addCriterion("dte_fecha_presentacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionIsNotNull() {
            addCriterion("dte_fecha_presentacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion =", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion <>", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion >", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion >=", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion <", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_presentacion <=", value, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_presentacion in", values, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_presentacion not in", values, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_presentacion between", value1, value2, "dte_fecha_presentacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_presentacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_presentacion not between", value1, value2, "dte_fecha_presentacion");
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