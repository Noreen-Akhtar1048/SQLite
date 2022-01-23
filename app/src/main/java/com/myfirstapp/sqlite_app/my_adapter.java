package com.myfirstapp.sqlite_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class my_adapter extends RecyclerView.Adapter<my_adapter.myviewholder>
{
    ArrayList<model> dataholder;

    public my_adapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.e_name.setText(dataholder.get(position).getName());
        holder.e_age.setText(dataholder.get(position).getAge());
        holder.e_salary.setText(dataholder.get(position).getSalary());
        holder.e_design.setText(dataholder.get(position).getDesignation());
        holder.e_bonus.setText(dataholder.get(position).getBonus());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder{

        TextView e_name,e_age,e_salary,e_design,e_bonus;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            e_name = (TextView)itemView.findViewById(R.id.E_Name);
            e_age = (TextView)itemView.findViewById(R.id.E_Age);
            e_salary = (TextView)itemView.findViewById(R.id.E_Salary);
            e_design = (TextView)itemView.findViewById(R.id.E_Designation);
            e_bonus = (TextView)itemView.findViewById(R.id.E_Bonus);
        }
    }
}
