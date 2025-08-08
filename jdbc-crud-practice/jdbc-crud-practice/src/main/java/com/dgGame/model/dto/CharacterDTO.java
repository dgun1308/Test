package com.dgGame.model.dto;

public class CharacterDTO {

    private String name;
    private int level;
    private int hp;
    private int apoint;
    private int dpoint;
    private int tapoint;
    private int tdpoint;
    private String jobid;

    public CharacterDTO() {}

    public CharacterDTO(String name, int level, int hp, int apoint, int dpoint, int tapoint, int tdpoint, String jobid) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.apoint = apoint;
        this.dpoint = dpoint;
        this.tapoint = tapoint;
        this.tdpoint = tdpoint;
        this.jobid = jobid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getTapoint() {
        return tapoint;
    }

    public void setTapoint(int tapoint) {
        this.tapoint = tapoint;
    }

    public int getTdpoint() {
        return tdpoint;
    }

    public void setTdpoint(int tdpoint) {
        this.tdpoint = tdpoint;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", apoint=" + apoint +
                ", dpoint=" + dpoint +
                ", tapoint=" + tapoint +
                ", tdpoint=" + tdpoint +
                ", jobid='" + jobid + '\'' +
                '}';
    }
}
