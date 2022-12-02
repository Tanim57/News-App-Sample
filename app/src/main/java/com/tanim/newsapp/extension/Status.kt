package com.tanim.newsapp.extension

import com.tanim.newsapp.data.mapper.Status

fun Status.isLoading() = this == Status.LOADING

fun Status.error() = this == Status.ERROR

fun Status.success() = this == Status.SUCCESS
