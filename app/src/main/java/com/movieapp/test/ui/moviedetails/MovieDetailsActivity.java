package com.movieapp.test.ui.moviedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "MOVIE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        TextView txt_movie_title = findViewById(R.id.text_title_movie_details_activity);

        final Movie movie = (Movie) getIntent().getSerializableExtra(MOVIE_EXTRA);

        txt_movie_title.setText(movie.getTitle());
    }
}