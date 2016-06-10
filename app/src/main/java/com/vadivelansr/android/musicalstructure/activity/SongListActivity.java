package com.vadivelansr.android.musicalstructure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.vadivelansr.android.musicalstructure.R;
import com.vadivelansr.android.musicalstructure.config.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SongListActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.button_action)
    Button buttonPlaySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getIntent() != null && !TextUtils.isEmpty(getIntent().getStringExtra(Constants.OPTION))){
            getSupportActionBar().setTitle(getIntent().getStringExtra(Constants.OPTION) + " - " + getString(R.string.song_list));
        }

        buttonPlaySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongListActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
