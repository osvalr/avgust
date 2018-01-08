package pe.com.acme.invoiceelec.model.mybatis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentElectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VentElectExample() {
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

        public Criteria andEmpIdIsNull() {
            addCriterion("EMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("EMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(String value) {
            addCriterion("EMP_ID =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(String value) {
            addCriterion("EMP_ID <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(String value) {
            addCriterion("EMP_ID >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_ID >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(String value) {
            addCriterion("EMP_ID <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(String value) {
            addCriterion("EMP_ID <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLike(String value) {
            addCriterion("EMP_ID like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotLike(String value) {
            addCriterion("EMP_ID not like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<String> values) {
            addCriterion("EMP_ID in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<String> values) {
            addCriterion("EMP_ID not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(String value1, String value2) {
            addCriterion("EMP_ID between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(String value1, String value2) {
            addCriterion("EMP_ID not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andDocumKeyIsNull() {
            addCriterion("DOCUM_KEY is null");
            return (Criteria) this;
        }

        public Criteria andDocumKeyIsNotNull() {
            addCriterion("DOCUM_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andDocumKeyEqualTo(String value) {
            addCriterion("DOCUM_KEY =", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyNotEqualTo(String value) {
            addCriterion("DOCUM_KEY <>", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyGreaterThan(String value) {
            addCriterion("DOCUM_KEY >", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyGreaterThanOrEqualTo(String value) {
            addCriterion("DOCUM_KEY >=", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyLessThan(String value) {
            addCriterion("DOCUM_KEY <", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyLessThanOrEqualTo(String value) {
            addCriterion("DOCUM_KEY <=", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyLike(String value) {
            addCriterion("DOCUM_KEY like", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyNotLike(String value) {
            addCriterion("DOCUM_KEY not like", value, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyIn(List<String> values) {
            addCriterion("DOCUM_KEY in", values, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyNotIn(List<String> values) {
            addCriterion("DOCUM_KEY not in", values, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyBetween(String value1, String value2) {
            addCriterion("DOCUM_KEY between", value1, value2, "documKey");
            return (Criteria) this;
        }

        public Criteria andDocumKeyNotBetween(String value1, String value2) {
            addCriterion("DOCUM_KEY not between", value1, value2, "documKey");
            return (Criteria) this;
        }

        public Criteria andNumfSerieIsNull() {
            addCriterion("NUMF_SERIE is null");
            return (Criteria) this;
        }

        public Criteria andNumfSerieIsNotNull() {
            addCriterion("NUMF_SERIE is not null");
            return (Criteria) this;
        }

        public Criteria andNumfSerieEqualTo(String value) {
            addCriterion("NUMF_SERIE =", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieNotEqualTo(String value) {
            addCriterion("NUMF_SERIE <>", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieGreaterThan(String value) {
            addCriterion("NUMF_SERIE >", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieGreaterThanOrEqualTo(String value) {
            addCriterion("NUMF_SERIE >=", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieLessThan(String value) {
            addCriterion("NUMF_SERIE <", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieLessThanOrEqualTo(String value) {
            addCriterion("NUMF_SERIE <=", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieLike(String value) {
            addCriterion("NUMF_SERIE like", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieNotLike(String value) {
            addCriterion("NUMF_SERIE not like", value, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieIn(List<String> values) {
            addCriterion("NUMF_SERIE in", values, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieNotIn(List<String> values) {
            addCriterion("NUMF_SERIE not in", values, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieBetween(String value1, String value2) {
            addCriterion("NUMF_SERIE between", value1, value2, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfSerieNotBetween(String value1, String value2) {
            addCriterion("NUMF_SERIE not between", value1, value2, "numfSerie");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelIsNull() {
            addCriterion("NUMF_CORREL is null");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelIsNotNull() {
            addCriterion("NUMF_CORREL is not null");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelEqualTo(Integer value) {
            addCriterion("NUMF_CORREL =", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelNotEqualTo(Integer value) {
            addCriterion("NUMF_CORREL <>", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelGreaterThan(Integer value) {
            addCriterion("NUMF_CORREL >", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUMF_CORREL >=", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelLessThan(Integer value) {
            addCriterion("NUMF_CORREL <", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelLessThanOrEqualTo(Integer value) {
            addCriterion("NUMF_CORREL <=", value, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelIn(List<Integer> values) {
            addCriterion("NUMF_CORREL in", values, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelNotIn(List<Integer> values) {
            addCriterion("NUMF_CORREL not in", values, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelBetween(Integer value1, Integer value2) {
            addCriterion("NUMF_CORREL between", value1, value2, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andNumfCorrelNotBetween(Integer value1, Integer value2) {
            addCriterion("NUMF_CORREL not between", value1, value2, "numfCorrel");
            return (Criteria) this;
        }

        public Criteria andEstadoDocIsNull() {
            addCriterion("ESTADO_DOC is null");
            return (Criteria) this;
        }

        public Criteria andEstadoDocIsNotNull() {
            addCriterion("ESTADO_DOC is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoDocEqualTo(String value) {
            addCriterion("ESTADO_DOC =", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocNotEqualTo(String value) {
            addCriterion("ESTADO_DOC <>", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocGreaterThan(String value) {
            addCriterion("ESTADO_DOC >", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocGreaterThanOrEqualTo(String value) {
            addCriterion("ESTADO_DOC >=", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocLessThan(String value) {
            addCriterion("ESTADO_DOC <", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocLessThanOrEqualTo(String value) {
            addCriterion("ESTADO_DOC <=", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocLike(String value) {
            addCriterion("ESTADO_DOC like", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocNotLike(String value) {
            addCriterion("ESTADO_DOC not like", value, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocIn(List<String> values) {
            addCriterion("ESTADO_DOC in", values, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocNotIn(List<String> values) {
            addCriterion("ESTADO_DOC not in", values, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocBetween(String value1, String value2) {
            addCriterion("ESTADO_DOC between", value1, value2, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andEstadoDocNotBetween(String value1, String value2) {
            addCriterion("ESTADO_DOC not between", value1, value2, "estadoDoc");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecIsNull() {
            addCriterion("RUTA_DOC_ELEC is null");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecIsNotNull() {
            addCriterion("RUTA_DOC_ELEC is not null");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecEqualTo(String value) {
            addCriterion("RUTA_DOC_ELEC =", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecNotEqualTo(String value) {
            addCriterion("RUTA_DOC_ELEC <>", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecGreaterThan(String value) {
            addCriterion("RUTA_DOC_ELEC >", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecGreaterThanOrEqualTo(String value) {
            addCriterion("RUTA_DOC_ELEC >=", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecLessThan(String value) {
            addCriterion("RUTA_DOC_ELEC <", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecLessThanOrEqualTo(String value) {
            addCriterion("RUTA_DOC_ELEC <=", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecLike(String value) {
            addCriterion("RUTA_DOC_ELEC like", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecNotLike(String value) {
            addCriterion("RUTA_DOC_ELEC not like", value, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecIn(List<String> values) {
            addCriterion("RUTA_DOC_ELEC in", values, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecNotIn(List<String> values) {
            addCriterion("RUTA_DOC_ELEC not in", values, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecBetween(String value1, String value2) {
            addCriterion("RUTA_DOC_ELEC between", value1, value2, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaDocElecNotBetween(String value1, String value2) {
            addCriterion("RUTA_DOC_ELEC not between", value1, value2, "rutaDocElec");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasIsNull() {
            addCriterion("RUTA_COD_BARRAS is null");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasIsNotNull() {
            addCriterion("RUTA_COD_BARRAS is not null");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS =", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasNotEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS <>", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasGreaterThan(String value) {
            addCriterion("RUTA_COD_BARRAS >", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasGreaterThanOrEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS >=", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasLessThan(String value) {
            addCriterion("RUTA_COD_BARRAS <", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasLessThanOrEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS <=", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasLike(String value) {
            addCriterion("RUTA_COD_BARRAS like", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasNotLike(String value) {
            addCriterion("RUTA_COD_BARRAS not like", value, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasIn(List<String> values) {
            addCriterion("RUTA_COD_BARRAS in", values, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasNotIn(List<String> values) {
            addCriterion("RUTA_COD_BARRAS not in", values, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasBetween(String value1, String value2) {
            addCriterion("RUTA_COD_BARRAS between", value1, value2, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasNotBetween(String value1, String value2) {
            addCriterion("RUTA_COD_BARRAS not between", value1, value2, "rutaCodBarras");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddIsNull() {
            addCriterion("NUMF_USUADD is null");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddIsNotNull() {
            addCriterion("NUMF_USUADD is not null");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddEqualTo(String value) {
            addCriterion("NUMF_USUADD =", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddNotEqualTo(String value) {
            addCriterion("NUMF_USUADD <>", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddGreaterThan(String value) {
            addCriterion("NUMF_USUADD >", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddGreaterThanOrEqualTo(String value) {
            addCriterion("NUMF_USUADD >=", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddLessThan(String value) {
            addCriterion("NUMF_USUADD <", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddLessThanOrEqualTo(String value) {
            addCriterion("NUMF_USUADD <=", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddLike(String value) {
            addCriterion("NUMF_USUADD like", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddNotLike(String value) {
            addCriterion("NUMF_USUADD not like", value, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddIn(List<String> values) {
            addCriterion("NUMF_USUADD in", values, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddNotIn(List<String> values) {
            addCriterion("NUMF_USUADD not in", values, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddBetween(String value1, String value2) {
            addCriterion("NUMF_USUADD between", value1, value2, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsuaddNotBetween(String value1, String value2) {
            addCriterion("NUMF_USUADD not between", value1, value2, "numfUsuadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddIsNull() {
            addCriterion("NUMF_FECADD is null");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddIsNotNull() {
            addCriterion("NUMF_FECADD is not null");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddEqualTo(Date value) {
            addCriterion("NUMF_FECADD =", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddNotEqualTo(Date value) {
            addCriterion("NUMF_FECADD <>", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddGreaterThan(Date value) {
            addCriterion("NUMF_FECADD >", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddGreaterThanOrEqualTo(Date value) {
            addCriterion("NUMF_FECADD >=", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddLessThan(Date value) {
            addCriterion("NUMF_FECADD <", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddLessThanOrEqualTo(Date value) {
            addCriterion("NUMF_FECADD <=", value, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddIn(List<Date> values) {
            addCriterion("NUMF_FECADD in", values, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddNotIn(List<Date> values) {
            addCriterion("NUMF_FECADD not in", values, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddBetween(Date value1, Date value2) {
            addCriterion("NUMF_FECADD between", value1, value2, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfFecaddNotBetween(Date value1, Date value2) {
            addCriterion("NUMF_FECADD not between", value1, value2, "numfFecadd");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodIsNull() {
            addCriterion("NUMF_USUMOD is null");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodIsNotNull() {
            addCriterion("NUMF_USUMOD is not null");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodEqualTo(String value) {
            addCriterion("NUMF_USUMOD =", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodNotEqualTo(String value) {
            addCriterion("NUMF_USUMOD <>", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodGreaterThan(String value) {
            addCriterion("NUMF_USUMOD >", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodGreaterThanOrEqualTo(String value) {
            addCriterion("NUMF_USUMOD >=", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodLessThan(String value) {
            addCriterion("NUMF_USUMOD <", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodLessThanOrEqualTo(String value) {
            addCriterion("NUMF_USUMOD <=", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodLike(String value) {
            addCriterion("NUMF_USUMOD like", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodNotLike(String value) {
            addCriterion("NUMF_USUMOD not like", value, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodIn(List<String> values) {
            addCriterion("NUMF_USUMOD in", values, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodNotIn(List<String> values) {
            addCriterion("NUMF_USUMOD not in", values, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodBetween(String value1, String value2) {
            addCriterion("NUMF_USUMOD between", value1, value2, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfUsumodNotBetween(String value1, String value2) {
            addCriterion("NUMF_USUMOD not between", value1, value2, "numfUsumod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodIsNull() {
            addCriterion("NUMF_FECMOD is null");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodIsNotNull() {
            addCriterion("NUMF_FECMOD is not null");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodEqualTo(Date value) {
            addCriterion("NUMF_FECMOD =", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodNotEqualTo(Date value) {
            addCriterion("NUMF_FECMOD <>", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodGreaterThan(Date value) {
            addCriterion("NUMF_FECMOD >", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodGreaterThanOrEqualTo(Date value) {
            addCriterion("NUMF_FECMOD >=", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodLessThan(Date value) {
            addCriterion("NUMF_FECMOD <", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodLessThanOrEqualTo(Date value) {
            addCriterion("NUMF_FECMOD <=", value, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodIn(List<Date> values) {
            addCriterion("NUMF_FECMOD in", values, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodNotIn(List<Date> values) {
            addCriterion("NUMF_FECMOD not in", values, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodBetween(Date value1, Date value2) {
            addCriterion("NUMF_FECMOD between", value1, value2, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andNumfFecmodNotBetween(Date value1, Date value2) {
            addCriterion("NUMF_FECMOD not between", value1, value2, "numfFecmod");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixIsNull() {
            addCriterion("RUTA_COD_BARRAS_MATRIX is null");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixIsNotNull() {
            addCriterion("RUTA_COD_BARRAS_MATRIX is not null");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX =", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixNotEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX <>", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixGreaterThan(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX >", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixGreaterThanOrEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX >=", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixLessThan(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX <", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixLessThanOrEqualTo(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX <=", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixLike(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX like", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixNotLike(String value) {
            addCriterion("RUTA_COD_BARRAS_MATRIX not like", value, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixIn(List<String> values) {
            addCriterion("RUTA_COD_BARRAS_MATRIX in", values, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixNotIn(List<String> values) {
            addCriterion("RUTA_COD_BARRAS_MATRIX not in", values, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixBetween(String value1, String value2) {
            addCriterion("RUTA_COD_BARRAS_MATRIX between", value1, value2, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andRutaCodBarrasMatrixNotBetween(String value1, String value2) {
            addCriterion("RUTA_COD_BARRAS_MATRIX not between", value1, value2, "rutaCodBarrasMatrix");
            return (Criteria) this;
        }

        public Criteria andTipDocElectIsNull() {
            addCriterion("TIP_DOC_ELECT is null");
            return (Criteria) this;
        }

        public Criteria andTipDocElectIsNotNull() {
            addCriterion("TIP_DOC_ELECT is not null");
            return (Criteria) this;
        }

        public Criteria andTipDocElectEqualTo(String value) {
            addCriterion("TIP_DOC_ELECT =", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectNotEqualTo(String value) {
            addCriterion("TIP_DOC_ELECT <>", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectGreaterThan(String value) {
            addCriterion("TIP_DOC_ELECT >", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectGreaterThanOrEqualTo(String value) {
            addCriterion("TIP_DOC_ELECT >=", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectLessThan(String value) {
            addCriterion("TIP_DOC_ELECT <", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectLessThanOrEqualTo(String value) {
            addCriterion("TIP_DOC_ELECT <=", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectLike(String value) {
            addCriterion("TIP_DOC_ELECT like", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectNotLike(String value) {
            addCriterion("TIP_DOC_ELECT not like", value, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectIn(List<String> values) {
            addCriterion("TIP_DOC_ELECT in", values, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectNotIn(List<String> values) {
            addCriterion("TIP_DOC_ELECT not in", values, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectBetween(String value1, String value2) {
            addCriterion("TIP_DOC_ELECT between", value1, value2, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andTipDocElectNotBetween(String value1, String value2) {
            addCriterion("TIP_DOC_ELECT not between", value1, value2, "tipDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectIsNull() {
            addCriterion("NUM_DOC_ELECT is null");
            return (Criteria) this;
        }

        public Criteria andNumDocElectIsNotNull() {
            addCriterion("NUM_DOC_ELECT is not null");
            return (Criteria) this;
        }

        public Criteria andNumDocElectEqualTo(String value) {
            addCriterion("NUM_DOC_ELECT =", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectNotEqualTo(String value) {
            addCriterion("NUM_DOC_ELECT <>", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectGreaterThan(String value) {
            addCriterion("NUM_DOC_ELECT >", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectGreaterThanOrEqualTo(String value) {
            addCriterion("NUM_DOC_ELECT >=", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectLessThan(String value) {
            addCriterion("NUM_DOC_ELECT <", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectLessThanOrEqualTo(String value) {
            addCriterion("NUM_DOC_ELECT <=", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectLike(String value) {
            addCriterion("NUM_DOC_ELECT like", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectNotLike(String value) {
            addCriterion("NUM_DOC_ELECT not like", value, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectIn(List<String> values) {
            addCriterion("NUM_DOC_ELECT in", values, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectNotIn(List<String> values) {
            addCriterion("NUM_DOC_ELECT not in", values, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectBetween(String value1, String value2) {
            addCriterion("NUM_DOC_ELECT between", value1, value2, "numDocElect");
            return (Criteria) this;
        }

        public Criteria andNumDocElectNotBetween(String value1, String value2) {
            addCriterion("NUM_DOC_ELECT not between", value1, value2, "numDocElect");
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