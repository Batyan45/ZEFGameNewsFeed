package com.batyan.zefgame.modules.article;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class ArticleFragment extends Fragment {

    private TextView dateTextView;
    private TextView textTextView;
    private TextView titleTextView;
    private FloatingActionButton linkButton;
    private ImageButton shareButton;
    ArticleModel article;

    ArticleFragment(ArticleModel article) {
        super();
        this.article = article;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_article, container, false);

        dateTextView = view.findViewById(R.id.date_article);
        dateTextView.setText(article.getPubDate());

        textTextView = view.findViewById(R.id.text_article);
        textTextView.setText(article.getText());

        titleTextView = view.findViewById(R.id.title_article);
        titleTextView.setText(article.getTitle());

        linkButton = view.findViewById(R.id.link_button);
        linkButton.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(article.getLink()))));

        shareButton = view.findViewById(R.id.share_button);
        shareButton.setOnClickListener(v -> {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, article.getTitle());
            shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.more) + " " + article.getLink());
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share)));
        });

        return view;
    }
}