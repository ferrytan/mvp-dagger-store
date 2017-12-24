package com.meetferrytan.mvpdaggerstore.presentation.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpActivity;
import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.UserDetailFragment;
import com.meetferrytan.mvpdaggerstore.util.format.DateTimeFormatUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class GithubUserSearchActivity extends BaseMvpActivity<GithubUserSearchPresenter, GithubUserSearchContract.View>
        implements GithubUserSearchContract.View, HasSupportFragmentInjector {
    public static final String CONTENT_LOG = "log";
    @BindView(R.id.txvLog) TextView txvLog;
    @BindView(R.id.edtUsername) EditText edtUsername;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;
    private UserDetailFragment mUserDetailFragment;
    private String mLastQuery;

    @Override
    public int setLayoutRes() {
        return R.layout.activity_example;
    }

    @Override
    public void processIntentExtras(Bundle extras) {

    }

    @Override
    public void startingUpActivity(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(CONTENT_LOG)) {
                txvLog.setText(savedInstanceState.getString(CONTENT_LOG));
            }
        }
        txvLog.setMovementMethod(new ScrollingMovementMethod());
        mUserDetailFragment = UserDetailFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mUserDetailFragment).commit();
    }

    @Override
    public void inject() {
        AndroidInjection.inject(this);
    }

    @Override
    public GithubUserSearchContract.View getViewImpl() {
        return this;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CONTENT_LOG, txvLog.getText().toString());
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {
        // Switch process by static integers from GithubUserSearchPresenter
        switch (processCode) {
            case GithubUserSearchPresenter.PROCESS_GET_USER_DETAIL:
                appendLog(getCurrentDateTime() + " Error: " + message + "\n");
                break;
        }
    }

    @Override
    public void showLoading(int processCode, boolean show) {
        // Switch process by static integers from GithubUserSearchPresenter
        switch (processCode) {
            case GithubUserSearchPresenter.PROCESS_GET_USER_DETAIL:
                if (show) {
                    appendLog(getCurrentDateTime() + " Loading Github User \"" + mLastQuery + "\"\n");
                } else {
                    appendLog(getCurrentDateTime() + " Done fetching user data\n");
                }
                break;
        }
    }

    @OnClick(R.id.btnGetUserDetail)
    public void getUserDetail() {
        mLastQuery = edtUsername.getText().toString();
        if (!"".equals(mLastQuery)) {
            getPresenter().getUserDetail(mLastQuery);
        }
    }

    private String getCurrentDateTime() {
        return DateTimeFormatUtil.millisToDateFormat(System.currentTimeMillis(), "dd-MM HH:mm:ss.SSS");
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public void showUserDetail(User user) {
        appendLog(getCurrentDateTime() + " User fetched: " + user.getId() + "-" + user.getName() + "\n");
        mUserDetailFragment.updateUserInfo(user);
    }

    private void appendLog(String text) {
        txvLog.append(text);
        int textBottom = txvLog.getLineHeight() * (txvLog.getLineCount());
        int textViewHeight = txvLog.getHeight();
        if (textBottom > textViewHeight) {
            txvLog.scrollTo(0, textBottom - textViewHeight);
        }
    }
}
