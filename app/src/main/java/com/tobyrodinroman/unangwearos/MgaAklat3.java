package com.tobyrodinroman.unangwearos;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MgaAklat3 extends WearableActivity {

    ListView lvVerse;
    String[] verses = {"Obadias","Pahayag","Panaghoy","1 Pedro","2 Pedro","Roma","Ruth","1 Samuel","2 Samuel","Santiago","1 Tesalonica","2 Tesalonica","1 Timoteo","2 Timoteo","Tito"};
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
                Intent theIntent = new Intent(MgaAklat3.this, Chapters.class);
                theIntent.putExtra("aklat", value);
                startActivity(theIntent);
            }
        });





        // Enables Always-on
//        setAmbientEnabled();
    }


}