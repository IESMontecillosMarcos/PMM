
package com.example.actividad4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Falta por implementar.
    // - El telefono intenta dominar el mundo (pendiente de SKynet).

    // Errores conocidos.

    // Atts.
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText);
        addLetter();
    }

    public void addLetter(){
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(text.length() == 8) {
                    char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
                    String textDni = text.getText().toString();
                    int dni = Integer.parseInt(textDni);
                    int val = dni%23;
                    textDni = textDni+letras[val];
                    text.setText(textDni);
                }
            }
        });
    }
}




