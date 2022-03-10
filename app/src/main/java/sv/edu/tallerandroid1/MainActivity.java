package sv.edu.tallerandroid1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText NombreUsuario,Contrasena;
    Button bnt_iniciar;
    TextView registro;
    NewDB dsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NombreUsuario = (EditText) findViewById(R.id.UsuarioInicio);
        Contrasena = (EditText) findViewById(R.id.contrasena_Inicio);
        bnt_iniciar = (Button) findViewById(R.id.btn_iniciosesion);
        registro = (TextView) findViewById(R.id.registrarse);

        dsDB = new NewDB(this);

        bnt_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Usuario = NombreUsuario.getText().toString();
                String Contra = Contrasena.getText().toString();

                if (Usuario.equals("") || Contra.equals("")){
                    Toast.makeText(MainActivity.this,"Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean data= dsDB.verifyContrauser(Usuario,Contra);

                    if(data == true){
                        Intent intent = new Intent(getApplicationContext(), Inicio.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Los datos ingresados no son validos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}