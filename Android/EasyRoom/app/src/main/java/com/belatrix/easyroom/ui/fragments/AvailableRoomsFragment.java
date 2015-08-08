package com.belatrix.easyroom.ui.fragments;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.adapter.AvailableRoomsPagerAdapter;
import com.belatrix.easyroom.entities.Room;
import com.belatrix.easyroom.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AvailableRoomsFragment extends BaseFragment {

    private List<Room> mAvailableRooms;
    private ViewPager mViewPager;
    private AvailableRoomsPagerAdapter mAdapter;


    public static AvailableRoomsFragment newInstance() {
        AvailableRoomsFragment fragment = new AvailableRoomsFragment();
        return fragment;
    }

    public AvailableRoomsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_available_rooms, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.vp_rooms);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new AvailableRoomsPagerAdapter(getChildFragmentManager(), getAvailableRooms());
        mViewPager.setAdapter(mAdapter);
    }

    private List<AvailableRoomItemFragment> getAvailableRooms() {
        List<AvailableRoomItemFragment> rooms = new ArrayList<>();
        rooms.add(AvailableRoomItemFragment.newInstance(new Room("Nazca")));
        rooms.add(AvailableRoomItemFragment.newInstance(new Room("Lima")));
        rooms.add(AvailableRoomItemFragment.newInstance(new Room("Paracas")));
        rooms.add(AvailableRoomItemFragment.newInstance(new Room("Macchu Picchu")));
        return rooms;
    }
}
