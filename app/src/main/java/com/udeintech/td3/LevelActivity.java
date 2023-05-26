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

public class LevelActivity extends AppCompatActivity {
    private TextView level2;
    private TextView tv_launch_count;
    private Button btn;
    public  static  int old_size=1;
    public static int number_launch = 0;
    public static String EXTRA_LAUCNCH = "EXTRA_LAUCNCH";
    public final static int LEVEL_ACTIVITY_LAUNCH_SETTINGS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        number_launch += 1;
        Intent intent = getIntent();
        int level = intent.getIntExtra(MainActivity.EXTRA_LEVEL, 1);
        level2 = findViewById(R.id.tv_level2);
        btn = findViewById(R.id.button);
        level2.setText("Level:"+Integer.toString(level));

        tv_launch_count = findViewById(R.id.tv_launch_count);
        tv_launch_count.setText("Nombre d'appel de oncreate:"+Integer.toString(number_launch));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_action:
                Intent intent = new Intent(LevelActivity.this, Settings.class);
                intent.putExtra("old_size",old_size);
                startActivityForResult(intent, LEVEL_ACTIVITY_LAUNCH_SETTINGS);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.i("", "");
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.i("", "");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("", "");
    }

    @Override
    protected void onPause() {
        Log.i("", "");
        super.onPause();
    }

    @Override
    protected void onStop() {

        Log.i("", "");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("", "");
        super.onDestroy();
    }

    public void backaction(View view) {
        finish();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra(EXTRA_LAUCNCH, number_launch);
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == LEVEL_ACTIVITY_LAUNCH_SETTINGS && resultCode == RESULT_OK) {
            int code = data.getIntExtra(Settings.BTN_CHAINE, 0);
            switch (code) {
                case 10:
                    Log.i("petit", "petit dans level");
                    level2.setTextSize(12);
                    tv_launch_count.setTextSize(12);
                    old_size=1;
                    btn.setTextSize(12);

                    break;
                case 11:
                    Log.i("moyen", "moyen dans level");
                    level2.setTextSize(15);
                    tv_launch_count.setTextSize(15);
                    btn.setTextSize(15);
                    old_size=2;
                    break;
                case 12:
                    Log.i("grand", "grand dans level");
                    level2.setTextSize(25);
                    tv_launch_count.setTextSize(25);
                    btn.setTextSize(25);
                    old_size=3;
                    break;
                default:
                    break;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}