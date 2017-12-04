package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioRolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsuarioRolExample() {
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

        public Criteria andId_usuarioIsNull() {
            addCriterion("id_usuario is null");
            return (Criteria) this;
        }

        public Criteria andId_usuarioIsNotNull() {
            addCriterion("id_usuario is not null");
            return (Criteria) this;
        }

        public Criteria andId_usuarioEqualTo(Integer value) {
            addCriterion("id_usuario =", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioNotEqualTo(Integer value) {
            addCriterion("id_usuario <>", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioGreaterThan(Integer value) {
            addCriterion("id_usuario >", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_usuario >=", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioLessThan(Integer value) {
            addCriterion("id_usuario <", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioLessThanOrEqualTo(Integer value) {
            addCriterion("id_usuario <=", value, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioIn(List<Integer> values) {
            addCriterion("id_usuario in", values, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioNotIn(List<Integer> values) {
            addCriterion("id_usuario not in", values, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario between", value1, value2, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_usuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("id_usuario not between", value1, value2, "id_usuario");
            return (Criteria) this;
        }

        public Criteria andId_rolIsNull() {
            addCriterion("id_rol is null");
            return (Criteria) this;
        }

        public Criteria andId_rolIsNotNull() {
            addCriterion("id_rol is not null");
            return (Criteria) this;
        }

        public Criteria andId_rolEqualTo(Integer value) {
            addCriterion("id_rol =", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolNotEqualTo(Integer value) {
            addCriterion("id_rol <>", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolGreaterThan(Integer value) {
            addCriterion("id_rol >", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_rol >=", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolLessThan(Integer value) {
            addCriterion("id_rol <", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolLessThanOrEqualTo(Integer value) {
            addCriterion("id_rol <=", value, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolIn(List<Integer> values) {
            addCriterion("id_rol in", values, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolNotIn(List<Integer> values) {
            addCriterion("id_rol not in", values, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolBetween(Integer value1, Integer value2) {
            addCriterion("id_rol between", value1, value2, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_rolNotBetween(Integer value1, Integer value2) {
            addCriterion("id_rol not between", value1, value2, "id_rol");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionIsNull() {
            addCriterion("id_aplicacion is null");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionIsNotNull() {
            addCriterion("id_aplicacion is not null");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionEqualTo(Integer value) {
            addCriterion("id_aplicacion =", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionNotEqualTo(Integer value) {
            addCriterion("id_aplicacion <>", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionGreaterThan(Integer value) {
            addCriterion("id_aplicacion >", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_aplicacion >=", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionLessThan(Integer value) {
            addCriterion("id_aplicacion <", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_aplicacion <=", value, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionIn(List<Integer> values) {
            addCriterion("id_aplicacion in", values, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionNotIn(List<Integer> values) {
            addCriterion("id_aplicacion not in", values, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionBetween(Integer value1, Integer value2) {
            addCriterion("id_aplicacion between", value1, value2, "id_aplicacion");
            return (Criteria) this;
        }

        public Criteria andId_aplicacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_aplicacion not between", value1, value2, "id_aplicacion");
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

        public Criteria andId_estadoEqualTo(Short value) {
            addCriterion("id_estado =", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotEqualTo(Short value) {
            addCriterion("id_estado <>", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThan(Short value) {
            addCriterion("id_estado >", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThanOrEqualTo(Short value) {
            addCriterion("id_estado >=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThan(Short value) {
            addCriterion("id_estado <", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThanOrEqualTo(Short value) {
            addCriterion("id_estado <=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoIn(List<Short> values) {
            addCriterion("id_estado in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotIn(List<Short> values) {
            addCriterion("id_estado not in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoBetween(Short value1, Short value2) {
            addCriterion("id_estado between", value1, value2, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotBetween(Short value1, Short value2) {
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