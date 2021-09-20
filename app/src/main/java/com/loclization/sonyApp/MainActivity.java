package com.loclization.sonyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txt_hello;
    private Button btn_en, btn_ch, btn_hn;
    private Locale myLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txt_hello = (TextView)findViewById(R.id.txt_hello);
        this.btn_en = (Button) findViewById(R.id.btn_en);
        this.btn_ch = (Button)findViewById(R.id.btn_ch);
        this.btn_hn = (Button)findViewById(R.id.btn_hn);
        this.btn_en.setOnClickListener(this);
        this.btn_ch.setOnClickListener(this);
        this.btn_hn.setOnClickListener(this);

    }
// if you want to read from csv file use  changeLang method and inside this method read csv file from lang string match and
    // then show the text  getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics()); from replacing this
    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        updateTexts();
    }
    private void updateTexts()
    {
        txt_hello.setText(R.string.hello_world);

    }
    @Override
    public void onClick(View v) {
        String lang = "en";
        switch (v.getId()) {
            case R.id.btn_en:
                lang = "en";
                break;
            case R.id.btn_ch:
                lang = "ch";
                break;
            case R.id.btn_hn:
                lang = "hn";
                break;
            default:
                break;
        }
        changeLang(lang);
    }
    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (myLocale != null){
            newConfig.locale = myLocale;
            Locale.setDefault(myLocale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}