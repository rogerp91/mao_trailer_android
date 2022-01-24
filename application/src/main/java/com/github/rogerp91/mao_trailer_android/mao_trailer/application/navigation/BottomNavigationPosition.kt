package com.github.rogerp91.mao_trailer_android.mao_trailer.application.navigation

import androidx.fragment.app.Fragment
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.R
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.ui.dashboard.DashboardFragment
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.ui.home.HomeFragment
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.ui.notifications.NotificationsFragment

interface BottomNavigationPosition {

    fun id(): Int

    fun position(): Int

    fun tag(): String

    fun fragment(): Fragment

    fun find(id: Int): BottomNavigationPosition?
}

abstract class BottomNavigationPositionBase(
    private val next: BottomNavigationPosition?
) : BottomNavigationPosition {

    protected fun nextChain(id: Int): BottomNavigationPosition? {
        return next?.find(id)
    }
}

class MoviesBottomNavigationPosition(
    next: BottomNavigationPosition?
) : BottomNavigationPositionBase(next), BottomNavigationPosition {

    override fun id(): Int = R.id.navigation_movie

    override fun position(): Int = 0

    override fun tag(): String = "movies"

    override fun fragment(): Fragment = DashboardFragment()

    override fun find(id: Int): BottomNavigationPosition? {
        if (id == R.id.navigation_movie) {
            return this
        }
        return nextChain(id)
    }
}

class TvBottomNavigationPosition(
    next: BottomNavigationPosition
) : BottomNavigationPositionBase(next), BottomNavigationPosition {

    override fun id(): Int = R.id.navigation_tv

    override fun position(): Int = 1

    override fun tag(): String = "tv"

    override fun fragment(): Fragment = HomeFragment()

    override fun find(id: Int): BottomNavigationPosition? {
        if (id == R.id.navigation_tv) {
            return this
        }
        return nextChain(id)
    }
}

class ProfileBottomNavigationPosition(
    next: BottomNavigationPosition
) : BottomNavigationPositionBase(next), BottomNavigationPosition {

    override fun id(): Int = R.id.navigation_profile

    override fun position(): Int = 2

    override fun tag(): String = "profile"

    override fun fragment(): Fragment = NotificationsFragment()

    override fun find(id: Int): BottomNavigationPosition? {
        if (id == R.id.navigation_profile) {
            return this
        }
        return nextChain(id)
    }
}

class UnknownBottomNavigationPosition :
    BottomNavigationPositionBase(null),
    BottomNavigationPosition {

    override fun id(): Int = 0

    override fun position(): Int = 0

    override fun tag(): String = "unknown"

    override fun fragment(): Fragment = Fragment()

    override fun find(id: Int): BottomNavigationPosition {
        return this
    }
}
