package luisvivas.com.example.final_ecosistemas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Tema extends AppCompatActivity {
    private Comunicacion ref;
    private boolean MemoriaOpen;
    private boolean PerVisualOpen;
    private ImageView Memoria;
    private ImageView PerVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema);
        ref = Comunicacion.getRef();

        MemoriaOpen = ref.getContadorMem();
        PerVisualOpen = ref.getContadorPrv();


        Memoria = findViewById(R.id.imv_memoria_tema);
        PerVis = findViewById(R.id.imv_percepcion_tema);


        Memoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MemoriaOpen ==true) {
                    Intent i = new Intent(Tema.this, MemoriaActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Tema.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                }
            }
        });

        PerVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PerVisualOpen ==true) {
                    Intent i = new Intent(Tema.this, pervisual_activity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Tema.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Metodos para prohibir la entrada a los temas

        /*
        * onClick {
        * if(MemoriaOpen == false){
                    Toast.makeText(MainActivity.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                    }else{
                    Intent i = new Intent(Tema.this, MemoriaActivity.class);
                startActivity(i);
                    }

                    onClick {
        * if(PerVisualOpen == false){
                    Toast.makeText(MainActivity.this, "Este tema ha sido cerrado por el profesor", Toast.LENGTH_LONG).show();
                    }else{
                    Intent i = new Intent(Tema.this, MemoriaActivity.class);
                startActivity(i);
                    }

        *
        *
        *
        *
        *
        *
        * */

    }
}
