package JDBC.Prod;

import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ProdMenu m = new ProdMenu();

    m.run(sc);
  }
}
