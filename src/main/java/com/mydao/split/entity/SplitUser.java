package com.mydao.split.entity;

import java.io.Serializable;

public class SplitUser implements Serializable{
    private String id;

    private String userName;

    private String passWord;

    private String userType;

    private String netSiteNo;

    private String nickName;

    private String siteIp;

    private Integer page;

    private Integer limit;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSiteIp() {
        return siteIp;
    }

    public void setSiteIp(String siteIp) {
        this.siteIp = siteIp;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getNetSiteNo() {
        return netSiteNo;
    }

    public void setNetSiteNo(String netSiteNo) {
        this.netSiteNo = netSiteNo == null ? null : netSiteNo.trim();
    }
}