package com.game.edw.suduko;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.PrintStream;
import java.lang.reflect.Array;
import util.NextDrizzy;
import util.NextTheme;
import util.SudokuChecker;
import util.SudokuGenerator;
import view.ClockView;
import view.GameView;
import view.SudokuView;

public class MainActivity extends Activity
{
  private static int REMOVE_NUM = 60;
  private static int[][] answer;
  public static int currentDrizzy;
  public static int currentTheme;
  private static boolean initFlag = false;
  private static int[][] matr;
  public static boolean modeFlag;
  public static boolean musicFlag;
  public static boolean pauseFlag = false;
  private static int[][] type;
  private ClockView clockView;
  private TextView comText;
  MediaPlayer drizzy;
  private TextView gameText;
  private GameView gameView;
  private TextView modeText;
  private TextView musicText;
  private TextView skipText;
  private Button submitBt;
  private SudokuChecker sudokuChecker;
  private SudokuView sudokuView;
  private TextView themeText;
  private TextView titleText;

  static
  {
    modeFlag = false;
    musicFlag = false;
    currentDrizzy = 2131099664;
    currentTheme = Color.parseColor("WHITE");
  }

  private int[][] blankMatrix()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 9;
    arrayOfInt[1] = 9;
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt);
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        arrayOfInt1[i][j] = 0;
    return arrayOfInt1;
  }

  private int[][] initType(int[][] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 9;
    arrayOfInt[1] = 9;
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt);
    for (int i = 0; i < 9; i++)
    {
      int j = 0;
      if (j >= 9)
        continue;
      if (paramArrayOfInt[i][j] != 0)
        arrayOfInt1[i][j] = 1;
      while (true)
      {
        j++;
        break;
        arrayOfInt1[i][j] = 0;
      }
    }
    return arrayOfInt1;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    System.out.println("-----onCreate------");
    setContentView(2130968601);
    this.drizzy = MediaPlayer.create(this, 2131099664);
    this.drizzy.start();
    this.sudokuChecker = new SudokuChecker();
    this.sudokuView = ((SudokuView)findViewById(2131558490));
    this.titleText = ((TextView)findViewById(2131558484));
    this.gameText = ((TextView)findViewById(2131558482));
    this.modeText = ((TextView)findViewById(2131558483));
    this.clockView = ((ClockView)findViewById(2131558488));
    this.comText = ((EditText)findViewById(2131558491));
    this.submitBt = ((Button)findViewById(2131558492));
    this.musicText = ((TextView)findViewById(2131558485));
    this.skipText = ((TextView)findViewById(2131558486));
    this.themeText = ((TextView)findViewById(2131558489));
    if (!initFlag)
    {
      initFlag = true;
      System.out.println("initFlag:" + initFlag);
      answer = SudokuGenerator.generate();
      System.out.println("generate");
      matr = SudokuGenerator.remove(REMOVE_NUM, answer);
      type = initType(matr);
    }
    this.sudokuView.setMatr(matr, type);
    this.sudokuView.setOnTouchListener(new bvOnTouchLis(this));
    this.titleText.setOnTouchListener(new solveOnTouchLis(this));
    this.gameText.setOnTouchListener(new newGameOnTouchLis(this));
    this.modeText.setOnTouchListener(new modeOnTouchLis(this));
    this.clockView.setOnClickListener(new clkOnClickLis(this));
    this.musicText.setOnTouchListener(new musicOnTouchLis(this));
    this.skipText.setOnTouchListener(new skipOnTouchLis(this));
    this.themeText.setOnTouchListener(new themeOnTouchLis(this));
  }

  protected void onPause()
  {
    this.clockView.pause();
    this.drizzy.pause();
    super.onPause();
  }

  protected void onStop()
  {
    this.clockView.pause();
    this.drizzy.stop();
    super.onStop();
  }

  public void submit(View paramView)
  {
    Object localObject = "invalid command";
    String str1 = this.comText.getText().toString();
    if (str1.equalsIgnoreCase("restart"))
    {
      Animation localAnimation1 = AnimationUtils.loadAnimation(this, 2131034113);
      Animation localAnimation2 = AnimationUtils.loadAnimation(this, 2131034112);
      this.titleText.startAnimation(localAnimation2);
      this.gameText.startAnimation(localAnimation2);
      this.sudokuView.startAnimation(localAnimation1);
      answer = SudokuGenerator.generate();
      matr = SudokuGenerator.remove(REMOVE_NUM, answer);
      type = initType(matr);
      this.sudokuView.setMatr(matr, type);
      this.clockView.restart();
      localObject = "restart";
    }
    while (true)
    {
      Toast.makeText(this, (CharSequence)localObject, 1).show();
      this.comText.setText("");
      return;
      if ((str1.length() <= 2) || (!str1.substring(0, 2).equalsIgnoreCase("rm")))
        continue;
      String str2 = str1.substring(2, str1.length());
      try
      {
        int i = Integer.parseInt(str2);
        if ((i > 0) && (i < 81))
          REMOVE_NUM = i;
        String str3 = "set remove number " + i;
        localObject = str3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject = "wrong number formate";
      }
    }
  }

  class bvOnTouchLis
    implements View.OnTouchListener
  {
    Context context;

    public bvOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (MainActivity.pauseFlag)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2131034112);
        MainActivity.this.clockView.startAnimation(localAnimation);
      }
      while (true)
      {
        return true;
        switch (paramMotionEvent.getAction())
        {
        case 4:
        case 2:
        case 3:
        default:
          break;
        case 0:
          int i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          MainActivity.this.sudokuView.click(i, j);
          MainActivity.access$202(MainActivity.this.sudokuView.getMatr());
          MainActivity.access$302(MainActivity.this.sudokuView.getType());
          break;
        case 1:
          MainActivity.this.sudokuView.release();
        }
      }
    }
  }

  class clkOnClickLis
    implements View.OnClickListener
  {
    Context context;

    public clkOnClickLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public void onClick(View paramView)
    {
      if (!MainActivity.pauseFlag)
      {
        MainActivity.this.clockView.pause();
        MainActivity.pauseFlag = true;
      }
      while (true)
      {
        return;
        MainActivity.this.clockView.restart();
        MainActivity.pauseFlag = false;
      }
    }
  }

  class gamOnClickLis
    implements View.OnClickListener
  {
    Context context;

    public gamOnClickLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public void onClick(View paramView)
    {
      if (!MainActivity.pauseFlag)
      {
        MainActivity.this.gameView.pause();
        MainActivity.pauseFlag = true;
      }
      while (true)
      {
        return;
        MainActivity.this.gameView.restart();
        MainActivity.pauseFlag = false;
      }
    }
  }

  class modeOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.gameText.getTextColors();

    public modeOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      case 1:
      }
      while (true)
      {
        return true;
        if (MainActivity.modeFlag)
        {
          Animation localAnimation2 = AnimationUtils.loadAnimation(this.context, 2131034113);
          MainActivity.this.sudokuView.startAnimation(localAnimation2);
          MainActivity.access$502(SudokuGenerator.generate());
          MainActivity.access$202(SudokuGenerator.remove(MainActivity.REMOVE_NUM, MainActivity.answer));
          MainActivity.access$302(MainActivity.this.initType(MainActivity.matr));
          MainActivity.this.sudokuView.setMatr(MainActivity.matr, MainActivity.type);
          MainActivity.this.clockView.restart();
          MainActivity.modeFlag = false;
          continue;
        }
        Animation localAnimation1 = AnimationUtils.loadAnimation(this.context, 2131034113);
        MainActivity.this.sudokuView.startAnimation(localAnimation1);
        int[][] arrayOfInt = MainActivity.this.blankMatrix();
        MainActivity.access$302(MainActivity.this.initType(arrayOfInt));
        MainActivity.this.sudokuView.setMatr(arrayOfInt, MainActivity.type);
        MainActivity.this.clockView.restart();
        MainActivity.modeFlag = true;
        continue;
        MainActivity.this.gameText.setTextColor(this.orignColor);
        MainActivity.this.sudokuView.unCheck();
      }
    }
  }

  class musicOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.gameText.getTextColors();

    public musicOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (MainActivity.musicFlag)
      {
        MainActivity.this.drizzy.start();
        MainActivity.musicFlag = false;
      }
      while (true)
      {
        return true;
        MainActivity.this.drizzy.pause();
        MainActivity.musicFlag = true;
      }
    }
  }

  class newGameOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.gameText.getTextColors();

    public newGameOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      case 1:
      }
      while (true)
      {
        return true;
        if (!MainActivity.modeFlag)
        {
          Animation localAnimation2 = AnimationUtils.loadAnimation(this.context, 2131034113);
          MainActivity.this.sudokuView.startAnimation(localAnimation2);
          MainActivity.access$502(SudokuGenerator.generate());
          MainActivity.access$202(SudokuGenerator.remove(MainActivity.REMOVE_NUM, MainActivity.answer));
          MainActivity.access$302(MainActivity.this.initType(MainActivity.matr));
          MainActivity.this.sudokuView.setMatr(MainActivity.matr, MainActivity.type);
          MainActivity.this.clockView.restart();
          continue;
        }
        Animation localAnimation1 = AnimationUtils.loadAnimation(this.context, 2131034113);
        MainActivity.this.sudokuView.startAnimation(localAnimation1);
        int[][] arrayOfInt = MainActivity.this.blankMatrix();
        MainActivity.access$302(MainActivity.this.initType(arrayOfInt));
        MainActivity.this.sudokuView.setMatr(arrayOfInt, MainActivity.type);
        MainActivity.this.clockView.restart();
        continue;
        MainActivity.this.gameText.setTextColor(this.orignColor);
        MainActivity.this.sudokuView.unCheck();
      }
    }
  }

  class skipOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.gameText.getTextColors();

    public skipOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      MainActivity.this.drizzy.stop();
      MainActivity.currentDrizzy = NextDrizzy.getNextDrizzy(MainActivity.currentDrizzy);
      MainActivity.this.drizzy = MediaPlayer.create(MainActivity.this, MainActivity.currentDrizzy);
      MainActivity.this.drizzy.start();
      return true;
    }
  }

  class solveOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.titleText.getTextColors();

    public solveOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      case 1:
      }
      while (true)
      {
        return true;
        boolean bool = MainActivity.this.sudokuView.check();
        if (!MainActivity.modeFlag)
        {
          if (bool)
          {
            Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2131034113);
            MainActivity.this.titleText.setTextColor(-16711936);
            MainActivity.this.sudokuView.startAnimation(localAnimation);
            MainActivity.access$502(SudokuGenerator.generate());
            MainActivity.access$202(SudokuGenerator.remove(MainActivity.REMOVE_NUM, MainActivity.answer));
            MainActivity.access$302(MainActivity.this.initType(MainActivity.matr));
            MainActivity.this.sudokuView.setMatr(MainActivity.matr, MainActivity.type);
            MainActivity.this.clockView.restart();
            continue;
          }
          MainActivity.this.titleText.setTextColor(-65536);
          continue;
        }
        MainActivity.access$302(MainActivity.this.initType(MainActivity.matr));
        MainActivity.this.sudokuChecker.setBoard(MainActivity.matr);
        try
        {
          MainActivity.this.sudokuChecker.solvePuzzle(0, 0);
          label203: MainActivity.access$202(MainActivity.this.sudokuChecker.getBoard());
          MainActivity.this.sudokuView.setMatr(MainActivity.matr, MainActivity.type);
          continue;
          MainActivity.this.titleText.setTextColor(this.orignColor);
          MainActivity.this.sudokuView.unCheck();
        }
        catch (Exception localException)
        {
          break label203;
        }
      }
    }
  }

  class themeOnTouchLis
    implements View.OnTouchListener
  {
    Context context;
    ColorStateList orignColor = MainActivity.this.gameText.getTextColors();

    public themeOnTouchLis(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      MainActivity.currentTheme = NextTheme.getNextTheme(MainActivity.currentTheme);
      MainActivity.this.findViewById(2131558481).setBackgroundColor(MainActivity.currentTheme);
      return true;
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     com.game.edw.suduko.MainActivity
 * JD-Core Version:    0.6.0
 */