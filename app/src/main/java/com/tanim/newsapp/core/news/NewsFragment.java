package com.tanim.newsapp.core.news;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.tanim.newsapp.BR;
import com.tanim.newsapp.R;
import com.tanim.newsapp.base.BaseFragment;
import com.tanim.newsapp.data.mapper.Status;
import com.tanim.newsapp.databinding.FragmentNewsBinding;
import com.tanim.newsapp.di.component.FragmentComponent;

public class NewsFragment extends BaseFragment<FragmentNewsBinding,NewsViewModel> {

    private Snackbar snackbar;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void performDependencyInjection(@NonNull FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NewsAdapter adapter = new NewsAdapter();

        getViewDataBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false));

        getViewDataBinding().recyclerView.setAdapter(adapter);

        mViewModel.lastResponse.observe(getViewLifecycleOwner(), response -> {
            if(response==null)
                return;
            if(response.status == Status.LOADING){
                showProgressbar();
                hideError();
            }else {
                hideProgressbar();
                if (response.status == Status.SUCCESS) {
                    if(response.data.getStatus().equals("ok")){
                        adapter.setArticles(response.data.getArticles());
                        hideError();
                    }else {
                        showError(response.data.getMessage());
                    }
                } else if (response.status == Status.ERROR) {
                    showError(response.message.format(requireContext()));
                }
            }
        });

        getViewDataBinding().btnRetry.setOnClickListener(view1 -> mViewModel.fetchNews());

    }

    @Override
    public void showError(@NonNull String message) {
        getViewDataBinding().tvMessage.setText(message);
        getViewDataBinding().tvMessage.setVisibility(View.VISIBLE);
        getViewDataBinding().btnRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        getViewDataBinding().tvMessage.setVisibility(View.GONE);
        getViewDataBinding().btnRetry.setVisibility(View.GONE);
    }

    @Override
    public void showProgressbar() {
        getViewDataBinding().progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        getViewDataBinding().progressbar.setVisibility(View.GONE);
    }
}
