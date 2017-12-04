package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonaExample() {
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

        public Criteria andId_personaIsNull() {
            addCriterion("id_persona is null");
            return (Criteria) this;
        }

        public Criteria andId_personaIsNotNull() {
            addCriterion("id_persona is not null");
            return (Criteria) this;
        }

        public Criteria andId_personaEqualTo(Integer value) {
            addCriterion("id_persona =", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaNotEqualTo(Integer value) {
            addCriterion("id_persona <>", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaGreaterThan(Integer value) {
            addCriterion("id_persona >", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_persona >=", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaLessThan(Integer value) {
            addCriterion("id_persona <", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaLessThanOrEqualTo(Integer value) {
            addCriterion("id_persona <=", value, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaIn(List<Integer> values) {
            addCriterion("id_persona in", values, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaNotIn(List<Integer> values) {
            addCriterion("id_persona not in", values, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaBetween(Integer value1, Integer value2) {
            addCriterion("id_persona between", value1, value2, "id_persona");
            return (Criteria) this;
        }

        public Criteria andId_personaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_persona not between", value1, value2, "id_persona");
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

        public Criteria andRazon_socialIsNull() {
            addCriterion("razon_social is null");
            return (Criteria) this;
        }

        public Criteria andRazon_socialIsNotNull() {
            addCriterion("razon_social is not null");
            return (Criteria) this;
        }

        public Criteria andRazon_socialEqualTo(String value) {
            addCriterion("razon_social =", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialNotEqualTo(String value) {
            addCriterion("razon_social <>", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialGreaterThan(String value) {
            addCriterion("razon_social >", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialGreaterThanOrEqualTo(String value) {
            addCriterion("razon_social >=", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialLessThan(String value) {
            addCriterion("razon_social <", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialLessThanOrEqualTo(String value) {
            addCriterion("razon_social <=", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialLike(String value) {
            addCriterion("razon_social like", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialNotLike(String value) {
            addCriterion("razon_social not like", value, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialIn(List<String> values) {
            addCriterion("razon_social in", values, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialNotIn(List<String> values) {
            addCriterion("razon_social not in", values, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialBetween(String value1, String value2) {
            addCriterion("razon_social between", value1, value2, "razon_social");
            return (Criteria) this;
        }

        public Criteria andRazon_socialNotBetween(String value1, String value2) {
            addCriterion("razon_social not between", value1, value2, "razon_social");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docIsNull() {
            addCriterion("id_tipo_doc is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docIsNotNull() {
            addCriterion("id_tipo_doc is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docEqualTo(Integer value) {
            addCriterion("id_tipo_doc =", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docNotEqualTo(Integer value) {
            addCriterion("id_tipo_doc <>", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docGreaterThan(Integer value) {
            addCriterion("id_tipo_doc >", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_doc >=", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docLessThan(Integer value) {
            addCriterion("id_tipo_doc <", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_doc <=", value, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docIn(List<Integer> values) {
            addCriterion("id_tipo_doc in", values, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docNotIn(List<Integer> values) {
            addCriterion("id_tipo_doc not in", values, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_doc between", value1, value2, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andId_tipo_docNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_doc not between", value1, value2, "id_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docIsNull() {
            addCriterion("num_tipo_doc is null");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docIsNotNull() {
            addCriterion("num_tipo_doc is not null");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docEqualTo(String value) {
            addCriterion("num_tipo_doc =", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docNotEqualTo(String value) {
            addCriterion("num_tipo_doc <>", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docGreaterThan(String value) {
            addCriterion("num_tipo_doc >", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docGreaterThanOrEqualTo(String value) {
            addCriterion("num_tipo_doc >=", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docLessThan(String value) {
            addCriterion("num_tipo_doc <", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docLessThanOrEqualTo(String value) {
            addCriterion("num_tipo_doc <=", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docLike(String value) {
            addCriterion("num_tipo_doc like", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docNotLike(String value) {
            addCriterion("num_tipo_doc not like", value, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docIn(List<String> values) {
            addCriterion("num_tipo_doc in", values, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docNotIn(List<String> values) {
            addCriterion("num_tipo_doc not in", values, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docBetween(String value1, String value2) {
            addCriterion("num_tipo_doc between", value1, value2, "num_tipo_doc");
            return (Criteria) this;
        }

        public Criteria andNum_tipo_docNotBetween(String value1, String value2) {
            addCriterion("num_tipo_doc not between", value1, value2, "num_tipo_doc");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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