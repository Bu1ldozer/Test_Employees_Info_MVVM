package com.halushchak.testemployeesinfo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.halushchak.testemployeesinfo.R;
import com.halushchak.testemployeesinfo.data.pojo.Employee;
import com.halushchak.testemployeesinfo.data.pojo.Specialty;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        List<Specialty> specialties = employee.getSpecialty();
        holder.textViewName.setText(employee.getFName());
        holder.textViewLastName.setText(employee.getLName());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < specialties.size(); i++) {
            if (i != specialties.size() - 1) {
                builder.append(specialties.get(i).getName()).append(", ");
            } else {
                builder.append(specialties.get(i).getName());
            }
        }
        holder.textViewSpecialty.setText(builder);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewLastName;
        private TextView textViewSpecialty;

        private EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewSpecialty = itemView.findViewById(R.id.textViewSpecialty);
        }
    }
}
