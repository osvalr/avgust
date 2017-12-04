package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPersonaNaturalLegajoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonaNaturalLegajoExample() {
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

        public Criteria andSrl_id_persona_natural_legajoIsNull() {
            addCriterion("srl_id_persona_natural_legajo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoIsNotNull() {
            addCriterion("srl_id_persona_natural_legajo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo =", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <>", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoGreaterThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo >", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo >=", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoLessThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <=", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo in", values, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo not in", values, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo between", value1, value2, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo not between", value1, value2, "srl_id_persona_natural_legajo");
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

        public Criteria andInt_id_tipo_documentoIsNull() {
            addCriterion("int_id_tipo_documento is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoIsNotNull() {
            addCriterion("int_id_tipo_documento is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoEqualTo(Integer value) {
            addCriterion("int_id_tipo_documento =", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_documento <>", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_documento >", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_documento >=", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoLessThan(Integer value) {
            addCriterion("int_id_tipo_documento <", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_documento <=", value, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoIn(List<Integer> values) {
            addCriterion("int_id_tipo_documento in", values, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_documento not in", values, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_documento between", value1, value2, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_documentoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_documento not between", value1, value2, "int_id_tipo_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoIsNull() {
            addCriterion("var_nombre_documento is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoIsNotNull() {
            addCriterion("var_nombre_documento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoEqualTo(String value) {
            addCriterion("var_nombre_documento =", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoNotEqualTo(String value) {
            addCriterion("var_nombre_documento <>", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoGreaterThan(String value) {
            addCriterion("var_nombre_documento >", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_documento >=", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoLessThan(String value) {
            addCriterion("var_nombre_documento <", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_documento <=", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoLike(String value) {
            addCriterion("var_nombre_documento like", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoNotLike(String value) {
            addCriterion("var_nombre_documento not like", value, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoIn(List<String> values) {
            addCriterion("var_nombre_documento in", values, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoNotIn(List<String> values) {
            addCriterion("var_nombre_documento not in", values, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoBetween(String value1, String value2) {
            addCriterion("var_nombre_documento between", value1, value2, "var_nombre_documento");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_documentoNotBetween(String value1, String value2) {
            addCriterion("var_nombre_documento not between", value1, value2, "var_nombre_documento");
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

        public Criteria andVar_asunto_documentoIsNull() {
            addCriterion("var_asunto_documento is null");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoIsNotNull() {
            addCriterion("var_asunto_documento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoEqualTo(String value) {
            addCriterion("var_asunto_documento =", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoNotEqualTo(String value) {
            addCriterion("var_asunto_documento <>", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoGreaterThan(String value) {
            addCriterion("var_asunto_documento >", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoGreaterThanOrEqualTo(String value) {
            addCriterion("var_asunto_documento >=", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoLessThan(String value) {
            addCriterion("var_asunto_documento <", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoLessThanOrEqualTo(String value) {
            addCriterion("var_asunto_documento <=", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoLike(String value) {
            addCriterion("var_asunto_documento like", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoNotLike(String value) {
            addCriterion("var_asunto_documento not like", value, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoIn(List<String> values) {
            addCriterion("var_asunto_documento in", values, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoNotIn(List<String> values) {
            addCriterion("var_asunto_documento not in", values, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoBetween(String value1, String value2) {
            addCriterion("var_asunto_documento between", value1, value2, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_asunto_documentoNotBetween(String value1, String value2) {
            addCriterion("var_asunto_documento not between", value1, value2, "var_asunto_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoIsNull() {
            addCriterion("var_descripcion_documento is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoIsNotNull() {
            addCriterion("var_descripcion_documento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoEqualTo(String value) {
            addCriterion("var_descripcion_documento =", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoNotEqualTo(String value) {
            addCriterion("var_descripcion_documento <>", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoGreaterThan(String value) {
            addCriterion("var_descripcion_documento >", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_documento >=", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoLessThan(String value) {
            addCriterion("var_descripcion_documento <", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_documento <=", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoLike(String value) {
            addCriterion("var_descripcion_documento like", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoNotLike(String value) {
            addCriterion("var_descripcion_documento not like", value, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoIn(List<String> values) {
            addCriterion("var_descripcion_documento in", values, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoNotIn(List<String> values) {
            addCriterion("var_descripcion_documento not in", values, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoBetween(String value1, String value2) {
            addCriterion("var_descripcion_documento between", value1, value2, "var_descripcion_documento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_documentoNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_documento not between", value1, value2, "var_descripcion_documento");
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

        public Criteria andSrl_id_contratoIsNull() {
            addCriterion("srl_id_contrato is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoIsNotNull() {
            addCriterion("srl_id_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoEqualTo(Integer value) {
            addCriterion("srl_id_contrato =", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotEqualTo(Integer value) {
            addCriterion("srl_id_contrato <>", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoGreaterThan(Integer value) {
            addCriterion("srl_id_contrato >", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato >=", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoLessThan(Integer value) {
            addCriterion("srl_id_contrato <", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato <=", value, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoIn(List<Integer> values) {
            addCriterion("srl_id_contrato in", values, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotIn(List<Integer> values) {
            addCriterion("srl_id_contrato not in", values, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato between", value1, value2, "srl_id_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contratoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato not between", value1, value2, "srl_id_contrato");
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