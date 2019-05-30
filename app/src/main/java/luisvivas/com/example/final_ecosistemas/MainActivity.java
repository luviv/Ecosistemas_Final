package luisvivas.com.example.final_ecosistemas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titulo;
    private ImageView logo;
    private EditText usuario;
    private EditText contra;
    private Button inicio;
    private ImageButton google;
    private TextView nocuenta;
    private Button registrar;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        titulo = findViewById(R.id.tv_titulo_main);
        logo = findViewById(R.id.img_logo_main);
        usuario = findViewById(R.id.edt_usuario_main);
        contra = findViewById(R.id.edt_contra_main);
        inicio = findViewById(R.id.btn_inicio_main);
        google = findViewById(R.id.btn_google_main);

        registrar = findViewById(R.id.btn_registrarse_main);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        inicio.setOnClickListener(this);

        nocuenta = findViewById(R.id.tv_cuenta_main);
    }

    private void logearUsuario() {

        String email = usuario.getText().toString().trim();
        String contraseña = contra.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un e-mail", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(contraseña)) {
            Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Iniciando sesión...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "¡Bienvenido! " + usuario.getText(), Toast.LENGTH_LONG).show();
                } else {
                    //Si un usuario intenta ingresar una contraseña que no coincide
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(MainActivity.this, "La contraseña no coincide, por favor vuelve a intentarlo", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No se pudo iniciar sesión", Toast.LENGTH_LONG).show();
                    }
                }

                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        logearUsuario();
    }

}