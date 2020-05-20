package com.batyan.zefgame.modules.article;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.modules.common.SingleFragmentActivity;

public final class ArticleActivity extends SingleFragmentActivity {

    ArticleModel article;
    int fragmentId = R.id.fragment_container_article;

    @Override
    protected Fragment createFragment() {
        return new ArticleFragment(article);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            this.article = (ArticleModel) arguments.get("article");
        }
        getFragment(fragmentId);
        setContentView(R.layout.activity_article);
    }
}