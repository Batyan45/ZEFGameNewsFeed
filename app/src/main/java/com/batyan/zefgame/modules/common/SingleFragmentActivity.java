package com.batyan.zefgame.modules.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    private Fragment fragment;

    protected abstract Fragment createFragment();

    protected void initializeFragment(int fragmentId) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(fragmentId);

        if (null == fragment) {
            fragment = createFragment();
            fragmentManager
                    .beginTransaction()
                    .add(fragmentId, fragment)
                    .commit();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}