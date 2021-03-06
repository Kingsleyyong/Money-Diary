//package com.madassignment.moneydiary;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.annotation.NonNull;
//
//import com.madassignment.moneydiary.R;
//import com.madassignment.moneydiary.User;
//import com.madassignment.moneydiary.UserRepository;
//
//import java.util.List;
//
//public class UserListAdapter
//    extends RecyclerView.Adapter<UserListAdapter.ViewHolder>{
//
//    private final int userLayout;
//    private List<User> userList;
//
//    public UserListAdapter(int layoutID) {
//        userLayout = layoutID;
//    }
//
//    public void setUserList(List<User> users) {
//        userList = users;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList == null ? 0 : userList.size();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(
//                parent.getContext()).inflate(userLayout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final RecyclerView.ViewHolder holder)
//}
