package com.tanim.newsapp.di.module

import android.content.Context
import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import com.tanim.newsapp.base.BaseFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tanim.newsapp.base.ViewModelFactory
import com.tanim.newsapp.core.bookmark.BookmarkModel
import com.tanim.newsapp.core.home.HomeViewModel
import com.tanim.newsapp.core.login.LoginViewModel
import com.tanim.newsapp.core.newdetails.NewsDetailViewModel
import com.tanim.newsapp.core.news.NewsViewModel
import com.tanim.newsapp.repository.DataRepository
import com.tanim.newsapp.managers.DataManager
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: BaseFragment<*, *>) {
    @Provides
    fun provideContext(): Context {
        return fragment.requireContext()
    }

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(fragment.requireContext())
    }

    @Provides
    fun provideLoginViewModel(dataManager: DataManager,repository: DataRepository): LoginViewModel {

        val supplier: Supplier<LoginViewModel> =
            Supplier { LoginViewModel(dataManager,repository) }

        val factory: ViewModelFactory<LoginViewModel> =
            ViewModelFactory<LoginViewModel>(LoginViewModel::class.java, supplier)

        return ViewModelProvider(fragment, factory).get(LoginViewModel::class.java)
    }

    @Provides
    fun provideHomeViewModel(dataManager: DataManager,repository: DataRepository): HomeViewModel {

        val supplier: Supplier<HomeViewModel> =
            Supplier { HomeViewModel(dataManager,repository) }

        val factory: ViewModelFactory<HomeViewModel> =
            ViewModelFactory<HomeViewModel>(HomeViewModel::class.java, supplier)

        return ViewModelProvider(fragment, factory).get(HomeViewModel::class.java)
    }

    @Provides
    fun provideNewsViewModel(dataManager: DataManager,repository: DataRepository): NewsViewModel {

        val supplier: Supplier<NewsViewModel> =
            Supplier { NewsViewModel(dataManager,repository) }

        val factory: ViewModelFactory<NewsViewModel> =
            ViewModelFactory<NewsViewModel>(NewsViewModel::class.java, supplier)

        return ViewModelProvider(fragment, factory).get(NewsViewModel::class.java)
    }

    @Provides
    fun provideNewsDetailViewModel(dataManager: DataManager,repository: DataRepository): NewsDetailViewModel {

        val supplier: Supplier<NewsDetailViewModel> =
            Supplier { NewsDetailViewModel(dataManager,repository) }

        val factory: ViewModelFactory<NewsDetailViewModel> =
            ViewModelFactory<NewsDetailViewModel>(NewsDetailViewModel::class.java, supplier)

        return ViewModelProvider(fragment, factory).get(NewsDetailViewModel::class.java)
    }

    @Provides
    fun provideBookmarkViewModel(dataManager: DataManager,repository: DataRepository): BookmarkModel {

        val supplier: Supplier<BookmarkModel> =
            Supplier { BookmarkModel(dataManager,repository) }

        val factory: ViewModelFactory<BookmarkModel> =
            ViewModelFactory<BookmarkModel>(BookmarkModel::class.java, supplier)

        return ViewModelProvider(fragment, factory).get(BookmarkModel::class.java)
    }
}