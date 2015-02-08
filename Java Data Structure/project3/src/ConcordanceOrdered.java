//  Data Structures with Java, Second Edition
//  by John R. Hubbard
//  Copyright 2007 by McGraw-Hill

import java.io.*;
import java.util.*;

public class ConcordanceOrdered {
  private Map<String,String> map = new TreeMap<String,String>();
  
  public ConcordanceOrdered(String file) {
    int lineNumber = 0;
    try {
      Scanner input = new Scanner(new File(file));
      while (input.hasNextLine()) {
        String line = input.nextLine();
        ++lineNumber;
        StringTokenizer parser = new StringTokenizer(line,",.;:()-!?' ");
        while (parser.hasMoreTokens()) {
          String word = parser.nextToken().toUpperCase();
          String listing = map.get(word);
          if (listing == null) {
            listing = "" + lineNumber;
          } else {
            listing += ", " + lineNumber;
          }
          map.put(word,listing);
        }
      }
      input.close();
    } catch(IOException e) {
      System.out.println(e);
    }
  }
  
  public void write(String file) {
    try {
      PrintWriter output = new PrintWriter(file);
      for (Map.Entry<String,String> entry : map.entrySet()) {
        output.println(entry);
      }
      output.close();
    } catch(IOException e) {
      System.out.println(e);
    }
  }
}
