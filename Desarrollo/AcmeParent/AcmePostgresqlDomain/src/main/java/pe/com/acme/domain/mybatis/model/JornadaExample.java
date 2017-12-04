package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JornadaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JornadaExample() {
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

        public Criteria andNum_diaIsNull() {
            addCriterion("num_dia is null");
            return (Criteria) this;
        }

        public Criteria andNum_diaIsNotNull() {
            addCriterion("num_dia is not null");
            return (Criteria) this;
        }

        public Criteria andNum_diaEqualTo(Integer value) {
            addCriterion("num_dia =", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotEqualTo(Integer value) {
            addCriterion("num_dia <>", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaGreaterThan(Integer value) {
            addCriterion("num_dia >", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_dia >=", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaLessThan(Integer value) {
            addCriterion("num_dia <", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaLessThanOrEqualTo(Integer value) {
            addCriterion("num_dia <=", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaIn(List<Integer> values) {
            addCriterion("num_dia in", values, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotIn(List<Integer> values) {
            addCriterion("num_dia not in", values, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaBetween(Integer value1, Integer value2) {
            addCriterion("num_dia between", value1, value2, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotBetween(Integer value1, Integer value2) {
            addCriterion("num_dia not between", value1, value2, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_mesIsNull() {
            addCriterion("num_mes is null");
            return (Criteria) this;
        }

        public Criteria andNum_mesIsNotNull() {
            addCriterion("num_mes is not null");
            return (Criteria) this;
        }

        public Criteria andNum_mesEqualTo(Integer value) {
            addCriterion("num_mes =", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotEqualTo(Integer value) {
            addCriterion("num_mes <>", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesGreaterThan(Integer value) {
            addCriterion("num_mes >", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_mes >=", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesLessThan(Integer value) {
            addCriterion("num_mes <", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesLessThanOrEqualTo(Integer value) {
            addCriterion("num_mes <=", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesIn(List<Integer> values) {
            addCriterion("num_mes in", values, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotIn(List<Integer> values) {
            addCriterion("num_mes not in", values, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesBetween(Integer value1, Integer value2) {
            addCriterion("num_mes between", value1, value2, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotBetween(Integer value1, Integer value2) {
            addCriterion("num_mes not between", value1, value2, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_anioIsNull() {
            addCriterion("num_anio is null");
            return (Criteria) this;
        }

        public Criteria andNum_anioIsNotNull() {
            addCriterion("num_anio is not null");
            return (Criteria) this;
        }

        public Criteria andNum_anioEqualTo(Integer value) {
            addCriterion("num_anio =", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotEqualTo(Integer value) {
            addCriterion("num_anio <>", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioGreaterThan(Integer value) {
            addCriterion("num_anio >", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_anio >=", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioLessThan(Integer value) {
            addCriterion("num_anio <", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioLessThanOrEqualTo(Integer value) {
            addCriterion("num_anio <=", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioIn(List<Integer> values) {
            addCriterion("num_anio in", values, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotIn(List<Integer> values) {
            addCriterion("num_anio not in", values, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioBetween(Integer value1, Integer value2) {
            addCriterion("num_anio between", value1, value2, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotBetween(Integer value1, Integer value2) {
            addCriterion("num_anio not between", value1, value2, "num_anio");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaIsNull() {
            addCriterion("fecha_jornada is null");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaIsNotNull() {
            addCriterion("fecha_jornada is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_jornada =", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_jornada <>", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_jornada >", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_jornada >=", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaLessThan(Date value) {
            addCriterionForJDBCDate("fecha_jornada <", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_jornada <=", value, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_jornada in", values, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_jornada not in", values, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_jornada between", value1, value2, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andFecha_jornadaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_jornada not between", value1, value2, "fecha_jornada");
            return (Criteria) this;
        }

        public Criteria andId_estadoIsNull() {
            addCriterion("id_estado is null");
            return (Criteria) this;
        }

        public Criteria andId_estadoIsNotNull() {
            addCriterion("id_estado is not null");
            return (Criteria) this;
        }

        public Criteria andId_estadoEqualTo(Integer value) {
            addCriterion("id_estado =", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotEqualTo(Integer value) {
            addCriterion("id_estado <>", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThan(Integer value) {
            addCriterion("id_estado >", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_estado >=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThan(Integer value) {
            addCriterion("id_estado <", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("id_estado <=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoIn(List<Integer> values) {
            addCriterion("id_estado in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotIn(List<Integer> values) {
            addCriterion("id_estado not in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoBetween(Integer value1, Integer value2) {
            addCriterion("id_estado between", value1, value2, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_estado not between", value1, value2, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regIsNull() {
            addCriterion("id_usuario_reg is null");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regIsNotNull() {
            addCriterion("id_usuario_reg is not null");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regEqualTo(Integer value) {
            addCriterion("id_usuario_reg =", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regNotEqualTo(Integer value) {
            addCriterion("id_usuario_reg <>", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regGreaterThan(Integer value) {
            addCriterion("id_usuario_reg >", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_usuario_reg >=", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regLessThan(Integer value) {
            addCriterion("id_usuario_reg <", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regLessThanOrEqualTo(Integer value) {
            addCriterion("id_usuario_reg <=", value, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regIn(List<Integer> values) {
            addCriterion("id_usuario_reg in", values, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regNotIn(List<Integer> values) {
            addCriterion("id_usuario_reg not in", values, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario_reg between", value1, value2, "id_usuario_reg");
            return (Criteria) this;
        }

        public Criteria andId_usuario_regNotBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario_reg not between", value1, value2, "id_usuario_reg");
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

        public Criteria andId_usuario_modIsNull() {
            addCriterion("id_usuario_mod is null");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modIsNotNull() {
            addCriterion("id_usuario_mod is not null");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modEqualTo(Integer value) {
            addCriterion("id_usuario_mod =", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modNotEqualTo(Integer value) {
            addCriterion("id_usuario_mod <>", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modGreaterThan(Integer value) {
            addCriterion("id_usuario_mod >", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_usuario_mod >=", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modLessThan(Integer value) {
            addCriterion("id_usuario_mod <", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modLessThanOrEqualTo(Integer value) {
            addCriterion("id_usuario_mod <=", value, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modIn(List<Integer> values) {
            addCriterion("id_usuario_mod in", values, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modNotIn(List<Integer> values) {
            addCriterion("id_usuario_mod not in", values, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario_mod between", value1, value2, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andId_usuario_modNotBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario_mod not between", value1, value2, "id_usuario_mod");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionIsNull() {
            addCriterion("fecha_modificacion is null");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionIsNotNull() {
            addCriterion("fecha_modificacion is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionEqualTo(Date value) {
            addCriterion("fecha_modificacion =", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionNotEqualTo(Date value) {
            addCriterion("fecha_modificacion <>", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionGreaterThan(Date value) {
            addCriterion("fecha_modificacion >", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha_modificacion >=", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionLessThan(Date value) {
            addCriterion("fecha_modificacion <", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionLessThanOrEqualTo(Date value) {
            addCriterion("fecha_modificacion <=", value, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionIn(List<Date> values) {
            addCriterion("fecha_modificacion in", values, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionNotIn(List<Date> values) {
            addCriterion("fecha_modificacion not in", values, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionBetween(Date value1, Date value2) {
            addCriterion("fecha_modificacion between", value1, value2, "fecha_modificacion");
            return (Criteria) this;
        }

        public Criteria andFecha_modificacionNotBetween(Date value1, Date value2) {
            addCriterion("fecha_modificacion not between", value1, value2, "fecha_modificacion");
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