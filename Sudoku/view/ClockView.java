package view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Timer;

public class ClockView extends TextView
{
  private static Handler handler;
  private static boolean isPause;
  private static Thread tickThread;
  private static int time = 0;

  static
  {
    isPause = false;
    tickThread = null;
  }

  public ClockView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public ClockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public ClockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    if (isPause())
      setText("Paused");
    while (true)
    {
      handler = new Handler()
      {
        public void handleMessage(Message paramMessage)
        {
          ClockView.access$002(paramMessage.what);
          if (ClockView.isPause)
            ClockView.this.setText("Paused");
          while (true)
          {
            return;
            ClockView.this.update();
          }
        }
      };
      if (tickThread == null)
      {
        tickThread = new Thread(new Ticktock());
        tickThread.start();
      }
      return;
      setText("0:00:00");
    }
  }

  private void update()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = time % 60;
    int j = time % 3600 / 60;
    localStringBuilder.append(time / 3600);
    localStringBuilder.append(':');
    if (j < 10)
      localStringBuilder.append('0');
    localStringBuilder.append(j);
    localStringBuilder.append(':');
    if (i < 10)
      localStringBuilder.append('0');
    localStringBuilder.append(i);
    setText(localStringBuilder.toString());
    invalidate();
  }

  public boolean isPause()
  {
    return isPause;
  }

  public void pause()
  {
    isPause = true;
  }

  public void restart()
  {
    time = 0;
    isPause = false;
  }

  class Ticktock
    implements Runnable
  {
    Ticktock()
    {
    }

    public void run()
    {
      new Timer().schedule(new ClockView.Ticktock.1(this), 0L, 1000L);
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     view.ClockView
 * JD-Core Version:    0.6.0
 */