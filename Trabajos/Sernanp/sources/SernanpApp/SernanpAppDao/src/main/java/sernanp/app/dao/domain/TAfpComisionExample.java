package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAfpComisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAfpComisionExample() {
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

        public Criteria andSrl_id_afp_comisionIsNull() {
            addCriterion("srl_id_afp_comision is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionIsNotNull() {
            addCriterion("srl_id_afp_comision is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionEqualTo(Integer value) {
            addCriterion("srl_id_afp_comision =", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionNotEqualTo(Integer value) {
            addCriterion("srl_id_afp_comision <>", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionGreaterThan(Integer value) {
            addCriterion("srl_id_afp_comision >", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp_comision >=", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionLessThan(Integer value) {
            addCriterion("srl_id_afp_comision <", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp_comision <=", value, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionIn(List<Integer> values) {
            addCriterion("srl_id_afp_comision in", values, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionNotIn(List<Integer> values) {
            addCriterion("srl_id_afp_comision not in", values, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp_comision between", value1, value2, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afp_comisionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp_comision not between", value1, value2, "srl_id_afp_comision");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNull() {
            addCriterion("srl_id_afp is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNotNull() {
            addCriterion("srl_id_afp is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpEqualTo(Integer value) {
            addCriterion("srl_id_afp =", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotEqualTo(Integer value) {
            addCriterion("srl_id_afp <>", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThan(Integer value) {
            addCriterion("srl_id_afp >", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp >=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThan(Integer value) {
            addCriterion("srl_id_afp <", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp <=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIn(List<Integer> values) {
            addCriterion("srl_id_afp in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotIn(List<Integer> values) {
            addCriterion("srl_id_afp not in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp not between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNull() {
            addCriterion("int_id_tipo_comision is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNotNull() {
            addCriterion("int_id_tipo_comision is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision =", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <>", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThan(Integer value) {
            addCriterion("int_id_tipo_comision >", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision >=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThan(Integer value) {
            addCriterion("int_id_tipo_comision <", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision not in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision between", value1, value2, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision not between", value1, value2, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andDec_aporteIsNull() {
            addCriterion("dec_aporte is null");
            return (Criteria) this;
        }

        public Criteria andDec_aporteIsNotNull() {
            addCriterion("dec_aporte is not null");
            return (Criteria) this;
        }

        public Criteria andDec_aporteEqualTo(BigDecimal value) {
            addCriterion("dec_aporte =", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteNotEqualTo(BigDecimal value) {
            addCriterion("dec_aporte <>", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteGreaterThan(BigDecimal value) {
            addCriterion("dec_aporte >", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_aporte >=", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteLessThan(BigDecimal value) {
            addCriterion("dec_aporte <", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_aporte <=", value, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteIn(List<BigDecimal> values) {
            addCriterion("dec_aporte in", values, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteNotIn(List<BigDecimal> values) {
            addCriterion("dec_aporte not in", values, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_aporte between", value1, value2, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_aporteNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_aporte not between", value1, value2, "dec_aporte");
            return (Criteria) this;
        }

        public Criteria andDec_seguroIsNull() {
            addCriterion("dec_seguro is null");
            return (Criteria) this;
        }

        public Criteria andDec_seguroIsNotNull() {
            addCriterion("dec_seguro is not null");
            return (Criteria) this;
        }

        public Criteria andDec_seguroEqualTo(BigDecimal value) {
            addCriterion("dec_seguro =", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroNotEqualTo(BigDecimal value) {
            addCriterion("dec_seguro <>", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroGreaterThan(BigDecimal value) {
            addCriterion("dec_seguro >", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_seguro >=", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroLessThan(BigDecimal value) {
            addCriterion("dec_seguro <", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_seguro <=", value, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroIn(List<BigDecimal> values) {
            addCriterion("dec_seguro in", values, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroNotIn(List<BigDecimal> values) {
            addCriterion("dec_seguro not in", values, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_seguro between", value1, value2, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_seguroNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_seguro not between", value1, value2, "dec_seguro");
            return (Criteria) this;
        }

        public Criteria andDec_comisionIsNull() {
            addCriterion("dec_comision is null");
            return (Criteria) this;
        }

        public Criteria andDec_comisionIsNotNull() {
            addCriterion("dec_comision is not null");
            return (Criteria) this;
        }

        public Criteria andDec_comisionEqualTo(BigDecimal value) {
            addCriterion("dec_comision =", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionNotEqualTo(BigDecimal value) {
            addCriterion("dec_comision <>", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionGreaterThan(BigDecimal value) {
            addCriterion("dec_comision >", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_comision >=", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionLessThan(BigDecimal value) {
            addCriterion("dec_comision <", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_comision <=", value, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionIn(List<BigDecimal> values) {
            addCriterion("dec_comision in", values, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionNotIn(List<BigDecimal> values) {
            addCriterion("dec_comision not in", values, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_comision between", value1, value2, "dec_comision");
            return (Criteria) this;
        }

        public Criteria andDec_comisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_comision not between", value1, value2, "dec_comision");
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