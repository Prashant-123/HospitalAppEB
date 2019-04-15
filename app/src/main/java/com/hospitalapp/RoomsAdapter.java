package com.hospitalapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RoomModel> list = new ArrayList<>();
    int[] gradient = {R.drawable.gradient_sub_1, R.drawable.gradient_sub_2, R.drawable.gradient_sub_3,
            R.drawable.gradient_sub_4, R.drawable.gradient_sub_5};
    int rand = new Random().nextInt(5);

    public RoomsAdapter(Context context, ArrayList<RoomModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RoomsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rooms_model, parent,  false);
        return new RoomsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsAdapter.ViewHolder holder, int i) {
        holder.room_card.setBackgroundResource(gradient[rand]);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout room_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room_card = itemView.findViewById(R.id.room_card);
        }
    }
}
