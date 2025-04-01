package br.fecap.ads.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btnSet;
    private Button btnReset;
    private EditText campoAltura;
    private EditText campoPeso;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculaIMC(View view){

        // Vinculando os elementos com os Views
        btnSet  = findViewById(R.id.btnSet);
        btnReset = findViewById(R.id.btnReset);
        campoAltura = findViewById(R.id.editTextAltura);
        campoPeso = findViewById(R.id.editTextPeso);
        textResultado = findViewById(R.id.textResultado);

        // Variaveis para recuperar (get) e converter em String:
        String altura = campoAltura.getText().toString();
        String peso = campoPeso.getText().toString();

        // Converter os dados para Numerico:
        Double numAltura = Double.parseDouble(altura);
        Double numPeso = Double.parseDouble(peso);
        Double numImc = numPeso / (numAltura * numAltura);

        // Converter o resultado numImc -> String imc
        //String imc = String.valueOf(numImc);

        DecimalFormat df = new DecimalFormat("##.##");
        String imc = df.format(numImc);

        // Apresentar o resultado:
        textResultado.setText(imc + "kg/m²");

    }

}