package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalExample() {
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

        public Criteria andTsp_fec_creaIsNull() {
            addCriterion("tsp_fec_crea is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaIsNotNull() {
            addCriterion("tsp_fec_crea is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaEqualTo(Date value) {
            addCriterion("tsp_fec_crea =", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaNotEqualTo(Date value) {
            addCriterion("tsp_fec_crea <>", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaGreaterThan(Date value) {
            addCriterion("tsp_fec_crea >", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_crea >=", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaLessThan(Date value) {
            addCriterion("tsp_fec_crea <", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_crea <=", value, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaIn(List<Date> values) {
            addCriterion("tsp_fec_crea in", values, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaNotIn(List<Date> values) {
            addCriterion("tsp_fec_crea not in", values, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_crea between", value1, value2, "tsp_fec_crea");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_creaNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_crea not between", value1, value2, "tsp_fec_crea");
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

        public Criteria andTsp_fec_modIsNull() {
            addCriterion("tsp_fec_mod is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modIsNotNull() {
            addCriterion("tsp_fec_mod is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modEqualTo(Date value) {
            addCriterion("tsp_fec_mod =", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modNotEqualTo(Date value) {
            addCriterion("tsp_fec_mod <>", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modGreaterThan(Date value) {
            addCriterion("tsp_fec_mod >", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_mod >=", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modLessThan(Date value) {
            addCriterion("tsp_fec_mod <", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fec_mod <=", value, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modIn(List<Date> values) {
            addCriterion("tsp_fec_mod in", values, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modNotIn(List<Date> values) {
            addCriterion("tsp_fec_mod not in", values, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_mod between", value1, value2, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andTsp_fec_modNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fec_mod not between", value1, value2, "tsp_fec_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modIsNull() {
            addCriterion("int_id_usu_mod is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modIsNotNull() {
            addCriterion("int_id_usu_mod is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modEqualTo(Integer value) {
            addCriterion("int_id_usu_mod =", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modNotEqualTo(Integer value) {
            addCriterion("int_id_usu_mod <>", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modGreaterThan(Integer value) {
            addCriterion("int_id_usu_mod >", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_mod >=", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modLessThan(Integer value) {
            addCriterion("int_id_usu_mod <", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_usu_mod <=", value, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modIn(List<Integer> values) {
            addCriterion("int_id_usu_mod in", values, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modNotIn(List<Integer> values) {
            addCriterion("int_id_usu_mod not in", values, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_mod between", value1, value2, "int_id_usu_mod");
            return (Criteria) this;
        }

        public Criteria andInt_id_usu_modNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_usu_mod not between", value1, value2, "int_id_usu_mod");
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

        public Criteria andVar_tarjeta_proximidadIsNull() {
            addCriterion("var_tarjeta_proximidad is null");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadIsNotNull() {
            addCriterion("var_tarjeta_proximidad is not null");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadEqualTo(String value) {
            addCriterion("var_tarjeta_proximidad =", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadNotEqualTo(String value) {
            addCriterion("var_tarjeta_proximidad <>", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadGreaterThan(String value) {
            addCriterion("var_tarjeta_proximidad >", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadGreaterThanOrEqualTo(String value) {
            addCriterion("var_tarjeta_proximidad >=", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadLessThan(String value) {
            addCriterion("var_tarjeta_proximidad <", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadLessThanOrEqualTo(String value) {
            addCriterion("var_tarjeta_proximidad <=", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadLike(String value) {
            addCriterion("var_tarjeta_proximidad like", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadNotLike(String value) {
            addCriterion("var_tarjeta_proximidad not like", value, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadIn(List<String> values) {
            addCriterion("var_tarjeta_proximidad in", values, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadNotIn(List<String> values) {
            addCriterion("var_tarjeta_proximidad not in", values, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadBetween(String value1, String value2) {
            addCriterion("var_tarjeta_proximidad between", value1, value2, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andVar_tarjeta_proximidadNotBetween(String value1, String value2) {
            addCriterion("var_tarjeta_proximidad not between", value1, value2, "var_tarjeta_proximidad");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraIsNull() {
            addCriterion("srl_id_tipo_carrera is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraIsNotNull() {
            addCriterion("srl_id_tipo_carrera is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraEqualTo(Integer value) {
            addCriterion("srl_id_tipo_carrera =", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraNotEqualTo(Integer value) {
            addCriterion("srl_id_tipo_carrera <>", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraGreaterThan(Integer value) {
            addCriterion("srl_id_tipo_carrera >", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_carrera >=", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraLessThan(Integer value) {
            addCriterion("srl_id_tipo_carrera <", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_carrera <=", value, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraIn(List<Integer> values) {
            addCriterion("srl_id_tipo_carrera in", values, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraNotIn(List<Integer> values) {
            addCriterion("srl_id_tipo_carrera not in", values, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_carrera between", value1, value2, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_carreraNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_carrera not between", value1, value2, "srl_id_tipo_carrera");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNull() {
            addCriterion("var_numero_cuenta_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIsNotNull() {
            addCriterion("var_numero_cuenta_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria =", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <>", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThan(String value) {
            addCriterion("var_numero_cuenta_bancaria >", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria >=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThan(String value) {
            addCriterion("var_numero_cuenta_bancaria <", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLessThanOrEqualTo(String value) {
            addCriterion("var_numero_cuenta_bancaria <=", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaLike(String value) {
            addCriterion("var_numero_cuenta_bancaria like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotLike(String value) {
            addCriterion("var_numero_cuenta_bancaria not like", value, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotIn(List<String> values) {
            addCriterion("var_numero_cuenta_bancaria not in", values, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria between", value1, value2, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_numero_cuenta_bancariaNotBetween(String value1, String value2) {
            addCriterion("var_numero_cuenta_bancaria not between", value1, value2, "var_numero_cuenta_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNull() {
            addCriterion("srl_id_entidad_bancaria is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIsNotNull() {
            addCriterion("srl_id_entidad_bancaria is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria =", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <>", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria >", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria >=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThan(Integer value) {
            addCriterion("srl_id_entidad_bancaria <", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_entidad_bancaria <=", value, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotIn(List<Integer> values) {
            addCriterion("srl_id_entidad_bancaria not in", values, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andSrl_id_entidad_bancariaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_entidad_bancaria not between", value1, value2, "srl_id_entidad_bancaria");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIsNull() {
            addCriterion("var_codigo_afiliacion is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIsNotNull() {
            addCriterion("var_codigo_afiliacion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionEqualTo(String value) {
            addCriterion("var_codigo_afiliacion =", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotEqualTo(String value) {
            addCriterion("var_codigo_afiliacion <>", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionGreaterThan(String value) {
            addCriterion("var_codigo_afiliacion >", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionGreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_afiliacion >=", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLessThan(String value) {
            addCriterion("var_codigo_afiliacion <", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLessThanOrEqualTo(String value) {
            addCriterion("var_codigo_afiliacion <=", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionLike(String value) {
            addCriterion("var_codigo_afiliacion like", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotLike(String value) {
            addCriterion("var_codigo_afiliacion not like", value, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionIn(List<String> values) {
            addCriterion("var_codigo_afiliacion in", values, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotIn(List<String> values) {
            addCriterion("var_codigo_afiliacion not in", values, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionBetween(String value1, String value2) {
            addCriterion("var_codigo_afiliacion between", value1, value2, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_afiliacionNotBetween(String value1, String value2) {
            addCriterion("var_codigo_afiliacion not between", value1, value2, "var_codigo_afiliacion");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIsNull() {
            addCriterion("var_nombre_afp is null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIsNotNull() {
            addCriterion("var_nombre_afp is not null");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpEqualTo(String value) {
            addCriterion("var_nombre_afp =", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotEqualTo(String value) {
            addCriterion("var_nombre_afp <>", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpGreaterThan(String value) {
            addCriterion("var_nombre_afp >", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpGreaterThanOrEqualTo(String value) {
            addCriterion("var_nombre_afp >=", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLessThan(String value) {
            addCriterion("var_nombre_afp <", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLessThanOrEqualTo(String value) {
            addCriterion("var_nombre_afp <=", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpLike(String value) {
            addCriterion("var_nombre_afp like", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotLike(String value) {
            addCriterion("var_nombre_afp not like", value, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpIn(List<String> values) {
            addCriterion("var_nombre_afp in", values, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotIn(List<String> values) {
            addCriterion("var_nombre_afp not in", values, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpBetween(String value1, String value2) {
            addCriterion("var_nombre_afp between", value1, value2, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andVar_nombre_afpNotBetween(String value1, String value2) {
            addCriterion("var_nombre_afp not between", value1, value2, "var_nombre_afp");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIsNull() {
            addCriterion("dte_fecha_afiliacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIsNotNull() {
            addCriterion("dte_fecha_afiliacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion =", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <>", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion >", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion >=", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_afiliacion <=", value, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_afiliacion in", values, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_afiliacion not in", values, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_afiliacion between", value1, value2, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_afiliacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_afiliacion not between", value1, value2, "dte_fecha_afiliacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIsNull() {
            addCriterion("srl_id_regimen_pensionario is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIsNotNull() {
            addCriterion("srl_id_regimen_pensionario is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario =", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <>", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario >", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario >=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThan(Integer value) {
            addCriterion("srl_id_regimen_pensionario <", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_regimen_pensionario <=", value, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotIn(List<Integer> values) {
            addCriterion("srl_id_regimen_pensionario not in", values, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario between", value1, value2, "srl_id_regimen_pensionario");
            return (Criteria) this;
        }

        public Criteria andSrl_id_regimen_pensionarioNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_regimen_pensionario not between", value1, value2, "srl_id_regimen_pensionario");
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

        public Criteria andDte_fec_ingresoIsNull() {
            addCriterion("dte_fec_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoIsNotNull() {
            addCriterion("dte_fec_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso =", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso <>", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso >", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso >=", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso <", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fec_ingreso <=", value, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_ingreso in", values, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fec_ingreso not in", values, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_ingreso between", value1, value2, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fec_ingresoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fec_ingreso not between", value1, value2, "dte_fec_ingreso");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNull() {
            addCriterion("srl_id_afp is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIsNotNull() {
            addCriterion("srl_id_afp is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpEqualTo(Integer value) {
            addCriterion("srl_id_afp =", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotEqualTo(Integer value) {
            addCriterion("srl_id_afp <>", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThan(Integer value) {
            addCriterion("srl_id_afp >", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp >=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThan(Integer value) {
            addCriterion("srl_id_afp <", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_afp <=", value, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpIn(List<Integer> values) {
            addCriterion("srl_id_afp in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotIn(List<Integer> values) {
            addCriterion("srl_id_afp not in", values, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andSrl_id_afpNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_afp not between", value1, value2, "srl_id_afp");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNull() {
            addCriterion("int_id_tipo_comision is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIsNotNull() {
            addCriterion("int_id_tipo_comision is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision =", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <>", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThan(Integer value) {
            addCriterion("int_id_tipo_comision >", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision >=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThan(Integer value) {
            addCriterion("int_id_tipo_comision <", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_comision <=", value, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_comision not in", values, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision between", value1, value2, "int_id_tipo_comision");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_comisionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_comision not between", value1, value2, "int_id_tipo_comision");
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