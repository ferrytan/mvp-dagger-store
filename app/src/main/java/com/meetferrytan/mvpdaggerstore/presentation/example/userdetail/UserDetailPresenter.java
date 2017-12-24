package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail;

import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BasePresenter;

import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by ferrytan on 11/8/17.
 */

public class UserDetailPresenter extends BasePresenter<UserDetailContract.View>
        implements UserDetailContract.Presenter {

    @Inject
    public UserDetailPresenter() {

    }

    @Override
    public void updateUserDetail(User user) {
        String avatar = user.getAvatar();
        String name = user.getName();
        String blog = user.getBlog();
        String location = user.getLocation();
        String username = user.getLogin();
        String reposcount = String.format(Locale.getDefault(), "%d public repositories", user.getPublicRepos());

        getView().displayUser(avatar, name, username, blog, location, reposcount);
    }
}
