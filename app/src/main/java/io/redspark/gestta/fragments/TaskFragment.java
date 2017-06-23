package io.redspark.gestta.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.redspark.gestta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {

    private View mView;

    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_task, container, false);

        return mView;
    }

}
