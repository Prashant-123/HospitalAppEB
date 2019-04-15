package com.hospitalapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(@NonNull final RoomsAdapter.ViewHolder holder, int i) {
        holder.room_card.setBackgroundResource(gradient[rand]);
        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(holder.itemView.getContext());
                final View dialogView = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.patient_info_tap, null);
                final LinearLayout view;
                dialogBuilder.setView(dialogView);
                view = dialogView.findViewById(R.id.info_card);


                RadioGroup rGroup = dialogView.findViewById(R.id.rg);
                rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                {
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId) {
                            case R.id.rb1: SetData(dialogView, "Prashant", "#21", "Viral Fever", "AB+", "pk021998@gmail.com", "+91-8527753545", "D-359, Street No-2, Hardev Puri, Shahdara"); break;
                            case R.id.rb2: SetData(dialogView, "Kumar", "#69", "Road Accident", "A+", "kumar21@gmail.com", "+91-8989898989", "Delhi, IN"); break;
                            default:
                                Toast.makeText(dialogView.getContext(), "Radio Button Error", Toast.LENGTH_SHORT).show();
                        }
                        view.setVisibility(View.VISIBLE);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout room_card;
        MaterialButton info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room_card = itemView.findViewById(R.id.room_card);
            info = itemView.findViewById(R.id.info);
        }
    }

    public void SetData(View view, String name, String p_id, String disease, String bg, String email, String phone, String address){
        TextView nameTV, pidTV, diseaseTV, bgTV, emailTV, phoneTV, addressTV;
        nameTV = view.findViewById(R.id.name_profile);
        pidTV = view.findViewById(R.id.p_id);
        diseaseTV = view.findViewById(R.id.disease);
        bgTV = view.findViewById(R.id.bg);
        emailTV = view.findViewById(R.id.email_profile);
        phoneTV = view.findViewById(R.id.phone_profile);
        addressTV = view.findViewById(R.id.addresss_profile);

        nameTV.setText(name);
        pidTV.setText(p_id);
        diseaseTV.setText(disease);
        bgTV.setText(bg);
        emailTV.setText(email);
        phoneTV.setText(phone);
        addressTV.setText(address);
    }
}
