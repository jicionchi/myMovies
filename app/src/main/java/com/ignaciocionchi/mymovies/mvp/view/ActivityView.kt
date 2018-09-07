package com.ignaciocionchi.mymovies.mvp.view

import android.support.v7.app.AppCompatActivity
import java.lang.ref.WeakReference

open class ActivityView<out T : AppCompatActivity>(t: T) {
    private val activityRef: WeakReference<T> = WeakReference(t)

    fun getActivity() = activityRef.get()

    fun getContext() = activityRef.get()
}