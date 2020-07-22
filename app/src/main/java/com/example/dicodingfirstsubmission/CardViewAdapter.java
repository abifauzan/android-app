package com.example.dicodingfirstsubmission;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Destination> listDestination;

    public ArrayList<Destination> getListDestination() {
        return listDestination;
    }

    public CardViewAdapter(Context context) {
        this.context = context;
    }

    public void setListDestination(ArrayList<Destination> listDestination) {
        this.listDestination = listDestination;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);

        return new CardViewViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, final int position) {
        Destination i = getListDestination().get(position);

        cardViewViewHolder.title.setText(i.getTitle());
        cardViewViewHolder.content.setText(i.getDescription());

        Glide.with(context)
                .load(i.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.photo);

        final String[] list = new String[] {
                listDestination.get(position).getTitle(),
                listDestination.get(position).getDescription(),
                listDestination.get(position).getPhoto()
        };

        cardViewViewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Go to detail of "+i.getTitle(), Toast.LENGTH_SHORT).show();
                Intent moved = new Intent(context, detailActivity.class);
                moved.putExtra("lists", list);

                context.startActivity(moved);

            }
        });

        cardViewViewHolder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Share "+ listDestination.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListDestination().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView content;
        ImageView photo;
        Button btnDetail;
        Button btn_share;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_heading);
            content = itemView.findViewById(R.id.item_content);
            photo = itemView.findViewById(R.id.item_img);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btn_share = itemView.findViewById(R.id.btn_share);
        }
    }
}
