package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonalExample() {
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

        public Criteria andIdpersonanaturalIsNull() {
            addCriterion("idpersonanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNotNull() {
            addCriterion("idpersonanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalEqualTo(Integer value) {
            addCriterion("idpersonanatural =", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotEqualTo(Integer value) {
            addCriterion("idpersonanatural <>", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThan(Integer value) {
            addCriterion("idpersonanatural >", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural >=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThan(Integer value) {
            addCriterion("idpersonanatural <", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural <=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIn(List<Integer> values) {
            addCriterion("idpersonanatural in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotIn(List<Integer> values) {
            addCriterion("idpersonanatural not in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural not between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andMailpersonalIsNull() {
            addCriterion("mailpersonal is null");
            return (Criteria) this;
        }

        public Criteria andMailpersonalIsNotNull() {
            addCriterion("mailpersonal is not null");
            return (Criteria) this;
        }

        public Criteria andMailpersonalEqualTo(String value) {
            addCriterion("mailpersonal =", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalNotEqualTo(String value) {
            addCriterion("mailpersonal <>", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalGreaterThan(String value) {
            addCriterion("mailpersonal >", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalGreaterThanOrEqualTo(String value) {
            addCriterion("mailpersonal >=", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalLessThan(String value) {
            addCriterion("mailpersonal <", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalLessThanOrEqualTo(String value) {
            addCriterion("mailpersonal <=", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalLike(String value) {
            addCriterion("mailpersonal like", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalNotLike(String value) {
            addCriterion("mailpersonal not like", value, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalIn(List<String> values) {
            addCriterion("mailpersonal in", values, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalNotIn(List<String> values) {
            addCriterion("mailpersonal not in", values, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalBetween(String value1, String value2) {
            addCriterion("mailpersonal between", value1, value2, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andMailpersonalNotBetween(String value1, String value2) {
            addCriterion("mailpersonal not between", value1, value2, "mailpersonal");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosIsNull() {
            addCriterion("int_cant_hijos is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosIsNotNull() {
            addCriterion("int_cant_hijos is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosEqualTo(Integer value) {
            addCriterion("int_cant_hijos =", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosNotEqualTo(Integer value) {
            addCriterion("int_cant_hijos <>", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosGreaterThan(Integer value) {
            addCriterion("int_cant_hijos >", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_hijos >=", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosLessThan(Integer value) {
            addCriterion("int_cant_hijos <", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_hijos <=", value, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosIn(List<Integer> values) {
            addCriterion("int_cant_hijos in", values, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosNotIn(List<Integer> values) {
            addCriterion("int_cant_hijos not in", values, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_hijos between", value1, value2, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_cant_hijosNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_hijos not between", value1, value2, "int_cant_hijos");
            return (Criteria) this;
        }

        public Criteria andInt_id_profIsNull() {
            addCriterion("int_id_prof is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_profIsNotNull() {
            addCriterion("int_id_prof is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_profEqualTo(Integer value) {
            addCriterion("int_id_prof =", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profNotEqualTo(Integer value) {
            addCriterion("int_id_prof <>", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profGreaterThan(Integer value) {
            addCriterion("int_id_prof >", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_prof >=", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profLessThan(Integer value) {
            addCriterion("int_id_prof <", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_prof <=", value, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profIn(List<Integer> values) {
            addCriterion("int_id_prof in", values, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profNotIn(List<Integer> values) {
            addCriterion("int_id_prof not in", values, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profBetween(Integer value1, Integer value2) {
            addCriterion("int_id_prof between", value1, value2, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_profNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_prof not between", value1, value2, "int_id_prof");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduIsNull() {
            addCriterion("int_id_niv_edu is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduIsNotNull() {
            addCriterion("int_id_niv_edu is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduEqualTo(Integer value) {
            addCriterion("int_id_niv_edu =", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduNotEqualTo(Integer value) {
            addCriterion("int_id_niv_edu <>", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduGreaterThan(Integer value) {
            addCriterion("int_id_niv_edu >", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_niv_edu >=", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduLessThan(Integer value) {
            addCriterion("int_id_niv_edu <", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_niv_edu <=", value, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduIn(List<Integer> values) {
            addCriterion("int_id_niv_edu in", values, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduNotIn(List<Integer> values) {
            addCriterion("int_id_niv_edu not in", values, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduBetween(Integer value1, Integer value2) {
            addCriterion("int_id_niv_edu between", value1, value2, "int_id_niv_edu");
            return (Criteria) this;
        }

        public Criteria andInt_id_niv_eduNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_niv_edu not between", value1, value2, "int_id_niv_edu");
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

        public Criteria andSrl_id_profesionIsNull() {
            addCriterion("srl_id_profesion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIsNotNull() {
            addCriterion("srl_id_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionEqualTo(Integer value) {
            addCriterion("srl_id_profesion =", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotEqualTo(Integer value) {
            addCriterion("srl_id_profesion <>", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThan(Integer value) {
            addCriterion("srl_id_profesion >", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion >=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThan(Integer value) {
            addCriterion("srl_id_profesion <", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion <=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIn(List<Integer> values) {
            addCriterion("srl_id_profesion in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotIn(List<Integer> values) {
            addCriterion("srl_id_profesion not in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion between", value1, value2, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion not between", value1, value2, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoIsNull() {
            addCriterion("srl_id_asis_turno is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoIsNotNull() {
            addCriterion("srl_id_asis_turno is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoEqualTo(Integer value) {
            addCriterion("srl_id_asis_turno =", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoNotEqualTo(Integer value) {
            addCriterion("srl_id_asis_turno <>", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoGreaterThan(Integer value) {
            addCriterion("srl_id_asis_turno >", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_asis_turno >=", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoLessThan(Integer value) {
            addCriterion("srl_id_asis_turno <", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_asis_turno <=", value, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoIn(List<Integer> values) {
            addCriterion("srl_id_asis_turno in", values, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoNotIn(List<Integer> values) {
            addCriterion("srl_id_asis_turno not in", values, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_asis_turno between", value1, value2, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andSrl_id_asis_turnoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_asis_turno not between", value1, value2, "srl_id_asis_turno");
            return (Criteria) this;
        }

        public Criteria andInt_flagIsNull() {
            addCriterion("int_flag is null");
            return (Criteria) this;
        }

        public Criteria andInt_flagIsNotNull() {
            addCriterion("int_flag is not null");
            return (Criteria) this;
        }

        public Criteria andInt_flagEqualTo(Integer value) {
            addCriterion("int_flag =", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagNotEqualTo(Integer value) {
            addCriterion("int_flag <>", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagGreaterThan(Integer value) {
            addCriterion("int_flag >", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_flag >=", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagLessThan(Integer value) {
            addCriterion("int_flag <", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagLessThanOrEqualTo(Integer value) {
            addCriterion("int_flag <=", value, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagIn(List<Integer> values) {
            addCriterion("int_flag in", values, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagNotIn(List<Integer> values) {
            addCriterion("int_flag not in", values, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagBetween(Integer value1, Integer value2) {
            addCriterion("int_flag between", value1, value2, "int_flag");
            return (Criteria) this;
        }

        public Criteria andInt_flagNotBetween(Integer value1, Integer value2) {
            addCriterion("int_flag not between", value1, value2, "int_flag");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteIsNull() {
            addCriterion("var_num_expediente is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteIsNotNull() {
            addCriterion("var_num_expediente is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteEqualTo(String value) {
            addCriterion("var_num_expediente =", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotEqualTo(String value) {
            addCriterion("var_num_expediente <>", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteGreaterThan(String value) {
            addCriterion("var_num_expediente >", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_expediente >=", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLessThan(String value) {
            addCriterion("var_num_expediente <", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLessThanOrEqualTo(String value) {
            addCriterion("var_num_expediente <=", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteLike(String value) {
            addCriterion("var_num_expediente like", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotLike(String value) {
            addCriterion("var_num_expediente not like", value, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteIn(List<String> values) {
            addCriterion("var_num_expediente in", values, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotIn(List<String> values) {
            addCriterion("var_num_expediente not in", values, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteBetween(String value1, String value2) {
            addCriterion("var_num_expediente between", value1, value2, "var_num_expediente");
            return (Criteria) this;
        }

        public Criteria andVar_num_expedienteNotBetween(String value1, String value2) {
            addCriterion("var_num_expediente not between", value1, value2, "var_num_expediente");
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