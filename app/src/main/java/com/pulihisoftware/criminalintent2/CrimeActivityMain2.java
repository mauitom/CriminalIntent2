package com.pulihisoftware.criminalintent2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*this activity class is capable of hosting a fragment*/
/*this activity will add the activity via CODE */

/*this is the newer version they show on page 164. It becomes a subclass of SingleFragmentActivity*/
/*the reason is to use SingleFragmentActivity as a reusable class for generating fragments.*/
/*I changed the usage to this "2" class in the Android Manifest so it uses it - it works*/

public class CrimeActivityMain2 extends SingleFragmentActivity
{

    @Override
    protected Fragment createFragment()
    {
        return new CrimeFragment();
    }
}
