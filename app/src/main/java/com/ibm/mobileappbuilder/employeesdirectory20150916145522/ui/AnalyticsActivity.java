

package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * AnalyticsActivity list activity
 */
public class AnalyticsActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.analyticsActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return AnalyticsFragment.class;
    }

}

