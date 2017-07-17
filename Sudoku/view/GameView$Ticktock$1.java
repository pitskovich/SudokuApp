package view;

import android.os.Handler;
import java.util.TimerTask;

class GameView$Ticktock$1 extends TimerTask
{
  public void run()
  {
    if (!GameView.access$100())
      GameView.access$002((1 + GameView.access$000()) % 7200);
    GameView.access$300().sendEmptyMessage(GameView.access$000());
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     view.GameView.Ticktock.1
 * JD-Core Version:    0.6.0
 */