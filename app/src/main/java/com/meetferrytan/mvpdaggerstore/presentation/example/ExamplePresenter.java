package com.meetferrytan.mvpdaggerstore.presentation.example;

import com.google.gson.Gson;
import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.presentation.base.BasePresenter;
import com.meetferrytan.mvpdaggerstore.util.cache.StoreBarcode;
import com.meetferrytan.mvpdaggerstore.util.schedulers.RunOn;
import com.nytimes.android.external.store3.base.impl.Store;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import retrofit2.Retrofit;
import timber.log.Timber;

import static com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.IO;
import static com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.UI;

/**
 * Created by ferrytan on 10/22/17.
 */

public class ExamplePresenter extends BasePresenter<ExampleContract.View>
        implements ExampleContract.Presenter {

    public static final int PROCESS_GET_USER_DETAIL = 101;
    @Inject
    Store<User, StoreBarcode> mUserDetailStore;
    @Inject
    @RunOn(UI)
    Scheduler mUiScheduler;
    @Inject
    @RunOn(IO)
    Scheduler mIoScheduler;
    @Inject
    Retrofit mRetrofit;
    @Inject
    Gson mGson;

    @Inject
    public ExamplePresenter() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.d("onCreate: state");
        // presenter state still not restored
    }

    @Override
    public void onStart() {
        super.onStart();
        Timber.d("onStart: state");
        // presenter state still not restored
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.d("onResume: state");
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.d("onPause: state");
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.d("onStop: state");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy: state");
        // all disposable processes are cleared here
    }

    @Override
    public void getUserDetail(String username) {
        StoreBarcode barCode = new StoreBarcode("", "getUserDetail", username);
        processSingleRequest(
                mUserDetailStore.get(barCode)
                        .observeOn(mUiScheduler) // observe on UI thread
                        .subscribeOn(mIoScheduler), // network request, observe on IO scheduler
                PROCESS_GET_USER_DETAIL,
                result -> getView().showUserDetail(result));
    }
}
