package com.belatrix.easyroom.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.DailyRoom;

import java.util.ArrayList;

public class DayListFragment extends Fragment {

    private final static int START_LIMIT = 8;

    private final static int END_LIMIT = 17;

    private ArrayList<DailyRoom> mDailyRooms;

    RecyclerView mRecyclerView;

    DayListAdapter mAdapter;


    public static DayListFragment newInstance(String param1, String param2) {
        DayListFragment fragment = new DayListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DayListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    private void fillArray() {
        mDailyRooms = new ArrayList<>();

        for (int i = START_LIMIT; i <= END_LIMIT; i++) {

            DailyRoom dailyRoom = new DailyRoom();
            dailyRoom.isFree = true;
            dailyRoom.start = buildHour(i);
            dailyRoom.end = buildHour(i + 1);
            mDailyRooms.add(dailyRoom);
        }

        if (mRecyclerView != null) {
            mAdapter = new DayListAdapter(mDailyRooms);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private String buildHour(int hour) {
        String value = Integer.toString(hour) + ":00";
        return value;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_day_list, container, false);
        if (fragmentView != null) {

            Toolbar mToolbar = (Toolbar) fragmentView.findViewById(R.id.toolbar);
            mToolbar.setTitle("Room Name");
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView = (RecyclerView) fragmentView
                    .findViewById(R.id.recycler);

            // allows for optimizations
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            fillArray();
        }
        return fragmentView;
    }
}
