package com.movieapp.test.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.movieapp.test.R;

public class FavoriteActivity extends AppCompatActivity {
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        setToolbar();

        database = openOrCreateDatabase("app", MODE_PRIVATE, null);
        displayMovies();
        //database.execSQL("DROP TABLE movies");

    }

    public void setToolbar() {
        Toolbar myChildToolbar = findViewById(R.id.toolbar_favorite);
        setSupportActionBar(myChildToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

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
}