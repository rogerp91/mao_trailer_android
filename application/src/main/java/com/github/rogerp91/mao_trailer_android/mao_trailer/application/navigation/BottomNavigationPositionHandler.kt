package com.github.rogerp91.mao_trailer_android.mao_trailer.application.navigation

object BottomNavigationPositionHandler {

    fun buildConfig(): BottomNavigationPosition {
        val unknown = UnknownBottomNavigationPosition()
        val movies = MoviesBottomNavigationPosition(unknown)
        val profile = ProfileBottomNavigationPosition(movies)
        return TvBottomNavigationPosition(profile)
    }
}
