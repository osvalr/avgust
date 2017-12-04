package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonanaturalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonanaturalExample() {
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

        public Criteria andIdpersonaIsNull() {
            addCriterion("idpersona is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonaIsNotNull() {
            addCriterion("idpersona is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonaEqualTo(Integer value) {
            addCriterion("idpersona =", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaNotEqualTo(Integer value) {
            addCriterion("idpersona <>", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaGreaterThan(Integer value) {
            addCriterion("idpersona >", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersona >=", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaLessThan(Integer value) {
            addCriterion("idpersona <", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaLessThanOrEqualTo(Integer value) {
            addCriterion("idpersona <=", value, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaIn(List<Integer> values) {
            addCriterion("idpersona in", values, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaNotIn(List<Integer> values) {
            addCriterion("idpersona not in", values, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaBetween(Integer value1, Integer value2) {
            addCriterion("idpersona between", value1, value2, "idpersona");
            return (Criteria) this;
        }

        public Criteria andIdpersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersona not between", value1, value2, "idpersona");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andApepatIsNull() {
            addCriterion("apepat is null");
            return (Criteria) this;
        }

        public Criteria andApepatIsNotNull() {
            addCriterion("apepat is not null");
            return (Criteria) this;
        }

        public Criteria andApepatEqualTo(String value) {
            addCriterion("apepat =", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatNotEqualTo(String value) {
            addCriterion("apepat <>", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatGreaterThan(String value) {
            addCriterion("apepat >", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatGreaterThanOrEqualTo(String value) {
            addCriterion("apepat >=", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatLessThan(String value) {
            addCriterion("apepat <", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatLessThanOrEqualTo(String value) {
            addCriterion("apepat <=", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatLike(String value) {
            addCriterion("apepat like", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatNotLike(String value) {
            addCriterion("apepat not like", value, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatIn(List<String> values) {
            addCriterion("apepat in", values, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatNotIn(List<String> values) {
            addCriterion("apepat not in", values, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatBetween(String value1, String value2) {
            addCriterion("apepat between", value1, value2, "apepat");
            return (Criteria) this;
        }

        public Criteria andApepatNotBetween(String value1, String value2) {
            addCriterion("apepat not between", value1, value2, "apepat");
            return (Criteria) this;
        }

        public Criteria andApematIsNull() {
            addCriterion("apemat is null");
            return (Criteria) this;
        }

        public Criteria andApematIsNotNull() {
            addCriterion("apemat is not null");
            return (Criteria) this;
        }

        public Criteria andApematEqualTo(String value) {
            addCriterion("apemat =", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematNotEqualTo(String value) {
            addCriterion("apemat <>", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematGreaterThan(String value) {
            addCriterion("apemat >", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematGreaterThanOrEqualTo(String value) {
            addCriterion("apemat >=", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematLessThan(String value) {
            addCriterion("apemat <", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematLessThanOrEqualTo(String value) {
            addCriterion("apemat <=", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematLike(String value) {
            addCriterion("apemat like", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematNotLike(String value) {
            addCriterion("apemat not like", value, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematIn(List<String> values) {
            addCriterion("apemat in", values, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematNotIn(List<String> values) {
            addCriterion("apemat not in", values, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematBetween(String value1, String value2) {
            addCriterion("apemat between", value1, value2, "apemat");
            return (Criteria) this;
        }

        public Criteria andApematNotBetween(String value1, String value2) {
            addCriterion("apemat not between", value1, value2, "apemat");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoIsNull() {
            addCriterion("idtipodocumento is null");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoIsNotNull() {
            addCriterion("idtipodocumento is not null");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoEqualTo(Integer value) {
            addCriterion("idtipodocumento =", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoNotEqualTo(Integer value) {
            addCriterion("idtipodocumento <>", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoGreaterThan(Integer value) {
            addCriterion("idtipodocumento >", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idtipodocumento >=", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoLessThan(Integer value) {
            addCriterion("idtipodocumento <", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoLessThanOrEqualTo(Integer value) {
            addCriterion("idtipodocumento <=", value, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoIn(List<Integer> values) {
            addCriterion("idtipodocumento in", values, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoNotIn(List<Integer> values) {
            addCriterion("idtipodocumento not in", values, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoBetween(Integer value1, Integer value2) {
            addCriterion("idtipodocumento between", value1, value2, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andIdtipodocumentoNotBetween(Integer value1, Integer value2) {
            addCriterion("idtipodocumento not between", value1, value2, "idtipodocumento");
            return (Criteria) this;
        }

        public Criteria andNumerodocIsNull() {
            addCriterion("numerodoc is null");
            return (Criteria) this;
        }

        public Criteria andNumerodocIsNotNull() {
            addCriterion("numerodoc is not null");
            return (Criteria) this;
        }

        public Criteria andNumerodocEqualTo(String value) {
            addCriterion("numerodoc =", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocNotEqualTo(String value) {
            addCriterion("numerodoc <>", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocGreaterThan(String value) {
            addCriterion("numerodoc >", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocGreaterThanOrEqualTo(String value) {
            addCriterion("numerodoc >=", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocLessThan(String value) {
            addCriterion("numerodoc <", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocLessThanOrEqualTo(String value) {
            addCriterion("numerodoc <=", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocLike(String value) {
            addCriterion("numerodoc like", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocNotLike(String value) {
            addCriterion("numerodoc not like", value, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocIn(List<String> values) {
            addCriterion("numerodoc in", values, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocNotIn(List<String> values) {
            addCriterion("numerodoc not in", values, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocBetween(String value1, String value2) {
            addCriterion("numerodoc between", value1, value2, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andNumerodocNotBetween(String value1, String value2) {
            addCriterion("numerodoc not between", value1, value2, "numerodoc");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoIsNull() {
            addCriterion("fechanacimiento is null");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoIsNotNull() {
            addCriterion("fechanacimiento is not null");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoEqualTo(Date value) {
            addCriterionForJDBCDate("fechanacimiento =", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fechanacimiento <>", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoGreaterThan(Date value) {
            addCriterionForJDBCDate("fechanacimiento >", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fechanacimiento >=", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoLessThan(Date value) {
            addCriterionForJDBCDate("fechanacimiento <", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fechanacimiento <=", value, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoIn(List<Date> values) {
            addCriterionForJDBCDate("fechanacimiento in", values, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fechanacimiento not in", values, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fechanacimiento between", value1, value2, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andFechanacimientoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fechanacimiento not between", value1, value2, "fechanacimiento");
            return (Criteria) this;
        }

        public Criteria andIdsexoIsNull() {
            addCriterion("idsexo is null");
            return (Criteria) this;
        }

        public Criteria andIdsexoIsNotNull() {
            addCriterion("idsexo is not null");
            return (Criteria) this;
        }

        public Criteria andIdsexoEqualTo(Integer value) {
            addCriterion("idsexo =", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoNotEqualTo(Integer value) {
            addCriterion("idsexo <>", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoGreaterThan(Integer value) {
            addCriterion("idsexo >", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idsexo >=", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoLessThan(Integer value) {
            addCriterion("idsexo <", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoLessThanOrEqualTo(Integer value) {
            addCriterion("idsexo <=", value, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoIn(List<Integer> values) {
            addCriterion("idsexo in", values, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoNotIn(List<Integer> values) {
            addCriterion("idsexo not in", values, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoBetween(Integer value1, Integer value2) {
            addCriterion("idsexo between", value1, value2, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdsexoNotBetween(Integer value1, Integer value2) {
            addCriterion("idsexo not between", value1, value2, "idsexo");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilIsNull() {
            addCriterion("idestadocivil is null");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilIsNotNull() {
            addCriterion("idestadocivil is not null");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilEqualTo(Integer value) {
            addCriterion("idestadocivil =", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilNotEqualTo(Integer value) {
            addCriterion("idestadocivil <>", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilGreaterThan(Integer value) {
            addCriterion("idestadocivil >", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilGreaterThanOrEqualTo(Integer value) {
            addCriterion("idestadocivil >=", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilLessThan(Integer value) {
            addCriterion("idestadocivil <", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilLessThanOrEqualTo(Integer value) {
            addCriterion("idestadocivil <=", value, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilIn(List<Integer> values) {
            addCriterion("idestadocivil in", values, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilNotIn(List<Integer> values) {
            addCriterion("idestadocivil not in", values, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilBetween(Integer value1, Integer value2) {
            addCriterion("idestadocivil between", value1, value2, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andIdestadocivilNotBetween(Integer value1, Integer value2) {
            addCriterion("idestadocivil not between", value1, value2, "idestadocivil");
            return (Criteria) this;
        }

        public Criteria andTemporalIsNull() {
            addCriterion("temporal is null");
            return (Criteria) this;
        }

        public Criteria andTemporalIsNotNull() {
            addCriterion("temporal is not null");
            return (Criteria) this;
        }

        public Criteria andTemporalEqualTo(Integer value) {
            addCriterion("temporal =", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalNotEqualTo(Integer value) {
            addCriterion("temporal <>", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalGreaterThan(Integer value) {
            addCriterion("temporal >", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalGreaterThanOrEqualTo(Integer value) {
            addCriterion("temporal >=", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalLessThan(Integer value) {
            addCriterion("temporal <", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalLessThanOrEqualTo(Integer value) {
            addCriterion("temporal <=", value, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalIn(List<Integer> values) {
            addCriterion("temporal in", values, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalNotIn(List<Integer> values) {
            addCriterion("temporal not in", values, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalBetween(Integer value1, Integer value2) {
            addCriterion("temporal between", value1, value2, "temporal");
            return (Criteria) this;
        }

        public Criteria andTemporalNotBetween(Integer value1, Integer value2) {
            addCriterion("temporal not between", value1, value2, "temporal");
            return (Criteria) this;
        }

        public Criteria andRucIsNull() {
            addCriterion("ruc is null");
            return (Criteria) this;
        }

        public Criteria andRucIsNotNull() {
            addCriterion("ruc is not null");
            return (Criteria) this;
        }

        public Criteria andRucEqualTo(String value) {
            addCriterion("ruc =", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucNotEqualTo(String value) {
            addCriterion("ruc <>", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucGreaterThan(String value) {
            addCriterion("ruc >", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucGreaterThanOrEqualTo(String value) {
            addCriterion("ruc >=", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucLessThan(String value) {
            addCriterion("ruc <", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucLessThanOrEqualTo(String value) {
            addCriterion("ruc <=", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucLike(String value) {
            addCriterion("ruc like", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucNotLike(String value) {
            addCriterion("ruc not like", value, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucIn(List<String> values) {
            addCriterion("ruc in", values, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucNotIn(List<String> values) {
            addCriterion("ruc not in", values, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucBetween(String value1, String value2) {
            addCriterion("ruc between", value1, value2, "ruc");
            return (Criteria) this;
        }

        public Criteria andRucNotBetween(String value1, String value2) {
            addCriterion("ruc not between", value1, value2, "ruc");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNull() {
            addCriterion("direccion is null");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNotNull() {
            addCriterion("direccion is not null");
            return (Criteria) this;
        }

        public Criteria andDireccionEqualTo(String value) {
            addCriterion("direccion =", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotEqualTo(String value) {
            addCriterion("direccion <>", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThan(String value) {
            addCriterion("direccion >", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThanOrEqualTo(String value) {
            addCriterion("direccion >=", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThan(String value) {
            addCriterion("direccion <", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThanOrEqualTo(String value) {
            addCriterion("direccion <=", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLike(String value) {
            addCriterion("direccion like", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotLike(String value) {
            addCriterion("direccion not like", value, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionIn(List<String> values) {
            addCriterion("direccion in", values, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotIn(List<String> values) {
            addCriterion("direccion not in", values, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionBetween(String value1, String value2) {
            addCriterion("direccion between", value1, value2, "direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotBetween(String value1, String value2) {
            addCriterion("direccion not between", value1, value2, "direccion");
            return (Criteria) this;
        }

        public Criteria andIdubigeoIsNull() {
            addCriterion("idubigeo is null");
            return (Criteria) this;
        }

        public Criteria andIdubigeoIsNotNull() {
            addCriterion("idubigeo is not null");
            return (Criteria) this;
        }

        public Criteria andIdubigeoEqualTo(Integer value) {
            addCriterion("idubigeo =", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotEqualTo(Integer value) {
            addCriterion("idubigeo <>", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoGreaterThan(Integer value) {
            addCriterion("idubigeo >", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idubigeo >=", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoLessThan(Integer value) {
            addCriterion("idubigeo <", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoLessThanOrEqualTo(Integer value) {
            addCriterion("idubigeo <=", value, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoIn(List<Integer> values) {
            addCriterion("idubigeo in", values, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotIn(List<Integer> values) {
            addCriterion("idubigeo not in", values, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoBetween(Integer value1, Integer value2) {
            addCriterion("idubigeo between", value1, value2, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andIdubigeoNotBetween(Integer value1, Integer value2) {
            addCriterion("idubigeo not between", value1, value2, "idubigeo");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileIsNull() {
            addCriterion("var_num_file is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileIsNotNull() {
            addCriterion("var_num_file is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileEqualTo(String value) {
            addCriterion("var_num_file =", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotEqualTo(String value) {
            addCriterion("var_num_file <>", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileGreaterThan(String value) {
            addCriterion("var_num_file >", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_file >=", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLessThan(String value) {
            addCriterion("var_num_file <", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLessThanOrEqualTo(String value) {
            addCriterion("var_num_file <=", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileLike(String value) {
            addCriterion("var_num_file like", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotLike(String value) {
            addCriterion("var_num_file not like", value, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileIn(List<String> values) {
            addCriterion("var_num_file in", values, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotIn(List<String> values) {
            addCriterion("var_num_file not in", values, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileBetween(String value1, String value2) {
            addCriterion("var_num_file between", value1, value2, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_fileNotBetween(String value1, String value2) {
            addCriterion("var_num_file not between", value1, value2, "var_num_file");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIsNull() {
            addCriterion("var_num_caja is null");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIsNotNull() {
            addCriterion("var_num_caja is not null");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaEqualTo(String value) {
            addCriterion("var_num_caja =", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotEqualTo(String value) {
            addCriterion("var_num_caja <>", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaGreaterThan(String value) {
            addCriterion("var_num_caja >", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaGreaterThanOrEqualTo(String value) {
            addCriterion("var_num_caja >=", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLessThan(String value) {
            addCriterion("var_num_caja <", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLessThanOrEqualTo(String value) {
            addCriterion("var_num_caja <=", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaLike(String value) {
            addCriterion("var_num_caja like", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotLike(String value) {
            addCriterion("var_num_caja not like", value, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaIn(List<String> values) {
            addCriterion("var_num_caja in", values, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotIn(List<String> values) {
            addCriterion("var_num_caja not in", values, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaBetween(String value1, String value2) {
            addCriterion("var_num_caja between", value1, value2, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_num_cajaNotBetween(String value1, String value2) {
            addCriterion("var_num_caja not between", value1, value2, "var_num_caja");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteIsNull() {
            addCriterion("var_numero_pasaporte is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteIsNotNull() {
            addCriterion("var_numero_pasaporte is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteEqualTo(String value) {
            addCriterion("var_numero_pasaporte =", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteNotEqualTo(String value) {
            addCriterion("var_numero_pasaporte <>", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteGreaterThan(String value) {
            addCriterion("var_numero_pasaporte >", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_pasaporte >=", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteLessThan(String value) {
            addCriterion("var_numero_pasaporte <", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteLessThanOrEqualTo(String value) {
            addCriterion("var_numero_pasaporte <=", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteLike(String value) {
            addCriterion("var_numero_pasaporte like", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteNotLike(String value) {
            addCriterion("var_numero_pasaporte not like", value, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteIn(List<String> values) {
            addCriterion("var_numero_pasaporte in", values, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteNotIn(List<String> values) {
            addCriterion("var_numero_pasaporte not in", values, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteBetween(String value1, String value2) {
            addCriterion("var_numero_pasaporte between", value1, value2, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_pasaporteNotBetween(String value1, String value2) {
            addCriterion("var_numero_pasaporte not between", value1, value2, "var_numero_pasaporte");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteIsNull() {
            addCriterion("var_numero_brevete is null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteIsNotNull() {
            addCriterion("var_numero_brevete is not null");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteEqualTo(String value) {
            addCriterion("var_numero_brevete =", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteNotEqualTo(String value) {
            addCriterion("var_numero_brevete <>", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteGreaterThan(String value) {
            addCriterion("var_numero_brevete >", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteGreaterThanOrEqualTo(String value) {
            addCriterion("var_numero_brevete >=", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteLessThan(String value) {
            addCriterion("var_numero_brevete <", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteLessThanOrEqualTo(String value) {
            addCriterion("var_numero_brevete <=", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteLike(String value) {
            addCriterion("var_numero_brevete like", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteNotLike(String value) {
            addCriterion("var_numero_brevete not like", value, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteIn(List<String> values) {
            addCriterion("var_numero_brevete in", values, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteNotIn(List<String> values) {
            addCriterion("var_numero_brevete not in", values, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteBetween(String value1, String value2) {
            addCriterion("var_numero_brevete between", value1, value2, "var_numero_brevete");
            return (Criteria) this;
        }

        public Criteria andVar_numero_breveteNotBetween(String value1, String value2) {
            addCriterion("var_numero_brevete not between", value1, value2, "var_numero_brevete");
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