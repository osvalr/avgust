package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class TPostulantePersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPostulantePersonalExample() {
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

        public Criteria andInt_porta_lic_conducirIsNull() {
            addCriterion("int_porta_lic_conducir is null");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirIsNotNull() {
            addCriterion("int_porta_lic_conducir is not null");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirEqualTo(Integer value) {
            addCriterion("int_porta_lic_conducir =", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirNotEqualTo(Integer value) {
            addCriterion("int_porta_lic_conducir <>", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirGreaterThan(Integer value) {
            addCriterion("int_porta_lic_conducir >", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_porta_lic_conducir >=", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirLessThan(Integer value) {
            addCriterion("int_porta_lic_conducir <", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirLessThanOrEqualTo(Integer value) {
            addCriterion("int_porta_lic_conducir <=", value, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirIn(List<Integer> values) {
            addCriterion("int_porta_lic_conducir in", values, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirNotIn(List<Integer> values) {
            addCriterion("int_porta_lic_conducir not in", values, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirBetween(Integer value1, Integer value2) {
            addCriterion("int_porta_lic_conducir between", value1, value2, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_porta_lic_conducirNotBetween(Integer value1, Integer value2) {
            addCriterion("int_porta_lic_conducir not between", value1, value2, "int_porta_lic_conducir");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licIsNull() {
            addCriterion("int_clase_lic is null");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licIsNotNull() {
            addCriterion("int_clase_lic is not null");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licEqualTo(Integer value) {
            addCriterion("int_clase_lic =", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licNotEqualTo(Integer value) {
            addCriterion("int_clase_lic <>", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licGreaterThan(Integer value) {
            addCriterion("int_clase_lic >", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_clase_lic >=", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licLessThan(Integer value) {
            addCriterion("int_clase_lic <", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licLessThanOrEqualTo(Integer value) {
            addCriterion("int_clase_lic <=", value, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licIn(List<Integer> values) {
            addCriterion("int_clase_lic in", values, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licNotIn(List<Integer> values) {
            addCriterion("int_clase_lic not in", values, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licBetween(Integer value1, Integer value2) {
            addCriterion("int_clase_lic between", value1, value2, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_clase_licNotBetween(Integer value1, Integer value2) {
            addCriterion("int_clase_lic not between", value1, value2, "int_clase_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licIsNull() {
            addCriterion("int_categoria_lic is null");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licIsNotNull() {
            addCriterion("int_categoria_lic is not null");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licEqualTo(Integer value) {
            addCriterion("int_categoria_lic =", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licNotEqualTo(Integer value) {
            addCriterion("int_categoria_lic <>", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licGreaterThan(Integer value) {
            addCriterion("int_categoria_lic >", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_categoria_lic >=", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licLessThan(Integer value) {
            addCriterion("int_categoria_lic <", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licLessThanOrEqualTo(Integer value) {
            addCriterion("int_categoria_lic <=", value, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licIn(List<Integer> values) {
            addCriterion("int_categoria_lic in", values, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licNotIn(List<Integer> values) {
            addCriterion("int_categoria_lic not in", values, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licBetween(Integer value1, Integer value2) {
            addCriterion("int_categoria_lic between", value1, value2, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_categoria_licNotBetween(Integer value1, Integer value2) {
            addCriterion("int_categoria_lic not between", value1, value2, "int_categoria_lic");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoIsNull() {
            addCriterion("int_id_ubigeo_nacimiento is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoIsNotNull() {
            addCriterion("int_id_ubigeo_nacimiento is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoEqualTo(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento =", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoNotEqualTo(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento <>", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoGreaterThan(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento >", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento >=", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoLessThan(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento <", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_ubigeo_nacimiento <=", value, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoIn(List<Integer> values) {
            addCriterion("int_id_ubigeo_nacimiento in", values, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoNotIn(List<Integer> values) {
            addCriterion("int_id_ubigeo_nacimiento not in", values, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_ubigeo_nacimiento between", value1, value2, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andInt_id_ubigeo_nacimientoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_ubigeo_nacimiento not between", value1, value2, "int_id_ubigeo_nacimiento");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalIsNull() {
            addCriterion("var_email_principal is null");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalIsNotNull() {
            addCriterion("var_email_principal is not null");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalEqualTo(String value) {
            addCriterion("var_email_principal =", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalNotEqualTo(String value) {
            addCriterion("var_email_principal <>", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalGreaterThan(String value) {
            addCriterion("var_email_principal >", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalGreaterThanOrEqualTo(String value) {
            addCriterion("var_email_principal >=", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalLessThan(String value) {
            addCriterion("var_email_principal <", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalLessThanOrEqualTo(String value) {
            addCriterion("var_email_principal <=", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalLike(String value) {
            addCriterion("var_email_principal like", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalNotLike(String value) {
            addCriterion("var_email_principal not like", value, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalIn(List<String> values) {
            addCriterion("var_email_principal in", values, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalNotIn(List<String> values) {
            addCriterion("var_email_principal not in", values, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalBetween(String value1, String value2) {
            addCriterion("var_email_principal between", value1, value2, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_principalNotBetween(String value1, String value2) {
            addCriterion("var_email_principal not between", value1, value2, "var_email_principal");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioIsNull() {
            addCriterion("var_email_secundario is null");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioIsNotNull() {
            addCriterion("var_email_secundario is not null");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioEqualTo(String value) {
            addCriterion("var_email_secundario =", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioNotEqualTo(String value) {
            addCriterion("var_email_secundario <>", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioGreaterThan(String value) {
            addCriterion("var_email_secundario >", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioGreaterThanOrEqualTo(String value) {
            addCriterion("var_email_secundario >=", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioLessThan(String value) {
            addCriterion("var_email_secundario <", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioLessThanOrEqualTo(String value) {
            addCriterion("var_email_secundario <=", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioLike(String value) {
            addCriterion("var_email_secundario like", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioNotLike(String value) {
            addCriterion("var_email_secundario not like", value, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioIn(List<String> values) {
            addCriterion("var_email_secundario in", values, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioNotIn(List<String> values) {
            addCriterion("var_email_secundario not in", values, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioBetween(String value1, String value2) {
            addCriterion("var_email_secundario between", value1, value2, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_email_secundarioNotBetween(String value1, String value2) {
            addCriterion("var_email_secundario not between", value1, value2, "var_email_secundario");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoIsNull() {
            addCriterion("var_telefono is null");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoIsNotNull() {
            addCriterion("var_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoEqualTo(String value) {
            addCriterion("var_telefono =", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoNotEqualTo(String value) {
            addCriterion("var_telefono <>", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoGreaterThan(String value) {
            addCriterion("var_telefono >", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoGreaterThanOrEqualTo(String value) {
            addCriterion("var_telefono >=", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoLessThan(String value) {
            addCriterion("var_telefono <", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoLessThanOrEqualTo(String value) {
            addCriterion("var_telefono <=", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoLike(String value) {
            addCriterion("var_telefono like", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoNotLike(String value) {
            addCriterion("var_telefono not like", value, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoIn(List<String> values) {
            addCriterion("var_telefono in", values, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoNotIn(List<String> values) {
            addCriterion("var_telefono not in", values, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoBetween(String value1, String value2) {
            addCriterion("var_telefono between", value1, value2, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_telefonoNotBetween(String value1, String value2) {
            addCriterion("var_telefono not between", value1, value2, "var_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoIsNull() {
            addCriterion("var_codigo_ciudad_telefono is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoIsNotNull() {
            addCriterion("var_codigo_ciudad_telefono is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono =", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoNotEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono <>", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoGreaterThan(String value) {
            addCriterion("var_codigo_ciudad_telefono >", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoGreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono >=", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoLessThan(String value) {
            addCriterion("var_codigo_ciudad_telefono <", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoLessThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono <=", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoLike(String value) {
            addCriterion("var_codigo_ciudad_telefono like", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoNotLike(String value) {
            addCriterion("var_codigo_ciudad_telefono not like", value, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoIn(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono in", values, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoNotIn(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono not in", values, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoBetween(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono between", value1, value2, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefonoNotBetween(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono not between", value1, value2, "var_codigo_ciudad_telefono");
            return (Criteria) this;
        }

        public Criteria andVar_celularIsNull() {
            addCriterion("var_celular is null");
            return (Criteria) this;
        }

        public Criteria andVar_celularIsNotNull() {
            addCriterion("var_celular is not null");
            return (Criteria) this;
        }

        public Criteria andVar_celularEqualTo(String value) {
            addCriterion("var_celular =", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularNotEqualTo(String value) {
            addCriterion("var_celular <>", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularGreaterThan(String value) {
            addCriterion("var_celular >", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularGreaterThanOrEqualTo(String value) {
            addCriterion("var_celular >=", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularLessThan(String value) {
            addCriterion("var_celular <", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularLessThanOrEqualTo(String value) {
            addCriterion("var_celular <=", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularLike(String value) {
            addCriterion("var_celular like", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularNotLike(String value) {
            addCriterion("var_celular not like", value, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularIn(List<String> values) {
            addCriterion("var_celular in", values, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularNotIn(List<String> values) {
            addCriterion("var_celular not in", values, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularBetween(String value1, String value2) {
            addCriterion("var_celular between", value1, value2, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_celularNotBetween(String value1, String value2) {
            addCriterion("var_celular not between", value1, value2, "var_celular");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2IsNull() {
            addCriterion("var_codigo_ciudad_telefono2 is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2IsNotNull() {
            addCriterion("var_codigo_ciudad_telefono2 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2EqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono2 =", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2NotEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono2 <>", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2GreaterThan(String value) {
            addCriterion("var_codigo_ciudad_telefono2 >", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2GreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono2 >=", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2LessThan(String value) {
            addCriterion("var_codigo_ciudad_telefono2 <", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2LessThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono2 <=", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2Like(String value) {
            addCriterion("var_codigo_ciudad_telefono2 like", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2NotLike(String value) {
            addCriterion("var_codigo_ciudad_telefono2 not like", value, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2In(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono2 in", values, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2NotIn(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono2 not in", values, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2Between(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono2 between", value1, value2, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono2NotBetween(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono2 not between", value1, value2, "var_codigo_ciudad_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2IsNull() {
            addCriterion("var_telefono2 is null");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2IsNotNull() {
            addCriterion("var_telefono2 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2EqualTo(String value) {
            addCriterion("var_telefono2 =", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2NotEqualTo(String value) {
            addCriterion("var_telefono2 <>", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2GreaterThan(String value) {
            addCriterion("var_telefono2 >", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2GreaterThanOrEqualTo(String value) {
            addCriterion("var_telefono2 >=", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2LessThan(String value) {
            addCriterion("var_telefono2 <", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2LessThanOrEqualTo(String value) {
            addCriterion("var_telefono2 <=", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2Like(String value) {
            addCriterion("var_telefono2 like", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2NotLike(String value) {
            addCriterion("var_telefono2 not like", value, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2In(List<String> values) {
            addCriterion("var_telefono2 in", values, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2NotIn(List<String> values) {
            addCriterion("var_telefono2 not in", values, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2Between(String value1, String value2) {
            addCriterion("var_telefono2 between", value1, value2, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_telefono2NotBetween(String value1, String value2) {
            addCriterion("var_telefono2 not between", value1, value2, "var_telefono2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2IsNull() {
            addCriterion("var_celular2 is null");
            return (Criteria) this;
        }

        public Criteria andVar_celular2IsNotNull() {
            addCriterion("var_celular2 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_celular2EqualTo(String value) {
            addCriterion("var_celular2 =", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2NotEqualTo(String value) {
            addCriterion("var_celular2 <>", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2GreaterThan(String value) {
            addCriterion("var_celular2 >", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2GreaterThanOrEqualTo(String value) {
            addCriterion("var_celular2 >=", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2LessThan(String value) {
            addCriterion("var_celular2 <", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2LessThanOrEqualTo(String value) {
            addCriterion("var_celular2 <=", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2Like(String value) {
            addCriterion("var_celular2 like", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2NotLike(String value) {
            addCriterion("var_celular2 not like", value, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2In(List<String> values) {
            addCriterion("var_celular2 in", values, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2NotIn(List<String> values) {
            addCriterion("var_celular2 not in", values, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2Between(String value1, String value2) {
            addCriterion("var_celular2 between", value1, value2, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_celular2NotBetween(String value1, String value2) {
            addCriterion("var_celular2 not between", value1, value2, "var_celular2");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3IsNull() {
            addCriterion("var_codigo_ciudad_telefono3 is null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3IsNotNull() {
            addCriterion("var_codigo_ciudad_telefono3 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3EqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono3 =", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3NotEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono3 <>", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3GreaterThan(String value) {
            addCriterion("var_codigo_ciudad_telefono3 >", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3GreaterThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono3 >=", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3LessThan(String value) {
            addCriterion("var_codigo_ciudad_telefono3 <", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3LessThanOrEqualTo(String value) {
            addCriterion("var_codigo_ciudad_telefono3 <=", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3Like(String value) {
            addCriterion("var_codigo_ciudad_telefono3 like", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3NotLike(String value) {
            addCriterion("var_codigo_ciudad_telefono3 not like", value, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3In(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono3 in", values, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3NotIn(List<String> values) {
            addCriterion("var_codigo_ciudad_telefono3 not in", values, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3Between(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono3 between", value1, value2, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_codigo_ciudad_telefono3NotBetween(String value1, String value2) {
            addCriterion("var_codigo_ciudad_telefono3 not between", value1, value2, "var_codigo_ciudad_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3IsNull() {
            addCriterion("var_telefono3 is null");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3IsNotNull() {
            addCriterion("var_telefono3 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3EqualTo(String value) {
            addCriterion("var_telefono3 =", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3NotEqualTo(String value) {
            addCriterion("var_telefono3 <>", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3GreaterThan(String value) {
            addCriterion("var_telefono3 >", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3GreaterThanOrEqualTo(String value) {
            addCriterion("var_telefono3 >=", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3LessThan(String value) {
            addCriterion("var_telefono3 <", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3LessThanOrEqualTo(String value) {
            addCriterion("var_telefono3 <=", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3Like(String value) {
            addCriterion("var_telefono3 like", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3NotLike(String value) {
            addCriterion("var_telefono3 not like", value, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3In(List<String> values) {
            addCriterion("var_telefono3 in", values, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3NotIn(List<String> values) {
            addCriterion("var_telefono3 not in", values, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3Between(String value1, String value2) {
            addCriterion("var_telefono3 between", value1, value2, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_telefono3NotBetween(String value1, String value2) {
            addCriterion("var_telefono3 not between", value1, value2, "var_telefono3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3IsNull() {
            addCriterion("var_celular3 is null");
            return (Criteria) this;
        }

        public Criteria andVar_celular3IsNotNull() {
            addCriterion("var_celular3 is not null");
            return (Criteria) this;
        }

        public Criteria andVar_celular3EqualTo(String value) {
            addCriterion("var_celular3 =", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3NotEqualTo(String value) {
            addCriterion("var_celular3 <>", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3GreaterThan(String value) {
            addCriterion("var_celular3 >", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3GreaterThanOrEqualTo(String value) {
            addCriterion("var_celular3 >=", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3LessThan(String value) {
            addCriterion("var_celular3 <", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3LessThanOrEqualTo(String value) {
            addCriterion("var_celular3 <=", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3Like(String value) {
            addCriterion("var_celular3 like", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3NotLike(String value) {
            addCriterion("var_celular3 not like", value, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3In(List<String> values) {
            addCriterion("var_celular3 in", values, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3NotIn(List<String> values) {
            addCriterion("var_celular3 not in", values, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3Between(String value1, String value2) {
            addCriterion("var_celular3 between", value1, value2, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_celular3NotBetween(String value1, String value2) {
            addCriterion("var_celular3 not between", value1, value2, "var_celular3");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalIsNull() {
            addCriterion("var_resumen_profesional is null");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalIsNotNull() {
            addCriterion("var_resumen_profesional is not null");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalEqualTo(String value) {
            addCriterion("var_resumen_profesional =", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalNotEqualTo(String value) {
            addCriterion("var_resumen_profesional <>", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalGreaterThan(String value) {
            addCriterion("var_resumen_profesional >", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalGreaterThanOrEqualTo(String value) {
            addCriterion("var_resumen_profesional >=", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalLessThan(String value) {
            addCriterion("var_resumen_profesional <", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalLessThanOrEqualTo(String value) {
            addCriterion("var_resumen_profesional <=", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalLike(String value) {
            addCriterion("var_resumen_profesional like", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalNotLike(String value) {
            addCriterion("var_resumen_profesional not like", value, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalIn(List<String> values) {
            addCriterion("var_resumen_profesional in", values, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalNotIn(List<String> values) {
            addCriterion("var_resumen_profesional not in", values, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalBetween(String value1, String value2) {
            addCriterion("var_resumen_profesional between", value1, value2, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andVar_resumen_profesionalNotBetween(String value1, String value2) {
            addCriterion("var_resumen_profesional not between", value1, value2, "var_resumen_profesional");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaIsNull() {
            addCriterion("int_persona_discapacitada is null");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaIsNotNull() {
            addCriterion("int_persona_discapacitada is not null");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaEqualTo(Integer value) {
            addCriterion("int_persona_discapacitada =", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaNotEqualTo(Integer value) {
            addCriterion("int_persona_discapacitada <>", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaGreaterThan(Integer value) {
            addCriterion("int_persona_discapacitada >", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_persona_discapacitada >=", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaLessThan(Integer value) {
            addCriterion("int_persona_discapacitada <", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaLessThanOrEqualTo(Integer value) {
            addCriterion("int_persona_discapacitada <=", value, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaIn(List<Integer> values) {
            addCriterion("int_persona_discapacitada in", values, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaNotIn(List<Integer> values) {
            addCriterion("int_persona_discapacitada not in", values, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaBetween(Integer value1, Integer value2) {
            addCriterion("int_persona_discapacitada between", value1, value2, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_persona_discapacitadaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_persona_discapacitada not between", value1, value2, "int_persona_discapacitada");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaIsNull() {
            addCriterion("int_pertenece_ffaa is null");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaIsNotNull() {
            addCriterion("int_pertenece_ffaa is not null");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaEqualTo(Integer value) {
            addCriterion("int_pertenece_ffaa =", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaNotEqualTo(Integer value) {
            addCriterion("int_pertenece_ffaa <>", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaGreaterThan(Integer value) {
            addCriterion("int_pertenece_ffaa >", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_pertenece_ffaa >=", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaLessThan(Integer value) {
            addCriterion("int_pertenece_ffaa <", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaLessThanOrEqualTo(Integer value) {
            addCriterion("int_pertenece_ffaa <=", value, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaIn(List<Integer> values) {
            addCriterion("int_pertenece_ffaa in", values, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaNotIn(List<Integer> values) {
            addCriterion("int_pertenece_ffaa not in", values, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaBetween(Integer value1, Integer value2) {
            addCriterion("int_pertenece_ffaa between", value1, value2, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_pertenece_ffaaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_pertenece_ffaa not between", value1, value2, "int_pertenece_ffaa");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaIsNull() {
            addCriterion("int_culmino_edu_prima is null");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaIsNotNull() {
            addCriterion("int_culmino_edu_prima is not null");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaEqualTo(Integer value) {
            addCriterion("int_culmino_edu_prima =", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaNotEqualTo(Integer value) {
            addCriterion("int_culmino_edu_prima <>", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaGreaterThan(Integer value) {
            addCriterion("int_culmino_edu_prima >", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_culmino_edu_prima >=", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaLessThan(Integer value) {
            addCriterion("int_culmino_edu_prima <", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaLessThanOrEqualTo(Integer value) {
            addCriterion("int_culmino_edu_prima <=", value, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaIn(List<Integer> values) {
            addCriterion("int_culmino_edu_prima in", values, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaNotIn(List<Integer> values) {
            addCriterion("int_culmino_edu_prima not in", values, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaBetween(Integer value1, Integer value2) {
            addCriterion("int_culmino_edu_prima between", value1, value2, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_primaNotBetween(Integer value1, Integer value2) {
            addCriterion("int_culmino_edu_prima not between", value1, value2, "int_culmino_edu_prima");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunIsNull() {
            addCriterion("int_culmino_edu_secun is null");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunIsNotNull() {
            addCriterion("int_culmino_edu_secun is not null");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunEqualTo(Integer value) {
            addCriterion("int_culmino_edu_secun =", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunNotEqualTo(Integer value) {
            addCriterion("int_culmino_edu_secun <>", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunGreaterThan(Integer value) {
            addCriterion("int_culmino_edu_secun >", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_culmino_edu_secun >=", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunLessThan(Integer value) {
            addCriterion("int_culmino_edu_secun <", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunLessThanOrEqualTo(Integer value) {
            addCriterion("int_culmino_edu_secun <=", value, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunIn(List<Integer> values) {
            addCriterion("int_culmino_edu_secun in", values, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunNotIn(List<Integer> values) {
            addCriterion("int_culmino_edu_secun not in", values, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunBetween(Integer value1, Integer value2) {
            addCriterion("int_culmino_edu_secun between", value1, value2, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andInt_culmino_edu_secunNotBetween(Integer value1, Integer value2) {
            addCriterion("int_culmino_edu_secun not between", value1, value2, "int_culmino_edu_secun");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroIsNull() {
            addCriterion("var_observacion_registro is null");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroIsNotNull() {
            addCriterion("var_observacion_registro is not null");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroEqualTo(String value) {
            addCriterion("var_observacion_registro =", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroNotEqualTo(String value) {
            addCriterion("var_observacion_registro <>", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroGreaterThan(String value) {
            addCriterion("var_observacion_registro >", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroGreaterThanOrEqualTo(String value) {
            addCriterion("var_observacion_registro >=", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroLessThan(String value) {
            addCriterion("var_observacion_registro <", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroLessThanOrEqualTo(String value) {
            addCriterion("var_observacion_registro <=", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroLike(String value) {
            addCriterion("var_observacion_registro like", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroNotLike(String value) {
            addCriterion("var_observacion_registro not like", value, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroIn(List<String> values) {
            addCriterion("var_observacion_registro in", values, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroNotIn(List<String> values) {
            addCriterion("var_observacion_registro not in", values, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroBetween(String value1, String value2) {
            addCriterion("var_observacion_registro between", value1, value2, "var_observacion_registro");
            return (Criteria) this;
        }

        public Criteria andVar_observacion_registroNotBetween(String value1, String value2) {
            addCriterion("var_observacion_registro not between", value1, value2, "var_observacion_registro");
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