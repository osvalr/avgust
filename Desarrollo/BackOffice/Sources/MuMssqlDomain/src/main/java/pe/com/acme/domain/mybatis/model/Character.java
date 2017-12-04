package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class Character extends CharacterKey implements Serializable {
	
    private String accountID;

    private Integer cLevel;

    private Integer levelUpPoint;

    private Integer strength;

    private Integer dexterity;

    private Integer vitality;

    private Integer energy;

    private Integer money;

    private Integer leadership;

    private Integer pklevel;
    
    private Integer pkcount;

    private Integer resets;

    private static final long serialVersionUID = 1L;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    public Integer getLevelUpPoint() {
        return levelUpPoint;
    }

    public void setLevelUpPoint(Integer levelUpPoint) {
        this.levelUpPoint = levelUpPoint;
    }

 

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getVitality() {
        return vitality;
    }

    public void setVitality(Integer vitality) {
        this.vitality = vitality;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }



 

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getResets() {
        return resets;
    }

    public void setResets(Integer resets) {
        this.resets = resets;
    }

 

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountID=").append(accountID);
        sb.append(", cLevel=").append(cLevel);
        sb.append(", levelUpPoint=").append(levelUpPoint);
        sb.append(", strength=").append(strength);
        sb.append(", dexterity=").append(dexterity);
        sb.append(", vitality=").append(vitality);
        sb.append(", energy=").append(energy);
        sb.append(", money=").append(money);
        sb.append(", leadership=").append(leadership);
        sb.append(", resets=").append(resets);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Integer getPklevel() {
		return pklevel;
	}

	public void setPklevel(Integer pklevel) {
		this.pklevel = pklevel;
	}

	public Integer getPkcount() {
		return pkcount;
	}

	public void setPkcount(Integer pkcount) {
		this.pkcount = pkcount;
	}
}