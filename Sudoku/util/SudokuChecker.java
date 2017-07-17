package util;

import java.io.PrintStream;
import java.lang.reflect.Array;

public class SudokuChecker
{
  int[][] board;
  int boardSize = 9;

  public SudokuChecker()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 9;
    arrayOfInt[1] = 9;
    this.board = ((int[][])Array.newInstance(Integer.TYPE, arrayOfInt));
  }

  public static boolean[] checkBlock(int[][] paramArrayOfInt)
  {
    boolean[] arrayOfBoolean = new boolean[9];
    int i = 0;
    if (i < 9)
    {
      int j = 0;
      for (int k = 0; k < 9; k++)
        j += paramArrayOfInt[(3 * (i % 3) + k % 3)][(3 * (i / 3) + k / 3)];
      if (j == 45);
      for (int m = 1; ; m = 0)
      {
        arrayOfBoolean[i] = m;
        i++;
        break;
      }
    }
    return arrayOfBoolean;
  }

  private boolean checkBox(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 3 * (paramInt1 / 3);
    int j = 3 * (paramInt2 / 3);
    int k = 0;
    int n;
    if (k < this.boardSize / 3)
    {
      n = 0;
      label31: if (n < this.boardSize / 3)
        if (this.board[(i + k)][(j + n)] != paramInt3);
    }
    for (int m = 0; ; m = 1)
    {
      return m;
      n++;
      break label31;
      k++;
      break;
    }
  }

  public static boolean[] checkCol(int[][] paramArrayOfInt)
  {
    boolean[] arrayOfBoolean = new boolean[9];
    int i = 0;
    if (i < 9)
    {
      int j = 0;
      for (int k = 0; k < 9; k++)
        j += paramArrayOfInt[i][k];
      if (j == 45);
      for (int m = 1; ; m = 0)
      {
        arrayOfBoolean[i] = m;
        i++;
        break;
      }
    }
    return arrayOfBoolean;
  }

  private boolean checkCol2(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.boardSize)
      if (this.board[i][paramInt1] != paramInt2);
    for (int j = 0; ; j = 1)
    {
      return j;
      i++;
      break;
    }
  }

  public static boolean[] checkRow(int[][] paramArrayOfInt)
  {
    boolean[] arrayOfBoolean = new boolean[9];
    int i = 0;
    if (i < 9)
    {
      int j = 0;
      for (int k = 0; k < 9; k++)
        j += paramArrayOfInt[k][i];
      if (j == 45);
      for (int m = 1; ; m = 0)
      {
        arrayOfBoolean[i] = m;
        i++;
        break;
      }
    }
    return arrayOfBoolean;
  }

  private boolean checkRow2(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.boardSize)
      if (this.board[paramInt1][i] != paramInt2);
    for (int j = 0; ; j = 1)
    {
      return j;
      i++;
      break;
    }
  }

  public static boolean isCompleted(int[][] paramArrayOfInt)
  {
    int i = 0;
    int k;
    if (i < 9)
    {
      k = 0;
      label10: if (k < 9)
        if (paramArrayOfInt[i][k] != 0);
    }
    for (int j = 0; ; j = 1)
    {
      return j;
      k++;
      break label10;
      i++;
      break;
    }
  }

  public static void print(boolean[] paramArrayOfBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfBoolean.length; i++)
    {
      localStringBuilder.append(paramArrayOfBoolean[i]);
      localStringBuilder.append(" ");
    }
    System.out.println(localStringBuilder.toString());
  }

  public int[][] getBoard()
  {
    return this.board;
  }

  public void next(int paramInt1, int paramInt2)
    throws Exception
  {
    if (paramInt2 < -1 + this.boardSize)
      solvePuzzle(paramInt1, paramInt2 + 1);
    while (true)
    {
      return;
      solvePuzzle(paramInt1 + 1, 0);
    }
  }

  public void setBoard(int[][] paramArrayOfInt)
  {
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        this.board[i][j] = paramArrayOfInt[i][j];
  }

  public void solvePuzzle(int paramInt1, int paramInt2)
    throws Exception
  {
    if (paramInt1 > -1 + this.boardSize)
      throw new Exception();
    if (this.board[paramInt1][paramInt2] != 0)
      next(paramInt1, paramInt2);
    while (true)
    {
      return;
      for (int i = 1; i < 1 + this.boardSize; i++)
      {
        if ((!checkRow2(paramInt1, i)) || (!checkCol2(paramInt2, i)) || (!checkBox(paramInt1, paramInt2, i)))
          continue;
        this.board[paramInt1][paramInt2] = i;
        next(paramInt1, paramInt2);
      }
      this.board[paramInt1][paramInt2] = 0;
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     util.SudokuChecker
 * JD-Core Version:    0.6.0
 */