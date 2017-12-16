package com.pulihisoftware.criminalintent2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/*this activity class is capable of hosting a fragment*/
/*this activity will add the activity via CODE */

public class CrimeActivityMain extends AppCompatActivity
{

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

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = new CrimeFragment();
            // a fragment transaction is used to add, remove, attach, detach and replace fragments.
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Crime Activity", "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Crime Activity", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Crime Activity", "onDestroy");
    }
}
