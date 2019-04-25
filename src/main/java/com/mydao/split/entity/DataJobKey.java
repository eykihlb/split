package com.mydao.split.entity;

import java.io.Serializable;
import java.util.Date;

public class DataJobKey implements Serializable {
    private Date jobbegin;

    private String jobno;

    private String laneno;

    private String netno;

    private String staffno;

    private String siteno;

    public Date getJobbegin() {
        return jobbegin;
    }

    public void setJobbegin(Date jobbegin) {
        this.jobbegin = jobbegin;
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno == null ? null : jobno.trim();
    }

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

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno == null ? null : staffno.trim();
    }

    public String getSiteno() {
        return siteno;
    }

    public void setSiteno(String siteno) {
        this.siteno = siteno == null ? null : siteno.trim();
    }
}