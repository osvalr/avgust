package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TConvocatoriaAreaOrgPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConvocatoriaAreaOrgPersonalExample() {
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

        public Criteria andSrl_id_conv_area_org_personalIsNull() {
            addCriterion("srl_id_conv_area_org_personal is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalIsNotNull() {
            addCriterion("srl_id_conv_area_org_personal is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_personal =", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalNotEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_personal <>", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalGreaterThan(Integer value) {
            addCriterion("srl_id_conv_area_org_personal >", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_personal >=", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalLessThan(Integer value) {
            addCriterion("srl_id_conv_area_org_personal <", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_personal <=", value, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org_personal in", values, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalNotIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org_personal not in", values, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org_personal between", value1, value2, "srl_id_conv_area_org_personal");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_personalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org_personal not between", value1, value2, "srl_id_conv_area_org_personal");
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

        public Criteria andIdrolIsNull() {
            addCriterion("idrol is null");
            return (Criteria) this;
        }

        public Criteria andIdrolIsNotNull() {
            addCriterion("idrol is not null");
            return (Criteria) this;
        }

        public Criteria andIdrolEqualTo(Integer value) {
            addCriterion("idrol =", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotEqualTo(Integer value) {
            addCriterion("idrol <>", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolGreaterThan(Integer value) {
            addCriterion("idrol >", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolGreaterThanOrEqualTo(Integer value) {
            addCriterion("idrol >=", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolLessThan(Integer value) {
            addCriterion("idrol <", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolLessThanOrEqualTo(Integer value) {
            addCriterion("idrol <=", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolIn(List<Integer> values) {
            addCriterion("idrol in", values, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotIn(List<Integer> values) {
            addCriterion("idrol not in", values, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolBetween(Integer value1, Integer value2) {
            addCriterion("idrol between", value1, value2, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotBetween(Integer value1, Integer value2) {
            addCriterion("idrol not between", value1, value2, "idrol");
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