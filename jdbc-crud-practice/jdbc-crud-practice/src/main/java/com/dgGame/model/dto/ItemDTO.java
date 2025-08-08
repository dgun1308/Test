package com.dgGame.model.dto;

public class ItemDTO {

    private String id;
    private String name;
    private int apoint;
    private int dpoint;
    private int level;
    private String equipmentId;

    public ItemDTO () {}

    public ItemDTO(String id, String name, int apoint, int dpoint, int level, String equipmentId) {
        this.id = id;
        this.name = name;
        this.apoint = apoint;
        this.dpoint = dpoint;
        this.level = level;
        this.equipmentId = equipmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApoint() {
        return apoint;
    }

    public void setApoint(int apoint) {
        this.apoint = apoint;
    }

    public int getDpoint() {
        return dpoint;
    }

    public void setDpoint(int dpoint) {
        this.dpoint = dpoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", apoint=" + apoint +
                ", dpoint=" + dpoint +
                ", level=" + level +
                ", equipmentId='" + equipmentId + '\'' +
                '}';
    }
}
