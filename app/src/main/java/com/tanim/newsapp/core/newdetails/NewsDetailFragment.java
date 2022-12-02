package com.tanim.newsapp.core.newdetails;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tanim.newsapp.BR;
import com.tanim.newsapp.R;
import com.tanim.newsapp.base.BaseFragment;
import com.tanim.newsapp.databinding.FragmentNewsDetailsBinding;
import com.tanim.newsapp.di.component.FragmentComponent;

public class NewsDetailFragment extends BaseFragment<FragmentNewsDetailsBinding, NewsDetailViewModel> {
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
        return R.layout.fragment_news_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            mViewModel.article.set(NewsDetailFragmentArgs.fromBundle(requireArguments()).getArticle());
        }

    }


}
