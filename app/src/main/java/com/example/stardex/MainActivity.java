package com.example.stardex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtPesoEnv,edtValorEnv,edtPeso;
    Button btnCalcular, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.edtPeso);
        //edtPesoEnv = (EditText) findViewById(R.id.edtPesoEnv);
        //edtValorEnv = (EditText) findViewById(R.id.edtPesoEnv);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(EnviarDados());

    }
    private View.OnClickListener EnviarDados() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Bundle Dados;
                if (!(edtPeso.getText().toString().isEmpty())) {
                    Dados = new Bundle();

                    int valPeso = Integer.parseInt(edtPeso.getText().toString());
                    Dados.putInt("Peso", valPeso);
                    Intent telaCalculo = new Intent(MainActivity.this, CalcularValor.class);
                    telaCalculo.putExtras(Dados);
                    startActivity(telaCalculo);
                } else {
                    Toast Aviso = Toast.makeText(getApplicationContext(),
                    "informe um valor de no minimo 1kg",Toast.LENGTH_LONG);
                    Aviso.show();
                }

            }

        };
        }
    }