package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogoItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatalogoItemExample() {
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

        public Criteria andId_catalogo_itemIsNull() {
            addCriterion("id_catalogo_item is null");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemIsNotNull() {
            addCriterion("id_catalogo_item is not null");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemEqualTo(Integer value) {
            addCriterion("id_catalogo_item =", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemNotEqualTo(Integer value) {
            addCriterion("id_catalogo_item <>", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemGreaterThan(Integer value) {
            addCriterion("id_catalogo_item >", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_catalogo_item >=", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemLessThan(Integer value) {
            addCriterion("id_catalogo_item <", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemLessThanOrEqualTo(Integer value) {
            addCriterion("id_catalogo_item <=", value, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemIn(List<Integer> values) {
            addCriterion("id_catalogo_item in", values, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemNotIn(List<Integer> values) {
            addCriterion("id_catalogo_item not in", values, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemBetween(Integer value1, Integer value2) {
            addCriterion("id_catalogo_item between", value1, value2, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogo_itemNotBetween(Integer value1, Integer value2) {
            addCriterion("id_catalogo_item not between", value1, value2, "id_catalogo_item");
            return (Criteria) this;
        }

        public Criteria andId_catalogoIsNull() {
            addCriterion("id_catalogo is null");
            return (Criteria) this;
        }

        public Criteria andId_catalogoIsNotNull() {
            addCriterion("id_catalogo is not null");
            return (Criteria) this;
        }

        public Criteria andId_catalogoEqualTo(Integer value) {
            addCriterion("id_catalogo =", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoNotEqualTo(Integer value) {
            addCriterion("id_catalogo <>", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoGreaterThan(Integer value) {
            addCriterion("id_catalogo >", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_catalogo >=", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoLessThan(Integer value) {
            addCriterion("id_catalogo <", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoLessThanOrEqualTo(Integer value) {
            addCriterion("id_catalogo <=", value, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoIn(List<Integer> values) {
            addCriterion("id_catalogo in", values, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoNotIn(List<Integer> values) {
            addCriterion("id_catalogo not in", values, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoBetween(Integer value1, Integer value2) {
            addCriterion("id_catalogo between", value1, value2, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andId_catalogoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_catalogo not between", value1, value2, "id_catalogo");
            return (Criteria) this;
        }

        public Criteria andValor_itemIsNull() {
            addCriterion("valor_item is null");
            return (Criteria) this;
        }

        public Criteria andValor_itemIsNotNull() {
            addCriterion("valor_item is not null");
            return (Criteria) this;
        }

        public Criteria andValor_itemEqualTo(Short value) {
            addCriterion("valor_item =", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemNotEqualTo(Short value) {
            addCriterion("valor_item <>", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemGreaterThan(Short value) {
            addCriterion("valor_item >", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemGreaterThanOrEqualTo(Short value) {
            addCriterion("valor_item >=", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemLessThan(Short value) {
            addCriterion("valor_item <", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemLessThanOrEqualTo(Short value) {
            addCriterion("valor_item <=", value, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemIn(List<Short> values) {
            addCriterion("valor_item in", values, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemNotIn(List<Short> values) {
            addCriterion("valor_item not in", values, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemBetween(Short value1, Short value2) {
            addCriterion("valor_item between", value1, value2, "valor_item");
            return (Criteria) this;
        }

        public Criteria andValor_itemNotBetween(Short value1, Short value2) {
            addCriterion("valor_item not between", value1, value2, "valor_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemIsNull() {
            addCriterion("descrip_item is null");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemIsNotNull() {
            addCriterion("descrip_item is not null");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemEqualTo(String value) {
            addCriterion("descrip_item =", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemNotEqualTo(String value) {
            addCriterion("descrip_item <>", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemGreaterThan(String value) {
            addCriterion("descrip_item >", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemGreaterThanOrEqualTo(String value) {
            addCriterion("descrip_item >=", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemLessThan(String value) {
            addCriterion("descrip_item <", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemLessThanOrEqualTo(String value) {
            addCriterion("descrip_item <=", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemLike(String value) {
            addCriterion("descrip_item like", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemNotLike(String value) {
            addCriterion("descrip_item not like", value, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemIn(List<String> values) {
            addCriterion("descrip_item in", values, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemNotIn(List<String> values) {
            addCriterion("descrip_item not in", values, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemBetween(String value1, String value2) {
            addCriterion("descrip_item between", value1, value2, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andDescrip_itemNotBetween(String value1, String value2) {
            addCriterion("descrip_item not between", value1, value2, "descrip_item");
            return (Criteria) this;
        }

        public Criteria andValor_aIsNull() {
            addCriterion("valor_a is null");
            return (Criteria) this;
        }

        public Criteria andValor_aIsNotNull() {
            addCriterion("valor_a is not null");
            return (Criteria) this;
        }

        public Criteria andValor_aEqualTo(String value) {
            addCriterion("valor_a =", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aNotEqualTo(String value) {
            addCriterion("valor_a <>", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aGreaterThan(String value) {
            addCriterion("valor_a >", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aGreaterThanOrEqualTo(String value) {
            addCriterion("valor_a >=", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aLessThan(String value) {
            addCriterion("valor_a <", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aLessThanOrEqualTo(String value) {
            addCriterion("valor_a <=", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aLike(String value) {
            addCriterion("valor_a like", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aNotLike(String value) {
            addCriterion("valor_a not like", value, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aIn(List<String> values) {
            addCriterion("valor_a in", values, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aNotIn(List<String> values) {
            addCriterion("valor_a not in", values, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aBetween(String value1, String value2) {
            addCriterion("valor_a between", value1, value2, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_aNotBetween(String value1, String value2) {
            addCriterion("valor_a not between", value1, value2, "valor_a");
            return (Criteria) this;
        }

        public Criteria andValor_bIsNull() {
            addCriterion("valor_b is null");
            return (Criteria) this;
        }

        public Criteria andValor_bIsNotNull() {
            addCriterion("valor_b is not null");
            return (Criteria) this;
        }

        public Criteria andValor_bEqualTo(String value) {
            addCriterion("valor_b =", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bNotEqualTo(String value) {
            addCriterion("valor_b <>", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bGreaterThan(String value) {
            addCriterion("valor_b >", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bGreaterThanOrEqualTo(String value) {
            addCriterion("valor_b >=", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bLessThan(String value) {
            addCriterion("valor_b <", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bLessThanOrEqualTo(String value) {
            addCriterion("valor_b <=", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bLike(String value) {
            addCriterion("valor_b like", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bNotLike(String value) {
            addCriterion("valor_b not like", value, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bIn(List<String> values) {
            addCriterion("valor_b in", values, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bNotIn(List<String> values) {
            addCriterion("valor_b not in", values, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bBetween(String value1, String value2) {
            addCriterion("valor_b between", value1, value2, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_bNotBetween(String value1, String value2) {
            addCriterion("valor_b not between", value1, value2, "valor_b");
            return (Criteria) this;
        }

        public Criteria andValor_cIsNull() {
            addCriterion("valor_c is null");
            return (Criteria) this;
        }

        public Criteria andValor_cIsNotNull() {
            addCriterion("valor_c is not null");
            return (Criteria) this;
        }

        public Criteria andValor_cEqualTo(String value) {
            addCriterion("valor_c =", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cNotEqualTo(String value) {
            addCriterion("valor_c <>", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cGreaterThan(String value) {
            addCriterion("valor_c >", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cGreaterThanOrEqualTo(String value) {
            addCriterion("valor_c >=", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cLessThan(String value) {
            addCriterion("valor_c <", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cLessThanOrEqualTo(String value) {
            addCriterion("valor_c <=", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cLike(String value) {
            addCriterion("valor_c like", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cNotLike(String value) {
            addCriterion("valor_c not like", value, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cIn(List<String> values) {
            addCriterion("valor_c in", values, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cNotIn(List<String> values) {
            addCriterion("valor_c not in", values, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cBetween(String value1, String value2) {
            addCriterion("valor_c between", value1, value2, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_cNotBetween(String value1, String value2) {
            addCriterion("valor_c not between", value1, value2, "valor_c");
            return (Criteria) this;
        }

        public Criteria andValor_dIsNull() {
            addCriterion("valor_d is null");
            return (Criteria) this;
        }

        public Criteria andValor_dIsNotNull() {
            addCriterion("valor_d is not null");
            return (Criteria) this;
        }

        public Criteria andValor_dEqualTo(String value) {
            addCriterion("valor_d =", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dNotEqualTo(String value) {
            addCriterion("valor_d <>", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dGreaterThan(String value) {
            addCriterion("valor_d >", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dGreaterThanOrEqualTo(String value) {
            addCriterion("valor_d >=", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dLessThan(String value) {
            addCriterion("valor_d <", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dLessThanOrEqualTo(String value) {
            addCriterion("valor_d <=", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dLike(String value) {
            addCriterion("valor_d like", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dNotLike(String value) {
            addCriterion("valor_d not like", value, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dIn(List<String> values) {
            addCriterion("valor_d in", values, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dNotIn(List<String> values) {
            addCriterion("valor_d not in", values, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dBetween(String value1, String value2) {
            addCriterion("valor_d between", value1, value2, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_dNotBetween(String value1, String value2) {
            addCriterion("valor_d not between", value1, value2, "valor_d");
            return (Criteria) this;
        }

        public Criteria andValor_eIsNull() {
            addCriterion("valor_e is null");
            return (Criteria) this;
        }

        public Criteria andValor_eIsNotNull() {
            addCriterion("valor_e is not null");
            return (Criteria) this;
        }

        public Criteria andValor_eEqualTo(String value) {
            addCriterion("valor_e =", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eNotEqualTo(String value) {
            addCriterion("valor_e <>", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eGreaterThan(String value) {
            addCriterion("valor_e >", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eGreaterThanOrEqualTo(String value) {
            addCriterion("valor_e >=", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eLessThan(String value) {
            addCriterion("valor_e <", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eLessThanOrEqualTo(String value) {
            addCriterion("valor_e <=", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eLike(String value) {
            addCriterion("valor_e like", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eNotLike(String value) {
            addCriterion("valor_e not like", value, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eIn(List<String> values) {
            addCriterion("valor_e in", values, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eNotIn(List<String> values) {
            addCriterion("valor_e not in", values, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eBetween(String value1, String value2) {
            addCriterion("valor_e between", value1, value2, "valor_e");
            return (Criteria) this;
        }

        public Criteria andValor_eNotBetween(String value1, String value2) {
            addCriterion("valor_e not between", value1, value2, "valor_e");
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

        public Criteria andId_estadoEqualTo(Short value) {
            addCriterion("id_estado =", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotEqualTo(Short value) {
            addCriterion("id_estado <>", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThan(Short value) {
            addCriterion("id_estado >", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoGreaterThanOrEqualTo(Short value) {
            addCriterion("id_estado >=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThan(Short value) {
            addCriterion("id_estado <", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoLessThanOrEqualTo(Short value) {
            addCriterion("id_estado <=", value, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoIn(List<Short> values) {
            addCriterion("id_estado in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotIn(List<Short> values) {
            addCriterion("id_estado not in", values, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoBetween(Short value1, Short value2) {
            addCriterion("id_estado between", value1, value2, "id_estado");
            return (Criteria) this;
        }

        public Criteria andId_estadoNotBetween(Short value1, Short value2) {
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