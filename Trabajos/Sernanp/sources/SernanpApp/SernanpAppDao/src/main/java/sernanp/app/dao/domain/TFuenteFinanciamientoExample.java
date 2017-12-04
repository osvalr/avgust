package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TFuenteFinanciamientoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFuenteFinanciamientoExample() {
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

        public Criteria andInt_cod_fuente_financiamientoIsNull() {
            addCriterion("int_cod_fuente_financiamiento is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoIsNotNull() {
            addCriterion("int_cod_fuente_financiamiento is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoEqualTo(Integer value) {
            addCriterion("int_cod_fuente_financiamiento =", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoNotEqualTo(Integer value) {
            addCriterion("int_cod_fuente_financiamiento <>", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoGreaterThan(Integer value) {
            addCriterion("int_cod_fuente_financiamiento >", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_fuente_financiamiento >=", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoLessThan(Integer value) {
            addCriterion("int_cod_fuente_financiamiento <", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_fuente_financiamiento <=", value, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoIn(List<Integer> values) {
            addCriterion("int_cod_fuente_financiamiento in", values, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoNotIn(List<Integer> values) {
            addCriterion("int_cod_fuente_financiamiento not in", values, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_fuente_financiamiento between", value1, value2, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_cod_fuente_financiamientoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_fuente_financiamiento not between", value1, value2, "int_cod_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoIsNull() {
            addCriterion("var_descripcion_fuente_financiamiento is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoIsNotNull() {
            addCriterion("var_descripcion_fuente_financiamiento is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoEqualTo(String value) {
            addCriterion("var_descripcion_fuente_financiamiento =", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoNotEqualTo(String value) {
            addCriterion("var_descripcion_fuente_financiamiento <>", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoGreaterThan(String value) {
            addCriterion("var_descripcion_fuente_financiamiento >", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_fuente_financiamiento >=", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoLessThan(String value) {
            addCriterion("var_descripcion_fuente_financiamiento <", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_fuente_financiamiento <=", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoLike(String value) {
            addCriterion("var_descripcion_fuente_financiamiento like", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoNotLike(String value) {
            addCriterion("var_descripcion_fuente_financiamiento not like", value, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoIn(List<String> values) {
            addCriterion("var_descripcion_fuente_financiamiento in", values, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoNotIn(List<String> values) {
            addCriterion("var_descripcion_fuente_financiamiento not in", values, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoBetween(String value1, String value2) {
            addCriterion("var_descripcion_fuente_financiamiento between", value1, value2, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_fuente_financiamientoNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_fuente_financiamiento not between", value1, value2, "var_descripcion_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_siglaIsNull() {
            addCriterion("var_sigla is null");
            return (Criteria) this;
        }

        public Criteria andVar_siglaIsNotNull() {
            addCriterion("var_sigla is not null");
            return (Criteria) this;
        }

        public Criteria andVar_siglaEqualTo(String value) {
            addCriterion("var_sigla =", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaNotEqualTo(String value) {
            addCriterion("var_sigla <>", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaGreaterThan(String value) {
            addCriterion("var_sigla >", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaGreaterThanOrEqualTo(String value) {
            addCriterion("var_sigla >=", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaLessThan(String value) {
            addCriterion("var_sigla <", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaLessThanOrEqualTo(String value) {
            addCriterion("var_sigla <=", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaLike(String value) {
            addCriterion("var_sigla like", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaNotLike(String value) {
            addCriterion("var_sigla not like", value, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaIn(List<String> values) {
            addCriterion("var_sigla in", values, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaNotIn(List<String> values) {
            addCriterion("var_sigla not in", values, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaBetween(String value1, String value2) {
            addCriterion("var_sigla between", value1, value2, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andVar_siglaNotBetween(String value1, String value2) {
            addCriterion("var_sigla not between", value1, value2, "var_sigla");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoIsNull() {
            addCriterion("int_id_tipo_fuente_financiamiento is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoIsNotNull() {
            addCriterion("int_id_tipo_fuente_financiamiento is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoEqualTo(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento =", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento <>", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoGreaterThan(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento >", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento >=", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoLessThan(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento <", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_fuente_financiamiento <=", value, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoIn(List<Integer> values) {
            addCriterion("int_id_tipo_fuente_financiamiento in", values, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_fuente_financiamiento not in", values, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_fuente_financiamiento between", value1, value2, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_fuente_financiamientoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_fuente_financiamiento not between", value1, value2, "int_id_tipo_fuente_financiamiento");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorIsNull() {
            addCriterion("var_coordinador is null");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorIsNotNull() {
            addCriterion("var_coordinador is not null");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorEqualTo(String value) {
            addCriterion("var_coordinador =", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorNotEqualTo(String value) {
            addCriterion("var_coordinador <>", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorGreaterThan(String value) {
            addCriterion("var_coordinador >", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorGreaterThanOrEqualTo(String value) {
            addCriterion("var_coordinador >=", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorLessThan(String value) {
            addCriterion("var_coordinador <", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorLessThanOrEqualTo(String value) {
            addCriterion("var_coordinador <=", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorLike(String value) {
            addCriterion("var_coordinador like", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorNotLike(String value) {
            addCriterion("var_coordinador not like", value, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorIn(List<String> values) {
            addCriterion("var_coordinador in", values, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorNotIn(List<String> values) {
            addCriterion("var_coordinador not in", values, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorBetween(String value1, String value2) {
            addCriterion("var_coordinador between", value1, value2, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_coordinadorNotBetween(String value1, String value2) {
            addCriterion("var_coordinador not between", value1, value2, "var_coordinador");
            return (Criteria) this;
        }

        public Criteria andVar_emailIsNull() {
            addCriterion("var_email is null");
            return (Criteria) this;
        }

        public Criteria andVar_emailIsNotNull() {
            addCriterion("var_email is not null");
            return (Criteria) this;
        }

        public Criteria andVar_emailEqualTo(String value) {
            addCriterion("var_email =", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailNotEqualTo(String value) {
            addCriterion("var_email <>", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailGreaterThan(String value) {
            addCriterion("var_email >", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailGreaterThanOrEqualTo(String value) {
            addCriterion("var_email >=", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailLessThan(String value) {
            addCriterion("var_email <", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailLessThanOrEqualTo(String value) {
            addCriterion("var_email <=", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailLike(String value) {
            addCriterion("var_email like", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailNotLike(String value) {
            addCriterion("var_email not like", value, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailIn(List<String> values) {
            addCriterion("var_email in", values, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailNotIn(List<String> values) {
            addCriterion("var_email not in", values, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailBetween(String value1, String value2) {
            addCriterion("var_email between", value1, value2, "var_email");
            return (Criteria) this;
        }

        public Criteria andVar_emailNotBetween(String value1, String value2) {
            addCriterion("var_email not between", value1, value2, "var_email");
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

        public Criteria andInt_id_auditoriaIsNull() {
            addCriterion("int_id_auditoria is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaIsNotNull() {
            addCriterion("int_id_auditoria is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaEqualTo(Integer value) {
            addCriterion("int_id_auditoria =", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaNotEqualTo(Integer value) {
            addCriterion("int_id_auditoria <>", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaGreaterThan(Integer value) {
            addCriterion("int_id_auditoria >", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_auditoria >=", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaLessThan(Integer value) {
            addCriterion("int_id_auditoria <", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_auditoria <=", value, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaIn(List<Integer> values) {
            addCriterion("int_id_auditoria in", values, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaNotIn(List<Integer> values) {
            addCriterion("int_id_auditoria not in", values, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaBetween(Integer value1, Integer value2) {
            addCriterion("int_id_auditoria between", value1, value2, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andInt_id_auditoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_auditoria not between", value1, value2, "int_id_auditoria");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoIsNull() {
            addCriterion("var_rubro_fte_fto is null");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoIsNotNull() {
            addCriterion("var_rubro_fte_fto is not null");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoEqualTo(String value) {
            addCriterion("var_rubro_fte_fto =", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoNotEqualTo(String value) {
            addCriterion("var_rubro_fte_fto <>", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoGreaterThan(String value) {
            addCriterion("var_rubro_fte_fto >", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoGreaterThanOrEqualTo(String value) {
            addCriterion("var_rubro_fte_fto >=", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoLessThan(String value) {
            addCriterion("var_rubro_fte_fto <", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoLessThanOrEqualTo(String value) {
            addCriterion("var_rubro_fte_fto <=", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoLike(String value) {
            addCriterion("var_rubro_fte_fto like", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoNotLike(String value) {
            addCriterion("var_rubro_fte_fto not like", value, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoIn(List<String> values) {
            addCriterion("var_rubro_fte_fto in", values, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoNotIn(List<String> values) {
            addCriterion("var_rubro_fte_fto not in", values, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoBetween(String value1, String value2) {
            addCriterion("var_rubro_fte_fto between", value1, value2, "var_rubro_fte_fto");
            return (Criteria) this;
        }

        public Criteria andVar_rubro_fte_ftoNotBetween(String value1, String value2) {
            addCriterion("var_rubro_fte_fto not between", value1, value2, "var_rubro_fte_fto");
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