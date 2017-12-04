package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPersonalContratoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalContratoExample() {
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

        public Criteria andVar_num_contratoIsNull() {
            addCriterion("var_num_contrato is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoIsNotNull() {
            addCriterion("var_num_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoEqualTo(String value) {
            addCriterion("var_num_contrato =", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoNotEqualTo(String value) {
            addCriterion("var_num_contrato <>", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoGreaterThan(String value) {
            addCriterion("var_num_contrato >", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_contrato >=", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoLessThan(String value) {
            addCriterion("var_num_contrato <", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoLessThanOrEqualTo(String value) {
            addCriterion("var_num_contrato <=", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoLike(String value) {
            addCriterion("var_num_contrato like", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoNotLike(String value) {
            addCriterion("var_num_contrato not like", value, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoIn(List<String> values) {
            addCriterion("var_num_contrato in", values, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoNotIn(List<String> values) {
            addCriterion("var_num_contrato not in", values, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoBetween(String value1, String value2) {
            addCriterion("var_num_contrato between", value1, value2, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andVar_num_contratoNotBetween(String value1, String value2) {
            addCriterion("var_num_contrato not between", value1, value2, "var_num_contrato");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoIsNull() {
            addCriterion("num_sueldo is null");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoIsNotNull() {
            addCriterion("num_sueldo is not null");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoEqualTo(BigDecimal value) {
            addCriterion("num_sueldo =", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoNotEqualTo(BigDecimal value) {
            addCriterion("num_sueldo <>", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoGreaterThan(BigDecimal value) {
            addCriterion("num_sueldo >", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("num_sueldo >=", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoLessThan(BigDecimal value) {
            addCriterion("num_sueldo <", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("num_sueldo <=", value, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoIn(List<BigDecimal> values) {
            addCriterion("num_sueldo in", values, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoNotIn(List<BigDecimal> values) {
            addCriterion("num_sueldo not in", values, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_sueldo between", value1, value2, "num_sueldo");
            return (Criteria) this;
        }

        public Criteria andNum_sueldoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("num_sueldo not between", value1, value2, "num_sueldo");
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

        public Criteria andDte_fec_inicioIsNull() {
            addCriterion("dte_fec_inicio is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioIsNotNull() {
            addCriterion("dte_fec_inicio is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio =", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio <>", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio >", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio >=", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio <", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_inicio <=", value, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_inicio in", values, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_inicio not in", values, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_inicio between", value1, value2, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_inicioNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_inicio not between", value1, value2, "dte_fec_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoIsNull() {
            addCriterion("dte_fec_termino is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoIsNotNull() {
            addCriterion("dte_fec_termino is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_termino =", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_termino <>", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_termino >", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_termino >=", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_termino <", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_termino <=", value, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_termino in", values, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_termino not in", values, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_termino between", value1, value2, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_terminoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_termino not between", value1, value2, "dte_fec_termino");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripIsNull() {
            addCriterion("dte_fec_suscrip is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripIsNotNull() {
            addCriterion("dte_fec_suscrip is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip =", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip <>", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip >", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip >=", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip <", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_suscrip <=", value, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_suscrip in", values, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_suscrip not in", values, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_suscrip between", value1, value2, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andDte_fec_suscripNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_suscrip not between", value1, value2, "dte_fec_suscrip");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labIsNull() {
            addCriterion("int_id_reg_lab is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labIsNotNull() {
            addCriterion("int_id_reg_lab is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labEqualTo(Integer value) {
            addCriterion("int_id_reg_lab =", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labNotEqualTo(Integer value) {
            addCriterion("int_id_reg_lab <>", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labGreaterThan(Integer value) {
            addCriterion("int_id_reg_lab >", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_reg_lab >=", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labLessThan(Integer value) {
            addCriterion("int_id_reg_lab <", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_reg_lab <=", value, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labIn(List<Integer> values) {
            addCriterion("int_id_reg_lab in", values, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labNotIn(List<Integer> values) {
            addCriterion("int_id_reg_lab not in", values, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labBetween(Integer value1, Integer value2) {
            addCriterion("int_id_reg_lab between", value1, value2, "int_id_reg_lab");
            return (Criteria) this;
        }

        public Criteria andInt_id_reg_labNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_reg_lab not between", value1, value2, "int_id_reg_lab");
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

        public Criteria andDte_fec_ceseIsNull() {
            addCriterion("dte_fec_cese is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseIsNotNull() {
            addCriterion("dte_fec_cese is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_cese =", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_cese <>", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_cese >", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_cese >=", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_cese <", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_cese <=", value, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_cese in", values, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_cese not in", values, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_cese between", value1, value2, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ceseNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_cese not between", value1, value2, "dte_fec_cese");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipIsNull() {
            addCriterion("int_id_tab_tip is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipIsNotNull() {
            addCriterion("int_id_tab_tip is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipEqualTo(Integer value) {
            addCriterion("int_id_tab_tip =", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipNotEqualTo(Integer value) {
            addCriterion("int_id_tab_tip <>", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipGreaterThan(Integer value) {
            addCriterion("int_id_tab_tip >", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tab_tip >=", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipLessThan(Integer value) {
            addCriterion("int_id_tab_tip <", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tab_tip <=", value, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipIn(List<Integer> values) {
            addCriterion("int_id_tab_tip in", values, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipNotIn(List<Integer> values) {
            addCriterion("int_id_tab_tip not in", values, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tab_tip between", value1, value2, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_id_tab_tipNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tab_tip not between", value1, value2, "int_id_tab_tip");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoIsNull() {
            addCriterion("int_est_contrato is null");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoIsNotNull() {
            addCriterion("int_est_contrato is not null");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoEqualTo(Integer value) {
            addCriterion("int_est_contrato =", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoNotEqualTo(Integer value) {
            addCriterion("int_est_contrato <>", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoGreaterThan(Integer value) {
            addCriterion("int_est_contrato >", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_est_contrato >=", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoLessThan(Integer value) {
            addCriterion("int_est_contrato <", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoLessThanOrEqualTo(Integer value) {
            addCriterion("int_est_contrato <=", value, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoIn(List<Integer> values) {
            addCriterion("int_est_contrato in", values, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoNotIn(List<Integer> values) {
            addCriterion("int_est_contrato not in", values, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoBetween(Integer value1, Integer value2) {
            addCriterion("int_est_contrato between", value1, value2, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andInt_est_contratoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_est_contrato not between", value1, value2, "int_est_contrato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoIsNull() {
            addCriterion("srl_id_cargo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoIsNotNull() {
            addCriterion("srl_id_cargo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoEqualTo(Integer value) {
            addCriterion("srl_id_cargo =", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotEqualTo(Integer value) {
            addCriterion("srl_id_cargo <>", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoGreaterThan(Integer value) {
            addCriterion("srl_id_cargo >", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_cargo >=", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoLessThan(Integer value) {
            addCriterion("srl_id_cargo <", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_cargo <=", value, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoIn(List<Integer> values) {
            addCriterion("srl_id_cargo in", values, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotIn(List<Integer> values) {
            addCriterion("srl_id_cargo not in", values, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_cargo between", value1, value2, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_cargoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_cargo not between", value1, value2, "srl_id_cargo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaIsNull() {
            addCriterion("srl_id_meta_presupuestaria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaIsNotNull() {
            addCriterion("srl_id_meta_presupuestaria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaEqualTo(Integer value) {
            addCriterion("srl_id_meta_presupuestaria =", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaNotEqualTo(Integer value) {
            addCriterion("srl_id_meta_presupuestaria <>", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaGreaterThan(Integer value) {
            addCriterion("srl_id_meta_presupuestaria >", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_meta_presupuestaria >=", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaLessThan(Integer value) {
            addCriterion("srl_id_meta_presupuestaria <", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_meta_presupuestaria <=", value, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaIn(List<Integer> values) {
            addCriterion("srl_id_meta_presupuestaria in", values, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaNotIn(List<Integer> values) {
            addCriterion("srl_id_meta_presupuestaria not in", values, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_meta_presupuestaria between", value1, value2, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_presupuestariaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_meta_presupuestaria not between", value1, value2, "srl_id_meta_presupuestaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNull() {
            addCriterion("srl_id_regimen_contractual is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIsNotNull() {
            addCriterion("srl_id_regimen_contractual is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual =", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <>", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_contractual >", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual >=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThan(Integer value) {
            addCriterion("srl_id_regimen_contractual <", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_contractual <=", value, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_contractual not in", values, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_contractualNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_contractual not between", value1, value2, "srl_id_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoIsNull() {
            addCriterion("srl_id_fuente_financiamiento is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoIsNotNull() {
            addCriterion("srl_id_fuente_financiamiento is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoEqualTo(Integer value) {
            addCriterion("srl_id_fuente_financiamiento =", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoNotEqualTo(Integer value) {
            addCriterion("srl_id_fuente_financiamiento <>", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoGreaterThan(Integer value) {
            addCriterion("srl_id_fuente_financiamiento >", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_fuente_financiamiento >=", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoLessThan(Integer value) {
            addCriterion("srl_id_fuente_financiamiento <", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_fuente_financiamiento <=", value, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoIn(List<Integer> values) {
            addCriterion("srl_id_fuente_financiamiento in", values, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoNotIn(List<Integer> values) {
            addCriterion("srl_id_fuente_financiamiento not in", values, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_fuente_financiamiento between", value1, value2, "srl_id_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_fuente_financiamientoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_fuente_financiamiento not between", value1, value2, "srl_id_fuente_financiamiento");
            return (Criteria) this;
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

        public Criteria andSrl_id_sede_presIsNull() {
            addCriterion("srl_id_sede_pres is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presIsNotNull() {
            addCriterion("srl_id_sede_pres is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presEqualTo(Integer value) {
            addCriterion("srl_id_sede_pres =", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presNotEqualTo(Integer value) {
            addCriterion("srl_id_sede_pres <>", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presGreaterThan(Integer value) {
            addCriterion("srl_id_sede_pres >", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_sede_pres >=", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presLessThan(Integer value) {
            addCriterion("srl_id_sede_pres <", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_sede_pres <=", value, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presIn(List<Integer> values) {
            addCriterion("srl_id_sede_pres in", values, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presNotIn(List<Integer> values) {
            addCriterion("srl_id_sede_pres not in", values, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_sede_pres between", value1, value2, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_sede_presNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_sede_pres not between", value1, value2, "srl_id_sede_pres");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoIsNull() {
            addCriterion("srl_id_nivel_remunerativo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoIsNotNull() {
            addCriterion("srl_id_nivel_remunerativo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoEqualTo(Integer value) {
            addCriterion("srl_id_nivel_remunerativo =", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoNotEqualTo(Integer value) {
            addCriterion("srl_id_nivel_remunerativo <>", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoGreaterThan(Integer value) {
            addCriterion("srl_id_nivel_remunerativo >", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_remunerativo >=", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoLessThan(Integer value) {
            addCriterion("srl_id_nivel_remunerativo <", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_remunerativo <=", value, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoIn(List<Integer> values) {
            addCriterion("srl_id_nivel_remunerativo in", values, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoNotIn(List<Integer> values) {
            addCriterion("srl_id_nivel_remunerativo not in", values, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_remunerativo between", value1, value2, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_remunerativoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_remunerativo not between", value1, value2, "srl_id_nivel_remunerativo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreIsNull() {
            addCriterion("srl_id_contrato_padre is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreIsNotNull() {
            addCriterion("srl_id_contrato_padre is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreEqualTo(Integer value) {
            addCriterion("srl_id_contrato_padre =", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreNotEqualTo(Integer value) {
            addCriterion("srl_id_contrato_padre <>", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreGreaterThan(Integer value) {
            addCriterion("srl_id_contrato_padre >", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato_padre >=", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreLessThan(Integer value) {
            addCriterion("srl_id_contrato_padre <", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_contrato_padre <=", value, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreIn(List<Integer> values) {
            addCriterion("srl_id_contrato_padre in", values, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreNotIn(List<Integer> values) {
            addCriterion("srl_id_contrato_padre not in", values, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato_padre between", value1, value2, "srl_id_contrato_padre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_contrato_padreNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_contrato_padre not between", value1, value2, "srl_id_contrato_padre");
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

        public Criteria andInt_id_tipo_tratoIsNull() {
            addCriterion("int_id_tipo_trato is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoIsNotNull() {
            addCriterion("int_id_tipo_trato is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoEqualTo(Integer value) {
            addCriterion("int_id_tipo_trato =", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_trato <>", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_trato >", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_trato >=", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoLessThan(Integer value) {
            addCriterion("int_id_tipo_trato <", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_trato <=", value, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoIn(List<Integer> values) {
            addCriterion("int_id_tipo_trato in", values, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_trato not in", values, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_trato between", value1, value2, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_tratoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_trato not between", value1, value2, "int_id_tipo_trato");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operIsNull() {
            addCriterion("srl_id_resp_unid_oper is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operIsNotNull() {
            addCriterion("srl_id_resp_unid_oper is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper =", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper <>", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operGreaterThan(Integer value) {
            addCriterion("srl_id_resp_unid_oper >", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper >=", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operLessThan(Integer value) {
            addCriterion("srl_id_resp_unid_oper <", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_resp_unid_oper <=", value, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operIn(List<Integer> values) {
            addCriterion("srl_id_resp_unid_oper in", values, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotIn(List<Integer> values) {
            addCriterion("srl_id_resp_unid_oper not in", values, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_resp_unid_oper between", value1, value2, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_resp_unid_operNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_resp_unid_oper not between", value1, value2, "srl_id_resp_unid_oper");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoIsNull() {
            addCriterion("srl_id_plantilla_documento_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoIsNotNull() {
            addCriterion("srl_id_plantilla_documento_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo =", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <>", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo >", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo >=", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoLessThan(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <=", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento_archivo in", values, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento_archivo not in", values, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento_archivo between", value1, value2, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento_archivo not between", value1, value2, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionIsNull() {
            addCriterion("var_num_resolucion is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionIsNotNull() {
            addCriterion("var_num_resolucion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionEqualTo(String value) {
            addCriterion("var_num_resolucion =", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionNotEqualTo(String value) {
            addCriterion("var_num_resolucion <>", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionGreaterThan(String value) {
            addCriterion("var_num_resolucion >", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_resolucion >=", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionLessThan(String value) {
            addCriterion("var_num_resolucion <", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionLessThanOrEqualTo(String value) {
            addCriterion("var_num_resolucion <=", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionLike(String value) {
            addCriterion("var_num_resolucion like", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionNotLike(String value) {
            addCriterion("var_num_resolucion not like", value, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionIn(List<String> values) {
            addCriterion("var_num_resolucion in", values, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionNotIn(List<String> values) {
            addCriterion("var_num_resolucion not in", values, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionBetween(String value1, String value2) {
            addCriterion("var_num_resolucion between", value1, value2, "var_num_resolucion");
            return (Criteria) this;
        }

        public Criteria andVar_num_resolucionNotBetween(String value1, String value2) {
            addCriterion("var_num_resolucion not between", value1, value2, "var_num_resolucion");
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

        public Criteria andDes_area_organicaIsNull() {
            addCriterion("des_area_organica is null");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaIsNotNull() {
            addCriterion("des_area_organica is not null");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaEqualTo(String value) {
            addCriterion("des_area_organica =", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaNotEqualTo(String value) {
            addCriterion("des_area_organica <>", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaGreaterThan(String value) {
            addCriterion("des_area_organica >", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaGreaterThanOrEqualTo(String value) {
            addCriterion("des_area_organica >=", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaLessThan(String value) {
            addCriterion("des_area_organica <", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaLessThanOrEqualTo(String value) {
            addCriterion("des_area_organica <=", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaLike(String value) {
            addCriterion("des_area_organica like", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaNotLike(String value) {
            addCriterion("des_area_organica not like", value, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaIn(List<String> values) {
            addCriterion("des_area_organica in", values, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaNotIn(List<String> values) {
            addCriterion("des_area_organica not in", values, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaBetween(String value1, String value2) {
            addCriterion("des_area_organica between", value1, value2, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_area_organicaNotBetween(String value1, String value2) {
            addCriterion("des_area_organica not between", value1, value2, "des_area_organica");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaIsNull() {
            addCriterion("des_unidad_operativa is null");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaIsNotNull() {
            addCriterion("des_unidad_operativa is not null");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaEqualTo(String value) {
            addCriterion("des_unidad_operativa =", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaNotEqualTo(String value) {
            addCriterion("des_unidad_operativa <>", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaGreaterThan(String value) {
            addCriterion("des_unidad_operativa >", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaGreaterThanOrEqualTo(String value) {
            addCriterion("des_unidad_operativa >=", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaLessThan(String value) {
            addCriterion("des_unidad_operativa <", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaLessThanOrEqualTo(String value) {
            addCriterion("des_unidad_operativa <=", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaLike(String value) {
            addCriterion("des_unidad_operativa like", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaNotLike(String value) {
            addCriterion("des_unidad_operativa not like", value, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaIn(List<String> values) {
            addCriterion("des_unidad_operativa in", values, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaNotIn(List<String> values) {
            addCriterion("des_unidad_operativa not in", values, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaBetween(String value1, String value2) {
            addCriterion("des_unidad_operativa between", value1, value2, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andDes_unidad_operativaNotBetween(String value1, String value2) {
            addCriterion("des_unidad_operativa not between", value1, value2, "des_unidad_operativa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaIsNull() {
            addCriterion("srl_id_meta_fuente_generica is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaIsNotNull() {
            addCriterion("srl_id_meta_fuente_generica is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaEqualTo(Integer value) {
            addCriterion("srl_id_meta_fuente_generica =", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaNotEqualTo(Integer value) {
            addCriterion("srl_id_meta_fuente_generica <>", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaGreaterThan(Integer value) {
            addCriterion("srl_id_meta_fuente_generica >", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_meta_fuente_generica >=", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaLessThan(Integer value) {
            addCriterion("srl_id_meta_fuente_generica <", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_meta_fuente_generica <=", value, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaIn(List<Integer> values) {
            addCriterion("srl_id_meta_fuente_generica in", values, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaNotIn(List<Integer> values) {
            addCriterion("srl_id_meta_fuente_generica not in", values, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_meta_fuente_generica between", value1, value2, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andSrl_id_meta_fuente_genericaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_meta_fuente_generica not between", value1, value2, "srl_id_meta_fuente_generica");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualIsNull() {
            addCriterion("var_nivel_regimen_contractual is null");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualIsNotNull() {
            addCriterion("var_nivel_regimen_contractual is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualEqualTo(String value) {
            addCriterion("var_nivel_regimen_contractual =", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualNotEqualTo(String value) {
            addCriterion("var_nivel_regimen_contractual <>", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualGreaterThan(String value) {
            addCriterion("var_nivel_regimen_contractual >", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualGreaterThanOrEqualTo(String value) {
            addCriterion("var_nivel_regimen_contractual >=", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualLessThan(String value) {
            addCriterion("var_nivel_regimen_contractual <", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualLessThanOrEqualTo(String value) {
            addCriterion("var_nivel_regimen_contractual <=", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualLike(String value) {
            addCriterion("var_nivel_regimen_contractual like", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualNotLike(String value) {
            addCriterion("var_nivel_regimen_contractual not like", value, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualIn(List<String> values) {
            addCriterion("var_nivel_regimen_contractual in", values, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualNotIn(List<String> values) {
            addCriterion("var_nivel_regimen_contractual not in", values, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualBetween(String value1, String value2) {
            addCriterion("var_nivel_regimen_contractual between", value1, value2, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andVar_nivel_regimen_contractualNotBetween(String value1, String value2) {
            addCriterion("var_nivel_regimen_contractual not between", value1, value2, "var_nivel_regimen_contractual");
            return (Criteria) this;
        }

        public Criteria andCodmetaIsNull() {
            addCriterion("codmeta is null");
            return (Criteria) this;
        }

        public Criteria andCodmetaIsNotNull() {
            addCriterion("codmeta is not null");
            return (Criteria) this;
        }

        public Criteria andCodmetaEqualTo(String value) {
            addCriterion("codmeta =", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaNotEqualTo(String value) {
            addCriterion("codmeta <>", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaGreaterThan(String value) {
            addCriterion("codmeta >", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaGreaterThanOrEqualTo(String value) {
            addCriterion("codmeta >=", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaLessThan(String value) {
            addCriterion("codmeta <", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaLessThanOrEqualTo(String value) {
            addCriterion("codmeta <=", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaLike(String value) {
            addCriterion("codmeta like", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaNotLike(String value) {
            addCriterion("codmeta not like", value, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaIn(List<String> values) {
            addCriterion("codmeta in", values, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaNotIn(List<String> values) {
            addCriterion("codmeta not in", values, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaBetween(String value1, String value2) {
            addCriterion("codmeta between", value1, value2, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodmetaNotBetween(String value1, String value2) {
            addCriterion("codmeta not between", value1, value2, "codmeta");
            return (Criteria) this;
        }

        public Criteria andCodfuenteIsNull() {
            addCriterion("codfuente is null");
            return (Criteria) this;
        }

        public Criteria andCodfuenteIsNotNull() {
            addCriterion("codfuente is not null");
            return (Criteria) this;
        }

        public Criteria andCodfuenteEqualTo(String value) {
            addCriterion("codfuente =", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteNotEqualTo(String value) {
            addCriterion("codfuente <>", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteGreaterThan(String value) {
            addCriterion("codfuente >", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteGreaterThanOrEqualTo(String value) {
            addCriterion("codfuente >=", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteLessThan(String value) {
            addCriterion("codfuente <", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteLessThanOrEqualTo(String value) {
            addCriterion("codfuente <=", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteLike(String value) {
            addCriterion("codfuente like", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteNotLike(String value) {
            addCriterion("codfuente not like", value, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteIn(List<String> values) {
            addCriterion("codfuente in", values, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteNotIn(List<String> values) {
            addCriterion("codfuente not in", values, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteBetween(String value1, String value2) {
            addCriterion("codfuente between", value1, value2, "codfuente");
            return (Criteria) this;
        }

        public Criteria andCodfuenteNotBetween(String value1, String value2) {
            addCriterion("codfuente not between", value1, value2, "codfuente");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIsNull() {
            addCriterion("var_ubicacion_fisica is null");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIsNotNull() {
            addCriterion("var_ubicacion_fisica is not null");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaEqualTo(String value) {
            addCriterion("var_ubicacion_fisica =", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotEqualTo(String value) {
            addCriterion("var_ubicacion_fisica <>", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaGreaterThan(String value) {
            addCriterion("var_ubicacion_fisica >", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaGreaterThanOrEqualTo(String value) {
            addCriterion("var_ubicacion_fisica >=", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLessThan(String value) {
            addCriterion("var_ubicacion_fisica <", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLessThanOrEqualTo(String value) {
            addCriterion("var_ubicacion_fisica <=", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaLike(String value) {
            addCriterion("var_ubicacion_fisica like", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotLike(String value) {
            addCriterion("var_ubicacion_fisica not like", value, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaIn(List<String> values) {
            addCriterion("var_ubicacion_fisica in", values, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotIn(List<String> values) {
            addCriterion("var_ubicacion_fisica not in", values, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaBetween(String value1, String value2) {
            addCriterion("var_ubicacion_fisica between", value1, value2, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andVar_ubicacion_fisicaNotBetween(String value1, String value2) {
            addCriterion("var_ubicacion_fisica not between", value1, value2, "var_ubicacion_fisica");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoIsNull() {
            addCriterion("int_id_idubigeo is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoIsNotNull() {
            addCriterion("int_id_idubigeo is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoEqualTo(Integer value) {
            addCriterion("int_id_idubigeo =", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoNotEqualTo(Integer value) {
            addCriterion("int_id_idubigeo <>", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoGreaterThan(Integer value) {
            addCriterion("int_id_idubigeo >", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_idubigeo >=", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoLessThan(Integer value) {
            addCriterion("int_id_idubigeo <", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_idubigeo <=", value, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoIn(List<Integer> values) {
            addCriterion("int_id_idubigeo in", values, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoNotIn(List<Integer> values) {
            addCriterion("int_id_idubigeo not in", values, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_idubigeo between", value1, value2, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andInt_id_idubigeoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_idubigeo not between", value1, value2, "int_id_idubigeo");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalIsNull() {
            addCriterion("var_direccion_personal is null");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalIsNotNull() {
            addCriterion("var_direccion_personal is not null");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalEqualTo(String value) {
            addCriterion("var_direccion_personal =", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalNotEqualTo(String value) {
            addCriterion("var_direccion_personal <>", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalGreaterThan(String value) {
            addCriterion("var_direccion_personal >", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalGreaterThanOrEqualTo(String value) {
            addCriterion("var_direccion_personal >=", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalLessThan(String value) {
            addCriterion("var_direccion_personal <", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalLessThanOrEqualTo(String value) {
            addCriterion("var_direccion_personal <=", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalLike(String value) {
            addCriterion("var_direccion_personal like", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalNotLike(String value) {
            addCriterion("var_direccion_personal not like", value, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalIn(List<String> values) {
            addCriterion("var_direccion_personal in", values, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalNotIn(List<String> values) {
            addCriterion("var_direccion_personal not in", values, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalBetween(String value1, String value2) {
            addCriterion("var_direccion_personal between", value1, value2, "var_direccion_personal");
            return (Criteria) this;
        }

        public Criteria andVar_direccion_personalNotBetween(String value1, String value2) {
            addCriterion("var_direccion_personal not between", value1, value2, "var_direccion_personal");
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