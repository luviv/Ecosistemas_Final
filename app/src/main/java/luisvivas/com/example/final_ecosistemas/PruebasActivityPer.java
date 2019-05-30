package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PruebasActivityPer extends AppCompatActivity {

    private Comunicacion ref;
    private ImageView prueba1;
    private ImageView prueba2;
    private ImageView prueba3;
    private boolean PruebaP1Open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);

        //PruebaP1Open = ref.getContadorPV1();
        prueba1 = findViewById(R.id.imv_prueba1_pruebas);
        prueba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if(PruebaP1Open ==true){
                    startActivity(new Intent(PruebasActivityPer.this, LaboratorioActivity.class));

                }else{
                    Toast.makeText(PruebasActivityPer.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                }
                */
                startActivity(new Intent(PruebasActivityPer.this, LaboratorioActivity.class));
            }
        });
    }
}
