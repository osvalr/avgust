package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPostulanteCnvAreaOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPostulanteCnvAreaOrgExample() {
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

        public Criteria andSrl_id_postulante_conv_area_orgIsNull() {
            addCriterion("srl_id_postulante_conv_area_org is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgIsNotNull() {
            addCriterion("srl_id_postulante_conv_area_org is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgEqualTo(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org =", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgNotEqualTo(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org <>", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgGreaterThan(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org >", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org >=", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgLessThan(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org <", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_postulante_conv_area_org <=", value, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgIn(List<Integer> values) {
            addCriterion("srl_id_postulante_conv_area_org in", values, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgNotIn(List<Integer> values) {
            addCriterion("srl_id_postulante_conv_area_org not in", values, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_postulante_conv_area_org between", value1, value2, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_conv_area_orgNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_postulante_conv_area_org not between", value1, value2, "srl_id_postulante_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIsNull() {
            addCriterion("int_id_postulante is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIsNotNull() {
            addCriterion("int_id_postulante is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteEqualTo(Integer value) {
            addCriterion("int_id_postulante =", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotEqualTo(Integer value) {
            addCriterion("int_id_postulante <>", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteGreaterThan(Integer value) {
            addCriterion("int_id_postulante >", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_postulante >=", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteLessThan(Integer value) {
            addCriterion("int_id_postulante <", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_postulante <=", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIn(List<Integer> values) {
            addCriterion("int_id_postulante in", values, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotIn(List<Integer> values) {
            addCriterion("int_id_postulante not in", values, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteBetween(Integer value1, Integer value2) {
            addCriterion("int_id_postulante between", value1, value2, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_postulante not between", value1, value2, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgIsNull() {
            addCriterion("srl_id_conv_area_org is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgIsNotNull() {
            addCriterion("srl_id_conv_area_org is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org =", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgNotEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org <>", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgGreaterThan(Integer value) {
            addCriterion("srl_id_conv_area_org >", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org >=", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgLessThan(Integer value) {
            addCriterion("srl_id_conv_area_org <", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org <=", value, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org in", values, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgNotIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org not in", values, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org between", value1, value2, "srl_id_conv_area_org");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_orgNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org not between", value1, value2, "srl_id_conv_area_org");
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

        public Criteria andInt_orden_meritoIsNull() {
            addCriterion("int_orden_merito is null");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoIsNotNull() {
            addCriterion("int_orden_merito is not null");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoEqualTo(Integer value) {
            addCriterion("int_orden_merito =", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoNotEqualTo(Integer value) {
            addCriterion("int_orden_merito <>", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoGreaterThan(Integer value) {
            addCriterion("int_orden_merito >", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_orden_merito >=", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoLessThan(Integer value) {
            addCriterion("int_orden_merito <", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoLessThanOrEqualTo(Integer value) {
            addCriterion("int_orden_merito <=", value, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoIn(List<Integer> values) {
            addCriterion("int_orden_merito in", values, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoNotIn(List<Integer> values) {
            addCriterion("int_orden_merito not in", values, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoBetween(Integer value1, Integer value2) {
            addCriterion("int_orden_merito between", value1, value2, "int_orden_merito");
            return (Criteria) this;
        }

        public Criteria andInt_orden_meritoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_orden_merito not between", value1, value2, "int_orden_merito");
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

        public Criteria andDec_puntaje_totalIsNull() {
            addCriterion("dec_puntaje_total is null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalIsNotNull() {
            addCriterion("dec_puntaje_total is not null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_total =", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalNotEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_total <>", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalGreaterThan(BigDecimal value) {
            addCriterion("dec_puntaje_total >", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_total >=", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalLessThan(BigDecimal value) {
            addCriterion("dec_puntaje_total <", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_total <=", value, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_total in", values, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalNotIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_total not in", values, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_total between", value1, value2, "dec_puntaje_total");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_totalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_total not between", value1, value2, "dec_puntaje_total");
            return (Criteria) this;
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