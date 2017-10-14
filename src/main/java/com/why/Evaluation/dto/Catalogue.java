package com.why.Evaluation.dto;

public class Catalogue {
    private Integer catalogId;

    private String catalogName;

    private String catalogInfo;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getCatalogInfo() {
        return catalogInfo;
    }

    public void setCatalogInfo(String catalogInfo) {
        this.catalogInfo = catalogInfo == null ? null : catalogInfo.trim();
    }
}