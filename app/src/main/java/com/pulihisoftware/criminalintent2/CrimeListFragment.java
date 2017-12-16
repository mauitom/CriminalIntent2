package com.pulihisoftware.criminalintent2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by thomas cunningham on 12/14/17.
 */

public class CrimeListFragment extends Fragment
{
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mCrimeAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceType)
    {
        View view = inflater.inflate(R.layout.fragment_crime_list_recycler_view,
                container,
                false);
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI()
    {
        CrimeLabSingleton crimeLab = CrimeLabSingleton.get(getActivity());
        List<CrimeModelClass> crimes = crimeLab.getCrimes();

        mCrimeAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mCrimeAdapter);
    }



    // an inner class defines a class needed in this file.
    // a ViewHolder holds on to a View. In this case an itemView.
    // this RecyclerView needs this (along with an Adapter).
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;
        private CrimeModelClass mCrime;

        private CrimeHolder(LayoutInflater inflater,
                           ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_crime,
                    parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mSolvedImageView = itemView.findViewById(R.id.crime_solved);
        }

        public void bind(CrimeModelClass crime)
        {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view)
        {
            Toast.makeText(getActivity(),
                    mCrime.getTitle() + " clicked.", Toast.LENGTH_SHORT).show();
        }
    }

    // an inner class defines a class needed in this file.
    // this class knows about the Crime object, RecyclerView does not.
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>
    {
        private List<CrimeModelClass> mCrimes;

        private CrimeAdapter(List<CrimeModelClass> crimes)
        {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            // called by RecyclerView when it needs a new ViewHolder to dispay an item with.
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position)
        {
            CrimeModelClass crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount()
        {
            return mCrimes.size();
        }
    }

}
