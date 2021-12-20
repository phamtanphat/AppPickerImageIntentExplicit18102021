package com.example.apppickerimageintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TableLayout mTbLayout;
    int mColumn , mRow , mCount;
    int mResourceId;
    String[] mArrDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTbLayout = findViewById(R.id.tableLayout);

        initView();
    }

    private void initView() {
        // Get data
        Intent intent = getIntent();
        if (intent != null){
            mArrDrawable = intent.getStringArrayExtra("arr_drawable");
        }

        mRow = (int) Math.ceil( Double.parseDouble ((mArrDrawable.length / 3f)+""));
        mCount = 0;
        mColumn = 3;
        // 6 dong 3 cot
        for (int i = 0 ; i < mRow ; i++){
            //Create row
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < mColumn ; y++){
                if (mCount < mArrDrawable.length){
                    // Tính vị trí của hình chữ nhật khi biết trục tung và hoành
//                    mIndex =  mColumn * i  + y ;
                    mResourceId = getResources().getIdentifier(mArrDrawable[mCount],"drawable",getPackageName());
                    ImageView imageView = new ImageView(this);
                    imageView.setImageResource(mResourceId);
                    tableRow.addView(imageView);
                    mCount++;
                }
            }
            mTbLayout.addView(tableRow);
        }
    }
}