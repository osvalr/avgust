package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPersonalDescuentoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalDescuentoExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andSrl_id_pers_descIsNull() {
            addCriterion("srl_id_pers_desc is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descIsNotNull() {
            addCriterion("srl_id_pers_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descEqualTo(Integer value) {
            addCriterion("srl_id_pers_desc =", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descNotEqualTo(Integer value) {
            addCriterion("srl_id_pers_desc <>", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descGreaterThan(Integer value) {
            addCriterion("srl_id_pers_desc >", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_pers_desc >=", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descLessThan(Integer value) {
            addCriterion("srl_id_pers_desc <", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_pers_desc <=", value, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descIn(List<Integer> values) {
            addCriterion("srl_id_pers_desc in", values, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descNotIn(List<Integer> values) {
            addCriterion("srl_id_pers_desc not in", values, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_pers_desc between", value1, value2, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_descNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_pers_desc not between", value1, value2, "srl_id_pers_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descIsNull() {
            addCriterion("int_periodo_desc is null");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descIsNotNull() {
            addCriterion("int_periodo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descEqualTo(Integer value) {
            addCriterion("int_periodo_desc =", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descNotEqualTo(Integer value) {
            addCriterion("int_periodo_desc <>", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descGreaterThan(Integer value) {
            addCriterion("int_periodo_desc >", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_periodo_desc >=", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descLessThan(Integer value) {
            addCriterion("int_periodo_desc <", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descLessThanOrEqualTo(Integer value) {
            addCriterion("int_periodo_desc <=", value, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descIn(List<Integer> values) {
            addCriterion("int_periodo_desc in", values, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descNotIn(List<Integer> values) {
            addCriterion("int_periodo_desc not in", values, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descBetween(Integer value1, Integer value2) {
            addCriterion("int_periodo_desc between", value1, value2, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_descNotBetween(Integer value1, Integer value2) {
            addCriterion("int_periodo_desc not between", value1, value2, "int_periodo_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descIsNull() {
            addCriterion("int_mes_desc is null");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descIsNotNull() {
            addCriterion("int_mes_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descEqualTo(Integer value) {
            addCriterion("int_mes_desc =", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descNotEqualTo(Integer value) {
            addCriterion("int_mes_desc <>", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descGreaterThan(Integer value) {
            addCriterion("int_mes_desc >", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_mes_desc >=", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descLessThan(Integer value) {
            addCriterion("int_mes_desc <", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descLessThanOrEqualTo(Integer value) {
            addCriterion("int_mes_desc <=", value, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descIn(List<Integer> values) {
            addCriterion("int_mes_desc in", values, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descNotIn(List<Integer> values) {
            addCriterion("int_mes_desc not in", values, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descBetween(Integer value1, Integer value2) {
            addCriterion("int_mes_desc between", value1, value2, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andInt_mes_descNotBetween(Integer value1, Integer value2) {
            addCriterion("int_mes_desc not between", value1, value2, "int_mes_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descIsNull() {
            addCriterion("num_monto_desc is null");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descIsNotNull() {
            addCriterion("num_monto_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descEqualTo(BigDecimal value) {
            addCriterion("num_monto_desc =", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descNotEqualTo(BigDecimal value) {
            addCriterion("num_monto_desc <>", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descGreaterThan(BigDecimal value) {
            addCriterion("num_monto_desc >", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("num_monto_desc >=", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descLessThan(BigDecimal value) {
            addCriterion("num_monto_desc <", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descLessThanOrEqualTo(BigDecimal value) {
            addCriterion("num_monto_desc <=", value, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descIn(List<BigDecimal> values) {
            addCriterion("num_monto_desc in", values, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descNotIn(List<BigDecimal> values) {
            addCriterion("num_monto_desc not in", values, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_monto_desc between", value1, value2, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andNum_monto_descNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_monto_desc not between", value1, value2, "num_monto_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descIsNull() {
            addCriterion("tsp_fec_pers_desc is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descIsNotNull() {
            addCriterion("tsp_fec_pers_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descEqualTo(Date value) {
            addCriterion("tsp_fec_pers_desc =", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descNotEqualTo(Date value) {
            addCriterion("tsp_fec_pers_desc <>", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descGreaterThan(Date value) {
            addCriterion("tsp_fec_pers_desc >", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_pers_desc >=", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descLessThan(Date value) {
            addCriterion("tsp_fec_pers_desc <", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_pers_desc <=", value, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descIn(List<Date> values) {
            addCriterion("tsp_fec_pers_desc in", values, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descNotIn(List<Date> values) {
            addCriterion("tsp_fec_pers_desc not in", values, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_pers_desc between", value1, value2, "tsp_fec_pers_desc");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_pers_descNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_pers_desc not between", value1, value2, "tsp_fec_pers_desc");
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

        public Criteria andIdtablatipoIsNull() {
            addCriterion("idtablatipo is null");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoIsNotNull() {
            addCriterion("idtablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoEqualTo(Integer value) {
            addCriterion("idtablatipo =", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoNotEqualTo(Integer value) {
            addCriterion("idtablatipo <>", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoGreaterThan(Integer value) {
            addCriterion("idtablatipo >", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idtablatipo >=", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoLessThan(Integer value) {
            addCriterion("idtablatipo <", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoLessThanOrEqualTo(Integer value) {
            addCriterion("idtablatipo <=", value, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoIn(List<Integer> values) {
            addCriterion("idtablatipo in", values, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoNotIn(List<Integer> values) {
            addCriterion("idtablatipo not in", values, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoBetween(Integer value1, Integer value2) {
            addCriterion("idtablatipo between", value1, value2, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablatipoNotBetween(Integer value1, Integer value2) {
            addCriterion("idtablatipo not between", value1, value2, "idtablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaIsNull() {
            addCriterion("int_minutos_tardanza is null");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaIsNotNull() {
            addCriterion("int_minutos_tardanza is not null");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaEqualTo(Integer value) {
            addCriterion("int_minutos_tardanza =", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaNotEqualTo(Integer value) {
            addCriterion("int_minutos_tardanza <>", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaGreaterThan(Integer value) {
            addCriterion("int_minutos_tardanza >", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_minutos_tardanza >=", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaLessThan(Integer value) {
            addCriterion("int_minutos_tardanza <", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaLessThanOrEqualTo(Integer value) {
            addCriterion("int_minutos_tardanza <=", value, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaIn(List<Integer> values) {
            addCriterion("int_minutos_tardanza in", values, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaNotIn(List<Integer> values) {
            addCriterion("int_minutos_tardanza not in", values, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaBetween(Integer value1, Integer value2) {
            addCriterion("int_minutos_tardanza between", value1, value2, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_minutos_tardanzaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_minutos_tardanza not between", value1, value2, "int_minutos_tardanza");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasIsNull() {
            addCriterion("int_cant_inasistencias is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasIsNotNull() {
            addCriterion("int_cant_inasistencias is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasEqualTo(Integer value) {
            addCriterion("int_cant_inasistencias =", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasNotEqualTo(Integer value) {
            addCriterion("int_cant_inasistencias <>", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasGreaterThan(Integer value) {
            addCriterion("int_cant_inasistencias >", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_inasistencias >=", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasLessThan(Integer value) {
            addCriterion("int_cant_inasistencias <", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_inasistencias <=", value, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasIn(List<Integer> values) {
            addCriterion("int_cant_inasistencias in", values, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasNotIn(List<Integer> values) {
            addCriterion("int_cant_inasistencias not in", values, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_inasistencias between", value1, value2, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_inasistenciasNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_inasistencias not between", value1, value2, "int_cant_inasistencias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoIsNull() {
            addCriterion("int_cant_dias_permiso is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoIsNotNull() {
            addCriterion("int_cant_dias_permiso is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoEqualTo(Integer value) {
            addCriterion("int_cant_dias_permiso =", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoNotEqualTo(Integer value) {
            addCriterion("int_cant_dias_permiso <>", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoGreaterThan(Integer value) {
            addCriterion("int_cant_dias_permiso >", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias_permiso >=", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoLessThan(Integer value) {
            addCriterion("int_cant_dias_permiso <", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias_permiso <=", value, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoIn(List<Integer> values) {
            addCriterion("int_cant_dias_permiso in", values, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoNotIn(List<Integer> values) {
            addCriterion("int_cant_dias_permiso not in", values, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias_permiso between", value1, value2, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_permisoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias_permiso not between", value1, value2, "int_cant_dias_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghIsNull() {
            addCriterion("int_cant_dias_licencias_sgh is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghIsNotNull() {
            addCriterion("int_cant_dias_licencias_sgh is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghEqualTo(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh =", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghNotEqualTo(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh <>", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghGreaterThan(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh >", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh >=", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghLessThan(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh <", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias_licencias_sgh <=", value, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghIn(List<Integer> values) {
            addCriterion("int_cant_dias_licencias_sgh in", values, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghNotIn(List<Integer> values) {
            addCriterion("int_cant_dias_licencias_sgh not in", values, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias_licencias_sgh between", value1, value2, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andInt_cant_dias_licencias_sghNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias_licencias_sgh not between", value1, value2, "int_cant_dias_licencias_sgh");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoIsNull() {
            addCriterion("hor_cant_permiso is null");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoIsNotNull() {
            addCriterion("hor_cant_permiso is not null");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoEqualTo(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso =", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoNotEqualTo(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso <>", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoGreaterThan(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso >", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso >=", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoLessThan(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso <", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hor_cant_permiso <=", value, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoIn(List<Date> values) {
            addCriterionForJDBCTime("hor_cant_permiso in", values, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoNotIn(List<Date> values) {
            addCriterionForJDBCTime("hor_cant_permiso not in", values, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hor_cant_permiso between", value1, value2, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andHor_cant_permisoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hor_cant_permiso not between", value1, value2, "hor_cant_permiso");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionIsNull() {
            addCriterion("int_flag_ubicacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionIsNotNull() {
            addCriterion("int_flag_ubicacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionEqualTo(Integer value) {
            addCriterion("int_flag_ubicacion =", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionNotEqualTo(Integer value) {
            addCriterion("int_flag_ubicacion <>", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionGreaterThan(Integer value) {
            addCriterion("int_flag_ubicacion >", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_flag_ubicacion >=", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionLessThan(Integer value) {
            addCriterion("int_flag_ubicacion <", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_flag_ubicacion <=", value, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionIn(List<Integer> values) {
            addCriterion("int_flag_ubicacion in", values, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionNotIn(List<Integer> values) {
            addCriterion("int_flag_ubicacion not in", values, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionBetween(Integer value1, Integer value2) {
            addCriterion("int_flag_ubicacion between", value1, value2, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_flag_ubicacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_flag_ubicacion not between", value1, value2, "int_flag_ubicacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualIsNull() {
            addCriterion("int_id_reg_contractual is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualIsNotNull() {
            addCriterion("int_id_reg_contractual is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualEqualTo(Integer value) {
            addCriterion("int_id_reg_contractual =", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualNotEqualTo(Integer value) {
            addCriterion("int_id_reg_contractual <>", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualGreaterThan(Integer value) {
            addCriterion("int_id_reg_contractual >", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_reg_contractual >=", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualLessThan(Integer value) {
            addCriterion("int_id_reg_contractual <", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_reg_contractual <=", value, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualIn(List<Integer> values) {
            addCriterion("int_id_reg_contractual in", values, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualNotIn(List<Integer> values) {
            addCriterion("int_id_reg_contractual not in", values, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualBetween(Integer value1, Integer value2) {
            addCriterion("int_id_reg_contractual between", value1, value2, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_contractualNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_reg_contractual not between", value1, value2, "int_id_reg_contractual");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeIsNull() {
            addCriterion("int_id_sede is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeIsNotNull() {
            addCriterion("int_id_sede is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeEqualTo(Integer value) {
            addCriterion("int_id_sede =", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeNotEqualTo(Integer value) {
            addCriterion("int_id_sede <>", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeGreaterThan(Integer value) {
            addCriterion("int_id_sede >", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_sede >=", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeLessThan(Integer value) {
            addCriterion("int_id_sede <", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_sede <=", value, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeIn(List<Integer> values) {
            addCriterion("int_id_sede in", values, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeNotIn(List<Integer> values) {
            addCriterion("int_id_sede not in", values, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeBetween(Integer value1, Integer value2) {
            addCriterion("int_id_sede between", value1, value2, "int_id_sede");
            return (Criteria) this;
        }

        public Criteria andInt_id_sedeNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_sede not between", value1, value2, "int_id_sede");
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