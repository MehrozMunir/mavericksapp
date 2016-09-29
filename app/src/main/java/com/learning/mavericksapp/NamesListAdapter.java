package com.learning.mavericksapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
import java.util.List;
 
public class NamesListAdapter extends RecyclerView.Adapter<NamesListAdapter.MyViewHolder> {
 
    private List<NameItem> namesList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
 
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
 
 
    public NamesListAdapter(List<NameItem> namesList) {
        this.namesList = namesList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.name_list_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NameItem nameItem = namesList.get(position);
        holder.name.setText(getFormattedName(nameItem.getFname(),nameItem.getLname()));
    }
 
    @Override
    public int getItemCount() {
        return namesList.size();
    }

    private String getFormattedName(String fname,String lname){
        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
        lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
        return lname+", "+fname;
    }
}
