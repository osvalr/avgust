package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResetHistoricoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResetHistoricoExample() {
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

        public Criteria andId_reset_historicoIsNull() {
            addCriterion("id_reset_historico is null");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoIsNotNull() {
            addCriterion("id_reset_historico is not null");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoEqualTo(Integer value) {
            addCriterion("id_reset_historico =", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoNotEqualTo(Integer value) {
            addCriterion("id_reset_historico <>", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoGreaterThan(Integer value) {
            addCriterion("id_reset_historico >", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_reset_historico >=", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoLessThan(Integer value) {
            addCriterion("id_reset_historico <", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoLessThanOrEqualTo(Integer value) {
            addCriterion("id_reset_historico <=", value, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoIn(List<Integer> values) {
            addCriterion("id_reset_historico in", values, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoNotIn(List<Integer> values) {
            addCriterion("id_reset_historico not in", values, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoBetween(Integer value1, Integer value2) {
            addCriterion("id_reset_historico between", value1, value2, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andId_reset_historicoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_reset_historico not between", value1, value2, "id_reset_historico");
            return (Criteria) this;
        }

        public Criteria andAccountIDIsNull() {
            addCriterion("AccountID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIDIsNotNull() {
            addCriterion("AccountID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIDEqualTo(String value) {
            addCriterion("AccountID =", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotEqualTo(String value) {
            addCriterion("AccountID <>", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDGreaterThan(String value) {
            addCriterion("AccountID >", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDGreaterThanOrEqualTo(String value) {
            addCriterion("AccountID >=", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLessThan(String value) {
            addCriterion("AccountID <", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLessThanOrEqualTo(String value) {
            addCriterion("AccountID <=", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLike(String value) {
            addCriterion("AccountID like", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotLike(String value) {
            addCriterion("AccountID not like", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDIn(List<String> values) {
            addCriterion("AccountID in", values, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotIn(List<String> values) {
            addCriterion("AccountID not in", values, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDBetween(String value1, String value2) {
            addCriterion("AccountID between", value1, value2, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotBetween(String value1, String value2) {
            addCriterion("AccountID not between", value1, value2, "accountID");
            return (Criteria) this;
        }

        public Criteria andNameCharacterIsNull() {
            addCriterion("NameCharacter is null");
            return (Criteria) this;
        }

        public Criteria andNameCharacterIsNotNull() {
            addCriterion("NameCharacter is not null");
            return (Criteria) this;
        }

        public Criteria andNameCharacterEqualTo(String value) {
            addCriterion("NameCharacter =", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterNotEqualTo(String value) {
            addCriterion("NameCharacter <>", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterGreaterThan(String value) {
            addCriterion("NameCharacter >", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("NameCharacter >=", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterLessThan(String value) {
            addCriterion("NameCharacter <", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterLessThanOrEqualTo(String value) {
            addCriterion("NameCharacter <=", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterLike(String value) {
            addCriterion("NameCharacter like", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterNotLike(String value) {
            addCriterion("NameCharacter not like", value, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterIn(List<String> values) {
            addCriterion("NameCharacter in", values, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterNotIn(List<String> values) {
            addCriterion("NameCharacter not in", values, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterBetween(String value1, String value2) {
            addCriterion("NameCharacter between", value1, value2, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andNameCharacterNotBetween(String value1, String value2) {
            addCriterion("NameCharacter not between", value1, value2, "nameCharacter");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIsNull() {
            addCriterion("fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIsNotNull() {
            addCriterion("fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_registroEqualTo(Date value) {
            addCriterion("fecha_registro =", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotEqualTo(Date value) {
            addCriterion("fecha_registro <>", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroGreaterThan(Date value) {
            addCriterion("fecha_registro >", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha_registro >=", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroLessThan(Date value) {
            addCriterion("fecha_registro <", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroLessThanOrEqualTo(Date value) {
            addCriterion("fecha_registro <=", value, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroIn(List<Date> values) {
            addCriterion("fecha_registro in", values, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotIn(List<Date> values) {
            addCriterion("fecha_registro not in", values, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroBetween(Date value1, Date value2) {
            addCriterion("fecha_registro between", value1, value2, "fecha_registro");
            return (Criteria) this;
        }

        public Criteria andFecha_registroNotBetween(Date value1, Date value2) {
            addCriterion("fecha_registro not between", value1, value2, "fecha_registro");
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