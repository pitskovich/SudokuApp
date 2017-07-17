package util;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class SudokuGenerator
{
  private static int[] genCenter()
  {
    int[] arrayOfInt = new int[9];
    ArrayList localArrayList = new ArrayList();
    int i = 9;
    Random localRandom = new Random();
    for (int j = 1; j < 10; j++)
      localArrayList.add(Integer.valueOf(j));
    while (i > 0)
    {
      int k = localRandom.nextInt(i);
      arrayOfInt[(9 - i)] = ((Integer)localArrayList.remove(k)).intValue();
      i--;
    }
    return arrayOfInt;
  }

  public static int[][] generate()
  {
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 9;
    arrayOfInt1[1] = 9;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt1);
    int[][] arrayOfInt2 = new int[9][];
    int[] arrayOfInt3 = new int[9];
    arrayOfInt3[0] = 8;
    arrayOfInt3[1] = 6;
    arrayOfInt3[2] = 7;
    arrayOfInt3[3] = 2;
    arrayOfInt3[4] = 0;
    arrayOfInt3[5] = 1;
    arrayOfInt3[6] = 5;
    arrayOfInt3[7] = 3;
    arrayOfInt3[8] = 4;
    arrayOfInt2[0] = arrayOfInt3;
    int[] arrayOfInt4 = new int[9];
    arrayOfInt4[0] = 2;
    arrayOfInt4[1] = 0;
    arrayOfInt4[2] = 1;
    arrayOfInt4[3] = 5;
    arrayOfInt4[4] = 3;
    arrayOfInt4[5] = 4;
    arrayOfInt4[6] = 8;
    arrayOfInt4[7] = 6;
    arrayOfInt4[8] = 7;
    arrayOfInt2[1] = arrayOfInt4;
    int[] arrayOfInt5 = new int[9];
    arrayOfInt5[0] = 5;
    arrayOfInt5[1] = 3;
    arrayOfInt5[2] = 4;
    arrayOfInt5[3] = 8;
    arrayOfInt5[4] = 6;
    arrayOfInt5[5] = 7;
    arrayOfInt5[6] = 2;
    arrayOfInt5[7] = 0;
    arrayOfInt5[8] = 1;
    arrayOfInt2[2] = arrayOfInt5;
    int[] arrayOfInt6 = new int[9];
    arrayOfInt6[0] = 6;
    arrayOfInt6[1] = 7;
    arrayOfInt6[2] = 8;
    arrayOfInt6[3] = 0;
    arrayOfInt6[4] = 1;
    arrayOfInt6[5] = 2;
    arrayOfInt6[6] = 3;
    arrayOfInt6[7] = 4;
    arrayOfInt6[8] = 5;
    arrayOfInt2[3] = arrayOfInt6;
    int[] arrayOfInt7 = new int[9];
    arrayOfInt7[0] = 0;
    arrayOfInt7[1] = 1;
    arrayOfInt7[2] = 2;
    arrayOfInt7[3] = 3;
    arrayOfInt7[4] = 4;
    arrayOfInt7[5] = 5;
    arrayOfInt7[6] = 6;
    arrayOfInt7[7] = 7;
    arrayOfInt7[8] = 8;
    arrayOfInt2[4] = arrayOfInt7;
    int[] arrayOfInt8 = new int[9];
    arrayOfInt8[0] = 3;
    arrayOfInt8[1] = 4;
    arrayOfInt8[2] = 5;
    arrayOfInt8[3] = 6;
    arrayOfInt8[4] = 7;
    arrayOfInt8[5] = 8;
    arrayOfInt8[6] = 0;
    arrayOfInt8[7] = 1;
    arrayOfInt8[8] = 2;
    arrayOfInt2[5] = arrayOfInt8;
    int[] arrayOfInt9 = new int[9];
    arrayOfInt9[0] = 7;
    arrayOfInt9[1] = 8;
    arrayOfInt9[2] = 6;
    arrayOfInt9[3] = 1;
    arrayOfInt9[4] = 2;
    arrayOfInt9[5] = 0;
    arrayOfInt9[6] = 4;
    arrayOfInt9[7] = 5;
    arrayOfInt9[8] = 3;
    arrayOfInt2[6] = arrayOfInt9;
    int[] arrayOfInt10 = new int[9];
    arrayOfInt10[0] = 1;
    arrayOfInt10[1] = 2;
    arrayOfInt10[2] = 0;
    arrayOfInt10[3] = 4;
    arrayOfInt10[4] = 5;
    arrayOfInt10[5] = 3;
    arrayOfInt10[6] = 7;
    arrayOfInt10[7] = 8;
    arrayOfInt10[8] = 6;
    arrayOfInt2[7] = arrayOfInt10;
    int[] arrayOfInt11 = new int[9];
    arrayOfInt11[0] = 4;
    arrayOfInt11[1] = 5;
    arrayOfInt11[2] = 3;
    arrayOfInt11[3] = 7;
    arrayOfInt11[4] = 8;
    arrayOfInt11[5] = 6;
    arrayOfInt11[6] = 1;
    arrayOfInt11[7] = 2;
    arrayOfInt11[8] = 0;
    arrayOfInt2[8] = arrayOfInt11;
    int[] arrayOfInt12 = genCenter();
    for (int i = 0; i < 9; i++)
      for (int k = 0; k < 9; k++)
        arrayOfInt[i][k] = arrayOfInt12[arrayOfInt2[i][k]];
    Random localRandom = new Random();
    for (int j = 0; j < 3; j++)
    {
      swapCol(localRandom.nextInt(3) + j * 3, localRandom.nextInt(3) + j * 3, arrayOfInt);
      swapRow(localRandom.nextInt(3) + j * 3, localRandom.nextInt(3) + j * 3, arrayOfInt);
    }
    return arrayOfInt;
  }

  public static void print(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfInt.length; i++)
    {
      localStringBuilder.append(paramArrayOfInt[i]);
      localStringBuilder.append(" ");
    }
    System.out.println(localStringBuilder.toString());
  }

  public static void print(int[][] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      for (int k = 0; k < i; k++)
      {
        localStringBuilder.append(paramArrayOfInt[j][k]);
        localStringBuilder.append(" ");
      }
      System.out.println(localStringBuilder.toString());
    }
  }

  public static int[][] remove(int paramInt, int[][] paramArrayOfInt)
  {
    Random localRandom = new Random();
    for (int i = 0; i < paramInt; i++)
    {
      int j = localRandom.nextInt(81);
      paramArrayOfInt[(j / 9)][(j % 9)] = 0;
    }
    return paramArrayOfInt;
  }

  public static void swapCol(int paramInt1, int paramInt2, int[][] paramArrayOfInt)
  {
    if (paramInt1 == paramInt2);
    while (true)
    {
      return;
      for (int i = 0; i < 9; i++)
      {
        int j = paramArrayOfInt[paramInt1][i];
        paramArrayOfInt[paramInt1][i] = paramArrayOfInt[paramInt2][i];
        paramArrayOfInt[paramInt2][i] = j;
      }
    }
  }

  public static void swapRow(int paramInt1, int paramInt2, int[][] paramArrayOfInt)
  {
    if (paramInt1 == paramInt2);
    while (true)
    {
      return;
      for (int i = 0; i < 9; i++)
      {
        int j = paramArrayOfInt[i][paramInt1];
        paramArrayOfInt[i][paramInt1] = paramArrayOfInt[i][paramInt2];
        paramArrayOfInt[i][paramInt2] = j;
      }
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     util.SudokuGenerator
 * JD-Core Version:    0.6.0
 */