package com.movieapp.test.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Filme;
import com.movieapp.test.data.network.ApiService;
import com.movieapp.test.data.network.response.FilmesResult;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody; //Apagamos o que era responsebody para chamar o callback certo após criar a classe FilmesResul que agora é o tipo da resposta que o response vai obter
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    //1
    RecyclerView recyclerFilmes; //Global scope / Escopo global

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        recyclerFilmes = findViewById(R.id.recycler_view);

        //5
        ApiService.getInstance().obterFilmesPopulares("fcb6188dc381c27658a694c99c2bbd12")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            //2
                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListaFilmesActivity.this);
                            //3
                            recyclerFilmes.setLayoutManager(linearLayoutManager);
                            recyclerFilmes.setAdapter(new ListaFilmesAdapter(response.body().getResultadoFilmes())); //Recebe os resultados vindo da API e não da nossa lista fake que se chamava criaFilmes()
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {

                    }
                });
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
