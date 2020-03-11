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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView receive_txt1;
    private EditText transfer_txt1;
    private Button transfer1;
    private ImageView gif1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void startGif() {
        Glide.with(this).load(R.drawable.transfer).into(gif1);
    }



    private void initView() {
        receive_txt1 = findViewById(R.id.receive_txt1);
        transfer_txt1 = findViewById(R.id.transfer_text1);
        transfer1 = findViewById(R.id.transfer1);
        gif1 = findViewById(R.id.gif1);
        transfer1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startGif();
        final Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("01",transfer_txt1.getText().toString());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityForResult(intent,0x01);
                clearGif();
            }
        },3000);
    }

    private void clearGif() {
        Glide.with(this).clear(gif1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0x01){
            String extra1 = data.getStringExtra("02");
            receive_txt1.setText(extra1);
        }
    }
}
