package pe.com.acme.domain.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CharacterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CharacterExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAccountIDIsNull() {
            addCriterion("AccountID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIDIsNotNull() {
            addCriterion("AccountID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIDEqualTo(String value) {
            addCriterion("AccountID =", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotEqualTo(String value) {
            addCriterion("AccountID <>", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDGreaterThan(String value) {
            addCriterion("AccountID >", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDGreaterThanOrEqualTo(String value) {
            addCriterion("AccountID >=", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLessThan(String value) {
            addCriterion("AccountID <", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLessThanOrEqualTo(String value) {
            addCriterion("AccountID <=", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDLike(String value) {
            addCriterion("AccountID like", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotLike(String value) {
            addCriterion("AccountID not like", value, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDIn(List<String> values) {
            addCriterion("AccountID in", values, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotIn(List<String> values) {
            addCriterion("AccountID not in", values, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDBetween(String value1, String value2) {
            addCriterion("AccountID between", value1, value2, "accountID");
            return (Criteria) this;
        }

        public Criteria andAccountIDNotBetween(String value1, String value2) {
            addCriterion("AccountID not between", value1, value2, "accountID");
            return (Criteria) this;
        }

        public Criteria andCLevelIsNull() {
            addCriterion("cLevel is null");
            return (Criteria) this;
        }

        public Criteria andCLevelIsNotNull() {
            addCriterion("cLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCLevelEqualTo(Integer value) {
            addCriterion("cLevel =", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotEqualTo(Integer value) {
            addCriterion("cLevel <>", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelGreaterThan(Integer value) {
            addCriterion("cLevel >", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("cLevel >=", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelLessThan(Integer value) {
            addCriterion("cLevel <", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelLessThanOrEqualTo(Integer value) {
            addCriterion("cLevel <=", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelIn(List<Integer> values) {
            addCriterion("cLevel in", values, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotIn(List<Integer> values) {
            addCriterion("cLevel not in", values, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelBetween(Integer value1, Integer value2) {
            addCriterion("cLevel between", value1, value2, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("cLevel not between", value1, value2, "cLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointIsNull() {
            addCriterion("LevelUpPoint is null");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointIsNotNull() {
            addCriterion("LevelUpPoint is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointEqualTo(Integer value) {
            addCriterion("LevelUpPoint =", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointNotEqualTo(Integer value) {
            addCriterion("LevelUpPoint <>", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointGreaterThan(Integer value) {
            addCriterion("LevelUpPoint >", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("LevelUpPoint >=", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointLessThan(Integer value) {
            addCriterion("LevelUpPoint <", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointLessThanOrEqualTo(Integer value) {
            addCriterion("LevelUpPoint <=", value, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointIn(List<Integer> values) {
            addCriterion("LevelUpPoint in", values, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointNotIn(List<Integer> values) {
            addCriterion("LevelUpPoint not in", values, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointBetween(Integer value1, Integer value2) {
            addCriterion("LevelUpPoint between", value1, value2, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andLevelUpPointNotBetween(Integer value1, Integer value2) {
            addCriterion("LevelUpPoint not between", value1, value2, "levelUpPoint");
            return (Criteria) this;
        }

        public Criteria andClassIsNull() {
            addCriterion("Class is null");
            return (Criteria) this;
        }

        public Criteria andClassIsNotNull() {
            addCriterion("Class is not null");
            return (Criteria) this;
        }

        public Criteria andClassEqualTo(Byte value) {
            addCriterion("Class =", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotEqualTo(Byte value) {
            addCriterion("Class <>", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassGreaterThan(Byte value) {
            addCriterion("Class >", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassGreaterThanOrEqualTo(Byte value) {
            addCriterion("Class >=", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassLessThan(Byte value) {
            addCriterion("Class <", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassLessThanOrEqualTo(Byte value) {
            addCriterion("Class <=", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassIn(List<Byte> values) {
            addCriterion("Class in", values, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotIn(List<Byte> values) {
            addCriterion("Class not in", values, "class");
            return (Criteria) this;
        }

        public Criteria andClassBetween(Byte value1, Byte value2) {
            addCriterion("Class between", value1, value2, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotBetween(Byte value1, Byte value2) {
            addCriterion("Class not between", value1, value2, "class");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("Experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("Experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("Experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("Experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("Experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("Experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("Experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("Experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("Experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("Experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("Experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("Experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andStrengthIsNull() {
            addCriterion("Strength is null");
            return (Criteria) this;
        }

        public Criteria andStrengthIsNotNull() {
            addCriterion("Strength is not null");
            return (Criteria) this;
        }

        public Criteria andStrengthEqualTo(Integer value) {
            addCriterion("Strength =", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthNotEqualTo(Integer value) {
            addCriterion("Strength <>", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthGreaterThan(Integer value) {
            addCriterion("Strength >", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("Strength >=", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthLessThan(Integer value) {
            addCriterion("Strength <", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthLessThanOrEqualTo(Integer value) {
            addCriterion("Strength <=", value, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthIn(List<Integer> values) {
            addCriterion("Strength in", values, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthNotIn(List<Integer> values) {
            addCriterion("Strength not in", values, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthBetween(Integer value1, Integer value2) {
            addCriterion("Strength between", value1, value2, "strength");
            return (Criteria) this;
        }

        public Criteria andStrengthNotBetween(Integer value1, Integer value2) {
            addCriterion("Strength not between", value1, value2, "strength");
            return (Criteria) this;
        }

        public Criteria andDexterityIsNull() {
            addCriterion("Dexterity is null");
            return (Criteria) this;
        }

        public Criteria andDexterityIsNotNull() {
            addCriterion("Dexterity is not null");
            return (Criteria) this;
        }

        public Criteria andDexterityEqualTo(Integer value) {
            addCriterion("Dexterity =", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityNotEqualTo(Integer value) {
            addCriterion("Dexterity <>", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityGreaterThan(Integer value) {
            addCriterion("Dexterity >", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dexterity >=", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityLessThan(Integer value) {
            addCriterion("Dexterity <", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityLessThanOrEqualTo(Integer value) {
            addCriterion("Dexterity <=", value, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityIn(List<Integer> values) {
            addCriterion("Dexterity in", values, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityNotIn(List<Integer> values) {
            addCriterion("Dexterity not in", values, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityBetween(Integer value1, Integer value2) {
            addCriterion("Dexterity between", value1, value2, "dexterity");
            return (Criteria) this;
        }

        public Criteria andDexterityNotBetween(Integer value1, Integer value2) {
            addCriterion("Dexterity not between", value1, value2, "dexterity");
            return (Criteria) this;
        }

        public Criteria andVitalityIsNull() {
            addCriterion("Vitality is null");
            return (Criteria) this;
        }

        public Criteria andVitalityIsNotNull() {
            addCriterion("Vitality is not null");
            return (Criteria) this;
        }

        public Criteria andVitalityEqualTo(Integer value) {
            addCriterion("Vitality =", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityNotEqualTo(Integer value) {
            addCriterion("Vitality <>", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityGreaterThan(Integer value) {
            addCriterion("Vitality >", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityGreaterThanOrEqualTo(Integer value) {
            addCriterion("Vitality >=", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityLessThan(Integer value) {
            addCriterion("Vitality <", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityLessThanOrEqualTo(Integer value) {
            addCriterion("Vitality <=", value, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityIn(List<Integer> values) {
            addCriterion("Vitality in", values, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityNotIn(List<Integer> values) {
            addCriterion("Vitality not in", values, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityBetween(Integer value1, Integer value2) {
            addCriterion("Vitality between", value1, value2, "vitality");
            return (Criteria) this;
        }

        public Criteria andVitalityNotBetween(Integer value1, Integer value2) {
            addCriterion("Vitality not between", value1, value2, "vitality");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNull() {
            addCriterion("Energy is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("Energy is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(Integer value) {
            addCriterion("Energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(Integer value) {
            addCriterion("Energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(Integer value) {
            addCriterion("Energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(Integer value) {
            addCriterion("Energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(Integer value) {
            addCriterion("Energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<Integer> values) {
            addCriterion("Energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<Integer> values) {
            addCriterion("Energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(Integer value1, Integer value2) {
            addCriterion("Energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(Integer value1, Integer value2) {
            addCriterion("Energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("Money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("Money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            addCriterion("Money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            addCriterion("Money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            addCriterion("Money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            addCriterion("Money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("Money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            addCriterion("Money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            addCriterion("Money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            addCriterion("Money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("Money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andLifeIsNull() {
            addCriterion("Life is null");
            return (Criteria) this;
        }

        public Criteria andLifeIsNotNull() {
            addCriterion("Life is not null");
            return (Criteria) this;
        }

        public Criteria andLifeEqualTo(Float value) {
            addCriterion("Life =", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotEqualTo(Float value) {
            addCriterion("Life <>", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeGreaterThan(Float value) {
            addCriterion("Life >", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeGreaterThanOrEqualTo(Float value) {
            addCriterion("Life >=", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeLessThan(Float value) {
            addCriterion("Life <", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeLessThanOrEqualTo(Float value) {
            addCriterion("Life <=", value, "life");
            return (Criteria) this;
        }

        public Criteria andLifeIn(List<Float> values) {
            addCriterion("Life in", values, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotIn(List<Float> values) {
            addCriterion("Life not in", values, "life");
            return (Criteria) this;
        }

        public Criteria andLifeBetween(Float value1, Float value2) {
            addCriterion("Life between", value1, value2, "life");
            return (Criteria) this;
        }

        public Criteria andLifeNotBetween(Float value1, Float value2) {
            addCriterion("Life not between", value1, value2, "life");
            return (Criteria) this;
        }

        public Criteria andMaxLifeIsNull() {
            addCriterion("MaxLife is null");
            return (Criteria) this;
        }

        public Criteria andMaxLifeIsNotNull() {
            addCriterion("MaxLife is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLifeEqualTo(Float value) {
            addCriterion("MaxLife =", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeNotEqualTo(Float value) {
            addCriterion("MaxLife <>", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeGreaterThan(Float value) {
            addCriterion("MaxLife >", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeGreaterThanOrEqualTo(Float value) {
            addCriterion("MaxLife >=", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeLessThan(Float value) {
            addCriterion("MaxLife <", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeLessThanOrEqualTo(Float value) {
            addCriterion("MaxLife <=", value, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeIn(List<Float> values) {
            addCriterion("MaxLife in", values, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeNotIn(List<Float> values) {
            addCriterion("MaxLife not in", values, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeBetween(Float value1, Float value2) {
            addCriterion("MaxLife between", value1, value2, "maxLife");
            return (Criteria) this;
        }

        public Criteria andMaxLifeNotBetween(Float value1, Float value2) {
            addCriterion("MaxLife not between", value1, value2, "maxLife");
            return (Criteria) this;
        }

        public Criteria andManaIsNull() {
            addCriterion("Mana is null");
            return (Criteria) this;
        }

        public Criteria andManaIsNotNull() {
            addCriterion("Mana is not null");
            return (Criteria) this;
        }

        public Criteria andManaEqualTo(Float value) {
            addCriterion("Mana =", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaNotEqualTo(Float value) {
            addCriterion("Mana <>", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaGreaterThan(Float value) {
            addCriterion("Mana >", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaGreaterThanOrEqualTo(Float value) {
            addCriterion("Mana >=", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaLessThan(Float value) {
            addCriterion("Mana <", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaLessThanOrEqualTo(Float value) {
            addCriterion("Mana <=", value, "mana");
            return (Criteria) this;
        }

        public Criteria andManaIn(List<Float> values) {
            addCriterion("Mana in", values, "mana");
            return (Criteria) this;
        }

        public Criteria andManaNotIn(List<Float> values) {
            addCriterion("Mana not in", values, "mana");
            return (Criteria) this;
        }

        public Criteria andManaBetween(Float value1, Float value2) {
            addCriterion("Mana between", value1, value2, "mana");
            return (Criteria) this;
        }

        public Criteria andManaNotBetween(Float value1, Float value2) {
            addCriterion("Mana not between", value1, value2, "mana");
            return (Criteria) this;
        }

        public Criteria andMaxManaIsNull() {
            addCriterion("MaxMana is null");
            return (Criteria) this;
        }

        public Criteria andMaxManaIsNotNull() {
            addCriterion("MaxMana is not null");
            return (Criteria) this;
        }

        public Criteria andMaxManaEqualTo(Float value) {
            addCriterion("MaxMana =", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaNotEqualTo(Float value) {
            addCriterion("MaxMana <>", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaGreaterThan(Float value) {
            addCriterion("MaxMana >", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaGreaterThanOrEqualTo(Float value) {
            addCriterion("MaxMana >=", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaLessThan(Float value) {
            addCriterion("MaxMana <", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaLessThanOrEqualTo(Float value) {
            addCriterion("MaxMana <=", value, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaIn(List<Float> values) {
            addCriterion("MaxMana in", values, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaNotIn(List<Float> values) {
            addCriterion("MaxMana not in", values, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaBetween(Float value1, Float value2) {
            addCriterion("MaxMana between", value1, value2, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMaxManaNotBetween(Float value1, Float value2) {
            addCriterion("MaxMana not between", value1, value2, "maxMana");
            return (Criteria) this;
        }

        public Criteria andMapNumberIsNull() {
            addCriterion("MapNumber is null");
            return (Criteria) this;
        }

        public Criteria andMapNumberIsNotNull() {
            addCriterion("MapNumber is not null");
            return (Criteria) this;
        }

        public Criteria andMapNumberEqualTo(Short value) {
            addCriterion("MapNumber =", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberNotEqualTo(Short value) {
            addCriterion("MapNumber <>", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberGreaterThan(Short value) {
            addCriterion("MapNumber >", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("MapNumber >=", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberLessThan(Short value) {
            addCriterion("MapNumber <", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberLessThanOrEqualTo(Short value) {
            addCriterion("MapNumber <=", value, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberIn(List<Short> values) {
            addCriterion("MapNumber in", values, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberNotIn(List<Short> values) {
            addCriterion("MapNumber not in", values, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberBetween(Short value1, Short value2) {
            addCriterion("MapNumber between", value1, value2, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapNumberNotBetween(Short value1, Short value2) {
            addCriterion("MapNumber not between", value1, value2, "mapNumber");
            return (Criteria) this;
        }

        public Criteria andMapPosXIsNull() {
            addCriterion("MapPosX is null");
            return (Criteria) this;
        }

        public Criteria andMapPosXIsNotNull() {
            addCriterion("MapPosX is not null");
            return (Criteria) this;
        }

        public Criteria andMapPosXEqualTo(Short value) {
            addCriterion("MapPosX =", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXNotEqualTo(Short value) {
            addCriterion("MapPosX <>", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXGreaterThan(Short value) {
            addCriterion("MapPosX >", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXGreaterThanOrEqualTo(Short value) {
            addCriterion("MapPosX >=", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXLessThan(Short value) {
            addCriterion("MapPosX <", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXLessThanOrEqualTo(Short value) {
            addCriterion("MapPosX <=", value, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXIn(List<Short> values) {
            addCriterion("MapPosX in", values, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXNotIn(List<Short> values) {
            addCriterion("MapPosX not in", values, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXBetween(Short value1, Short value2) {
            addCriterion("MapPosX between", value1, value2, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosXNotBetween(Short value1, Short value2) {
            addCriterion("MapPosX not between", value1, value2, "mapPosX");
            return (Criteria) this;
        }

        public Criteria andMapPosYIsNull() {
            addCriterion("MapPosY is null");
            return (Criteria) this;
        }

        public Criteria andMapPosYIsNotNull() {
            addCriterion("MapPosY is not null");
            return (Criteria) this;
        }

        public Criteria andMapPosYEqualTo(Short value) {
            addCriterion("MapPosY =", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYNotEqualTo(Short value) {
            addCriterion("MapPosY <>", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYGreaterThan(Short value) {
            addCriterion("MapPosY >", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYGreaterThanOrEqualTo(Short value) {
            addCriterion("MapPosY >=", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYLessThan(Short value) {
            addCriterion("MapPosY <", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYLessThanOrEqualTo(Short value) {
            addCriterion("MapPosY <=", value, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYIn(List<Short> values) {
            addCriterion("MapPosY in", values, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYNotIn(List<Short> values) {
            addCriterion("MapPosY not in", values, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYBetween(Short value1, Short value2) {
            addCriterion("MapPosY between", value1, value2, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapPosYNotBetween(Short value1, Short value2) {
            addCriterion("MapPosY not between", value1, value2, "mapPosY");
            return (Criteria) this;
        }

        public Criteria andMapDirIsNull() {
            addCriterion("MapDir is null");
            return (Criteria) this;
        }

        public Criteria andMapDirIsNotNull() {
            addCriterion("MapDir is not null");
            return (Criteria) this;
        }

        public Criteria andMapDirEqualTo(Byte value) {
            addCriterion("MapDir =", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirNotEqualTo(Byte value) {
            addCriterion("MapDir <>", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirGreaterThan(Byte value) {
            addCriterion("MapDir >", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirGreaterThanOrEqualTo(Byte value) {
            addCriterion("MapDir >=", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirLessThan(Byte value) {
            addCriterion("MapDir <", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirLessThanOrEqualTo(Byte value) {
            addCriterion("MapDir <=", value, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirIn(List<Byte> values) {
            addCriterion("MapDir in", values, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirNotIn(List<Byte> values) {
            addCriterion("MapDir not in", values, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirBetween(Byte value1, Byte value2) {
            addCriterion("MapDir between", value1, value2, "mapDir");
            return (Criteria) this;
        }

        public Criteria andMapDirNotBetween(Byte value1, Byte value2) {
            addCriterion("MapDir not between", value1, value2, "mapDir");
            return (Criteria) this;
        }

        public Criteria andPkCountIsNull() {
            addCriterion("PkCount is null");
            return (Criteria) this;
        }

        public Criteria andPkCountIsNotNull() {
            addCriterion("PkCount is not null");
            return (Criteria) this;
        }

        public Criteria andPkCountEqualTo(Integer value) {
            addCriterion("PkCount =", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountNotEqualTo(Integer value) {
            addCriterion("PkCount <>", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountGreaterThan(Integer value) {
            addCriterion("PkCount >", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PkCount >=", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountLessThan(Integer value) {
            addCriterion("PkCount <", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountLessThanOrEqualTo(Integer value) {
            addCriterion("PkCount <=", value, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountIn(List<Integer> values) {
            addCriterion("PkCount in", values, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountNotIn(List<Integer> values) {
            addCriterion("PkCount not in", values, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountBetween(Integer value1, Integer value2) {
            addCriterion("PkCount between", value1, value2, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PkCount not between", value1, value2, "pkCount");
            return (Criteria) this;
        }

        public Criteria andPkLevelIsNull() {
            addCriterion("PkLevel is null");
            return (Criteria) this;
        }

        public Criteria andPkLevelIsNotNull() {
            addCriterion("PkLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPkLevelEqualTo(Integer value) {
            addCriterion("PkLevel =", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelNotEqualTo(Integer value) {
            addCriterion("PkLevel <>", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelGreaterThan(Integer value) {
            addCriterion("PkLevel >", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("PkLevel >=", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelLessThan(Integer value) {
            addCriterion("PkLevel <", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelLessThanOrEqualTo(Integer value) {
            addCriterion("PkLevel <=", value, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelIn(List<Integer> values) {
            addCriterion("PkLevel in", values, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelNotIn(List<Integer> values) {
            addCriterion("PkLevel not in", values, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelBetween(Integer value1, Integer value2) {
            addCriterion("PkLevel between", value1, value2, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("PkLevel not between", value1, value2, "pkLevel");
            return (Criteria) this;
        }

        public Criteria andPkTimeIsNull() {
            addCriterion("PkTime is null");
            return (Criteria) this;
        }

        public Criteria andPkTimeIsNotNull() {
            addCriterion("PkTime is not null");
            return (Criteria) this;
        }

        public Criteria andPkTimeEqualTo(Integer value) {
            addCriterion("PkTime =", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeNotEqualTo(Integer value) {
            addCriterion("PkTime <>", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeGreaterThan(Integer value) {
            addCriterion("PkTime >", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PkTime >=", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeLessThan(Integer value) {
            addCriterion("PkTime <", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeLessThanOrEqualTo(Integer value) {
            addCriterion("PkTime <=", value, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeIn(List<Integer> values) {
            addCriterion("PkTime in", values, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeNotIn(List<Integer> values) {
            addCriterion("PkTime not in", values, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeBetween(Integer value1, Integer value2) {
            addCriterion("PkTime between", value1, value2, "pkTime");
            return (Criteria) this;
        }

        public Criteria andPkTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("PkTime not between", value1, value2, "pkTime");
            return (Criteria) this;
        }

        public Criteria andMDateIsNull() {
            addCriterion("MDate is null");
            return (Criteria) this;
        }

        public Criteria andMDateIsNotNull() {
            addCriterion("MDate is not null");
            return (Criteria) this;
        }

        public Criteria andMDateEqualTo(Date value) {
            addCriterion("MDate =", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotEqualTo(Date value) {
            addCriterion("MDate <>", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateGreaterThan(Date value) {
            addCriterion("MDate >", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateGreaterThanOrEqualTo(Date value) {
            addCriterion("MDate >=", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateLessThan(Date value) {
            addCriterion("MDate <", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateLessThanOrEqualTo(Date value) {
            addCriterion("MDate <=", value, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateIn(List<Date> values) {
            addCriterion("MDate in", values, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotIn(List<Date> values) {
            addCriterion("MDate not in", values, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateBetween(Date value1, Date value2) {
            addCriterion("MDate between", value1, value2, "MDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotBetween(Date value1, Date value2) {
            addCriterion("MDate not between", value1, value2, "MDate");
            return (Criteria) this;
        }

        public Criteria andLDateIsNull() {
            addCriterion("LDate is null");
            return (Criteria) this;
        }

        public Criteria andLDateIsNotNull() {
            addCriterion("LDate is not null");
            return (Criteria) this;
        }

        public Criteria andLDateEqualTo(Date value) {
            addCriterion("LDate =", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateNotEqualTo(Date value) {
            addCriterion("LDate <>", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateGreaterThan(Date value) {
            addCriterion("LDate >", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LDate >=", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateLessThan(Date value) {
            addCriterion("LDate <", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateLessThanOrEqualTo(Date value) {
            addCriterion("LDate <=", value, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateIn(List<Date> values) {
            addCriterion("LDate in", values, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateNotIn(List<Date> values) {
            addCriterion("LDate not in", values, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateBetween(Date value1, Date value2) {
            addCriterion("LDate between", value1, value2, "LDate");
            return (Criteria) this;
        }

        public Criteria andLDateNotBetween(Date value1, Date value2) {
            addCriterion("LDate not between", value1, value2, "LDate");
            return (Criteria) this;
        }

        public Criteria andCtlCodeIsNull() {
            addCriterion("CtlCode is null");
            return (Criteria) this;
        }

        public Criteria andCtlCodeIsNotNull() {
            addCriterion("CtlCode is not null");
            return (Criteria) this;
        }

        public Criteria andCtlCodeEqualTo(Byte value) {
            addCriterion("CtlCode =", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeNotEqualTo(Byte value) {
            addCriterion("CtlCode <>", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeGreaterThan(Byte value) {
            addCriterion("CtlCode >", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CtlCode >=", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeLessThan(Byte value) {
            addCriterion("CtlCode <", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeLessThanOrEqualTo(Byte value) {
            addCriterion("CtlCode <=", value, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeIn(List<Byte> values) {
            addCriterion("CtlCode in", values, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeNotIn(List<Byte> values) {
            addCriterion("CtlCode not in", values, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeBetween(Byte value1, Byte value2) {
            addCriterion("CtlCode between", value1, value2, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andCtlCodeNotBetween(Byte value1, Byte value2) {
            addCriterion("CtlCode not between", value1, value2, "ctlCode");
            return (Criteria) this;
        }

        public Criteria andDbVersionIsNull() {
            addCriterion("DbVersion is null");
            return (Criteria) this;
        }

        public Criteria andDbVersionIsNotNull() {
            addCriterion("DbVersion is not null");
            return (Criteria) this;
        }

        public Criteria andDbVersionEqualTo(Byte value) {
            addCriterion("DbVersion =", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotEqualTo(Byte value) {
            addCriterion("DbVersion <>", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionGreaterThan(Byte value) {
            addCriterion("DbVersion >", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionGreaterThanOrEqualTo(Byte value) {
            addCriterion("DbVersion >=", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionLessThan(Byte value) {
            addCriterion("DbVersion <", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionLessThanOrEqualTo(Byte value) {
            addCriterion("DbVersion <=", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionIn(List<Byte> values) {
            addCriterion("DbVersion in", values, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotIn(List<Byte> values) {
            addCriterion("DbVersion not in", values, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionBetween(Byte value1, Byte value2) {
            addCriterion("DbVersion between", value1, value2, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotBetween(Byte value1, Byte value2) {
            addCriterion("DbVersion not between", value1, value2, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andLeadershipIsNull() {
            addCriterion("Leadership is null");
            return (Criteria) this;
        }

        public Criteria andLeadershipIsNotNull() {
            addCriterion("Leadership is not null");
            return (Criteria) this;
        }

        public Criteria andLeadershipEqualTo(Integer value) {
            addCriterion("Leadership =", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipNotEqualTo(Integer value) {
            addCriterion("Leadership <>", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipGreaterThan(Integer value) {
            addCriterion("Leadership >", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipGreaterThanOrEqualTo(Integer value) {
            addCriterion("Leadership >=", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipLessThan(Integer value) {
            addCriterion("Leadership <", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipLessThanOrEqualTo(Integer value) {
            addCriterion("Leadership <=", value, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipIn(List<Integer> values) {
            addCriterion("Leadership in", values, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipNotIn(List<Integer> values) {
            addCriterion("Leadership not in", values, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipBetween(Integer value1, Integer value2) {
            addCriterion("Leadership between", value1, value2, "leadership");
            return (Criteria) this;
        }

        public Criteria andLeadershipNotBetween(Integer value1, Integer value2) {
            addCriterion("Leadership not between", value1, value2, "leadership");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeIsNull() {
            addCriterion("ChatLimitTime is null");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeIsNotNull() {
            addCriterion("ChatLimitTime is not null");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeEqualTo(Short value) {
            addCriterion("ChatLimitTime =", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeNotEqualTo(Short value) {
            addCriterion("ChatLimitTime <>", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeGreaterThan(Short value) {
            addCriterion("ChatLimitTime >", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("ChatLimitTime >=", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeLessThan(Short value) {
            addCriterion("ChatLimitTime <", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeLessThanOrEqualTo(Short value) {
            addCriterion("ChatLimitTime <=", value, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeIn(List<Short> values) {
            addCriterion("ChatLimitTime in", values, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeNotIn(List<Short> values) {
            addCriterion("ChatLimitTime not in", values, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeBetween(Short value1, Short value2) {
            addCriterion("ChatLimitTime between", value1, value2, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andChatLimitTimeNotBetween(Short value1, Short value2) {
            addCriterion("ChatLimitTime not between", value1, value2, "chatLimitTime");
            return (Criteria) this;
        }

        public Criteria andFruitPointIsNull() {
            addCriterion("FruitPoint is null");
            return (Criteria) this;
        }

        public Criteria andFruitPointIsNotNull() {
            addCriterion("FruitPoint is not null");
            return (Criteria) this;
        }

        public Criteria andFruitPointEqualTo(Integer value) {
            addCriterion("FruitPoint =", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointNotEqualTo(Integer value) {
            addCriterion("FruitPoint <>", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointGreaterThan(Integer value) {
            addCriterion("FruitPoint >", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("FruitPoint >=", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointLessThan(Integer value) {
            addCriterion("FruitPoint <", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointLessThanOrEqualTo(Integer value) {
            addCriterion("FruitPoint <=", value, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointIn(List<Integer> values) {
            addCriterion("FruitPoint in", values, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointNotIn(List<Integer> values) {
            addCriterion("FruitPoint not in", values, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointBetween(Integer value1, Integer value2) {
            addCriterion("FruitPoint between", value1, value2, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andFruitPointNotBetween(Integer value1, Integer value2) {
            addCriterion("FruitPoint not between", value1, value2, "fruitPoint");
            return (Criteria) this;
        }

        public Criteria andJHDXIsNull() {
            addCriterion("JHDX is null");
            return (Criteria) this;
        }

        public Criteria andJHDXIsNotNull() {
            addCriterion("JHDX is not null");
            return (Criteria) this;
        }

        public Criteria andJHDXEqualTo(String value) {
            addCriterion("JHDX =", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXNotEqualTo(String value) {
            addCriterion("JHDX <>", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXGreaterThan(String value) {
            addCriterion("JHDX >", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXGreaterThanOrEqualTo(String value) {
            addCriterion("JHDX >=", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXLessThan(String value) {
            addCriterion("JHDX <", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXLessThanOrEqualTo(String value) {
            addCriterion("JHDX <=", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXLike(String value) {
            addCriterion("JHDX like", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXNotLike(String value) {
            addCriterion("JHDX not like", value, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXIn(List<String> values) {
            addCriterion("JHDX in", values, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXNotIn(List<String> values) {
            addCriterion("JHDX not in", values, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXBetween(String value1, String value2) {
            addCriterion("JHDX between", value1, value2, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHDXNotBetween(String value1, String value2) {
            addCriterion("JHDX not between", value1, value2, "JHDX");
            return (Criteria) this;
        }

        public Criteria andJHtypeIsNull() {
            addCriterion("JHtype is null");
            return (Criteria) this;
        }

        public Criteria andJHtypeIsNotNull() {
            addCriterion("JHtype is not null");
            return (Criteria) this;
        }

        public Criteria andJHtypeEqualTo(Byte value) {
            addCriterion("JHtype =", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeNotEqualTo(Byte value) {
            addCriterion("JHtype <>", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeGreaterThan(Byte value) {
            addCriterion("JHtype >", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("JHtype >=", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeLessThan(Byte value) {
            addCriterion("JHtype <", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeLessThanOrEqualTo(Byte value) {
            addCriterion("JHtype <=", value, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeIn(List<Byte> values) {
            addCriterion("JHtype in", values, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeNotIn(List<Byte> values) {
            addCriterion("JHtype not in", values, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeBetween(Byte value1, Byte value2) {
            addCriterion("JHtype between", value1, value2, "JHtype");
            return (Criteria) this;
        }

        public Criteria andJHtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("JHtype not between", value1, value2, "JHtype");
            return (Criteria) this;
        }

        public Criteria andResetsIsNull() {
            addCriterion("Resets is null");
            return (Criteria) this;
        }

        public Criteria andResetsIsNotNull() {
            addCriterion("Resets is not null");
            return (Criteria) this;
        }

        public Criteria andResetsEqualTo(Integer value) {
            addCriterion("Resets =", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsNotEqualTo(Integer value) {
            addCriterion("Resets <>", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsGreaterThan(Integer value) {
            addCriterion("Resets >", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Resets >=", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsLessThan(Integer value) {
            addCriterion("Resets <", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsLessThanOrEqualTo(Integer value) {
            addCriterion("Resets <=", value, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsIn(List<Integer> values) {
            addCriterion("Resets in", values, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsNotIn(List<Integer> values) {
            addCriterion("Resets not in", values, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsBetween(Integer value1, Integer value2) {
            addCriterion("Resets between", value1, value2, "resets");
            return (Criteria) this;
        }

        public Criteria andResetsNotBetween(Integer value1, Integer value2) {
            addCriterion("Resets not between", value1, value2, "resets");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryIsNull() {
            addCriterion("ExpandedInventory is null");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryIsNotNull() {
            addCriterion("ExpandedInventory is not null");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryEqualTo(Byte value) {
            addCriterion("ExpandedInventory =", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryNotEqualTo(Byte value) {
            addCriterion("ExpandedInventory <>", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryGreaterThan(Byte value) {
            addCriterion("ExpandedInventory >", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("ExpandedInventory >=", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryLessThan(Byte value) {
            addCriterion("ExpandedInventory <", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryLessThanOrEqualTo(Byte value) {
            addCriterion("ExpandedInventory <=", value, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryIn(List<Byte> values) {
            addCriterion("ExpandedInventory in", values, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryNotIn(List<Byte> values) {
            addCriterion("ExpandedInventory not in", values, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryBetween(Byte value1, Byte value2) {
            addCriterion("ExpandedInventory between", value1, value2, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andExpandedInventoryNotBetween(Byte value1, Byte value2) {
            addCriterion("ExpandedInventory not between", value1, value2, "expandedInventory");
            return (Criteria) this;
        }

        public Criteria andGrandResetsIsNull() {
            addCriterion("GrandResets is null");
            return (Criteria) this;
        }

        public Criteria andGrandResetsIsNotNull() {
            addCriterion("GrandResets is not null");
            return (Criteria) this;
        }

        public Criteria andGrandResetsEqualTo(Integer value) {
            addCriterion("GrandResets =", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsNotEqualTo(Integer value) {
            addCriterion("GrandResets <>", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsGreaterThan(Integer value) {
            addCriterion("GrandResets >", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsGreaterThanOrEqualTo(Integer value) {
            addCriterion("GrandResets >=", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsLessThan(Integer value) {
            addCriterion("GrandResets <", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsLessThanOrEqualTo(Integer value) {
            addCriterion("GrandResets <=", value, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsIn(List<Integer> values) {
            addCriterion("GrandResets in", values, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsNotIn(List<Integer> values) {
            addCriterion("GrandResets not in", values, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsBetween(Integer value1, Integer value2) {
            addCriterion("GrandResets between", value1, value2, "grandResets");
            return (Criteria) this;
        }

        public Criteria andGrandResetsNotBetween(Integer value1, Integer value2) {
            addCriterion("GrandResets not between", value1, value2, "grandResets");
            return (Criteria) this;
        }

        public Criteria andOffExpIsNull() {
            addCriterion("OffExp is null");
            return (Criteria) this;
        }

        public Criteria andOffExpIsNotNull() {
            addCriterion("OffExp is not null");
            return (Criteria) this;
        }

        public Criteria andOffExpEqualTo(Integer value) {
            addCriterion("OffExp =", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpNotEqualTo(Integer value) {
            addCriterion("OffExp <>", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpGreaterThan(Integer value) {
            addCriterion("OffExp >", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpGreaterThanOrEqualTo(Integer value) {
            addCriterion("OffExp >=", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpLessThan(Integer value) {
            addCriterion("OffExp <", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpLessThanOrEqualTo(Integer value) {
            addCriterion("OffExp <=", value, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpIn(List<Integer> values) {
            addCriterion("OffExp in", values, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpNotIn(List<Integer> values) {
            addCriterion("OffExp not in", values, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpBetween(Integer value1, Integer value2) {
            addCriterion("OffExp between", value1, value2, "offExp");
            return (Criteria) this;
        }

        public Criteria andOffExpNotBetween(Integer value1, Integer value2) {
            addCriterion("OffExp not between", value1, value2, "offExp");
            return (Criteria) this;
        }

        public Criteria andMu_idIsNull() {
            addCriterion("mu_id is null");
            return (Criteria) this;
        }

        public Criteria andMu_idIsNotNull() {
            addCriterion("mu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMu_idEqualTo(Integer value) {
            addCriterion("mu_id =", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idNotEqualTo(Integer value) {
            addCriterion("mu_id <>", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idGreaterThan(Integer value) {
            addCriterion("mu_id >", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("mu_id >=", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idLessThan(Integer value) {
            addCriterion("mu_id <", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idLessThanOrEqualTo(Integer value) {
            addCriterion("mu_id <=", value, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idIn(List<Integer> values) {
            addCriterion("mu_id in", values, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idNotIn(List<Integer> values) {
            addCriterion("mu_id not in", values, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idBetween(Integer value1, Integer value2) {
            addCriterion("mu_id between", value1, value2, "mu_id");
            return (Criteria) this;
        }

        public Criteria andMu_idNotBetween(Integer value1, Integer value2) {
            addCriterion("mu_id not between", value1, value2, "mu_id");
            return (Criteria) this;
        }

        public Criteria andCProfileIsNull() {
            addCriterion("CProfile is null");
            return (Criteria) this;
        }

        public Criteria andCProfileIsNotNull() {
            addCriterion("CProfile is not null");
            return (Criteria) this;
        }

        public Criteria andCProfileEqualTo(Integer value) {
            addCriterion("CProfile =", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileNotEqualTo(Integer value) {
            addCriterion("CProfile <>", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileGreaterThan(Integer value) {
            addCriterion("CProfile >", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileGreaterThanOrEqualTo(Integer value) {
            addCriterion("CProfile >=", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileLessThan(Integer value) {
            addCriterion("CProfile <", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileLessThanOrEqualTo(Integer value) {
            addCriterion("CProfile <=", value, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileIn(List<Integer> values) {
            addCriterion("CProfile in", values, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileNotIn(List<Integer> values) {
            addCriterion("CProfile not in", values, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileBetween(Integer value1, Integer value2) {
            addCriterion("CProfile between", value1, value2, "CProfile");
            return (Criteria) this;
        }

        public Criteria andCProfileNotBetween(Integer value1, Integer value2) {
            addCriterion("CProfile not between", value1, value2, "CProfile");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsIsNull() {
            addCriterion("Grand_Resets is null");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsIsNotNull() {
            addCriterion("Grand_Resets is not null");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsEqualTo(Integer value) {
            addCriterion("Grand_Resets =", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsNotEqualTo(Integer value) {
            addCriterion("Grand_Resets <>", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsGreaterThan(Integer value) {
            addCriterion("Grand_Resets >", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Grand_Resets >=", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsLessThan(Integer value) {
            addCriterion("Grand_Resets <", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsLessThanOrEqualTo(Integer value) {
            addCriterion("Grand_Resets <=", value, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsIn(List<Integer> values) {
            addCriterion("Grand_Resets in", values, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsNotIn(List<Integer> values) {
            addCriterion("Grand_Resets not in", values, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsBetween(Integer value1, Integer value2) {
            addCriterion("Grand_Resets between", value1, value2, "grand_Resets");
            return (Criteria) this;
        }

        public Criteria andGrand_ResetsNotBetween(Integer value1, Integer value2) {
            addCriterion("Grand_Resets not between", value1, value2, "grand_Resets");
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