package com.movieapp.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes; //Deixamos o FilmeResponse só para converter o que ta vindo em código java, então agora pegamos os dados da classe Filme (como se fosse uma dataclass em kotlin)

    public ListaFilmesAdapter() {
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view); //Passando meu item que é uma view para o viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) { // Esse cara chamado holder vai pegar cada item da sua lista e colocar em pilha de acordo com o total do retunr em getItemCount
        holder.bind(filmes.get(position)); //Posição de cada item vindo da api sendo enviado para a função bind]
    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;
        private ImageView imagePosterFilme;

        public ListaFilmesViewHolder(View itemView) { //itemView esta recebendo a view de fato (que é o nosso layout R.layout.item_filme )
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
            imagePosterFilme = itemView.findViewById(R.id.image_poster_filme);
        }

        public void bind(Filme filme) {
            //Agora o bind esta sendo feito de fato
            textTituloFilme.setText(filme.getTitulo());
            //o bind da imagem do poster é feito atráves do picasso
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500/" + filme.getCaminhoPoster())
                    .into(imagePosterFilme);

        }
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
        notifyDataSetChanged(); //Responsável por ver todos os itens que esta chegando pro adapter
    }
}
