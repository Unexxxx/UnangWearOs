package org.chromium.chrome.browser.unangwearos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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


                String value = (String) parent.getItemAtPosition(position);
                Intent theIntent = new Intent(MgaAklat.this, Chapters.class);
                theIntent.putExtra("aklat", value);
                startActivity(theIntent);
            }
        });





        // Enables Always-on
//        setAmbientEnabled();
    }


}