package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPostulanteCapacitacionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPostulanteCapacitacionExample() {
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

        public Criteria andSrl_id_postulante_capacitacionIsNull() {
            addCriterion("srl_id_postulante_capacitacion is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionIsNotNull() {
            addCriterion("srl_id_postulante_capacitacion is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionEqualTo(Integer value) {
            addCriterion("srl_id_postulante_capacitacion =", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionNotEqualTo(Integer value) {
            addCriterion("srl_id_postulante_capacitacion <>", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionGreaterThan(Integer value) {
            addCriterion("srl_id_postulante_capacitacion >", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_postulante_capacitacion >=", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionLessThan(Integer value) {
            addCriterion("srl_id_postulante_capacitacion <", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_postulante_capacitacion <=", value, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionIn(List<Integer> values) {
            addCriterion("srl_id_postulante_capacitacion in", values, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionNotIn(List<Integer> values) {
            addCriterion("srl_id_postulante_capacitacion not in", values, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_postulante_capacitacion between", value1, value2, "srl_id_postulante_capacitacion");
            return (Criteria) this;
        }

        public Criteria andSrl_id_postulante_capacitacionNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_postulante_capacitacion not between", value1, value2, "srl_id_postulante_capacitacion");
            return (Criteria) this;
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

        public Criteria andInt_id_institucionIsNull() {
            addCriterion("int_id_institucion is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionIsNotNull() {
            addCriterion("int_id_institucion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionEqualTo(Integer value) {
            addCriterion("int_id_institucion =", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionNotEqualTo(Integer value) {
            addCriterion("int_id_institucion <>", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionGreaterThan(Integer value) {
            addCriterion("int_id_institucion >", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_institucion >=", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionLessThan(Integer value) {
            addCriterion("int_id_institucion <", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_institucion <=", value, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionIn(List<Integer> values) {
            addCriterion("int_id_institucion in", values, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionNotIn(List<Integer> values) {
            addCriterion("int_id_institucion not in", values, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionBetween(Integer value1, Integer value2) {
            addCriterion("int_id_institucion between", value1, value2, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andInt_id_institucionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_institucion not between", value1, value2, "int_id_institucion");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaIsNull() {
            addCriterion("var_descrip_programa is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaIsNotNull() {
            addCriterion("var_descrip_programa is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaEqualTo(String value) {
            addCriterion("var_descrip_programa =", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaNotEqualTo(String value) {
            addCriterion("var_descrip_programa <>", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaGreaterThan(String value) {
            addCriterion("var_descrip_programa >", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_programa >=", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaLessThan(String value) {
            addCriterion("var_descrip_programa <", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_programa <=", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaLike(String value) {
            addCriterion("var_descrip_programa like", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaNotLike(String value) {
            addCriterion("var_descrip_programa not like", value, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaIn(List<String> values) {
            addCriterion("var_descrip_programa in", values, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaNotIn(List<String> values) {
            addCriterion("var_descrip_programa not in", values, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaBetween(String value1, String value2) {
            addCriterion("var_descrip_programa between", value1, value2, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_programaNotBetween(String value1, String value2) {
            addCriterion("var_descrip_programa not between", value1, value2, "var_descrip_programa");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioIsNull() {
            addCriterion("int_cant_anio is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioIsNotNull() {
            addCriterion("int_cant_anio is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioEqualTo(Integer value) {
            addCriterion("int_cant_anio =", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioNotEqualTo(Integer value) {
            addCriterion("int_cant_anio <>", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioGreaterThan(Integer value) {
            addCriterion("int_cant_anio >", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_anio >=", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioLessThan(Integer value) {
            addCriterion("int_cant_anio <", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_anio <=", value, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioIn(List<Integer> values) {
            addCriterion("int_cant_anio in", values, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioNotIn(List<Integer> values) {
            addCriterion("int_cant_anio not in", values, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_anio between", value1, value2, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_anioNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_anio not between", value1, value2, "int_cant_anio");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesIsNull() {
            addCriterion("int_cant_meses is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesIsNotNull() {
            addCriterion("int_cant_meses is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesEqualTo(Integer value) {
            addCriterion("int_cant_meses =", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesNotEqualTo(Integer value) {
            addCriterion("int_cant_meses <>", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesGreaterThan(Integer value) {
            addCriterion("int_cant_meses >", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_meses >=", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesLessThan(Integer value) {
            addCriterion("int_cant_meses <", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_meses <=", value, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesIn(List<Integer> values) {
            addCriterion("int_cant_meses in", values, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesNotIn(List<Integer> values) {
            addCriterion("int_cant_meses not in", values, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_meses between", value1, value2, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_mesesNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_meses not between", value1, value2, "int_cant_meses");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasIsNull() {
            addCriterion("int_cant_dias is null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasIsNotNull() {
            addCriterion("int_cant_dias is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasEqualTo(Integer value) {
            addCriterion("int_cant_dias =", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasNotEqualTo(Integer value) {
            addCriterion("int_cant_dias <>", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasGreaterThan(Integer value) {
            addCriterion("int_cant_dias >", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias >=", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasLessThan(Integer value) {
            addCriterion("int_cant_dias <", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasLessThanOrEqualTo(Integer value) {
            addCriterion("int_cant_dias <=", value, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasIn(List<Integer> values) {
            addCriterion("int_cant_dias in", values, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasNotIn(List<Integer> values) {
            addCriterion("int_cant_dias not in", values, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias between", value1, value2, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andInt_cant_diasNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cant_dias not between", value1, value2, "int_cant_dias");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIsNull() {
            addCriterion("dte_fecha_inicio is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIsNotNull() {
            addCriterion("dte_fecha_inicio is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio =", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <>", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio >", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio >=", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_inicio <=", value, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio in", values, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_inicio not in", values, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio between", value1, value2, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_inicioNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_inicio not between", value1, value2, "dte_fecha_inicio");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIsNull() {
            addCriterion("dte_fecha_fin is null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIsNotNull() {
            addCriterion("dte_fecha_fin is not null");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin =", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <>", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finGreaterThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin >", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin >=", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finLessThan(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dte_fecha_fin <=", value, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin in", values, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotIn(List<Date> values) {
            addCriterionForJDBCDate("dte_fecha_fin not in", values, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin between", value1, value2, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andDte_fecha_finNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dte_fecha_fin not between", value1, value2, "dte_fecha_fin");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelIsNull() {
            addCriterion("int_id_tipo_nivel is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelIsNotNull() {
            addCriterion("int_id_tipo_nivel is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelEqualTo(Integer value) {
            addCriterion("int_id_tipo_nivel =", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelNotEqualTo(Integer value) {
            addCriterion("int_id_tipo_nivel <>", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelGreaterThan(Integer value) {
            addCriterion("int_id_tipo_nivel >", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_nivel >=", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelLessThan(Integer value) {
            addCriterion("int_id_tipo_nivel <", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_tipo_nivel <=", value, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelIn(List<Integer> values) {
            addCriterion("int_id_tipo_nivel in", values, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelNotIn(List<Integer> values) {
            addCriterion("int_id_tipo_nivel not in", values, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_nivel between", value1, value2, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_tipo_nivelNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_tipo_nivel not between", value1, value2, "int_id_tipo_nivel");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNull() {
            addCriterion("int_id_estado is null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIsNotNull() {
            addCriterion("int_id_estado is not null");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoEqualTo(Integer value) {
            addCriterion("int_id_estado =", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotEqualTo(Integer value) {
            addCriterion("int_id_estado <>", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThan(Integer value) {
            addCriterion("int_id_estado >", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado >=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThan(Integer value) {
            addCriterion("int_id_estado <", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoLessThanOrEqualTo(Integer value) {
            addCriterion("int_id_estado <=", value, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoIn(List<Integer> values) {
            addCriterion("int_id_estado in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotIn(List<Integer> values) {
            addCriterion("int_id_estado not in", values, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andInt_id_estadoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_id_estado not between", value1, value2, "int_id_estado");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNull() {
            addCriterion("tsp_fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIsNotNull() {
            addCriterion("tsp_fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroEqualTo(Date value) {
            addCriterion("tsp_fecha_registro =", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <>", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThan(Date value) {
            addCriterion("tsp_fecha_registro >", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroGreaterThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro >=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThan(Date value) {
            addCriterion("tsp_fecha_registro <", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroLessThanOrEqualTo(Date value) {
            addCriterion("tsp_fecha_registro <=", value, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroIn(List<Date> values) {
            addCriterion("tsp_fecha_registro in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotIn(List<Date> values) {
            addCriterion("tsp_fecha_registro not in", values, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro between", value1, value2, "tsp_fecha_registro");
            return (Criteria) this;
        }

        public Criteria andTsp_fecha_registroNotBetween(Date value1, Date value2) {
            addCriterion("tsp_fecha_registro not between", value1, value2, "tsp_fecha_registro");
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