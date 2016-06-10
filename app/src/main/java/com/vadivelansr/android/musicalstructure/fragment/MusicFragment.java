package com.vadivelansr.android.musicalstructure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vadivelansr.android.musicalstructure.R;
import com.vadivelansr.android.musicalstructure.activity.PlayerActivity;
import com.vadivelansr.android.musicalstructure.activity.SongListActivity;
import com.vadivelansr.android.musicalstructure.config.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vadivelansr on 6/9/2016.
 */
public class MusicFragment extends Fragment {
    @Bind(R.id.text_description)
    TextView textDescription;
    @Bind(R.id.text_hurdles)
    TextView textHurdles;
    @Bind(R.id.text_solution)
    TextView textSolution;
    @Bind(R.id.button_action)
    Button buttonAction;
    private String mOption;

    public MusicFragment() {

    }

    public static MusicFragment newInstance(String paramOption) {
        MusicFragment planFragment = new MusicFragment();
        Bundle args = new Bundle();
        args.putString(Constants.OPTION, paramOption);
        planFragment.setArguments(args);
        return planFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOption = getArguments().getString(Constants.OPTION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this, rootView);
        setUpFragment(mOption);
        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (mOption.equalsIgnoreCase(Constants.SONGS) || mOption.equalsIgnoreCase(Constants.RECENT)) {
                    intent = new Intent(getActivity(), PlayerActivity.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(getActivity(), SongListActivity.class);
                    switch (mOption){
                        case Constants.ALBUMS:
                            intent.putExtra(Constants.OPTION, getString(R.string.albums));
                            break;
                        case Constants.ARTISTS:
                            intent.putExtra(Constants.OPTION, getString(R.string.artists));
                            break;
                        case Constants.PLAY_LISTS:
                            intent.putExtra(Constants.OPTION, getString(R.string.play_lists));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

    private void setUpFragment(String option) {
        switch (option) {
            case Constants.ALBUMS:
                setText(R.string.albums_description, R.string.hurdles_song_scan,
                        R.string.solution_song_scan, R.string.albums);
                break;
            case Constants.ARTISTS:
                setText(R.string.artists_description, R.string.hurdles_song_scan,
                        R.string.solution_song_scan, R.string.artists);
                break;
            case Constants.PLAY_LISTS:
                setText(R.string.play_lists_description, R.string.hurdles_play_list_details,
                        R.string.solution_play_list_details, R.string.play_lists);
                break;
            case Constants.SONGS:
                setText(R.string.songs_description, R.string.hurdles_song_scan,
                        R.string.solution_song_scan, R.string.songs);
                break;
            case Constants.RECENT:
                setText(R.string.recent_description, R.string.hurdles_recent_activity,
                        R.string.solution_recent_activity, R.string.recent_activity);
                break;
        }
    }

    private void setText(int desc, int hurdle, int solution, int option) {
        textDescription.setText(getString(desc));
        textHurdles.setText(getString(hurdle) + " " + getString(option));
        textSolution.setText(getString(solution));
        if (mOption.equalsIgnoreCase(Constants.RECENT))
            buttonAction.setText(getString(R.string.play_song));
        else
            buttonAction.setText(getString(R.string.open) + " " + getString(option));
    }
}
