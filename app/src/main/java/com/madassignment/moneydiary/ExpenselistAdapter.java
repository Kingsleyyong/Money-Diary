package com.madassignment.moneydiary;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenselistAdapter extends RecyclerView.Adapter<ExpenselistAdapter.ViewHolder>{
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

        ViewHolder viewHolder = new ExpenselistAdapter.ViewHolder(view);
        ctx = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenselistAdapter.ViewHolder holder, int position) {
        Expense_record_dao dao = new Expense_record_dao(ctx);
        expenseList = dao.getAll();

        holder.date.setText(expenseList.get(position).getDate());
        holder.desc.setText(expenseList.get(position).getDecs());
        holder.cate.setText(expenseList.get(position).getCategory());
        holder.amt.setText(Double.toString(expenseList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        Expense_record_dao dao = new Expense_record_dao(ctx);
        return dao.totalNumber();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView date, desc, cate, amt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.editTextDateRecord);
            desc = itemView.findViewById(R.id.editTextDescRecord);
            cate = itemView.findViewById(R.id.editTextCategoryRecord);
            amt = itemView.findViewById(R.id.editTextAmountRecord);
        }
    }
}
