package com.example.hw1.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1.R;
import com.example.hw1.adapters.MyItemRecyclerViewAdapter;
import com.example.hw1.dummy.DummyContent;

public class ItemFragment extends Fragment {
    private static final String BUNDLE_COUNT = "items-count";

    private int mColumnCount = 3;
    private OnListFragmentInteractionListener mListener;
    private MyItemRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation  = getResources().getConfiguration().orientation;
        mColumnCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? 3 : 4;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        view.findViewById(R.id.fab).setOnClickListener((View itemView) -> {
            int position = DummyContent.createDummyItem();
            adapter.notifyItemInserted(position);
        });

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        Log.d("TAG", String.valueOf(mColumnCount));

        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(BUNDLE_COUNT) - DummyContent.ITEMS.size();
            for (int i = 0; i < count; ++i) {
                DummyContent.createDummyItem();
            }
        }

        adapter = new MyItemRecyclerViewAdapter(mListener, DummyContent.ITEMS);
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(int position);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(BUNDLE_COUNT, DummyContent.ITEMS.size());
        Log.d("TAG", "onSaveInstanceState() - " + DummyContent.ITEMS.size());
        super.onSaveInstanceState(outState);
    }
}
