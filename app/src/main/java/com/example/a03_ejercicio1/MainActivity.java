package com.example.a03_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS PARA LAS VISTAS
    private EditText txtFrase;
    private Button btnPalabras;
    private Button btnCaracteres;

    //CONSTANTES
    public static final int PALABRAS = 1;
    public static final int CARACTERES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();
        //inicializaEventos();

    }

    private void inicializaEventos() {
        btnPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(PALABRAS);
            }
        });

        btnCaracteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(CARACTERES);
            }
        });
    }

    private void onclick(int palabras) {
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);
            bundle.putInt("OPERACION", palabras);
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Frase vacía", Toast.LENGTH_SHORT);
        }
    }

    private void inicializaVistas() {
        txtFrase = findViewById(R.id.txtFraseMain);
        btnCaracteres = findViewById(R.id.btnCaracteresMain);
        btnPalabras = findViewById(R.id.btnPalabrasMain);
    }

    public void onClickBotones(View boton){
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);
            bundle.putInt("OPERACION", boton.getId());
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Frase vacía", Toast.LENGTH_SHORT);
        }
    }
}