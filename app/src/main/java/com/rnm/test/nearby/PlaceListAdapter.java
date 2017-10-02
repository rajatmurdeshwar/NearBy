package com.rnm.test.nearby;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.places.PlaceBuffer;

/**
 * Created by Mahe on 9/30/2017.
 */

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.PlaceViewHolder> {

    private Context mContext;
    private PlaceBuffer mPlaces;

    public PlaceListAdapter(Context context,PlaceBuffer places) {
        mContext =context;
        mPlaces = places;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_card,parent,false);
        return new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        String placeName = mPlaces.get(position).getName().toString();
        String placeAddress = mPlaces.get(position).getAddress().toString();
        holder.nameTextView.setText(placeName);
        holder.nameTextView.setText(placeAddress);

    }
    public void swapPlaces(PlaceBuffer newPlaces) {
        mPlaces = newPlaces;
        if (mPlaces != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if(mPlaces==null) return 0;
        return mPlaces.getCount();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView;
        TextView addressTextView;

        public PlaceViewHolder(View itemView)
        {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            addressTextView = (TextView) itemView.findViewById(R.id.address_text_view);
        }
    }
}
