package com.xodec.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcking.github.com.giraffeplayer2.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        videoView = findViewById(R.id.video_view);
        btn.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        if (view == btn){
            btn.setVisibility(View.GONE);
            videoView.setVideoPath("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4").getPlayer().start();
        }
    }
}
