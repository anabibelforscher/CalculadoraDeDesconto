package com.anabibelforscher.calculadoradedesconto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textDesconto;
    private TextView textTotal;
    private SeekBar seekBarDesconto;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textDesconto = findViewById(R.id.textDesconto);
        textTotal = findViewById(R.id.textTotal);
        seekBarDesconto = findViewById(R.id.seekBarDesconto);

        seekBarDesconto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar desconto, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcularDesconto();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcularDesconto (){
        String valorInformado = editValor.getText().toString();
        if (valorInformado == null || valorInformado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Informe um valor da compra!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            double precoDigitado = Double.parseDouble(valorInformado);
            double valorDesconto = precoDigitado*(porcentagem/100);
            double total = precoDigitado-valorDesconto;

            textDesconto.setText("R$ "+ valorDesconto);
            textTotal.setText("R$ "+ total);

        }

    }
}