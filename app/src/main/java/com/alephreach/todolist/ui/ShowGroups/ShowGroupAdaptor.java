package com.alephreach.todolist.ui.ShowGroups;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alephreach.todolist.R;
import com.alephreach.todolist.domain.Entities.Group;

import java.util.List;

public class ShowGroupAdaptor extends RecyclerView.Adapter<ShowGroupAdaptor.ViewHolder> {

    private List<Group> mGroupList;

    public void bindData(List<Group> groups) {
        mGroupList = groups;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Group group = mGroupList.get(position);
        holder.mTitle.setText(group.getGroupname());
    }

    @Override
    public int getItemCount() {
        if (mGroupList == null) {
            return 0;
        } else {
            return mGroupList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mPercentage;
        private TextView mDone;
        private TextView mUndone;
        private TextView mTaskAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.view_group_title);
            mPercentage = itemView.findViewById(R.id.view_group_percentage);
            mDone = itemView.findViewById(R.id.view_group_task_done);
            mUndone = itemView.findViewById(R.id.view_group_task_undone);
            mTaskAmount = itemView.findViewById(R.id.view_group_number_of_tasks);
        }
    }

}
