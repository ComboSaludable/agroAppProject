package com.cdp.Agro.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdp.Agro.Activity.VerProductoActivity;
import com.cdp.Agro.R;
import com.cdp.Agro.entidades.Producto;


import java.util.ArrayList;

public class ListaProductoAdapter extends RecyclerView.Adapter<ListaProductoAdapter.ProductoViewHolder> {


    ArrayList<Producto> listaProductos;

    public ListaProductoAdapter(ArrayList<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.viewNombreProducto.setText(listaProductos.get(position).getNombre());
        holder.viewCategoriaProducto.setText(listaProductos.get(position).getCategoria());
        holder.viewPrecioProducto.setText(listaProductos.get(position).getPrecio());
        holder.viewDescripcionProducto.setText(listaProductos.get(position).getDescripcion());
        holder.viewStockProducto.setText((listaProductos.get(position).getStock()));
        holder.viewDisponibilidadProcuto.setText(((listaProductos.get(position).getStock())));



    }



    @Override
    public int getItemCount() {
        return listaProductos.size();
    }


    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombreProducto, viewCategoriaProducto, viewPrecioProducto, viewDescripcionProducto, viewStockProducto, viewDisponibilidadProcuto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);


            viewNombreProducto = itemView.findViewById(R.id.viewNombreProducto);
            viewCategoriaProducto = itemView.findViewById(R.id.textViewCategoriaProducto);
            viewPrecioProducto = itemView.findViewById(R.id.textViewPrecioProducto);
            viewDescripcionProducto = itemView.findViewById(R.id.textViewDescripcionProducto);
            viewStockProducto = itemView.findViewById(R.id.textViewStockProducto);
            viewDisponibilidadProcuto = itemView.findViewById(R.id.textViewDisponibilidadProducto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerProductoActivity.class);
                    intent.putExtra("ID", listaProductos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });



        }
    }
}
