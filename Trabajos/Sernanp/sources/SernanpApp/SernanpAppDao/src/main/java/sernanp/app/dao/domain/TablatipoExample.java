package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TablatipoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TablatipoExample() {
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

        public Criteria andOrdtablatipoIsNull() {
            addCriterion("ordtablatipo is null");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoIsNotNull() {
            addCriterion("ordtablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoEqualTo(Integer value) {
            addCriterion("ordtablatipo =", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoNotEqualTo(Integer value) {
            addCriterion("ordtablatipo <>", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoGreaterThan(Integer value) {
            addCriterion("ordtablatipo >", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordtablatipo >=", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoLessThan(Integer value) {
            addCriterion("ordtablatipo <", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoLessThanOrEqualTo(Integer value) {
            addCriterion("ordtablatipo <=", value, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoIn(List<Integer> values) {
            addCriterion("ordtablatipo in", values, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoNotIn(List<Integer> values) {
            addCriterion("ordtablatipo not in", values, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoBetween(Integer value1, Integer value2) {
            addCriterion("ordtablatipo between", value1, value2, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andOrdtablatipoNotBetween(Integer value1, Integer value2) {
            addCriterion("ordtablatipo not between", value1, value2, "ordtablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoIsNull() {
            addCriterion("destablatipo is null");
            return (Criteria) this;
        }

        public Criteria andDestablatipoIsNotNull() {
            addCriterion("destablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andDestablatipoEqualTo(String value) {
            addCriterion("destablatipo =", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoNotEqualTo(String value) {
            addCriterion("destablatipo <>", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoGreaterThan(String value) {
            addCriterion("destablatipo >", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoGreaterThanOrEqualTo(String value) {
            addCriterion("destablatipo >=", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoLessThan(String value) {
            addCriterion("destablatipo <", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoLessThanOrEqualTo(String value) {
            addCriterion("destablatipo <=", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoLike(String value) {
            addCriterion("destablatipo like", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoNotLike(String value) {
            addCriterion("destablatipo not like", value, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoIn(List<String> values) {
            addCriterion("destablatipo in", values, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoNotIn(List<String> values) {
            addCriterion("destablatipo not in", values, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoBetween(String value1, String value2) {
            addCriterion("destablatipo between", value1, value2, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andDestablatipoNotBetween(String value1, String value2) {
            addCriterion("destablatipo not between", value1, value2, "destablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoIsNull() {
            addCriterion("abrtablatipo is null");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoIsNotNull() {
            addCriterion("abrtablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoEqualTo(String value) {
            addCriterion("abrtablatipo =", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoNotEqualTo(String value) {
            addCriterion("abrtablatipo <>", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoGreaterThan(String value) {
            addCriterion("abrtablatipo >", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoGreaterThanOrEqualTo(String value) {
            addCriterion("abrtablatipo >=", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoLessThan(String value) {
            addCriterion("abrtablatipo <", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoLessThanOrEqualTo(String value) {
            addCriterion("abrtablatipo <=", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoLike(String value) {
            addCriterion("abrtablatipo like", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoNotLike(String value) {
            addCriterion("abrtablatipo not like", value, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoIn(List<String> values) {
            addCriterion("abrtablatipo in", values, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoNotIn(List<String> values) {
            addCriterion("abrtablatipo not in", values, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoBetween(String value1, String value2) {
            addCriterion("abrtablatipo between", value1, value2, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andAbrtablatipoNotBetween(String value1, String value2) {
            addCriterion("abrtablatipo not between", value1, value2, "abrtablatipo");
            return (Criteria) this;
        }

        public Criteria andIdtablaIsNull() {
            addCriterion("idtabla is null");
            return (Criteria) this;
        }

        public Criteria andIdtablaIsNotNull() {
            addCriterion("idtabla is not null");
            return (Criteria) this;
        }

        public Criteria andIdtablaEqualTo(Integer value) {
            addCriterion("idtabla =", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaNotEqualTo(Integer value) {
            addCriterion("idtabla <>", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaGreaterThan(Integer value) {
            addCriterion("idtabla >", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idtabla >=", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaLessThan(Integer value) {
            addCriterion("idtabla <", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaLessThanOrEqualTo(Integer value) {
            addCriterion("idtabla <=", value, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaIn(List<Integer> values) {
            addCriterion("idtabla in", values, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaNotIn(List<Integer> values) {
            addCriterion("idtabla not in", values, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaBetween(Integer value1, Integer value2) {
            addCriterion("idtabla between", value1, value2, "idtabla");
            return (Criteria) this;
        }

        public Criteria andIdtablaNotBetween(Integer value1, Integer value2) {
            addCriterion("idtabla not between", value1, value2, "idtabla");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoIsNull() {
            addCriterion("codinttablatipo is null");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoIsNotNull() {
            addCriterion("codinttablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoEqualTo(Integer value) {
            addCriterion("codinttablatipo =", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoNotEqualTo(Integer value) {
            addCriterion("codinttablatipo <>", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoGreaterThan(Integer value) {
            addCriterion("codinttablatipo >", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codinttablatipo >=", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoLessThan(Integer value) {
            addCriterion("codinttablatipo <", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoLessThanOrEqualTo(Integer value) {
            addCriterion("codinttablatipo <=", value, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoIn(List<Integer> values) {
            addCriterion("codinttablatipo in", values, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoNotIn(List<Integer> values) {
            addCriterion("codinttablatipo not in", values, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoBetween(Integer value1, Integer value2) {
            addCriterion("codinttablatipo between", value1, value2, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andCodinttablatipoNotBetween(Integer value1, Integer value2) {
            addCriterion("codinttablatipo not between", value1, value2, "codinttablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoIsNull() {
            addCriterion("mensajetablatipo is null");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoIsNotNull() {
            addCriterion("mensajetablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoEqualTo(String value) {
            addCriterion("mensajetablatipo =", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoNotEqualTo(String value) {
            addCriterion("mensajetablatipo <>", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoGreaterThan(String value) {
            addCriterion("mensajetablatipo >", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoGreaterThanOrEqualTo(String value) {
            addCriterion("mensajetablatipo >=", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoLessThan(String value) {
            addCriterion("mensajetablatipo <", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoLessThanOrEqualTo(String value) {
            addCriterion("mensajetablatipo <=", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoLike(String value) {
            addCriterion("mensajetablatipo like", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoNotLike(String value) {
            addCriterion("mensajetablatipo not like", value, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoIn(List<String> values) {
            addCriterion("mensajetablatipo in", values, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoNotIn(List<String> values) {
            addCriterion("mensajetablatipo not in", values, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoBetween(String value1, String value2) {
            addCriterion("mensajetablatipo between", value1, value2, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andMensajetablatipoNotBetween(String value1, String value2) {
            addCriterion("mensajetablatipo not between", value1, value2, "mensajetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoIsNull() {
            addCriterion("clasetablatipo is null");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoIsNotNull() {
            addCriterion("clasetablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoEqualTo(String value) {
            addCriterion("clasetablatipo =", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoNotEqualTo(String value) {
            addCriterion("clasetablatipo <>", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoGreaterThan(String value) {
            addCriterion("clasetablatipo >", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoGreaterThanOrEqualTo(String value) {
            addCriterion("clasetablatipo >=", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoLessThan(String value) {
            addCriterion("clasetablatipo <", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoLessThanOrEqualTo(String value) {
            addCriterion("clasetablatipo <=", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoLike(String value) {
            addCriterion("clasetablatipo like", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoNotLike(String value) {
            addCriterion("clasetablatipo not like", value, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoIn(List<String> values) {
            addCriterion("clasetablatipo in", values, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoNotIn(List<String> values) {
            addCriterion("clasetablatipo not in", values, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoBetween(String value1, String value2) {
            addCriterion("clasetablatipo between", value1, value2, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andClasetablatipoNotBetween(String value1, String value2) {
            addCriterion("clasetablatipo not between", value1, value2, "clasetablatipo");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleIsNull() {
            addCriterion("flagvisible is null");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleIsNotNull() {
            addCriterion("flagvisible is not null");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleEqualTo(Integer value) {
            addCriterion("flagvisible =", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleNotEqualTo(Integer value) {
            addCriterion("flagvisible <>", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleGreaterThan(Integer value) {
            addCriterion("flagvisible >", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("flagvisible >=", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleLessThan(Integer value) {
            addCriterion("flagvisible <", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleLessThanOrEqualTo(Integer value) {
            addCriterion("flagvisible <=", value, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleIn(List<Integer> values) {
            addCriterion("flagvisible in", values, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleNotIn(List<Integer> values) {
            addCriterion("flagvisible not in", values, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleBetween(Integer value1, Integer value2) {
            addCriterion("flagvisible between", value1, value2, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andFlagvisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("flagvisible not between", value1, value2, "flagvisible");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoIsNull() {
            addCriterion("int_cod_refer_tablatipo is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoIsNotNull() {
            addCriterion("int_cod_refer_tablatipo is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoEqualTo(Integer value) {
            addCriterion("int_cod_refer_tablatipo =", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoNotEqualTo(Integer value) {
            addCriterion("int_cod_refer_tablatipo <>", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoGreaterThan(Integer value) {
            addCriterion("int_cod_refer_tablatipo >", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_refer_tablatipo >=", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoLessThan(Integer value) {
            addCriterion("int_cod_refer_tablatipo <", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_refer_tablatipo <=", value, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoIn(List<Integer> values) {
            addCriterion("int_cod_refer_tablatipo in", values, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoNotIn(List<Integer> values) {
            addCriterion("int_cod_refer_tablatipo not in", values, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_refer_tablatipo between", value1, value2, "int_cod_refer_tablatipo");
            return (Criteria) this;
        }

        public Criteria andInt_cod_refer_tablatipoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_refer_tablatipo not between", value1, value2, "int_cod_refer_tablatipo");
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