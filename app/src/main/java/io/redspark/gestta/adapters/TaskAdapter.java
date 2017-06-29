package io.redspark.gestta.adapters;

import android.support.annotation.IntegerRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.redspark.gestta.R;

/**
 * Created by weslleyneri on 29/06/15.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    public interface TaskAdapaterListener {
        void onItemClickListener(Integer position);
        void onIconClickListener(Integer position);
    }

    private List<String> mTasks;
    private TaskAdapaterListener mTaskAdapaterListener;

    public TaskAdapter(List<String> nTmTasks, TaskAdapaterListener mTaskAdapaterListener) {
        this.mTasks = nTmTasks;
        this.mTaskAdapaterListener = mTaskAdapaterListener;
    }

    public void clearTasks() {
        mTasks = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void changeTasks(List<String> taks) {
        mTasks = taks;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_task, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mTaskAdapaterListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String task = mTasks.get(position);
        holder.setTitle(task);;
        holder.setTitleColor(position % 2 != 0);
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public String getTask(Integer position) {
        return mTasks.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_task_icon) protected ImageView mImageViewIcon;
        @BindView(R.id.cell_task_label) protected TextView mTextViewTitle;

        private TaskAdapaterListener mTaskAdapaterListener;
        private Integer mPosition;

        public ViewHolder(View itemView, TaskAdapaterListener taskAdapaterListener) {
            super(itemView);
            this.mTaskAdapaterListener = taskAdapaterListener;
            ButterKnife.bind(this, itemView);
        }

        public void setPosition(Integer position) {
            mPosition = position;
        }

        public void setTitle(String title) {
            mTextViewTitle.setText(title);
        }

        public void setTitleColor(boolean isOdd) {
            if (isOdd) {
                mTextViewTitle.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.primaryButton));
            } else {
                mTextViewTitle.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.colorPrimary));
            }
        }

        @OnClick(R.id.cell_task_icon)
        protected void iconTapped() {
            if (mTaskAdapaterListener != null) {
                mTaskAdapaterListener.onIconClickListener(mPosition);
            }
        }

        @OnClick(R.id.cell_task)
        protected void itemTapped() {
            if (mTaskAdapaterListener != null) {
                mTaskAdapaterListener.onItemClickListener(mPosition);
            }
        }
    }
}
