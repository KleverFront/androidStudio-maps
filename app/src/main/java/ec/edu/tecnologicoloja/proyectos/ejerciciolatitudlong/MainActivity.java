package ec.edu.tecnologicoloja.proyectos.ejerciciolatitudlong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txLatitud, txLongitud;
    Button btnUbicar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txLongitud = findViewById(R.id.tx_longitud);
        txLatitud = findViewById(R.id.tx_latitud);
        btnUbicar = findViewById(R.id.btn_ubicar);
        ObtenerPermisoGps();
    }
    public void ObtenerPermisoGps (){
        if (
                ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&  ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
        }
    }
    public void Ubicar(View v ){

        Toast.makeText(this," ", Toast.LENGTH_LONG).show();
        miPosicion();
    }

    public void miPosicion(){
        LocationManager objLocalition = null;
        LocationListener objLocListener;
        objLocalition = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objLocListener = new MyPosicion();

        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&  ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION}, 2000);
        }

        objLocalition.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,objLocListener);

        if (objLocalition.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if(MyPosicion.latitud != 0){
                double lat = MyPosicion.latitud;
                double lon = MyPosicion.longitud;
                txLatitud.setText(""+lat);
                txLongitud.setText(""+lon);
            }
        }
    }

}