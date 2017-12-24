package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail;


import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseContract;

/**
 * Created by ferrytan on 11/8/17.
 */

public class UserDetailContract {

    interface View extends BaseContract.View {
        void displayUser(String avatar, String name, String username, String location, String blog, String repos);
    }

    interface Presenter extends BaseContract.Presenter<UserDetailContract.View> {
        void updateUserDetail(User user);
    }
}
