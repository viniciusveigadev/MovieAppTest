package com.movieapp.test.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Filme;
import com.movieapp.test.data.network.ApiService;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        //1
        RecyclerView recyclerFilmes = findViewById(R.id.recycler_view);

        //5
        ApiService.getInstance().obterFilmesPopulares("fcb6188dc381c27658a694c99c2bbd12")
                .enqueue(new Callback<ResponseBody>() { //.execute() fará a aplicação quebrar pois esta é a thread principal;
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

        //2
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //3
        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter(new ListaFilmesAdapter(criaFilmes())); //Recebe de fato a Classe ListaFilmesAdapter que esta tudo configurado

    }
        //4
    private List<Filme> criaFilmes() {
        return Arrays.asList(
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha"),
                new Filme("Homem aranha")
        );
    }

}
