package com.example.froylan.galeria;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by froylan on 19/11/16.
 */

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.viewHolder>{
    private List<GaleriaModel.Imagen> galeria;
    private Context context;

    public GaleriaAdapter(List<GaleriaModel.Imagen> galeria, Context context) {
        this.galeria = galeria;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_galeria,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GaleriaModel.Imagen imagen=galeria.get(position);

        //insertar imagen desde url
        Glide.with(context).load(imagen.getUrl()).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return galeria.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;


        public viewHolder(View itemView) {
            super(itemView);
            imagen=(ImageView)itemView.findViewById(R.id.imagen);
        }
    }
}
