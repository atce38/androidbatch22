package com.atce.androidb21.model;

public class ApplicationModel {
    private String appName;
    private String appIcon;

    // Constructor, getters, and setters
    public ApplicationModel(String appName, String appIcon) {
        this.appName = appName;
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppIcon() {
        return appIcon;
    }
}
