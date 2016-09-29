package me.crossle.demo.surfacetexture.sv;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.LinearLayout;

import me.crossle.demo.surfacetexture.R;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class SurfaceViewActivity extends Activity {

	private SurfaceView mSurfaceView;
	private IjkMediaPlayer mMediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout linearLayout = new LinearLayout(this);
		mSurfaceView = new SurfaceView(this);
		linearLayout.addView(mSurfaceView, 1111, 1111);
		setContentView(linearLayout);
		mSurfaceView.getHolder().addCallback(new Callback() {

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				mMediaPlayer.release();
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				playback();
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void playback() {
		mMediaPlayer = new IjkMediaPlayer();
		try {
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/AceBanna.4K.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one_1.avi");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/WatchCS.mp4");
//			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/3602.mp4");
			mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Download/one1.mp4");

			mMediaPlayer.setDisplay(mSurfaceView.getHolder());
			mMediaPlayer.prepareAsync();
			mMediaPlayer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
