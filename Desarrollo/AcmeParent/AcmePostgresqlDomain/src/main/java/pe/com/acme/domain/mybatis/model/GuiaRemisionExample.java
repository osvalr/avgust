package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GuiaRemisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuiaRemisionExample() {
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

        public Criteria andId_guia_remisionIsNull() {
            addCriterion("id_guia_remision is null");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionIsNotNull() {
            addCriterion("id_guia_remision is not null");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionEqualTo(Integer value) {
            addCriterion("id_guia_remision =", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionNotEqualTo(Integer value) {
            addCriterion("id_guia_remision <>", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionGreaterThan(Integer value) {
            addCriterion("id_guia_remision >", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_guia_remision >=", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionLessThan(Integer value) {
            addCriterion("id_guia_remision <", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionLessThanOrEqualTo(Integer value) {
            addCriterion("id_guia_remision <=", value, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionIn(List<Integer> values) {
            addCriterion("id_guia_remision in", values, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionNotIn(List<Integer> values) {
            addCriterion("id_guia_remision not in", values, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionBetween(Integer value1, Integer value2) {
            addCriterion("id_guia_remision between", value1, value2, "id_guia_remision");
            return (Criteria) this;
        }

        public Criteria andId_guia_remisionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_guia_remision not between", value1, value2, "id_guia_remision");
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

        public Criteria andSerie_docu_guiaIsNull() {
            addCriterion("serie_docu_guia is null");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaIsNotNull() {
            addCriterion("serie_docu_guia is not null");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaEqualTo(String value) {
            addCriterion("serie_docu_guia =", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaNotEqualTo(String value) {
            addCriterion("serie_docu_guia <>", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaGreaterThan(String value) {
            addCriterion("serie_docu_guia >", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaGreaterThanOrEqualTo(String value) {
            addCriterion("serie_docu_guia >=", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaLessThan(String value) {
            addCriterion("serie_docu_guia <", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaLessThanOrEqualTo(String value) {
            addCriterion("serie_docu_guia <=", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaLike(String value) {
            addCriterion("serie_docu_guia like", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaNotLike(String value) {
            addCriterion("serie_docu_guia not like", value, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaIn(List<String> values) {
            addCriterion("serie_docu_guia in", values, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaNotIn(List<String> values) {
            addCriterion("serie_docu_guia not in", values, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaBetween(String value1, String value2) {
            addCriterion("serie_docu_guia between", value1, value2, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andSerie_docu_guiaNotBetween(String value1, String value2) {
            addCriterion("serie_docu_guia not between", value1, value2, "serie_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaIsNull() {
            addCriterion("correlativo_docu_guia is null");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaIsNotNull() {
            addCriterion("correlativo_docu_guia is not null");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaEqualTo(String value) {
            addCriterion("correlativo_docu_guia =", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaNotEqualTo(String value) {
            addCriterion("correlativo_docu_guia <>", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaGreaterThan(String value) {
            addCriterion("correlativo_docu_guia >", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaGreaterThanOrEqualTo(String value) {
            addCriterion("correlativo_docu_guia >=", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaLessThan(String value) {
            addCriterion("correlativo_docu_guia <", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaLessThanOrEqualTo(String value) {
            addCriterion("correlativo_docu_guia <=", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaLike(String value) {
            addCriterion("correlativo_docu_guia like", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaNotLike(String value) {
            addCriterion("correlativo_docu_guia not like", value, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaIn(List<String> values) {
            addCriterion("correlativo_docu_guia in", values, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaNotIn(List<String> values) {
            addCriterion("correlativo_docu_guia not in", values, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaBetween(String value1, String value2) {
            addCriterion("correlativo_docu_guia between", value1, value2, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andCorrelativo_docu_guiaNotBetween(String value1, String value2) {
            addCriterion("correlativo_docu_guia not between", value1, value2, "correlativo_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaIsNull() {
            addCriterion("num_docu_guia is null");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaIsNotNull() {
            addCriterion("num_docu_guia is not null");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaEqualTo(String value) {
            addCriterion("num_docu_guia =", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaNotEqualTo(String value) {
            addCriterion("num_docu_guia <>", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaGreaterThan(String value) {
            addCriterion("num_docu_guia >", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaGreaterThanOrEqualTo(String value) {
            addCriterion("num_docu_guia >=", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaLessThan(String value) {
            addCriterion("num_docu_guia <", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaLessThanOrEqualTo(String value) {
            addCriterion("num_docu_guia <=", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaLike(String value) {
            addCriterion("num_docu_guia like", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaNotLike(String value) {
            addCriterion("num_docu_guia not like", value, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaIn(List<String> values) {
            addCriterion("num_docu_guia in", values, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaNotIn(List<String> values) {
            addCriterion("num_docu_guia not in", values, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaBetween(String value1, String value2) {
            addCriterion("num_docu_guia between", value1, value2, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andNum_docu_guiaNotBetween(String value1, String value2) {
            addCriterion("num_docu_guia not between", value1, value2, "num_docu_guia");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoIsNull() {
            addCriterion("fecha_inicio_traslado is null");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoIsNotNull() {
            addCriterion("fecha_inicio_traslado is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado =", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado <>", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado >", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado >=", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoLessThan(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado <", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio_traslado <=", value, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_inicio_traslado in", values, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_inicio_traslado not in", values, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_inicio_traslado between", value1, value2, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andFecha_inicio_trasladoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_inicio_traslado not between", value1, value2, "fecha_inicio_traslado");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioIsNull() {
            addCriterion("id_destinatario is null");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioIsNotNull() {
            addCriterion("id_destinatario is not null");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioEqualTo(Integer value) {
            addCriterion("id_destinatario =", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioNotEqualTo(Integer value) {
            addCriterion("id_destinatario <>", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioGreaterThan(Integer value) {
            addCriterion("id_destinatario >", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_destinatario >=", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioLessThan(Integer value) {
            addCriterion("id_destinatario <", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioLessThanOrEqualTo(Integer value) {
            addCriterion("id_destinatario <=", value, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioIn(List<Integer> values) {
            addCriterion("id_destinatario in", values, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioNotIn(List<Integer> values) {
            addCriterion("id_destinatario not in", values, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioBetween(Integer value1, Integer value2) {
            addCriterion("id_destinatario between", value1, value2, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_destinatarioNotBetween(Integer value1, Integer value2) {
            addCriterion("id_destinatario not between", value1, value2, "id_destinatario");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoIsNull() {
            addCriterion("id_motivo_traslado is null");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoIsNotNull() {
            addCriterion("id_motivo_traslado is not null");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoEqualTo(Integer value) {
            addCriterion("id_motivo_traslado =", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoNotEqualTo(Integer value) {
            addCriterion("id_motivo_traslado <>", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoGreaterThan(Integer value) {
            addCriterion("id_motivo_traslado >", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_motivo_traslado >=", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoLessThan(Integer value) {
            addCriterion("id_motivo_traslado <", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoLessThanOrEqualTo(Integer value) {
            addCriterion("id_motivo_traslado <=", value, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoIn(List<Integer> values) {
            addCriterion("id_motivo_traslado in", values, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoNotIn(List<Integer> values) {
            addCriterion("id_motivo_traslado not in", values, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoBetween(Integer value1, Integer value2) {
            addCriterion("id_motivo_traslado between", value1, value2, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andId_motivo_trasladoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_motivo_traslado not between", value1, value2, "id_motivo_traslado");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaIsNull() {
            addCriterion("direccion_partida is null");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaIsNotNull() {
            addCriterion("direccion_partida is not null");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaEqualTo(String value) {
            addCriterion("direccion_partida =", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaNotEqualTo(String value) {
            addCriterion("direccion_partida <>", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaGreaterThan(String value) {
            addCriterion("direccion_partida >", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaGreaterThanOrEqualTo(String value) {
            addCriterion("direccion_partida >=", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaLessThan(String value) {
            addCriterion("direccion_partida <", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaLessThanOrEqualTo(String value) {
            addCriterion("direccion_partida <=", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaLike(String value) {
            addCriterion("direccion_partida like", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaNotLike(String value) {
            addCriterion("direccion_partida not like", value, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaIn(List<String> values) {
            addCriterion("direccion_partida in", values, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaNotIn(List<String> values) {
            addCriterion("direccion_partida not in", values, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaBetween(String value1, String value2) {
            addCriterion("direccion_partida between", value1, value2, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_partidaNotBetween(String value1, String value2) {
            addCriterion("direccion_partida not between", value1, value2, "direccion_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaIsNull() {
            addCriterion("id_departamento_partida is null");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaIsNotNull() {
            addCriterion("id_departamento_partida is not null");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaEqualTo(Integer value) {
            addCriterion("id_departamento_partida =", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaNotEqualTo(Integer value) {
            addCriterion("id_departamento_partida <>", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaGreaterThan(Integer value) {
            addCriterion("id_departamento_partida >", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_departamento_partida >=", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaLessThan(Integer value) {
            addCriterion("id_departamento_partida <", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaLessThanOrEqualTo(Integer value) {
            addCriterion("id_departamento_partida <=", value, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaIn(List<Integer> values) {
            addCriterion("id_departamento_partida in", values, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaNotIn(List<Integer> values) {
            addCriterion("id_departamento_partida not in", values, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaBetween(Integer value1, Integer value2) {
            addCriterion("id_departamento_partida between", value1, value2, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_departamento_partidaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_departamento_partida not between", value1, value2, "id_departamento_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaIsNull() {
            addCriterion("id_provincia_partida is null");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaIsNotNull() {
            addCriterion("id_provincia_partida is not null");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaEqualTo(Integer value) {
            addCriterion("id_provincia_partida =", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaNotEqualTo(Integer value) {
            addCriterion("id_provincia_partida <>", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaGreaterThan(Integer value) {
            addCriterion("id_provincia_partida >", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_provincia_partida >=", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaLessThan(Integer value) {
            addCriterion("id_provincia_partida <", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaLessThanOrEqualTo(Integer value) {
            addCriterion("id_provincia_partida <=", value, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaIn(List<Integer> values) {
            addCriterion("id_provincia_partida in", values, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaNotIn(List<Integer> values) {
            addCriterion("id_provincia_partida not in", values, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaBetween(Integer value1, Integer value2) {
            addCriterion("id_provincia_partida between", value1, value2, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_provincia_partidaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_provincia_partida not between", value1, value2, "id_provincia_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaIsNull() {
            addCriterion("id_distrito_partida is null");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaIsNotNull() {
            addCriterion("id_distrito_partida is not null");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaEqualTo(Integer value) {
            addCriterion("id_distrito_partida =", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaNotEqualTo(Integer value) {
            addCriterion("id_distrito_partida <>", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaGreaterThan(Integer value) {
            addCriterion("id_distrito_partida >", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_distrito_partida >=", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaLessThan(Integer value) {
            addCriterion("id_distrito_partida <", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaLessThanOrEqualTo(Integer value) {
            addCriterion("id_distrito_partida <=", value, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaIn(List<Integer> values) {
            addCriterion("id_distrito_partida in", values, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaNotIn(List<Integer> values) {
            addCriterion("id_distrito_partida not in", values, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaBetween(Integer value1, Integer value2) {
            addCriterion("id_distrito_partida between", value1, value2, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andId_distrito_partidaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_distrito_partida not between", value1, value2, "id_distrito_partida");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaIsNull() {
            addCriterion("direccion_llegada is null");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaIsNotNull() {
            addCriterion("direccion_llegada is not null");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaEqualTo(String value) {
            addCriterion("direccion_llegada =", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaNotEqualTo(String value) {
            addCriterion("direccion_llegada <>", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaGreaterThan(String value) {
            addCriterion("direccion_llegada >", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaGreaterThanOrEqualTo(String value) {
            addCriterion("direccion_llegada >=", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaLessThan(String value) {
            addCriterion("direccion_llegada <", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaLessThanOrEqualTo(String value) {
            addCriterion("direccion_llegada <=", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaLike(String value) {
            addCriterion("direccion_llegada like", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaNotLike(String value) {
            addCriterion("direccion_llegada not like", value, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaIn(List<String> values) {
            addCriterion("direccion_llegada in", values, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaNotIn(List<String> values) {
            addCriterion("direccion_llegada not in", values, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaBetween(String value1, String value2) {
            addCriterion("direccion_llegada between", value1, value2, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andDireccion_llegadaNotBetween(String value1, String value2) {
            addCriterion("direccion_llegada not between", value1, value2, "direccion_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaIsNull() {
            addCriterion("id_departamento_llegada is null");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaIsNotNull() {
            addCriterion("id_departamento_llegada is not null");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaEqualTo(Integer value) {
            addCriterion("id_departamento_llegada =", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaNotEqualTo(Integer value) {
            addCriterion("id_departamento_llegada <>", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaGreaterThan(Integer value) {
            addCriterion("id_departamento_llegada >", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_departamento_llegada >=", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaLessThan(Integer value) {
            addCriterion("id_departamento_llegada <", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaLessThanOrEqualTo(Integer value) {
            addCriterion("id_departamento_llegada <=", value, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaIn(List<Integer> values) {
            addCriterion("id_departamento_llegada in", values, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaNotIn(List<Integer> values) {
            addCriterion("id_departamento_llegada not in", values, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaBetween(Integer value1, Integer value2) {
            addCriterion("id_departamento_llegada between", value1, value2, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_departamento_llegadaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_departamento_llegada not between", value1, value2, "id_departamento_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaIsNull() {
            addCriterion("id_provincia_llegada is null");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaIsNotNull() {
            addCriterion("id_provincia_llegada is not null");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaEqualTo(Integer value) {
            addCriterion("id_provincia_llegada =", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaNotEqualTo(Integer value) {
            addCriterion("id_provincia_llegada <>", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaGreaterThan(Integer value) {
            addCriterion("id_provincia_llegada >", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_provincia_llegada >=", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaLessThan(Integer value) {
            addCriterion("id_provincia_llegada <", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaLessThanOrEqualTo(Integer value) {
            addCriterion("id_provincia_llegada <=", value, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaIn(List<Integer> values) {
            addCriterion("id_provincia_llegada in", values, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaNotIn(List<Integer> values) {
            addCriterion("id_provincia_llegada not in", values, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaBetween(Integer value1, Integer value2) {
            addCriterion("id_provincia_llegada between", value1, value2, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_provincia_llegadaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_provincia_llegada not between", value1, value2, "id_provincia_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaIsNull() {
            addCriterion("id_distrito_llegada is null");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaIsNotNull() {
            addCriterion("id_distrito_llegada is not null");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaEqualTo(Integer value) {
            addCriterion("id_distrito_llegada =", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaNotEqualTo(Integer value) {
            addCriterion("id_distrito_llegada <>", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaGreaterThan(Integer value) {
            addCriterion("id_distrito_llegada >", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_distrito_llegada >=", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaLessThan(Integer value) {
            addCriterion("id_distrito_llegada <", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaLessThanOrEqualTo(Integer value) {
            addCriterion("id_distrito_llegada <=", value, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaIn(List<Integer> values) {
            addCriterion("id_distrito_llegada in", values, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaNotIn(List<Integer> values) {
            addCriterion("id_distrito_llegada not in", values, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaBetween(Integer value1, Integer value2) {
            addCriterion("id_distrito_llegada between", value1, value2, "id_distrito_llegada");
            return (Criteria) this;
        }

        public Criteria andId_distrito_llegadaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_distrito_llegada not between", value1, value2, "id_distrito_llegada");
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