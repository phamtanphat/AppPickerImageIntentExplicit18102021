package com.example.apppickerimageintentexplicit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] mArrDrawable;
    private ImageView mImgPick, mImgRandom;
    private int mResourceRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();

    }

    private void event() {
        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("arr_drawable",mArrDrawable);
                startActivity(intent);
            }
        });
    }

    private void init() {
        // Ánh xạ
        mImgPick = findViewById(R.id.imgPick);
        mImgRandom = findViewById(R.id.imgRandom);

        // Tạo mảng chứa tên hình
        mArrDrawable = getResources().getStringArray(R.array.ArrayDrawable);

        // Xử lý việc gán hình cho hình random
        mResourceRandom = randomImage(mArrDrawable);
        mImgRandom.setImageResource(mResourceRandom);
    }
    private int randomImage(String[] arrDrawable){
        int index = new Random().nextInt(arrDrawable.length);
        String name = arrDrawable[index];
        int resourceImage = getResources().getIdentifier(name,"drawable",getPackageName());
        return resourceImage;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_refresh:
                mResourceRandom = randomImage(mArrDrawable);
                mImgRandom.setImageResource(mResourceRandom);
                break;
        }
        return true;
    }
}