package ec.edu.tecnologicoloja.proyectos.ejerciciolatitudlong;

import android.location.Location;
import android.location.LocationListener;

import java.util.List;

public class MyPosicion implements LocationListener {

    public static double latitud, longitud;
    public static boolean statusGPS;
    public static Location coordenadas;

    @Override
    public void onLocationChanged(Location location) {
        latitud = location.getLatitude();
        longitud = location.getLongitude();
        coordenadas = location;
    }


    @Override
    public void onProviderEnabled(String provider) {
        statusGPS = true;
    }

    @Override
    public void onProviderDisabled(String provider) {
        statusGPS = false;
    }




}
