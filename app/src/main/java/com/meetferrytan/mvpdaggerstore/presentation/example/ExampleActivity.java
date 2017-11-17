package com.meetferrytan.mvpdaggerstore.presentation.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpActivity;
import com.meetferrytan.mvpdaggerstore.presentation.example.fragment.ExampleFragment;
import com.meetferrytan.mvpdaggerstore.util.format.DateTimeFormatUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ExampleActivity extends BaseMvpActivity<ExamplePresenter, ExampleContract.View>
        implements ExampleContract.View, HasSupportFragmentInjector {
    public static final String TEXTVIEW_CONTENT = "textview";
    @BindView(R.id.textView)
    TextView mTextView;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public int setLayoutRes() {
        return R.layout.activity_example;
    }

    @Override
    public void processIntentExtras(Bundle extras) {

    }

    @Override
    public void startingUpActivity(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTVIEW_CONTENT)) {
                mTextView.setText(savedInstanceState.getString(TEXTVIEW_CONTENT));
            }
        }
        mTextView.setMovementMethod(new ScrollingMovementMethod());

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, ExampleFragment.newInstance()).commit();
    }

    @Override
    public void inject() {
        AndroidInjection.inject(this);
    }

    @Override
    public ExampleContract.View getViewImpl() {
        return this;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXTVIEW_CONTENT, mTextView.getText().toString());
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {
        // Switch process by static integers from ExamplePresenter
        switch (processCode) {
            case ExamplePresenter.PROCESS_GET_USER_DETAIL:
                mTextView.append(getCurrentDateTime() + " Loading User Detail Error..\n");
                break;
        }
    }

    @Override
    public void showLoading(int processCode, boolean show) {
        // Switch process by static integers from ExamplePresenter
        switch (processCode) {
            case ExamplePresenter.PROCESS_GET_USER_DETAIL:
                if (show) {
                    mTextView.append(getCurrentDateTime() + " Loading User Detail Start..\n");
                } else {
                    mTextView.append(getCurrentDateTime() + " Loading User Detail End..\n");
                }
                break;
        }
    }

    @OnClick(R.id.btnGetUserDetail)
    public void getUserDetail() {
        getPresenter().getUserDetail("ferrytan");
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
        mTextView.append(getCurrentDateTime() + " " + user.getId() + "-" + user.getName() + "\n");
    }
}
