package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MemoriaActivity extends AppCompatActivity {

    private ImageView documento;
    private ImageView contenido;
    private ImageView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        prueba = findViewById(R.id.imv_prueba__memoria);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemoriaActivity.this, PruebasActivity.class));
            }
        });
    }
}
