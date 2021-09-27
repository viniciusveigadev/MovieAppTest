package com.movieapp.test.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.movieapp.test.R;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    SQLiteDatabase database;
    ArrayList<String> myListOfFavMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_movies);

        setToolbar();

        database = openOrCreateDatabase("app", MODE_PRIVATE, null);
        //displayMovies();

        ListView listView = findViewById(R.id.list_view);
        myListOfFavMovies = new ArrayList<>();

        addFavMoviesToList();

        //Set movies from myList into listView
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myListOfFavMovies);
        listView.setAdapter(listAdapter);

    }

    public void setToolbar() {
        Toolbar myChildToolbar = findViewById(R.id.toolbar_favorite);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void addFavMoviesToList() {
        try {
            Cursor data = database.rawQuery("SELECT * FROM movies", null);

            int indexMovieTitle = data.getColumnIndex("name");

            //For Empty list. No favorited movies
            if (!data.moveToNext()) {
                Toast.makeText(this, "Sua lista esta vazia!", Toast.LENGTH_SHORT).show();
            }

            data.moveToFirst();

            while (data != null) {
                myListOfFavMovies.add(data.getString(indexMovieTitle));

                data.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/* FOR DEVELOPMENT
    public void displayMovies() {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM movies", null);

            int indexColunaId = cursor.getColumnIndex("id");
            int indexColunaname = cursor.getColumnIndex("name");
            int indexColunaFavorite = cursor.getColumnIndex("favorite");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Número de id - ", cursor.getString(indexColunaId));
                Log.i("Resultado name - ", cursor.getString(indexColunaname));
                Log.i("Resultado favorite - ", cursor.getString(indexColunaFavorite));

                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 */
}