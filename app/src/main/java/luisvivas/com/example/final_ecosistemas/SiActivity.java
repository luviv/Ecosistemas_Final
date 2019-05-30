package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SiActivity extends AppCompatActivity {

    private Comunicacion ref;
    Button enviar;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si);
        ref = Comunicacion.getRef();



        enviar = findViewById(R.id.btn_enviar_si);
        edt = findViewById(R.id.edt_respuesta_si);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SiActivity.this, HomeActivity.class);
                startActivity(i);

                ref.enviar(edt.getText().toString().trim());
            }




        });
    }
}
