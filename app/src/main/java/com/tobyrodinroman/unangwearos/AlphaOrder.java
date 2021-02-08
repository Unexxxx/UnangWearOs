package com.tobyrodinroman.unangwearos;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

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
                Intent intent = new Intent(AlphaOrder.this, MgaAklat1.class);
                startActivity(intent);
                break;
            case "h-n":
                Intent intent1 = new Intent(AlphaOrder.this, MgaAklat2.class);
                startActivity(intent1);
                break;
            case "o-u":
                Intent intent2 = new Intent(AlphaOrder.this, MgaAklat3.class);
                startActivity(intent2);
                break;
            case "v-z":
                Intent intent3 = new Intent(AlphaOrder.this, MgaAklat4.class);
                startActivity(intent3);
                break;
        }
    }

}