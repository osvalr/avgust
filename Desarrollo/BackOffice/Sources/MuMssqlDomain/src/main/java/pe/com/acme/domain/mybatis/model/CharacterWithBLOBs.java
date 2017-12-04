package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;

public class CharacterWithBLOBs extends Character implements Serializable {
    private byte[] inventory;

    private byte[] magicList;

    private byte[] quest;

    private static final long serialVersionUID = 1L;

    public byte[] getInventory() {
        return inventory;
    }

    public void setInventory(byte[] inventory) {
        this.inventory = inventory;
    }

    public byte[] getMagicList() {
        return magicList;
    }

    public void setMagicList(byte[] magicList) {
        this.magicList = magicList;
    }

    public byte[] getQuest() {
        return quest;
    }

    public void setQuest(byte[] quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inventory=").append(inventory);
        sb.append(", magicList=").append(magicList);
        sb.append(", quest=").append(quest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}