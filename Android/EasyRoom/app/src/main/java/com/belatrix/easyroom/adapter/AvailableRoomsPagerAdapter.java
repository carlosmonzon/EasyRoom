package com.belatrix.easyroom.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.belatrix.easyroom.ui.fragments.AvailableRoomItemFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyosida on 07/08/2015.
 */
public class AvailableRoomsPagerAdapter extends FragmentPagerAdapter {

    private List<AvailableRoomItemFragment> mRoomList = new ArrayList<>();

    public AvailableRoomsPagerAdapter(FragmentManager fm, List<AvailableRoomItemFragment> rooms) {
        super(fm);
        if (rooms != null) {
            mRoomList.addAll(rooms);
        }
    }

    @Override
    public int getCount() {
        return mRoomList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mRoomList.get(position);
    }

}
