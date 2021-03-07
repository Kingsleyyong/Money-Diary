package com.madassignment.moneydiary.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.madassignment.moneydiary.R;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import com.madassignment.moneydiary.expense_record;
import java.util.List;

public class ExpenselistAdapter extends RecyclerView.Adapter<ExpenselistAdapter.ViewHolder>{
    private final int expenseLayout;
    private List<expense_record> expenseList;
    public ExpenselistAdapter(int layoutId){
            expenseLayout = layoutId;
        }

    public void setRecordList(List<expense_record> records) {
            expenseList = records;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return expenseList == null ? 0 : expenseList.size();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(
                    parent.getContext()).inflate(expenseLayout, parent, false);
            return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int
            listPosition) {
        TextView item = holder.item;
        item.setText(expenseList.get(listPosition).getDecs());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;

        ViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.expense_records_row);
        }
    }
}
