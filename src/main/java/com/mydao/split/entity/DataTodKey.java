package com.mydao.split.entity;

import java.io.Serializable;
import java.util.Date;

public class DataTodKey implements Serializable{
    private String laneno;

    private String netno;

    private String siteno;

    private String slipno;

    private String staffno;

    private Date toddate;

    public String getLaneno() {
        return laneno;
    }

    public void setLaneno(String laneno) {
        this.laneno = laneno == null ? null : laneno.trim();
    }

    public String getNetno() {
        return netno;
    }

    public void setNetno(String netno) {
        this.netno = netno == null ? null : netno.trim();
    }

    public String getSiteno() {
        return siteno;
    }

    public void setSiteno(String siteno) {
        this.siteno = siteno == null ? null : siteno.trim();
    }

    public String getSlipno() {
        return slipno;
    }

    public void setSlipno(String slipno) {
        this.slipno = slipno == null ? null : slipno.trim();
    }

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno == null ? null : staffno.trim();
    }

    public Date getToddate() {
        return toddate;
    }

    public void setToddate(Date toddate) {
        this.toddate = toddate;
    }
}