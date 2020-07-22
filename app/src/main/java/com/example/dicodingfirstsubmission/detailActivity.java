package com.example.dicodingfirstsubmission;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class detailActivity extends AppCompatActivity {

    TextView detailTitle;
    TextView detailContent;
    ImageView detailPhoto;

    ImageView btnBack;
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = findViewById(R.id.detailTitle);
        detailContent = findViewById(R.id.detailDescription);
        detailPhoto = findViewById(R.id.detailPhoto);
        btnBack = findViewById(R.id.btnBack);
        btnBook = findViewById(R.id.btnBook);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailActivity.super.onBackPressed();
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(detailActivity.this, "Booking Process activate!", Toast.LENGTH_SHORT).show();
            }
        });

        String[] lists = getIntent().getStringArrayExtra("lists");

        detailTitle.setText(lists[0]);
        detailContent.setText(lists[1]);

        Glide.with(this).load(lists[2]).into(detailPhoto);

    }
}
