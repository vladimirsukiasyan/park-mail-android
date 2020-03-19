package com.example.hw1.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hw1.R;

public class DetailFragment extends Fragment {
    public static String ARG_POSITION = "POSITION";
    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        Bundle args = getArguments();
        if (null != args) {
            position = args.getInt(ARG_POSITION);
        }
        if (null != savedInstanceState) {
            position = savedInstanceState.getInt(ARG_POSITION);
        }

        TextView textDetail = view.findViewById(R.id.textDetail);
        textDetail.setText(String.valueOf(position + 1));
        textDetail.setTextColor(position % 2 == 0 ? Color.RED : Color.BLUE);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(ARG_POSITION, position);
        super.onSaveInstanceState(outState);
    }
}
