package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPersonanaturalFormacionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPersonanaturalFormacionExample() {
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

        public Criteria andSrl_id_personanatural_formacionIsNull() {
            addCriterion("srl_id_personanatural_formacion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionIsNotNull() {
            addCriterion("srl_id_personanatural_formacion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_formacion =", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionNotEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_formacion <>", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionGreaterThan(Integer value) {
            addCriterion("srl_id_personanatural_formacion >", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_formacion >=", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionLessThan(Integer value) {
            addCriterion("srl_id_personanatural_formacion <", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_personanatural_formacion <=", value, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionIn(List<Integer> values) {
            addCriterion("srl_id_personanatural_formacion in", values, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionNotIn(List<Integer> values) {
            addCriterion("srl_id_personanatural_formacion not in", values, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personanatural_formacion between", value1, value2, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_personanatural_formacionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_personanatural_formacion not between", value1, value2, "srl_id_personanatural_formacion");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNull() {
            addCriterion("idpersonanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIsNotNull() {
            addCriterion("idpersonanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalEqualTo(Integer value) {
            addCriterion("idpersonanatural =", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotEqualTo(Integer value) {
            addCriterion("idpersonanatural <>", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThan(Integer value) {
            addCriterion("idpersonanatural >", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural >=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThan(Integer value) {
            addCriterion("idpersonanatural <", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonanatural <=", value, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalIn(List<Integer> values) {
            addCriterion("idpersonanatural in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotIn(List<Integer> values) {
            addCriterion("idpersonanatural not in", values, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andIdpersonanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonanatural not between", value1, value2, "idpersonanatural");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIsNull() {
            addCriterion("srl_id_tipo_profesion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIsNotNull() {
            addCriterion("srl_id_tipo_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion =", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion <>", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionGreaterThan(Integer value) {
            addCriterion("srl_id_tipo_profesion >", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion >=", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionLessThan(Integer value) {
            addCriterion("srl_id_tipo_profesion <", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_tipo_profesion <=", value, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionIn(List<Integer> values) {
            addCriterion("srl_id_tipo_profesion in", values, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotIn(List<Integer> values) {
            addCriterion("srl_id_tipo_profesion not in", values, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_profesion between", value1, value2, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_tipo_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_tipo_profesion not between", value1, value2, "srl_id_tipo_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalIsNull() {
            addCriterion("srl_id_grupo_ocupacional is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalIsNotNull() {
            addCriterion("srl_id_grupo_ocupacional is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional =", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <>", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalGreaterThan(Integer value) {
            addCriterion("srl_id_grupo_ocupacional >", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional >=", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalLessThan(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_grupo_ocupacional <=", value, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalIn(List<Integer> values) {
            addCriterion("srl_id_grupo_ocupacional in", values, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotIn(List<Integer> values) {
            addCriterion("srl_id_grupo_ocupacional not in", values, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_grupo_ocupacional between", value1, value2, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_grupo_ocupacionalNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_grupo_ocupacional not between", value1, value2, "srl_id_grupo_ocupacional");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioIsNull() {
            addCriterion("srl_id_nivel_estudio is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioIsNotNull() {
            addCriterion("srl_id_nivel_estudio is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio =", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio <>", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioGreaterThan(Integer value) {
            addCriterion("srl_id_nivel_estudio >", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio >=", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioLessThan(Integer value) {
            addCriterion("srl_id_nivel_estudio <", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_nivel_estudio <=", value, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioIn(List<Integer> values) {
            addCriterion("srl_id_nivel_estudio in", values, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotIn(List<Integer> values) {
            addCriterion("srl_id_nivel_estudio not in", values, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_estudio between", value1, value2, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andSrl_id_nivel_estudioNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_nivel_estudio not between", value1, value2, "srl_id_nivel_estudio");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionIsNull() {
            addCriterion("int_tipo_formacion is null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionIsNotNull() {
            addCriterion("int_tipo_formacion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionEqualTo(Integer value) {
            addCriterion("int_tipo_formacion =", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionNotEqualTo(Integer value) {
            addCriterion("int_tipo_formacion <>", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionGreaterThan(Integer value) {
            addCriterion("int_tipo_formacion >", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_formacion >=", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionLessThan(Integer value) {
            addCriterion("int_tipo_formacion <", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionLessThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_formacion <=", value, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionIn(List<Integer> values) {
            addCriterion("int_tipo_formacion in", values, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionNotIn(List<Integer> values) {
            addCriterion("int_tipo_formacion not in", values, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_formacion between", value1, value2, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_formacionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_formacion not between", value1, value2, "int_tipo_formacion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionIsNull() {
            addCriterion("var_descripcion_institucion is null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionIsNotNull() {
            addCriterion("var_descripcion_institucion is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionEqualTo(String value) {
            addCriterion("var_descripcion_institucion =", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionNotEqualTo(String value) {
            addCriterion("var_descripcion_institucion <>", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionGreaterThan(String value) {
            addCriterion("var_descripcion_institucion >", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionGreaterThanOrEqualTo(String value) {
            addCriterion("var_descripcion_institucion >=", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionLessThan(String value) {
            addCriterion("var_descripcion_institucion <", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionLessThanOrEqualTo(String value) {
            addCriterion("var_descripcion_institucion <=", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionLike(String value) {
            addCriterion("var_descripcion_institucion like", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionNotLike(String value) {
            addCriterion("var_descripcion_institucion not like", value, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionIn(List<String> values) {
            addCriterion("var_descripcion_institucion in", values, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionNotIn(List<String> values) {
            addCriterion("var_descripcion_institucion not in", values, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionBetween(String value1, String value2) {
            addCriterion("var_descripcion_institucion between", value1, value2, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descripcion_institucionNotBetween(String value1, String value2) {
            addCriterion("var_descripcion_institucion not between", value1, value2, "var_descripcion_institucion");
            return (Criteria) this;
        }

        public Criteria andIdpaisIsNull() {
            addCriterion("idpais is null");
            return (Criteria) this;
        }

        public Criteria andIdpaisIsNotNull() {
            addCriterion("idpais is not null");
            return (Criteria) this;
        }

        public Criteria andIdpaisEqualTo(Integer value) {
            addCriterion("idpais =", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotEqualTo(Integer value) {
            addCriterion("idpais <>", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisGreaterThan(Integer value) {
            addCriterion("idpais >", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpais >=", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisLessThan(Integer value) {
            addCriterion("idpais <", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisLessThanOrEqualTo(Integer value) {
            addCriterion("idpais <=", value, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisIn(List<Integer> values) {
            addCriterion("idpais in", values, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotIn(List<Integer> values) {
            addCriterion("idpais not in", values, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisBetween(Integer value1, Integer value2) {
            addCriterion("idpais between", value1, value2, "idpais");
            return (Criteria) this;
        }

        public Criteria andIdpaisNotBetween(Integer value1, Integer value2) {
            addCriterion("idpais not between", value1, value2, "idpais");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoIsNull() {
            addCriterion("dte_fecha_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoIsNotNull() {
            addCriterion("dte_fecha_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso =", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso <>", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso >", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso >=", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso <", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_ingreso <=", value, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_ingreso in", values, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_ingreso not in", values, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_ingreso between", value1, value2, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_ingresoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_ingreso not between", value1, value2, "dte_fecha_ingreso");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionIsNull() {
            addCriterion("dte_fecha_culminacion is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionIsNotNull() {
            addCriterion("dte_fecha_culminacion is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion =", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion <>", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion >", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion >=", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion <", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_culminacion <=", value, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_culminacion in", values, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_culminacion not in", values, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_culminacion between", value1, value2, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_culminacionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_culminacion not between", value1, value2, "dte_fecha_culminacion");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosIsNull() {
            addCriterion("int_sigue_estudios is null");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosIsNotNull() {
            addCriterion("int_sigue_estudios is not null");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosEqualTo(Integer value) {
            addCriterion("int_sigue_estudios =", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosNotEqualTo(Integer value) {
            addCriterion("int_sigue_estudios <>", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosGreaterThan(Integer value) {
            addCriterion("int_sigue_estudios >", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_sigue_estudios >=", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosLessThan(Integer value) {
            addCriterion("int_sigue_estudios <", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosLessThanOrEqualTo(Integer value) {
            addCriterion("int_sigue_estudios <=", value, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosIn(List<Integer> values) {
            addCriterion("int_sigue_estudios in", values, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosNotIn(List<Integer> values) {
            addCriterion("int_sigue_estudios not in", values, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosBetween(Integer value1, Integer value2) {
            addCriterion("int_sigue_estudios between", value1, value2, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andInt_sigue_estudiosNotBetween(Integer value1, Integer value2) {
            addCriterion("int_sigue_estudios not between", value1, value2, "int_sigue_estudios");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIsNull() {
            addCriterion("srl_id_profesion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIsNotNull() {
            addCriterion("srl_id_profesion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionEqualTo(Integer value) {
            addCriterion("srl_id_profesion =", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotEqualTo(Integer value) {
            addCriterion("srl_id_profesion <>", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThan(Integer value) {
            addCriterion("srl_id_profesion >", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion >=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThan(Integer value) {
            addCriterion("srl_id_profesion <", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_profesion <=", value, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionIn(List<Integer> values) {
            addCriterion("srl_id_profesion in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotIn(List<Integer> values) {
            addCriterion("srl_id_profesion not in", values, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion between", value1, value2, "srl_id_profesion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_profesionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_profesion not between", value1, value2, "srl_id_profesion");
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