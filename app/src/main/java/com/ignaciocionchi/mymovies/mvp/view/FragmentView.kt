package com.ignaciocionchi.mymovies.mvp.view

import android.support.v4.app.Fragment
import java.lang.ref.WeakReference

open class FragmentView<out T : Fragment>(t: T) {
    private val activityRef: WeakReference<T> = WeakReference(t)

    fun getFragment() = activityRef.get()
    fun getActivity() = activityRef.get()?.activity
}