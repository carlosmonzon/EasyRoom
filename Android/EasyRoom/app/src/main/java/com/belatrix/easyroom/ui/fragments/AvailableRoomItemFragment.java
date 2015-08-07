package com.belatrix.easyroom.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.Room;
import com.belatrix.easyroom.ui.BaseFragment;

public class AvailableRoomItemFragment extends BaseFragment {

    private static final String ROOM_KEY = "_room_name";
    
    private Room mRoom;


    public static AvailableRoomItemFragment newInstance(Room availableRoom) {
        AvailableRoomItemFragment fragment = new AvailableRoomItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ROOM_KEY, availableRoom);
        fragment.setArguments(bundle);
        return fragment;
    }

    public AvailableRoomItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRoom = getArguments().getParcelable(ROOM_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_available_room_item, container, false);
    }


}
