package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate;


import com.meetferrytan.mvpdaggerstore.data.entity.RepositorySearchResponse;
import com.meetferrytan.mvpdaggerstore.presentation.base.BasePresenter;
import com.meetferrytan.mvpdaggerstore.util.cache.StoreBarcode;
import com.meetferrytan.mvpdaggerstore.util.format.DateTimeFormatUtil;
import com.meetferrytan.mvpdaggerstore.util.schedulers.RunOn;
import com.nytimes.android.external.store3.base.impl.Store;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import timber.log.Timber;

import static com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.COMPUTATION;
import static com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.IO;
import static com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.UI;

/**
 * Created by ferrytan on 11/8/17.
 */

public class UserUpdatePresenter extends BasePresenter<UserUpdateContract.View>
        implements UserUpdateContract.Presenter {

    public static final int PROCESS_GET_USER_UPDATE = 0;
    public static final String PARAM_QUERY = "q";
    public static final String PARAM_SORT = "sort";
    @Inject Store<RepositorySearchResponse, StoreBarcode> repositorySearchStore;
    @Inject @RunOn(UI) Scheduler mUiScheduler;
    @Inject @RunOn(IO) Scheduler mIoScheduler;
    @Inject @RunOn(COMPUTATION) Scheduler mComputationScheduler;

    @Inject
    public UserUpdatePresenter() {
    }

    @Override
    public void getUserUpdate(String username) {
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_QUERY, "user:" + username + "+pushed:>" + getLastWeekDateGithubFormatted());
        params.put(PARAM_SORT, "updated");
        StoreBarcode barCode = new StoreBarcode(params, "getUserUpdate");
        processSingleRequest(
                repositorySearchStore.get(barCode)
                        .subscribeOn(mIoScheduler) // network request, observe on IO scheduler
                        .observeOn(mComputationScheduler) // observe on computation scheduler
                        .map(RepositorySearchResponse::getItems)
                        .observeOn(mUiScheduler),
                PROCESS_GET_USER_UPDATE,
                result -> {
                    if (result.size() > 0) {
                        Flowable.fromIterable(result)
                                .subscribeOn(mComputationScheduler)
                                .take(1)
                                .observeOn(mUiScheduler)
                                .subscribe(lastUpdate -> {
                                    String updateText = "Last pushed \""
                                            + lastUpdate.getName()
                                            + "\" repository at "
                                            + DateTimeFormatUtil.millisToReadableDate(lastUpdate.getPushedAt().getTime(), DateTimeFormatUtil.BOUND_SECONDS);
                                    getView().showUserUpdate(updateText);
                                });
                    } else {
                        getView().showUserUpdate("No updates in the past week");
                    }
                });
    }

    private String getLastWeekDateGithubFormatted() {
        Calendar lastWeek = Calendar.getInstance();
        lastWeek.add(Calendar.DAY_OF_WEEK, -7);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        String lastWeekFormattedDate = simpleDateFormat.format(lastWeek.getTime());
        Timber.d(lastWeekFormattedDate);
        return lastWeekFormattedDate;
    }
}
