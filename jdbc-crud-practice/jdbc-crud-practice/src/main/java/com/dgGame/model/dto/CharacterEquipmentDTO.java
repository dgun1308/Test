package com.dgGame.model.dto;

public class CharacterEquipmentDTO {

    private String cName;
    private String eId;
    private String iId;

    public CharacterEquipmentDTO () {}

    public CharacterEquipmentDTO(String cName, String eId, String iId) {
        this.cName = cName;
        this.eId = eId;
        this.iId = iId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Override
    public String toString() {
        return "CharacterEquipmentDTO{" +
                "cName='" + cName + '\'' +
                ", eId='" + eId + '\'' +
                ", iId='" + iId + '\'' +
                '}';
    }
}
