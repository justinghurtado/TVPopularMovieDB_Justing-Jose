package com.example.themoviedb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.themoviedb.Constants.Companion.MOVIE_BACKDROP
import com.example.themoviedb.Constants.Companion.MOVIE_OVERVIEW
import com.example.themoviedb.Constants.Companion.MOVIE_POSTER
import com.example.themoviedb.Constants.Companion.MOVIE_RATING
import com.example.themoviedb.Constants.Companion.MOVIE_RELEASE_DATE
import com.example.themoviedb.Constants.Companion.MOVIE_TITLE
import com.example.themoviedb.databinding.ActivityMoviesDetailsBinding


class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        if (extras != null) {
            populateDetails(extras)
        } else {
            finish()
        }
    }

    private fun populateDetails(extras: Bundle) {
        extras.getString(MOVIE_BACKDROP)?.let { backdropPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w1280$backdropPath")
                .transform(CenterCrop())
                .into(binding.movieBackdrop)
        }

        extras.getString(MOVIE_POSTER)?.let { posterPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342$posterPath")
                .transform(CenterCrop())
                .into(binding.moviePoster)
        }

        binding.movieTitle.text = extras.getString(MOVIE_TITLE, "")
        binding.movieRating.rating = extras.getFloat(MOVIE_RATING, 0f) / 2
        binding.movieReleaseDate.text = extras.getString(MOVIE_RELEASE_DATE, "")
        binding.movieOverview.text = extras.getString(MOVIE_OVERVIEW, "")
    }
    }
