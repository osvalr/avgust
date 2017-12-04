package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class UsuarioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsuarioExample() {
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

        public Criteria andIdusuarioIsNull() {
            addCriterion("idusuario is null");
            return (Criteria) this;
        }

        public Criteria andIdusuarioIsNotNull() {
            addCriterion("idusuario is not null");
            return (Criteria) this;
        }

        public Criteria andIdusuarioEqualTo(Integer value) {
            addCriterion("idusuario =", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotEqualTo(Integer value) {
            addCriterion("idusuario <>", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioGreaterThan(Integer value) {
            addCriterion("idusuario >", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("idusuario >=", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioLessThan(Integer value) {
            addCriterion("idusuario <", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioLessThanOrEqualTo(Integer value) {
            addCriterion("idusuario <=", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioIn(List<Integer> values) {
            addCriterion("idusuario in", values, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotIn(List<Integer> values) {
            addCriterion("idusuario not in", values, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioBetween(Integer value1, Integer value2) {
            addCriterion("idusuario between", value1, value2, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("idusuario not between", value1, value2, "idusuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioIsNull() {
            addCriterion("usuario is null");
            return (Criteria) this;
        }

        public Criteria andUsuarioIsNotNull() {
            addCriterion("usuario is not null");
            return (Criteria) this;
        }

        public Criteria andUsuarioEqualTo(String value) {
            addCriterion("usuario =", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioNotEqualTo(String value) {
            addCriterion("usuario <>", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioGreaterThan(String value) {
            addCriterion("usuario >", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioGreaterThanOrEqualTo(String value) {
            addCriterion("usuario >=", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioLessThan(String value) {
            addCriterion("usuario <", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioLessThanOrEqualTo(String value) {
            addCriterion("usuario <=", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioLike(String value) {
            addCriterion("usuario like", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioNotLike(String value) {
            addCriterion("usuario not like", value, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioIn(List<String> values) {
            addCriterion("usuario in", values, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioNotIn(List<String> values) {
            addCriterion("usuario not in", values, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioBetween(String value1, String value2) {
            addCriterion("usuario between", value1, value2, "usuario");
            return (Criteria) this;
        }

        public Criteria andUsuarioNotBetween(String value1, String value2) {
            addCriterion("usuario not between", value1, value2, "usuario");
            return (Criteria) this;
        }

        public Criteria andClaveIsNull() {
            addCriterion("clave is null");
            return (Criteria) this;
        }

        public Criteria andClaveIsNotNull() {
            addCriterion("clave is not null");
            return (Criteria) this;
        }

        public Criteria andClaveEqualTo(String value) {
            addCriterion("clave =", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveNotEqualTo(String value) {
            addCriterion("clave <>", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveGreaterThan(String value) {
            addCriterion("clave >", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveGreaterThanOrEqualTo(String value) {
            addCriterion("clave >=", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveLessThan(String value) {
            addCriterion("clave <", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveLessThanOrEqualTo(String value) {
            addCriterion("clave <=", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveLike(String value) {
            addCriterion("clave like", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveNotLike(String value) {
            addCriterion("clave not like", value, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveIn(List<String> values) {
            addCriterion("clave in", values, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveNotIn(List<String> values) {
            addCriterion("clave not in", values, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveBetween(String value1, String value2) {
            addCriterion("clave between", value1, value2, "clave");
            return (Criteria) this;
        }

        public Criteria andClaveNotBetween(String value1, String value2) {
            addCriterion("clave not between", value1, value2, "clave");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNull() {
            addCriterion("estado is null");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNotNull() {
            addCriterion("estado is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoEqualTo(Integer value) {
            addCriterion("estado =", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotEqualTo(Integer value) {
            addCriterion("estado <>", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThan(Integer value) {
            addCriterion("estado >", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("estado >=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThan(Integer value) {
            addCriterion("estado <", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThanOrEqualTo(Integer value) {
            addCriterion("estado <=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoIn(List<Integer> values) {
            addCriterion("estado in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotIn(List<Integer> values) {
            addCriterion("estado not in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoBetween(Integer value1, Integer value2) {
            addCriterion("estado between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotBetween(Integer value1, Integer value2) {
            addCriterion("estado not between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andIdareaIsNull() {
            addCriterion("idarea is null");
            return (Criteria) this;
        }

        public Criteria andIdareaIsNotNull() {
            addCriterion("idarea is not null");
            return (Criteria) this;
        }

        public Criteria andIdareaEqualTo(Integer value) {
            addCriterion("idarea =", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotEqualTo(Integer value) {
            addCriterion("idarea <>", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaGreaterThan(Integer value) {
            addCriterion("idarea >", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idarea >=", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaLessThan(Integer value) {
            addCriterion("idarea <", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaLessThanOrEqualTo(Integer value) {
            addCriterion("idarea <=", value, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaIn(List<Integer> values) {
            addCriterion("idarea in", values, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotIn(List<Integer> values) {
            addCriterion("idarea not in", values, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaBetween(Integer value1, Integer value2) {
            addCriterion("idarea between", value1, value2, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdareaNotBetween(Integer value1, Integer value2) {
            addCriterion("idarea not between", value1, value2, "idarea");
            return (Criteria) this;
        }

        public Criteria andIdrolIsNull() {
            addCriterion("idrol is null");
            return (Criteria) this;
        }

        public Criteria andIdrolIsNotNull() {
            addCriterion("idrol is not null");
            return (Criteria) this;
        }

        public Criteria andIdrolEqualTo(Integer value) {
            addCriterion("idrol =", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotEqualTo(Integer value) {
            addCriterion("idrol <>", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolGreaterThan(Integer value) {
            addCriterion("idrol >", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolGreaterThanOrEqualTo(Integer value) {
            addCriterion("idrol >=", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolLessThan(Integer value) {
            addCriterion("idrol <", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolLessThanOrEqualTo(Integer value) {
            addCriterion("idrol <=", value, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolIn(List<Integer> values) {
            addCriterion("idrol in", values, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotIn(List<Integer> values) {
            addCriterion("idrol not in", values, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolBetween(Integer value1, Integer value2) {
            addCriterion("idrol between", value1, value2, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdrolNotBetween(Integer value1, Integer value2) {
            addCriterion("idrol not between", value1, value2, "idrol");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNull() {
            addCriterion("idpersonal is null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIsNotNull() {
            addCriterion("idpersonal is not null");
            return (Criteria) this;
        }

        public Criteria andIdpersonalEqualTo(Integer value) {
            addCriterion("idpersonal =", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotEqualTo(Integer value) {
            addCriterion("idpersonal <>", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThan(Integer value) {
            addCriterion("idpersonal >", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idpersonal >=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThan(Integer value) {
            addCriterion("idpersonal <", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalLessThanOrEqualTo(Integer value) {
            addCriterion("idpersonal <=", value, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalIn(List<Integer> values) {
            addCriterion("idpersonal in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotIn(List<Integer> values) {
            addCriterion("idpersonal not in", values, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andIdpersonalNotBetween(Integer value1, Integer value2) {
            addCriterion("idpersonal not between", value1, value2, "idpersonal");
            return (Criteria) this;
        }

        public Criteria andLoginfirstIsNull() {
            addCriterion("loginfirst is null");
            return (Criteria) this;
        }

        public Criteria andLoginfirstIsNotNull() {
            addCriterion("loginfirst is not null");
            return (Criteria) this;
        }

        public Criteria andLoginfirstEqualTo(Integer value) {
            addCriterion("loginfirst =", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstNotEqualTo(Integer value) {
            addCriterion("loginfirst <>", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstGreaterThan(Integer value) {
            addCriterion("loginfirst >", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstGreaterThanOrEqualTo(Integer value) {
            addCriterion("loginfirst >=", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstLessThan(Integer value) {
            addCriterion("loginfirst <", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstLessThanOrEqualTo(Integer value) {
            addCriterion("loginfirst <=", value, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstIn(List<Integer> values) {
            addCriterion("loginfirst in", values, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstNotIn(List<Integer> values) {
            addCriterion("loginfirst not in", values, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstBetween(Integer value1, Integer value2) {
            addCriterion("loginfirst between", value1, value2, "loginfirst");
            return (Criteria) this;
        }

        public Criteria andLoginfirstNotBetween(Integer value1, Integer value2) {
            addCriterion("loginfirst not between", value1, value2, "loginfirst");
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