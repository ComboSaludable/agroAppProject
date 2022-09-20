package com.cdp.Agro.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdp.Agro.R;
import com.cdp.Agro.entidades.Pedido;

import java.util.ArrayList;


public class ListaPedidoAdapter extends RecyclerView.Adapter<ListaPedidoAdapter.PedidoViewHolder>{



    ArrayList<Pedido> listaPedido;

    public ListaPedidoAdapter(ArrayList<Pedido> listaPedido){
        this.listaPedido = listaPedido;
    }




    @NonNull
    @Override
    public ListaPedidoAdapter.PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_pedido, null, false);
        return new PedidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPedidoAdapter.PedidoViewHolder holder, int position) {
        holder.viewNumeroPedido.setText(Math.toIntExact(listaPedido.get(position).getNumeroPedido()));
        holder.viewMetodoPagoPedido.setText(listaPedido.get(position).getMetodoPagos());
        holder.viewValorPagarPedido.setText((int) listaPedido.get(position).getValorPagar());
        holder.viewFechaRegistro.setText((CharSequence) listaPedido.get(position).getFechaRegistro());
        holder.viewProducto.setText((listaPedido.get(position).getProductos2()));



    }

    @Override
    public int getItemCount() {
        return listaPedido.size();
    }

    public class PedidoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNumeroPedido, viewMetodoPagoPedido, viewValorPagarPedido, viewFechaRegistro, viewProducto;

        public PedidoViewHolder(@NonNull View itemView) {
            super(itemView);


            viewNumeroPedido = itemView.findViewById(R.id.viewNumeroPedido);
            viewMetodoPagoPedido = itemView.findViewById(R.id.textViewMetodoPagarPedido);
            viewValorPagarPedido = itemView.findViewById(R.id.textViewValorPagarPedido);
            viewFechaRegistro = itemView.findViewById(R.id.textViewFechaRegistroPedido);
            viewProducto = itemView.findViewById(R.id.textViewProductos);



        }
    }
}
