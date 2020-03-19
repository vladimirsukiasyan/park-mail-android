package com.example.hw1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hw1.dummy.DummyContent;
import com.example.hw1.fragments.DetailFragment;
import com.example.hw1.fragments.ItemFragment;

public class MainActivity extends AppCompatActivity
        implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, ItemFragment.newInstance(3))
                    .commit();
        }

    }

    @Override
    public void onListFragmentInteraction(int position) {
        Log.d("DEBUG", "[MainActivity] Item" + position + "was clicked");

        Bundle args = new Bundle();
        args.putInt(DetailFragment.ARG_POSITION, position);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment )
                .addToBackStack(null)
                .commit();
    }
}
