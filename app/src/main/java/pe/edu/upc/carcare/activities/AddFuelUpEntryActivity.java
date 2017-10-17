package pe.edu.upc.carcare.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.carcare.CarCareApp;
import pe.edu.upc.carcare.R;
import pe.edu.upc.carcare.models.FuelUpEntry;

public class AddFuelUpEntryActivity extends AppCompatActivity {
    ANImageView logoANImageView;
    TextInputEditText costPerGallonTextInputEditText;
    TextInputEditText gallonsTextInputEditText;
    TextInputEditText odometerTextInputEditText;
    TextInputEditText descriptionTextInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel_up_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        logoANImageView = (ANImageView) findViewById(R.id.logoANImageView);
        costPerGallonTextInputEditText = (TextInputEditText) findViewById(R.id.costPerGallonTextInputEditText);
        gallonsTextInputEditText = (TextInputEditText) findViewById(R.id.gallonsTextInputEditText);
        odometerTextInputEditText = (TextInputEditText) findViewById(R.id.odometerTextInputEditText);
        descriptionTextInputEditText = (TextInputEditText) findViewById(R.id.descriptionTextInputEditText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FuelUpEntry entry = new FuelUpEntry(8.3, 11.5, new FuelType("Gas 90", "Gasoline 90 Octanes"), new Date(), "145100", "Sample 2");
                entry.setCostPerGallon(Double.parseDouble(costPerGallonTextInputEditText.getText().toString()))

                        .setGallons(Double.parseDouble(gallonsTextInputEditText.getText().toString()))
                        .setOdometer(odometerTextInputEditText.getText().toString())
                        .setDescription(descriptionTextInputEditText.getText().toString())
                        .setFuelType(CarCareApp.getInstance().getFuelTypes().get(0));
                CarCareApp.getInstance().addFuelUpEntry(entry);
                SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor e = preferences.edit();
                e.putString("last_gallons", entry.getGallonsAsString());
                finish();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
