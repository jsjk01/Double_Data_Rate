package com.example.double_data_rate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView receive_txt2;
    private EditText transfer_txt2;
    private Button transfer2;
    private ImageView gif2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();


    }

    private void startGif() {
        Glide.with(this).load(R.drawable.transfer).into(gif2);
    }



    private void initView() {
        receive_txt2 = findViewById(R.id.receive_txt2);
        receive_txt2.setText(getIntent().getStringExtra("01"));
        transfer_txt2 = findViewById(R.id.transfer_text2);
        transfer2 = findViewById(R.id.transfer2);
        gif2 = findViewById(R.id.gif2);
        transfer2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startGif();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("02",transfer_txt2.getText().toString());
        setResult(RESULT_OK,intent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                clearGif();
                finish();
            }
        },3000);
    }

    private void clearGif() {
        Glide.with(this).clear(gif2);
    }

}
