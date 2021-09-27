package com.movieapp.test.ui.moviedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.movieapp.test.R;
import com.movieapp.test.data.model.Movie;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "MOVIE_EXTRA";

    TextView txt_movie_title;
    ImageView image_poster;
    ImageView favButton;
    TextView txt_overview;
    TextView txt_release_date;

    SQLiteDatabase database;
    Movie movie;
    int indexFavoriteColumn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movie = (Movie) getIntent().getSerializableExtra(MOVIE_EXTRA);

        txt_movie_title = findViewById(R.id.text_title_movie_details_activity);
        image_poster = findViewById(R.id.poster_full);
        favButton = findViewById(R.id.im_fav_button_details_activity);
        txt_overview = findViewById(R.id.text_movie_overview);
        txt_release_date = findViewById(R.id.txt_release_date);

        database = openOrCreateDatabase("app", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS movies(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, favorite VARCHAR)");

        setFavoriteBtnColor();

        txt_movie_title.setText(movie.getTitle());

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/" + movie.getPosterPath())
                .into(image_poster);

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovieFavorited()) {
                    favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    movie.setFavorited(false);

                    //Set false to movies that users do not like
                    database.execSQL("UPDATE movies SET favorite = 'false' WHERE name = '" + movie.getTitle() + "' ");

                    //Remove unfavorite movie(s) from database
                    database.execSQL("DELETE FROM movies WHERE favorite = 'false' ");
                    Snackbar.make(v, "Removido dos favoritos", Snackbar.LENGTH_SHORT).show();

                } else {
                    favButton.setImageResource(R.drawable.ic_baseline_favorite_24);
                    movie.setFavorited(true);

                    //Add favorite movie into database
                    database.execSQL("INSERT INTO movies(name, favorite)" + "VALUES" + "('" + movie.getTitle() + "','true');");
                    Snackbar.make(v, "Adicionado aos favoritos", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        //Set Movie Overview
        txt_overview.setText(movie.getOverview());

        txt_release_date.setText(movie.getRelease_date());

    }

    //Set heart button with red color if the movie is favorited by getting data from SQL Database
    private void setFavoriteBtnColor() {
        if (isMovieFavorited()) {
            favButton.setImageResource(R.drawable.ic_baseline_favorite_24);
        } else {
            favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }
    }

    //Show us if a movie is on the list of favorite or not
    public boolean isMovieFavorited() {

        try {
            Cursor cursor = database.rawQuery("SELECT * FROM movies WHERE name = '" + movie.getTitle() + "'", null);

            indexFavoriteColumn = cursor.getColumnIndex("favorite");

            return cursor.moveToFirst(); //It will return true if there is a favorite movie at the first row. false if list of favorite movies is empty/null

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}