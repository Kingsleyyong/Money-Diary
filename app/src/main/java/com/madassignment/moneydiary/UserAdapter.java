package com.madassignment.moneydiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> {

    private List<User> userList;
    private Context context;

    public UserAdapter() {
    }

    public void setData(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users,null));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        User user = userList.get(position);
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        holder.user.setText(username); //dk correct or not
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {
        TextView user;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.users_row);
        }
    }
}
