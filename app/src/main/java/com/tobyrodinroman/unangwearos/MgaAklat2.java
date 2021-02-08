package com.tobyrodinroman.unangwearos;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MgaAklat2 extends WearableActivity {

    ListView lvVerse;
    String[] verses = {"Habakkuk","Hagai","1 Hari","2 Hari","Hebreo","Hosea","Hukomt","Isaias","Jeremias","Job","Joel","Jonas","Josue","Juan","1 Juan","2 Juan","3 Juan","Judas","Kawikaan","Levitico","Lucas","Malakias","Marcos","Mateo","Mikas","Nahum","Nehemias"};
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
                Intent theIntent = new Intent(MgaAklat2.this, Chapters.class);
                theIntent.putExtra("aklat", value);
                startActivity(theIntent);
            }
        });






    }


}