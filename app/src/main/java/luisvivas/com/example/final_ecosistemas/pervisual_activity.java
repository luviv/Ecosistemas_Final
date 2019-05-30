package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class pervisual_activity extends AppCompatActivity {

    private Comunicacion ref;
    Button documentos;
    Button contenido;
    Button pruebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pervisual_activity);

        ref= Comunicacion.getRef();

        documentos = findViewById(R.id.btn_documentos_pervis);
        contenido = findViewById(R.id.btn_contenido_pervis);
        pruebas = findViewById(R.id.btn_pruebas_pervis);





        documentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pervisual_activity.this, "No disponible aún", Toast.LENGTH_LONG).show();
            }
        });


        contenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pervisual_activity.this, "No disponible aún", Toast.LENGTH_LONG).show();
            }
        });

    pruebas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(pervisual_activity.this, PruebasActivityPer.class);
            startActivity(i);
        }
    });

    }




}
