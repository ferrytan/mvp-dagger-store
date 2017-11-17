package com.meetferrytan.mvpdaggerstore.presentation.example;


import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseContract;

/**
 * Created by ferrytan on 10/22/17.
 */

public interface ExampleContract {

    interface View extends BaseContract.View {
        void showUserDetail(User user);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getUserDetail(String username);
    }
}
