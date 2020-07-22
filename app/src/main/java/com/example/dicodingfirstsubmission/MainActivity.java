package com.example.dicodingfirstsubmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_rv;
    private ArrayList<Destination> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Top 5 Destination in Bandung");

        main_rv = findViewById(R.id.main_rv);
        main_rv.setHasFixedSize(true);

        list.addAll(DestinationData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        main_rv.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(this);
        cardViewAdapter.setListDestination(list);
        main_rv.setAdapter(cardViewAdapter);

        ItemClickSupport.addTo(main_rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(list.get(position));
            }
        });
    }

    private void showSelectedItem(Destination destination) {

        final String[] list = new String[] {
                destination.getTitle(),
                destination.getDescription(),
                destination.getPhoto()
        };

        Intent moved = new Intent(this, detailActivity.class);
        moved.putExtra("lists", list);

        startActivity(moved);

//        Toast.makeText(this, "You choose "+ destination.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
