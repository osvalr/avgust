package pe.com.acme.domain.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ComprobantePagoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComprobantePagoExample() {
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

        public Criteria andId_comprobante_pagoIsNull() {
            addCriterion("id_comprobante_pago is null");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoIsNotNull() {
            addCriterion("id_comprobante_pago is not null");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoEqualTo(Integer value) {
            addCriterion("id_comprobante_pago =", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoNotEqualTo(Integer value) {
            addCriterion("id_comprobante_pago <>", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoGreaterThan(Integer value) {
            addCriterion("id_comprobante_pago >", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_comprobante_pago >=", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoLessThan(Integer value) {
            addCriterion("id_comprobante_pago <", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoLessThanOrEqualTo(Integer value) {
            addCriterion("id_comprobante_pago <=", value, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoIn(List<Integer> values) {
            addCriterion("id_comprobante_pago in", values, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoNotIn(List<Integer> values) {
            addCriterion("id_comprobante_pago not in", values, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoBetween(Integer value1, Integer value2) {
            addCriterion("id_comprobante_pago between", value1, value2, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_pagoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_comprobante_pago not between", value1, value2, "id_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoIsNull() {
            addCriterion("id_tipo_comprobante_pago is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoIsNotNull() {
            addCriterion("id_tipo_comprobante_pago is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoEqualTo(Integer value) {
            addCriterion("id_tipo_comprobante_pago =", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoNotEqualTo(Integer value) {
            addCriterion("id_tipo_comprobante_pago <>", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoGreaterThan(Integer value) {
            addCriterion("id_tipo_comprobante_pago >", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_comprobante_pago >=", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoLessThan(Integer value) {
            addCriterion("id_tipo_comprobante_pago <", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_comprobante_pago <=", value, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoIn(List<Integer> values) {
            addCriterion("id_tipo_comprobante_pago in", values, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoNotIn(List<Integer> values) {
            addCriterion("id_tipo_comprobante_pago not in", values, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_comprobante_pago between", value1, value2, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andId_tipo_comprobante_pagoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_comprobante_pago not between", value1, value2, "id_tipo_comprobante_pago");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionIsNull() {
            addCriterion("fecha_emision is null");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionIsNotNull() {
            addCriterion("fecha_emision is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_emision =", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_emision <>", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_emision >", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_emision >=", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionLessThan(Date value) {
            addCriterionForJDBCDate("fecha_emision <", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_emision <=", value, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_emision in", values, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_emision not in", values, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_emision between", value1, value2, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_emisionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_emision not between", value1, value2, "fecha_emision");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoIsNull() {
            addCriterion("fecha_cancelado is null");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoIsNotNull() {
            addCriterion("fecha_cancelado is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_cancelado =", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_cancelado <>", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_cancelado >", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_cancelado >=", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoLessThan(Date value) {
            addCriterionForJDBCDate("fecha_cancelado <", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_cancelado <=", value, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_cancelado in", values, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_cancelado not in", values, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_cancelado between", value1, value2, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andFecha_canceladoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_cancelado not between", value1, value2, "fecha_cancelado");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteIsNull() {
            addCriterion("serie_docu_comprobante is null");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteIsNotNull() {
            addCriterion("serie_docu_comprobante is not null");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteEqualTo(String value) {
            addCriterion("serie_docu_comprobante =", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteNotEqualTo(String value) {
            addCriterion("serie_docu_comprobante <>", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteGreaterThan(String value) {
            addCriterion("serie_docu_comprobante >", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteGreaterThanOrEqualTo(String value) {
            addCriterion("serie_docu_comprobante >=", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteLessThan(String value) {
            addCriterion("serie_docu_comprobante <", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteLessThanOrEqualTo(String value) {
            addCriterion("serie_docu_comprobante <=", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteLike(String value) {
            addCriterion("serie_docu_comprobante like", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteNotLike(String value) {
            addCriterion("serie_docu_comprobante not like", value, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteIn(List<String> values) {
            addCriterion("serie_docu_comprobante in", values, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteNotIn(List<String> values) {
            addCriterion("serie_docu_comprobante not in", values, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteBetween(String value1, String value2) {
            addCriterion("serie_docu_comprobante between", value1, value2, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_comprobanteNotBetween(String value1, String value2) {
            addCriterion("serie_docu_comprobante not between", value1, value2, "serie_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpIsNull() {
            addCriterion("correlativo_docu_cdp is null");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpIsNotNull() {
            addCriterion("correlativo_docu_cdp is not null");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpEqualTo(String value) {
            addCriterion("correlativo_docu_cdp =", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpNotEqualTo(String value) {
            addCriterion("correlativo_docu_cdp <>", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpGreaterThan(String value) {
            addCriterion("correlativo_docu_cdp >", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpGreaterThanOrEqualTo(String value) {
            addCriterion("correlativo_docu_cdp >=", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpLessThan(String value) {
            addCriterion("correlativo_docu_cdp <", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpLessThanOrEqualTo(String value) {
            addCriterion("correlativo_docu_cdp <=", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpLike(String value) {
            addCriterion("correlativo_docu_cdp like", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpNotLike(String value) {
            addCriterion("correlativo_docu_cdp not like", value, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpIn(List<String> values) {
            addCriterion("correlativo_docu_cdp in", values, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpNotIn(List<String> values) {
            addCriterion("correlativo_docu_cdp not in", values, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpBetween(String value1, String value2) {
            addCriterion("correlativo_docu_cdp between", value1, value2, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_cdpNotBetween(String value1, String value2) {
            addCriterion("correlativo_docu_cdp not between", value1, value2, "correlativo_docu_cdp");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteIsNull() {
            addCriterion("num_docu_comprobante is null");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteIsNotNull() {
            addCriterion("num_docu_comprobante is not null");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteEqualTo(String value) {
            addCriterion("num_docu_comprobante =", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteNotEqualTo(String value) {
            addCriterion("num_docu_comprobante <>", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteGreaterThan(String value) {
            addCriterion("num_docu_comprobante >", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteGreaterThanOrEqualTo(String value) {
            addCriterion("num_docu_comprobante >=", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteLessThan(String value) {
            addCriterion("num_docu_comprobante <", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteLessThanOrEqualTo(String value) {
            addCriterion("num_docu_comprobante <=", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteLike(String value) {
            addCriterion("num_docu_comprobante like", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteNotLike(String value) {
            addCriterion("num_docu_comprobante not like", value, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteIn(List<String> values) {
            addCriterion("num_docu_comprobante in", values, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteNotIn(List<String> values) {
            addCriterion("num_docu_comprobante not in", values, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteBetween(String value1, String value2) {
            addCriterion("num_docu_comprobante between", value1, value2, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andNum_docu_comprobanteNotBetween(String value1, String value2) {
            addCriterion("num_docu_comprobante not between", value1, value2, "num_docu_comprobante");
            return (Criteria) this;
        }

        public Criteria andId_clienteIsNull() {
            addCriterion("id_cliente is null");
            return (Criteria) this;
        }

        public Criteria andId_clienteIsNotNull() {
            addCriterion("id_cliente is not null");
            return (Criteria) this;
        }

        public Criteria andId_clienteEqualTo(Integer value) {
            addCriterion("id_cliente =", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteNotEqualTo(Integer value) {
            addCriterion("id_cliente <>", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteGreaterThan(Integer value) {
            addCriterion("id_cliente >", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_cliente >=", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteLessThan(Integer value) {
            addCriterion("id_cliente <", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteLessThanOrEqualTo(Integer value) {
            addCriterion("id_cliente <=", value, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteIn(List<Integer> values) {
            addCriterion("id_cliente in", values, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteNotIn(List<Integer> values) {
            addCriterion("id_cliente not in", values, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteBetween(Integer value1, Integer value2) {
            addCriterion("id_cliente between", value1, value2, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andId_clienteNotBetween(Integer value1, Integer value2) {
            addCriterion("id_cliente not between", value1, value2, "id_cliente");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaIsNull() {
            addCriterion("sub_total_venta is null");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaIsNotNull() {
            addCriterion("sub_total_venta is not null");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaEqualTo(BigDecimal value) {
            addCriterion("sub_total_venta =", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaNotEqualTo(BigDecimal value) {
            addCriterion("sub_total_venta <>", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaGreaterThan(BigDecimal value) {
            addCriterion("sub_total_venta >", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sub_total_venta >=", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaLessThan(BigDecimal value) {
            addCriterion("sub_total_venta <", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sub_total_venta <=", value, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaIn(List<BigDecimal> values) {
            addCriterion("sub_total_venta in", values, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaNotIn(List<BigDecimal> values) {
            addCriterion("sub_total_venta not in", values, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sub_total_venta between", value1, value2, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andSub_total_ventaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sub_total_venta not between", value1, value2, "sub_total_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaIsNull() {
            addCriterion("valor_igv_venta is null");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaIsNotNull() {
            addCriterion("valor_igv_venta is not null");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaEqualTo(BigDecimal value) {
            addCriterion("valor_igv_venta =", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaNotEqualTo(BigDecimal value) {
            addCriterion("valor_igv_venta <>", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaGreaterThan(BigDecimal value) {
            addCriterion("valor_igv_venta >", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("valor_igv_venta >=", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaLessThan(BigDecimal value) {
            addCriterion("valor_igv_venta <", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("valor_igv_venta <=", value, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaIn(List<BigDecimal> values) {
            addCriterion("valor_igv_venta in", values, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaNotIn(List<BigDecimal> values) {
            addCriterion("valor_igv_venta not in", values, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valor_igv_venta between", value1, value2, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andValor_igv_ventaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("valor_igv_venta not between", value1, value2, "valor_igv_venta");
            return (Criteria) this;
        }

        public Criteria andImporte_totalIsNull() {
            addCriterion("importe_total is null");
            return (Criteria) this;
        }

        public Criteria andImporte_totalIsNotNull() {
            addCriterion("importe_total is not null");
            return (Criteria) this;
        }

        public Criteria andImporte_totalEqualTo(BigDecimal value) {
            addCriterion("importe_total =", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalNotEqualTo(BigDecimal value) {
            addCriterion("importe_total <>", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalGreaterThan(BigDecimal value) {
            addCriterion("importe_total >", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("importe_total >=", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalLessThan(BigDecimal value) {
            addCriterion("importe_total <", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("importe_total <=", value, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalIn(List<BigDecimal> values) {
            addCriterion("importe_total in", values, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalNotIn(List<BigDecimal> values) {
            addCriterion("importe_total not in", values, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("importe_total between", value1, value2, "importe_total");
            return (Criteria) this;
        }

        public Criteria andImporte_totalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("importe_total not between", value1, value2, "importe_total");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionIsNull() {
            addCriterion("flag_percepcion is null");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionIsNotNull() {
            addCriterion("flag_percepcion is not null");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionEqualTo(Integer value) {
            addCriterion("flag_percepcion =", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionNotEqualTo(Integer value) {
            addCriterion("flag_percepcion <>", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionGreaterThan(Integer value) {
            addCriterion("flag_percepcion >", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag_percepcion >=", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionLessThan(Integer value) {
            addCriterion("flag_percepcion <", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionLessThanOrEqualTo(Integer value) {
            addCriterion("flag_percepcion <=", value, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionIn(List<Integer> values) {
            addCriterion("flag_percepcion in", values, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionNotIn(List<Integer> values) {
            addCriterion("flag_percepcion not in", values, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionBetween(Integer value1, Integer value2) {
            addCriterion("flag_percepcion between", value1, value2, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andFlag_percepcionNotBetween(Integer value1, Integer value2) {
            addCriterion("flag_percepcion not between", value1, value2, "flag_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionIsNull() {
            addCriterion("porcentaje_percepcion is null");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionIsNotNull() {
            addCriterion("porcentaje_percepcion is not null");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionEqualTo(BigDecimal value) {
            addCriterion("porcentaje_percepcion =", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionNotEqualTo(BigDecimal value) {
            addCriterion("porcentaje_percepcion <>", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionGreaterThan(BigDecimal value) {
            addCriterion("porcentaje_percepcion >", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("porcentaje_percepcion >=", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionLessThan(BigDecimal value) {
            addCriterion("porcentaje_percepcion <", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("porcentaje_percepcion <=", value, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionIn(List<BigDecimal> values) {
            addCriterion("porcentaje_percepcion in", values, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionNotIn(List<BigDecimal> values) {
            addCriterion("porcentaje_percepcion not in", values, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("porcentaje_percepcion between", value1, value2, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andPorcentaje_percepcionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("porcentaje_percepcion not between", value1, value2, "porcentaje_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionIsNull() {
            addCriterion("monto_percepcion is null");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionIsNotNull() {
            addCriterion("monto_percepcion is not null");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionEqualTo(BigDecimal value) {
            addCriterion("monto_percepcion =", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionNotEqualTo(BigDecimal value) {
            addCriterion("monto_percepcion <>", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionGreaterThan(BigDecimal value) {
            addCriterion("monto_percepcion >", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monto_percepcion >=", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionLessThan(BigDecimal value) {
            addCriterion("monto_percepcion <", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monto_percepcion <=", value, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionIn(List<BigDecimal> values) {
            addCriterion("monto_percepcion in", values, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionNotIn(List<BigDecimal> values) {
            addCriterion("monto_percepcion not in", values, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monto_percepcion between", value1, value2, "monto_percepcion");
            return (Criteria) this;
        }

        public Criteria andMonto_percepcionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monto_percepcion not between", value1, value2, "monto_percepcion");
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