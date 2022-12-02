package com.tanim.newsapp.core.news;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.tanim.newsapp.BR;
import com.tanim.newsapp.NavigationMainDirections;
import com.tanim.newsapp.R;
import com.tanim.newsapp.data.news.Article;
import com.tanim.newsapp.databinding.ItemNewsBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {


    private List<Article> articles;

    @SuppressLint("NotifyDataSetChanged")
    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_news, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.binds(articles.get(position));

        holder.binding.viewRoot.setOnClickListener(view -> Navigation.findNavController(view).navigate(NavigationMainDirections.actionNavigateNewsDetail(
                articles.get(position)
        )));

    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ItemNewsBinding binding;

        public Holder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void binds(Article article) {
            binding.setVariable(BR.article, article);
            binding.executePendingBindings();
        }
    }
}
