package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPersonalVacacionesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalVacacionesExample() {
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

        public Criteria andSrl_id_pers_vacIsNull() {
            addCriterion("srl_id_pers_vac is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacIsNotNull() {
            addCriterion("srl_id_pers_vac is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacEqualTo(Integer value) {
            addCriterion("srl_id_pers_vac =", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacNotEqualTo(Integer value) {
            addCriterion("srl_id_pers_vac <>", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacGreaterThan(Integer value) {
            addCriterion("srl_id_pers_vac >", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_pers_vac >=", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacLessThan(Integer value) {
            addCriterion("srl_id_pers_vac <", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_pers_vac <=", value, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacIn(List<Integer> values) {
            addCriterion("srl_id_pers_vac in", values, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacNotIn(List<Integer> values) {
            addCriterion("srl_id_pers_vac not in", values, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_pers_vac between", value1, value2, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andSrl_id_pers_vacNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_pers_vac not between", value1, value2, "srl_id_pers_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacIsNull() {
            addCriterion("int_periodo_vac is null");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacIsNotNull() {
            addCriterion("int_periodo_vac is not null");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacEqualTo(Integer value) {
            addCriterion("int_periodo_vac =", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacNotEqualTo(Integer value) {
            addCriterion("int_periodo_vac <>", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacGreaterThan(Integer value) {
            addCriterion("int_periodo_vac >", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_periodo_vac >=", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacLessThan(Integer value) {
            addCriterion("int_periodo_vac <", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacLessThanOrEqualTo(Integer value) {
            addCriterion("int_periodo_vac <=", value, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacIn(List<Integer> values) {
            addCriterion("int_periodo_vac in", values, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacNotIn(List<Integer> values) {
            addCriterion("int_periodo_vac not in", values, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacBetween(Integer value1, Integer value2) {
            addCriterion("int_periodo_vac between", value1, value2, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andInt_periodo_vacNotBetween(Integer value1, Integer value2) {
            addCriterion("int_periodo_vac not between", value1, value2, "int_periodo_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacIsNull() {
            addCriterion("dte_fec_inicio_programacion_vac is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacIsNotNull() {
            addCriterion("dte_fec_inicio_programacion_vac is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac =", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac <>", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac >", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac >=", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac <", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac <=", value, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac in", values, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac not in", values, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac between", value1, value2, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicio_programacion_vacNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_inicio_programacion_vac not between", value1, value2, "dte_fec_inicio_programacion_vac");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesIsNull() {
            addCriterion("int_est_vacaciones is null");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesIsNotNull() {
            addCriterion("int_est_vacaciones is not null");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesEqualTo(Integer value) {
            addCriterion("int_est_vacaciones =", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesNotEqualTo(Integer value) {
            addCriterion("int_est_vacaciones <>", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesGreaterThan(Integer value) {
            addCriterion("int_est_vacaciones >", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_est_vacaciones >=", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesLessThan(Integer value) {
            addCriterion("int_est_vacaciones <", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesLessThanOrEqualTo(Integer value) {
            addCriterion("int_est_vacaciones <=", value, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesIn(List<Integer> values) {
            addCriterion("int_est_vacaciones in", values, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesNotIn(List<Integer> values) {
            addCriterion("int_est_vacaciones not in", values, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesBetween(Integer value1, Integer value2) {
            addCriterion("int_est_vacaciones between", value1, value2, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andInt_est_vacacionesNotBetween(Integer value1, Integer value2) {
            addCriterion("int_est_vacaciones not between", value1, value2, "int_est_vacaciones");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaIsNull() {
            addCriterion("tsp_fec_sys_crea is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaIsNotNull() {
            addCriterion("tsp_fec_sys_crea is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaEqualTo(Date value) {
            addCriterion("tsp_fec_sys_crea =", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaNotEqualTo(Date value) {
            addCriterion("tsp_fec_sys_crea <>", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaGreaterThan(Date value) {
            addCriterion("tsp_fec_sys_crea >", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_crea >=", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaLessThan(Date value) {
            addCriterion("tsp_fec_sys_crea <", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_crea <=", value, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaIn(List<Date> values) {
            addCriterion("tsp_fec_sys_crea in", values, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaNotIn(List<Date> values) {
            addCriterion("tsp_fec_sys_crea not in", values, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_crea between", value1, value2, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_creaNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_crea not between", value1, value2, "tsp_fec_sys_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modIsNull() {
            addCriterion("tsp_fec_sys_mod is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modIsNotNull() {
            addCriterion("tsp_fec_sys_mod is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modEqualTo(Date value) {
            addCriterion("tsp_fec_sys_mod =", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modNotEqualTo(Date value) {
            addCriterion("tsp_fec_sys_mod <>", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modGreaterThan(Date value) {
            addCriterion("tsp_fec_sys_mod >", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_mod >=", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modLessThan(Date value) {
            addCriterion("tsp_fec_sys_mod <", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_mod <=", value, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modIn(List<Date> values) {
            addCriterion("tsp_fec_sys_mod in", values, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modNotIn(List<Date> values) {
            addCriterion("tsp_fec_sys_mod not in", values, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_mod between", value1, value2, "tsp_fec_sys_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_modNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_mod not between", value1, value2, "tsp_fec_sys_mod");
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

        public Criteria andInt_dias_vac_correspondeIsNull() {
            addCriterion("int_dias_vac_corresponde is null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeIsNotNull() {
            addCriterion("int_dias_vac_corresponde is not null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeEqualTo(Integer value) {
            addCriterion("int_dias_vac_corresponde =", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeNotEqualTo(Integer value) {
            addCriterion("int_dias_vac_corresponde <>", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeGreaterThan(Integer value) {
            addCriterion("int_dias_vac_corresponde >", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_dias_vac_corresponde >=", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeLessThan(Integer value) {
            addCriterion("int_dias_vac_corresponde <", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeLessThanOrEqualTo(Integer value) {
            addCriterion("int_dias_vac_corresponde <=", value, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeIn(List<Integer> values) {
            addCriterion("int_dias_vac_corresponde in", values, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeNotIn(List<Integer> values) {
            addCriterion("int_dias_vac_corresponde not in", values, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeBetween(Integer value1, Integer value2) {
            addCriterion("int_dias_vac_corresponde between", value1, value2, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_correspondeNotBetween(Integer value1, Integer value2) {
            addCriterion("int_dias_vac_corresponde not between", value1, value2, "int_dias_vac_corresponde");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceIsNull() {
            addCriterion("int_dias_vac_goce is null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceIsNotNull() {
            addCriterion("int_dias_vac_goce is not null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceEqualTo(Integer value) {
            addCriterion("int_dias_vac_goce =", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceNotEqualTo(Integer value) {
            addCriterion("int_dias_vac_goce <>", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceGreaterThan(Integer value) {
            addCriterion("int_dias_vac_goce >", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_dias_vac_goce >=", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceLessThan(Integer value) {
            addCriterion("int_dias_vac_goce <", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceLessThanOrEqualTo(Integer value) {
            addCriterion("int_dias_vac_goce <=", value, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceIn(List<Integer> values) {
            addCriterion("int_dias_vac_goce in", values, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceNotIn(List<Integer> values) {
            addCriterion("int_dias_vac_goce not in", values, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceBetween(Integer value1, Integer value2) {
            addCriterion("int_dias_vac_goce between", value1, value2, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_goceNotBetween(Integer value1, Integer value2) {
            addCriterion("int_dias_vac_goce not between", value1, value2, "int_dias_vac_goce");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasIsNull() {
            addCriterion("int_dias_vac_truncas is null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasIsNotNull() {
            addCriterion("int_dias_vac_truncas is not null");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasEqualTo(BigDecimal value) {
            addCriterion("int_dias_vac_truncas =", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasNotEqualTo(BigDecimal value) {
            addCriterion("int_dias_vac_truncas <>", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasGreaterThan(BigDecimal value) {
            addCriterion("int_dias_vac_truncas >", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("int_dias_vac_truncas >=", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasLessThan(BigDecimal value) {
            addCriterion("int_dias_vac_truncas <", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasLessThanOrEqualTo(BigDecimal value) {
            addCriterion("int_dias_vac_truncas <=", value, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasIn(List<BigDecimal> values) {
            addCriterion("int_dias_vac_truncas in", values, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasNotIn(List<BigDecimal> values) {
            addCriterion("int_dias_vac_truncas not in", values, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("int_dias_vac_truncas between", value1, value2, "int_dias_vac_truncas");
            return (Criteria) this;
        }

        public Criteria andInt_dias_vac_truncasNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("int_dias_vac_truncas not between", value1, value2, "int_dias_vac_truncas");
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