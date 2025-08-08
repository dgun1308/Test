package com.dgGame.model.dto;

public class EquipmentSlotDTO {

    private String id;
    private String name;

    public EquipmentSlotDTO () {}

    public EquipmentSlotDTO(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "EquipmentSlotDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
