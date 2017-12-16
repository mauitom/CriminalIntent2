package com.pulihisoftware.criminalintent2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by thomascunningham1 on 12/14/17.
 */

public class CrimeLabSingleton
{
    /*allows app to have one owner of the crime data*/

    private static CrimeLabSingleton sCrimeLab; // s means Static variable
    private List<CrimeModelClass> mCrimes;      // a list of crimes

    public static CrimeLabSingleton get(Context context)
    {
        if (sCrimeLab == null)
        {
            sCrimeLab = new CrimeLabSingleton(context);
        }
        return sCrimeLab;
    }

    private CrimeLabSingleton(Context context)
    {
        mCrimes = new ArrayList<>();

        // put dummy data into the list
        for (int i =0; i < 100; i++)
        {
            CrimeModelClass crime = new CrimeModelClass();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // every other one is true
            mCrimes.add(crime);          // add this crime to the list
        }
    }

    public List<CrimeModelClass> getCrimes()  // get all of the crime list
    {
        return mCrimes;
    }

    public CrimeModelClass getCrime(UUID id)   // get a crime by id.
    {
        for (CrimeModelClass crime : mCrimes)
        {
            if (crime.getId().equals(id))
                return crime;
        }
        return null;
    }
}
