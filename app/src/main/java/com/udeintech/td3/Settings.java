package com.udeintech.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton_petit;
    private RadioButton radioButton_moyen;
    private RadioButton radioButton_grand;

    public  static final  int BTN_PETIT=10;
    public  static final  int BTN_MOYEN=11;
    public  static final  int BTN_GRAND=12;
    public  static  int BTN_SELECT=0;
    public  static String BTN_CHAINE="BTN_CHAINE";
//    public  static String PETIT="PETIT";
////    public  static String MOYEN="MOYEN";
////    public  static String GRAND="GRAND";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("reglages");
        radioButton_petit=findViewById(R.id.radio_petit);
        radioButton_moyen=findViewById(R.id.radio_moyen);
        radioButton_grand=findViewById(R.id.radio_grand);
        radioGroup=findViewById(R.id.radio_group);
        int old_size=getIntent().getIntExtra("old_size",1);
        if (old_size==1)
        {
            radioButton_petit.setChecked(true);
        }
        if (old_size==2)
        {
            radioButton_moyen.setChecked(true);
        }
        if (old_size==3)
        {
            radioButton_grand.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radio_petit:
                        petit(radioGroup);
                        break;
                    case R.id.radio_moyen:
                        moyen(radioGroup);
                        break;
                    case R.id.radio_grand:
                        grand(radioGroup);
                        break;
                    default:
                        break;
                }
            }
        });
    }
   public  void petit(View view)
   {

        Intent data = new Intent();
        BTN_SELECT=BTN_PETIT;
        data.putExtra(BTN_CHAINE,BTN_SELECT);
        setResult(RESULT_OK,data);
        finish();
    }
    public  void moyen(View view)
    {
        Intent data = new Intent();
        BTN_SELECT=BTN_MOYEN;
        data.putExtra(BTN_CHAINE,BTN_SELECT);
        setResult(RESULT_OK,data);
        finish();
    }
    public  void grand(View view)
    {
        Intent data = new Intent();
        BTN_SELECT=BTN_GRAND;
        data.putExtra(BTN_CHAINE,BTN_SELECT);
        setResult(RESULT_OK,data);
        finish();
    }
}