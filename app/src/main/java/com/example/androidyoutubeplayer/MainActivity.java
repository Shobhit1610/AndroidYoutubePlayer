package com.example.androidyoutubeplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.ytp_1);
        youTubePlayerView.initialize(Configure.apikey,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b)
        {
            youTubePlayer.loadVideo(Configure.videokey);
            getYoutubePlayer();
        }
    }

    private YouTubePlayerView getYoutubePlayer()
    {
        return (YouTubePlayerView)findViewById(R.id.ytp_1);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
