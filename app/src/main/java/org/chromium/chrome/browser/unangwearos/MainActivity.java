package org.chromium.chrome.browser.unangwearos;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
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
public class MainActivity extends WearableActivity {
    ListView lvVerse;
    ArrayAdapter<String> verseArrayAdapter;
    String[] mStringArray = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvVerse = findViewById(R.id.lvVerse);

        SharedPreferences aklatSharedPref = getSharedPreferences("bibiliyeah", Context.MODE_PRIVATE);
        String aklatData = aklatSharedPref.getString("MGA_AKLAT", null);
        Gson gson = new Gson();
        List<String> data = new ArrayList<>();
        if(aklatData != null){
            data = gson.fromJson(aklatData, new TypeToken<List<String>>(){}.getType());
        }
        mStringArray = new String[data.size()];
        mStringArray = (String[]) data.toArray(mStringArray);
        verseArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStringArray);
        lvVerse.setAdapter(verseArrayAdapter);
        lvVerse.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences aklatSharedPref = getSharedPreferences("bibiliyeah", Context.MODE_PRIVATE);
                String aklatData = aklatSharedPref.getString("MGA_AKLAT", null);
                Gson gson = new Gson();
                List<String> data = new ArrayList<>();
                if(aklatData != null){
                    data = gson.fromJson(aklatData, new TypeToken<List<String>>(){}.getType());
                }
                for(String itemString: data){
                    if(mStringArray[i].equalsIgnoreCase(itemString)){
                        data.remove(i);
                    }
                }
                mStringArray = new String[data.size()];
                mStringArray = (String[]) data.toArray(mStringArray);
                verseArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mStringArray);
                lvVerse.setAdapter(verseArrayAdapter);
                saveToSharedPref(data);
                return false;
            }
        });
        // Enables Always-on
//        setAmbientEnabled();
    }
    public void onClickAdd(View view){
        Intent intent = new Intent(MainActivity.this,AlphaOrder.class);
        startActivity(intent);
    }
    private void saveToSharedPref(List<String> wholeData){
        Gson gson = new Gson();
        String wholeDataString = gson.toJson(wholeData);
        SharedPreferences aklatSharedPref = getSharedPreferences("bibiliyeah", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = aklatSharedPref.edit();
        editor.putString("MGA_AKLAT", wholeDataString);
        editor.apply();
    }
}