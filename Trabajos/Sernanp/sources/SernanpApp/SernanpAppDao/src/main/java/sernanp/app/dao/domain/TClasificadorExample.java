package sernanp.app.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TClasificadorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TClasificadorExample() {
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

        public Criteria andSrl_id_clasificadorIsNull() {
            addCriterion("srl_id_clasificador is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorIsNotNull() {
            addCriterion("srl_id_clasificador is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorEqualTo(Integer value) {
            addCriterion("srl_id_clasificador =", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorNotEqualTo(Integer value) {
            addCriterion("srl_id_clasificador <>", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorGreaterThan(Integer value) {
            addCriterion("srl_id_clasificador >", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_clasificador >=", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorLessThan(Integer value) {
            addCriterion("srl_id_clasificador <", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_clasificador <=", value, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorIn(List<Integer> values) {
            addCriterion("srl_id_clasificador in", values, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorNotIn(List<Integer> values) {
            addCriterion("srl_id_clasificador not in", values, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_clasificador between", value1, value2, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_clasificadorNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_clasificador not between", value1, value2, "srl_id_clasificador");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoIsNull() {
            addCriterion("srl_id_generica_gasto is null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoIsNotNull() {
            addCriterion("srl_id_generica_gasto is not null");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoEqualTo(Integer value) {
            addCriterion("srl_id_generica_gasto =", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoNotEqualTo(Integer value) {
            addCriterion("srl_id_generica_gasto <>", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoGreaterThan(Integer value) {
            addCriterion("srl_id_generica_gasto >", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoGreaterThanOrEqualTo(Integer value) {
            addCriterion("srl_id_generica_gasto >=", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoLessThan(Integer value) {
            addCriterion("srl_id_generica_gasto <", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoLessThanOrEqualTo(Integer value) {
            addCriterion("srl_id_generica_gasto <=", value, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoIn(List<Integer> values) {
            addCriterion("srl_id_generica_gasto in", values, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoNotIn(List<Integer> values) {
            addCriterion("srl_id_generica_gasto not in", values, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_generica_gasto between", value1, value2, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andSrl_id_generica_gastoNotBetween(Integer value1, Integer value2) {
            addCriterion("srl_id_generica_gasto not between", value1, value2, "srl_id_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionIsNull() {
            addCriterion("int_tipo_transaccion is null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionIsNotNull() {
            addCriterion("int_tipo_transaccion is not null");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionEqualTo(Integer value) {
            addCriterion("int_tipo_transaccion =", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionNotEqualTo(Integer value) {
            addCriterion("int_tipo_transaccion <>", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionGreaterThan(Integer value) {
            addCriterion("int_tipo_transaccion >", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_transaccion >=", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionLessThan(Integer value) {
            addCriterion("int_tipo_transaccion <", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionLessThanOrEqualTo(Integer value) {
            addCriterion("int_tipo_transaccion <=", value, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionIn(List<Integer> values) {
            addCriterion("int_tipo_transaccion in", values, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionNotIn(List<Integer> values) {
            addCriterion("int_tipo_transaccion not in", values, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_transaccion between", value1, value2, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_tipo_transaccionNotBetween(Integer value1, Integer value2) {
            addCriterion("int_tipo_transaccion not between", value1, value2, "int_tipo_transaccion");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoIsNull() {
            addCriterion("int_cod_generica_gasto is null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoIsNotNull() {
            addCriterion("int_cod_generica_gasto is not null");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoEqualTo(Integer value) {
            addCriterion("int_cod_generica_gasto =", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoNotEqualTo(Integer value) {
            addCriterion("int_cod_generica_gasto <>", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoGreaterThan(Integer value) {
            addCriterion("int_cod_generica_gasto >", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_cod_generica_gasto >=", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoLessThan(Integer value) {
            addCriterion("int_cod_generica_gasto <", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoLessThanOrEqualTo(Integer value) {
            addCriterion("int_cod_generica_gasto <=", value, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoIn(List<Integer> values) {
            addCriterion("int_cod_generica_gasto in", values, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoNotIn(List<Integer> values) {
            addCriterion("int_cod_generica_gasto not in", values, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_generica_gasto between", value1, value2, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_cod_generica_gastoNotBetween(Integer value1, Integer value2) {
            addCriterion("int_cod_generica_gasto not between", value1, value2, "int_cod_generica_gasto");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iIsNull() {
            addCriterion("int_generica_nivel_i is null");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iIsNotNull() {
            addCriterion("int_generica_nivel_i is not null");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iEqualTo(Integer value) {
            addCriterion("int_generica_nivel_i =", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iNotEqualTo(Integer value) {
            addCriterion("int_generica_nivel_i <>", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iGreaterThan(Integer value) {
            addCriterion("int_generica_nivel_i >", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_generica_nivel_i >=", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iLessThan(Integer value) {
            addCriterion("int_generica_nivel_i <", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iLessThanOrEqualTo(Integer value) {
            addCriterion("int_generica_nivel_i <=", value, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iIn(List<Integer> values) {
            addCriterion("int_generica_nivel_i in", values, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iNotIn(List<Integer> values) {
            addCriterion("int_generica_nivel_i not in", values, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iBetween(Integer value1, Integer value2) {
            addCriterion("int_generica_nivel_i between", value1, value2, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iNotBetween(Integer value1, Integer value2) {
            addCriterion("int_generica_nivel_i not between", value1, value2, "int_generica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiIsNull() {
            addCriterion("int_generica_nivel_ii is null");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiIsNotNull() {
            addCriterion("int_generica_nivel_ii is not null");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiEqualTo(Integer value) {
            addCriterion("int_generica_nivel_ii =", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiNotEqualTo(Integer value) {
            addCriterion("int_generica_nivel_ii <>", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiGreaterThan(Integer value) {
            addCriterion("int_generica_nivel_ii >", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_generica_nivel_ii >=", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiLessThan(Integer value) {
            addCriterion("int_generica_nivel_ii <", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiLessThanOrEqualTo(Integer value) {
            addCriterion("int_generica_nivel_ii <=", value, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiIn(List<Integer> values) {
            addCriterion("int_generica_nivel_ii in", values, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiNotIn(List<Integer> values) {
            addCriterion("int_generica_nivel_ii not in", values, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiBetween(Integer value1, Integer value2) {
            addCriterion("int_generica_nivel_ii between", value1, value2, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_generica_nivel_iiNotBetween(Integer value1, Integer value2) {
            addCriterion("int_generica_nivel_ii not between", value1, value2, "int_generica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iIsNull() {
            addCriterion("int_especifica_nivel_i is null");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iIsNotNull() {
            addCriterion("int_especifica_nivel_i is not null");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_i =", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iNotEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_i <>", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iGreaterThan(Integer value) {
            addCriterion("int_especifica_nivel_i >", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_i >=", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iLessThan(Integer value) {
            addCriterion("int_especifica_nivel_i <", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iLessThanOrEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_i <=", value, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iIn(List<Integer> values) {
            addCriterion("int_especifica_nivel_i in", values, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iNotIn(List<Integer> values) {
            addCriterion("int_especifica_nivel_i not in", values, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iBetween(Integer value1, Integer value2) {
            addCriterion("int_especifica_nivel_i between", value1, value2, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iNotBetween(Integer value1, Integer value2) {
            addCriterion("int_especifica_nivel_i not between", value1, value2, "int_especifica_nivel_i");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiIsNull() {
            addCriterion("int_especifica_nivel_ii is null");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiIsNotNull() {
            addCriterion("int_especifica_nivel_ii is not null");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_ii =", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiNotEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_ii <>", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiGreaterThan(Integer value) {
            addCriterion("int_especifica_nivel_ii >", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_ii >=", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiLessThan(Integer value) {
            addCriterion("int_especifica_nivel_ii <", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiLessThanOrEqualTo(Integer value) {
            addCriterion("int_especifica_nivel_ii <=", value, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiIn(List<Integer> values) {
            addCriterion("int_especifica_nivel_ii in", values, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiNotIn(List<Integer> values) {
            addCriterion("int_especifica_nivel_ii not in", values, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiBetween(Integer value1, Integer value2) {
            addCriterion("int_especifica_nivel_ii between", value1, value2, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andInt_especifica_nivel_iiNotBetween(Integer value1, Integer value2) {
            addCriterion("int_especifica_nivel_ii not between", value1, value2, "int_especifica_nivel_ii");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorIsNull() {
            addCriterion("var_descrip_clasificador is null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorIsNotNull() {
            addCriterion("var_descrip_clasificador is not null");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorEqualTo(String value) {
            addCriterion("var_descrip_clasificador =", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorNotEqualTo(String value) {
            addCriterion("var_descrip_clasificador <>", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorGreaterThan(String value) {
            addCriterion("var_descrip_clasificador >", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorGreaterThanOrEqualTo(String value) {
            addCriterion("var_descrip_clasificador >=", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorLessThan(String value) {
            addCriterion("var_descrip_clasificador <", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorLessThanOrEqualTo(String value) {
            addCriterion("var_descrip_clasificador <=", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorLike(String value) {
            addCriterion("var_descrip_clasificador like", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorNotLike(String value) {
            addCriterion("var_descrip_clasificador not like", value, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorIn(List<String> values) {
            addCriterion("var_descrip_clasificador in", values, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorNotIn(List<String> values) {
            addCriterion("var_descrip_clasificador not in", values, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorBetween(String value1, String value2) {
            addCriterion("var_descrip_clasificador between", value1, value2, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_descrip_clasificadorNotBetween(String value1, String value2) {
            addCriterion("var_descrip_clasificador not between", value1, value2, "var_descrip_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorIsNull() {
            addCriterion("var_detalle_clasificador is null");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorIsNotNull() {
            addCriterion("var_detalle_clasificador is not null");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorEqualTo(String value) {
            addCriterion("var_detalle_clasificador =", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorNotEqualTo(String value) {
            addCriterion("var_detalle_clasificador <>", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorGreaterThan(String value) {
            addCriterion("var_detalle_clasificador >", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorGreaterThanOrEqualTo(String value) {
            addCriterion("var_detalle_clasificador >=", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorLessThan(String value) {
            addCriterion("var_detalle_clasificador <", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorLessThanOrEqualTo(String value) {
            addCriterion("var_detalle_clasificador <=", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorLike(String value) {
            addCriterion("var_detalle_clasificador like", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorNotLike(String value) {
            addCriterion("var_detalle_clasificador not like", value, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorIn(List<String> values) {
            addCriterion("var_detalle_clasificador in", values, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorNotIn(List<String> values) {
            addCriterion("var_detalle_clasificador not in", values, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorBetween(String value1, String value2) {
            addCriterion("var_detalle_clasificador between", value1, value2, "var_detalle_clasificador");
            return (Criteria) this;
        }

        public Criteria andVar_detalle_clasificadorNotBetween(String value1, String value2) {
            addCriterion("var_detalle_clasificador not between", value1, value2, "var_detalle_clasificador");
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