package com.batyan.zefgame.modules.feed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.modules.article.ArticleActivity;

public final class FeedAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private final List<ArticleModel> articles;

    FeedAdapter(final List<ArticleModel> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public FeedItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new FeedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FeedItemViewHolder holder, final int position) {
        final ArticleModel article = articles.get(position);
        holder.getDescriptionTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context itemContext = holder.getDescriptionTextView().getContext();
                Intent intent = new Intent(itemContext, ArticleActivity.class);
                intent.putExtra("article", article);
                itemContext.startActivity(intent);
            }
        });
        holder.onBind(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
