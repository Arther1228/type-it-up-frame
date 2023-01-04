package com.yang.pojo;

import java.io.Serializable;

public class StudentEntity implements Serializable {
    private String sno;
    private String sName;
    private String sSex;
    private int sAge;
    private String sDept;
    
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsDept() {
        return sDept;
    }

    public void setsDept(String sDept) {
        this.sDept = sDept;
    }
}
