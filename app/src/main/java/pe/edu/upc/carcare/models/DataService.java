package pe.edu.upc.carcare.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alumnos on 4/25/17.
 */

public class DataService {
    private List<FuelUpEntry> fuelUpEntries;
    private List<FuelType> fuelTypes;

    public DataService() {
        fuelTypes = FuelType.findAll();
        initData();
    }
    public void initData() {
        fuelUpEntries = new ArrayList<>();
        fuelUpEntries.add(new FuelUpEntry(8.5, 11, new FuelType("Gas 90", "Gasoline 90 Octanes"), new Date(), "145000", "Sample 1"));
        fuelUpEntries.add(new FuelUpEntry(8.3, 11.5, new FuelType("Gas 90", "Gasoline 90 Octanes"), new Date(), "145100", "Sample 2"));

    }

    public List<FuelUpEntry> getFuelUpEntries() {
        return fuelUpEntries;
    }

    public boolean addFuelUpEntry(FuelUpEntry fuelUpEntry) {
        fuelUpEntries.add(fuelUpEntry);
        return true;
    }

    public List<FuelType> getFuelTypes() {
        return this.fuelTypes;
    }

    public DataService setFuelTypes(List<FuelType> fuelTypes) {
        this.fuelTypes = fuelTypes;
        return this;
    }


}
