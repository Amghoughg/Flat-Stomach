package com.fitnessch19.flatstomachworkout.utils;

public class LaunchDataModel {
    public String app_name;
    public String app_pakage;
    public int categoryCount;
    public String icon_url;

    public String getApp_name() {
        return this.app_name;
    }

    public String getApp_pakage() {
        return this.app_pakage;
    }

    public int getCategoryCount() {
        return this.categoryCount;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setApp_name(String str) {
        this.app_name = str;
    }

    public void setApp_pakage(String str) {
        this.app_pakage = str;
    }

    public void setCategoryCount(int i) {
        this.categoryCount = i;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }
}
