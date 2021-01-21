package org.chromium.chrome.browser.unangwearos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class Chapters extends WearableActivity {

    TextView tvAklat, tvChapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        tvAklat = findViewById(R.id.tvAklat);
        tvChapter = findViewById(R.id.tvChapter);

        String aklat = getIntent().getStringExtra("aklat");
            tvAklat.setText(aklat);


    }

    public void onNumberClickChapter(View view) {
        switch (view.getId()) {

            case R.id.btn0:
                onInputNumbers(0);
                break;
            case R.id.btn1:
                onInputNumbers(1);
                break;
            case R.id.btn2:
                onInputNumbers(2);
                break;
            case R.id.btn3:
                onInputNumbers(3);
                break;
            case R.id.btn4:
                onInputNumbers(4);
                break;
            case R.id.btn5:
                onInputNumbers(5);
                break;
            case R.id.btn6:
                onInputNumbers(6);
                break;
            case R.id.btn7:
                onInputNumbers(7);
                break;
            case R.id.btn8:
                onInputNumbers(8);
                break;
            case R.id.btn9:
                onInputNumbers(9);
                break;
        }
    }
    public void onInputNumbers(int num){
        String inputChapter = tvChapter.getText().toString();
        String chapter = inputChapter + num;
        tvChapter.setText(chapter);
    }

    public void allClear(View view){
        tvChapter.setText("");


    }
}