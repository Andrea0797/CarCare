package pe.edu.upc.carcare.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumnos on 4/25/17.
 */

public class FuelType {
    private String name;
    private String description;

    public FuelType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FuelType() {
    }

    public String getName() {
        return name;
    }

    public FuelType setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FuelType setDescription(String description) {
        this.description = description;
        return this;
    }

    public static List<FuelType> from(String[] fuelTypeNames) {
        List<FuelType> fuelTypes = new ArrayList<>();
        for(int i = 0; i < fuelTypeNames.length; i++) {
            fuelTypes.add((new FuelType()).setName(fuelTypeNames[i]));
        };
        return fuelTypes;
    }

    public static List<FuelType> findAll() {
        return FuelType.from(new String[]{"Gas 90", "Gas 98"});
    }

    @Override
    public String toString() {
        return name;
    }
}
