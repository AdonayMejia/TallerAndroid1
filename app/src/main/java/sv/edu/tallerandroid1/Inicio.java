package sv.edu.tallerandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Inicio extends AppCompatActivity {

    ImageView ejercicio1, ejercicio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ejercicio1 = (ImageView) findViewById(R.id.img1);
        ejercicio2 = (ImageView) findViewById(R.id.img2);

        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ejercicio1.class);
                startActivity(intent);
            }
        });

        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ejercicio2.class);
                startActivity(intent);
            }
        });

    }


}