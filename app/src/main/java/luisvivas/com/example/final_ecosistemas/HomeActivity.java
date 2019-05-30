package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Observable;
import java.util.Observer;

public class HomeActivity extends AppCompatActivity implements Observer {

    private Comunicacion ref;
    private ImageButton tema;
    private ImageButton avance;
    private ImageButton logro;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ref = Comunicacion.getRef();
        ref.addObserver(this);


        tema = findViewById(R.id.btn_tema_home);

        avance= findViewById(R.id.btn_avance_home);
        logro= findViewById(R.id.btn_logro_home);

        tema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Tema.class);
                startActivity(i);
            }
        });


        avance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Avance.class);
                startActivity(i);
            }
        });

        logro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Logro.class);
                startActivity(i);
            }
        });


    }




    @Override
    public void update(Observable observable, Object o) {

    }
}
