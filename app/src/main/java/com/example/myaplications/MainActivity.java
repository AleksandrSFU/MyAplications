package com.example.myaplications;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String stingURL = "index.html";
    public static final String chekWEB = "false";
    public static final String stingBit = "115200";
    public static final String stingPaswrd = "1234";
    private String SHARED_PREF = "";
    private String URLload;
    private boolean Checked;
    private String loafBIT;
    private String Paswrd;
    private EditText editURL;
    private CheckBox checkWEB;
    private EditText editRate;
    private EditText editPaswrd;
    private Button loadSettings;
    private Button saveSettings;
    private Button resetSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editURL = (EditText) findViewById(R.id.editURL);
        checkWEB = (CheckBox) findViewById(R.id.checkBox1);
        editRate = (EditText) findViewById(R.id.editText2);
        editPaswrd = (EditText) findViewById(R.id.editText3);
        loadSettings  = (Button) findViewById(R.id.loadSettings);
        saveSettings = (Button) findViewById(R.id.saveSettings);
        resetSettings = (Button) findViewById(R.id.resetSettings);

        resetSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetData();
            }
        });
        saveSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
        loadSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
        loadData();
        updateData();
    }
    public void  resetData(){
        editURL.setText(stingURL);
        checkWEB.setChecked(false);
        editRate.setText(stingBit);
        editPaswrd.setText(stingPaswrd);
    }
    public void  saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(stingURL, editURL.getText().toString());
        editor.putBoolean(chekWEB, checkWEB.isChecked());
        editor.putString(stingBit, editRate.getText().toString());
        editor.putString(stingPaswrd, editPaswrd.getText().toString());
        editor.apply();
        Toast.makeText(this,"Сохранено", Toast.LENGTH_SHORT).show();
    }
    public void  loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        URLload = sharedPreferences.getString(stingURL,"");
        Checked = sharedPreferences.getBoolean(chekWEB, false);
        loafBIT = sharedPreferences.getString(stingBit,"");
        Paswrd = sharedPreferences.getString(stingPaswrd,"");
    }
    public void updateData(){
        editURL.setText(URLload);
        checkWEB.setChecked(Checked);
        editRate.setText(loafBIT);
        editPaswrd.setText(Paswrd);
    }
}