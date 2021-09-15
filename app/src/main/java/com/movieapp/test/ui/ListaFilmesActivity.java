package com.movieapp.test.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.mapper.FilmeMapper;
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
    private RecyclerView recyclerFilmes;
    private ListaFilmesAdapter filmesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configurarAdapter();
        obtemFIlmes();
    }

    private void configurarAdapter() {
        recyclerFilmes = findViewById(R.id.recycler_view);

        filmesAdapter = new ListaFilmesAdapter();

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerFilmes.setLayoutManager(gridLayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }

    private void obtemFIlmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("fcb6188dc381c27658a694c99c2bbd12", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) { //200 ok
                            final List<Filme> listaFilmes = FilmeMapper.
                                    deResponseParaDominio(response.body().getResultadoFilmes());
                            filmesAdapter.setFilmes(listaFilmes);
                        }else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
    }

    private void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_LONG).show();
    }
}
