package com.example.actividad4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.counterCharacter);
        changeText();
    }

    public void changeText(){
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text.length() == 4) {
                    text.append("-");
                }else if(text.length() == 9){
                    text.append("-");
                }else if(text.length() == 14){
                    text.append("-");
                }
                if(text.length() <= 18){
                    text.setTextColor(Color.RED);
                }
                else if(text.length() >= 19){
                    text.setTextColor(Color.GREEN);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable text) {
                // TODO Auto-generated method stub
            }
        });
    }






}