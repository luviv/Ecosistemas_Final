package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class Logro extends AppCompatActivity implements Observer {


    private Comunicacion ref;
    private Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logro);
        ref = Comunicacion.getRef();
        ref.addObserver(this);



        atras = findViewById(R.id.btn_atras_logro);


        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Logro.this, HomeActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
