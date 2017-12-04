package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TConvAreaOrgFactorEvalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConvAreaOrgFactorEvalExample() {
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

        public Criteria andSrl_conv_area_org_factor_evalIsNull() {
            addCriterion("srl_conv_area_org_factor_eval is null");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalIsNotNull() {
            addCriterion("srl_conv_area_org_factor_eval is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalEqualTo(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval =", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalNotEqualTo(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval <>", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalGreaterThan(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval >", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval >=", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalLessThan(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval <", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_conv_area_org_factor_eval <=", value, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalIn(List<Integer> values) {
            addCriterion("srl_conv_area_org_factor_eval in", values, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalNotIn(List<Integer> values) {
            addCriterion("srl_conv_area_org_factor_eval not in", values, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalBetween(Integer value1, Integer value2) {
            addCriterion("srl_conv_area_org_factor_eval between", value1, value2, "srl_conv_area_org_factor_eval");
            return (Criteria) this;
        }

        public Criteria andSrl_conv_area_org_factor_evalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_conv_area_org_factor_eval not between", value1, value2, "srl_conv_area_org_factor_eval");
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

        public Criteria andSrl_id_factor_evaluacionIsNull() {
            addCriterion("srl_id_factor_evaluacion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionIsNotNull() {
            addCriterion("srl_id_factor_evaluacion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionEqualTo(Integer value) {
            addCriterion("srl_id_factor_evaluacion =", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionNotEqualTo(Integer value) {
            addCriterion("srl_id_factor_evaluacion <>", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionGreaterThan(Integer value) {
            addCriterion("srl_id_factor_evaluacion >", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_factor_evaluacion >=", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionLessThan(Integer value) {
            addCriterion("srl_id_factor_evaluacion <", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_factor_evaluacion <=", value, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionIn(List<Integer> values) {
            addCriterion("srl_id_factor_evaluacion in", values, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionNotIn(List<Integer> values) {
            addCriterion("srl_id_factor_evaluacion not in", values, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_factor_evaluacion between", value1, value2, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_factor_evaluacionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_factor_evaluacion not between", value1, value2, "srl_id_factor_evaluacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaIsNull() {
            addCriterion("int_id_estado_asistencia is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaIsNotNull() {
            addCriterion("int_id_estado_asistencia is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaEqualTo(Integer value) {
            addCriterion("int_id_estado_asistencia =", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaNotEqualTo(Integer value) {
            addCriterion("int_id_estado_asistencia <>", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaGreaterThan(Integer value) {
            addCriterion("int_id_estado_asistencia >", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_asistencia >=", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaLessThan(Integer value) {
            addCriterion("int_id_estado_asistencia <", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_asistencia <=", value, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaIn(List<Integer> values) {
            addCriterion("int_id_estado_asistencia in", values, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaNotIn(List<Integer> values) {
            addCriterion("int_id_estado_asistencia not in", values, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_asistencia between", value1, value2, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_asistenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_asistencia not between", value1, value2, "int_id_estado_asistencia");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoIsNull() {
            addCriterion("dec_puntaje_obtenido is null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoIsNotNull() {
            addCriterion("dec_puntaje_obtenido is not null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido =", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoNotEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido <>", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoGreaterThan(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido >", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido >=", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoLessThan(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido <", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_obtenido <=", value, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_obtenido in", values, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoNotIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_obtenido not in", values, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_obtenido between", value1, value2, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_obtenidoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_obtenido not between", value1, value2, "dec_puntaje_obtenido");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoIsNull() {
            addCriterion("dec_puntaje_calculado is null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoIsNotNull() {
            addCriterion("dec_puntaje_calculado is not null");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_calculado =", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoNotEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_calculado <>", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoGreaterThan(BigDecimal value) {
            addCriterion("dec_puntaje_calculado >", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_calculado >=", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoLessThan(BigDecimal value) {
            addCriterion("dec_puntaje_calculado <", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dec_puntaje_calculado <=", value, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_calculado in", values, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoNotIn(List<BigDecimal> values) {
            addCriterion("dec_puntaje_calculado not in", values, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_calculado between", value1, value2, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andDec_puntaje_calculadoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dec_puntaje_calculado not between", value1, value2, "dec_puntaje_calculado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionIsNull() {
            addCriterion("int_id_estado_clasificacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionIsNotNull() {
            addCriterion("int_id_estado_clasificacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionEqualTo(Integer value) {
            addCriterion("int_id_estado_clasificacion =", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionNotEqualTo(Integer value) {
            addCriterion("int_id_estado_clasificacion <>", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionGreaterThan(Integer value) {
            addCriterion("int_id_estado_clasificacion >", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_clasificacion >=", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionLessThan(Integer value) {
            addCriterion("int_id_estado_clasificacion <", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado_clasificacion <=", value, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionIn(List<Integer> values) {
            addCriterion("int_id_estado_clasificacion in", values, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionNotIn(List<Integer> values) {
            addCriterion("int_id_estado_clasificacion not in", values, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_clasificacion between", value1, value2, "int_id_estado_clasificacion");
            return (Criteria) this;
        }

        public Criteria andInt_id_estado_clasificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado_clasificacion not between", value1, value2, "int_id_estado_clasificacion");
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