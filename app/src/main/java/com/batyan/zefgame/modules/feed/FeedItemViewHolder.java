package com.batyan.zefgame.modules.feed;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;

final class FeedItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView titleTextVIew;
    private final TextView authorTextView;
    private final TextView dateTextView;
    private final TextView descriptionTextView;

    FeedItemViewHolder(@NonNull final View itemView) {
        super(itemView);

        titleTextVIew = itemView.findViewById(R.id.title);
        authorTextView = itemView.findViewById(R.id.author_list);
        dateTextView = itemView.findViewById(R.id.date_list);
        descriptionTextView = itemView.findViewById(R.id.description_list);
    }

    void onBind(final ArticleModel article) {
        titleTextVIew.setText(article.getTitle());
        authorTextView.setText(article.getAuthor());
        dateTextView.setText(article.getPubDate());
        titleTextVIew.setOnClickListener(v -> descriptionTextView
                .setVisibility(descriptionTextView.getVisibility() > View.VISIBLE
                ? View.VISIBLE
                : View.GONE));
        descriptionTextView.setText(article.getDescription());
    }

    TextView getDescriptionTextView() {
        return descriptionTextView;
    }

}
