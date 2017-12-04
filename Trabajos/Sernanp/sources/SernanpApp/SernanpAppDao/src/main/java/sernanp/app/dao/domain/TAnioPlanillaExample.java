package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TAnioPlanillaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAnioPlanillaExample() {
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

        public Criteria andSrl_id_anio_planillaIsNull() {
            addCriterion("srl_id_anio_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIsNotNull() {
            addCriterion("srl_id_anio_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla =", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <>", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_anio_planilla >", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla >=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThan(Integer value) {
            addCriterion("srl_id_anio_planilla <", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_anio_planilla <=", value, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_anio_planilla not in", values, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla between", value1, value2, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_anio_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_anio_planilla not between", value1, value2, "srl_id_anio_planilla");
            return (Criteria) this;
        }

        public Criteria andInt_anioIsNull() {
            addCriterion("int_anio is null");
            return (Criteria) this;
        }

        public Criteria andInt_anioIsNotNull() {
            addCriterion("int_anio is not null");
            return (Criteria) this;
        }

        public Criteria andInt_anioEqualTo(Integer value) {
            addCriterion("int_anio =", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotEqualTo(Integer value) {
            addCriterion("int_anio <>", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioGreaterThan(Integer value) {
            addCriterion("int_anio >", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_anio >=", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioLessThan(Integer value) {
            addCriterion("int_anio <", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioLessThanOrEqualTo(Integer value) {
            addCriterion("int_anio <=", value, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioIn(List<Integer> values) {
            addCriterion("int_anio in", values, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotIn(List<Integer> values) {
            addCriterion("int_anio not in", values, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioBetween(Integer value1, Integer value2) {
            addCriterion("int_anio between", value1, value2, "int_anio");
            return (Criteria) this;
        }

        public Criteria andInt_anioNotBetween(Integer value1, Integer value2) {
            addCriterion("int_anio not between", value1, value2, "int_anio");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorIsNull() {
            addCriterion("var_cod_ejecutor is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorIsNotNull() {
            addCriterion("var_cod_ejecutor is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorEqualTo(String value) {
            addCriterion("var_cod_ejecutor =", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorNotEqualTo(String value) {
            addCriterion("var_cod_ejecutor <>", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorGreaterThan(String value) {
            addCriterion("var_cod_ejecutor >", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_ejecutor >=", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorLessThan(String value) {
            addCriterion("var_cod_ejecutor <", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorLessThanOrEqualTo(String value) {
            addCriterion("var_cod_ejecutor <=", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorLike(String value) {
            addCriterion("var_cod_ejecutor like", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorNotLike(String value) {
            addCriterion("var_cod_ejecutor not like", value, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorIn(List<String> values) {
            addCriterion("var_cod_ejecutor in", values, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorNotIn(List<String> values) {
            addCriterion("var_cod_ejecutor not in", values, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorBetween(String value1, String value2) {
            addCriterion("var_cod_ejecutor between", value1, value2, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_cod_ejecutorNotBetween(String value1, String value2) {
            addCriterion("var_cod_ejecutor not between", value1, value2, "var_cod_ejecutor");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioIsNull() {
            addCriterion("var_nombre_anio is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioIsNotNull() {
            addCriterion("var_nombre_anio is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioEqualTo(String value) {
            addCriterion("var_nombre_anio =", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioNotEqualTo(String value) {
            addCriterion("var_nombre_anio <>", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioGreaterThan(String value) {
            addCriterion("var_nombre_anio >", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_anio >=", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioLessThan(String value) {
            addCriterion("var_nombre_anio <", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_anio <=", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioLike(String value) {
            addCriterion("var_nombre_anio like", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioNotLike(String value) {
            addCriterion("var_nombre_anio not like", value, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioIn(List<String> values) {
            addCriterion("var_nombre_anio in", values, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioNotIn(List<String> values) {
            addCriterion("var_nombre_anio not in", values, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioBetween(String value1, String value2) {
            addCriterion("var_nombre_anio between", value1, value2, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_anioNotBetween(String value1, String value2) {
            addCriterion("var_nombre_anio not between", value1, value2, "var_nombre_anio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIsNull() {
            addCriterion("dte_fecha_inicio is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIsNotNull() {
            addCriterion("dte_fecha_inicio is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio =", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <>", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio >", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio >=", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <=", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio in", values, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio not in", values, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio between", value1, value2, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio not between", value1, value2, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIsNull() {
            addCriterion("dte_fecha_fin is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIsNotNull() {
            addCriterion("dte_fecha_fin is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin =", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <>", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin >", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin >=", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <=", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin in", values, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin not in", values, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin between", value1, value2, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin not between", value1, value2, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaIsNull() {
            addCriterion("int_id_estado_vigencia is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaIsNotNull() {
            addCriterion("int_id_estado_vigencia is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaEqualTo(Integer value) {
            addCriterion("int_id_estado_vigencia =", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaNotEqualTo(Integer value) {
            addCriterion("int_id_estado_vigencia <>", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaGreaterThan(Integer value) {
            addCriterion("int_id_estado_vigencia >", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_vigencia >=", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaLessThan(Integer value) {
            addCriterion("int_id_estado_vigencia <", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_vigencia <=", value, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaIn(List<Integer> values) {
            addCriterion("int_id_estado_vigencia in", values, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaNotIn(List<Integer> values) {
            addCriterion("int_id_estado_vigencia not in", values, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_vigencia between", value1, value2, "int_id_estado_vigencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_vigenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_vigencia not between", value1, value2, "int_id_estado_vigencia");
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