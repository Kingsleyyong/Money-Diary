package com.madassignment.moneydiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class incomeRecAdapter extends RecyclerView.Adapter<incomeRecAdapter.ViewHolder> {
    Context ctx;
    List<income> incomeList;

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.record_income_expense, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        ctx = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        incomeDAO dao = new incomeDAO(ctx);
        incomeList = dao.getAll();

        holder.date.setText(incomeList.get(position).getincomeDate());
        holder.desc.setText(incomeList.get(position).getincomeDesc());
        holder.cate.setText(incomeList.get(position).getincomeCate());
        holder.amt.setText(String.format("%.2f", incomeList.get(position).getincomeAmt()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dao.deleteOne(incomeList.get(position).getincomeID());
            }
        });

    }

    @Override
    public int getItemCount() {
        incomeDAO dao = new incomeDAO(ctx);
        return dao.totalNumber();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView date, desc, cate, amt;
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.editTextDateRecord);
            desc = itemView.findViewById(R.id.editTextDescRecord);
            cate = itemView.findViewById(R.id.editTextCategoryRecord);
            amt = itemView.findViewById(R.id.editTextAmountRecord);
            delete = itemView.findViewById(R.id.deleteBtn);

        }
    }
}
