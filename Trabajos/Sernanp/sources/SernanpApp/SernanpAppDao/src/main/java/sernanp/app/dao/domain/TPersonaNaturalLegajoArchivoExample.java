package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPersonaNaturalLegajoArchivoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonaNaturalLegajoArchivoExample() {
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

        public Criteria andSrl_id_persona_natural_legajo_archivoIsNull() {
            addCriterion("srl_id_persona_natural_legajo_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoIsNotNull() {
            addCriterion("srl_id_persona_natural_legajo_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo =", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo <>", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo >", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo >=", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoLessThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo <", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo_archivo <=", value, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo_archivo in", values, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo_archivo not in", values, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo_archivo between", value1, value2, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajo_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo_archivo not between", value1, value2, "srl_id_persona_natural_legajo_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoIsNull() {
            addCriterion("srl_id_persona_natural_legajo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoIsNotNull() {
            addCriterion("srl_id_persona_natural_legajo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo =", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <>", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoGreaterThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo >", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo >=", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoLessThan(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_persona_natural_legajo <=", value, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo in", values, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotIn(List<Integer> values) {
            addCriterion("srl_id_persona_natural_legajo not in", values, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo between", value1, value2, "srl_id_persona_natural_legajo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_persona_natural_legajoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_persona_natural_legajo not between", value1, value2, "srl_id_persona_natural_legajo");
            return (Criteria) this;
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

        public Criteria andInt_num_versionIsNull() {
            addCriterion("int_num_version is null");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionIsNotNull() {
            addCriterion("int_num_version is not null");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionEqualTo(Integer value) {
            addCriterion("int_num_version =", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionNotEqualTo(Integer value) {
            addCriterion("int_num_version <>", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionGreaterThan(Integer value) {
            addCriterion("int_num_version >", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_num_version >=", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionLessThan(Integer value) {
            addCriterion("int_num_version <", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionLessThanOrEqualTo(Integer value) {
            addCriterion("int_num_version <=", value, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionIn(List<Integer> values) {
            addCriterion("int_num_version in", values, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionNotIn(List<Integer> values) {
            addCriterion("int_num_version not in", values, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionBetween(Integer value1, Integer value2) {
            addCriterion("int_num_version between", value1, value2, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andInt_num_versionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_num_version not between", value1, value2, "int_num_version");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreIsNull() {
            addCriterion("srl_id_archivopadre is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreIsNotNull() {
            addCriterion("srl_id_archivopadre is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreEqualTo(Integer value) {
            addCriterion("srl_id_archivopadre =", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreNotEqualTo(Integer value) {
            addCriterion("srl_id_archivopadre <>", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreGreaterThan(Integer value) {
            addCriterion("srl_id_archivopadre >", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivopadre >=", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreLessThan(Integer value) {
            addCriterion("srl_id_archivopadre <", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivopadre <=", value, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreIn(List<Integer> values) {
            addCriterion("srl_id_archivopadre in", values, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreNotIn(List<Integer> values) {
            addCriterion("srl_id_archivopadre not in", values, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivopadre between", value1, value2, "srl_id_archivopadre");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivopadreNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivopadre not between", value1, value2, "srl_id_archivopadre");
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