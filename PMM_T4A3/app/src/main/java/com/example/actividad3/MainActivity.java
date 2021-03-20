package com.example.actividad3;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Falta por implementar.

    // Errores conocidos.
    // - Las imagenes no pueden ser muy pesadas, poca reso o tamanio. (Solo con moviles antiguos o >Android8.1(?))


    // Atts.
    private RecyclerView recyclerView;
    private Button btnAceptar;
    private int[] images = {R.drawable.tv, R.drawable.telefono, R.drawable.tablet, R.drawable.torre, R.drawable.portatil,
            R.drawable.reloj};
    private ArrayList<Model> item_list = new ArrayList<>();
    private ModelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private void initControls() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        item_list.add(new Model("Television", false, images[0]));
        item_list.add(new Model("Telefono Movil", false, images[1]));
        item_list.add(new Model("Tableta", false, images[2]));
        item_list.add(new Model("Ordenador fijo", false, images[3]));
        item_list.add(new Model("Ordenador portatil", false,images[4]));
        item_list.add(new Model("Reloj", false, images[5]));


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ModelAdapter(item_list);
        recyclerView.setAdapter(mAdapter);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "";
                for (int j=0; j<item_list.size();j++) {
                    if (item_list.get(j).isSelected() == true) {
                        data = data + "\n" + item_list.get(j).getItemName().toString();
                    }
                }
                Toast.makeText(getBaseContext(), "Has seleccionado:\n " + data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}