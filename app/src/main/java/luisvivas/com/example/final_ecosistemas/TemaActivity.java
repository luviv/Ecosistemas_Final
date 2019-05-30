package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TemaActivity extends AppCompatActivity {

    private ImageView memoria;
    private ImageView percepcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema);

        memoria = findViewById(R.id.imv_memoria_tema);
        percepcion = findViewById(R.id.imv_percepcion_tema);

        memoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TemaActivity.this, MemoriaActivity.class));
            }
        });
    }
}
