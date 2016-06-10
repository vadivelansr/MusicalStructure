package com.vadivelansr.android.musicalstructure.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vadivelansr.android.musicalstructure.R;
import com.vadivelansr.android.musicalstructure.config.Constants;
import com.vadivelansr.android.musicalstructure.fragment.MusicFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecentActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, MusicFragment.newInstance(Constants.RECENT));
        transaction.commit();
    }

}
