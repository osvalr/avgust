package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionalidadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FuncionalidadExample() {
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

        public Criteria andId_funcionalidadIsNull() {
            addCriterion("id_funcionalidad is null");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadIsNotNull() {
            addCriterion("id_funcionalidad is not null");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadEqualTo(Integer value) {
            addCriterion("id_funcionalidad =", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadNotEqualTo(Integer value) {
            addCriterion("id_funcionalidad <>", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadGreaterThan(Integer value) {
            addCriterion("id_funcionalidad >", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_funcionalidad >=", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadLessThan(Integer value) {
            addCriterion("id_funcionalidad <", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadLessThanOrEqualTo(Integer value) {
            addCriterion("id_funcionalidad <=", value, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadIn(List<Integer> values) {
            addCriterion("id_funcionalidad in", values, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadNotIn(List<Integer> values) {
            addCriterion("id_funcionalidad not in", values, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadBetween(Integer value1, Integer value2) {
            addCriterion("id_funcionalidad between", value1, value2, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andId_funcionalidadNotBetween(Integer value1, Integer value2) {
            addCriterion("id_funcionalidad not between", value1, value2, "id_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadIsNull() {
            addCriterion("nombre_funcionalidad is null");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadIsNotNull() {
            addCriterion("nombre_funcionalidad is not null");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadEqualTo(String value) {
            addCriterion("nombre_funcionalidad =", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadNotEqualTo(String value) {
            addCriterion("nombre_funcionalidad <>", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadGreaterThan(String value) {
            addCriterion("nombre_funcionalidad >", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_funcionalidad >=", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadLessThan(String value) {
            addCriterion("nombre_funcionalidad <", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadLessThanOrEqualTo(String value) {
            addCriterion("nombre_funcionalidad <=", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadLike(String value) {
            addCriterion("nombre_funcionalidad like", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadNotLike(String value) {
            addCriterion("nombre_funcionalidad not like", value, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadIn(List<String> values) {
            addCriterion("nombre_funcionalidad in", values, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadNotIn(List<String> values) {
            addCriterion("nombre_funcionalidad not in", values, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadBetween(String value1, String value2) {
            addCriterion("nombre_funcionalidad between", value1, value2, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andNombre_funcionalidadNotBetween(String value1, String value2) {
            addCriterion("nombre_funcionalidad not between", value1, value2, "nombre_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadIsNull() {
            addCriterion("recurso_funcionalidad is null");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadIsNotNull() {
            addCriterion("recurso_funcionalidad is not null");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadEqualTo(String value) {
            addCriterion("recurso_funcionalidad =", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadNotEqualTo(String value) {
            addCriterion("recurso_funcionalidad <>", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadGreaterThan(String value) {
            addCriterion("recurso_funcionalidad >", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadGreaterThanOrEqualTo(String value) {
            addCriterion("recurso_funcionalidad >=", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadLessThan(String value) {
            addCriterion("recurso_funcionalidad <", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadLessThanOrEqualTo(String value) {
            addCriterion("recurso_funcionalidad <=", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadLike(String value) {
            addCriterion("recurso_funcionalidad like", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadNotLike(String value) {
            addCriterion("recurso_funcionalidad not like", value, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadIn(List<String> values) {
            addCriterion("recurso_funcionalidad in", values, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadNotIn(List<String> values) {
            addCriterion("recurso_funcionalidad not in", values, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadBetween(String value1, String value2) {
            addCriterion("recurso_funcionalidad between", value1, value2, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andRecurso_funcionalidadNotBetween(String value1, String value2) {
            addCriterion("recurso_funcionalidad not between", value1, value2, "recurso_funcionalidad");
            return (Criteria) this;
        }

        public Criteria andIcon_clsIsNull() {
            addCriterion("icon_cls is null");
            return (Criteria) this;
        }

        public Criteria andIcon_clsIsNotNull() {
            addCriterion("icon_cls is not null");
            return (Criteria) this;
        }

        public Criteria andIcon_clsEqualTo(String value) {
            addCriterion("icon_cls =", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsNotEqualTo(String value) {
            addCriterion("icon_cls <>", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsGreaterThan(String value) {
            addCriterion("icon_cls >", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsGreaterThanOrEqualTo(String value) {
            addCriterion("icon_cls >=", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsLessThan(String value) {
            addCriterion("icon_cls <", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsLessThanOrEqualTo(String value) {
            addCriterion("icon_cls <=", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsLike(String value) {
            addCriterion("icon_cls like", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsNotLike(String value) {
            addCriterion("icon_cls not like", value, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsIn(List<String> values) {
            addCriterion("icon_cls in", values, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsNotIn(List<String> values) {
            addCriterion("icon_cls not in", values, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsBetween(String value1, String value2) {
            addCriterion("icon_cls between", value1, value2, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andIcon_clsNotBetween(String value1, String value2) {
            addCriterion("icon_cls not between", value1, value2, "icon_cls");
            return (Criteria) this;
        }

        public Criteria andAlias_componentIsNull() {
            addCriterion("alias_component is null");
            return (Criteria) this;
        }

        public Criteria andAlias_componentIsNotNull() {
            addCriterion("alias_component is not null");
            return (Criteria) this;
        }

        public Criteria andAlias_componentEqualTo(String value) {
            addCriterion("alias_component =", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentNotEqualTo(String value) {
            addCriterion("alias_component <>", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentGreaterThan(String value) {
            addCriterion("alias_component >", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentGreaterThanOrEqualTo(String value) {
            addCriterion("alias_component >=", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentLessThan(String value) {
            addCriterion("alias_component <", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentLessThanOrEqualTo(String value) {
            addCriterion("alias_component <=", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentLike(String value) {
            addCriterion("alias_component like", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentNotLike(String value) {
            addCriterion("alias_component not like", value, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentIn(List<String> values) {
            addCriterion("alias_component in", values, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentNotIn(List<String> values) {
            addCriterion("alias_component not in", values, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentBetween(String value1, String value2) {
            addCriterion("alias_component between", value1, value2, "alias_component");
            return (Criteria) this;
        }

        public Criteria andAlias_componentNotBetween(String value1, String value2) {
            addCriterion("alias_component not between", value1, value2, "alias_component");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersIsNull() {
            addCriterion("component_controllers is null");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersIsNotNull() {
            addCriterion("component_controllers is not null");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersEqualTo(String value) {
            addCriterion("component_controllers =", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersNotEqualTo(String value) {
            addCriterion("component_controllers <>", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersGreaterThan(String value) {
            addCriterion("component_controllers >", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersGreaterThanOrEqualTo(String value) {
            addCriterion("component_controllers >=", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersLessThan(String value) {
            addCriterion("component_controllers <", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersLessThanOrEqualTo(String value) {
            addCriterion("component_controllers <=", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersLike(String value) {
            addCriterion("component_controllers like", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersNotLike(String value) {
            addCriterion("component_controllers not like", value, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersIn(List<String> values) {
            addCriterion("component_controllers in", values, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersNotIn(List<String> values) {
            addCriterion("component_controllers not in", values, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersBetween(String value1, String value2) {
            addCriterion("component_controllers between", value1, value2, "component_controllers");
            return (Criteria) this;
        }

        public Criteria andComponent_controllersNotBetween(String value1, String value2) {
            addCriterion("component_controllers not between", value1, value2, "component_controllers");
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