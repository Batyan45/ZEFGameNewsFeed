package com.batyan.zefgame.modules.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.batyan.zefgame.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected Fragment fragment;

    protected abstract Fragment createFragment();

    protected void getFragment(int fragmentId) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(fragmentId);

        if (null == fragment) {
            fragment = createFragment();
            fragmentManager
                    .beginTransaction()
                    .add(fragmentId, fragment)
                    .commit();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}