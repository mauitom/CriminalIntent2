package com.pulihisoftware.criminalintent2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by thomas cunningham on 12/12/17.
 *
 * this is the java class that backs up the fragment_crime.xml file
 * this is a CONTROLLER class interacts with model and view classes
 */

public class CrimeFragment extends Fragment
{
    private CrimeModelClass mCrime;  // this controller needs a reference to our crime model class.
    private EditText mTitleField; // we need an instance of this from the xml file. Grab it in the OnCreateView() method.
    private Button mDateButton; // need an instance of our button. grab in OnCreateView().
    private CheckBox mSolvedCheckBox; // need an instance of our checkbox. grab in OnCreateView().

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        // this is a PUBLIC method because it will be called by this fragments Activity class.
        // notice you do not INFLATE it here - done in another onCreateView method.
        super.onCreate(savedInstanceState);
        mCrime = new CrimeModelClass();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // here it refers to its associated xml file, fragment_crime.
        // the false means you add the view from the activities code.
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        // title field instance
        mTitleField = v.findViewById(R.id.crime_title); // view gets the layout xml file, its root view.
                                                    // crime_title is the id we defined in the xml file.
        mTitleField.addTextChangedListener(new TextWatcher()  // when you add this listener or event callback
                // it automatically adds the override methods it needs to accomplish this - spiffy.
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                Log.d("Crime Fragment", "beforeTextChanged");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                Log.d("Crime Fragment", "onTextChanged");
                mCrime.setTitle(s.toString()); // callback on this event.
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Log.d("Crime Fragment", "afterTextChanged");
            }
        });

        // date button instance
        mDateButton = v.findViewById(R.id.crime_date); // crime_date is the id we defined in the xml file.
        mDateButton.setText(mCrime.getDate().toString());  // our model property stores this date info.
        mDateButton.setEnabled(false);                   // don't want the user to be able to press button.

        // checkbox instance
        mSolvedCheckBox = v.findViewById(R.id.crime_solved); // crime_solved is the id we defined in xml file.
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;

    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }
}
