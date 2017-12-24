package com.meetferrytan.mvpdaggerstore.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by ferrytan on 24/12/17.
 */

public class GithubRepository {
    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("created_at")
    private Date mCreatedAt;
    @SerializedName("updated_at")
    private Date mUpdatedAt;
    @SerializedName("pushed_at")
    private Date mPushedAt;
    @SerializedName("html_url")
    private String mHtmlUrl;

    public GithubRepository() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public Date getPushedAt() {
        return mPushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        mPushedAt = pushedAt;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }
}
