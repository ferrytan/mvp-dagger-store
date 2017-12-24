package com.meetferrytan.mvpdaggerstore.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ferrytan on 24/12/17.
 */

public class RepositorySearchResponse {
    @SerializedName("total_count")
    private int mTotalCount;
    @SerializedName("incomplete_results")
    private boolean mIncompleteResults;
    @SerializedName("items")
    private List<GithubRepository> mItems;

    public RepositorySearchResponse() {
    }

    public int getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        mTotalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        mIncompleteResults = incompleteResults;
    }

    public List<GithubRepository> getItems() {
        return mItems;
    }

    public void setItems(List<GithubRepository> items) {
        mItems = items;
    }
}
