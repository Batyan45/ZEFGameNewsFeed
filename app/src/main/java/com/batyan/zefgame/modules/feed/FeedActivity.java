package com.batyan.zefgame.modules.feed;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.batyan.zefgame.R;
import com.batyan.zefgame.modules.common.SingleFragmentActivity;

public final class FeedActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FeedFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeFragment(R.id.fragment_container);
        setContentView(R.layout.activity_list);
        FeedModuleContract.downloadArticles();
    }
}
