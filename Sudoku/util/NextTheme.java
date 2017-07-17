package util;

import android.graphics.Color;

public class NextTheme
{
  public static int getNextTheme(int paramInt)
  {
    int i;
    if (paramInt == Color.parseColor("WHITE"))
      i = Color.parseColor("RED");
    while (true)
    {
      return i;
      if (paramInt == Color.parseColor("RED"))
      {
        i = Color.parseColor("YELLOW");
        continue;
      }
      if (paramInt == Color.parseColor("YELLOW"))
      {
        i = Color.parseColor("GREEN");
        continue;
      }
      if (paramInt == Color.parseColor("GREEN"))
      {
        i = Color.parseColor("CYAN");
        continue;
      }
      if (paramInt == Color.parseColor("CYAN"))
      {
        i = Color.parseColor("MAGENTA");
        continue;
      }
      if (paramInt == Color.parseColor("MAGENTA"))
      {
        i = Color.parseColor("WHITE");
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           C:\Users\Peter\Downloads\tools\classes-dex2jar.jar
 * Qualified Name:     util.NextTheme
 * JD-Core Version:    0.6.0
 */