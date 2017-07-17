package util;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service
  implements MediaPlayer.OnErrorListener
{
  private int length = 0;
  private final IBinder mBinder = new ServiceBinder();
  MediaPlayer mPlayer;

  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }

  public void onCreate()
  {
    super.onCreate();
    this.mPlayer = MediaPlayer.create(this, 2131099664);
    this.mPlayer.setOnErrorListener(this);
    if (this.mPlayer != null)
    {
      this.mPlayer.setLooping(true);
      this.mPlayer.setVolume(100.0F, 100.0F);
    }
    this.mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
      {
        onError(MusicService.this.mPlayer, paramInt1, paramInt2);
        return true;
      }
    });
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.mPlayer != null);
    try
    {
      this.mPlayer.stop();
      this.mPlayer.release();
      return;
    }
    finally
    {
      this.mPlayer = null;
    }
    throw localObject;
  }

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Toast.makeText(this, "music player failed", 0).show();
    if (this.mPlayer != null);
    try
    {
      this.mPlayer.stop();
      this.mPlayer.release();
      return false;
    }
    finally
    {
      this.mPlayer = null;
    }
    throw localObject;
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mPlayer.start();
    return 1;
  }

  public void pauseMusic()
  {
    if (this.mPlayer.isPlaying())
    {
      this.mPlayer.pause();
      this.length = this.mPlayer.getCurrentPosition();
    }
  }

  public void resumeMusic()
  {
    if (!this.mPlayer.isPlaying())
    {
      this.mPlayer.seekTo(this.length);
      this.mPlayer.start();
    }
  }

  public void stopMusic()
  {
    this.mPlayer.stop();
    this.mPlayer.release();
    this.mPlayer = null;
  }

  public class ServiceBinder extends Binder
  {
    public ServiceBinder()
    {
    }

    public MusicService getService()
    {
      return MusicService.this;
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     util.MusicService
 * JD-Core Version:    0.6.0
 */