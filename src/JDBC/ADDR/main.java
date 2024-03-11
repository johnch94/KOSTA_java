package JDBC.ADDR;

import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    AddrMenu menu = new AddrMenu();
    Scanner sc = new Scanner(System.in);
    menu.run(sc);
    // 잘못된 번호 입력시 나올 출력기능 수정필요함.
  }
}
