package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPostulanteNumeroTelefonoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPostulanteNumeroTelefonoExample() {
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

        public Criteria andSrl_id_numero_telefonoIsNull() {
            addCriterion("srl_id_numero_telefono is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoIsNotNull() {
            addCriterion("srl_id_numero_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono =", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono <>", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoGreaterThan(Integer value) {
            addCriterion("srl_id_numero_telefono >", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono >=", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoLessThan(Integer value) {
            addCriterion("srl_id_numero_telefono <", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_numero_telefono <=", value, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoIn(List<Integer> values) {
            addCriterion("srl_id_numero_telefono in", values, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotIn(List<Integer> values) {
            addCriterion("srl_id_numero_telefono not in", values, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_numero_telefono between", value1, value2, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andSrl_id_numero_telefonoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_numero_telefono not between", value1, value2, "srl_id_numero_telefono");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIsNull() {
            addCriterion("int_id_postulante is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIsNotNull() {
            addCriterion("int_id_postulante is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteEqualTo(Integer value) {
            addCriterion("int_id_postulante =", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotEqualTo(Integer value) {
            addCriterion("int_id_postulante <>", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteGreaterThan(Integer value) {
            addCriterion("int_id_postulante >", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_postulante >=", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteLessThan(Integer value) {
            addCriterion("int_id_postulante <", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_postulante <=", value, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteIn(List<Integer> values) {
            addCriterion("int_id_postulante in", values, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotIn(List<Integer> values) {
            addCriterion("int_id_postulante not in", values, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteBetween(Integer value1, Integer value2) {
            addCriterion("int_id_postulante between", value1, value2, "int_id_postulante");
            return (Criteria) this;
        }

        public Criteria andInt_id_postulanteNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_postulante not between", value1, value2, "int_id_postulante");
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