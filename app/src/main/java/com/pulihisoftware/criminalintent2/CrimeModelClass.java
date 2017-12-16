package com.pulihisoftware.criminalintent2;

import java.util.Date;
import java.util.UUID;

/**
 * Created by thomascunningham1 on 12/12/17.
 */

public class CrimeModelClass
{
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public CrimeModelClass()

    {
        mId = UUID.randomUUID();
        mDate = new Date();
        mSolved = false;
    }

    /////////////////// getters \\\\\\\\\\\\\\\\\\\\\
    public UUID getId()
    {
        return mId;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public Date getDate()
    {
        return mDate;
    }

    public boolean isSolved()
    {
        return mSolved;
    }
    /////////////////// setters \\\\\\\\\\\\\\\\\\\\\
    public void setTitle(String title)
    {
        mTitle = title;
    }

    public void setDate(Date date)
    {
        mDate = date;
    }

    public void setSolved(boolean solved)
    {
        mSolved = solved;
    }
}
