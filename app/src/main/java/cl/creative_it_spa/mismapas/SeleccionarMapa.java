package cl.creative_it_spa.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionarMapa extends AppCompatActivity {

    ListView lista_lugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_mapa);


        lista_lugares=(ListView) findViewById(R.id.lista_lugares);

        ArrayList<String> listado= new ArrayList<>();
        listado.add("Isla de Pascua, Chile");
        listado.add("Valdivia, Chile");
        listado.add("Arica, Chile");
        listado.add("Punta Arenas, Chile");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,

                android.R.layout.simple_list_item_1, android.R.id.text1, listado);

        lista_lugares.setAdapter(adapter);

        lista_lugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int itemPosition     = position;
                double numero=-55.7684646468;
                Intent intent=new Intent(SeleccionarMapa.this, MapsActivity.class);

                switch (position){
                    case 0:
                        intent.putExtra("latitud", -27.144909062295284);
                        intent.putExtra("longitud", -109.42094223049321);
                        intent.putExtra("lugar", "Isla de Pascua");
                        break;

                    case 1:
                        intent.putExtra("latitud", -39.81171575979185);
                        intent.putExtra("longitud", -73.24779169109502);
                        intent.putExtra("lugar", "Valdivia");
                        break;

                    case 2:
                        intent.putExtra("latitud", -18.478029939332004);
                        intent.putExtra("longitud", -70.32196031358876);
                        intent.putExtra("lugar", "Arica");
                        break;

                    case 3:
                        intent.putExtra("latitud", -53.16746169874368);
                        intent.putExtra("longitud", -70.90949015167394);
                        intent.putExtra("lugar", "Punta Arenas");
                        break;
                }
                startActivity(intent);
            }
        });

    }
}
