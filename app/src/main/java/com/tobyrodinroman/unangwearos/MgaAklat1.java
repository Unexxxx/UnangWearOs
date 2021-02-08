package com.tobyrodinroman.unangwearos;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MgaAklat1 extends WearableActivity {

    ListView lvVerse;
    String[] verses = {"Amos","Ang Awit ni Solomon","Ang Mangangaral","Awit","Bilang","Colosas","1 Corinto","2 Corinto","1 Cronica","2 Cronica","Daniel","Deuteronomio","Efeso","Ester","Exodo","Ezekiel","Ezra","Filemon","Filipos","Galacia","Gawa","Genesis"};
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
                Intent theIntent = new Intent(MgaAklat1.this, Chapters.class);
                theIntent.putExtra("aklat", value);
                startActivity(theIntent);
            }
        });





        // Enables Always-on
//        setAmbientEnabled();
    }


}