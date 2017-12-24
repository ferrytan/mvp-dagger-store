package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpFragment;
import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate.UserUpdateFragment;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class UserDetailFragment extends BaseMvpFragment<UserDetailPresenter, UserDetailContract.View>
        implements UserDetailContract.View, HasSupportFragmentInjector {

    @BindView(R.id.imgAvatar) ImageView imgAvatar;
    @BindView(R.id.txvName) TextView txvName;
    @BindView(R.id.txvLocation) TextView txvLocation;
    @BindView(R.id.txvBlogUrl) TextView txvBlogUrl;
    @BindView(R.id.txvRepoCount) TextView txvRepoCount;

    @Inject DispatchingAndroidInjector<Fragment> childFragmentInjector;

    private UserUpdateFragment mUserUpdateFragment;

    public UserDetailFragment() {
        // Required empty public constructor
    }

    public static UserDetailFragment newInstance() {
        UserDetailFragment fragment = new UserDetailFragment();
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
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void processArguments(Bundle args) {

    }

    @Override
    public void startingUpFragment(View view, Bundle savedInstanceState) {
        mUserUpdateFragment = UserUpdateFragment.newInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout, mUserUpdateFragment).commit();
    }

    @Override
    public UserDetailContract.View getViewImpl() {
        return this;
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {
        // not called
    }

    @Override
    public void showLoading(int processCode, boolean show) {
        // not called
    }

    public void updateUserInfo(User user) {
        getPresenter().updateUserDetail(user);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }

    @Override
    public void displayUser(String avatar, String name, String username, String location, String blog, String repos) {
        Glide.with(this)
                .load(avatar)
                .into(imgAvatar);

        txvName.setText(name);
        txvLocation.setText(location);
        txvBlogUrl.setText(blog);
        txvRepoCount.setText(repos);

        mUserUpdateFragment.fetchUserUpdate(username);
    }
}
