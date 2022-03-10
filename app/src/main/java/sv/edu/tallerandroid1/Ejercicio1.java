package sv.edu.tallerandroid1;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    EditText valora,valorb,valorc;
    TextView mostrar;
    Button Calcular;
    Double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        valora = (EditText) findViewById(R.id.value_a);
        valorb = (EditText) findViewById(R.id.value_b);
        valorc = (EditText) findViewById(R.id.value_c);
        mostrar = (TextView) findViewById(R.id.result);
        Calcular = (Button) findViewById(R.id.cuadratica);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(String.valueOf(valora.getText()));
                b = Double.parseDouble(String.valueOf(valorb.getText()));
                c = Double.parseDouble(String.valueOf(valorc.getText()));

                Double test= a * c;
                Double raiz = (Math.pow(b,2) - (4 * test));
                Double x1;
                Double x2;
                Double data = Math.sqrt(raiz);

                if (a != 0){
                    if (raiz < 0){
                        Toast.makeText(Ejercicio1.this, "La raiz no es valida", Toast.LENGTH_SHORT).show();
                    }else {
                        x1 = ((-b) + data) / (2 * a);

                        x2 = ((-b) - data) / (2 * a);
                            mostrar.setText("Variable X1 =" + String.format("%.3f", x1) + "\n" + "Variable X2 =" + String.format("%.3f", x2));

                    }
                }
            }
        });

    }
}