package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembInfoExample() {
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

        public Criteria andMemb_guidIsNull() {
            addCriterion("memb_guid is null");
            return (Criteria) this;
        }

        public Criteria andMemb_guidIsNotNull() {
            addCriterion("memb_guid is not null");
            return (Criteria) this;
        }

        public Criteria andMemb_guidEqualTo(Integer value) {
            addCriterion("memb_guid =", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotEqualTo(Integer value) {
            addCriterion("memb_guid <>", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidGreaterThan(Integer value) {
            addCriterion("memb_guid >", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memb_guid >=", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidLessThan(Integer value) {
            addCriterion("memb_guid <", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidLessThanOrEqualTo(Integer value) {
            addCriterion("memb_guid <=", value, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidIn(List<Integer> values) {
            addCriterion("memb_guid in", values, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotIn(List<Integer> values) {
            addCriterion("memb_guid not in", values, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidBetween(Integer value1, Integer value2) {
            addCriterion("memb_guid between", value1, value2, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb_guidNotBetween(Integer value1, Integer value2) {
            addCriterion("memb_guid not between", value1, value2, "memb_guid");
            return (Criteria) this;
        }

        public Criteria andMemb___idIsNull() {
            addCriterion("memb___id is null");
            return (Criteria) this;
        }

        public Criteria andMemb___idIsNotNull() {
            addCriterion("memb___id is not null");
            return (Criteria) this;
        }

        public Criteria andMemb___idEqualTo(String value) {
            addCriterion("memb___id =", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotEqualTo(String value) {
            addCriterion("memb___id <>", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idGreaterThan(String value) {
            addCriterion("memb___id >", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idGreaterThanOrEqualTo(String value) {
            addCriterion("memb___id >=", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLessThan(String value) {
            addCriterion("memb___id <", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLessThanOrEqualTo(String value) {
            addCriterion("memb___id <=", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idLike(String value) {
            addCriterion("memb___id like", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotLike(String value) {
            addCriterion("memb___id not like", value, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idIn(List<String> values) {
            addCriterion("memb___id in", values, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotIn(List<String> values) {
            addCriterion("memb___id not in", values, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idBetween(String value1, String value2) {
            addCriterion("memb___id between", value1, value2, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb___idNotBetween(String value1, String value2) {
            addCriterion("memb___id not between", value1, value2, "memb___id");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdIsNull() {
            addCriterion("memb__pwd is null");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdIsNotNull() {
            addCriterion("memb__pwd is not null");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdEqualTo(String value) {
            addCriterion("memb__pwd =", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdNotEqualTo(String value) {
            addCriterion("memb__pwd <>", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdGreaterThan(String value) {
            addCriterion("memb__pwd >", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdGreaterThanOrEqualTo(String value) {
            addCriterion("memb__pwd >=", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdLessThan(String value) {
            addCriterion("memb__pwd <", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdLessThanOrEqualTo(String value) {
            addCriterion("memb__pwd <=", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdLike(String value) {
            addCriterion("memb__pwd like", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdNotLike(String value) {
            addCriterion("memb__pwd not like", value, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdIn(List<String> values) {
            addCriterion("memb__pwd in", values, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdNotIn(List<String> values) {
            addCriterion("memb__pwd not in", values, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdBetween(String value1, String value2) {
            addCriterion("memb__pwd between", value1, value2, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb__pwdNotBetween(String value1, String value2) {
            addCriterion("memb__pwd not between", value1, value2, "memb__pwd");
            return (Criteria) this;
        }

        public Criteria andMemb_nameIsNull() {
            addCriterion("memb_name is null");
            return (Criteria) this;
        }

        public Criteria andMemb_nameIsNotNull() {
            addCriterion("memb_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemb_nameEqualTo(String value) {
            addCriterion("memb_name =", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameNotEqualTo(String value) {
            addCriterion("memb_name <>", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameGreaterThan(String value) {
            addCriterion("memb_name >", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameGreaterThanOrEqualTo(String value) {
            addCriterion("memb_name >=", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameLessThan(String value) {
            addCriterion("memb_name <", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameLessThanOrEqualTo(String value) {
            addCriterion("memb_name <=", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameLike(String value) {
            addCriterion("memb_name like", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameNotLike(String value) {
            addCriterion("memb_name not like", value, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameIn(List<String> values) {
            addCriterion("memb_name in", values, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameNotIn(List<String> values) {
            addCriterion("memb_name not in", values, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameBetween(String value1, String value2) {
            addCriterion("memb_name between", value1, value2, "memb_name");
            return (Criteria) this;
        }

        public Criteria andMemb_nameNotBetween(String value1, String value2) {
            addCriterion("memb_name not between", value1, value2, "memb_name");
            return (Criteria) this;
        }

        public Criteria andSno__numbIsNull() {
            addCriterion("sno__numb is null");
            return (Criteria) this;
        }

        public Criteria andSno__numbIsNotNull() {
            addCriterion("sno__numb is not null");
            return (Criteria) this;
        }

        public Criteria andSno__numbEqualTo(String value) {
            addCriterion("sno__numb =", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbNotEqualTo(String value) {
            addCriterion("sno__numb <>", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbGreaterThan(String value) {
            addCriterion("sno__numb >", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbGreaterThanOrEqualTo(String value) {
            addCriterion("sno__numb >=", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbLessThan(String value) {
            addCriterion("sno__numb <", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbLessThanOrEqualTo(String value) {
            addCriterion("sno__numb <=", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbLike(String value) {
            addCriterion("sno__numb like", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbNotLike(String value) {
            addCriterion("sno__numb not like", value, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbIn(List<String> values) {
            addCriterion("sno__numb in", values, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbNotIn(List<String> values) {
            addCriterion("sno__numb not in", values, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbBetween(String value1, String value2) {
            addCriterion("sno__numb between", value1, value2, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andSno__numbNotBetween(String value1, String value2) {
            addCriterion("sno__numb not between", value1, value2, "sno__numb");
            return (Criteria) this;
        }

        public Criteria andPost_codeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPost_codeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPost_codeEqualTo(String value) {
            addCriterion("post_code =", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeGreaterThan(String value) {
            addCriterion("post_code >", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLessThan(String value) {
            addCriterion("post_code <", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLike(String value) {
            addCriterion("post_code like", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotLike(String value) {
            addCriterion("post_code not like", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeIn(List<String> values) {
            addCriterion("post_code in", values, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "post_code");
            return (Criteria) this;
        }

        public Criteria andAddr_infoIsNull() {
            addCriterion("addr_info is null");
            return (Criteria) this;
        }

        public Criteria andAddr_infoIsNotNull() {
            addCriterion("addr_info is not null");
            return (Criteria) this;
        }

        public Criteria andAddr_infoEqualTo(String value) {
            addCriterion("addr_info =", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoNotEqualTo(String value) {
            addCriterion("addr_info <>", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoGreaterThan(String value) {
            addCriterion("addr_info >", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoGreaterThanOrEqualTo(String value) {
            addCriterion("addr_info >=", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoLessThan(String value) {
            addCriterion("addr_info <", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoLessThanOrEqualTo(String value) {
            addCriterion("addr_info <=", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoLike(String value) {
            addCriterion("addr_info like", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoNotLike(String value) {
            addCriterion("addr_info not like", value, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoIn(List<String> values) {
            addCriterion("addr_info in", values, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoNotIn(List<String> values) {
            addCriterion("addr_info not in", values, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoBetween(String value1, String value2) {
            addCriterion("addr_info between", value1, value2, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_infoNotBetween(String value1, String value2) {
            addCriterion("addr_info not between", value1, value2, "addr_info");
            return (Criteria) this;
        }

        public Criteria andAddr_detaIsNull() {
            addCriterion("addr_deta is null");
            return (Criteria) this;
        }

        public Criteria andAddr_detaIsNotNull() {
            addCriterion("addr_deta is not null");
            return (Criteria) this;
        }

        public Criteria andAddr_detaEqualTo(String value) {
            addCriterion("addr_deta =", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaNotEqualTo(String value) {
            addCriterion("addr_deta <>", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaGreaterThan(String value) {
            addCriterion("addr_deta >", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaGreaterThanOrEqualTo(String value) {
            addCriterion("addr_deta >=", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaLessThan(String value) {
            addCriterion("addr_deta <", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaLessThanOrEqualTo(String value) {
            addCriterion("addr_deta <=", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaLike(String value) {
            addCriterion("addr_deta like", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaNotLike(String value) {
            addCriterion("addr_deta not like", value, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaIn(List<String> values) {
            addCriterion("addr_deta in", values, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaNotIn(List<String> values) {
            addCriterion("addr_deta not in", values, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaBetween(String value1, String value2) {
            addCriterion("addr_deta between", value1, value2, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andAddr_detaNotBetween(String value1, String value2) {
            addCriterion("addr_deta not between", value1, value2, "addr_deta");
            return (Criteria) this;
        }

        public Criteria andTel__numbIsNull() {
            addCriterion("tel__numb is null");
            return (Criteria) this;
        }

        public Criteria andTel__numbIsNotNull() {
            addCriterion("tel__numb is not null");
            return (Criteria) this;
        }

        public Criteria andTel__numbEqualTo(String value) {
            addCriterion("tel__numb =", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbNotEqualTo(String value) {
            addCriterion("tel__numb <>", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbGreaterThan(String value) {
            addCriterion("tel__numb >", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbGreaterThanOrEqualTo(String value) {
            addCriterion("tel__numb >=", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbLessThan(String value) {
            addCriterion("tel__numb <", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbLessThanOrEqualTo(String value) {
            addCriterion("tel__numb <=", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbLike(String value) {
            addCriterion("tel__numb like", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbNotLike(String value) {
            addCriterion("tel__numb not like", value, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbIn(List<String> values) {
            addCriterion("tel__numb in", values, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbNotIn(List<String> values) {
            addCriterion("tel__numb not in", values, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbBetween(String value1, String value2) {
            addCriterion("tel__numb between", value1, value2, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andTel__numbNotBetween(String value1, String value2) {
            addCriterion("tel__numb not between", value1, value2, "tel__numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbIsNull() {
            addCriterion("phon_numb is null");
            return (Criteria) this;
        }

        public Criteria andPhon_numbIsNotNull() {
            addCriterion("phon_numb is not null");
            return (Criteria) this;
        }

        public Criteria andPhon_numbEqualTo(String value) {
            addCriterion("phon_numb =", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbNotEqualTo(String value) {
            addCriterion("phon_numb <>", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbGreaterThan(String value) {
            addCriterion("phon_numb >", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbGreaterThanOrEqualTo(String value) {
            addCriterion("phon_numb >=", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbLessThan(String value) {
            addCriterion("phon_numb <", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbLessThanOrEqualTo(String value) {
            addCriterion("phon_numb <=", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbLike(String value) {
            addCriterion("phon_numb like", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbNotLike(String value) {
            addCriterion("phon_numb not like", value, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbIn(List<String> values) {
            addCriterion("phon_numb in", values, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbNotIn(List<String> values) {
            addCriterion("phon_numb not in", values, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbBetween(String value1, String value2) {
            addCriterion("phon_numb between", value1, value2, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andPhon_numbNotBetween(String value1, String value2) {
            addCriterion("phon_numb not between", value1, value2, "phon_numb");
            return (Criteria) this;
        }

        public Criteria andMail_addrIsNull() {
            addCriterion("mail_addr is null");
            return (Criteria) this;
        }

        public Criteria andMail_addrIsNotNull() {
            addCriterion("mail_addr is not null");
            return (Criteria) this;
        }

        public Criteria andMail_addrEqualTo(String value) {
            addCriterion("mail_addr =", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrNotEqualTo(String value) {
            addCriterion("mail_addr <>", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrGreaterThan(String value) {
            addCriterion("mail_addr >", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrGreaterThanOrEqualTo(String value) {
            addCriterion("mail_addr >=", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrLessThan(String value) {
            addCriterion("mail_addr <", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrLessThanOrEqualTo(String value) {
            addCriterion("mail_addr <=", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrLike(String value) {
            addCriterion("mail_addr like", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrNotLike(String value) {
            addCriterion("mail_addr not like", value, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrIn(List<String> values) {
            addCriterion("mail_addr in", values, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrNotIn(List<String> values) {
            addCriterion("mail_addr not in", values, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrBetween(String value1, String value2) {
            addCriterion("mail_addr between", value1, value2, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andMail_addrNotBetween(String value1, String value2) {
            addCriterion("mail_addr not between", value1, value2, "mail_addr");
            return (Criteria) this;
        }

        public Criteria andFpas_quesIsNull() {
            addCriterion("fpas_ques is null");
            return (Criteria) this;
        }

        public Criteria andFpas_quesIsNotNull() {
            addCriterion("fpas_ques is not null");
            return (Criteria) this;
        }

        public Criteria andFpas_quesEqualTo(String value) {
            addCriterion("fpas_ques =", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesNotEqualTo(String value) {
            addCriterion("fpas_ques <>", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesGreaterThan(String value) {
            addCriterion("fpas_ques >", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesGreaterThanOrEqualTo(String value) {
            addCriterion("fpas_ques >=", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesLessThan(String value) {
            addCriterion("fpas_ques <", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesLessThanOrEqualTo(String value) {
            addCriterion("fpas_ques <=", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesLike(String value) {
            addCriterion("fpas_ques like", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesNotLike(String value) {
            addCriterion("fpas_ques not like", value, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesIn(List<String> values) {
            addCriterion("fpas_ques in", values, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesNotIn(List<String> values) {
            addCriterion("fpas_ques not in", values, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesBetween(String value1, String value2) {
            addCriterion("fpas_ques between", value1, value2, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_quesNotBetween(String value1, String value2) {
            addCriterion("fpas_ques not between", value1, value2, "fpas_ques");
            return (Criteria) this;
        }

        public Criteria andFpas_answIsNull() {
            addCriterion("fpas_answ is null");
            return (Criteria) this;
        }

        public Criteria andFpas_answIsNotNull() {
            addCriterion("fpas_answ is not null");
            return (Criteria) this;
        }

        public Criteria andFpas_answEqualTo(String value) {
            addCriterion("fpas_answ =", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answNotEqualTo(String value) {
            addCriterion("fpas_answ <>", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answGreaterThan(String value) {
            addCriterion("fpas_answ >", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answGreaterThanOrEqualTo(String value) {
            addCriterion("fpas_answ >=", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answLessThan(String value) {
            addCriterion("fpas_answ <", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answLessThanOrEqualTo(String value) {
            addCriterion("fpas_answ <=", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answLike(String value) {
            addCriterion("fpas_answ like", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answNotLike(String value) {
            addCriterion("fpas_answ not like", value, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answIn(List<String> values) {
            addCriterion("fpas_answ in", values, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answNotIn(List<String> values) {
            addCriterion("fpas_answ not in", values, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answBetween(String value1, String value2) {
            addCriterion("fpas_answ between", value1, value2, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andFpas_answNotBetween(String value1, String value2) {
            addCriterion("fpas_answ not between", value1, value2, "fpas_answ");
            return (Criteria) this;
        }

        public Criteria andJob__codeIsNull() {
            addCriterion("job__code is null");
            return (Criteria) this;
        }

        public Criteria andJob__codeIsNotNull() {
            addCriterion("job__code is not null");
            return (Criteria) this;
        }

        public Criteria andJob__codeEqualTo(String value) {
            addCriterion("job__code =", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeNotEqualTo(String value) {
            addCriterion("job__code <>", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeGreaterThan(String value) {
            addCriterion("job__code >", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeGreaterThanOrEqualTo(String value) {
            addCriterion("job__code >=", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeLessThan(String value) {
            addCriterion("job__code <", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeLessThanOrEqualTo(String value) {
            addCriterion("job__code <=", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeLike(String value) {
            addCriterion("job__code like", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeNotLike(String value) {
            addCriterion("job__code not like", value, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeIn(List<String> values) {
            addCriterion("job__code in", values, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeNotIn(List<String> values) {
            addCriterion("job__code not in", values, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeBetween(String value1, String value2) {
            addCriterion("job__code between", value1, value2, "job__code");
            return (Criteria) this;
        }

        public Criteria andJob__codeNotBetween(String value1, String value2) {
            addCriterion("job__code not between", value1, value2, "job__code");
            return (Criteria) this;
        }

        public Criteria andAppl_daysIsNull() {
            addCriterion("appl_days is null");
            return (Criteria) this;
        }

        public Criteria andAppl_daysIsNotNull() {
            addCriterion("appl_days is not null");
            return (Criteria) this;
        }

        public Criteria andAppl_daysEqualTo(Date value) {
            addCriterion("appl_days =", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysNotEqualTo(Date value) {
            addCriterion("appl_days <>", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysGreaterThan(Date value) {
            addCriterion("appl_days >", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysGreaterThanOrEqualTo(Date value) {
            addCriterion("appl_days >=", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysLessThan(Date value) {
            addCriterion("appl_days <", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysLessThanOrEqualTo(Date value) {
            addCriterion("appl_days <=", value, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysIn(List<Date> values) {
            addCriterion("appl_days in", values, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysNotIn(List<Date> values) {
            addCriterion("appl_days not in", values, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysBetween(Date value1, Date value2) {
            addCriterion("appl_days between", value1, value2, "appl_days");
            return (Criteria) this;
        }

        public Criteria andAppl_daysNotBetween(Date value1, Date value2) {
            addCriterion("appl_days not between", value1, value2, "appl_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysIsNull() {
            addCriterion("modi_days is null");
            return (Criteria) this;
        }

        public Criteria andModi_daysIsNotNull() {
            addCriterion("modi_days is not null");
            return (Criteria) this;
        }

        public Criteria andModi_daysEqualTo(Date value) {
            addCriterion("modi_days =", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysNotEqualTo(Date value) {
            addCriterion("modi_days <>", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysGreaterThan(Date value) {
            addCriterion("modi_days >", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysGreaterThanOrEqualTo(Date value) {
            addCriterion("modi_days >=", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysLessThan(Date value) {
            addCriterion("modi_days <", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysLessThanOrEqualTo(Date value) {
            addCriterion("modi_days <=", value, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysIn(List<Date> values) {
            addCriterion("modi_days in", values, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysNotIn(List<Date> values) {
            addCriterion("modi_days not in", values, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysBetween(Date value1, Date value2) {
            addCriterion("modi_days between", value1, value2, "modi_days");
            return (Criteria) this;
        }

        public Criteria andModi_daysNotBetween(Date value1, Date value2) {
            addCriterion("modi_days not between", value1, value2, "modi_days");
            return (Criteria) this;
        }

        public Criteria andOut__daysIsNull() {
            addCriterion("out__days is null");
            return (Criteria) this;
        }

        public Criteria andOut__daysIsNotNull() {
            addCriterion("out__days is not null");
            return (Criteria) this;
        }

        public Criteria andOut__daysEqualTo(Date value) {
            addCriterion("out__days =", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysNotEqualTo(Date value) {
            addCriterion("out__days <>", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysGreaterThan(Date value) {
            addCriterion("out__days >", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysGreaterThanOrEqualTo(Date value) {
            addCriterion("out__days >=", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysLessThan(Date value) {
            addCriterion("out__days <", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysLessThanOrEqualTo(Date value) {
            addCriterion("out__days <=", value, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysIn(List<Date> values) {
            addCriterion("out__days in", values, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysNotIn(List<Date> values) {
            addCriterion("out__days not in", values, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysBetween(Date value1, Date value2) {
            addCriterion("out__days between", value1, value2, "out__days");
            return (Criteria) this;
        }

        public Criteria andOut__daysNotBetween(Date value1, Date value2) {
            addCriterion("out__days not between", value1, value2, "out__days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysIsNull() {
            addCriterion("true_days is null");
            return (Criteria) this;
        }

        public Criteria andTrue_daysIsNotNull() {
            addCriterion("true_days is not null");
            return (Criteria) this;
        }

        public Criteria andTrue_daysEqualTo(Date value) {
            addCriterion("true_days =", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysNotEqualTo(Date value) {
            addCriterion("true_days <>", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysGreaterThan(Date value) {
            addCriterion("true_days >", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysGreaterThanOrEqualTo(Date value) {
            addCriterion("true_days >=", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysLessThan(Date value) {
            addCriterion("true_days <", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysLessThanOrEqualTo(Date value) {
            addCriterion("true_days <=", value, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysIn(List<Date> values) {
            addCriterion("true_days in", values, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysNotIn(List<Date> values) {
            addCriterion("true_days not in", values, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysBetween(Date value1, Date value2) {
            addCriterion("true_days between", value1, value2, "true_days");
            return (Criteria) this;
        }

        public Criteria andTrue_daysNotBetween(Date value1, Date value2) {
            addCriterion("true_days not between", value1, value2, "true_days");
            return (Criteria) this;
        }

        public Criteria andMail_chekIsNull() {
            addCriterion("mail_chek is null");
            return (Criteria) this;
        }

        public Criteria andMail_chekIsNotNull() {
            addCriterion("mail_chek is not null");
            return (Criteria) this;
        }

        public Criteria andMail_chekEqualTo(String value) {
            addCriterion("mail_chek =", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekNotEqualTo(String value) {
            addCriterion("mail_chek <>", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekGreaterThan(String value) {
            addCriterion("mail_chek >", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekGreaterThanOrEqualTo(String value) {
            addCriterion("mail_chek >=", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekLessThan(String value) {
            addCriterion("mail_chek <", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekLessThanOrEqualTo(String value) {
            addCriterion("mail_chek <=", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekLike(String value) {
            addCriterion("mail_chek like", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekNotLike(String value) {
            addCriterion("mail_chek not like", value, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekIn(List<String> values) {
            addCriterion("mail_chek in", values, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekNotIn(List<String> values) {
            addCriterion("mail_chek not in", values, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekBetween(String value1, String value2) {
            addCriterion("mail_chek between", value1, value2, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andMail_chekNotBetween(String value1, String value2) {
            addCriterion("mail_chek not between", value1, value2, "mail_chek");
            return (Criteria) this;
        }

        public Criteria andBloc_codeIsNull() {
            addCriterion("bloc_code is null");
            return (Criteria) this;
        }

        public Criteria andBloc_codeIsNotNull() {
            addCriterion("bloc_code is not null");
            return (Criteria) this;
        }

        public Criteria andBloc_codeEqualTo(String value) {
            addCriterion("bloc_code =", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeNotEqualTo(String value) {
            addCriterion("bloc_code <>", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeGreaterThan(String value) {
            addCriterion("bloc_code >", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeGreaterThanOrEqualTo(String value) {
            addCriterion("bloc_code >=", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeLessThan(String value) {
            addCriterion("bloc_code <", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeLessThanOrEqualTo(String value) {
            addCriterion("bloc_code <=", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeLike(String value) {
            addCriterion("bloc_code like", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeNotLike(String value) {
            addCriterion("bloc_code not like", value, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeIn(List<String> values) {
            addCriterion("bloc_code in", values, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeNotIn(List<String> values) {
            addCriterion("bloc_code not in", values, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeBetween(String value1, String value2) {
            addCriterion("bloc_code between", value1, value2, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andBloc_codeNotBetween(String value1, String value2) {
            addCriterion("bloc_code not between", value1, value2, "bloc_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeIsNull() {
            addCriterion("ctl1_code is null");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeIsNotNull() {
            addCriterion("ctl1_code is not null");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeEqualTo(String value) {
            addCriterion("ctl1_code =", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeNotEqualTo(String value) {
            addCriterion("ctl1_code <>", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeGreaterThan(String value) {
            addCriterion("ctl1_code >", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeGreaterThanOrEqualTo(String value) {
            addCriterion("ctl1_code >=", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeLessThan(String value) {
            addCriterion("ctl1_code <", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeLessThanOrEqualTo(String value) {
            addCriterion("ctl1_code <=", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeLike(String value) {
            addCriterion("ctl1_code like", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeNotLike(String value) {
            addCriterion("ctl1_code not like", value, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeIn(List<String> values) {
            addCriterion("ctl1_code in", values, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeNotIn(List<String> values) {
            addCriterion("ctl1_code not in", values, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeBetween(String value1, String value2) {
            addCriterion("ctl1_code between", value1, value2, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCtl1_codeNotBetween(String value1, String value2) {
            addCriterion("ctl1_code not between", value1, value2, "ctl1_code");
            return (Criteria) this;
        }

        public Criteria andCspointsIsNull() {
            addCriterion("cspoints is null");
            return (Criteria) this;
        }

        public Criteria andCspointsIsNotNull() {
            addCriterion("cspoints is not null");
            return (Criteria) this;
        }

        public Criteria andCspointsEqualTo(Integer value) {
            addCriterion("cspoints =", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsNotEqualTo(Integer value) {
            addCriterion("cspoints <>", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsGreaterThan(Integer value) {
            addCriterion("cspoints >", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("cspoints >=", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsLessThan(Integer value) {
            addCriterion("cspoints <", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsLessThanOrEqualTo(Integer value) {
            addCriterion("cspoints <=", value, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsIn(List<Integer> values) {
            addCriterion("cspoints in", values, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsNotIn(List<Integer> values) {
            addCriterion("cspoints not in", values, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsBetween(Integer value1, Integer value2) {
            addCriterion("cspoints between", value1, value2, "cspoints");
            return (Criteria) this;
        }

        public Criteria andCspointsNotBetween(Integer value1, Integer value2) {
            addCriterion("cspoints not between", value1, value2, "cspoints");
            return (Criteria) this;
        }

        public Criteria andVipIsNull() {
            addCriterion("vip is null");
            return (Criteria) this;
        }

        public Criteria andVipIsNotNull() {
            addCriterion("vip is not null");
            return (Criteria) this;
        }

        public Criteria andVipEqualTo(Integer value) {
            addCriterion("vip =", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotEqualTo(Integer value) {
            addCriterion("vip <>", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThan(Integer value) {
            addCriterion("vip >", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip >=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThan(Integer value) {
            addCriterion("vip <", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThanOrEqualTo(Integer value) {
            addCriterion("vip <=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipIn(List<Integer> values) {
            addCriterion("vip in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotIn(List<Integer> values) {
            addCriterion("vip not in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipBetween(Integer value1, Integer value2) {
            addCriterion("vip between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotBetween(Integer value1, Integer value2) {
            addCriterion("vip not between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andVipDurationIsNull() {
            addCriterion("VipDuration is null");
            return (Criteria) this;
        }

        public Criteria andVipDurationIsNotNull() {
            addCriterion("VipDuration is not null");
            return (Criteria) this;
        }

        public Criteria andVipDurationEqualTo(Integer value) {
            addCriterion("VipDuration =", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationNotEqualTo(Integer value) {
            addCriterion("VipDuration <>", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationGreaterThan(Integer value) {
            addCriterion("VipDuration >", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("VipDuration >=", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationLessThan(Integer value) {
            addCriterion("VipDuration <", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationLessThanOrEqualTo(Integer value) {
            addCriterion("VipDuration <=", value, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationIn(List<Integer> values) {
            addCriterion("VipDuration in", values, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationNotIn(List<Integer> values) {
            addCriterion("VipDuration not in", values, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationBetween(Integer value1, Integer value2) {
            addCriterion("VipDuration between", value1, value2, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andVipDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("VipDuration not between", value1, value2, "vipDuration");
            return (Criteria) this;
        }

        public Criteria andActivation_idIsNull() {
            addCriterion("activation_id is null");
            return (Criteria) this;
        }

        public Criteria andActivation_idIsNotNull() {
            addCriterion("activation_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivation_idEqualTo(String value) {
            addCriterion("activation_id =", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idNotEqualTo(String value) {
            addCriterion("activation_id <>", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idGreaterThan(String value) {
            addCriterion("activation_id >", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idGreaterThanOrEqualTo(String value) {
            addCriterion("activation_id >=", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idLessThan(String value) {
            addCriterion("activation_id <", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idLessThanOrEqualTo(String value) {
            addCriterion("activation_id <=", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idLike(String value) {
            addCriterion("activation_id like", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idNotLike(String value) {
            addCriterion("activation_id not like", value, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idIn(List<String> values) {
            addCriterion("activation_id in", values, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idNotIn(List<String> values) {
            addCriterion("activation_id not in", values, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idBetween(String value1, String value2) {
            addCriterion("activation_id between", value1, value2, "activation_id");
            return (Criteria) this;
        }

        public Criteria andActivation_idNotBetween(String value1, String value2) {
            addCriterion("activation_id not between", value1, value2, "activation_id");
            return (Criteria) this;
        }

        public Criteria andConfirmedIsNull() {
            addCriterion("confirmed is null");
            return (Criteria) this;
        }

        public Criteria andConfirmedIsNotNull() {
            addCriterion("confirmed is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmedEqualTo(Integer value) {
            addCriterion("confirmed =", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedNotEqualTo(Integer value) {
            addCriterion("confirmed <>", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedGreaterThan(Integer value) {
            addCriterion("confirmed >", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirmed >=", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedLessThan(Integer value) {
            addCriterion("confirmed <", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedLessThanOrEqualTo(Integer value) {
            addCriterion("confirmed <=", value, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedIn(List<Integer> values) {
            addCriterion("confirmed in", values, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedNotIn(List<Integer> values) {
            addCriterion("confirmed not in", values, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedBetween(Integer value1, Integer value2) {
            addCriterion("confirmed between", value1, value2, "confirmed");
            return (Criteria) this;
        }

        public Criteria andConfirmedNotBetween(Integer value1, Integer value2) {
            addCriterion("confirmed not between", value1, value2, "confirmed");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("Country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("Country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(Integer value) {
            addCriterion("Country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(Integer value) {
            addCriterion("Country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(Integer value) {
            addCriterion("Country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(Integer value) {
            addCriterion("Country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(Integer value) {
            addCriterion("Country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(Integer value) {
            addCriterion("Country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<Integer> values) {
            addCriterion("Country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<Integer> values) {
            addCriterion("Country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(Integer value1, Integer value2) {
            addCriterion("Country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(Integer value1, Integer value2) {
            addCriterion("Country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("Gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("Gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("Gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("Gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("Gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("Gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("Gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("Gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("Gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("Gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("Gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("Gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerIsNull() {
            addCriterion("SecretAnswer is null");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerIsNotNull() {
            addCriterion("SecretAnswer is not null");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerEqualTo(String value) {
            addCriterion("SecretAnswer =", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerNotEqualTo(String value) {
            addCriterion("SecretAnswer <>", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerGreaterThan(String value) {
            addCriterion("SecretAnswer >", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("SecretAnswer >=", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerLessThan(String value) {
            addCriterion("SecretAnswer <", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerLessThanOrEqualTo(String value) {
            addCriterion("SecretAnswer <=", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerLike(String value) {
            addCriterion("SecretAnswer like", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerNotLike(String value) {
            addCriterion("SecretAnswer not like", value, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerIn(List<String> values) {
            addCriterion("SecretAnswer in", values, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerNotIn(List<String> values) {
            addCriterion("SecretAnswer not in", values, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerBetween(String value1, String value2) {
            addCriterion("SecretAnswer between", value1, value2, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretAnswerNotBetween(String value1, String value2) {
            addCriterion("SecretAnswer not between", value1, value2, "secretAnswer");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionIsNull() {
            addCriterion("SecretQuestion is null");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionIsNotNull() {
            addCriterion("SecretQuestion is not null");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionEqualTo(Integer value) {
            addCriterion("SecretQuestion =", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionNotEqualTo(Integer value) {
            addCriterion("SecretQuestion <>", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionGreaterThan(Integer value) {
            addCriterion("SecretQuestion >", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionGreaterThanOrEqualTo(Integer value) {
            addCriterion("SecretQuestion >=", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionLessThan(Integer value) {
            addCriterion("SecretQuestion <", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionLessThanOrEqualTo(Integer value) {
            addCriterion("SecretQuestion <=", value, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionIn(List<Integer> values) {
            addCriterion("SecretQuestion in", values, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionNotIn(List<Integer> values) {
            addCriterion("SecretQuestion not in", values, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionBetween(Integer value1, Integer value2) {
            addCriterion("SecretQuestion between", value1, value2, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andSecretQuestionNotBetween(Integer value1, Integer value2) {
            addCriterion("SecretQuestion not between", value1, value2, "secretQuestion");
            return (Criteria) this;
        }

        public Criteria andInicioVIPIsNull() {
            addCriterion("InicioVIP is null");
            return (Criteria) this;
        }

        public Criteria andInicioVIPIsNotNull() {
            addCriterion("InicioVIP is not null");
            return (Criteria) this;
        }

        public Criteria andInicioVIPEqualTo(String value) {
            addCriterion("InicioVIP =", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPNotEqualTo(String value) {
            addCriterion("InicioVIP <>", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPGreaterThan(String value) {
            addCriterion("InicioVIP >", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPGreaterThanOrEqualTo(String value) {
            addCriterion("InicioVIP >=", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPLessThan(String value) {
            addCriterion("InicioVIP <", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPLessThanOrEqualTo(String value) {
            addCriterion("InicioVIP <=", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPLike(String value) {
            addCriterion("InicioVIP like", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPNotLike(String value) {
            addCriterion("InicioVIP not like", value, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPIn(List<String> values) {
            addCriterion("InicioVIP in", values, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPNotIn(List<String> values) {
            addCriterion("InicioVIP not in", values, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPBetween(String value1, String value2) {
            addCriterion("InicioVIP between", value1, value2, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andInicioVIPNotBetween(String value1, String value2) {
            addCriterion("InicioVIP not between", value1, value2, "inicioVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPIsNull() {
            addCriterion("FinVIP is null");
            return (Criteria) this;
        }

        public Criteria andFinVIPIsNotNull() {
            addCriterion("FinVIP is not null");
            return (Criteria) this;
        }

        public Criteria andFinVIPEqualTo(String value) {
            addCriterion("FinVIP =", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPNotEqualTo(String value) {
            addCriterion("FinVIP <>", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPGreaterThan(String value) {
            addCriterion("FinVIP >", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPGreaterThanOrEqualTo(String value) {
            addCriterion("FinVIP >=", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPLessThan(String value) {
            addCriterion("FinVIP <", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPLessThanOrEqualTo(String value) {
            addCriterion("FinVIP <=", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPLike(String value) {
            addCriterion("FinVIP like", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPNotLike(String value) {
            addCriterion("FinVIP not like", value, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPIn(List<String> values) {
            addCriterion("FinVIP in", values, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPNotIn(List<String> values) {
            addCriterion("FinVIP not in", values, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPBetween(String value1, String value2) {
            addCriterion("FinVIP between", value1, value2, "finVIP");
            return (Criteria) this;
        }

        public Criteria andFinVIPNotBetween(String value1, String value2) {
            addCriterion("FinVIP not between", value1, value2, "finVIP");
            return (Criteria) this;
        }

        public Criteria andVipTipeIsNull() {
            addCriterion("VipTipe is null");
            return (Criteria) this;
        }

        public Criteria andVipTipeIsNotNull() {
            addCriterion("VipTipe is not null");
            return (Criteria) this;
        }

        public Criteria andVipTipeEqualTo(Integer value) {
            addCriterion("VipTipe =", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeNotEqualTo(Integer value) {
            addCriterion("VipTipe <>", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeGreaterThan(Integer value) {
            addCriterion("VipTipe >", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeGreaterThanOrEqualTo(Integer value) {
            addCriterion("VipTipe >=", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeLessThan(Integer value) {
            addCriterion("VipTipe <", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeLessThanOrEqualTo(Integer value) {
            addCriterion("VipTipe <=", value, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeIn(List<Integer> values) {
            addCriterion("VipTipe in", values, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeNotIn(List<Integer> values) {
            addCriterion("VipTipe not in", values, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeBetween(Integer value1, Integer value2) {
            addCriterion("VipTipe between", value1, value2, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipTipeNotBetween(Integer value1, Integer value2) {
            addCriterion("VipTipe not between", value1, value2, "vipTipe");
            return (Criteria) this;
        }

        public Criteria andVipDateIsNull() {
            addCriterion("VipDate is null");
            return (Criteria) this;
        }

        public Criteria andVipDateIsNotNull() {
            addCriterion("VipDate is not null");
            return (Criteria) this;
        }

        public Criteria andVipDateEqualTo(String value) {
            addCriterion("VipDate =", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateNotEqualTo(String value) {
            addCriterion("VipDate <>", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateGreaterThan(String value) {
            addCriterion("VipDate >", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateGreaterThanOrEqualTo(String value) {
            addCriterion("VipDate >=", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateLessThan(String value) {
            addCriterion("VipDate <", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateLessThanOrEqualTo(String value) {
            addCriterion("VipDate <=", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateLike(String value) {
            addCriterion("VipDate like", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateNotLike(String value) {
            addCriterion("VipDate not like", value, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateIn(List<String> values) {
            addCriterion("VipDate in", values, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateNotIn(List<String> values) {
            addCriterion("VipDate not in", values, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateBetween(String value1, String value2) {
            addCriterion("VipDate between", value1, value2, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipDateNotBetween(String value1, String value2) {
            addCriterion("VipDate not between", value1, value2, "vipDate");
            return (Criteria) this;
        }

        public Criteria andVipINFIsNull() {
            addCriterion("VipINF is null");
            return (Criteria) this;
        }

        public Criteria andVipINFIsNotNull() {
            addCriterion("VipINF is not null");
            return (Criteria) this;
        }

        public Criteria andVipINFEqualTo(String value) {
            addCriterion("VipINF =", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFNotEqualTo(String value) {
            addCriterion("VipINF <>", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFGreaterThan(String value) {
            addCriterion("VipINF >", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFGreaterThanOrEqualTo(String value) {
            addCriterion("VipINF >=", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFLessThan(String value) {
            addCriterion("VipINF <", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFLessThanOrEqualTo(String value) {
            addCriterion("VipINF <=", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFLike(String value) {
            addCriterion("VipINF like", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFNotLike(String value) {
            addCriterion("VipINF not like", value, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFIn(List<String> values) {
            addCriterion("VipINF in", values, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFNotIn(List<String> values) {
            addCriterion("VipINF not in", values, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFBetween(String value1, String value2) {
            addCriterion("VipINF between", value1, value2, "vipINF");
            return (Criteria) this;
        }

        public Criteria andVipINFNotBetween(String value1, String value2) {
            addCriterion("VipINF not between", value1, value2, "vipINF");
            return (Criteria) this;
        }

        public Criteria andTVoteIsNull() {
            addCriterion("TVote is null");
            return (Criteria) this;
        }

        public Criteria andTVoteIsNotNull() {
            addCriterion("TVote is not null");
            return (Criteria) this;
        }

        public Criteria andTVoteEqualTo(Integer value) {
            addCriterion("TVote =", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteNotEqualTo(Integer value) {
            addCriterion("TVote <>", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteGreaterThan(Integer value) {
            addCriterion("TVote >", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("TVote >=", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteLessThan(Integer value) {
            addCriterion("TVote <", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteLessThanOrEqualTo(Integer value) {
            addCriterion("TVote <=", value, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteIn(List<Integer> values) {
            addCriterion("TVote in", values, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteNotIn(List<Integer> values) {
            addCriterion("TVote not in", values, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteBetween(Integer value1, Integer value2) {
            addCriterion("TVote between", value1, value2, "TVote");
            return (Criteria) this;
        }

        public Criteria andTVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("TVote not between", value1, value2, "TVote");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("Admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("Admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(Integer value) {
            addCriterion("Admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(Integer value) {
            addCriterion("Admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(Integer value) {
            addCriterion("Admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("Admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(Integer value) {
            addCriterion("Admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(Integer value) {
            addCriterion("Admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<Integer> values) {
            addCriterion("Admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<Integer> values) {
            addCriterion("Admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(Integer value1, Integer value2) {
            addCriterion("Admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("Admin not between", value1, value2, "admin");
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