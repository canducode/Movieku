package com.ngoopy.movieku.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.ngoopy.movieku.R
import com.ngoopy.movieku.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTVShow = DataDummy.generateDummyTVShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed())) // <- Memeriksa apakah id yang diharapkan tampil
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size)) // <- Mencoba scroll hingga banyak data
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())) // <- Memilih / Klik view dengan index 0
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed())) // <- Memeriksa apakah id yang diharapkan tampil
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title))) // <- Membandingkan data dengan exspektasi hasil yang diharapkan
    }

    @Test
    fun loadTVShow() {
        onView(withText("TV Show")).perform(click()) // <- Memilih / Klik tulisan TV Show
        onView(withId(R.id.rvTvShows)).check(matches(isDisplayed())) // <- Memeriksa apakah view id yang diharapkan tampil
        onView(withId(R.id.rvTvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size)) // <- Mencoba scroll hingga banyak data
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TV Show")).perform(click()) // <- Memilih / Klik tulisan TV Show
        onView(withId(R.id.rvTvShows)).check(matches(isDisplayed())) // <- Memeriksa apakah view id yang diharapkan tampil
        onView(withId(R.id.rvTvShows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())) // <- Memilih / Klik view dengan index 0
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed())) // <- Memeriksa apakah id yang diharapkan tampil
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTVShow[0].title)))  // <- Membandingkan data dengan exspektasi hasil yang diharapkan
    }
}