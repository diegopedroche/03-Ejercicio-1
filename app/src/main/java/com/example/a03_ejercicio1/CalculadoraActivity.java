package com.example.a03_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.StringTokenizer;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView lbResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        lbResultado = findViewById(R.id.lbResultadoCalculadora);

        //OBTENER LA UNFORMACION ENVIADA
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            String frase = bundle.getString("FRASE");
            int operacion = bundle.getInt("OPERACION");

            if(operacion == R.id.btnPalabrasMain){
                int resultado = contarPalabras(frase);
                lbResultado.setText("Palabras: " + resultado);
            }else if(operacion == R.id.btnCaracteresMain) {
                int resultado = contarCaracteres(frase);
                lbResultado.setText("Caracteres: " + resultado);
            }
        }
    }

    private int contarCaracteres(String frase) {
        return frase.length();
    }

    private int contarPalabras(String frase) {
        StringTokenizer stringTokenizer= new StringTokenizer(frase);
        return stringTokenizer.countTokens();
    }
}