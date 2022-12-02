package com.tanim.newsapp.core.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tanim.newsapp.BR
import com.tanim.newsapp.R
import com.tanim.newsapp.base.BaseFragment
import com.tanim.newsapp.core.bookmark.BookMarkFragment
import com.tanim.newsapp.core.news.NewsFragment
import com.tanim.newsapp.databinding.FragmentHomeBinding
import com.tanim.newsapp.di.component.FragmentComponent


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel


    override fun performDependencyInjection(buildComponent: FragmentComponent) {
        buildComponent.inject(this)
    }

    override val layout: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getViewDataBinding().viewPager2.setSaveEnabled(false);
        val screenSlidePagerAdapter = ScreenSlidePagerAdapter(this)
        viewDataBinding.viewPager2.adapter = screenSlidePagerAdapter

        val tabLayout: TabLayout = viewDataBinding.tabLayout

        TabLayoutMediator(
            tabLayout, viewDataBinding.viewPager2
        ) { tab: TabLayout.Tab, position: Int ->
            if (position == 0) {
                tab.setText(R.string.news)
            } else {
                tab.setText(R.string.bookmark)
            }
        }.attach()

    }


    private class ScreenSlidePagerAdapter(fa: Fragment) :

        FragmentStateAdapter(fa) {

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                NewsFragment()
            } else {
                BookMarkFragment()
            }
        }

        override fun getItemCount(): Int {
            return 2
        }
    }
}