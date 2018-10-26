package com.example.pallabi.pharmiz;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {

    private List<Medicine> mArrayList = new ArrayList<>();
    private List<Medicine> mFilteredList = new ArrayList<>();
    Context context;

    public DataAdapter(Context context,List<Medicine> mFilteredList) {
        this.mFilteredList = mFilteredList;
        mArrayList = mFilteredList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_rows,parent, false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText(mFilteredList.get(position).getName());
        holder.tv_version.setText(mFilteredList.get(position).getPrice());
        holder.tv_api_level.setText(mFilteredList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    mFilteredList = mArrayList;

                } else {

                    ArrayList<Medicine> filteredList = new ArrayList<>();
                    for (Medicine androidVersion : mArrayList) {
                        if (androidVersion.getName().toLowerCase().contains(charString))
                            filteredList.add(androidVersion);
                    }
                    mFilteredList = filteredList;
                }
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFilteredList = (ArrayList<Medicine>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_version,tv_api_level;
        Context context;
        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_version = itemView.findViewById(R.id.tv_price);
            tv_api_level = itemView.findViewById(R.id.tv_quantity);
        }
    }
}