package com.movieapp.test.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;

public class ListaFilmesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        //1
        RecyclerView recyclerFilmes = findViewById(R.id.recycler_view);
        //2
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //3
        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter(new ListaFilmesAdapter()); //Recebe de fato a Classe ListaFilmesAdapter que esta tudo configurado

    }
}
