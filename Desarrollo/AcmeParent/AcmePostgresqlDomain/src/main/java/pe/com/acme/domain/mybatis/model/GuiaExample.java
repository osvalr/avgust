package pe.com.acme.domain.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuiaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuiaExample() {
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

        public Criteria andId_guiaIsNull() {
            addCriterion("id_guia is null");
            return (Criteria) this;
        }

        public Criteria andId_guiaIsNotNull() {
            addCriterion("id_guia is not null");
            return (Criteria) this;
        }

        public Criteria andId_guiaEqualTo(Integer value) {
            addCriterion("id_guia =", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaNotEqualTo(Integer value) {
            addCriterion("id_guia <>", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaGreaterThan(Integer value) {
            addCriterion("id_guia >", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_guia >=", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaLessThan(Integer value) {
            addCriterion("id_guia <", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaLessThanOrEqualTo(Integer value) {
            addCriterion("id_guia <=", value, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaIn(List<Integer> values) {
            addCriterion("id_guia in", values, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaNotIn(List<Integer> values) {
            addCriterion("id_guia not in", values, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaBetween(Integer value1, Integer value2) {
            addCriterion("id_guia between", value1, value2, "id_guia");
            return (Criteria) this;
        }

        public Criteria andId_guiaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_guia not between", value1, value2, "id_guia");
            return (Criteria) this;
        }

        public Criteria andNum_diaIsNull() {
            addCriterion("num_dia is null");
            return (Criteria) this;
        }

        public Criteria andNum_diaIsNotNull() {
            addCriterion("num_dia is not null");
            return (Criteria) this;
        }

        public Criteria andNum_diaEqualTo(Integer value) {
            addCriterion("num_dia =", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotEqualTo(Integer value) {
            addCriterion("num_dia <>", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaGreaterThan(Integer value) {
            addCriterion("num_dia >", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_dia >=", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaLessThan(Integer value) {
            addCriterion("num_dia <", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaLessThanOrEqualTo(Integer value) {
            addCriterion("num_dia <=", value, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaIn(List<Integer> values) {
            addCriterion("num_dia in", values, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotIn(List<Integer> values) {
            addCriterion("num_dia not in", values, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaBetween(Integer value1, Integer value2) {
            addCriterion("num_dia between", value1, value2, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_diaNotBetween(Integer value1, Integer value2) {
            addCriterion("num_dia not between", value1, value2, "num_dia");
            return (Criteria) this;
        }

        public Criteria andNum_mesIsNull() {
            addCriterion("num_mes is null");
            return (Criteria) this;
        }

        public Criteria andNum_mesIsNotNull() {
            addCriterion("num_mes is not null");
            return (Criteria) this;
        }

        public Criteria andNum_mesEqualTo(Integer value) {
            addCriterion("num_mes =", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotEqualTo(Integer value) {
            addCriterion("num_mes <>", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesGreaterThan(Integer value) {
            addCriterion("num_mes >", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_mes >=", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesLessThan(Integer value) {
            addCriterion("num_mes <", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesLessThanOrEqualTo(Integer value) {
            addCriterion("num_mes <=", value, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesIn(List<Integer> values) {
            addCriterion("num_mes in", values, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotIn(List<Integer> values) {
            addCriterion("num_mes not in", values, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesBetween(Integer value1, Integer value2) {
            addCriterion("num_mes between", value1, value2, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_mesNotBetween(Integer value1, Integer value2) {
            addCriterion("num_mes not between", value1, value2, "num_mes");
            return (Criteria) this;
        }

        public Criteria andNum_anioIsNull() {
            addCriterion("num_anio is null");
            return (Criteria) this;
        }

        public Criteria andNum_anioIsNotNull() {
            addCriterion("num_anio is not null");
            return (Criteria) this;
        }

        public Criteria andNum_anioEqualTo(Integer value) {
            addCriterion("num_anio =", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotEqualTo(Integer value) {
            addCriterion("num_anio <>", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioGreaterThan(Integer value) {
            addCriterion("num_anio >", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_anio >=", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioLessThan(Integer value) {
            addCriterion("num_anio <", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioLessThanOrEqualTo(Integer value) {
            addCriterion("num_anio <=", value, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioIn(List<Integer> values) {
            addCriterion("num_anio in", values, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotIn(List<Integer> values) {
            addCriterion("num_anio not in", values, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioBetween(Integer value1, Integer value2) {
            addCriterion("num_anio between", value1, value2, "num_anio");
            return (Criteria) this;
        }

        public Criteria andNum_anioNotBetween(Integer value1, Integer value2) {
            addCriterion("num_anio not between", value1, value2, "num_anio");
            return (Criteria) this;
        }

        public Criteria andId_proveedorIsNull() {
            addCriterion("id_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andId_proveedorIsNotNull() {
            addCriterion("id_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andId_proveedorEqualTo(Integer value) {
            addCriterion("id_proveedor =", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorNotEqualTo(Integer value) {
            addCriterion("id_proveedor <>", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorGreaterThan(Integer value) {
            addCriterion("id_proveedor >", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_proveedor >=", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorLessThan(Integer value) {
            addCriterion("id_proveedor <", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorLessThanOrEqualTo(Integer value) {
            addCriterion("id_proveedor <=", value, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorIn(List<Integer> values) {
            addCriterion("id_proveedor in", values, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorNotIn(List<Integer> values) {
            addCriterion("id_proveedor not in", values, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorBetween(Integer value1, Integer value2) {
            addCriterion("id_proveedor between", value1, value2, "id_proveedor");
            return (Criteria) this;
        }

        public Criteria andId_proveedorNotBetween(Integer value1, Integer value2) {
            addCriterion("id_proveedor not between", value1, value2, "id_proveedor");
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

        public Criteria andId_tipo_mvto_guiaIsNull() {
            addCriterion("id_tipo_mvto_guia is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaIsNotNull() {
            addCriterion("id_tipo_mvto_guia is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaEqualTo(Integer value) {
            addCriterion("id_tipo_mvto_guia =", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaNotEqualTo(Integer value) {
            addCriterion("id_tipo_mvto_guia <>", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaGreaterThan(Integer value) {
            addCriterion("id_tipo_mvto_guia >", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_mvto_guia >=", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaLessThan(Integer value) {
            addCriterion("id_tipo_mvto_guia <", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_mvto_guia <=", value, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaIn(List<Integer> values) {
            addCriterion("id_tipo_mvto_guia in", values, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaNotIn(List<Integer> values) {
            addCriterion("id_tipo_mvto_guia not in", values, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_mvto_guia between", value1, value2, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_mvto_guiaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_mvto_guia not between", value1, value2, "id_tipo_mvto_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoIsNull() {
            addCriterion("id_tipo_producto is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoIsNotNull() {
            addCriterion("id_tipo_producto is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoEqualTo(Integer value) {
            addCriterion("id_tipo_producto =", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoNotEqualTo(Integer value) {
            addCriterion("id_tipo_producto <>", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoGreaterThan(Integer value) {
            addCriterion("id_tipo_producto >", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_producto >=", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoLessThan(Integer value) {
            addCriterion("id_tipo_producto <", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_producto <=", value, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoIn(List<Integer> values) {
            addCriterion("id_tipo_producto in", values, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoNotIn(List<Integer> values) {
            addCriterion("id_tipo_producto not in", values, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_producto between", value1, value2, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andId_tipo_productoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_producto not between", value1, value2, "id_tipo_producto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoIsNull() {
            addCriterion("total_peso_bruto is null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoIsNotNull() {
            addCriterion("total_peso_bruto is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoEqualTo(BigDecimal value) {
            addCriterion("total_peso_bruto =", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoNotEqualTo(BigDecimal value) {
            addCriterion("total_peso_bruto <>", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoGreaterThan(BigDecimal value) {
            addCriterion("total_peso_bruto >", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_bruto >=", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoLessThan(BigDecimal value) {
            addCriterion("total_peso_bruto <", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_bruto <=", value, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoIn(List<BigDecimal> values) {
            addCriterion("total_peso_bruto in", values, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoNotIn(List<BigDecimal> values) {
            addCriterion("total_peso_bruto not in", values, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_bruto between", value1, value2, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_brutoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_bruto not between", value1, value2, "total_peso_bruto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraIsNull() {
            addCriterion("total_peso_tara is null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraIsNotNull() {
            addCriterion("total_peso_tara is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraEqualTo(BigDecimal value) {
            addCriterion("total_peso_tara =", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraNotEqualTo(BigDecimal value) {
            addCriterion("total_peso_tara <>", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraGreaterThan(BigDecimal value) {
            addCriterion("total_peso_tara >", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_tara >=", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraLessThan(BigDecimal value) {
            addCriterion("total_peso_tara <", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_tara <=", value, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraIn(List<BigDecimal> values) {
            addCriterion("total_peso_tara in", values, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraNotIn(List<BigDecimal> values) {
            addCriterion("total_peso_tara not in", values, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_tara between", value1, value2, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_taraNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_tara not between", value1, value2, "total_peso_tara");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionIsNull() {
            addCriterion("total_peso_devolucion is null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionIsNotNull() {
            addCriterion("total_peso_devolucion is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionEqualTo(BigDecimal value) {
            addCriterion("total_peso_devolucion =", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionNotEqualTo(BigDecimal value) {
            addCriterion("total_peso_devolucion <>", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionGreaterThan(BigDecimal value) {
            addCriterion("total_peso_devolucion >", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_devolucion >=", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionLessThan(BigDecimal value) {
            addCriterion("total_peso_devolucion <", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_devolucion <=", value, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionIn(List<BigDecimal> values) {
            addCriterion("total_peso_devolucion in", values, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionNotIn(List<BigDecimal> values) {
            addCriterion("total_peso_devolucion not in", values, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_devolucion between", value1, value2, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_devolucionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_devolucion not between", value1, value2, "total_peso_devolucion");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoIsNull() {
            addCriterion("total_peso_neto is null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoIsNotNull() {
            addCriterion("total_peso_neto is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoEqualTo(BigDecimal value) {
            addCriterion("total_peso_neto =", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoNotEqualTo(BigDecimal value) {
            addCriterion("total_peso_neto <>", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoGreaterThan(BigDecimal value) {
            addCriterion("total_peso_neto >", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_neto >=", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoLessThan(BigDecimal value) {
            addCriterion("total_peso_neto <", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_peso_neto <=", value, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoIn(List<BigDecimal> values) {
            addCriterion("total_peso_neto in", values, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoNotIn(List<BigDecimal> values) {
            addCriterion("total_peso_neto not in", values, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_neto between", value1, value2, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andTotal_peso_netoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_peso_neto not between", value1, value2, "total_peso_neto");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoIsNull() {
            addCriterion("precio_aplicado is null");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoIsNotNull() {
            addCriterion("precio_aplicado is not null");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoEqualTo(BigDecimal value) {
            addCriterion("precio_aplicado =", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoNotEqualTo(BigDecimal value) {
            addCriterion("precio_aplicado <>", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoGreaterThan(BigDecimal value) {
            addCriterion("precio_aplicado >", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("precio_aplicado >=", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoLessThan(BigDecimal value) {
            addCriterion("precio_aplicado <", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("precio_aplicado <=", value, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoIn(List<BigDecimal> values) {
            addCriterion("precio_aplicado in", values, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoNotIn(List<BigDecimal> values) {
            addCriterion("precio_aplicado not in", values, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("precio_aplicado between", value1, value2, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andPrecio_aplicadoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("precio_aplicado not between", value1, value2, "precio_aplicado");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localIsNull() {
            addCriterion("id_moneda_local is null");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localIsNotNull() {
            addCriterion("id_moneda_local is not null");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localEqualTo(Integer value) {
            addCriterion("id_moneda_local =", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localNotEqualTo(Integer value) {
            addCriterion("id_moneda_local <>", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localGreaterThan(Integer value) {
            addCriterion("id_moneda_local >", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_moneda_local >=", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localLessThan(Integer value) {
            addCriterion("id_moneda_local <", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localLessThanOrEqualTo(Integer value) {
            addCriterion("id_moneda_local <=", value, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localIn(List<Integer> values) {
            addCriterion("id_moneda_local in", values, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localNotIn(List<Integer> values) {
            addCriterion("id_moneda_local not in", values, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localBetween(Integer value1, Integer value2) {
            addCriterion("id_moneda_local between", value1, value2, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andId_moneda_localNotBetween(Integer value1, Integer value2) {
            addCriterion("id_moneda_local not between", value1, value2, "id_moneda_local");
            return (Criteria) this;
        }

        public Criteria andTotal_importeIsNull() {
            addCriterion("total_importe is null");
            return (Criteria) this;
        }

        public Criteria andTotal_importeIsNotNull() {
            addCriterion("total_importe is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_importeEqualTo(BigDecimal value) {
            addCriterion("total_importe =", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeNotEqualTo(BigDecimal value) {
            addCriterion("total_importe <>", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeGreaterThan(BigDecimal value) {
            addCriterion("total_importe >", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_importe >=", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeLessThan(BigDecimal value) {
            addCriterion("total_importe <", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_importe <=", value, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeIn(List<BigDecimal> values) {
            addCriterion("total_importe in", values, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeNotIn(List<BigDecimal> values) {
            addCriterion("total_importe not in", values, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_importe between", value1, value2, "total_importe");
            return (Criteria) this;
        }

        public Criteria andTotal_importeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_importe not between", value1, value2, "total_importe");
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

        public Criteria andId_guia_referenciaIsNull() {
            addCriterion("id_guia_referencia is null");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaIsNotNull() {
            addCriterion("id_guia_referencia is not null");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaEqualTo(Integer value) {
            addCriterion("id_guia_referencia =", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaNotEqualTo(Integer value) {
            addCriterion("id_guia_referencia <>", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaGreaterThan(Integer value) {
            addCriterion("id_guia_referencia >", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_guia_referencia >=", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaLessThan(Integer value) {
            addCriterion("id_guia_referencia <", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaLessThanOrEqualTo(Integer value) {
            addCriterion("id_guia_referencia <=", value, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaIn(List<Integer> values) {
            addCriterion("id_guia_referencia in", values, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaNotIn(List<Integer> values) {
            addCriterion("id_guia_referencia not in", values, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaBetween(Integer value1, Integer value2) {
            addCriterion("id_guia_referencia between", value1, value2, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_guia_referenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_guia_referencia not between", value1, value2, "id_guia_referencia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaIsNull() {
            addCriterion("id_tipo_guia is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaIsNotNull() {
            addCriterion("id_tipo_guia is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaEqualTo(Integer value) {
            addCriterion("id_tipo_guia =", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaNotEqualTo(Integer value) {
            addCriterion("id_tipo_guia <>", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaGreaterThan(Integer value) {
            addCriterion("id_tipo_guia >", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_guia >=", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaLessThan(Integer value) {
            addCriterion("id_tipo_guia <", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_guia <=", value, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaIn(List<Integer> values) {
            addCriterion("id_tipo_guia in", values, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaNotIn(List<Integer> values) {
            addCriterion("id_tipo_guia not in", values, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_guia between", value1, value2, "id_tipo_guia");
            return (Criteria) this;
        }

        public Criteria andId_tipo_guiaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_guia not between", value1, value2, "id_tipo_guia");
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