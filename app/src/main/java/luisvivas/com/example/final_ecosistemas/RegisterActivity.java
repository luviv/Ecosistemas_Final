package luisvivas.com.example.final_ecosistemas;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private TextView titulo;
    private ImageView logo;
    private EditText correo;
    private EditText contraseña;
    private Button enviar;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        titulo = findViewById(R.id.tv_titulo_register);
        logo = findViewById(R.id.imv_logo_register);
        correo = findViewById(R.id.edt_correo_register);
        contraseña = findViewById(R.id.edt_contra_register);
        enviar = findViewById(R.id.btn_registrar_register);

        enviar.setOnClickListener(this);

        back  = findViewById(R.id.imv_back_register);

         View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        };

        back.setOnClickListener(listener);
    }

    private void registrarUsuario() {
        String email = correo.getText().toString().trim();
        String contra = contraseña.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un e-mail", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(contra)) {
            Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, contra).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Se ha registrado el usuario con el e-mail: " + correo.getText(), Toast.LENGTH_LONG).show();
                } else {
                    //Si un usuario intenta registrar una cuenta ya existente
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(RegisterActivity.this, "El usuario ya existe, por favor use otro correo", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "No se pudo registrar al usuario", Toast.LENGTH_LONG).show();
                    }
                }

                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View v) {
        registrarUsuario();
    }
}
