package com.pulihisoftware.criminalintent2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by thomascunningham1 on 12/14/17.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity
{
    // subclasses will implement this create fragment method. this allows this
    // generic abstract class to let the concrete class to return the instance
    // of the fragment they want to have laid out.
    protected abstract android.support.v4.app.Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // need a fragment manager. It is the class that Activity uses to manage fragments.
        // Your activity must derive from FragmentActivity to use this.
        FragmentManager fm = getSupportFragmentManager();

        // give the manager a fragment to work with.
        // fragment_container is defined in the id of activity_fragment
        // uses the id of a Frame Layout.

        android.support.v4.app.Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment();
            // a fragment transaction is used to add, remove, attach, detach and replace fragments.
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
