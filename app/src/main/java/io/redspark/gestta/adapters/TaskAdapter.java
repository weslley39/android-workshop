package io.redspark.gestta.adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.redspark.gestta.R;

/**
 * Created by weslleyneri on 29/06/15.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<String> mTasks;

    public TaskAdapter(List<String> nTmTasks) {
        this.mTasks = nTmTasks;
    }

    public void changeTasks(List<String> taks) {
        mTasks = taks;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_task, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String task = mTasks.get(position);
        holder.setTitle(task);;
        holder.setTitleColor(position % 2 != 0);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_task_icon) protected ImageView mImageViewIcon;
        @BindView(R.id.cell_task_label) protected TextView mTextViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTitle(String title) {
            mTextViewTitle.setText(title);
        }

        public void setTitleColor(boolean isOdd) {
            if (isOdd) {
                mTextViewTitle.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.primaryButton));
            }
        }
    }
}
