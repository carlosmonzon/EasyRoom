package com.belatrix.easyroom.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.belatrix.easyroom.interfaces.IFragmentListener;

public class BaseFragment extends Fragment {

    protected IFragmentListener mFragmentChangeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof  IFragmentListener) {
            mFragmentChangeListener = (IFragmentListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentChangeListener = null;
    }

}
