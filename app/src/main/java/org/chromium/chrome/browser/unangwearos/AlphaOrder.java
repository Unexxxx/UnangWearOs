package org.chromium.chrome.browser.unangwearos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Toast;

public class AlphaOrder extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_order);

    }

    public void onClickOrder(View view){
        switch (view.getId()){
            case R.id.btnA:
                aOrder("a-g");
                break;
            case R.id.btnH:
                aOrder("h-n");
                break;
            case R.id.btnO:
                aOrder("o-u");
                break;
            case R.id.btnV:
                aOrder("v-z");
                break;

        }
    }

    public void aOrder(String aOrder){
        switch (aOrder){
            case "a-g":
                Toast.makeText(this, "This is A-G!!!", Toast.LENGTH_LONG).show();
                mgaAklat();
                break;
            case "h-n":
                Toast.makeText(this, "This is H-N!!!", Toast.LENGTH_LONG).show();
                mgaAklat();
                break;
            case "o-u":
                Toast.makeText(this, "This is O-U!!!", Toast.LENGTH_LONG).show();
                mgaAklat();
                break;
            case "v-z":
                Toast.makeText(this, "This is V-Z!!!", Toast.LENGTH_LONG).show();
                mgaAklat();
                break;
        }
    }

    public void mgaAklat(){
        Intent intent = new Intent(AlphaOrder.this,MgaAklat.class);
        startActivity(intent);
    }
}