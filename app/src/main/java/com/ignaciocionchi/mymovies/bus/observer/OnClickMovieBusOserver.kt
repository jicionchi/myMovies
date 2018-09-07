package com.ignaciocionchi.mymovies.bus.observer

abstract class OnClickMovieBusOserver : BusObserver<OnClickMovieBusOserver.OnClickMovie>
(OnClickMovie::class.java) {

    class OnClickMovie(val moveId: Long)
}