package me.crossle.demo.surfacetexture.st;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MediaPlayerSurfaceStubActivity extends Activity {

	private static final String TAG = "MediaPlayerSurfaceStubActivity";

	protected Resources mResources;

	private VideoSurfaceView mVideoView = null;
	private IMediaPlayer mMediaPlayer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mResources = getResources();
		IjkMediaPlayer.loadLibrariesOnce(null);
		IjkMediaPlayer.native_profileBegin("libijkplayer.so");

		IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
		mMediaPlayer = ijkMediaPlayer;

		try {
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/AceBanna.4K.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one_1.avi");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/WatchCS.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/3602.mp4");
			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one1.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/StreamVR.avi");
		} catch (IOException e) {
			e.printStackTrace();
		}

		mVideoView = new VideoSurfaceView(this, mMediaPlayer);

        setContentView(mVideoView);

	}

	@Override
	protected void onResume() {
		super.onResume();
		mVideoView.onResume();
	}
}
