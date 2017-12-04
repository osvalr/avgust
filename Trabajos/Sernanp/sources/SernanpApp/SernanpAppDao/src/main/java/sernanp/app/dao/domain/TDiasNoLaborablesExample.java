package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDiasNoLaborablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDiasNoLaborablesExample() {
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

        public Criteria andSrl_id_no_laborableIsNull() {
            addCriterion("srl_id_no_laborable is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableIsNotNull() {
            addCriterion("srl_id_no_laborable is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableEqualTo(Integer value) {
            addCriterion("srl_id_no_laborable =", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableNotEqualTo(Integer value) {
            addCriterion("srl_id_no_laborable <>", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableGreaterThan(Integer value) {
            addCriterion("srl_id_no_laborable >", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_no_laborable >=", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableLessThan(Integer value) {
            addCriterion("srl_id_no_laborable <", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_no_laborable <=", value, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableIn(List<Integer> values) {
            addCriterion("srl_id_no_laborable in", values, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableNotIn(List<Integer> values) {
            addCriterion("srl_id_no_laborable not in", values, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_no_laborable between", value1, value2, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andSrl_id_no_laborableNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_no_laborable not between", value1, value2, "srl_id_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableIsNull() {
            addCriterion("dte_fec_no_laborable is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableIsNotNull() {
            addCriterion("dte_fec_no_laborable is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable =", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable <>", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable >", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable >=", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable <", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_no_laborable <=", value, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_no_laborable in", values, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_no_laborable not in", values, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_no_laborable between", value1, value2, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andDte_fec_no_laborableNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_no_laborable not between", value1, value2, "dte_fec_no_laborable");
            return (Criteria) this;
        }

        public Criteria andInt_estadoIsNull() {
            addCriterion("int_estado is null");
            return (Criteria) this;
        }

        public Criteria andInt_estadoIsNotNull() {
            addCriterion("int_estado is not null");
            return (Criteria) this;
        }

        public Criteria andInt_estadoEqualTo(Integer value) {
            addCriterion("int_estado =", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotEqualTo(Integer value) {
            addCriterion("int_estado <>", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoGreaterThan(Integer value) {
            addCriterion("int_estado >", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_estado >=", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoLessThan(Integer value) {
            addCriterion("int_estado <", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("int_estado <=", value, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoIn(List<Integer> values) {
            addCriterion("int_estado in", values, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotIn(List<Integer> values) {
            addCriterion("int_estado not in", values, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoBetween(Integer value1, Integer value2) {
            addCriterion("int_estado between", value1, value2, "int_estado");
            return (Criteria) this;
        }

        public Criteria andInt_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_estado not between", value1, value2, "int_estado");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regIsNull() {
            addCriterion("tsp_fec_sys_reg is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regIsNotNull() {
            addCriterion("tsp_fec_sys_reg is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regEqualTo(Date value) {
            addCriterion("tsp_fec_sys_reg =", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regNotEqualTo(Date value) {
            addCriterion("tsp_fec_sys_reg <>", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regGreaterThan(Date value) {
            addCriterion("tsp_fec_sys_reg >", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_reg >=", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regLessThan(Date value) {
            addCriterion("tsp_fec_sys_reg <", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_reg <=", value, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regIn(List<Date> values) {
            addCriterion("tsp_fec_sys_reg in", values, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regNotIn(List<Date> values) {
            addCriterion("tsp_fec_sys_reg not in", values, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_reg between", value1, value2, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_regNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_reg not between", value1, value2, "tsp_fec_sys_reg");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaIsNull() {
            addCriterion("int_id_usu_crea is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaIsNotNull() {
            addCriterion("int_id_usu_crea is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaEqualTo(Integer value) {
            addCriterion("int_id_usu_crea =", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaNotEqualTo(Integer value) {
            addCriterion("int_id_usu_crea <>", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaGreaterThan(Integer value) {
            addCriterion("int_id_usu_crea >", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_crea >=", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaLessThan(Integer value) {
            addCriterion("int_id_usu_crea <", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_crea <=", value, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaIn(List<Integer> values) {
            addCriterion("int_id_usu_crea in", values, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaNotIn(List<Integer> values) {
            addCriterion("int_id_usu_crea not in", values, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_crea between", value1, value2, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_creaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_crea not between", value1, value2, "int_id_usu_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulIsNull() {
            addCriterion("tsp_fec_sys_anul is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulIsNotNull() {
            addCriterion("tsp_fec_sys_anul is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulEqualTo(Date value) {
            addCriterion("tsp_fec_sys_anul =", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulNotEqualTo(Date value) {
            addCriterion("tsp_fec_sys_anul <>", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulGreaterThan(Date value) {
            addCriterion("tsp_fec_sys_anul >", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_anul >=", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulLessThan(Date value) {
            addCriterion("tsp_fec_sys_anul <", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_sys_anul <=", value, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulIn(List<Date> values) {
            addCriterion("tsp_fec_sys_anul in", values, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulNotIn(List<Date> values) {
            addCriterion("tsp_fec_sys_anul not in", values, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_anul between", value1, value2, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_sys_anulNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_sys_anul not between", value1, value2, "tsp_fec_sys_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulIsNull() {
            addCriterion("int_id_usu_anul is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulIsNotNull() {
            addCriterion("int_id_usu_anul is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulEqualTo(Integer value) {
            addCriterion("int_id_usu_anul =", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulNotEqualTo(Integer value) {
            addCriterion("int_id_usu_anul <>", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulGreaterThan(Integer value) {
            addCriterion("int_id_usu_anul >", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_anul >=", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulLessThan(Integer value) {
            addCriterion("int_id_usu_anul <", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_anul <=", value, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulIn(List<Integer> values) {
            addCriterion("int_id_usu_anul in", values, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulNotIn(List<Integer> values) {
            addCriterion("int_id_usu_anul not in", values, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_anul between", value1, value2, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_anulNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_anul not between", value1, value2, "int_id_usu_anul");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionIsNull() {
            addCriterion("var_dia_no_lab_descripcion is null");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionIsNotNull() {
            addCriterion("var_dia_no_lab_descripcion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionEqualTo(String value) {
            addCriterion("var_dia_no_lab_descripcion =", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionNotEqualTo(String value) {
            addCriterion("var_dia_no_lab_descripcion <>", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionGreaterThan(String value) {
            addCriterion("var_dia_no_lab_descripcion >", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionGreaterThanOrEqualTo(String value) {
            addCriterion("var_dia_no_lab_descripcion >=", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionLessThan(String value) {
            addCriterion("var_dia_no_lab_descripcion <", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionLessThanOrEqualTo(String value) {
            addCriterion("var_dia_no_lab_descripcion <=", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionLike(String value) {
            addCriterion("var_dia_no_lab_descripcion like", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionNotLike(String value) {
            addCriterion("var_dia_no_lab_descripcion not like", value, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionIn(List<String> values) {
            addCriterion("var_dia_no_lab_descripcion in", values, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionNotIn(List<String> values) {
            addCriterion("var_dia_no_lab_descripcion not in", values, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionBetween(String value1, String value2) {
            addCriterion("var_dia_no_lab_descripcion between", value1, value2, "var_dia_no_lab_descripcion");
            return (Criteria) this;
        }

        public Criteria andVar_dia_no_lab_descripcionNotBetween(String value1, String value2) {
            addCriterion("var_dia_no_lab_descripcion not between", value1, value2, "var_dia_no_lab_descripcion");
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

        public Criteria andInt_mesIsNull() {
            addCriterion("int_mes is null");
            return (Criteria) this;
        }

        public Criteria andInt_mesIsNotNull() {
            addCriterion("int_mes is not null");
            return (Criteria) this;
        }

        public Criteria andInt_mesEqualTo(Integer value) {
            addCriterion("int_mes =", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotEqualTo(Integer value) {
            addCriterion("int_mes <>", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesGreaterThan(Integer value) {
            addCriterion("int_mes >", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_mes >=", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesLessThan(Integer value) {
            addCriterion("int_mes <", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesLessThanOrEqualTo(Integer value) {
            addCriterion("int_mes <=", value, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesIn(List<Integer> values) {
            addCriterion("int_mes in", values, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotIn(List<Integer> values) {
            addCriterion("int_mes not in", values, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesBetween(Integer value1, Integer value2) {
            addCriterion("int_mes between", value1, value2, "int_mes");
            return (Criteria) this;
        }

        public Criteria andInt_mesNotBetween(Integer value1, Integer value2) {
            addCriterion("int_mes not between", value1, value2, "int_mes");
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