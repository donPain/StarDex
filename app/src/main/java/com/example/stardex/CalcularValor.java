package com.example.stardex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CalcularValor extends AppCompatActivity {

    TextView txtPeso, txtValor;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_valor);

        txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtValor = (TextView) findViewById(R.id.txtValor);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent DadosRecebidos = getIntent();
        Bundle Dados = DadosRecebidos.getExtras();

        CalcularPreco(Dados.getInt("Peso"));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view){
            finish();
        }
        });
        }
    private void CalcularPreco(int peso){
        double PrecoPago = CalcularReal(peso);
        if(peso>5){
            txtValor.setText(String.valueOf("R$"+ peso +"M"));
        }else {
            txtValor.setText(String.valueOf("R$" + "993.085,60"));
        }
        txtPeso.setText(String.valueOf(peso)+"KG");
    }
    private double CalcularReal(int peso){
        return (double) (peso * 0.7);
    }
  }
