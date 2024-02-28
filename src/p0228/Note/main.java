package p0228.Note;

import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    NoteMenu menu = new NoteMenu();
    Scanner sc = new Scanner(System.in);
    menu.run(sc);
  }
}
