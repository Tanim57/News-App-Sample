package com.tanim.newsapp.data.news;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tanim.newsapp.data.BasePageResponse;

import java.util.List;

@Keep
public class NewsResponse extends BasePageResponse {
    @SerializedName("articles")
    @Expose
    List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
