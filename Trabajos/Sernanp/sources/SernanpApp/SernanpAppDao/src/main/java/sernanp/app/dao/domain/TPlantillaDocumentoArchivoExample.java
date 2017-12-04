package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPlantillaDocumentoArchivoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPlantillaDocumentoArchivoExample() {
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

        public Criteria andSrl_id_plantilla_documento_archivoIsNull() {
            addCriterion("srl_id_plantilla_documento_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoIsNotNull() {
            addCriterion("srl_id_plantilla_documento_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo =", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <>", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo >", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo >=", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoLessThan(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento_archivo <=", value, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento_archivo in", values, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento_archivo not in", values, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento_archivo between", value1, value2, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documento_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento_archivo not between", value1, value2, "srl_id_plantilla_documento_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIsNull() {
            addCriterion("srl_id_archivo is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIsNotNull() {
            addCriterion("srl_id_archivo is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoEqualTo(Integer value) {
            addCriterion("srl_id_archivo =", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotEqualTo(Integer value) {
            addCriterion("srl_id_archivo <>", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThan(Integer value) {
            addCriterion("srl_id_archivo >", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo >=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThan(Integer value) {
            addCriterion("srl_id_archivo <", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_archivo <=", value, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoIn(List<Integer> values) {
            addCriterion("srl_id_archivo in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotIn(List<Integer> values) {
            addCriterion("srl_id_archivo not in", values, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo between", value1, value2, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_archivoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_archivo not between", value1, value2, "srl_id_archivo");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoIsNull() {
            addCriterion("srl_id_plantilla_documento is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoIsNotNull() {
            addCriterion("srl_id_plantilla_documento is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento =", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoNotEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento <>", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoGreaterThan(Integer value) {
            addCriterion("srl_id_plantilla_documento >", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento >=", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoLessThan(Integer value) {
            addCriterion("srl_id_plantilla_documento <", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_plantilla_documento <=", value, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento in", values, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoNotIn(List<Integer> values) {
            addCriterion("srl_id_plantilla_documento not in", values, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento between", value1, value2, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andSrl_id_plantilla_documentoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_plantilla_documento not between", value1, value2, "srl_id_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezIsNull() {
            addCriterion("dte_fecha_validez is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezIsNotNull() {
            addCriterion("dte_fecha_validez is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez =", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez <>", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez >", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez >=", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez <", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_validez <=", value, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_validez in", values, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_validez not in", values, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_validez between", value1, value2, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_validezNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_validez not between", value1, value2, "dte_fecha_validez");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoIsNull() {
            addCriterion("int_estado_plantilla_documento is null");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoIsNotNull() {
            addCriterion("int_estado_plantilla_documento is not null");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoEqualTo(Integer value) {
            addCriterion("int_estado_plantilla_documento =", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoNotEqualTo(Integer value) {
            addCriterion("int_estado_plantilla_documento <>", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoGreaterThan(Integer value) {
            addCriterion("int_estado_plantilla_documento >", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_estado_plantilla_documento >=", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoLessThan(Integer value) {
            addCriterion("int_estado_plantilla_documento <", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoLessThanOrEqualTo(Integer value) {
            addCriterion("int_estado_plantilla_documento <=", value, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoIn(List<Integer> values) {
            addCriterion("int_estado_plantilla_documento in", values, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoNotIn(List<Integer> values) {
            addCriterion("int_estado_plantilla_documento not in", values, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoBetween(Integer value1, Integer value2) {
            addCriterion("int_estado_plantilla_documento between", value1, value2, "int_estado_plantilla_documento");
            return (Criteria) this;
        }

        public Criteria andInt_estado_plantilla_documentoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_estado_plantilla_documento not between", value1, value2, "int_estado_plantilla_documento");
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