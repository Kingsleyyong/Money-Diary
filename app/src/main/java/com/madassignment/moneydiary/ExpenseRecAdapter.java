package com.madassignment.moneydiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseRecAdapter extends RecyclerView.Adapter<ExpenseRecAdapter.ViewHolder>{
    Context ctx;
    List<expense_record> expenseList;

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.record_income_expense, parent, false);

        ViewHolder viewHolder = new ExpenseRecAdapter.ViewHolder(view);
        ctx = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseRecAdapter.ViewHolder holder, int position) {
        Expense_record_dao dao = new Expense_record_dao(ctx);
        expenseList = dao.getAll();

        holder.date.setText(expenseList.get(position).getDate());
        holder.desc.setText(expenseList.get(position).getDecs());
        holder.cate.setText(expenseList.get(position).getCategory());

        holder.amt.setText(String.format("%.2f", expenseList.get(position).getPrice()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dao.deleteOne(expenseList.get(position).getExpense_id());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        Expense_record_dao dao = new Expense_record_dao(ctx);
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
