//  Data Structures with Java, Second Edition
//  by John R. Hubbard
//  Copyright 2007 by McGraw-Hill

public class TestConcordance {
  public static final String PATH = "C:\\Users\\hzou101.INSTR\\workspace\\project3\\src\\";
  public static final String IN_FILE = "Shakespeare.txt";
  public static final String CNO = "CNO.txt";
  public static final String CO = "CO.txt";

  public static void main(String[] args) {
    ConcordanceNotOrdered c = new ConcordanceNotOrdered(PATH+IN_FILE);
    c.write(CNO);
    
    ConcordanceOrdered x = new ConcordanceOrdered(PATH+IN_FILE);
    x.write(CO);
  }
}
