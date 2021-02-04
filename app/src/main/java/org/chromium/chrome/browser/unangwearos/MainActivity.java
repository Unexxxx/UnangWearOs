package org.chromium.chrome.browser.unangwearos;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends WearableActivity {

    ListView rvVerse;
    ArrayAdapter<String> verseArrayAdapter;
    String[] mStringArray = null;
    ImageButton ivAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVerse = findViewById(R.id.rv_verse);
        ivAdd = findViewById(R.id.ivAdd);


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
        rvVerse.setAdapter(verseArrayAdapter);
        rvVerse.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences aklatSharedPref = getSharedPreferences("bibiliyeah", Context.MODE_PRIVATE);
                String aklatData = aklatSharedPref.getString("MGA_AKLAT", null);
                Gson gson = new Gson();
                List<String> data = new ArrayList<>();
                if(aklatData != null){
                    data = gson.fromJson(aklatData, new TypeToken<List<String>>(){}.getType());
                }

                //remove data from listview
                data.remove(mStringArray[i]);
                verseArrayAdapter.notifyDataSetChanged();

                mStringArray = new String[data.size()];
                mStringArray = (String[]) data.toArray(mStringArray);
                verseArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mStringArray);
                rvVerse.setAdapter(verseArrayAdapter);
                saveToSharedPref(data);
                return false;
            }
        });
        rvVerse.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int btn_initPosY = ivAdd.getScrollY();
                if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    ivAdd.animate().cancel();
                    ivAdd.animate().translationYBy(150);
                }else if (scrollState == SCROLL_STATE_FLING) {
                    ivAdd.animate().cancel();
                    ivAdd.animate().translationYBy(150);
                } else {
                    ivAdd.animate().cancel();
                    ivAdd.animate().translationY(btn_initPosY);
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
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