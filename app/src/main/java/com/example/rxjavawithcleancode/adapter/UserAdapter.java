package com.example.rxjavawithcleancode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavawithcleancode.R;
import com.example.rxjavawithcleancode.databinding.ItemUserBinding;
import com.example.rxjavawithcleancode.domain.model.User;
import com.example.rxjavawithcleancode.view.MainActivity;
import com.example.rxjavawithcleancode.vm.RowUserInfoVm;
import com.example.rxjavawithcleancode.vm.UserInfoVm;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;

    private UserInfoVm userInfoVm;
    private OnItemClickListener listener;

    public UserAdapter(List<User> users) {

        this.users = users;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new UserViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = users.get(holder.getAdapterPosition());
        holder.itemUserBinding.setVm(new UserInfoVm(currentUser));
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        } else {
            return 0;
        }
    }

    public void setUserList(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }
    public User getCurrentItemAt(int position) {
        return users.get(position);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding itemUserBinding;

        public UserViewHolder(@NonNull ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getCurrentItemAt(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}