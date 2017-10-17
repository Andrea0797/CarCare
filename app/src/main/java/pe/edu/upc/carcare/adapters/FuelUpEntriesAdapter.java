package pe.edu.upc.carcare.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.carcare.R;
import pe.edu.upc.carcare.models.FuelUpEntry;

/**
 * Created by alumnos on 4/25/17.
 */

public class  FuelUpEntriesAdapter extends RecyclerView.Adapter<FuelUpEntriesAdapter.ViewHolder> {
    private List<FuelUpEntry> fuelUpEntries;

    public FuelUpEntriesAdapter(List<FuelUpEntry> fuelUpEntries) {
        this.setFuelUpEntries(fuelUpEntries);
    }

    public FuelUpEntriesAdapter() {
    }

    @Override
    public FuelUpEntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_fuel_up_entry, parent, false));
    }

    @Override
    public void onBindViewHolder(FuelUpEntriesAdapter.ViewHolder holder, int position) {
        final FuelUpEntry fuelUpEntry = fuelUpEntries.get(position);
        holder.fuelTypeTextView.setText(fuelUpEntries.get(position).getFuelType().getName());
        holder.gallonsTextView.setText(fuelUpEntries.get(position).getGallonsAsString());
        holder.priceTextView.setText(fuelUpEntries.get(position).getPriceAsString());
        holder.entryContextTextView.setText(fuelUpEntries.get(position).getEntryContext());
        holder.logoANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setImageUrl(fuelUpEntries.get(position).getUrlToLogo());

    }

    @Override
    public int getItemCount() {
        return fuelUpEntries.size();
    }

    public List<FuelUpEntry> getFuelUpEntries() {
        return fuelUpEntries;
    }

    public void setFuelUpEntries(List<FuelUpEntry> fuelUpEntries) {
        this.fuelUpEntries = fuelUpEntries;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView fuelUpEntryCardView;
        TextView gallonsTextView;
        TextView fuelTypeTextView;
        TextView priceTextView;
        TextView entryContextTextView;
        ANImageView logoANImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            fuelUpEntryCardView = (CardView) itemView.findViewById(R.id.fuelUpEntryCardView);
            gallonsTextView = (TextView) itemView.findViewById(R.id.gallonsTextView);
            fuelTypeTextView = (TextView) itemView.findViewById(R.id.fuelTypeTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
            entryContextTextView = (TextView) itemView.findViewById(R.id.entryContextTextView);
            logoANImageView = (ANImageView) itemView.findViewById(R.id.logoANImageView);
        }
    }
}
