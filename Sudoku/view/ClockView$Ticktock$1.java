package view;

import android.os.Handler;
import java.util.TimerTask;

class ClockView$Ticktock$1 extends TimerTask
{
  public void run()
  {
    if (!ClockView.access$100())
      ClockView.access$002((1 + ClockView.access$000()) % 7200);
    ClockView.access$300().sendEmptyMessage(ClockView.access$000());
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     view.ClockView.Ticktock.1
 * JD-Core Version:    0.6.0
 */