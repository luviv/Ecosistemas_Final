package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PruebasActivity extends AppCompatActivity {


    private Comunicacion ref;
    private ImageView prueba1;
    private ImageView prueba2;
    private ImageView prueba3;
    private boolean PruebaM1Open;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);


       // PruebaM1Open = ref.getContadorPM1();

        prueba1 = findViewById(R.id.imv_prueba1_pruebas);
        prueba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        /*        if(PruebaM1Open ==true){
                    Intent i = new Intent(PruebasActivity.this, LaboratorioActivity.class);
                    startActivity(i);
            }else{
                    Toast.makeText(PruebasActivity.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                }
                */

                Intent i = new Intent(PruebasActivity.this, LaboratorioActivity.class);
                startActivity(i);

            }
        });
    }
}
