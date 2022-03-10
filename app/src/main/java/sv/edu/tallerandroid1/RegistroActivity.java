package sv.edu.tallerandroid1;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText Nombreusuario, Contrasena, RepContra;
    Button bnt_registro;
    TextView iniciar_Sesion;
    NewDB dsDB;

    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.registro);

        Nombreusuario = (EditText) findViewById(R.id.nombreUsuario);
        Contrasena = (EditText) findViewById(R.id.contra);
        RepContra = (EditText) findViewById(R.id.confirmar_contra);

        iniciar_Sesion = (TextView) findViewById(R.id.inicioseccion);
        dsDB = new NewDB(this);
        bnt_registro = (Button) findViewById(R.id.btn_registrarse);

        bnt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Usuario = Nombreusuario.getText().toString();
                String Contra = Contrasena.getText().toString();
                String confiContra = RepContra.getText().toString();

                if (Usuario.equals("") || Contra.equals("") || confiContra.equals("")){
                    Toast.makeText(RegistroActivity.this, "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();

                }else{
                    if(Contra.equals(confiContra))
                    {
                        Boolean verifyUsuariodata= dsDB.verifyNombreUsuario(Usuario);

                        if(verifyUsuariodata== false)
                        {
                            Boolean Resdata = dsDB.insertarDatos(Usuario,Contra);

                            if(Resdata == true){
                                Toast.makeText(RegistroActivity.this, "Registro Completo!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(RegistroActivity.this, "El registro no pudo ser completado", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegistroActivity.this, "Esta cuenta ya existe/\n Por favor, iniciar sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistroActivity.this, "Digite correctamente las contraseñas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        iniciar_Sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
