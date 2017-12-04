package pe.com.acme.domain.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComprobanteItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComprobanteItemExample() {
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

        public Criteria andId_comprobante_itemIsNull() {
            addCriterion("id_comprobante_item is null");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemIsNotNull() {
            addCriterion("id_comprobante_item is not null");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemEqualTo(Integer value) {
            addCriterion("id_comprobante_item =", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemNotEqualTo(Integer value) {
            addCriterion("id_comprobante_item <>", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemGreaterThan(Integer value) {
            addCriterion("id_comprobante_item >", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_comprobante_item >=", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemLessThan(Integer value) {
            addCriterion("id_comprobante_item <", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemLessThanOrEqualTo(Integer value) {
            addCriterion("id_comprobante_item <=", value, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemIn(List<Integer> values) {
            addCriterion("id_comprobante_item in", values, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemNotIn(List<Integer> values) {
            addCriterion("id_comprobante_item not in", values, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemBetween(Integer value1, Integer value2) {
            addCriterion("id_comprobante_item between", value1, value2, "id_comprobante_item");
            return (Criteria) this;
        }

        public Criteria andId_comprobante_itemNotBetween(Integer value1, Integer value2) {
            addCriterion("id_comprobante_item not between", value1, value2, "id_comprobante_item");
            return (Criteria) this;
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

        public Criteria andId_articuloIsNull() {
            addCriterion("id_articulo is null");
            return (Criteria) this;
        }

        public Criteria andId_articuloIsNotNull() {
            addCriterion("id_articulo is not null");
            return (Criteria) this;
        }

        public Criteria andId_articuloEqualTo(Integer value) {
            addCriterion("id_articulo =", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloNotEqualTo(Integer value) {
            addCriterion("id_articulo <>", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloGreaterThan(Integer value) {
            addCriterion("id_articulo >", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_articulo >=", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloLessThan(Integer value) {
            addCriterion("id_articulo <", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloLessThanOrEqualTo(Integer value) {
            addCriterion("id_articulo <=", value, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloIn(List<Integer> values) {
            addCriterion("id_articulo in", values, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloNotIn(List<Integer> values) {
            addCriterion("id_articulo not in", values, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloBetween(Integer value1, Integer value2) {
            addCriterion("id_articulo between", value1, value2, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andId_articuloNotBetween(Integer value1, Integer value2) {
            addCriterion("id_articulo not between", value1, value2, "id_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloIsNull() {
            addCriterion("cantidad_articulo is null");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloIsNotNull() {
            addCriterion("cantidad_articulo is not null");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloEqualTo(Integer value) {
            addCriterion("cantidad_articulo =", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloNotEqualTo(Integer value) {
            addCriterion("cantidad_articulo <>", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloGreaterThan(Integer value) {
            addCriterion("cantidad_articulo >", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloGreaterThanOrEqualTo(Integer value) {
            addCriterion("cantidad_articulo >=", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloLessThan(Integer value) {
            addCriterion("cantidad_articulo <", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloLessThanOrEqualTo(Integer value) {
            addCriterion("cantidad_articulo <=", value, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloIn(List<Integer> values) {
            addCriterion("cantidad_articulo in", values, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloNotIn(List<Integer> values) {
            addCriterion("cantidad_articulo not in", values, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloBetween(Integer value1, Integer value2) {
            addCriterion("cantidad_articulo between", value1, value2, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andCantidad_articuloNotBetween(Integer value1, Integer value2) {
            addCriterion("cantidad_articulo not between", value1, value2, "cantidad_articulo");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaIsNull() {
            addCriterion("id_unidad_medida is null");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaIsNotNull() {
            addCriterion("id_unidad_medida is not null");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaEqualTo(Integer value) {
            addCriterion("id_unidad_medida =", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaNotEqualTo(Integer value) {
            addCriterion("id_unidad_medida <>", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaGreaterThan(Integer value) {
            addCriterion("id_unidad_medida >", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_unidad_medida >=", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaLessThan(Integer value) {
            addCriterion("id_unidad_medida <", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaLessThanOrEqualTo(Integer value) {
            addCriterion("id_unidad_medida <=", value, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaIn(List<Integer> values) {
            addCriterion("id_unidad_medida in", values, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaNotIn(List<Integer> values) {
            addCriterion("id_unidad_medida not in", values, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaBetween(Integer value1, Integer value2) {
            addCriterion("id_unidad_medida between", value1, value2, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andId_unidad_medidaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_unidad_medida not between", value1, value2, "id_unidad_medida");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloIsNull() {
            addCriterion("peso_articulo is null");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloIsNotNull() {
            addCriterion("peso_articulo is not null");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloEqualTo(BigDecimal value) {
            addCriterion("peso_articulo =", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloNotEqualTo(BigDecimal value) {
            addCriterion("peso_articulo <>", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloGreaterThan(BigDecimal value) {
            addCriterion("peso_articulo >", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("peso_articulo >=", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloLessThan(BigDecimal value) {
            addCriterion("peso_articulo <", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloLessThanOrEqualTo(BigDecimal value) {
            addCriterion("peso_articulo <=", value, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloIn(List<BigDecimal> values) {
            addCriterion("peso_articulo in", values, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloNotIn(List<BigDecimal> values) {
            addCriterion("peso_articulo not in", values, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peso_articulo between", value1, value2, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPeso_articuloNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peso_articulo not between", value1, value2, "peso_articulo");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioIsNull() {
            addCriterion("precio_unitario is null");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioIsNotNull() {
            addCriterion("precio_unitario is not null");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioEqualTo(BigDecimal value) {
            addCriterion("precio_unitario =", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioNotEqualTo(BigDecimal value) {
            addCriterion("precio_unitario <>", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioGreaterThan(BigDecimal value) {
            addCriterion("precio_unitario >", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("precio_unitario >=", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioLessThan(BigDecimal value) {
            addCriterion("precio_unitario <", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("precio_unitario <=", value, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioIn(List<BigDecimal> values) {
            addCriterion("precio_unitario in", values, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioNotIn(List<BigDecimal> values) {
            addCriterion("precio_unitario not in", values, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("precio_unitario between", value1, value2, "precio_unitario");
            return (Criteria) this;
        }

        public Criteria andPrecio_unitarioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("precio_unitario not between", value1, value2, "precio_unitario");
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