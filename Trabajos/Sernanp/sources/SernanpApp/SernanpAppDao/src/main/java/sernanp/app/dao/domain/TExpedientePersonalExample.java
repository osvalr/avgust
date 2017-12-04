package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TExpedientePersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TExpedientePersonalExample() {
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

        public Criteria andSrl_id_expedienteIsNull() {
            addCriterion("srl_id_expediente is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteIsNotNull() {
            addCriterion("srl_id_expediente is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteEqualTo(Integer value) {
            addCriterion("srl_id_expediente =", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteNotEqualTo(Integer value) {
            addCriterion("srl_id_expediente <>", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteGreaterThan(Integer value) {
            addCriterion("srl_id_expediente >", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_expediente >=", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteLessThan(Integer value) {
            addCriterion("srl_id_expediente <", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_expediente <=", value, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteIn(List<Integer> values) {
            addCriterion("srl_id_expediente in", values, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteNotIn(List<Integer> values) {
            addCriterion("srl_id_expediente not in", values, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_expediente between", value1, value2, "srl_id_expediente");
            return (Criteria) this;
        }

        public Criteria andSrl_id_expedienteNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_expediente not between", value1, value2, "srl_id_expediente");
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

        public Criteria andVar_num_expedienteIsNull() {
            addCriterion("var_num_expediente is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteIsNotNull() {
            addCriterion("var_num_expediente is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteEqualTo(String value) {
            addCriterion("var_num_expediente =", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotEqualTo(String value) {
            addCriterion("var_num_expediente <>", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteGreaterThan(String value) {
            addCriterion("var_num_expediente >", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_expediente >=", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLessThan(String value) {
            addCriterion("var_num_expediente <", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLessThanOrEqualTo(String value) {
            addCriterion("var_num_expediente <=", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLike(String value) {
            addCriterion("var_num_expediente like", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotLike(String value) {
            addCriterion("var_num_expediente not like", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteIn(List<String> values) {
            addCriterion("var_num_expediente in", values, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotIn(List<String> values) {
            addCriterion("var_num_expediente not in", values, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteBetween(String value1, String value2) {
            addCriterion("var_num_expediente between", value1, value2, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotBetween(String value1, String value2) {
            addCriterion("var_num_expediente not between", value1, value2, "var_num_expediente");
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

        public Criteria andVar_num_fileIsNull() {
            addCriterion("var_num_file is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileIsNotNull() {
            addCriterion("var_num_file is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileEqualTo(String value) {
            addCriterion("var_num_file =", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotEqualTo(String value) {
            addCriterion("var_num_file <>", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileGreaterThan(String value) {
            addCriterion("var_num_file >", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_file >=", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLessThan(String value) {
            addCriterion("var_num_file <", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLessThanOrEqualTo(String value) {
            addCriterion("var_num_file <=", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLike(String value) {
            addCriterion("var_num_file like", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotLike(String value) {
            addCriterion("var_num_file not like", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileIn(List<String> values) {
            addCriterion("var_num_file in", values, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotIn(List<String> values) {
            addCriterion("var_num_file not in", values, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileBetween(String value1, String value2) {
            addCriterion("var_num_file between", value1, value2, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotBetween(String value1, String value2) {
            addCriterion("var_num_file not between", value1, value2, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIsNull() {
            addCriterion("var_num_caja is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIsNotNull() {
            addCriterion("var_num_caja is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaEqualTo(String value) {
            addCriterion("var_num_caja =", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotEqualTo(String value) {
            addCriterion("var_num_caja <>", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaGreaterThan(String value) {
            addCriterion("var_num_caja >", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_caja >=", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLessThan(String value) {
            addCriterion("var_num_caja <", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLessThanOrEqualTo(String value) {
            addCriterion("var_num_caja <=", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLike(String value) {
            addCriterion("var_num_caja like", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotLike(String value) {
            addCriterion("var_num_caja not like", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIn(List<String> values) {
            addCriterion("var_num_caja in", values, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotIn(List<String> values) {
            addCriterion("var_num_caja not in", values, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaBetween(String value1, String value2) {
            addCriterion("var_num_caja between", value1, value2, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotBetween(String value1, String value2) {
            addCriterion("var_num_caja not between", value1, value2, "var_num_caja");
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