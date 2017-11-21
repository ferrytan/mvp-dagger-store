package com.meetferrytan.mvpdaggerstore.presentation.base;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by ferrytan on 9/20/17.
 */

public abstract class BaseActionBarActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return true;
    }

    @NonNull
    @Override
    public ActionBar getSupportActionBar() {
        assert super.getSupportActionBar() != null;
        return super.getSupportActionBar();
    }
}