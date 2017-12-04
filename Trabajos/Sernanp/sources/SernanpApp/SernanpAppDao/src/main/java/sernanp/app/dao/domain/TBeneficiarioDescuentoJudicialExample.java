package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBeneficiarioDescuentoJudicialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBeneficiarioDescuentoJudicialExample() {
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

        public Criteria andSrl_id_beneficiario_descuento_judicialIsNull() {
            addCriterion("srl_id_beneficiario_descuento_judicial is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialIsNotNull() {
            addCriterion("srl_id_beneficiario_descuento_judicial is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial =", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <>", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialGreaterThan(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial >", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial >=", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialLessThan(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_beneficiario_descuento_judicial <=", value, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialIn(List<Integer> values) {
            addCriterion("srl_id_beneficiario_descuento_judicial in", values, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotIn(List<Integer> values) {
            addCriterion("srl_id_beneficiario_descuento_judicial not in", values, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_beneficiario_descuento_judicial between", value1, value2, "srl_id_beneficiario_descuento_judicial");
            return (Criteria) this;
        }

        public Criteria andSrl_id_beneficiario_descuento_judicialNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_beneficiario_descuento_judicial not between", value1, value2, "srl_id_beneficiario_descuento_judicial");
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

        public Criteria andVar_descripcion_descuentoIsNull() {
            addCriterion("var_descripcion_descuento is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoIsNotNull() {
            addCriterion("var_descripcion_descuento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoEqualTo(String value) {
            addCriterion("var_descripcion_descuento =", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoNotEqualTo(String value) {
            addCriterion("var_descripcion_descuento <>", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoGreaterThan(String value) {
            addCriterion("var_descripcion_descuento >", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_descuento >=", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoLessThan(String value) {
            addCriterion("var_descripcion_descuento <", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_descuento <=", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoLike(String value) {
            addCriterion("var_descripcion_descuento like", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoNotLike(String value) {
            addCriterion("var_descripcion_descuento not like", value, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoIn(List<String> values) {
            addCriterion("var_descripcion_descuento in", values, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoNotIn(List<String> values) {
            addCriterion("var_descripcion_descuento not in", values, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoBetween(String value1, String value2) {
            addCriterion("var_descripcion_descuento between", value1, value2, "var_descripcion_descuento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_descuentoNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_descuento not between", value1, value2, "var_descripcion_descuento");
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

        public Criteria andVar_numero_docIsNull() {
            addCriterion("var_numero_doc is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docIsNotNull() {
            addCriterion("var_numero_doc is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docEqualTo(String value) {
            addCriterion("var_numero_doc =", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docNotEqualTo(String value) {
            addCriterion("var_numero_doc <>", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docGreaterThan(String value) {
            addCriterion("var_numero_doc >", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_doc >=", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docLessThan(String value) {
            addCriterion("var_numero_doc <", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docLessThanOrEqualTo(String value) {
            addCriterion("var_numero_doc <=", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docLike(String value) {
            addCriterion("var_numero_doc like", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docNotLike(String value) {
            addCriterion("var_numero_doc not like", value, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docIn(List<String> values) {
            addCriterion("var_numero_doc in", values, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docNotIn(List<String> values) {
            addCriterion("var_numero_doc not in", values, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docBetween(String value1, String value2) {
            addCriterion("var_numero_doc between", value1, value2, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_numero_docNotBetween(String value1, String value2) {
            addCriterion("var_numero_doc not between", value1, value2, "var_numero_doc");
            return (Criteria) this;
        }

        public Criteria andVar_nombresIsNull() {
            addCriterion("var_nombres is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombresIsNotNull() {
            addCriterion("var_nombres is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombresEqualTo(String value) {
            addCriterion("var_nombres =", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresNotEqualTo(String value) {
            addCriterion("var_nombres <>", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresGreaterThan(String value) {
            addCriterion("var_nombres >", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombres >=", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresLessThan(String value) {
            addCriterion("var_nombres <", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresLessThanOrEqualTo(String value) {
            addCriterion("var_nombres <=", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresLike(String value) {
            addCriterion("var_nombres like", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresNotLike(String value) {
            addCriterion("var_nombres not like", value, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresIn(List<String> values) {
            addCriterion("var_nombres in", values, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresNotIn(List<String> values) {
            addCriterion("var_nombres not in", values, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresBetween(String value1, String value2) {
            addCriterion("var_nombres between", value1, value2, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_nombresNotBetween(String value1, String value2) {
            addCriterion("var_nombres not between", value1, value2, "var_nombres");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterIsNull() {
            addCriterion("var_ape_pater is null");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterIsNotNull() {
            addCriterion("var_ape_pater is not null");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterEqualTo(String value) {
            addCriterion("var_ape_pater =", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterNotEqualTo(String value) {
            addCriterion("var_ape_pater <>", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterGreaterThan(String value) {
            addCriterion("var_ape_pater >", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterGreaterThanOrEqualTo(String value) {
            addCriterion("var_ape_pater >=", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterLessThan(String value) {
            addCriterion("var_ape_pater <", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterLessThanOrEqualTo(String value) {
            addCriterion("var_ape_pater <=", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterLike(String value) {
            addCriterion("var_ape_pater like", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterNotLike(String value) {
            addCriterion("var_ape_pater not like", value, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterIn(List<String> values) {
            addCriterion("var_ape_pater in", values, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterNotIn(List<String> values) {
            addCriterion("var_ape_pater not in", values, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterBetween(String value1, String value2) {
            addCriterion("var_ape_pater between", value1, value2, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_paterNotBetween(String value1, String value2) {
            addCriterion("var_ape_pater not between", value1, value2, "var_ape_pater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materIsNull() {
            addCriterion("var_ape_mater is null");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materIsNotNull() {
            addCriterion("var_ape_mater is not null");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materEqualTo(String value) {
            addCriterion("var_ape_mater =", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materNotEqualTo(String value) {
            addCriterion("var_ape_mater <>", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materGreaterThan(String value) {
            addCriterion("var_ape_mater >", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materGreaterThanOrEqualTo(String value) {
            addCriterion("var_ape_mater >=", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materLessThan(String value) {
            addCriterion("var_ape_mater <", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materLessThanOrEqualTo(String value) {
            addCriterion("var_ape_mater <=", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materLike(String value) {
            addCriterion("var_ape_mater like", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materNotLike(String value) {
            addCriterion("var_ape_mater not like", value, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materIn(List<String> values) {
            addCriterion("var_ape_mater in", values, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materNotIn(List<String> values) {
            addCriterion("var_ape_mater not in", values, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materBetween(String value1, String value2) {
            addCriterion("var_ape_mater between", value1, value2, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_ape_materNotBetween(String value1, String value2) {
            addCriterion("var_ape_mater not between", value1, value2, "var_ape_mater");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaIsNull() {
            addCriterion("var_numero_cuenta is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaIsNotNull() {
            addCriterion("var_numero_cuenta is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaEqualTo(String value) {
            addCriterion("var_numero_cuenta =", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaNotEqualTo(String value) {
            addCriterion("var_numero_cuenta <>", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaGreaterThan(String value) {
            addCriterion("var_numero_cuenta >", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta >=", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaLessThan(String value) {
            addCriterion("var_numero_cuenta <", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaLessThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta <=", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaLike(String value) {
            addCriterion("var_numero_cuenta like", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaNotLike(String value) {
            addCriterion("var_numero_cuenta not like", value, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaIn(List<String> values) {
            addCriterion("var_numero_cuenta in", values, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaNotIn(List<String> values) {
            addCriterion("var_numero_cuenta not in", values, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta between", value1, value2, "var_numero_cuenta");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuentaNotBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta not between", value1, value2, "var_numero_cuenta");
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