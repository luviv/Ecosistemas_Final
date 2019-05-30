package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PruebasActivity extends AppCompatActivity {

    private ImageView prueba1;
    private ImageView prueba2;
    private ImageView prueba3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);

        prueba1 = findViewById(R.id.imv_prueba1_pruebas);
        prueba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PruebasActivity.this, LaboratorioActivity.class));
            }
        });
    }
}
