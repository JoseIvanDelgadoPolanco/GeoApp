package com.example.user.geoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.model.Pregunta;

public class GeoActivity extends AppCompatActivity {
    Button mBotonCierto;
    Button mBotonFalso;
    Button mBotonSiguiente;
    TextView mTextoPregunta;
    private Pregunta mBancoDePreguntas[] = {
            new Pregunta(R.string.texto_pregunta_1, false),
            new Pregunta(R.string.texto_pregunta_2, true),
            new Pregunta(R.string.texto_pregunta_3, true),
            new Pregunta(R.string.texto_pregunta_4, true),
            new Pregunta(R.string.texto_pregunta_5, false),
    };
    private int mPreguntaActual = 0;

    private void actualizarPregunta() {
        int preguntaActual = mBancoDePreguntas[mPreguntaActual].getIdResTexto();
        mTextoPregunta.setText(preguntaActual);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);

        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(true);
            }
        });
        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(false);
            }
        });

        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                mPreguntaActual = mPreguntaActual + 1;
                if (mPreguntaActual == mBancoDePreguntas.length) {
                    mPreguntaActual = 0;
                }
                actualizarPregunta();
            }
        });
    }

    private void verificarRespuesta(boolean botonOprimido) {
        boolean respuestaEsVerdadera = mBancoDePreguntas[mPreguntaActual].isRespuestaVerdadera();
        if (botonOprimido == respuestaEsVerdadera) {
            Toast.makeText(GeoActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(GeoActivity.this, R.string.texto_incorrecto, Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
