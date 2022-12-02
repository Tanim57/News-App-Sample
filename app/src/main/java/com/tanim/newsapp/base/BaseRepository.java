package com.tanim.newsapp.base;


import com.tanim.newsapp.managers.DataManager;

public abstract class BaseRepository {
    private final DataManager dataManager;

    protected BaseRepository(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
