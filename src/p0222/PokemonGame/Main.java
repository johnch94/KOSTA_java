package p0222.PokemonGame;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Menu m = new Menu();
    Scanner sc = new Scanner(System.in);
    m.select(sc);
    m.run(sc);
  }
}
