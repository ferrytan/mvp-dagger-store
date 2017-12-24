package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate;

import com.meetferrytan.mvpdaggerstore.presentation.base.BaseContract;

/**
 * Created by ferrytan on 11/8/17.
 */

public class UserUpdateContract {

    interface View extends BaseContract.View {
        void showUserUpdate(String updateText);
    }

    interface Presenter extends BaseContract.Presenter<UserUpdateContract.View> {
        void getUserUpdate(String username);
    }
}
