package io.redspark.gestta.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.redspark.gestta.R;
import io.redspark.gestta.adapters.TaskAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter;

    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_task, container, false);

        setupRecycleView();
        loadData();

        return mRecyclerView;
    }

    private void setupRecycleView() {
        mTaskAdapter = new TaskAdapter(new ArrayList<String>());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mTaskAdapter);
    }

    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> newData = new ArrayList<String>();
                for(int index = 0; index < 300; index++) {
                    newData.add("Task: " + index);
                }

                mTaskAdapter.changeTasks(newData);
            }
        }, 1000);
    }

}
