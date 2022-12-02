package com.tanim.newsapp.data.mapper;


import androidx.annotation.Keep;

@Keep
public class Resource<T,V> {
    public Status status;
    public T data;
    public V message;

    public Resource(Status status, T data, V msg) {
        this.status = status;
        this.data = data;
        this.message = msg;
    }

    public static <T,V> Resource<T,V> success(T data){
        return new Resource<T,V>(Status.SUCCESS,data,null);
    }

    public static <T,V> Resource<T,V> error(V message,T data){
        return new Resource<T,V>(Status.ERROR,data,message);
    }

    public static <T,V> Resource<T,V> error(V message){
        return new Resource<T,V>(Status.ERROR,null,message);
    }

    public static <T,V> Resource<T,V> loading(){
        return new Resource<T,V>(Status.LOADING,null,null);

    }

}
