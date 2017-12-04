package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TConvAreaOrgArchivoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TConvAreaOrgArchivoExample() {
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

        public Criteria andSrl_id_archivoIsNull() {
            addCriterion("srl_id_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIsNotNull() {
            addCriterion("srl_id_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoEqualTo(Integer value) {
            addCriterion("srl_id_archivo =", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_archivo <>", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_archivo >", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo >=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThan(Integer value) {
            addCriterion("srl_id_archivo <", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo <=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIn(List<Integer> values) {
            addCriterion("srl_id_archivo in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_archivo not in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo between", value1, value2, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo not between", value1, value2, "srl_id_archivo");
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

        public Criteria andSrl_id_conv_area_org_etapaIsNull() {
            addCriterion("srl_id_conv_area_org_etapa is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaIsNotNull() {
            addCriterion("srl_id_conv_area_org_etapa is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa =", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaNotEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa <>", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaGreaterThan(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa >", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa >=", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaLessThan(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa <", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_conv_area_org_etapa <=", value, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org_etapa in", values, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaNotIn(List<Integer> values) {
            addCriterion("srl_id_conv_area_org_etapa not in", values, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org_etapa between", value1, value2, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andSrl_id_conv_area_org_etapaNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_conv_area_org_etapa not between", value1, value2, "srl_id_conv_area_org_etapa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoIsNull() {
            addCriterion("var_descrip_archivo is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoIsNotNull() {
            addCriterion("var_descrip_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoEqualTo(String value) {
            addCriterion("var_descrip_archivo =", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoNotEqualTo(String value) {
            addCriterion("var_descrip_archivo <>", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoGreaterThan(String value) {
            addCriterion("var_descrip_archivo >", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_archivo >=", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoLessThan(String value) {
            addCriterion("var_descrip_archivo <", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_archivo <=", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoLike(String value) {
            addCriterion("var_descrip_archivo like", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoNotLike(String value) {
            addCriterion("var_descrip_archivo not like", value, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoIn(List<String> values) {
            addCriterion("var_descrip_archivo in", values, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoNotIn(List<String> values) {
            addCriterion("var_descrip_archivo not in", values, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoBetween(String value1, String value2) {
            addCriterion("var_descrip_archivo between", value1, value2, "var_descrip_archivo");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_archivoNotBetween(String value1, String value2) {
            addCriterion("var_descrip_archivo not between", value1, value2, "var_descrip_archivo");
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
