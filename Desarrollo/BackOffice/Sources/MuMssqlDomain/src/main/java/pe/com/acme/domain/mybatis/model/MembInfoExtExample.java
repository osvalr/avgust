package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MembInfoExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembInfoExtExample() {
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

        public Criteria andMemb_guidIsNull() {
            addCriterion("memb_guid is null");
            return (Criteria) this;
        }

        public Criteria andMemb_guidIsNotNull() {
            addCriterion("memb_guid is not null");
            return (Criteria) this;
        }

        public Criteria andMemb_guidEqualTo(Integer value) {
            addCriterion("memb_guid =", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotEqualTo(Integer value) {
            addCriterion("memb_guid <>", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidGreaterThan(Integer value) {
            addCriterion("memb_guid >", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memb_guid >=", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidLessThan(Integer value) {
            addCriterion("memb_guid <", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidLessThanOrEqualTo(Integer value) {
            addCriterion("memb_guid <=", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidIn(List<Integer> values) {
            addCriterion("memb_guid in", values, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotIn(List<Integer> values) {
            addCriterion("memb_guid not in", values, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidBetween(Integer value1, Integer value2) {
            addCriterion("memb_guid between", value1, value2, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotBetween(Integer value1, Integer value2) {
            addCriterion("memb_guid not between", value1, value2, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andNombresIsNull() {
            addCriterion("nombres is null");
            return (Criteria) this;
        }

        public Criteria andNombresIsNotNull() {
            addCriterion("nombres is not null");
            return (Criteria) this;
        }

        public Criteria andNombresEqualTo(String value) {
            addCriterion("nombres =", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotEqualTo(String value) {
            addCriterion("nombres <>", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresGreaterThan(String value) {
            addCriterion("nombres >", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresGreaterThanOrEqualTo(String value) {
            addCriterion("nombres >=", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLessThan(String value) {
            addCriterion("nombres <", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLessThanOrEqualTo(String value) {
            addCriterion("nombres <=", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLike(String value) {
            addCriterion("nombres like", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotLike(String value) {
            addCriterion("nombres not like", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresIn(List<String> values) {
            addCriterion("nombres in", values, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotIn(List<String> values) {
            addCriterion("nombres not in", values, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresBetween(String value1, String value2) {
            addCriterion("nombres between", value1, value2, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotBetween(String value1, String value2) {
            addCriterion("nombres not between", value1, value2, "nombres");
            return (Criteria) this;
        }

        public Criteria andApe_paterIsNull() {
            addCriterion("ape_pater is null");
            return (Criteria) this;
        }

        public Criteria andApe_paterIsNotNull() {
            addCriterion("ape_pater is not null");
            return (Criteria) this;
        }

        public Criteria andApe_paterEqualTo(String value) {
            addCriterion("ape_pater =", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterNotEqualTo(String value) {
            addCriterion("ape_pater <>", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterGreaterThan(String value) {
            addCriterion("ape_pater >", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterGreaterThanOrEqualTo(String value) {
            addCriterion("ape_pater >=", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterLessThan(String value) {
            addCriterion("ape_pater <", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterLessThanOrEqualTo(String value) {
            addCriterion("ape_pater <=", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterLike(String value) {
            addCriterion("ape_pater like", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterNotLike(String value) {
            addCriterion("ape_pater not like", value, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterIn(List<String> values) {
            addCriterion("ape_pater in", values, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterNotIn(List<String> values) {
            addCriterion("ape_pater not in", values, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterBetween(String value1, String value2) {
            addCriterion("ape_pater between", value1, value2, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_paterNotBetween(String value1, String value2) {
            addCriterion("ape_pater not between", value1, value2, "ape_pater");
            return (Criteria) this;
        }

        public Criteria andApe_materIsNull() {
            addCriterion("ape_mater is null");
            return (Criteria) this;
        }

        public Criteria andApe_materIsNotNull() {
            addCriterion("ape_mater is not null");
            return (Criteria) this;
        }

        public Criteria andApe_materEqualTo(String value) {
            addCriterion("ape_mater =", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materNotEqualTo(String value) {
            addCriterion("ape_mater <>", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materGreaterThan(String value) {
            addCriterion("ape_mater >", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materGreaterThanOrEqualTo(String value) {
            addCriterion("ape_mater >=", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materLessThan(String value) {
            addCriterion("ape_mater <", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materLessThanOrEqualTo(String value) {
            addCriterion("ape_mater <=", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materLike(String value) {
            addCriterion("ape_mater like", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materNotLike(String value) {
            addCriterion("ape_mater not like", value, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materIn(List<String> values) {
            addCriterion("ape_mater in", values, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materNotIn(List<String> values) {
            addCriterion("ape_mater not in", values, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materBetween(String value1, String value2) {
            addCriterion("ape_mater between", value1, value2, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andApe_materNotBetween(String value1, String value2) {
            addCriterion("ape_mater not between", value1, value2, "ape_mater");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoIsNull() {
            addCriterion("fecha_nacimiento is null");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoIsNotNull() {
            addCriterion("fecha_nacimiento is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento =", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <>", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento >", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento >=", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoLessThan(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <=", value, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_nacimiento in", values, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_nacimiento not in", values, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_nacimiento between", value1, value2, "fecha_nacimiento");
            return (Criteria) this;
        }

        public Criteria andFecha_nacimientoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_nacimiento not between", value1, value2, "fecha_nacimiento");
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