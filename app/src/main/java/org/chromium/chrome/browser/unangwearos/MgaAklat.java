package org.chromium.chrome.browser.unangwearos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MgaAklat extends WearableActivity {

    ListView lvVerse;
    String[] verses = {"1 Pedro","Juan", "Gawa", "Awit", "Roma", "1 Korinto"};
    ArrayAdapter<String> verseS;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mga_aklat);

        lvVerse = findViewById(R.id.lvVerse);
        verseS = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, verses);
        lvVerse.setAdapter(verseS);

        lvVerse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String books = verseS.getItem(position);
                saveToSharedPref(books);

                Intent intent = new Intent(MgaAklat.this, MainActivity.class);
                startActivity(intent);
            }
        });





        // Enables Always-on
//        setAmbientEnabled();
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