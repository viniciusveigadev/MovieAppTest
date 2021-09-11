package com.movieapp.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view); //Passando meu item que é uma view para o viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) { // Esse cara chamado holder vai pegar cada item da sua lista e colocar em pilha de acordo com o total do retunr em getItemCount
        //Apartir de agora posso passar a informação para o meu id text_titulo_filme
        holder.textTituloFilme.setText("Esse é o filme 1 da position 0 da sua lista");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;

        public ListaFilmesViewHolder(View itemView) { //itemView esta recebendo a view de fato (que é o nosso layout R.layout.item_filme )
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);

        }
    }

}
