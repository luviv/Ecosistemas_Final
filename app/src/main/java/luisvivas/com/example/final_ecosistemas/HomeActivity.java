package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    private ImageButton tema;
    private ImageButton avance;
    private ImageButton logro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tema = findViewById(R.id.btn_tema_home);
        avance = findViewById(R.id.btn_avance_home);
        logro = findViewById(R.id.btn_logro_home);

        tema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TemaActivity.class));
            }
        });
    }
}
