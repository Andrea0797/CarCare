package pe.edu.upc.carcare;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import java.util.List;

import pe.edu.upc.carcare.models.DataService;
import pe.edu.upc.carcare.models.FuelType;
import pe.edu.upc.carcare.models.FuelUpEntry;

/**
 * Created by alumnos on 4/25/17.
 */

public class CarCareApp extends Application {
    private static CarCareApp instance;
    private DataService service = new DataService();

    public CarCareApp() {
        super();
        instance = this;
    }

    public static CarCareApp getInstance() { return instance; }

    public List<FuelUpEntry> getFuelUpEntries() { return service.getFuelUpEntries(); }

    public List<FuelType> getFuelTypes() { return service.getFuelTypes(); }

    public boolean addFuelUpEntry(FuelUpEntry fuelUpEntry) {
        return service.addFuelUpEntry(fuelUpEntry);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
