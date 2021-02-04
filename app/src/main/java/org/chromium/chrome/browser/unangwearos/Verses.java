package org.chromium.chrome.browser.unangwearos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Verses extends WearableActivity {

    TextView tvTalata, tvVerse;
    String aklat, chapter, verse="", inputVerse;
    String verses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        tvTalata = findViewById(R.id.tvTalata);
        tvVerse = findViewById(R.id.tvVerse);

        aklat = getIntent().getStringExtra("aklat");
        chapter = getIntent().getStringExtra("chapter");
        verses = aklat + " " + chapter + " : ";
        tvTalata.setText(verses);
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

    public void onClickDash(View view){
        if(inputVerse == null){
            tvVerse.setText("");
        }else{
            tvVerse.setText(verse + "-");
        }
    }
    public void onClickComma(View view){
        if(inputVerse == null){
            tvVerse.setText("");
        }else{
            tvVerse.setText(verse + ", ");
        }
    }
    public void onInputNumbers(int num){
        if(num == 0 && inputVerse == null){
            tvVerse.setText("");
        }else{
            inputVerse = tvVerse.getText().toString();
            verse = inputVerse + num;
            tvVerse.setText(verse);
        }

    }

    public void allClear(View view){
        tvVerse.setText("");
        verse = "";
        inputVerse = null;
    }
    public void onInputVerse(View view){
        if(verse == ""){
            Toast.makeText(this, "Please input Verse", Toast.LENGTH_SHORT).show();
        }else{
            String books = verses + verse;
            saveToSharedPref(books);
            Intent theIntent = new Intent(Verses.this, MainActivity.class);
            startActivity(theIntent);
        }

    }

    private void saveToSharedPref(String book){
        Gson gson = new Gson();

        SharedPreferences aklatSharedPref = getSharedPreferences("bibiliyeah", Context.MODE_PRIVATE);
        String aklatData = aklatSharedPref.getString("MGA_AKLAT", null);

        ArrayList<String> data = new ArrayList<>();
        if(aklatData != null){
            data = gson.fromJson(aklatData, new TypeToken<List<String>>(){}.getType());
        }
        data.add(book);

        String dataString = gson.toJson(data);
        SharedPreferences.Editor editor = aklatSharedPref.edit();
        editor.putString("MGA_AKLAT", dataString);
        editor.commit();
    }
}