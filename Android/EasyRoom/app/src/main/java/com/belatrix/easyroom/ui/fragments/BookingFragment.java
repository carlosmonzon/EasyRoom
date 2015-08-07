package com.belatrix.easyroom.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.easyroom.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BookingFragment extends Fragment {

    public BookingFragment newInstance() {
        BookingFragment bookingFragment = new BookingFragment();
        Bundle bundle = new Bundle();
//        bundle.put
        bookingFragment.setArguments(bundle);
        return bookingFragment;
    }

    public BookingFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reservation, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
