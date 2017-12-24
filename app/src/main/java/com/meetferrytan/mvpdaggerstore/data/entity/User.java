package com.meetferrytan.mvpdaggerstore.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ferrytan on 11/17/17.
 */

public class User {
    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("avatar_url")
    private String mAvatar;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("blog")
    private String mBlog;
    @SerializedName("public_repos")
    private int mPublicRepos;

    public User() {
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
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

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getBlog() {
        return mBlog;
    }

    public void setBlog(String blog) {
        mBlog = blog;
    }

    public int getPublicRepos() {
        return mPublicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        mPublicRepos = publicRepos;
    }
}