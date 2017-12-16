package com.pulihisoftware.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by thomas cunningham on 12/14/17.
 */

public class CrimeListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new CrimeListFragment();
    }
}
