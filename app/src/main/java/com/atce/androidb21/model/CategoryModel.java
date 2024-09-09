package com.atce.androidb21.model;

import java.util.List;

public class CategoryModel {
    private String categoryName;
    private List<ApplicationModel> applicationList;

    // Constructor, getters, and setters
    public CategoryModel(String categoryName, List<ApplicationModel> applicationList) {
        this.categoryName = categoryName;
        this.applicationList = applicationList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<ApplicationModel> getApplicationList() {
        return applicationList;
    }
}
