package com.batyan.zefgame.modules.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.batyan.zefgame.modules.feed.FeedModuleContract.listLiveData;

public final class FeedFragment extends Fragment implements FeedModuleContract.IFeedModuleView {

    private FeedModuleContract.IFeedModulePresenter presenter;

    private RecyclerView recyclerView;
    private FloatingActionButton updateButton;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_list);
        updateButton = view.findViewById(R.id.fab);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listLiveData.observe(this, this::showArticles);
        presenter.downloadArticles();
        updateButton.setOnClickListener(v -> {
            presenter.downloadArticles();
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setPresenter(final FeedModuleContract.IFeedModulePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showArticles(final List<ArticleModel> articles) {
        final FeedAdapter adapter = new FeedAdapter(articles);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(final String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }
}