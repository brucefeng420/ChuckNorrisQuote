package com.example.chucknorrissays;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote implements Serializable {

    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * No args constructor for use in serialization
     *
     */

    //quote class generated through postwoman and JSON to java converter
    public Quote() {
    }

    /**
     *
     * @param createdAt
     * @param categories
     * @param iconUrl
     * @param id
     * @param value
     * @param url
     * @param updatedAt
     */
    public Quote(List<Object> categories, String createdAt, String iconUrl, String id, String updatedAt, String url, String value) {
        super();
        this.categories = categories;
        this.createdAt = createdAt;
        this.iconUrl = iconUrl;
        this.id = id;
        this.updatedAt = updatedAt;
        this.url = url;
        this.value = value;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Quote withCategories(List<Object> categories) {
        this.categories = categories;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Quote withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Quote withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Quote withId(String id) {
        this.id = id;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Quote withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Quote withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Quote withValue(String value) {
        this.value = value;
        return this;
    }

}
