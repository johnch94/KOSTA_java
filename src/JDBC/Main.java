package JDBC;

import JDBC.Board.BoardMenu;
import JDBC.Prod.ProdMenu;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ProdMenu p = new ProdMenu();
    Scanner sc = new Scanner(System.in);
    p.run(sc);
  }
}
