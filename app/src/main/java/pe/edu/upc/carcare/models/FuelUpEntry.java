package pe.edu.upc.carcare.models;

import android.os.Bundle;

import java.util.Date;

import pe.edu.upc.carcare.network.ClearbitLogoApiService;


/**
 * Created by alumnos on 4/25/17.
 */

public class FuelUpEntry {
    private double gallons;
    private double costPerGallon;
    private FuelType fuelType;
    private Date createdAt;
    private String odometer;
    private String description;
    private String url;

    public FuelUpEntry(double v, double v1, FuelType fuelType, Date date, String s, String s1) {
    }

    public FuelUpEntry(String url, double gallons, double costPerGallon, FuelType fuelType, Date createdAt, String odometer, String description) {
        this.url = url;
        this.gallons = gallons;
        this.costPerGallon = costPerGallon;
        this.fuelType = fuelType;
        this.createdAt = createdAt;
        this.odometer = odometer;
        this.description = description;
    }

    public double getGallons() {
        return gallons;
    }

    public String getGallonsAsString() {
        return Double.toString(gallons);
    }

    public FuelUpEntry setGallons(double gallons) {
        this.gallons = gallons;
        return this;
    }

    public double getCostPerGallon() {
        return costPerGallon;
    }

    public FuelUpEntry setCostPerGallon(double costPerGallon) {
        this.costPerGallon = costPerGallon;
        return this;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public FuelUpEntry setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtAsString() {
        return null;
    }

    public FuelUpEntry setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getOdometer() {
        return odometer;
    }

    public FuelUpEntry setOdometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FuelUpEntry setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return gallons*costPerGallon;
    }

    public String getPriceAsString() {
        return Double.toString(getPrice());
    }

    public String getEntryContext() {

        return null;
    }


    public String getUrl() {
        return url;
    }

    public FuelUpEntry setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlToLogo()
    {
        return ClearbitLogoApiService.getUrlToLogo(url);
    }

    public static FuelUpEntry from(Bundle bundle)
    {
        FuelUpEntry source = new FuelUpEntry(8.3, 11.5, new FuelType("Gas 90", "Gasoline 90 Octanes"), new Date(), "145100", "Sample 2");
        return source.setUrl(bundle.getString("url"));
    }
}
