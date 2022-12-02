package com.tanim.newsapp.extension

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.tanim.newsapp.base.BaseFragment

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun BaseFragment<*, *>.close() = fragmentManager?.popBackStack()

val BaseFragment<*, *>.appContext: Context get() = activity?.applicationContext!!
