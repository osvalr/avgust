package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TConceptoPlanillaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConceptoPlanillaExample() {
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

        public Criteria andSrl_id_concepto_planillaIsNull() {
            addCriterion("srl_id_concepto_planilla is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaIsNotNull() {
            addCriterion("srl_id_concepto_planilla is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla =", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla <>", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaGreaterThan(Integer value) {
            addCriterion("srl_id_concepto_planilla >", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla >=", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaLessThan(Integer value) {
            addCriterion("srl_id_concepto_planilla <", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_concepto_planilla <=", value, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaIn(List<Integer> values) {
            addCriterion("srl_id_concepto_planilla in", values, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotIn(List<Integer> values) {
            addCriterion("srl_id_concepto_planilla not in", values, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_concepto_planilla between", value1, value2, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andSrl_id_concepto_planillaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_concepto_planilla not between", value1, value2, "srl_id_concepto_planilla");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoIsNull() {
            addCriterion("var_cod_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoIsNotNull() {
            addCriterion("var_cod_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoEqualTo(String value) {
            addCriterion("var_cod_concepto =", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoNotEqualTo(String value) {
            addCriterion("var_cod_concepto <>", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoGreaterThan(String value) {
            addCriterion("var_cod_concepto >", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_concepto >=", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoLessThan(String value) {
            addCriterion("var_cod_concepto <", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_cod_concepto <=", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoLike(String value) {
            addCriterion("var_cod_concepto like", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoNotLike(String value) {
            addCriterion("var_cod_concepto not like", value, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoIn(List<String> values) {
            addCriterion("var_cod_concepto in", values, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoNotIn(List<String> values) {
            addCriterion("var_cod_concepto not in", values, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoBetween(String value1, String value2) {
            addCriterion("var_cod_concepto between", value1, value2, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_cod_concepto not between", value1, value2, "var_cod_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoIsNull() {
            addCriterion("var_descrip_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoIsNotNull() {
            addCriterion("var_descrip_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoEqualTo(String value) {
            addCriterion("var_descrip_concepto =", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoNotEqualTo(String value) {
            addCriterion("var_descrip_concepto <>", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoGreaterThan(String value) {
            addCriterion("var_descrip_concepto >", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_concepto >=", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoLessThan(String value) {
            addCriterion("var_descrip_concepto <", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_concepto <=", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoLike(String value) {
            addCriterion("var_descrip_concepto like", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoNotLike(String value) {
            addCriterion("var_descrip_concepto not like", value, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoIn(List<String> values) {
            addCriterion("var_descrip_concepto in", values, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoNotIn(List<String> values) {
            addCriterion("var_descrip_concepto not in", values, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoBetween(String value1, String value2) {
            addCriterion("var_descrip_concepto between", value1, value2, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_descrip_concepto not between", value1, value2, "var_descrip_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoIsNull() {
            addCriterion("var_descrip_corto_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoIsNotNull() {
            addCriterion("var_descrip_corto_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoEqualTo(String value) {
            addCriterion("var_descrip_corto_concepto =", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoNotEqualTo(String value) {
            addCriterion("var_descrip_corto_concepto <>", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoGreaterThan(String value) {
            addCriterion("var_descrip_corto_concepto >", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_corto_concepto >=", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoLessThan(String value) {
            addCriterion("var_descrip_corto_concepto <", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_corto_concepto <=", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoLike(String value) {
            addCriterion("var_descrip_corto_concepto like", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoNotLike(String value) {
            addCriterion("var_descrip_corto_concepto not like", value, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoIn(List<String> values) {
            addCriterion("var_descrip_corto_concepto in", values, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoNotIn(List<String> values) {
            addCriterion("var_descrip_corto_concepto not in", values, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoBetween(String value1, String value2) {
            addCriterion("var_descrip_corto_concepto between", value1, value2, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_corto_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_descrip_corto_concepto not between", value1, value2, "var_descrip_corto_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoIsNull() {
            addCriterion("var_cod_pdt_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoIsNotNull() {
            addCriterion("var_cod_pdt_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoEqualTo(String value) {
            addCriterion("var_cod_pdt_concepto =", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoNotEqualTo(String value) {
            addCriterion("var_cod_pdt_concepto <>", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoGreaterThan(String value) {
            addCriterion("var_cod_pdt_concepto >", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_pdt_concepto >=", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoLessThan(String value) {
            addCriterion("var_cod_pdt_concepto <", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_cod_pdt_concepto <=", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoLike(String value) {
            addCriterion("var_cod_pdt_concepto like", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoNotLike(String value) {
            addCriterion("var_cod_pdt_concepto not like", value, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoIn(List<String> values) {
            addCriterion("var_cod_pdt_concepto in", values, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoNotIn(List<String> values) {
            addCriterion("var_cod_pdt_concepto not in", values, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoBetween(String value1, String value2) {
            addCriterion("var_cod_pdt_concepto between", value1, value2, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_pdt_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_cod_pdt_concepto not between", value1, value2, "var_cod_pdt_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoIsNull() {
            addCriterion("var_cod_mef_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoIsNotNull() {
            addCriterion("var_cod_mef_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoEqualTo(String value) {
            addCriterion("var_cod_mef_concepto =", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoNotEqualTo(String value) {
            addCriterion("var_cod_mef_concepto <>", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoGreaterThan(String value) {
            addCriterion("var_cod_mef_concepto >", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_mef_concepto >=", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoLessThan(String value) {
            addCriterion("var_cod_mef_concepto <", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_cod_mef_concepto <=", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoLike(String value) {
            addCriterion("var_cod_mef_concepto like", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoNotLike(String value) {
            addCriterion("var_cod_mef_concepto not like", value, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoIn(List<String> values) {
            addCriterion("var_cod_mef_concepto in", values, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoNotIn(List<String> values) {
            addCriterion("var_cod_mef_concepto not in", values, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoBetween(String value1, String value2) {
            addCriterion("var_cod_mef_concepto between", value1, value2, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_mef_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_cod_mef_concepto not between", value1, value2, "var_cod_mef_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoIsNull() {
            addCriterion("var_cod_siaf_concepto is null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoIsNotNull() {
            addCriterion("var_cod_siaf_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoEqualTo(String value) {
            addCriterion("var_cod_siaf_concepto =", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoNotEqualTo(String value) {
            addCriterion("var_cod_siaf_concepto <>", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoGreaterThan(String value) {
            addCriterion("var_cod_siaf_concepto >", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoGreaterThanOrEqualTo(String value) {
            addCriterion("var_cod_siaf_concepto >=", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoLessThan(String value) {
            addCriterion("var_cod_siaf_concepto <", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoLessThanOrEqualTo(String value) {
            addCriterion("var_cod_siaf_concepto <=", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoLike(String value) {
            addCriterion("var_cod_siaf_concepto like", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoNotLike(String value) {
            addCriterion("var_cod_siaf_concepto not like", value, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoIn(List<String> values) {
            addCriterion("var_cod_siaf_concepto in", values, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoNotIn(List<String> values) {
            addCriterion("var_cod_siaf_concepto not in", values, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoBetween(String value1, String value2) {
            addCriterion("var_cod_siaf_concepto between", value1, value2, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andVar_cod_siaf_conceptoNotBetween(String value1, String value2) {
            addCriterion("var_cod_siaf_concepto not between", value1, value2, "var_cod_siaf_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoIsNull() {
            addCriterion("int_id_tipo_concepto is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoIsNotNull() {
            addCriterion("int_id_tipo_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoEqualTo(Integer value) {
            addCriterion("int_id_tipo_concepto =", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_concepto <>", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_concepto >", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_concepto >=", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoLessThan(Integer value) {
            addCriterion("int_id_tipo_concepto <", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_concepto <=", value, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoIn(List<Integer> values) {
            addCriterion("int_id_tipo_concepto in", values, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_concepto not in", values, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_concepto between", value1, value2, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_concepto not between", value1, value2, "int_id_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoIsNull() {
            addCriterion("int_id_sub_tipo_concepto is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoIsNotNull() {
            addCriterion("int_id_sub_tipo_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoEqualTo(Integer value) {
            addCriterion("int_id_sub_tipo_concepto =", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoNotEqualTo(Integer value) {
            addCriterion("int_id_sub_tipo_concepto <>", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoGreaterThan(Integer value) {
            addCriterion("int_id_sub_tipo_concepto >", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_sub_tipo_concepto >=", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoLessThan(Integer value) {
            addCriterion("int_id_sub_tipo_concepto <", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_sub_tipo_concepto <=", value, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoIn(List<Integer> values) {
            addCriterion("int_id_sub_tipo_concepto in", values, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoNotIn(List<Integer> values) {
            addCriterion("int_id_sub_tipo_concepto not in", values, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_sub_tipo_concepto between", value1, value2, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_sub_tipo_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_sub_tipo_concepto not between", value1, value2, "int_id_sub_tipo_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoIsNull() {
            addCriterion("int_requiere_frecuencia_concepto is null");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoIsNotNull() {
            addCriterion("int_requiere_frecuencia_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoEqualTo(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto =", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoNotEqualTo(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto <>", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoGreaterThan(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto >", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto >=", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoLessThan(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto <", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("int_requiere_frecuencia_concepto <=", value, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoIn(List<Integer> values) {
            addCriterion("int_requiere_frecuencia_concepto in", values, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoNotIn(List<Integer> values) {
            addCriterion("int_requiere_frecuencia_concepto not in", values, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("int_requiere_frecuencia_concepto between", value1, value2, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_requiere_frecuencia_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_requiere_frecuencia_concepto not between", value1, value2, "int_requiere_frecuencia_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIsNull() {
            addCriterion("dec_monto_concepto is null");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIsNotNull() {
            addCriterion("dec_monto_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto =", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto <>", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoGreaterThan(BigDecimal value) {
            addCriterion("dec_monto_concepto >", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto >=", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoLessThan(BigDecimal value) {
            addCriterion("dec_monto_concepto <", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_monto_concepto <=", value, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoIn(List<BigDecimal> values) {
            addCriterion("dec_monto_concepto in", values, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotIn(List<BigDecimal> values) {
            addCriterion("dec_monto_concepto not in", values, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_monto_concepto between", value1, value2, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andDec_monto_conceptoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_monto_concepto not between", value1, value2, "dec_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIsNull() {
            addCriterion("int_id_tipo_monto_concepto is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIsNotNull() {
            addCriterion("int_id_tipo_monto_concepto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto =", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <>", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_monto_concepto >", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto >=", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoLessThan(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_monto_concepto <=", value, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoIn(List<Integer> values) {
            addCriterion("int_id_tipo_monto_concepto in", values, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_monto_concepto not in", values, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_monto_concepto between", value1, value2, "int_id_tipo_monto_concepto");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_monto_conceptoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_monto_concepto not between", value1, value2, "int_id_tipo_monto_concepto");
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