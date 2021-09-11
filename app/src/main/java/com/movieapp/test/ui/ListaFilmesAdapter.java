package com.movieapp.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Filme;
import com.movieapp.test.data.network.response.FilmesResponse;

import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<FilmesResponse> filmes; //Mudamos o tipo, pois agora criamos a clase FilmeResponse, e é nela que estão as repostas da API

    public ListaFilmesAdapter(List<FilmesResponse> filmes) { //Mudamos o tipo, pois agora criamos a clase FilmeResponse, e é nela que estão as repostas da API
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view); //Passando meu item que é uma view para o viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) { // Esse cara chamado holder vai pegar cada item da sua lista e colocar em pilha de acordo com o total do retunr em getItemCount
        //Apartir de agora posso passar a informação para o meu id text_titulo_filme
        holder.textTituloFilme.setText(filmes.get(position).getTituloOriginal()); //Apenas teste. obtendo o titulo do filme por enquanto
    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;

        public ListaFilmesViewHolder(View itemView) { //itemView esta recebendo a view de fato (que é o nosso layout R.layout.item_filme )
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);

        }
    }
}
