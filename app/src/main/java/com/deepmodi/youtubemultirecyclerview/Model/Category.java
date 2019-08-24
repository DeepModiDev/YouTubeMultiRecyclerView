package com.deepmodi.youtubemultirecyclerview.Model;

public class Category {
    private String CategoryId;
    private String Title;

    public Category() {
    }

    public Category(String categoryId, String title) {
        CategoryId = categoryId;
        Title = title;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
