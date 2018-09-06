package com.ignaciocionchi.mymovies.mvp.view

import android.support.v4.app.Fragment
import java.lang.ref.WeakReference

open class FragmentView<T : Fragment>(t: T) {
    private val activityRef: WeakReference<Fragment> = WeakReference(t)

    fun getFragment() = activityRef.get()
    fun getActivity() = activityRef.get()?.activity

}