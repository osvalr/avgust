package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class AreanaturalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreanaturalExample() {
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

        public Criteria andIdareanaturalIsNull() {
            addCriterion("idareanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalIsNotNull() {
            addCriterion("idareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalEqualTo(Integer value) {
            addCriterion("idareanatural =", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotEqualTo(Integer value) {
            addCriterion("idareanatural <>", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalGreaterThan(Integer value) {
            addCriterion("idareanatural >", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idareanatural >=", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalLessThan(Integer value) {
            addCriterion("idareanatural <", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idareanatural <=", value, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalIn(List<Integer> values) {
            addCriterion("idareanatural in", values, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotIn(List<Integer> values) {
            addCriterion("idareanatural not in", values, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idareanatural between", value1, value2, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andIdareanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idareanatural not between", value1, value2, "idareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalIsNull() {
            addCriterion("codareanatural is null");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalIsNotNull() {
            addCriterion("codareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalEqualTo(String value) {
            addCriterion("codareanatural =", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalNotEqualTo(String value) {
            addCriterion("codareanatural <>", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalGreaterThan(String value) {
            addCriterion("codareanatural >", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalGreaterThanOrEqualTo(String value) {
            addCriterion("codareanatural >=", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalLessThan(String value) {
            addCriterion("codareanatural <", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalLessThanOrEqualTo(String value) {
            addCriterion("codareanatural <=", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalLike(String value) {
            addCriterion("codareanatural like", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalNotLike(String value) {
            addCriterion("codareanatural not like", value, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalIn(List<String> values) {
            addCriterion("codareanatural in", values, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalNotIn(List<String> values) {
            addCriterion("codareanatural not in", values, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalBetween(String value1, String value2) {
            addCriterion("codareanatural between", value1, value2, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andCodareanaturalNotBetween(String value1, String value2) {
            addCriterion("codareanatural not between", value1, value2, "codareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalIsNull() {
            addCriterion("desareanatural is null");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalIsNotNull() {
            addCriterion("desareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalEqualTo(String value) {
            addCriterion("desareanatural =", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalNotEqualTo(String value) {
            addCriterion("desareanatural <>", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalGreaterThan(String value) {
            addCriterion("desareanatural >", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalGreaterThanOrEqualTo(String value) {
            addCriterion("desareanatural >=", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalLessThan(String value) {
            addCriterion("desareanatural <", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalLessThanOrEqualTo(String value) {
            addCriterion("desareanatural <=", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalLike(String value) {
            addCriterion("desareanatural like", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalNotLike(String value) {
            addCriterion("desareanatural not like", value, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalIn(List<String> values) {
            addCriterion("desareanatural in", values, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalNotIn(List<String> values) {
            addCriterion("desareanatural not in", values, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalBetween(String value1, String value2) {
            addCriterion("desareanatural between", value1, value2, "desareanatural");
            return (Criteria) this;
        }

        public Criteria andDesareanaturalNotBetween(String value1, String value2) {
            addCriterion("desareanatural not between", value1, value2, "desareanatural");
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

        public Criteria andIdcategoriaanpIsNull() {
            addCriterion("idcategoriaanp is null");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpIsNotNull() {
            addCriterion("idcategoriaanp is not null");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpEqualTo(Integer value) {
            addCriterion("idcategoriaanp =", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotEqualTo(Integer value) {
            addCriterion("idcategoriaanp <>", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpGreaterThan(Integer value) {
            addCriterion("idcategoriaanp >", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcategoriaanp >=", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpLessThan(Integer value) {
            addCriterion("idcategoriaanp <", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpLessThanOrEqualTo(Integer value) {
            addCriterion("idcategoriaanp <=", value, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpIn(List<Integer> values) {
            addCriterion("idcategoriaanp in", values, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotIn(List<Integer> values) {
            addCriterion("idcategoriaanp not in", values, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpBetween(Integer value1, Integer value2) {
            addCriterion("idcategoriaanp between", value1, value2, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andIdcategoriaanpNotBetween(Integer value1, Integer value2) {
            addCriterion("idcategoriaanp not between", value1, value2, "idcategoriaanp");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalIsNull() {
            addCriterion("ubicacionareanatural is null");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalIsNotNull() {
            addCriterion("ubicacionareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalEqualTo(String value) {
            addCriterion("ubicacionareanatural =", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalNotEqualTo(String value) {
            addCriterion("ubicacionareanatural <>", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalGreaterThan(String value) {
            addCriterion("ubicacionareanatural >", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalGreaterThanOrEqualTo(String value) {
            addCriterion("ubicacionareanatural >=", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalLessThan(String value) {
            addCriterion("ubicacionareanatural <", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalLessThanOrEqualTo(String value) {
            addCriterion("ubicacionareanatural <=", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalLike(String value) {
            addCriterion("ubicacionareanatural like", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalNotLike(String value) {
            addCriterion("ubicacionareanatural not like", value, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalIn(List<String> values) {
            addCriterion("ubicacionareanatural in", values, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalNotIn(List<String> values) {
            addCriterion("ubicacionareanatural not in", values, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalBetween(String value1, String value2) {
            addCriterion("ubicacionareanatural between", value1, value2, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andUbicacionareanaturalNotBetween(String value1, String value2) {
            addCriterion("ubicacionareanatural not between", value1, value2, "ubicacionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalIsNull() {
            addCriterion("idadministracionareanatural is null");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalIsNotNull() {
            addCriterion("idadministracionareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalEqualTo(Integer value) {
            addCriterion("idadministracionareanatural =", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalNotEqualTo(Integer value) {
            addCriterion("idadministracionareanatural <>", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalGreaterThan(Integer value) {
            addCriterion("idadministracionareanatural >", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("idadministracionareanatural >=", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalLessThan(Integer value) {
            addCriterion("idadministracionareanatural <", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("idadministracionareanatural <=", value, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalIn(List<Integer> values) {
            addCriterion("idadministracionareanatural in", values, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalNotIn(List<Integer> values) {
            addCriterion("idadministracionareanatural not in", values, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalBetween(Integer value1, Integer value2) {
            addCriterion("idadministracionareanatural between", value1, value2, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andIdadministracionareanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("idadministracionareanatural not between", value1, value2, "idadministracionareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalIsNull() {
            addCriterion("flagactivoareanatural is null");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalIsNotNull() {
            addCriterion("flagactivoareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalEqualTo(Integer value) {
            addCriterion("flagactivoareanatural =", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalNotEqualTo(Integer value) {
            addCriterion("flagactivoareanatural <>", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalGreaterThan(Integer value) {
            addCriterion("flagactivoareanatural >", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalGreaterThanOrEqualTo(Integer value) {
            addCriterion("flagactivoareanatural >=", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalLessThan(Integer value) {
            addCriterion("flagactivoareanatural <", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalLessThanOrEqualTo(Integer value) {
            addCriterion("flagactivoareanatural <=", value, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalIn(List<Integer> values) {
            addCriterion("flagactivoareanatural in", values, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalNotIn(List<Integer> values) {
            addCriterion("flagactivoareanatural not in", values, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalBetween(Integer value1, Integer value2) {
            addCriterion("flagactivoareanatural between", value1, value2, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andFlagactivoareanaturalNotBetween(Integer value1, Integer value2) {
            addCriterion("flagactivoareanatural not between", value1, value2, "flagactivoareanatural");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialIsNull() {
            addCriterion("idenlaceterritorial is null");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialIsNotNull() {
            addCriterion("idenlaceterritorial is not null");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialEqualTo(Integer value) {
            addCriterion("idenlaceterritorial =", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialNotEqualTo(Integer value) {
            addCriterion("idenlaceterritorial <>", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialGreaterThan(Integer value) {
            addCriterion("idenlaceterritorial >", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialGreaterThanOrEqualTo(Integer value) {
            addCriterion("idenlaceterritorial >=", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialLessThan(Integer value) {
            addCriterion("idenlaceterritorial <", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialLessThanOrEqualTo(Integer value) {
            addCriterion("idenlaceterritorial <=", value, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialIn(List<Integer> values) {
            addCriterion("idenlaceterritorial in", values, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialNotIn(List<Integer> values) {
            addCriterion("idenlaceterritorial not in", values, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialBetween(Integer value1, Integer value2) {
            addCriterion("idenlaceterritorial between", value1, value2, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andIdenlaceterritorialNotBetween(Integer value1, Integer value2) {
            addCriterion("idenlaceterritorial not between", value1, value2, "idenlaceterritorial");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalIsNull() {
            addCriterion("siglaareanatural is null");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalIsNotNull() {
            addCriterion("siglaareanatural is not null");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalEqualTo(String value) {
            addCriterion("siglaareanatural =", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalNotEqualTo(String value) {
            addCriterion("siglaareanatural <>", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalGreaterThan(String value) {
            addCriterion("siglaareanatural >", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalGreaterThanOrEqualTo(String value) {
            addCriterion("siglaareanatural >=", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalLessThan(String value) {
            addCriterion("siglaareanatural <", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalLessThanOrEqualTo(String value) {
            addCriterion("siglaareanatural <=", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalLike(String value) {
            addCriterion("siglaareanatural like", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalNotLike(String value) {
            addCriterion("siglaareanatural not like", value, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalIn(List<String> values) {
            addCriterion("siglaareanatural in", values, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalNotIn(List<String> values) {
            addCriterion("siglaareanatural not in", values, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalBetween(String value1, String value2) {
            addCriterion("siglaareanatural between", value1, value2, "siglaareanatural");
            return (Criteria) this;
        }

        public Criteria andSiglaareanaturalNotBetween(String value1, String value2) {
            addCriterion("siglaareanatural not between", value1, value2, "siglaareanatural");
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