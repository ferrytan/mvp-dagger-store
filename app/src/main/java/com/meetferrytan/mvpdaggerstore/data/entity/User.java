package com.meetferrytan.mvpdaggerstore.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ferrytan on 11/17/17.
 */

public class User {
    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;

    public User() {
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}