package sv.edu.tallerandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {

    EditText Votos;
    Button ContarVotos;
    TextView TotalVotos;
    int Count1=0,Count2=0,Count3=0,Count4=0,CantTotalVotos=0, VotosInvalidos=0;
    Double PrCan1, PrCan2,PrCan3,PrCan4,PrVotosInvalidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Votos = (EditText) findViewById(R.id.NumVotos);
        ContarVotos = (Button) findViewById(R.id.BtnCalcular);
        TotalVotos = (TextView) findViewById(R.id.ViewDatos);

        ContarVotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Count1=0;
                Count2=0;
                Count3=0;
                Count4=0;
                CantTotalVotos=0;
                Votos.setError(null);
                if(Votos.getText().toString().equals("")){
                    Votos.setError("Ingrese el numero del candito las veces necesarias separadas por coma" + "\n"+ "Formato valido (1,1,2,3)");
                    Votos.requestFocus();
                    return;
                }else {

                    String[] conteo = Votos.getText().toString().split(",");
                    for (int d = 0; d < conteo.length; d++) {

                        if(conteo[d].equals("1")){
                            Count1++;
                        }else if(conteo[d].equals("2")){
                            Count2++;
                        }else if(conteo[d].equals("3")){
                            Count3++;
                        }else if(conteo[d].equals("4")){
                            Count4++;
                        }

                    }

                    CantTotalVotos=Count1+Count2+Count3+Count4+VotosInvalidos;

                    PrCan1= (Count1 / Double.parseDouble(String.valueOf(CantTotalVotos)))*100;
                    PrCan2= (Count2 / Double.parseDouble(String.valueOf(CantTotalVotos)))*100;
                    PrCan3= (Count3 / Double.parseDouble(String.valueOf(CantTotalVotos)))*100;
                    PrCan4= (Count4 / Double.parseDouble(String.valueOf(CantTotalVotos)))*100;
                    PrVotosInvalidos= (VotosInvalidos / Double.parseDouble(String.valueOf(CantTotalVotos)))*100;

                    TotalVotos.setText(" #1 - Votos: " + Count1 + " con  porcentaje del " + String.format("%.2f", PrCan1) + "%" + "\n"+"\n"
                            + " #2 - Votos: " + Count2 + " con  porcentaje del " + String.format("%.2f", PrCan2) + "%" + "\n"+ "\n"
                            + " #3 - Votos: " + Count3 + " con  porcentaje del " + String.format("%.2f", PrCan3) + "%" + "\n" + "\n" +
                            " #4 - Votos: " + Count4 + " con  porcentaje del " + String.format("%.2f", PrCan4) + "%" + "\n" + "\n"
                    );
                }
            }
        });

    }
}