package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpFragment;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;

public class UserUpdateFragment extends BaseMvpFragment<UserUpdatePresenter, UserUpdateContract.View>
        implements UserUpdateContract.View {

    @BindView(R.id.txvUpdate) TextView txvUpdate;

    public UserUpdateFragment() {
        // Required empty public constructor
    }

    public static UserUpdateFragment newInstance() {
        UserUpdateFragment fragment = new UserUpdateFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void inject() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    protected View createLayout(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child_fragment_example, container, false);
    }

    @Override
    public void processArguments(Bundle args) {

    }

    @Override
    public void startingUpFragment(View view, Bundle savedInstanceState) {

    }

    @Override
    public UserUpdateContract.View getViewImpl() {
        return this;
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {
        txvUpdate.setText("Error fetching user update: " + message);
    }

    @Override
    public void showLoading(int processCode, boolean show) {
        if (show)
            txvUpdate.setText("fetching user update...");
    }

    public void fetchUserUpdate(String username) {
        getPresenter().getUserUpdate(username);
    }

    @Override
    public void showUserUpdate(String updateText) {
        txvUpdate.setText(updateText);
    }
}
