package org.chromium.chrome.browser.unangwearos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Chapters extends WearableActivity {

    TextView tvAklat, tvChapter;
    String aklat, chapter, inputChapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        tvAklat = findViewById(R.id.tvAklat);
        tvChapter = findViewById(R.id.tvChapter);

        aklat = getIntent().getStringExtra("aklat");
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
        if(num == 0 && inputChapter == null){
            tvChapter.setText("");
        }else{
            inputChapter = tvChapter.getText().toString();
            chapter = inputChapter + num;
            tvChapter.setText(chapter);
        }
    }

    public void allClear(View view){
        tvChapter.setText("");
        chapter = "";
        inputChapter = null;

    }
    public void onInputChapter(View view){
        if(chapter == ""){
            Toast.makeText(this, "Please input Chapter", Toast.LENGTH_SHORT).show();
        }else{
            String book = aklat;
            String chapters = chapter;
            Intent theIntent = new Intent(Chapters.this, Verses.class);
            theIntent.putExtra("aklat", book);
            theIntent.putExtra("chapter", chapters);
            startActivity(theIntent);
        }

    }
}