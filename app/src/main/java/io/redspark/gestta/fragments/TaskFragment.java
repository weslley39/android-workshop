package io.redspark.gestta.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.redspark.gestta.R;
import io.redspark.gestta.adapters.TaskAdapter;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment implements TaskAdapter.TaskAdapaterListener {

    private static final String TAG = TaskFragment.class.getSimpleName();

    @BindView(R.id.fragment_task_recycler_view) protected RecyclerView recyclerView;
    @BindView(R.id.fragment_task_swipe__refresh) protected SwipeRefreshLayout swipeRefreshLayout;

    protected  TaskAdapter mTaskAdapter;


    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this, view);

        setupRecycleView();
        setupRefreshLayout();
        loadData();

        return view;
    }

    private void setupRecycleView() {
        mTaskAdapter = new TaskAdapter(new ArrayList<String>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mTaskAdapter);
    }

    private void setupRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    private void loadData() {
        mTaskAdapter.clearTasks();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> newData = new ArrayList<String>();
                for(int index = 0; index < 300; index++) {
                    newData.add("Task: " + index);
                }

                mTaskAdapter.changeTasks(newData);
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public void onItemClickListener(Integer position) {
        Log.d(TAG, "Item Cliked: " + mTaskAdapter.getTask(position));
    }

    @Override
    public void onIconClickListener(Integer position) {
        Log.d(TAG, "Icon Cliked: " + mTaskAdapter.getTask(position));
    }
}
