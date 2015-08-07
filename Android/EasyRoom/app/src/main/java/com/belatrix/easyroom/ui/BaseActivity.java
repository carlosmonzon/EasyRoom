package com.belatrix.easyroom.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.interfaces.IFragmentListener;

public class BaseActivity extends AppCompatActivity implements IFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void replaceFragmentTransaction(int containerId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        String tag = fragment.getClass().getSimpleName();
        transaction.replace(containerId, fragment, tag);
        if(addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void replaceFragment(int containerId, Fragment fragment, boolean addToBackStack) {
        replaceFragmentTransaction(containerId == 0 ? R.id.container : containerId, fragment, addToBackStack);
    }

    @Override
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        replaceFragment(0, fragment, addToBackStack);
    }

}
