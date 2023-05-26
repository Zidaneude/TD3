package com.udeintech.td3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView level,score,nombre_launch_lavel_activity;
    static  int nbreclick=0;
    static  int nbrelevel=1;
    private Button btn_left;
    private Button btn_rigth;
    public  static  int old_size=1;
    public final static String EXTRA_LEVEL = "EXTRA_LEVEL";
    public final static int NUMBER_OF_LAUNCHES_REQUEST =2;
    public final static int MAIN_ACTIVITY_LAUNCH_SETTINGS =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level=findViewById(R.id.tv_level);
        nombre_launch_lavel_activity=findViewById(R.id.tv_number_of_launch2);
        score=findViewById(R.id.tv_score);
        nombre_launch_lavel_activity.setText(""+0);
        btn_left=findViewById(R.id.bt_left);
        btn_rigth=findViewById(R.id.bt_righ);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.settings_action:
                Intent intent=new Intent(MainActivity.this,Settings.class);
                intent.putExtra("old_size",old_size);
                startActivityForResult(intent,MAIN_ACTIVITY_LAUNCH_SETTINGS);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void scoreChange(View view)
    {
        nbreclick+=1;

        score.setText("Score:"+Integer.toString(nbreclick));
        if (nbreclick%5==0)
        {
            nbrelevel+=1;

            level.setText("Level:"+Integer.toString(nbrelevel));
            Intent intent=new Intent(MainActivity.this,LevelActivity.class);
            intent.putExtra(EXTRA_LEVEL,nbrelevel);
            startActivityForResult(intent, NUMBER_OF_LAUNCHES_REQUEST);
        }


    }
    public void resetAction(View view)
    {
        score=findViewById(R.id.tv_score);
        level=findViewById(R.id.tv_level);
        nbreclick=0;
        nbrelevel=1;
        score.setText("Score:0");
        level.setText("Level:1");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.i("","");
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.i("","");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("","");
    }

    @Override
    protected void onPause() {
        Log.i("","");
        super.onPause();
    }

    @Override
    protected void onStop() {

        Log.i("","");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("","");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == NUMBER_OF_LAUNCHES_REQUEST && resultCode == RESULT_OK) {
            int launches = data.getIntExtra(LevelActivity.EXTRA_LAUCNCH, 0);
            nombre_launch_lavel_activity.setText("nombre d'appel de oncreate:"+launches );
        }
        if (requestCode == MAIN_ACTIVITY_LAUNCH_SETTINGS && resultCode == RESULT_OK) {
            int code = data.getIntExtra(Settings.BTN_CHAINE, 0);
            switch (code)
            {
                case 10:
                    Log.i("petit","petit dans main");
                    score.setTextSize(10);
                    btn_rigth.setTextSize(10);
                    btn_left.setTextSize(10);
                    old_size=1;
                    break;
                case 11:
                    Log.i("moyen","moyen dans main");
                    score.setTextSize(15);
                    btn_rigth.setTextSize(15);
                    btn_left.setTextSize(15);
                    old_size=2;
                    break;
                case 12:
                    Log.i("grand","grand dans main");
                    score.setTextSize(25);
                    btn_rigth.setTextSize(25);
                    btn_left.setTextSize(25);
                    old_size=3;
                    break;
                default:
                    break;
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}