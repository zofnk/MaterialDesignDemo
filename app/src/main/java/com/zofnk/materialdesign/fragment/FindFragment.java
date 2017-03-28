package com.zofnk.materialdesign.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zofnk.materialdesign.R;
import com.zofnk.materialdesign.adapter.MainAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {


    public static FindFragment newInstance() {

        Bundle args = new Bundle();

        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FindFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(lm);
        MainAdapter mainAdapter = new MainAdapter(getContext());
        mRecyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListence(null);
        return view;
    }

}
