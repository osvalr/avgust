package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TConvocatoriaAreaOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConvocatoriaAreaOrgExample() {
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

        public Criteria andVar_codigo_postulacionIsNull() {
            addCriterion("var_codigo_postulacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionIsNotNull() {
            addCriterion("var_codigo_postulacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionEqualTo(String value) {
            addCriterion("var_codigo_postulacion =", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionNotEqualTo(String value) {
            addCriterion("var_codigo_postulacion <>", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionGreaterThan(String value) {
            addCriterion("var_codigo_postulacion >", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_postulacion >=", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionLessThan(String value) {
            addCriterion("var_codigo_postulacion <", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionLessThanOrEqualTo(String value) {
            addCriterion("var_codigo_postulacion <=", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionLike(String value) {
            addCriterion("var_codigo_postulacion like", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionNotLike(String value) {
            addCriterion("var_codigo_postulacion not like", value, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionIn(List<String> values) {
            addCriterion("var_codigo_postulacion in", values, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionNotIn(List<String> values) {
            addCriterion("var_codigo_postulacion not in", values, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionBetween(String value1, String value2) {
            addCriterion("var_codigo_postulacion between", value1, value2, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_postulacionNotBetween(String value1, String value2) {
            addCriterion("var_codigo_postulacion not between", value1, value2, "var_codigo_postulacion");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosIsNull() {
            addCriterion("int_num_puestos is null");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosIsNotNull() {
            addCriterion("int_num_puestos is not null");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosEqualTo(Integer value) {
            addCriterion("int_num_puestos =", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosNotEqualTo(Integer value) {
            addCriterion("int_num_puestos <>", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosGreaterThan(Integer value) {
            addCriterion("int_num_puestos >", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_num_puestos >=", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosLessThan(Integer value) {
            addCriterion("int_num_puestos <", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosLessThanOrEqualTo(Integer value) {
            addCriterion("int_num_puestos <=", value, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosIn(List<Integer> values) {
            addCriterion("int_num_puestos in", values, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosNotIn(List<Integer> values) {
            addCriterion("int_num_puestos not in", values, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosBetween(Integer value1, Integer value2) {
            addCriterion("int_num_puestos between", value1, value2, "int_num_puestos");
            return (Criteria) this;
        }

        public Criteria andInt_num_puestosNotBetween(Integer value1, Integer value2) {
            addCriterion("int_num_puestos not between", value1, value2, "int_num_puestos");
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

        public Criteria andSrl_id_requerimiento_personalIsNull() {
            addCriterion("srl_id_requerimiento_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalIsNotNull() {
            addCriterion("srl_id_requerimiento_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal =", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal <>", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalGreaterThan(Integer value) {
            addCriterion("srl_id_requerimiento_personal >", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal >=", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalLessThan(Integer value) {
            addCriterion("srl_id_requerimiento_personal <", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_requerimiento_personal <=", value, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalIn(List<Integer> values) {
            addCriterion("srl_id_requerimiento_personal in", values, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_requerimiento_personal not in", values, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_requerimiento_personal between", value1, value2, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_requerimiento_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_requerimiento_personal not between", value1, value2, "srl_id_requerimiento_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionIsNull() {
            addCriterion("srl_id_configuracion_factor_evaluacion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionIsNotNull() {
            addCriterion("srl_id_configuracion_factor_evaluacion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion =", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionNotEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion <>", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionGreaterThan(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion >", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion >=", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionLessThan(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion <", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_factor_evaluacion <=", value, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionIn(List<Integer> values) {
            addCriterion("srl_id_configuracion_factor_evaluacion in", values, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionNotIn(List<Integer> values) {
            addCriterion("srl_id_configuracion_factor_evaluacion not in", values, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_configuracion_factor_evaluacion between", value1, value2, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_factor_evaluacionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_configuracion_factor_evaluacion not between", value1, value2, "srl_id_configuracion_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalIsNull() {
            addCriterion("srl_id_configuracion_evaluacion_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalIsNotNull() {
            addCriterion("srl_id_configuracion_evaluacion_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal =", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal <>", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalGreaterThan(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal >", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal >=", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalLessThan(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal <", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_configuracion_evaluacion_personal <=", value, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalIn(List<Integer> values) {
            addCriterion("srl_id_configuracion_evaluacion_personal in", values, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_configuracion_evaluacion_personal not in", values, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_configuracion_evaluacion_personal between", value1, value2, "srl_id_configuracion_evaluacion_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_configuracion_evaluacion_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_configuracion_evaluacion_personal not between", value1, value2, "srl_id_configuracion_evaluacion_personal");
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

        public Criteria andVar_lugar_prestacionIsNull() {
            addCriterion("var_lugar_prestacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionIsNotNull() {
            addCriterion("var_lugar_prestacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionEqualTo(String value) {
            addCriterion("var_lugar_prestacion =", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotEqualTo(String value) {
            addCriterion("var_lugar_prestacion <>", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionGreaterThan(String value) {
            addCriterion("var_lugar_prestacion >", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_lugar_prestacion >=", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLessThan(String value) {
            addCriterion("var_lugar_prestacion <", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLessThanOrEqualTo(String value) {
            addCriterion("var_lugar_prestacion <=", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionLike(String value) {
            addCriterion("var_lugar_prestacion like", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotLike(String value) {
            addCriterion("var_lugar_prestacion not like", value, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionIn(List<String> values) {
            addCriterion("var_lugar_prestacion in", values, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotIn(List<String> values) {
            addCriterion("var_lugar_prestacion not in", values, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionBetween(String value1, String value2) {
            addCriterion("var_lugar_prestacion between", value1, value2, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andVar_lugar_prestacionNotBetween(String value1, String value2) {
            addCriterion("var_lugar_prestacion not between", value1, value2, "var_lugar_prestacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoIsNull() {
            addCriterion("dte_fecha_inicio_contrato is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoIsNotNull() {
            addCriterion("dte_fecha_inicio_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato =", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato <>", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato >", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato >=", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato <", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato <=", value, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato in", values, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato not in", values, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato between", value1, value2, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicio_contratoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio_contrato not between", value1, value2, "dte_fecha_inicio_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoIsNull() {
            addCriterion("dte_fecha_fin_contrato is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoIsNotNull() {
            addCriterion("dte_fecha_fin_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato =", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato <>", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato >", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato >=", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato <", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato <=", value, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato in", values, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato not in", values, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato between", value1, value2, "dte_fecha_fin_contrato");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_fin_contratoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin_contrato not between", value1, value2, "dte_fecha_fin_contrato");
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