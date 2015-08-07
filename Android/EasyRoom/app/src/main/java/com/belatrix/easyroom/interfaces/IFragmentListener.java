package com.belatrix.easyroom.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by pcarrillo on 22/07/2015.
 */
public interface IFragmentListener {

    void replaceFragment(int containerId, Fragment fragment, boolean addToBackStack);
    void replaceFragment(Fragment fragment, boolean addToBackStack);

}
