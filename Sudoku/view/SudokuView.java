package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.io.PrintStream;
import java.lang.reflect.Array;
import util.SudokuChecker;

public class SudokuView extends View
{
  private static int[][] matr;
  private static int[][] type;
  private Paint Black;
  private Paint Blue;
  private Paint Red;
  private Paint black;
  private Paint gray;
  private Paint green;
  private int height = 50;
  private boolean indFlag = false;
  private boolean[] isBloMarked;
  private boolean[] isColMarked;
  private boolean[] isRowMarked;
  private int step;
  private int tiCol = -1;
  private int tiLin = -1;
  private int width = 50;
  private Paint yel;

  public SudokuView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public SudokuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public SudokuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 9;
    arrayOfInt1[1] = 9;
    matr = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 9;
    arrayOfInt2[1] = 9;
    type = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt2);
    this.isRowMarked = new boolean[9];
    this.isColMarked = new boolean[9];
    this.isBloMarked = new boolean[9];
    this.black = new Paint();
    this.black.setColor(-16777216);
    this.black.setStrokeWidth(3.0F);
    this.Black = new Paint();
    this.Black.setColor(-16777216);
    this.Black.setStrokeWidth(6.0F);
    this.green = new Paint();
    this.green.setColor(Color.parseColor("blue"));
    this.green.setTextSize(70.0F);
    this.gray = new Paint();
    this.gray.setColor(-7829368);
    this.gray.setTextSize(70.0F);
    this.Red = new Paint();
    this.Red.setColor(Color.parseColor("#FF3300"));
    this.Red.setStrokeWidth(6.0F);
    this.yel = new Paint();
    this.yel.setColor(Color.parseColor("#FFE7BA"));
    this.yel.setStrokeWidth(3.0F);
    this.Blue = new Paint();
    this.Blue.setColor(Color.parseColor("blue"));
    this.Blue.setTextSize(70.0F);
  }

  public boolean check()
  {
    int i = 1;
    boolean[] arrayOfBoolean1 = SudokuChecker.checkRow(matr);
    boolean[] arrayOfBoolean2 = SudokuChecker.checkCol(matr);
    boolean[] arrayOfBoolean3 = SudokuChecker.checkBlock(matr);
    int j = 0;
    if (j < 9)
    {
      this.isRowMarked[j] = arrayOfBoolean1[j];
      this.isColMarked[j] = arrayOfBoolean2[j];
      this.isBloMarked[j] = arrayOfBoolean3[j];
      if ((i != 0) && (arrayOfBoolean1[j] != 0) && (arrayOfBoolean2[j] != 0) && (arrayOfBoolean3[j] != 0));
      for (i = 1; ; i = 0)
      {
        j++;
        break;
      }
    }
    System.out.println("--ROW--");
    SudokuChecker.print(this.isRowMarked);
    System.out.println("--COL--");
    SudokuChecker.print(this.isColMarked);
    this.indFlag = SudokuChecker.isCompleted(matr);
    invalidate();
    return i;
  }

  public void click(int paramInt1, int paramInt2)
  {
    int i = paramInt1 / this.step;
    int j = paramInt2 / this.step;
    this.tiLin = j;
    this.tiCol = i;
    if ((i < 9) && (j < 9))
      setVal(i, j, (1 + matr[i][j]) % 10);
  }

  public int[][] getMatr()
  {
    return matr;
  }

  public int[][] getType()
  {
    return type;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.height = getMeasuredHeight();
    this.width = getMeasuredWidth();
    this.height = this.width;
    setMinimumHeight(this.width);
    if (this.tiLin != -1)
    {
      Rect localRect1 = new Rect();
      localRect1.set(0, this.tiLin * this.step, -5 + this.width, (1 + this.tiLin) * this.step);
      paramCanvas.drawRect(localRect1, this.yel);
      Rect localRect2 = new Rect();
      localRect2.set(this.tiCol * this.step, 0, (1 + this.tiCol) * this.step, -5 + this.width);
      paramCanvas.drawRect(localRect2, this.yel);
    }
    this.step = (this.width / 9);
    int i = 0;
    if (i < 10)
    {
      if (i % 3 == 0)
      {
        paramCanvas.drawLine(i * this.step, 0.0F, i * this.step, this.width, this.Black);
        paramCanvas.drawLine(0.0F, i * this.step, this.width, i * this.step, this.Black);
      }
      while (true)
      {
        i++;
        break;
        paramCanvas.drawLine(i * this.step, 0.0F, i * this.step, this.width, this.black);
        paramCanvas.drawLine(0.0F, i * this.step, this.width, i * this.step, this.black);
      }
    }
    if (this.indFlag)
      for (int m = 0; m < 9; m++)
      {
        if (this.isColMarked[m] == 0)
          paramCanvas.drawLine(4.0F, m * this.step, 4.0F, (m + 1) * this.step, this.Red);
        if (this.isRowMarked[m] == 0)
          paramCanvas.drawLine(m * this.step, 4.0F, (m + 1) * this.step, 4.0F, this.Red);
        if (this.isBloMarked[m] != 0)
          continue;
        Rect localRect3 = new Rect();
        int n = m % 3;
        int i1 = m / 3;
        localRect3.set(n * 3 * this.step + this.step / 2, i1 * 3 * this.step + this.step / 2, 3 * (n + 1) * this.step - this.step / 2, 3 * (i1 + 1) * this.step - this.step / 2);
        paramCanvas.drawRect(localRect3, this.Red);
      }
    for (int j = 0; j < 9; j++)
    {
      int k = 0;
      if (k >= 9)
        continue;
      if (matr[j][k] == 0);
      while (true)
      {
        k++;
        break;
        String str = String.valueOf(matr[j][k]);
        if (type[j][k] == 0)
        {
          paramCanvas.drawText(str, j * this.step + this.step / 5, k * this.step + 4 * this.step / 5, this.green);
          continue;
        }
        paramCanvas.drawText(str, j * this.step + this.step / 5, k * this.step + 4 * this.step / 5, this.gray);
      }
    }
  }

  public void release()
  {
    this.tiCol = -1;
    this.tiLin = -1;
    invalidate();
  }

  public void setMatr(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2)
  {
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
      {
        matr[i][j] = paramArrayOfInt1[i][j];
        System.out.println(paramArrayOfInt1[i][j]);
        type[i][j] = paramArrayOfInt2[i][j];
      }
    invalidate();
  }

  public void setVal(int paramInt1, int paramInt2, int paramInt3)
  {
    if (type[paramInt1][paramInt2] == 1);
    while (true)
    {
      return;
      matr[paramInt1][paramInt2] = paramInt3;
      invalidate();
    }
  }

  public void unCheck()
  {
    this.indFlag = false;
    invalidate();
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     view.SudokuView
 * JD-Core Version:    0.6.0
 */