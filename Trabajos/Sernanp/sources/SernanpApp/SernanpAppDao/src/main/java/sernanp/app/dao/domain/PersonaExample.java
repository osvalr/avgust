package sernanp.app.dao.domain;

import java.util.ArrayList;
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

        public Criteria andTelefonoIsNull() {
            addCriterion("telefono is null");
            return (Criteria) this;
        }

        public Criteria andTelefonoIsNotNull() {
            addCriterion("telefono is not null");
            return (Criteria) this;
        }

        public Criteria andTelefonoEqualTo(String value) {
            addCriterion("telefono =", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotEqualTo(String value) {
            addCriterion("telefono <>", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThan(String value) {
            addCriterion("telefono >", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThanOrEqualTo(String value) {
            addCriterion("telefono >=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThan(String value) {
            addCriterion("telefono <", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThanOrEqualTo(String value) {
            addCriterion("telefono <=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLike(String value) {
            addCriterion("telefono like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotLike(String value) {
            addCriterion("telefono not like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoIn(List<String> values) {
            addCriterion("telefono in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotIn(List<String> values) {
            addCriterion("telefono not in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoBetween(String value1, String value2) {
            addCriterion("telefono between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotBetween(String value1, String value2) {
            addCriterion("telefono not between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalIsNull() {
            addCriterion("correopersonal is null");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalIsNotNull() {
            addCriterion("correopersonal is not null");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalEqualTo(String value) {
            addCriterion("correopersonal =", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalNotEqualTo(String value) {
            addCriterion("correopersonal <>", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalGreaterThan(String value) {
            addCriterion("correopersonal >", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalGreaterThanOrEqualTo(String value) {
            addCriterion("correopersonal >=", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalLessThan(String value) {
            addCriterion("correopersonal <", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalLessThanOrEqualTo(String value) {
            addCriterion("correopersonal <=", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalLike(String value) {
            addCriterion("correopersonal like", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalNotLike(String value) {
            addCriterion("correopersonal not like", value, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalIn(List<String> values) {
            addCriterion("correopersonal in", values, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalNotIn(List<String> values) {
            addCriterion("correopersonal not in", values, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalBetween(String value1, String value2) {
            addCriterion("correopersonal between", value1, value2, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreopersonalNotBetween(String value1, String value2) {
            addCriterion("correopersonal not between", value1, value2, "correopersonal");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalIsNull() {
            addCriterion("correoinstitucional is null");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalIsNotNull() {
            addCriterion("correoinstitucional is not null");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalEqualTo(String value) {
            addCriterion("correoinstitucional =", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalNotEqualTo(String value) {
            addCriterion("correoinstitucional <>", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalGreaterThan(String value) {
            addCriterion("correoinstitucional >", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalGreaterThanOrEqualTo(String value) {
            addCriterion("correoinstitucional >=", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalLessThan(String value) {
            addCriterion("correoinstitucional <", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalLessThanOrEqualTo(String value) {
            addCriterion("correoinstitucional <=", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalLike(String value) {
            addCriterion("correoinstitucional like", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalNotLike(String value) {
            addCriterion("correoinstitucional not like", value, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalIn(List<String> values) {
            addCriterion("correoinstitucional in", values, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalNotIn(List<String> values) {
            addCriterion("correoinstitucional not in", values, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalBetween(String value1, String value2) {
            addCriterion("correoinstitucional between", value1, value2, "correoinstitucional");
            return (Criteria) this;
        }

        public Criteria andCorreoinstitucionalNotBetween(String value1, String value2) {
            addCriterion("correoinstitucional not between", value1, value2, "correoinstitucional");
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